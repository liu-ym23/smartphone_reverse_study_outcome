package com.android.server.trust;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.admin.DevicePolicyManager;
import android.app.trust.ITrustListener;
import android.app.trust.ITrustManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricSourceType;
import android.hardware.biometrics.SensorProperties;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.location.ISignificantPlaceProvider;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.FrozenObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.security.KeyStoreAuthorization;
import android.service.trust.GrantTrustResult;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.Xml;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;
import com.android.internal.R;
import com.android.internal.content.PackageMonitor;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.policy.IDeviceLockedStateListener;
import com.android.internal.util.DumpUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockSettingsInternal;
import com.android.internal.widget.LockSettingsStateListener;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.pm.UserManagerInternal;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.Slogf;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class TrustManagerService extends SystemService {
    static final boolean DEBUG = false;
    private static final int MSG_CLEANUP_USER = 8;
    private static final int MSG_DISPATCH_UNLOCK_ATTEMPT = 3;
    private static final int MSG_DISPATCH_UNLOCK_LOCKOUT = 13;
    private static final int MSG_ENABLED_AGENTS_CHANGED = 4;
    private static final int MSG_FLUSH_TRUST_USUALLY_MANAGED = 10;
    private static final int MSG_KEYGUARD_SHOWING_CHANGED = 6;
    private static final int MSG_REFRESH_DEVICE_LOCKED_FOR_USER = 14;
    private static final int MSG_REFRESH_TRUSTABLE_TIMERS_AFTER_AUTH = 17;
    private static final int MSG_REGISTER_LISTENER = 1;
    private static final int MSG_SCHEDULE_TRUST_TIMEOUT = 15;
    private static final int MSG_START_USER = 7;
    private static final int MSG_STOP_USER = 12;
    private static final int MSG_SWITCH_USER = 9;
    private static final int MSG_UNLOCK_USER = 11;
    private static final int MSG_UNREGISTER_LISTENER = 2;
    private static final int MSG_USER_MAY_REQUEST_UNLOCK = 18;
    private static final int MSG_USER_REQUESTED_UNLOCK = 16;
    private static final String PERMISSION_PROVIDE_AGENT = "android.permission.PROVIDE_TRUST_AGENT";
    private static final String PRIV_NAMESPACE = "http://schemas.android.com/apk/prv/res/android";
    private static final String REFRESH_DEVICE_LOCKED_EXCEPT_USER = "except";
    private static final String TAG = "TrustManagerService";
    private static final long TRUSTABLE_IDLE_TIMEOUT_IN_MILLIS = 28800000;
    private static final long TRUSTABLE_TIMEOUT_IN_MILLIS = 86400000;
    private static final Intent TRUST_AGENT_INTENT = null;
    private static final String TRUST_TIMEOUT_ALARM_TAG = "TrustManagerService.trustTimeoutForUser";
    private static final long TRUST_TIMEOUT_IN_MILLIS = 14400000;
    private static final int TRUST_USUALLY_MANAGED_FLUSH_DELAY = 120000;
    private final ArraySet<AgentInfo> mActiveAgents;
    private final ActivityManager mActivityManager;
    private final Object mAlarmLock;
    private AlarmManager mAlarmManager;
    final TrustArchive mArchive;
    private final Context mContext;
    private int mCurrentUser;
    private final SparseBooleanArray mDeviceLockedForUser;
    private final RemoteCallbackList<IDeviceLockedStateListener> mDeviceLockedStateListeners;
    private FaceManager mFaceManager;
    private FingerprintManager mFingerprintManager;
    private final Handler mHandler;
    private final SparseArray<TrustableTimeoutAlarmListener> mIdleTrustableTimeoutAlarmListenerForUser;
    private volatile boolean mIsInSignificantPlace;
    private final KeyStoreAuthorization mKeyStoreAuthorization;
    private final SparseBooleanArray mLastActiveUnlockRunningState;
    private final LockPatternUtils mLockPatternUtils;
    private final LockSettingsInternal mLockSettings;
    private final LockSettingsStateListener mLockSettingsStateListener;
    final PackageMonitor mPackageMonitor;
    private final Receiver mReceiver;
    private final IBinder mService;
    private ServiceWatcher mSignificantPlaceServiceWatcher;
    private final StrongAuthTracker mStrongAuthTracker;
    private boolean mTrustAgentsCanRun;
    private final ArrayList<ITrustListener> mTrustListeners;
    private final ArrayMap<Integer, TrustedTimeoutAlarmListener> mTrustTimeoutAlarmListenerForUser;
    private final SparseBooleanArray mTrustUsuallyManagedForUser;
    private final SparseArray<TrustableTimeoutAlarmListener> mTrustableTimeoutAlarmListenerForUser;
    private final UserManager mUserManager;
    private UserManagerInternal mUserManagerInternal;
    private final SparseArray<TrustState> mUserTrustState;
    private final SparseBooleanArray mUsersUnlockedByBiometric;

    /* JADX INFO: renamed from: com.android.server.trust.TrustManagerService$3, reason: invalid class name */
    class AnonymousClass3 extends ITrustManager.Stub {
        final /* synthetic */ TrustManagerService this$0;

        public static /* synthetic */ void $r8$lambda$FufZRVneHKo76msBu1aL3VpkCFE(IBinder r0) {
            lambda$isInSignificantPlace$1(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$xWzvYkEjJNH0Pij-AIOBLE1gXT0, reason: not valid java name */
        public static /* synthetic */ void m8723$r8$lambda$xWzvYkEjJNH0PijAIOBLE1gXT0() {
            lambda$reportKeyguardShowingChanged$0();
        }

        /* JADX INFO: renamed from: -$$Nest$mdumpUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8724$$Nest$mdumpUser(AnonymousClass3 r0, PrintWriter r1, UserInfo r2, boolean r3) {
            r0.dumpUser(r1, r2, r3);
        }

        AnonymousClass3(TrustManagerService this$0) {
            this.this$0 = this$0;
        }

        public void reportUnlockAttempt(boolean r4, int r5) throws RemoteException {
            if (TrustManagerService.DEBUG == false) goto L5;
            Slogf.d(TrustManagerService.TAG, "reportUnlockAttempt(authenticated=%s, userId=%s)", new Object[]{Boolean.valueOf(r4), Integer.valueOf(r5)});
        L5:
            enforceReportPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(3, r4 ? 1 : 0, r5).sendToTarget();
        }

        public void reportUserRequestedUnlock(int r3, boolean r4) throws RemoteException {
            enforceReportPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(16, r3, r4 ? 1 : 0).sendToTarget();
        }

        public void reportUserMayRequestUnlock(int userId) throws RemoteException {
            enforceReportPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(18, userId, 0).sendToTarget();
        }

        public void reportUnlockLockout(int timeoutMs, int userId) throws RemoteException {
            enforceReportPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(13, timeoutMs, userId).sendToTarget();
        }

        public void reportEnabledTrustAgentsChanged(int userId) throws RemoteException {
            enforceReportPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(4, userId, 0).sendToTarget();
        }

        public void reportKeyguardShowingChanged() throws RemoteException {
            enforceReportPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).removeMessages(6);
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(6);
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).runWithScissors(new TrustManagerService$3$$ExternalSyntheticLambda0(), 0);
        }

        private static /* synthetic */ void lambda$reportKeyguardShowingChanged$0() {
        }

        public void registerTrustListener(ITrustListener trustListener) throws RemoteException {
            enforceListenerPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(1, trustListener).sendToTarget();
        }

        public void unregisterTrustListener(ITrustListener trustListener) throws RemoteException {
            enforceListenerPermission();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(2, trustListener).sendToTarget();
        }

        public boolean isDeviceLocked(int userId, int deviceId) throws RemoteException {
            if (deviceId == 0) goto L5;
            return false;
        L5:
            int userId2 = ActivityManager.handleIncomingUser(ITrustManager.Stub.getCallingPid(), ITrustManager.Stub.getCallingUid(), userId, false, true, "isDeviceLocked", null);
            long token = Binder.clearCallingIdentity();
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L7:
            if (TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isSeparateProfileChallengeEnabled(userId2) == true) goto L11;
            userId2 = TrustManagerService.m8720$$Nest$mresolveProfileParent(this.this$0, userId2);     // Catch: Throwable -> L9
        L11:
            boolean r0 = this.this$0.isDeviceLockedInner(userId2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return r0;
        }

        public boolean isDeviceSecure(int userId, int deviceId) throws RemoteException {
            if (deviceId == 0) goto L5;
            return false;
        L5:
            int userId2 = ActivityManager.handleIncomingUser(ITrustManager.Stub.getCallingPid(), ITrustManager.Stub.getCallingUid(), userId, false, true, "isDeviceSecure", null);
            long token = Binder.clearCallingIdentity();
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L7:
            if (TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isSeparateProfileChallengeEnabled(userId2) == true) goto L11;
            userId2 = TrustManagerService.m8720$$Nest$mresolveProfileParent(this.this$0, userId2);     // Catch: Throwable -> L9
        L11:
            boolean r0 = TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isSecure(userId2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return r0;
        }

        public boolean isInSignificantPlace() {
            super.isInSignificantPlace_enforcePermission();
            TrustManagerService.m8686$$Nest$fgetmSignificantPlaceServiceWatcher(this.this$0).runOnBinder(new TrustManagerService$3$$ExternalSyntheticLambda1());
            return TrustManagerService.m8684$$Nest$fgetmIsInSignificantPlace(this.this$0);
        }

        private static /* synthetic */ void lambda$isInSignificantPlace$1(IBinder binder) throws RemoteException {
            ISignificantPlaceProvider.Stub.asInterface(binder).onSignificantPlaceCheck();
        }

        public void registerDeviceLockedStateListener(IDeviceLockedStateListener listener, int deviceId) {
            super.registerDeviceLockedStateListener_enforcePermission();
            if (deviceId == 0) goto L5;
            return;
        L5:
            TrustManagerService.m8681$$Nest$fgetmDeviceLockedStateListeners(this.this$0).register(listener, Integer.valueOf(UserHandle.getUserId(Binder.getCallingUid())));
        }

        public void unregisterDeviceLockedStateListener(IDeviceLockedStateListener listener) {
            super.unregisterDeviceLockedStateListener_enforcePermission();
            TrustManagerService.m8681$$Nest$fgetmDeviceLockedStateListeners(this.this$0).unregister(listener);
        }

        private void enforceReportPermission() {
            TrustManagerService.m8678$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ACCESS_KEYGUARD_SECURE_STORAGE", "reporting trust events");
        }

        private void enforceListenerPermission() {
            TrustManagerService.m8678$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.TRUST_LISTENER", "register trust listener");
        }

        protected void dump(FileDescriptor fd, final PrintWriter fout, String[] args) {
            if (DumpUtils.checkDumpPermission(TrustManagerService.m8678$$Nest$fgetmContext(this.this$0), TrustManagerService.TAG, fout) == true) goto L6;
            return;
        L6:
            if (this.this$0.isSafeMode() == false) goto L10;
            fout.println("disabled because the system is in safe mode.");
            return;
        L10:
            if (TrustManagerService.m8688$$Nest$fgetmTrustAgentsCanRun(this.this$0) == true) goto L13;
            fout.println("disabled because the third-party apps can't run yet.");
            return;
        L13:
            final List<UserInfo> userInfos = TrustManagerService.m8692$$Nest$fgetmUserManager(this.this$0).getAliveUsers();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).runWithScissors(new AnonymousClass1(this, fout, userInfos), 1500);
        }

        private void dumpUser(PrintWriter fout, UserInfo user, boolean isCurrent) {
            fout.printf(" User \"%s\" (id=%d, flags=%#x)", new Object[]{user.name, Integer.valueOf(user.id), Integer.valueOf(user.flags)});
            if (user.supportsSwitchToByUser() == false) goto L5;
            if (isCurrent == false) goto L15;
            fout.print(" (current)");
        L15:
            fout.print(": trustState=" + TrustManagerService.m8708$$Nest$mgetUserTrustStateInner(this.this$0, user.id));
            fout.print(", trustManaged=" + dumpBool(TrustManagerService.m8699$$Nest$maggregateIsTrustManaged(this.this$0, user.id)));
            fout.print(", deviceLocked=" + dumpBool(this.this$0.isDeviceLockedInner(user.id)));
            fout.print(", isActiveUnlockRunning=" + dumpBool(TrustManagerService.m8698$$Nest$maggregateIsActiveUnlockRunning(this.this$0, user.id)));
            fout.print(", strongAuthRequired=" + dumpHex(TrustManagerService.m8687$$Nest$fgetmStrongAuthTracker(this.this$0).getStrongAuthForUser(user.id)));
            fout.println();
            fout.println("   Enabled agents:");
            ArraySet<String> simpleNames = new ArraySet();
            Iterator r2 = TrustManagerService.m8675$$Nest$fgetmActiveAgents(this.this$0).iterator();
            boolean duplicateSimpleNames = false;
        L16:
            boolean duplicateSimpleNames2 = r2.hasNext();
            if (duplicateSimpleNames2 == false) goto L31;
            AgentInfo info = (AgentInfo) r2.next();
            if (info.userId != user.id) goto L16;
            boolean trusted = info.agent.isTrusted();
            fout.print("    ");
            fout.println(info.component.flattenToShortString());
            fout.print("     bound=" + dumpBool(info.agent.isBound()));
            fout.print(", connected=" + dumpBool(info.agent.isConnected()));
            fout.print(", managingTrust=" + dumpBool(info.agent.isManagingTrust()));
            fout.print(", trusted=" + dumpBool(trusted));
            fout.println();
            if (trusted == false) goto L25;
            fout.println("      message=\"" + info.agent.getMessage() + "\"");
        L25:
            if (info.agent.isConnected() == true) goto L28;
            String restartTime = TrustArchive.formatDuration(info.agent.getScheduledRestartUptimeMillis() - SystemClock.uptimeMillis());
            fout.println("      restartScheduledAt=" + restartTime);
        L28:
            if (simpleNames.add(TrustArchive.getSimpleName(info.component)) == true) goto L16;
            duplicateSimpleNames = true;
            goto L16
        L31:
            fout.println("   Events:");
            this.this$0.mArchive.dump(fout, 50, user.id, "    ", duplicateSimpleNames);
            fout.println();
            return;
        L5:
            if (TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isProfileWithUnifiedChallenge(user.id) == false) goto L8;
            fout.print(" (profile with unified challenge)");
            boolean locked = this.this$0.isDeviceLockedInner(TrustManagerService.m8720$$Nest$mresolveProfileParent(this.this$0, user.id));
        L11:
            fout.println(": deviceLocked=" + dumpBool(locked));
            fout.println("   Trust agents disabled because switching to this user is not possible.");
            return;
        L8:
            if (TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isSeparateProfileChallengeEnabled(user.id) == false) goto L10;
            fout.print(" (profile with separate challenge)");
            locked = this.this$0.isDeviceLockedInner(user.id);
            goto L11
        L10:
            fout.println(" (user that cannot be switched to)");
            locked = this.this$0.isDeviceLockedInner(user.id);
            goto L11
        }

        private String dumpBool(boolean b) {
            if (b == false) goto L4;
            return "1";
        L4:
            return "0";
        }

        private String dumpHex(int i) {
            return "0x" + Integer.toHexString(i);
        }

        public void setDeviceLockedForUser(int userId, boolean locked) {
            enforceReportPermission();
            long identity = Binder.clearCallingIdentity();
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L4:
            if (TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isSeparateProfileChallengeEnabled(userId) == true) goto L6;
        L23:
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            if (TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0).isSecure(userId) == false) goto L23;
            SparseBooleanArray r2 = TrustManagerService.m8680$$Nest$fgetmDeviceLockedForUser(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r2);     // Catch: Throwable -> L15
            TrustManagerService.m8680$$Nest$fgetmDeviceLockedForUser(this.this$0).put(userId, locked);     // Catch: Throwable -> L20
            monitor-exit(r2);     // Catch: Throwable -> L20
            TrustManagerService.m8714$$Nest$mnotifyKeystoreOfDeviceLockState(this.this$0, userId, locked);     // Catch: Throwable -> L15
            TrustManagerService.m8713$$Nest$mnotifyDeviceLockedListenersForUser(this.this$0, userId, locked);     // Catch: Throwable -> L15
            if (locked == true) goto L30;
        L18:
            Intent lockIntent = new Intent("android.intent.action.DEVICE_LOCKED_CHANGED");     // Catch: Throwable -> L15
            lockIntent.addFlags(1073741824);     // Catch: Throwable -> L15
            lockIntent.putExtra("android.intent.extra.user_handle", userId);     // Catch: Throwable -> L15
            TrustManagerService.m8678$$Nest$fgetmContext(this.this$0).sendBroadcastAsUser(lockIntent, UserHandle.SYSTEM, "android.permission.TRUST_LISTENER", null);     // Catch: Throwable -> L15
            goto L23
        L30:
            ActivityManager.getService().notifyLockedProfile(userId);     // Catch: Throwable -> L15 RemoteException -> L17
            goto L18
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        }

        public boolean isTrustUsuallyManaged(int userId) {
            super.isTrustUsuallyManaged_enforcePermission();
            long identity = Binder.clearCallingIdentity();
            boolean r2 = TrustManagerService.m8711$$Nest$misTrustUsuallyManagedInternal(this.this$0, userId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unlockedByBiometricForUser(int r5, BiometricSourceType r6) {
            enforceReportPermission();
            SparseBooleanArray r0 = TrustManagerService.m8694$$Nest$fgetmUsersUnlockedByBiometric(this.this$0);
            monitor-enter(r0);
            TrustManagerService.m8694$$Nest$fgetmUsersUnlockedByBiometric(this.this$0).put(r5, true);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            int r1 = !TrustManagerService.m8710$$Nest$misAutomotive(this.this$0) ? 1 : 0;
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(14, r5, r1).sendToTarget();
            TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(17, Integer.valueOf(r5)).sendToTarget();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void clearAllBiometricRecognized(BiometricSourceType biometricSource, int unlockedUser) {
            enforceReportPermission();
            SparseBooleanArray r0 = TrustManagerService.m8694$$Nest$fgetmUsersUnlockedByBiometric(this.this$0);
            monitor-enter(r0);
            TrustManagerService.m8694$$Nest$fgetmUsersUnlockedByBiometric(this.this$0).clear();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            Message message = TrustManagerService.m8682$$Nest$fgetmHandler(this.this$0).obtainMessage(14, -1, 0);
            if (unlockedUser < 0) goto L9;
            Bundle bundle = new Bundle();
            bundle.putInt(TrustManagerService.REFRESH_DEVICE_LOCKED_EXCEPT_USER, unlockedUser);
            message.setData(bundle);
        L9:
            message.sendToTarget();
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean isActiveUnlockRunning(int userId) throws RemoteException {
            long identity = Binder.clearCallingIdentity();
            boolean r2 = TrustManagerService.m8698$$Nest$maggregateIsActiveUnlockRunning(this.this$0, userId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static final class AgentInfo {
        TrustAgentWrapper agent;
        ComponentName component;
        Drawable icon;
        CharSequence label;
        SettingsAttrs settings;
        int userId;

        /* synthetic */ AgentInfo(TrustManagerServiceIA r1) {
            this();
        }

        private AgentInfo() {
        }

        public boolean equals(Object other) {
            if ((other instanceof AgentInfo) == true) goto L5;
            return false;
        L5:
            AgentInfo o = (AgentInfo) other;
            if (this.component.equals(o.component) == true) goto L8;
            return false;
        L8:
            if (this.userId != o.userId) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this.component.hashCode() * 31) + this.userId;
        }

        public String toString() {
            return String.format("AgentInfo{label=%s, component=%s, userId=%s}", new Object[]{this.label, this.component, Integer.valueOf(this.userId)});
        }
    }

    protected static class Injector {
        private final Context mContext;

        public Injector(Context context) {
            this.mContext = context;
        }

        LockPatternUtils getLockPatternUtils() {
            return new LockPatternUtils(this.mContext);
        }

        KeyStoreAuthorization getKeyStoreAuthorization() {
            return KeyStoreAuthorization.getInstance();
        }

        AlarmManager getAlarmManager() {
            return (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        }

        Looper getLooper() {
            return Looper.myLooper();
        }
    }

    private class Receiver extends BroadcastReceiver {
        final /* synthetic */ TrustManagerService this$0;

        /* synthetic */ Receiver(TrustManagerService r1, TrustManagerServiceIA r2) {
            this(r1);
        }

        private Receiver(TrustManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED".equals(action) == false) goto L6;
            this.this$0.refreshAgentList(getSendingUserId());
            this.this$0.updateDevicePolicyFeatures();
            return;
        L6:
            if ("android.intent.action.USER_ADDED".equals(action) == false) goto L8;
        L37:
            int userId = getUserId(intent);
            if (userId <= 0) goto L50;
            TrustManagerService.m8712$$Nest$mmaybeEnableFactoryTrustAgents(this.this$0, userId);
            return;
        L50:
            return;
        L8:
            if ("android.intent.action.USER_STARTED".equals(action) == true) goto L37;
            if ("android.intent.action.USER_REMOVED".equals(action) == false) goto L49;
            int userId2 = getUserId(intent);
            if (userId2 <= 0) goto L47;
            SparseBooleanArray r2 = TrustManagerService.m8680$$Nest$fgetmDeviceLockedForUser(this.this$0);
            monitor-enter(r2);
            TrustManagerService.m8680$$Nest$fgetmDeviceLockedForUser(this.this$0).delete(userId2);     // Catch: Throwable -> L33
            monitor-exit(r2);     // Catch: Throwable -> L33
            SparseBooleanArray r3 = TrustManagerService.m8690$$Nest$fgetmTrustUsuallyManagedForUser(this.this$0);
            monitor-enter(r3);
            TrustManagerService.m8690$$Nest$fgetmTrustUsuallyManagedForUser(this.this$0).delete(userId2);     // Catch: Throwable -> L30
            monitor-exit(r3);     // Catch: Throwable -> L30
            SparseBooleanArray r4 = TrustManagerService.m8694$$Nest$fgetmUsersUnlockedByBiometric(this.this$0);
            monitor-enter(r4);
            TrustManagerService.m8694$$Nest$fgetmUsersUnlockedByBiometric(this.this$0).delete(userId2);     // Catch: Throwable -> L27
            monitor-exit(r4);     // Catch: Throwable -> L27
            this.this$0.refreshAgentList(userId2);
            TrustManagerService.m8715$$Nest$mrefreshDeviceLockedForUser(this.this$0, userId2);
            return;
        L27:
            th = move-exception;
            throw th;
        L30:
            th = move-exception;
            throw th;
        L33:
            th = move-exception;
            throw th;
        L47:
            return;
        }

        private int getUserId(Intent intent) {
            int userId = intent.getIntExtra("android.intent.extra.user_handle", -100);
            if (userId <= 0) goto L5;
            return userId;
        L5:
            Log.w(TrustManagerService.TAG, "EXTRA_USER_HANDLE missing or invalid, value=" + userId);
            return -100;
        }

        public void register(Context context) {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED");
            filter.addAction("android.intent.action.USER_ADDED");
            filter.addAction("android.intent.action.USER_REMOVED");
            filter.addAction("android.intent.action.USER_STARTED");
            context.registerReceiverAsUser(this, UserHandle.ALL, filter, null, null);
        }
    }

    private static class SettingsAttrs {
        public boolean canUnlockProfile;
        public ComponentName componentName;

        public SettingsAttrs(ComponentName componentName, boolean canUnlockProfile) {
            this.componentName = componentName;
            this.canUnlockProfile = canUnlockProfile;
        }
    }

    private class StrongAuthTracker extends LockPatternUtils.StrongAuthTracker {
        SparseBooleanArray mStartFromSuccessfulUnlock;
        final /* synthetic */ TrustManagerService this$0;

        StrongAuthTracker(TrustManagerService r1, Context context, Looper looper) {
            this.this$0 = r1;
            super(context, looper);
            this.mStartFromSuccessfulUnlock = new SparseBooleanArray();
        }

        public void onStrongAuthRequiredChanged(int userId) {
            this.mStartFromSuccessfulUnlock.delete(userId);
            if (TrustManagerService.DEBUG == false) goto L6;
            Log.i(TrustManagerService.TAG, "onStrongAuthRequiredChanged(" + userId + ") -> trustAllowed=" + isTrustAllowedForUser(userId) + " agentsCanRun=" + canAgentsRunForUser(userId));
        L6:
            if (isTrustAllowedForUser(userId) == true) goto L8;
            TrustTimeoutAlarmListener alarm = (TrustTimeoutAlarmListener) TrustManagerService.m8689$$Nest$fgetmTrustTimeoutAlarmListenerForUser(this.this$0).get(Integer.valueOf(userId));
            cancelPendingAlarm(alarm);
            TrustTimeoutAlarmListener alarm2 = (TrustTimeoutAlarmListener) TrustManagerService.m8691$$Nest$fgetmTrustableTimeoutAlarmListenerForUser(this.this$0).get(userId);
            cancelPendingAlarm(alarm2);
            TrustTimeoutAlarmListener alarm3 = (TrustTimeoutAlarmListener) TrustManagerService.m8683$$Nest$fgetmIdleTrustableTimeoutAlarmListenerForUser(this.this$0).get(userId);
            cancelPendingAlarm(alarm3);
        L8:
            this.this$0.refreshAgentList(userId);
            this.this$0.updateTrust(userId, 0);
        }

        private void cancelPendingAlarm(TrustTimeoutAlarmListener alarm) {
            if (alarm != null) goto L4;
            return;
        L4:
            if (alarm.isQueued() == false) goto L8;
            alarm.setQueued(false);
            TrustManagerService.m8677$$Nest$fgetmAlarmManager(this.this$0).cancel(alarm);
            return;
        }

        boolean canAgentsRunForUser(int userId) {
            if (this.mStartFromSuccessfulUnlock.get(userId) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.isTrustAllowedForUser(userId) == true) goto L8;
            return false;
        }

        void allowTrustFromUnlock(int userId) {
            if (userId < 0) goto L11;
            boolean previous = canAgentsRunForUser(userId);
            this.mStartFromSuccessfulUnlock.put(userId, true);
            if (TrustManagerService.DEBUG == false) goto L7;
            Log.i(TrustManagerService.TAG, "allowTrustFromUnlock(" + userId + ") -> trustAllowed=" + isTrustAllowedForUser(userId) + " agentsCanRun=" + canAgentsRunForUser(userId));
        L7:
            if (canAgentsRunForUser(userId) == previous) goto L12;
            this.this$0.refreshAgentList(userId);
            return;
        L12:
            return;
        L11:
            throw new IllegalArgumentException("userId must be a valid user: " + userId);
        }
    }

    private static final enum TimeoutType extends Enum<TimeoutType> {
        private static final /* synthetic */ TimeoutType[] $VALUES = null;
        public static final TimeoutType TRUSTABLE = null;
        public static final TimeoutType TRUSTED = null;

        private static /* synthetic */ TimeoutType[] $values() {
            return new TimeoutType[]{TRUSTED, TRUSTABLE};
        }

        private TimeoutType(String r1, int r2) {
            super(r1, r2);
        }

        public static TimeoutType valueOf(String name) {
            return (TimeoutType) Enum.valueOf(TimeoutType.class, name);
        }

        public static TimeoutType[] values() {
            return (TimeoutType[]) $VALUES.clone();
        }

        static {
            TRUSTED = new TimeoutType("TRUSTED", 0);
            TRUSTABLE = new TimeoutType("TRUSTABLE", 1);
            $VALUES = $values();
        }
    }

    private static final enum TrustState extends Enum<TrustState> {
        private static final /* synthetic */ TrustState[] $VALUES = null;
        public static final TrustState TRUSTABLE = null;
        public static final TrustState TRUSTED = null;
        public static final TrustState UNTRUSTED = null;

        private static /* synthetic */ TrustState[] $values() {
            return new TrustState[]{UNTRUSTED, TRUSTABLE, TRUSTED};
        }

        private TrustState(String r1, int r2) {
            super(r1, r2);
        }

        public static TrustState valueOf(String name) {
            return (TrustState) Enum.valueOf(TrustState.class, name);
        }

        public static TrustState[] values() {
            return (TrustState[]) $VALUES.clone();
        }

        static {
            UNTRUSTED = new TrustState("UNTRUSTED", 0);
            TRUSTABLE = new TrustState("TRUSTABLE", 1);
            TRUSTED = new TrustState("TRUSTED", 2);
            $VALUES = $values();
        }
    }

    private abstract class TrustTimeoutAlarmListener implements AlarmManager.OnAlarmListener {
        protected boolean mIsQueued;
        protected final int mUserId;
        final /* synthetic */ TrustManagerService this$0;

        protected abstract void handleAlarm();

        TrustTimeoutAlarmListener(TrustManagerService r1, int userId) {
            this.this$0 = r1;
            this.mIsQueued = false;
            this.mUserId = userId;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            this.mIsQueued = false;
            handleAlarm();
            if (TrustManagerService.m8687$$Nest$fgetmStrongAuthTracker(this.this$0).isTrustAllowedForUser(this.mUserId) == true) goto L5;
            return;
        L5:
            if (TrustManagerService.DEBUG == false) goto L7;
            Slogf.d(TrustManagerService.TAG, "Revoking all trust because of trust timeout");
        L7:
            LockPatternUtils r0 = TrustManagerService.m8685$$Nest$fgetmLockPatternUtils(this.this$0);
            TrustManagerService.m8687$$Nest$fgetmStrongAuthTracker(this.this$0);
            r0.requireStrongAuth(256, this.mUserId);
        }

        public boolean isQueued() {
            return this.mIsQueued;
        }

        public void setQueued(boolean isQueued) {
            this.mIsQueued = isQueued;
        }
    }

    private class TrustableTimeoutAlarmListener extends TrustTimeoutAlarmListener {
        final /* synthetic */ TrustManagerService this$0;

        TrustableTimeoutAlarmListener(TrustManagerService r1, int userId) {
            this.this$0 = r1;
            super(r1, userId);
        }

        @Override // com.android.server.trust.TrustManagerService.TrustTimeoutAlarmListener
        public void handleAlarm() {
            TrustManagerService.m8700$$Nest$mcancelBothTrustableAlarms(this.this$0, this.mUserId);
            TrustedTimeoutAlarmListener otherAlarm = (TrustedTimeoutAlarmListener) TrustManagerService.m8689$$Nest$fgetmTrustTimeoutAlarmListenerForUser(this.this$0).get(Integer.valueOf(this.mUserId));
            if (otherAlarm != null) goto L5;
            return;
        L5:
            if (otherAlarm.isQueued() == false) goto L17;
            Object r1 = TrustManagerService.m8676$$Nest$fgetmAlarmLock(this.this$0);
            monitor-enter(r1);
            disableRenewableTrustWhileNonrenewableTrustIsPresent();     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void disableRenewableTrustWhileNonrenewableTrustIsPresent() {
            Iterator r0 = TrustManagerService.m8675$$Nest$fgetmActiveAgents(this.this$0).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            AgentInfo agentInfo = (AgentInfo) r0.next();
            agentInfo.agent.setUntrustable();
            goto L4
        L6:
            this.this$0.updateTrust(this.mUserId, 0);
        }
    }

    private class TrustedTimeoutAlarmListener extends TrustTimeoutAlarmListener {
        final /* synthetic */ TrustManagerService this$0;

        TrustedTimeoutAlarmListener(TrustManagerService r1, int userId) {
            this.this$0 = r1;
            super(r1, userId);
        }

        @Override // com.android.server.trust.TrustManagerService.TrustTimeoutAlarmListener
        public void handleAlarm() {
            TrustableTimeoutAlarmListener otherAlarm = (TrustableTimeoutAlarmListener) TrustManagerService.m8691$$Nest$fgetmTrustableTimeoutAlarmListenerForUser(this.this$0).get(this.mUserId);
            if (otherAlarm != null) goto L5;
            return;
        L5:
            if (otherAlarm.isQueued() == false) goto L17;
            Object r1 = TrustManagerService.m8676$$Nest$fgetmAlarmLock(this.this$0);
            monitor-enter(r1);
            disableNonrenewableTrustWhileRenewableTrustIsPresent();     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void disableNonrenewableTrustWhileRenewableTrustIsPresent() {
            SparseArray r0 = TrustManagerService.m8693$$Nest$fgetmUserTrustState(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (TrustManagerService.m8693$$Nest$fgetmUserTrustState(this.this$0).get(this.mUserId) != TrustState.TRUSTED) goto L9;
            TrustManagerService.m8693$$Nest$fgetmUserTrustState(this.this$0).put(this.mUserId, TrustState.TRUSTABLE);     // Catch: Throwable -> L7
            this.this$0.updateTrust(this.mUserId, 0);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$MQk3qplmAyKWhiT8C3-u_7Yqv_c, reason: not valid java name */
    public static /* synthetic */ void m8674$r8$lambda$MQk3qplmAyKWhiT8C3u_7Yqv_c(TrustManagerService r0, long r1, int r3) {
        r0.lambda$addEscrowToken$0(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$bWUIXovEmIWITBIyHMbcGejjBkM() {
        lambda$waitForIdle$1();
    }

    public static /* synthetic */ void $r8$lambda$x4xqpUlqmEqX100QYUq3PQViTyY(TrustManagerService r0, int r1, boolean r2, int r3) {
        r0.lambda$notifyDeviceLockedListenersForUser$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveAgents, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m8675$$Nest$fgetmActiveAgents(TrustManagerService r0) {
        return r0.mActiveAgents;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8676$$Nest$fgetmAlarmLock(TrustManagerService r0) {
        return r0.mAlarmLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlarmManager m8677$$Nest$fgetmAlarmManager(TrustManagerService r0) {
        return r0.mAlarmManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8678$$Nest$fgetmContext(TrustManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8679$$Nest$fgetmCurrentUser(TrustManagerService r0) {
        return r0.mCurrentUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceLockedForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m8680$$Nest$fgetmDeviceLockedForUser(TrustManagerService r0) {
        return r0.mDeviceLockedForUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceLockedStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m8681$$Nest$fgetmDeviceLockedStateListeners(TrustManagerService r0) {
        return r0.mDeviceLockedStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8682$$Nest$fgetmHandler(TrustManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleTrustableTimeoutAlarmListenerForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8683$$Nest$fgetmIdleTrustableTimeoutAlarmListenerForUser(TrustManagerService r0) {
        return r0.mIdleTrustableTimeoutAlarmListenerForUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsInSignificantPlace, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8684$$Nest$fgetmIsInSignificantPlace(TrustManagerService r0) {
        return r0.mIsInSignificantPlace;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockPatternUtils, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockPatternUtils m8685$$Nest$fgetmLockPatternUtils(TrustManagerService r0) {
        return r0.mLockPatternUtils;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSignificantPlaceServiceWatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceWatcher m8686$$Nest$fgetmSignificantPlaceServiceWatcher(TrustManagerService r0) {
        return r0.mSignificantPlaceServiceWatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStrongAuthTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ StrongAuthTracker m8687$$Nest$fgetmStrongAuthTracker(TrustManagerService r0) {
        return r0.mStrongAuthTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustAgentsCanRun, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8688$$Nest$fgetmTrustAgentsCanRun(TrustManagerService r0) {
        return r0.mTrustAgentsCanRun;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustTimeoutAlarmListenerForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m8689$$Nest$fgetmTrustTimeoutAlarmListenerForUser(TrustManagerService r0) {
        return r0.mTrustTimeoutAlarmListenerForUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustUsuallyManagedForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m8690$$Nest$fgetmTrustUsuallyManagedForUser(TrustManagerService r0) {
        return r0.mTrustUsuallyManagedForUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustableTimeoutAlarmListenerForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8691$$Nest$fgetmTrustableTimeoutAlarmListenerForUser(TrustManagerService r0) {
        return r0.mTrustableTimeoutAlarmListenerForUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m8692$$Nest$fgetmUserManager(TrustManagerService r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserTrustState, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8693$$Nest$fgetmUserTrustState(TrustManagerService r0) {
        return r0.mUserTrustState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsersUnlockedByBiometric, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m8694$$Nest$fgetmUsersUnlockedByBiometric(TrustManagerService r0) {
        return r0.mUsersUnlockedByBiometric;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8695$$Nest$fputmCurrentUser(TrustManagerService r0, int r1) {
        r0.mCurrentUser = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsInSignificantPlace, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8696$$Nest$fputmIsInSignificantPlace(TrustManagerService r0, boolean r1) {
        r0.mIsInSignificantPlace = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8697$$Nest$maddListener(TrustManagerService r0, ITrustListener r1) {
        r0.addListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maggregateIsActiveUnlockRunning, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8698$$Nest$maggregateIsActiveUnlockRunning(TrustManagerService r0, int r1) {
        return r0.aggregateIsActiveUnlockRunning(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maggregateIsTrustManaged, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8699$$Nest$maggregateIsTrustManaged(TrustManagerService r0, int r1) {
        return r0.aggregateIsTrustManaged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelBothTrustableAlarms, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8700$$Nest$mcancelBothTrustableAlarms(TrustManagerService r0, int r1) {
        r0.cancelBothTrustableAlarms(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckNewAgentsForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8701$$Nest$mcheckNewAgentsForUser(TrustManagerService r0, int r1) {
        r0.checkNewAgentsForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchOnEnabledTrustAgentsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8702$$Nest$mdispatchOnEnabledTrustAgentsChanged(TrustManagerService r0, int r1) {
        r0.dispatchOnEnabledTrustAgentsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchTrustableDowngrade, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8703$$Nest$mdispatchTrustableDowngrade(TrustManagerService r0) {
        r0.dispatchTrustableDowngrade();
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchUnlockAttempt, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8704$$Nest$mdispatchUnlockAttempt(TrustManagerService r0, boolean r1, int r2) {
        r0.dispatchUnlockAttempt(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchUnlockLockout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8705$$Nest$mdispatchUnlockLockout(TrustManagerService r0, int r1, int r2) {
        r0.dispatchUnlockLockout(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchUserMayRequestUnlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8706$$Nest$mdispatchUserMayRequestUnlock(TrustManagerService r0, int r1) {
        r0.dispatchUserMayRequestUnlock(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchUserRequestedUnlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8707$$Nest$mdispatchUserRequestedUnlock(TrustManagerService r0, int r1, boolean r2) {
        r0.dispatchUserRequestedUnlock(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserTrustStateInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ TrustState m8708$$Nest$mgetUserTrustStateInner(TrustManagerService r0, int r1) {
        return r0.getUserTrustStateInner(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScheduleTrustTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8709$$Nest$mhandleScheduleTrustTimeout(TrustManagerService r0, boolean r1, TimeoutType r2) {
        r0.handleScheduleTrustTimeout(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misAutomotive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8710$$Nest$misAutomotive(TrustManagerService r0) {
        return r0.isAutomotive();
    }

    /* JADX INFO: renamed from: -$$Nest$misTrustUsuallyManagedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8711$$Nest$misTrustUsuallyManagedInternal(TrustManagerService r0, int r1) {
        return r0.isTrustUsuallyManagedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeEnableFactoryTrustAgents, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8712$$Nest$mmaybeEnableFactoryTrustAgents(TrustManagerService r0, int r1) {
        r0.maybeEnableFactoryTrustAgents(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceLockedListenersForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8713$$Nest$mnotifyDeviceLockedListenersForUser(TrustManagerService r0, int r1, boolean r2) {
        r0.notifyDeviceLockedListenersForUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyKeystoreOfDeviceLockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8714$$Nest$mnotifyKeystoreOfDeviceLockState(TrustManagerService r0, int r1, boolean r2) {
        r0.notifyKeystoreOfDeviceLockState(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshDeviceLockedForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8715$$Nest$mrefreshDeviceLockedForUser(TrustManagerService r0, int r1) {
        r0.refreshDeviceLockedForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshDeviceLockedForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8716$$Nest$mrefreshDeviceLockedForUser(TrustManagerService r0, int r1, int r2) {
        r0.refreshDeviceLockedForUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshTrustableTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8717$$Nest$mrefreshTrustableTimers(TrustManagerService r0, int r1) {
        r0.refreshTrustableTimers(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAgentsOfPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8718$$Nest$mremoveAgentsOfPackage(TrustManagerService r0, String r1) {
        r0.removeAgentsOfPackage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8719$$Nest$mremoveListener(TrustManagerService r0, ITrustListener r1) {
        r0.removeListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolveProfileParent, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8720$$Nest$mresolveProfileParent(TrustManagerService r0, int r1) {
        return r0.resolveProfileParent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDeviceLockedForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8721$$Nest$msetDeviceLockedForUser(TrustManagerService r0, int r1, boolean r2) {
        r0.setDeviceLockedForUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTrust, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8722$$Nest$mupdateTrust(TrustManagerService r0, int r1, int r2, boolean r3, AndroidFuture r4) {
        r0.updateTrust(r1, r2, r3, r4);
    }

    static {
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        DEBUG = r0;
        TRUST_AGENT_INTENT = new Intent("android.service.trust.TrustAgentService");
        return;
    L5:
        if (Log.isLoggable(TAG, 2) == false) goto L7;
        r0 = true;
        goto L8
    }

    public TrustManagerService(Context context) {
        this(context, new Injector(context));
    }

    protected TrustManagerService(Context context, Injector injector) {
        super(context);
        this.mActiveAgents = new ArraySet();
        this.mLastActiveUnlockRunningState = new SparseBooleanArray();
        this.mTrustListeners = new ArrayList();
        this.mReceiver = new Receiver(this, null);
        this.mArchive = new TrustArchive();
        this.mUserTrustState = new SparseArray();
        this.mDeviceLockedForUser = new SparseBooleanArray();
        this.mTrustUsuallyManagedForUser = new SparseBooleanArray();
        this.mUsersUnlockedByBiometric = new SparseBooleanArray();
        this.mTrustTimeoutAlarmListenerForUser = new ArrayMap();
        this.mTrustableTimeoutAlarmListenerForUser = new SparseArray();
        this.mIdleTrustableTimeoutAlarmListenerForUser = new SparseArray();
        this.mDeviceLockedStateListeners = new RemoteCallbackList();
        this.mAlarmLock = new Object();
        this.mLockSettingsStateListener = new AnonymousClass1(this);
        this.mTrustAgentsCanRun = false;
        this.mCurrentUser = 0;
        this.mIsInSignificantPlace = false;
        this.mService = new AnonymousClass3(this);
        this.mPackageMonitor = new AnonymousClass5(this);
        this.mContext = context;
        this.mHandler = createHandler(injector.getLooper());
        this.mUserManager = (UserManager) this.mContext.getSystemService("user");
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        this.mLockSettings = (LockSettingsInternal) LocalServices.getService(LockSettingsInternal.class);
        this.mLockPatternUtils = injector.getLockPatternUtils();
        this.mKeyStoreAuthorization = injector.getKeyStoreAuthorization();
        this.mStrongAuthTracker = new StrongAuthTracker(this, context, injector.getLooper());
        this.mAlarmManager = injector.getAlarmManager();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("trust", this.mService);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (isSafeMode() == false) goto L6;
        return;
    L6:
        if (phase != 500) goto L9;
        checkNewAgents();
        this.mPackageMonitor.register(this.mContext, this.mHandler.getLooper(), UserHandle.ALL, true);
        this.mReceiver.register(this.mContext);
        this.mLockPatternUtils.registerStrongAuthTracker(this.mStrongAuthTracker);
        this.mFingerprintManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        this.mFaceManager = (FaceManager) this.mContext.getSystemService(FaceManager.class);
        return;
    L9:
        if (phase != 600) goto L12;
        this.mTrustAgentsCanRun = true;
        refreshAgentList(-1);
        refreshDeviceLockedForUser(-1);
        this.mSignificantPlaceServiceWatcher = ServiceWatcher.create(this.mContext, TAG, CurrentUserServiceSupplier.create(this.mContext, "com.android.trust.provider.SignificantPlaceProvider.BIND", null, null, null), new AnonymousClass2(this));
        this.mSignificantPlaceServiceWatcher.register();
        return;
    L12:
        if (phase != 1000) goto L17;
        maybeEnableFactoryTrustAgents(0);
        return;
    }

    private boolean isAutomotive() {
        return getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    private void scheduleTrustTimeout(boolean r5, boolean r6) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "scheduleTrustTimeout(override=%s, isTrustable=%s)", new Object[]{Boolean.valueOf(r5), Boolean.valueOf(r6)});
    L5:
        this.mHandler.obtainMessage(15, r5 ? 1 : 0, r6 ? 1 : 0).sendToTarget();
    }

    private void handleScheduleTrustTimeout(boolean shouldOverride, TimeoutType timeoutType) {
        int userId = this.mCurrentUser;
        if (DEBUG == false) goto L6;
        Slogf.d(TAG, "handleScheduleTrustTimeout(shouldOverride=%s, timeoutType=%s)", new Object[]{Boolean.valueOf(shouldOverride), timeoutType});
    L6:
        if (timeoutType != TimeoutType.TRUSTABLE) goto L8;
        handleScheduleTrustableTimeouts(userId, shouldOverride, false);
        return;
    L8:
        handleScheduleTrustedTimeout(userId, shouldOverride);
    }

    private void refreshTrustableTimers(int userId) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "refreshTrustableTimers(userId=%s)", new Object[]{Integer.valueOf(userId)});
    L5:
        handleScheduleTrustableTimeouts(userId, true, true);
    }

    private void cancelBothTrustableAlarms(int userId) {
        TrustableTimeoutAlarmListener idleTimeout = this.mIdleTrustableTimeoutAlarmListenerForUser.get(userId);
        TrustableTimeoutAlarmListener trustableTimeout = this.mTrustableTimeoutAlarmListenerForUser.get(userId);
        if (idleTimeout != null) goto L5;
    L7:
        if (trustableTimeout != null) goto L9;
        return;
    L9:
        if (trustableTimeout.isQueued() == false) goto L13;
        trustableTimeout.setQueued(false);
        this.mAlarmManager.cancel(trustableTimeout);
        return;
    L13:
        return;
    L5:
        if (idleTimeout.isQueued() == false) goto L7;
        idleTimeout.setQueued(false);
        this.mAlarmManager.cancel(idleTimeout);
        goto L7
    }

    private void handleScheduleTrustedTimeout(int userId, boolean shouldOverride) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "handleScheduleTrustedTimeout(userId=%s, shouldOverride=%s)", new Object[]{Integer.valueOf(userId), Boolean.valueOf(shouldOverride)});
    L5:
        long when = SystemClock.elapsedRealtime() + 14400000;
        TrustedTimeoutAlarmListener alarm = this.mTrustTimeoutAlarmListenerForUser.get(Integer.valueOf(userId));
        if (alarm == null) goto L15;
        if (shouldOverride == false) goto L9;
    L14:
        this.mAlarmManager.cancel(alarm);
        TrustedTimeoutAlarmListener alarm2 = alarm;
    L17:
        if (DEBUG == false) goto L19;
        Slogf.d(TAG, "\tSetting up trust timeout alarm triggering at elapsedRealTime=%s", new Object[]{Long.valueOf(when)});
    L19:
        alarm2.setQueued(true);
        this.mAlarmManager.setExact(2, when, TRUST_TIMEOUT_ALARM_TAG, alarm2, this.mHandler);
        return;
    L9:
        if (alarm.isQueued() == false) goto L14;
        if (DEBUG == false) goto L21;
        Slogf.d(TAG, "Found existing trust timeout alarm. Skipping.");
        return;
    L21:
        return;
    L15:
        TrustedTimeoutAlarmListener alarm3 = new TrustedTimeoutAlarmListener(this, userId);
        this.mTrustTimeoutAlarmListenerForUser.put(Integer.valueOf(userId), alarm3);
        alarm2 = alarm3;
        goto L17
    }

    private void handleScheduleTrustableTimeouts(int userId, boolean overrideIdleTimeout, boolean overrideHardTimeout) {
        setUpIdleTimeout(userId, overrideIdleTimeout);
        setUpHardTimeout(userId, overrideHardTimeout);
    }

    private void setUpIdleTimeout(int userId, boolean overrideIdleTimeout) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "setUpIdleTimeout(userId=%s, overrideIdleTimeout=%s)", new Object[]{Integer.valueOf(userId), Boolean.valueOf(overrideIdleTimeout)});
    L5:
        long when = SystemClock.elapsedRealtime() + TRUSTABLE_IDLE_TIMEOUT_IN_MILLIS;
        TrustableTimeoutAlarmListener alarm = this.mIdleTrustableTimeoutAlarmListenerForUser.get(userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.SCHEDULE_EXACT_ALARM", null);
        if (alarm == null) goto L15;
        if (overrideIdleTimeout == false) goto L9;
    L14:
        this.mAlarmManager.cancel(alarm);
        TrustableTimeoutAlarmListener alarm2 = alarm;
    L17:
        if (DEBUG == false) goto L19;
        Slogf.d(TAG, "\tSetting up trustable idle timeout alarm triggering at elapsedRealTime=%s", new Object[]{Long.valueOf(when)});
    L19:
        alarm2.setQueued(true);
        this.mAlarmManager.setExact(2, when, TRUST_TIMEOUT_ALARM_TAG, alarm2, this.mHandler);
        return;
    L9:
        if (alarm.isQueued() == false) goto L14;
        if (DEBUG == false) goto L21;
        Slogf.d(TAG, "Found existing trustable timeout alarm. Skipping.");
        return;
    L21:
        return;
    L15:
        TrustableTimeoutAlarmListener alarm3 = new TrustableTimeoutAlarmListener(this, userId);
        this.mIdleTrustableTimeoutAlarmListenerForUser.put(userId, alarm3);
        alarm2 = alarm3;
        goto L17
    }

    private void setUpHardTimeout(int userId, boolean overrideHardTimeout) {
        if (DEBUG == false) goto L5;
        Slogf.i(TAG, "setUpHardTimeout(userId=%s, overrideHardTimeout=%s)", new Object[]{Integer.valueOf(userId), Boolean.valueOf(overrideHardTimeout)});
    L5:
        this.mContext.enforceCallingOrSelfPermission("android.permission.SCHEDULE_EXACT_ALARM", null);
        TrustableTimeoutAlarmListener alarm = this.mTrustableTimeoutAlarmListenerForUser.get(userId);
        if (alarm != null) goto L8;
    L10:
        long when = SystemClock.elapsedRealtime() + 86400000;
        if (alarm != null) goto L13;
        TrustableTimeoutAlarmListener alarm2 = new TrustableTimeoutAlarmListener(this, userId);
        this.mTrustableTimeoutAlarmListenerForUser.put(userId, alarm2);
        TrustableTimeoutAlarmListener alarm3 = alarm2;
    L17:
        if (DEBUG == false) goto L19;
        Slogf.d(TAG, "\tSetting up trustable hard timeout alarm triggering at elapsedRealTime=%s", new Object[]{Long.valueOf(when)});
    L19:
        alarm3.setQueued(true);
        this.mAlarmManager.setExact(2, when, TRUST_TIMEOUT_ALARM_TAG, alarm3, this.mHandler);
        return;
    L13:
        if (overrideHardTimeout == false) goto L15;
        this.mAlarmManager.cancel(alarm);
    L15:
        alarm3 = alarm;
        goto L17
    L8:
        if (alarm.isQueued() == false) goto L10;
        if (overrideHardTimeout == true) goto L10;
    }

    private void updateTrustAll() {
        List<UserInfo> userInfos = this.mUserManager.getAliveUsers();
        Iterator<UserInfo> r1 = userInfos.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UserInfo userInfo = r1.next();
        updateTrust(userInfo.id, 0);
        goto L4
    }

    public void updateTrust(int userId, int flags) {
        updateTrust(userId, flags, null);
    }

    public void updateTrust(int userId, int flags, AndroidFuture<GrantTrustResult> resultCallback) {
        updateTrust(userId, flags, false, resultCallback);
    }

    private void updateTrust(int userId, int flags, boolean isFromUnlock, AndroidFuture<GrantTrustResult> resultCallback) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "updateTrust(userId=%s, flags=%s, isFromUnlock=%s, resultCallbackPresent=%s)", new Object[]{Integer.valueOf(userId), Integer.valueOf(flags), Boolean.valueOf(isFromUnlock), Boolean.valueOf(Objects.isNull(resultCallback))});
    L5:
        boolean managed = aggregateIsTrustManaged(userId);
        dispatchOnTrustManagedChanged(managed, userId);
        if (this.mStrongAuthTracker.isTrustAllowedForUser(userId) == true) goto L8;
    L10:
        boolean trustedByAtLeastOneAgent = aggregateIsTrusted(userId);
        boolean trustableByAtLeastOneAgent = aggregateIsTrustable(userId);
        IWindowManager wm = WindowManagerGlobal.getWindowManagerService();
        boolean alreadyUnlocked = !wm.isKeyguardLocked();
        boolean alreadyUnlocked2 = alreadyUnlocked;
    L15:
        SparseArray<TrustState> r2 = this.mUserTrustState;
        monitor-enter(r2);
    L38:
        th = move-exception;
        throw th;
    L18:
        if (this.mUserTrustState.get(userId) != TrustState.TRUSTED) goto L20;
        boolean wasTrusted = true;
    L22:
        if (this.mUserTrustState.get(userId) != TrustState.TRUSTABLE) goto L24;
        boolean r3 = true;
    L25:
        boolean wasTrustable = r3;
        if (wasTrustable == true) goto L28;
    L30:
        boolean renewingTrust = false;
    L31:
        if (alreadyUnlocked2 == true) goto L40;
        if (isFromUnlock == true) goto L40;
        if (renewingTrust == true) goto L40;
        if (isAutomotive() == true) goto L40;
        boolean canMoveToTrusted = false;
    L42:
        if (userId != this.mCurrentUser) goto L44;
        boolean updatingTrustForCurrentUser = true;
    L46:
        if (DEBUG == false) goto L49;
        Slogf.d(TAG, "updateTrust: alreadyUnlocked=%s, wasTrusted=%s, wasTrustable=%s, renewingTrust=%s, canMoveToTrusted=%s, updatingTrustForCurrentUser=%s", new Object[]{Boolean.valueOf(alreadyUnlocked2), Boolean.valueOf(wasTrusted), Boolean.valueOf(wasTrustable), Boolean.valueOf(renewingTrust), Boolean.valueOf(canMoveToTrusted), Boolean.valueOf(updatingTrustForCurrentUser)});     // Catch: Throwable -> L38
    L49:
        if (trustedByAtLeastOneAgent == false) goto L53;
        if (wasTrusted == false) goto L53;
        monitor-exit(r2);     // Catch: Throwable -> L38
        return;
    L53:
        if (trustedByAtLeastOneAgent == false) goto L57;
        if (canMoveToTrusted == false) goto L57;
        if (updatingTrustForCurrentUser == false) goto L57;
        TrustState pendingTrustState = TrustState.TRUSTED;     // Catch: Throwable -> L38
    L64:
        if (DEBUG == false) goto L67;
        Slogf.d(TAG, "updateTrust: pendingTrustState=%s", new Object[]{pendingTrustState});     // Catch: Throwable -> L38
    L67:
        this.mUserTrustState.put(userId, pendingTrustState);     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
        if (pendingTrustState != TrustState.TRUSTED) goto L72;
        boolean isNowTrusted = true;
    L73:
        if (alreadyUnlocked2 == true) goto L76;
        if (isNowTrusted == false) goto L76;
        boolean newlyUnlocked = true;
    L78:
        if (DEBUG == false) goto L80;
        Slogf.d(TAG, "updateTrust: isNowTrusted=%s, newlyUnlocked=%s", new Object[]{Boolean.valueOf(isNowTrusted), Boolean.valueOf(newlyUnlocked)});
    L80:
        maybeActiveUnlockRunningChanged(userId);
        dispatchOnTrustChanged(isNowTrusted, newlyUnlocked, userId, flags, getTrustGrantedMessages(userId));
        if (isNowTrusted == wasTrusted) goto L89;
        refreshDeviceLockedForUser(userId);
        if (isNowTrusted == false) goto L89;
        if ((flags & 4) == 0) goto L87;
        boolean isTrustableTimeout = true;
    L88:
        scheduleTrustTimeout(isTrustableTimeout, isTrustableTimeout);
        goto L89
    L87:
        isTrustableTimeout = false;
    L89:
        boolean shouldSendCallback = newlyUnlocked;
        if (shouldSendCallback == false) goto L96;
        if (resultCallback == null) goto L96;
        if (DEBUG == false) goto L95;
        Slogf.d(TAG, "calling back with UNLOCKED_BY_GRANT");
    L95:
        resultCallback.complete(new GrantTrustResult(1));
    L96:
        if (wasTrusted == true) goto L99;
        if (wasTrustable == true) goto L99;
        return;
    L99:
        if (pendingTrustState == TrustState.UNTRUSTED) goto L101;
        return;
    L101:
        if (DEBUG == false) goto L103;
        Slogf.d(TAG, "Trust was revoked, destroy trustable alarms");
    L103:
        cancelBothTrustableAlarms(userId);
        return;
    L76:
        newlyUnlocked = false;
        goto L78
    L72:
        isNowTrusted = false;
    L57:
        if (trustableByAtLeastOneAgent == false) goto L62;
        if (wasTrusted == true) goto L60;
        if (wasTrustable == false) goto L62;
    L60:
        if (updatingTrustForCurrentUser == false) goto L62;
        pendingTrustState = TrustState.TRUSTABLE;     // Catch: Throwable -> L38
    L62:
        TrustState pendingTrustState2 = TrustState.UNTRUSTED;     // Catch: Throwable -> L38
        pendingTrustState = pendingTrustState2;
        goto L64
    L44:
        updatingTrustForCurrentUser = false;
    L40:
        canMoveToTrusted = true;
        goto L42
    L28:
        if ((flags & 4) == 0) goto L30;
        renewingTrust = true;
        goto L31
    L24:
        r3 = false;
        goto L25
    L20:
        wasTrusted = false;
    L14:
        alreadyUnlocked2 = false;
        goto L15
    L8:
        if (isTrustUsuallyManagedInternal(userId) == managed) goto L10;
        updateTrustUsuallyManaged(userId, managed);
        goto L10
    }

    private void updateTrustUsuallyManaged(int userId, boolean managed) {
        SparseBooleanArray r0 = this.mTrustUsuallyManagedForUser;
        monitor-enter(r0);
        this.mTrustUsuallyManagedForUser.put(userId, managed);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mHandler.removeMessages(10);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(10), 120000);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public long addEscrowToken(byte[] token, int userId) {
        return this.mLockPatternUtils.addEscrowToken(token, userId, new TrustManagerService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$addEscrowToken$0(long handle, int userid) {
        dispatchEscrowTokenActivatedLocked(handle, userid);
    }

    public boolean removeEscrowToken(long handle, int userId) {
        return this.mLockPatternUtils.removeEscrowToken(handle, userId);
    }

    public boolean isEscrowTokenActive(long handle, int userId) {
        return this.mLockPatternUtils.isEscrowTokenActive(handle, userId);
    }

    public void unlockUserWithToken(long handle, byte[] token, int userId) {
        this.mLockPatternUtils.unlockUserWithToken(handle, token, userId);
    }

    public void lockUser(int userId) {
        this.mLockPatternUtils.requireStrongAuth(256, userId);
        WindowManagerGlobal.getWindowManagerService().lockNow(null);     // Catch: RemoteException -> L5
        return;
    L6:
        Slogf.e(TAG, "Error locking screen when called from trust agent");
    }

    void showKeyguardErrorMessage(CharSequence message) {
        dispatchOnTrustError(message);
    }

    void refreshAgentList(int userIdOrAll) {
        int userIdOrAll2 = userIdOrAll;
        if (DEBUG == false) goto L6;
        Slogf.d(TAG, "refreshAgentList(userIdOrAll=%s)", new Object[]{Integer.valueOf(userIdOrAll2)});
    L6:
        if (this.mTrustAgentsCanRun == true) goto L12;
        if (DEBUG == false) goto L213;
        Slogf.d(TAG, "Did not refresh agent list because agents cannot run.");
        return;
    L213:
        return;
    L12:
        if (userIdOrAll2 == (-1)) goto L15;
        if (userIdOrAll2 >= 0) goto L15;
        Log.e(TAG, "refreshAgentList(userId=" + userIdOrAll2 + "): Invalid user handle, must be USER_ALL or a specific user.", new Throwable("here"));
        userIdOrAll2 = -1;
    L15:
        PackageManager pm = this.mContext.getPackageManager();
        if (userIdOrAll2 != (-1)) goto L18;
        List<UserInfo> userInfos = this.mUserManager.getAliveUsers();
    L19:
        LockPatternUtils lockPatternUtils = this.mLockPatternUtils;
        ArraySet<AgentInfo> obsoleteAgents = new ArraySet();
        obsoleteAgents.addAll(this.mActiveAgents);
        Iterator<UserInfo> r8 = userInfos.iterator();
    L21:
        if (r8.hasNext() == false) goto L126;
        UserInfo userInfo = r8.next();
        if (userInfo == null) goto L21;
        if (userInfo.partial == true) goto L21;
        if (userInfo.isEnabled() == false) goto L21;
        if (userInfo.guestToRemove == true) goto L21;
        if (userInfo.supportsSwitchToByUser() == false) goto L34;
        if (this.mActivityManager.isUserRunning(userInfo.id) == false) goto L39;
        if (lockPatternUtils.isSecure(userInfo.id) == false) goto L44;
        DevicePolicyManager dpm = lockPatternUtils.getDevicePolicyManager();
        int disabledFeatures = dpm.getKeyguardDisabledFeatures(null, userInfo.id);
        if ((disabledFeatures & 16) == 0) goto L49;
        boolean disableTrustAgents = true;
    L50:
        List<ComponentName> enabledAgents = lockPatternUtils.getEnabledTrustAgents(userInfo.id);
        if (enabledAgents.isEmpty() == true) goto L53;
        List<ResolveInfo> resolveInfos = resolveAllowedTrustAgents(pm, userInfo.id);
        Iterator<ResolveInfo> r17 = resolveInfos.iterator();
    L57:
        if (r17.hasNext() == false) goto L21;
        ResolveInfo resolveInfo = r17.next();
        ComponentName name = getComponentName(resolveInfo);
        if (enabledAgents.contains(name) == false) goto L61;
        List<ResolveInfo> resolveInfos2 = resolveInfos;
        LockPatternUtils lockPatternUtils2 = lockPatternUtils;
        if (disableTrustAgents == false) goto L74;
        List<PersistableBundle> config = dpm.getTrustAgentConfiguration(null, name, userInfo.id);
        if (config == null) goto L71;
        if (config.isEmpty() == false) goto L74;
    L71:
        if (DEBUG == true) goto L72;
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
        goto L57
    L72:
        Slogf.d(TAG, "refreshAgentList: skipping %s u%s: not allowed by DPM", new Object[]{name.flattenToShortString(), Integer.valueOf(userInfo.id)});
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
    L74:
        AgentInfo agentInfo = new AgentInfo(null);
        agentInfo.component = name;
        agentInfo.userId = userInfo.id;
        if (this.mActiveAgents.contains(agentInfo) == true) goto L77;
        agentInfo.label = resolveInfo.loadLabel(pm);
        agentInfo.icon = resolveInfo.loadIcon(pm);
        agentInfo.settings = getSettingsAttrs(pm, resolveInfo);
    L78:
        int index = 0;
        PackageManager pm2 = pm;
        if (agentInfo.settings != null) goto L81;
    L87:
        if (index == 0) goto L94;
        if (DEBUG == false) goto L94;
        Slogf.d(TAG, "refreshAgentList: trustagent %s of user %s can unlock user profile.", new Object[]{name, Integer.valueOf(userInfo.id)});
    L94:
        if (this.mUserManager.isUserUnlockingOrUnlocked(userInfo.id) == true) goto L101;
        if (index != 0) goto L101;
        if (DEBUG == true) goto L98;
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
        pm = pm2;
        goto L57
    L98:
        Slogf.d(TAG, "refreshAgentList: skipping user %s's trust agent %s: FBE still locked and the agent cannot unlock user profile.", new Object[]{Integer.valueOf(userInfo.id), name});
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
        pm = pm2;
    L101:
        if (this.mStrongAuthTracker.canAgentsRunForUser(userInfo.id) == true) goto L116;
        int flag = this.mStrongAuthTracker.getStrongAuthForUser(userInfo.id);
        if (flag == 8) goto L116;
        if (flag != 1) goto L110;
        if (index != 0) goto L116;
    L110:
        if (DEBUG == true) goto L111;
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
        pm = pm2;
        goto L57
    L111:
        Slogf.d(TAG, "refreshAgentList: skipping user %s: prevented by StrongAuthTracker = 0x%s", new Object[]{Integer.valueOf(userInfo.id), Integer.toHexString(this.mStrongAuthTracker.getStrongAuthForUser(userInfo.id))});
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
        pm = pm2;
        r8 = r8;
    L116:
        if (agentInfo.agent != null) goto L118;
        UserInfo userInfo2 = userInfo;
        agentInfo.agent = new TrustAgentWrapper(this.mContext, this, new Intent().setComponent(name), userInfo2.getUserHandle());
    L120:
        if (this.mActiveAgents.contains(agentInfo) == true) goto L122;
        this.mActiveAgents.add(agentInfo);
    L123:
        resolveInfos = resolveInfos2;
        lockPatternUtils = lockPatternUtils2;
        pm = pm2;
        userInfo = userInfo2;
        r8 = r8;
        goto L57
    L122:
        obsoleteAgents.remove(agentInfo);
        goto L123
    L118:
        userInfo2 = userInfo;
        goto L120
    L81:
        if (resolveInfo.serviceInfo.directBootAware == true) goto L83;
    L85:
        int r4 = 0;
    L86:
        index = r4;
        goto L87
    L83:
        if (agentInfo.settings.canUnlockProfile == false) goto L85;
        r4 = 1;
        goto L86
    L77:
        int index2 = this.mActiveAgents.indexOf(agentInfo);
        agentInfo = this.mActiveAgents.valueAt(index2);
        goto L78
    L61:
        if (DEBUG == false) goto L57;
        Slogf.d(TAG, "refreshAgentList: skipping %s u%s: not enabled by user", new Object[]{name.flattenToShortString(), Integer.valueOf(userInfo.id)});
        resolveInfos = resolveInfos;
        lockPatternUtils = lockPatternUtils;
        goto L57
    L53:
        if (DEBUG == false) goto L21;
        Slogf.d(TAG, "refreshAgentList: skipping user %s: no agents enabled by user", new Object[]{Integer.valueOf(userInfo.id)});
        goto L21
    L49:
        disableTrustAgents = false;
        goto L50
    L44:
        if (DEBUG == false) goto L21;
        Slogf.d(TAG, "refreshAgentList: skipping user %s: no secure credential", new Object[]{Integer.valueOf(userInfo.id)});
        goto L21
    L39:
        if (DEBUG == false) goto L21;
        Slogf.d(TAG, "refreshAgentList: skipping user %s: user not started", new Object[]{Integer.valueOf(userInfo.id)});
        goto L21
    L34:
        if (DEBUG == false) goto L21;
        Slogf.d(TAG, "refreshAgentList: skipping user %s: switchToByUser=false", new Object[]{Integer.valueOf(userInfo.id)});
        goto L21
    L126:
        boolean trustMayHaveChanged = false;
        int i = 0;
    L128:
        if (i >= obsoleteAgents.size()) goto L139;
        AgentInfo info = obsoleteAgents.valueAt(i);
        if (userIdOrAll2 == (-1)) goto L134;
        if (userIdOrAll2 == info.userId) goto L134;
    L137:
        i = i + 1;
    L134:
        if (info.agent.isManagingTrust() == false) goto L136;
        trustMayHaveChanged = true;
    L136:
        info.agent.destroy();
        this.mActiveAgents.remove(info);
        goto L137
    L139:
        if (DEBUG == false) goto L141;
        Slogf.d(TAG, "refreshAgentList: userInfos=%s, obsoleteAgents=%s, trustMayHaveChanged=%s", new Object[]{userInfos, obsoleteAgents, Boolean.valueOf(trustMayHaveChanged)});
    L141:
        if (trustMayHaveChanged == true) goto L143;
        return;
    L143:
        if (userIdOrAll2 != (-1)) goto L145;
        updateTrustAll();
        return;
    L145:
        updateTrust(userIdOrAll2, 0);
        return;
    L18:
        userInfos = new ArrayList();
        userInfos.add(this.mUserManager.getUserInfo(userIdOrAll2));
        goto L19
    }

    private TrustState getUserTrustStateInner(int userId) {
        SparseArray<TrustState> r0 = this.mUserTrustState;
        monitor-enter(r0);
        TrustState r1 = this.mUserTrustState.get(userId, TrustState.UNTRUSTED);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isDeviceLockedInner(int userId) {
        SparseBooleanArray r0 = this.mDeviceLockedForUser;
        monitor-enter(r0);
        boolean r1 = this.mDeviceLockedForUser.get(userId, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void maybeActiveUnlockRunningChanged(int userId) {
        boolean oldValue = this.mLastActiveUnlockRunningState.get(userId);
        boolean newValue = aggregateIsActiveUnlockRunning(userId);
        if (oldValue != newValue) goto L5;
        return;
    L5:
        this.mLastActiveUnlockRunningState.put(userId, newValue);
        int i = 0;
    L7:
        if (i >= this.mTrustListeners.size()) goto L10;
        notifyListenerIsActiveUnlockRunning(this.mTrustListeners.get(i), newValue, userId);
        i = i + 1;
        goto L7
    }

    private void refreshDeviceLockedForUser(int userId) {
        refreshDeviceLockedForUser(userId, ProcessList.INVALID_ADJ);
    }

    private void refreshDeviceLockedForUser(int userId, int unlockedUser) {
        if (userId == (-1)) goto L6;
        if (userId >= 0) goto L6;
        Log.e(TAG, "refreshDeviceLockedForUser(userId=" + userId + "): Invalid user handle, must be USER_ALL or a specific user.", new Throwable("here"));
        int userId2 = -1;
    L7:
        if (userId2 != (-1)) goto L9;
        List<UserInfo> userInfos = this.mUserManager.getAliveUsers();
    L10:
        IWindowManager wm = WindowManagerGlobal.getWindowManagerService();
        int i = 0;
    L12:
        if (i >= userInfos.size()) goto L73;
        UserInfo info = userInfos.get(i);
        if (info == null) goto L71;
        if (info.partial == true) goto L71;
        if (info.isEnabled() == false) goto L71;
        if (info.guestToRemove == true) goto L71;
        int id = info.id;
        boolean secure = this.mLockPatternUtils.isSecure(id);
        if (info.supportsSwitchToByUser() == false) goto L25;
        boolean deviceLocked = true;
        if (getUserTrustStateInner(id) != TrustState.TRUSTED) goto L35;
        boolean r0 = true;
    L36:
        boolean trusted = r0;
        boolean showingKeyguard = true;
        boolean biometricAuthenticated = false;
        boolean currentUserIsUnlocked = false;
        if (this.mCurrentUser != id) goto L58;
        SparseBooleanArray r15 = this.mUsersUnlockedByBiometric;
        monitor-enter(r15);
        biometricAuthenticated = this.mUsersUnlockedByBiometric.get(id, false);     // Catch: Throwable -> L51
        monitor-exit(r15);     // Catch: Throwable -> L51
        showingKeyguard = wm.isKeyguardLocked();     // Catch: RemoteException -> L44
    L47:
        if (unlockedUser != id) goto L49;
        boolean r1 = true;
    L50:
        currentUserIsUnlocked = r1;
    L60:
        if (secure == false) goto L65;
        if (showingKeyguard == false) goto L65;
        if (trusted == true) goto L65;
        if (biometricAuthenticated == true) goto L65;
    L66:
        if (deviceLocked == false) goto L69;
        if (currentUserIsUnlocked == true) goto L71;
    L69:
        setDeviceLockedForUser(id, deviceLocked);
    L65:
        deviceLocked = false;
        goto L66
    L49:
        r1 = false;
    L44:
        e = move-exception;
        Log.w(TAG, "Unable to check keyguard lock state", e);
    L51:
        th = th;
    L78:
        throw th;
    L55:
        th = th;
        goto L78
    L58:
        if (isVisibleBackgroundUser(id) == false) goto L60;
        showingKeyguard = !this.mUserManager.isUserUnlocked(id);
        goto L60
    L35:
        r0 = false;
        goto L36
    L25:
        if (info.isProfile() == false) goto L71;
        if (secure == true) goto L71;
        if (this.mLockPatternUtils.isProfileWithUnifiedChallenge(id) == true) goto L71;
        setDeviceLockedForUser(id, false);
    L71:
        i = i + 1;
        goto L12
    L73:
        return;
    L9:
        List<UserInfo> userInfos2 = new ArrayList();
        userInfos2.add(this.mUserManager.getUserInfo(userId2));
        userInfos = userInfos2;
    L6:
        userId2 = userId;
        goto L7
    }

    private void setDeviceLockedForUser(int userId, boolean locked) {
        SparseBooleanArray r0 = this.mDeviceLockedForUser;
        monitor-enter(r0);
        int r2 = 0;
        if (isDeviceLockedInner(userId) == locked) goto L7;
        boolean changed = true;
    L8:
        this.mDeviceLockedForUser.put(userId, locked);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (changed == false) goto L18;
        notifyTrustAgentsOfDeviceLockState(userId, locked);
        notifyKeystoreOfDeviceLockState(userId, locked);
        notifyDeviceLockedListenersForUser(userId, locked);
        int[] r1 = this.mUserManager.getEnabledProfileIds(userId);
        int r3 = r1.length;
    L13:
        if (r2 >= r3) goto L27;
        int profileHandle = r1[r2];
        if (this.mLockPatternUtils.isManagedProfileWithUnifiedChallenge(profileHandle) == false) goto L17;
        notifyKeystoreOfDeviceLockState(profileHandle, locked);
    L17:
        r2 = r2 + 1;
        goto L13
    L27:
        return;
    L18:
        return;
    L7:
        changed = false;
    L19:
        th = move-exception;
        throw th;
    }

    private boolean isVisibleBackgroundUser(int userId) {
        if (this.mUserManager.isVisibleBackgroundUsersSupported() == true) goto L7;
        return false;
    L7:
        if (this.mUserManagerInternal != null) goto L10;
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    L10:
        return this.mUserManagerInternal.isVisibleBackgroundFullUser(userId);
    }

    private void notifyTrustAgentsOfDeviceLockState(int userId, boolean isLocked) {
        int i = 0;
    L4:
        if (i >= this.mActiveAgents.size()) goto L12;
        AgentInfo agent = this.mActiveAgents.valueAt(i);
        if (agent.userId != userId) goto L10;
        if (isLocked == false) goto L9;
        agent.agent.onDeviceLocked();
        goto L10
    L9:
        agent.agent.onDeviceUnlocked();
    L10:
        i = i + 1;
        goto L4
    }

    private void notifyKeystoreOfDeviceLockState(int userId, boolean isLocked) {
        if (isLocked == true) goto L4;
        this.mKeyStoreAuthorization.onDeviceUnlocked(userId, null);
        return;
    L4:
        if (this.mLockPatternUtils.isProfileWithUnifiedChallenge(userId) == false) goto L6;
        int authUserId = resolveProfileParent(userId);
    L7:
        this.mKeyStoreAuthorization.onDeviceLocked(userId, getBiometricSids(authUserId), isWeakUnlockMethodEnabled(authUserId));
        return;
    L6:
        authUserId = userId;
        goto L7
    }

    private void dispatchEscrowTokenActivatedLocked(long handle, int userId) {
        int i = 0;
    L4:
        if (i >= this.mActiveAgents.size()) goto L10;
        AgentInfo agent = this.mActiveAgents.valueAt(i);
        if (agent.userId != userId) goto L8;
        agent.agent.onEscrowTokenActivated(handle, userId);
    L8:
        i = i + 1;
        goto L4
    }

    void updateDevicePolicyFeatures() {
        boolean changed = false;
        int i = 0;
    L4:
        if (i >= this.mActiveAgents.size()) goto L10;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.agent.isConnected() == false) goto L8;
        info.agent.updateDevicePolicyFeatures();
        changed = true;
    L8:
        i = i + 1;
        goto L4
    L10:
        if (changed == false) goto L16;
        this.mArchive.logDevicePolicyChanged();
        return;
    }

    private void removeAgentsOfPackage(String packageName) {
        boolean trustMayHaveChanged = false;
        int i = this.mActiveAgents.size() - 1;
    L3:
        if (i < 0) goto L12;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (packageName.equals(info.component.getPackageName()) == false) goto L10;
        Log.i(TAG, "Resetting agent " + info.component.flattenToShortString());
        if (info.agent.isManagingTrust() == false) goto L9;
        trustMayHaveChanged = true;
    L9:
        info.agent.destroy();
        this.mActiveAgents.removeAt(i);
    L10:
        i = i - 1;
        goto L3
    L12:
        if (trustMayHaveChanged == false) goto L18;
        updateTrustAll();
        return;
    }

    public void resetAgent(ComponentName name, int userId) {
        boolean trustMayHaveChanged = false;
        int i = this.mActiveAgents.size() - 1;
    L3:
        if (i < 0) goto L14;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (name.equals(info.component) == false) goto L12;
        if (userId != info.userId) goto L12;
        Log.i(TAG, "Resetting agent " + info.component.flattenToShortString());
        if (info.agent.isManagingTrust() == false) goto L11;
        trustMayHaveChanged = true;
    L11:
        info.agent.destroy();
        this.mActiveAgents.removeAt(i);
    L12:
        i = i - 1;
        goto L3
    L14:
        if (trustMayHaveChanged == false) goto L16;
        updateTrust(userId, 0);
    L16:
        refreshAgentList(userId);
    }

    private SettingsAttrs getSettingsAttrs(PackageManager pm, ResolveInfo resolveInfo) {
        if (resolveInfo != null) goto L5;
    L58:
        return null;
    L5:
        if (resolveInfo.serviceInfo == null) goto L58;
        if (resolveInfo.serviceInfo.metaData == null) goto L58;
        String cn = null;
        boolean canUnlockProfile = false;
        XmlResourceParser parser = null;
        Exception caughtException = null;
        parser = resolveInfo.serviceInfo.loadXmlMetaData(pm, "android.service.trust.trustagent");     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        if (parser != null) goto L24;
        Slogf.w(TAG, "Can't find %s meta-data", new Object[]{"android.service.trust.trustagent"});     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        if (parser == null) goto L15;
        parser.close();
    L15:
        return null;
    L24:
        Resources res = pm.getResourcesForApplication(resolveInfo.serviceInfo.applicationInfo);     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        AttributeSet attrs = Xml.asAttributeSet(parser);     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
    L25:
        int type = parser.next();     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        if (type == 1) goto L29;
        if (type != 2) goto L25;
    L29:
        String nodeName = parser.getName();     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        if ("trust-agent".equals(nodeName) == true) goto L34;
        Slogf.w(TAG, "Meta-data does not start with trust-agent tag");     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        parser.close();
        return null;
    L34:
        TypedArray sa = res.obtainAttributes(attrs, R.styleable.TrustAgent);     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        cn = sa.getString(2);     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        canUnlockProfile = attrs.getAttributeBooleanValue(PRIV_NAMESPACE, "unlockProfile", false);     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
        sa.recycle();     // Catch: Throwable -> L16 XmlPullParserException -> L18 IOException -> L20 PackageManager.NameNotFoundException -> L22
    L35:
        parser.close();
    L48:
        if (caughtException == null) goto L51;
        Slogf.w(TAG, caughtException, "Error parsing : %s", new Object[]{resolveInfo.serviceInfo.packageName});
        return null;
    L51:
        if (cn != null) goto L54;
        return null;
    L54:
        if (cn.indexOf(47) >= 0) goto L57;
        cn = resolveInfo.serviceInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + cn;
    L57:
        return new SettingsAttrs(ComponentName.unflattenFromString(cn), canUnlockProfile);
    L22:
        e = move-exception;
        caughtException = e;
        if (0 == 0) goto L48;
    L20:
        e = move-exception;
        caughtException = e;
        if (0 == 0) goto L48;
    L18:
        e = move-exception;
        caughtException = e;
        if (0 == 0) goto L48;
    L16:
        th = move-exception;
        if (0 == 0) goto L38;
        parser.close();
    L38:
        throw th;
    }

    private ComponentName getComponentName(ResolveInfo resolveInfo) {
        if (resolveInfo != null) goto L4;
        return null;
    L4:
        if (resolveInfo.serviceInfo != null) goto L7;
        return null;
    L7:
        return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
    }

    private void maybeEnableFactoryTrustAgents(int userId) {
        boolean shouldUseDefaultAgent = false;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "trust_agents_initialized", 0, userId) == 0) goto L5;
        return;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        List<ResolveInfo> resolveInfos = resolveAllowedTrustAgents(pm, userId);
        ComponentName defaultAgent = getDefaultFactoryTrustAgent(this.mContext);
        if (defaultAgent == null) goto L8;
        shouldUseDefaultAgent = true;
    L8:
        ArraySet<ComponentName> discoveredAgents = new ArraySet();
        if (shouldUseDefaultAgent == false) goto L11;
        discoveredAgents.add(defaultAgent);
        Log.i(TAG, "Enabling " + defaultAgent + " because it is a default agent.");
    L18:
        enableNewAgents(discoveredAgents, userId);
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "trust_agents_initialized", 1, userId);
        return;
    L11:
        Iterator<ResolveInfo> r8 = resolveInfos.iterator();
    L13:
        if (r8.hasNext() == false) goto L18;
        ResolveInfo resolveInfo = r8.next();
        ComponentName componentName = getComponentName(resolveInfo);
        if (isSystemTrustAgent(resolveInfo) == false) goto L16;
        discoveredAgents.add(componentName);
        goto L13
    L16:
        Log.i(TAG, "Leaving agent " + componentName + " disabled because package is not a system package.");
        goto L13
    }

    private void checkNewAgents() {
        Iterator r0 = this.mUserManager.getAliveUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UserInfo userInfo = (UserInfo) r0.next();
        checkNewAgentsForUser(userInfo.id);
        goto L4
    }

    private void checkNewAgentsForUser(int userId) {
        boolean hasDefaultAgent = false;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "known_trust_agents_initialized", 0, userId) != 0) goto L6;
        initializeKnownAgents(userId);
        return;
    L6:
        List<ComponentName> knownAgents = this.mLockPatternUtils.getKnownTrustAgents(userId);
        List<ResolveInfo> agentInfoList = resolveAllowedTrustAgents(this.mContext.getPackageManager(), userId);
        ArraySet<? extends ComponentName> newAgents = new ArraySet(agentInfoList.size());
        ArraySet<ComponentName> newSystemAgents = new ArraySet(agentInfoList.size());
        Iterator<ResolveInfo> r5 = agentInfoList.iterator();
    L8:
        if (r5.hasNext() == false) goto L17;
        ResolveInfo agentInfo = r5.next();
        ComponentName agentComponentName = getComponentName(agentInfo);
        if (knownAgents.contains(agentComponentName) == true) goto L8;
        newAgents.add(agentComponentName);
        if (isSystemTrustAgent(agentInfo) == false) goto L8;
        newSystemAgents.add(agentComponentName);
        goto L8
    L17:
        if (newAgents.isEmpty() == false) goto L19;
        return;
    L19:
        ArraySet<ComponentName> updatedKnowAgents = new ArraySet(knownAgents);
        updatedKnowAgents.addAll(newAgents);
        this.mLockPatternUtils.setKnownTrustAgents(updatedKnowAgents, userId);
        if (getDefaultFactoryTrustAgent(this.mContext) == null) goto L22;
        hasDefaultAgent = true;
    L22:
        if (hasDefaultAgent == true) goto L32;
        enableNewAgents(newSystemAgents, userId);
        return;
    }

    private void enableNewAgents(Collection<ComponentName> agents, int userId) {
        if (agents.isEmpty() == false) goto L5;
        return;
    L5:
        ArraySet<ComponentName> agentsToEnable = new ArraySet(agents);
        agentsToEnable.addAll(this.mLockPatternUtils.getEnabledTrustAgents(userId));
        this.mLockPatternUtils.setEnabledTrustAgents(agentsToEnable, userId);
    }

    private void initializeKnownAgents(int userId) {
        List<ResolveInfo> agentInfoList = resolveAllowedTrustAgents(this.mContext.getPackageManager(), userId);
        ArraySet<ComponentName> agentComponentNames = new ArraySet(agentInfoList.size());
        Iterator<ResolveInfo> r2 = agentInfoList.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ResolveInfo agentInfo = r2.next();
        agentComponentNames.add(getComponentName(agentInfo));
        goto L4
    L6:
        this.mLockPatternUtils.setKnownTrustAgents(agentComponentNames, userId);
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "known_trust_agents_initialized", 1, userId);
    }

    private static ComponentName getDefaultFactoryTrustAgent(Context context) {
        String defaultTrustAgent = context.getResources().getString(android.R.string.config_inCallNotificationSound);
        if (TextUtils.isEmpty(defaultTrustAgent) == false) goto L7;
        return null;
    L7:
        return ComponentName.unflattenFromString(defaultTrustAgent);
    }

    private List<ResolveInfo> resolveAllowedTrustAgents(PackageManager pm, int userId) {
        List<ResolveInfo> resolveInfos = pm.queryIntentServicesAsUser(TRUST_AGENT_INTENT, 786560, userId);
        ArrayList<ResolveInfo> allowedAgents = new ArrayList(resolveInfos.size());
        Iterator<ResolveInfo> r2 = resolveInfos.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        ResolveInfo resolveInfo = r2.next();
        if (resolveInfo.serviceInfo == null) goto L4;
        if (resolveInfo.serviceInfo.applicationInfo == null) goto L4;
        String packageName = resolveInfo.serviceInfo.packageName;
        if (pm.checkPermission(PERMISSION_PROVIDE_AGENT, packageName) != 0) goto L13;
        allowedAgents.add(resolveInfo);
        goto L4
    L13:
        ComponentName name = getComponentName(resolveInfo);
        Log.w(TAG, "Skipping agent " + name + " because package does not have permission " + PERMISSION_PROVIDE_AGENT + ".");
        goto L4
    L15:
        return allowedAgents;
    }

    private static boolean isSystemTrustAgent(ResolveInfo agentInfo) {
        if ((agentInfo.serviceInfo.applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean aggregateIsTrusted(int userId) {
        if (DEBUG == false) goto L6;
        Slogf.d(TAG, "aggregateIsTrusted(userId=%s)", new Object[]{Integer.valueOf(userId)});
    L6:
        if (this.mStrongAuthTracker.isTrustAllowedForUser(userId) == false) goto L8;
        int i = 0;
    L13:
        if (i >= this.mActiveAgents.size()) goto L25;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L23;
        if (info.agent.isTrusted() == false) goto L23;
        if (DEBUG == false) goto L30;
        Slogf.d(TAG, "trusted by %s", new Object[]{info});
        return true;
    L30:
        return true;
    L23:
        i = i + 1;
        goto L13
    L25:
        return false;
    L8:
        if (DEBUG == false) goto L10;
        Slogf.d(TAG, "not trusted because trust not allowed for userId=%s", new Object[]{Integer.valueOf(userId)});
    L10:
        return false;
    }

    private boolean aggregateIsTrustable(int userId) {
        if (DEBUG == false) goto L6;
        Slogf.d(TAG, "aggregateIsTrustable(userId=%s)", new Object[]{Integer.valueOf(userId)});
    L6:
        if (this.mStrongAuthTracker.isTrustAllowedForUser(userId) == false) goto L8;
        int i = 0;
    L13:
        if (i >= this.mActiveAgents.size()) goto L25;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L23;
        if (info.agent.isTrustable() == false) goto L23;
        if (DEBUG == false) goto L30;
        Slogf.d(TAG, "trustable by %s", new Object[]{info});
        return true;
    L30:
        return true;
    L23:
        i = i + 1;
        goto L13
    L25:
        return false;
    L8:
        if (DEBUG == false) goto L10;
        Slogf.d(TAG, "not trustable because trust not allowed for userId=%s", new Object[]{Integer.valueOf(userId)});
    L10:
        return false;
    }

    private boolean aggregateIsActiveUnlockRunning(int userId) {
        if (this.mStrongAuthTracker.isTrustAllowedForUser(userId) == true) goto L5;
        return false;
    L5:
        SparseArray<TrustState> r0 = this.mUserTrustState;
        monitor-enter(r0);
        TrustState currentState = this.mUserTrustState.get(userId);     // Catch: Throwable -> L13
        if (currentState != TrustState.TRUSTED) goto L10;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        int i = 0;
    L18:
        if (i >= this.mActiveAgents.size()) goto L27;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L25;
        if (info.agent.isTrustableOrWaitingForDowngrade() == false) goto L25;
        return true;
    L25:
        i = i + 1;
        goto L18
    L27:
        return false;
    L10:
        if (currentState == TrustState.TRUSTABLE) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    private void dispatchTrustableDowngrade() {
        int i = 0;
    L4:
        if (i >= this.mActiveAgents.size()) goto L10;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != this.mCurrentUser) goto L8;
        info.agent.downgradeToTrustable();
    L8:
        i = i + 1;
        goto L4
    }

    private List<String> getTrustGrantedMessages(int userId) {
        if (this.mStrongAuthTracker.isTrustAllowedForUser(userId) == false) goto L5;
        List<String> trustGrantedMessages = new ArrayList();
        int i = 0;
    L8:
        if (i >= this.mActiveAgents.size()) goto L20;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L18;
        if (info.agent.isTrusted() == false) goto L18;
        if (info.agent.shouldDisplayTrustGrantedMessage() == false) goto L18;
        if (info.agent.getMessage() == null) goto L18;
        trustGrantedMessages.add(info.agent.getMessage().toString());
    L18:
        i = i + 1;
        goto L8
    L20:
        return trustGrantedMessages;
    L5:
        return new ArrayList();
    }

    private boolean aggregateIsTrustManaged(int userId) {
        if (this.mStrongAuthTracker.isTrustAllowedForUser(userId) == false) goto L5;
        int i = 0;
    L10:
        if (i >= this.mActiveAgents.size()) goto L22;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L20;
        if (info.agent.isManagingTrust() == false) goto L20;
        if (DEBUG == false) goto L29;
        Slogf.d(TAG, "trust managed for userId=%s", new Object[]{Integer.valueOf(userId)});
        return true;
    L29:
        return true;
    L20:
        i = i + 1;
        goto L10
    L22:
        if (DEBUG == false) goto L24;
        Slogf.d(TAG, "trust not managed for userId=%s", new Object[]{Integer.valueOf(userId)});
    L24:
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slogf.d(TAG, "trust not managed due to trust not being allowed for userId=%s", new Object[]{Integer.valueOf(userId)});
    L7:
        return false;
    }

    private void dispatchUnlockAttempt(boolean successful, int userId) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "dispatchUnlockAttempt(successful=%s, userId=%s)", new Object[]{Boolean.valueOf(successful), Integer.valueOf(userId)});
    L5:
        if (successful == false) goto L7;
        this.mStrongAuthTracker.allowTrustFromUnlock(userId);
        updateTrust(userId, 0, true, null);
        this.mHandler.obtainMessage(17, Integer.valueOf(userId)).sendToTarget();
    L7:
        int i = 0;
    L9:
        if (i >= this.mActiveAgents.size()) goto L15;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L13;
        info.agent.onUnlockAttempt(successful);
    L13:
        i = i + 1;
        goto L9
    }

    private void dispatchUserRequestedUnlock(int userId, boolean dismissKeyguard) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "dispatchUserRequestedUnlock(user=%s, dismissKeyguard=%s)", new Object[]{Integer.valueOf(userId), Boolean.valueOf(dismissKeyguard)});
    L5:
        int i = 0;
    L7:
        if (i >= this.mActiveAgents.size()) goto L13;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L11;
        info.agent.onUserRequestedUnlock(dismissKeyguard);
    L11:
        i = i + 1;
        goto L7
    }

    private void dispatchUserMayRequestUnlock(int userId) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "dispatchUserMayRequestUnlock(user=%s)", new Object[]{Integer.valueOf(userId)});
    L5:
        int i = 0;
    L7:
        if (i >= this.mActiveAgents.size()) goto L13;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L11;
        info.agent.onUserMayRequestUnlock();
    L11:
        i = i + 1;
        goto L7
    }

    private void dispatchUnlockLockout(int timeoutMs, int userId) {
        int i = 0;
    L4:
        if (i >= this.mActiveAgents.size()) goto L10;
        AgentInfo info = this.mActiveAgents.valueAt(i);
        if (info.userId != userId) goto L8;
        info.agent.onUnlockLockout(timeoutMs);
    L8:
        i = i + 1;
        goto L4
    }

    private void notifyListenerIsActiveUnlockRunningInitialState(ITrustListener listener) {
        int numUsers = this.mLastActiveUnlockRunningState.size();
        int i = 0;
    L3:
        if (i >= numUsers) goto L6;
        int userId = this.mLastActiveUnlockRunningState.keyAt(i);
        boolean isRunning = aggregateIsActiveUnlockRunning(userId);
        notifyListenerIsActiveUnlockRunning(listener, isRunning, userId);
        i = i + 1;
        goto L3
    }

    private void notifyListenerIsActiveUnlockRunning(ITrustListener listener, boolean isRunning, int userId) {
        listener.onIsActiveUnlockRunningChanged(isRunning, userId);     // Catch: RemoteException -> L5 DeadObjectException -> L7
        goto L8
    L12:
        return;
    L5:
        e = move-exception;
        Slogf.e(TAG, "Exception while notifying TrustListener.", e);
        return;
    L8:
        Slogf.d(TAG, "TrustListener dead while trying to notify Active Unlock running state");
    }

    private void addListener(ITrustListener listener) {
        int i = 0;
    L4:
        if (i >= this.mTrustListeners.size()) goto L9;
        if (this.mTrustListeners.get(i).asBinder() == listener.asBinder()) goto L7;
        i = i + 1;
        goto L4
    L7:
        return;
    L9:
        this.mTrustListeners.add(listener);
        notifyListenerIsActiveUnlockRunningInitialState(listener);
        updateTrustAll();
    }

    private void removeListener(ITrustListener listener) {
        int i = 0;
    L4:
        if (i >= this.mTrustListeners.size()) goto L11;
        if (this.mTrustListeners.get(i).asBinder() == listener.asBinder()) goto L7;
        i = i + 1;
        goto L4
    L7:
        this.mTrustListeners.remove(i);
        return;
    }

    private void dispatchOnTrustChanged(boolean enabled, boolean newlyUnlocked, int userId, int flags, List<String> trustGrantedMessages) {
        if (DEBUG == false) goto L5;
        Log.i(TAG, "onTrustChanged(" + enabled + ", " + newlyUnlocked + ", " + userId + ", 0x" + Integer.toHexString(flags) + ")");
    L5:
        if (enabled == true) goto L7;
        flags = 0;
    L7:
        int flags2 = flags;
        int i = 0;
    L9:
        if (i >= this.mTrustListeners.size()) goto L31;
        boolean enabled2 = enabled;
        boolean newlyUnlocked2 = newlyUnlocked;
        int userId2 = userId;
        List<String> trustGrantedMessages2 = trustGrantedMessages;
        this.mTrustListeners.get(i).onTrustChanged(enabled2, newlyUnlocked2, userId2, flags2, trustGrantedMessages2);     // Catch: RemoteException -> L14 DeadObjectException -> L16 FrozenObjectException -> L18
    L14:
        e = move-exception;
        RemoteException e = e;
    L26:
        Slogf.e(TAG, "Exception while notifying TrustListener.", e);
    L27:
        Slogf.d(TAG, "Removing dead TrustListener.");
        this.mTrustListeners.remove(i);
        i = i - 1;
    L29:
        i = i + 1;
        enabled = enabled2;
        newlyUnlocked = newlyUnlocked2;
        userId = userId2;
        trustGrantedMessages = trustGrantedMessages2;
        goto L9
    L20:
        e = move-exception;
        enabled2 = enabled;
        newlyUnlocked2 = newlyUnlocked;
        userId2 = userId;
        trustGrantedMessages2 = trustGrantedMessages;
        e = e;
    L25:
        enabled2 = enabled;
        newlyUnlocked2 = newlyUnlocked;
        userId2 = userId;
        trustGrantedMessages2 = trustGrantedMessages;
    L23:
        enabled2 = enabled;
        newlyUnlocked2 = newlyUnlocked;
        userId2 = userId;
        trustGrantedMessages2 = trustGrantedMessages;
        goto L27
    }

    private void dispatchOnEnabledTrustAgentsChanged(int userId) {
        if (DEBUG == false) goto L5;
        Log.i(TAG, "onEnabledTrustAgentsChanged(" + userId + ")");
    L5:
        int i = 0;
    L7:
        if (i >= this.mTrustListeners.size()) goto L19;
        this.mTrustListeners.get(i).onEnabledTrustAgentsChanged(userId);     // Catch: RemoteException -> L10 DeadObjectException -> L12
    L17:
        i = i + 1;
    L10:
        e = move-exception;
        Slogf.e(TAG, "Exception while notifying TrustListener.", e);
    L15:
        Slogf.d(TAG, "Removing dead TrustListener.");
        this.mTrustListeners.remove(i);
        i = i - 1;
        goto L17
    }

    private void dispatchOnTrustManagedChanged(boolean managed, int userId) {
        if (DEBUG == false) goto L5;
        Log.i(TAG, "onTrustManagedChanged(" + managed + ", " + userId + ")");
    L5:
        int i = 0;
    L7:
        if (i >= this.mTrustListeners.size()) goto L21;
        this.mTrustListeners.get(i).onTrustManagedChanged(managed, userId);     // Catch: RemoteException -> L10 DeadObjectException -> L12 FrozenObjectException -> L14
    L10:
        e = move-exception;
        Slogf.e(TAG, "Exception while notifying TrustListener.", e);
    L17:
        Slogf.d(TAG, "Removing dead TrustListener.");
        this.mTrustListeners.remove(i);
        i = i - 1;
    L19:
        i = i + 1;
        goto L7
    }

    private void dispatchOnTrustError(CharSequence message) {
        if (DEBUG == false) goto L5;
        Log.i(TAG, "onTrustError(" + message + ")");
    L5:
        int i = 0;
    L7:
        if (i >= this.mTrustListeners.size()) goto L21;
        this.mTrustListeners.get(i).onTrustError(message);     // Catch: RemoteException -> L10 DeadObjectException -> L12 FrozenObjectException -> L14
    L10:
        e = move-exception;
        Slogf.e(TAG, "Exception while notifying TrustListener.", e);
    L19:
        i = i + 1;
    L17:
        Slogf.d(TAG, "Removing dead TrustListener.");
        this.mTrustListeners.remove(i);
        i = i - 1;
        goto L19
    }

    private long[] getBiometricSids(int userId) {
        BiometricManager biometricManager = (BiometricManager) this.mContext.getSystemService(BiometricManager.class);
        if (biometricManager != null) goto L7;
        return new long[0];
    L7:
        return biometricManager.getAuthenticatorIds(userId);
    }

    private boolean isWeakUnlockMethodEnabled(int userId) {
        if (this.mStrongAuthTracker.isBiometricAllowedForUser(false, userId) == false) goto L25;
        DevicePolicyManager dpm = this.mLockPatternUtils.getDevicePolicyManager();
        int disabledFeatures = dpm.getKeyguardDisabledFeatures(null, userId);
        if (this.mFingerprintManager == null) goto L15;
        if ((disabledFeatures & 32) != 0) goto L15;
        if (this.mFingerprintManager.hasEnrolledTemplates(userId) == false) goto L15;
        if (isWeakOrConvenienceSensor((SensorProperties) this.mFingerprintManager.getSensorProperties().get(0)) == false) goto L15;
        Slogf.i(TAG, "User is unlockable by non-strong fingerprint auth");
        return true;
    L15:
        if (this.mFaceManager == null) goto L25;
        if ((disabledFeatures & 128) != 0) goto L25;
        if (this.mFaceManager.hasEnrolledTemplates(userId) == false) goto L25;
        if (isWeakOrConvenienceSensor((SensorProperties) this.mFaceManager.getSensorProperties().get(0)) == false) goto L25;
        Slogf.i(TAG, "User is unlockable by non-strong face auth");
        return true;
    L25:
        if (getUserTrustStateInner(userId) != TrustState.TRUSTABLE) goto L27;
    L32:
        Slogf.i(TAG, "User is unlockable by trust agent");
        return true;
    L27:
        if (isAutomotive() == true) goto L29;
    L31:
        return false;
    L29:
        if (isTrustUsuallyManagedInternal(userId) == false) goto L31;
        goto L31
    }

    private static boolean isWeakOrConvenienceSensor(SensorProperties sensor) {
        if (sensor.getSensorStrength() != 1) goto L5;
        return true;
    L5:
        if (sensor.getSensorStrength() == 0) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        this.mHandler.obtainMessage(7, user.getUserIdentifier(), 0, null).sendToTarget();
    }

    @Override // com.android.server.SystemService
    public void onUserStopped(SystemService.TargetUser user) {
        this.mHandler.obtainMessage(8, user.getUserIdentifier(), 0, null).sendToTarget();
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        this.mHandler.obtainMessage(9, to.getUserIdentifier(), 0, null).sendToTarget();
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        this.mHandler.obtainMessage(11, user.getUserIdentifier(), 0, null).sendToTarget();
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        this.mHandler.obtainMessage(12, user.getUserIdentifier(), 0, null).sendToTarget();
    }

    private static /* synthetic */ void lambda$waitForIdle$1() {
    }

    void waitForIdle() {
        this.mHandler.runWithScissors(new TrustManagerService$$ExternalSyntheticLambda1(), 0);
    }

    private boolean isTrustUsuallyManagedInternal(int userId) {
        SparseBooleanArray r0 = this.mTrustUsuallyManagedForUser;
        monitor-enter(r0);
        int i = this.mTrustUsuallyManagedForUser.indexOfKey(userId);     // Catch: Throwable -> L9
        if (i < 0) goto L12;
        boolean r2 = this.mTrustUsuallyManagedForUser.valueAt(i);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        boolean persistedValue = this.mLockPatternUtils.isTrustUsuallyManaged(userId);
        SparseBooleanArray r3 = this.mTrustUsuallyManagedForUser;
        monitor-enter(r3);
        int i2 = this.mTrustUsuallyManagedForUser.indexOfKey(userId);     // Catch: Throwable -> L20
        if (i2 < 0) goto L22;
        boolean r4 = this.mTrustUsuallyManagedForUser.valueAt(i2);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return r4;
    L22:
        this.mTrustUsuallyManagedForUser.put(userId, persistedValue);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return persistedValue;
    L20:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }

    private int resolveProfileParent(int userId) {
        long identity = Binder.clearCallingIdentity();
        UserInfo parent = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L8
        if (parent == null) goto L10;
        int r3 = parent.getUserHandle().getIdentifier();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return r3;
    L10:
        Binder.restoreCallingIdentity(identity);
        return userId;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private Handler createHandler(final Looper looper) {
        return new AnonymousClass4(this, looper);
    }

    private void notifyDeviceLockedListenersForUser(final int userId, final boolean locked) {
        RemoteCallbackList<IDeviceLockedStateListener> r0 = this.mDeviceLockedStateListeners;
        monitor-enter(r0);
        int numListeners = this.mDeviceLockedStateListeners.beginBroadcast();     // Catch: Throwable -> L10
        IntStream.range(0, numListeners).forEach(new TrustManagerService$$ExternalSyntheticLambda2(this, userId, locked));     // Catch: Throwable -> L12
        this.mDeviceLockedStateListeners.finishBroadcast();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        this.mDeviceLockedStateListeners.finishBroadcast();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notifyDeviceLockedListenersForUser$2(int userId, boolean locked, int i) {
        Integer uid = (Integer) this.mDeviceLockedStateListeners.getBroadcastCookie(i);     // Catch: RemoteException -> L6
        if (userId != uid.intValue()) goto L13;
        this.mDeviceLockedStateListeners.getBroadcastItem(i).onDeviceLockedStateChanged(locked);     // Catch: RemoteException -> L6
        return;
    L13:
        return;
    L6:
        re = move-exception;
        Log.i(TAG, "Service died", re);
    }
}
