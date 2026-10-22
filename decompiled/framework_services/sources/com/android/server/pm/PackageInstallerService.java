package com.android.server.pm;

import android.R;
import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PackageDeleteObserver;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.IPackageInstaller;
import android.content.pm.IPackageInstallerCallback;
import android.content.pm.IPackageInstallerSession;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.VersionedPackage;
import android.content.pm.parsing.FrameworkParsingPackageUtils;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelableException;
import android.os.RemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SELinux;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.ExceptionUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SeempLog;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.util.ImageUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.SystemServiceManager;
import com.android.server.am.HostingRecord;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.utils.RequestThrottle;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import com.obric.server.memorydata.MemoryManagerService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInstallerService extends IPackageInstaller.Stub implements PackageSessionProvider {
    private static final int ADB_DEV_MODE = 36;
    private static final boolean DEBUG = false;
    private static final int HISTORICAL_CLEAR_SIZE = 400;
    private static final int HISTORICAL_SESSIONS_THRESHOLD = 500;
    public static final Set<String> INSTALLER_CHANGEABLE_APP_OP_PERMISSIONS = null;
    private static final boolean LOGD = false;
    private static final long MAX_ACTIVE_SESSIONS_NO_PERMISSION = 50;
    private static final long MAX_ACTIVE_SESSIONS_WITH_PERMISSION = 1024;
    private static final long MAX_AGE_MILLIS = 259200000;
    private static final long MAX_HISTORICAL_SESSIONS = 1048576;
    private static final long MAX_INSTALL_CONSTRAINTS_TIMEOUT_MILLIS = 604800000;
    private static final long MAX_SESSION_AGE_ON_LOW_STORAGE_MILLIS = 28800000;
    private static final long MAX_TIME_SINCE_UPDATE_MILLIS = 1814400000;
    private static final String ROLE_SYSTEM_APP_PROTECTION_SERVICE = "android.app.role.SYSTEM_APP_PROTECTION_SERVICE";
    private static final String TAG = "PackageInstaller";
    private static final String TAG_SESSIONS = "sessions";
    private static final FilenameFilter sStageFilter = null;
    private final SparseBooleanArray mAllocatedSessions;
    private final ApexManager mApexManager;
    private AppOpsManager mAppOps;
    private volatile boolean mBypassNextAllowedApexUpdateCheck;
    private volatile boolean mBypassNextStagedInstallerCheck;
    private final Callbacks mCallbacks;
    private final Context mContext;
    private volatile int mDisableVerificationForUid;
    private final GentleUpdateHelper mGentleUpdateHelper;
    private final List<PackageInstallerHistoricalSession> mHistoricalSessions;
    private final SparseIntArray mHistoricalSessionsByInstaller;
    private final InstallDependencyHelper mInstallDependencyHelper;
    private final Handler mInstallHandler;
    private final HandlerThread mInstallThread;
    private final InternalCallback mInternalCallback;
    private final SparseBooleanArray mLegacySessions;
    private volatile boolean mOkToSendBroadcasts;
    final PackageArchiver mPackageArchiver;
    private final PackageManagerService mPm;
    private final Random mRandom;
    private final PackageSessionVerifier mSessionVerifier;
    private final SparseArray<PackageInstallerSession> mSessions;
    private final File mSessionsDir;
    private final AtomicFile mSessionsFile;
    private final RequestThrottle mSettingsWriteRequest;
    private final SilentUpdatePolicy mSilentUpdatePolicy;
    private final StagingManager mStagingManager;

    private static final class BroadcastCookie {
        public final int callingUid;
        public final IntPredicate userCheck;

        BroadcastCookie(int callingUid, IntPredicate userCheck) {
            this.callingUid = callingUid;
            this.userCheck = userCheck;
        }
    }

    private class Callbacks extends Handler {
        private static final int MSG_SESSION_ACTIVE_CHANGED = 3;
        private static final int MSG_SESSION_BADGING_CHANGED = 2;
        private static final int MSG_SESSION_CREATED = 1;
        private static final int MSG_SESSION_FINISHED = 5;
        private static final int MSG_SESSION_PROGRESS_CHANGED = 4;
        private final RemoteCallbackList<IPackageInstallerCallback> mCallbacks;
        final /* synthetic */ PackageInstallerService this$0;

        /* JADX INFO: renamed from: -$$Nest$mnotifySessionActiveChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6741$$Nest$mnotifySessionActiveChanged(Callbacks r0, int r1, int r2, boolean r3) {
            r0.notifySessionActiveChanged(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifySessionBadgingChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6742$$Nest$mnotifySessionBadgingChanged(Callbacks r0, int r1, int r2) {
            r0.notifySessionBadgingChanged(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifySessionCreated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6743$$Nest$mnotifySessionCreated(Callbacks r0, int r1, int r2) {
            r0.notifySessionCreated(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifySessionProgressChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6744$$Nest$mnotifySessionProgressChanged(Callbacks r0, int r1, int r2, float r3) {
            r0.notifySessionProgressChanged(r1, r2, r3);
        }

        public Callbacks(PackageInstallerService r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
            this.mCallbacks = new RemoteCallbackList();
        }

        public void register(IPackageInstallerCallback callback, BroadcastCookie cookie) {
            this.mCallbacks.register(callback, cookie);
        }

        public void unregister(IPackageInstallerCallback callback) {
            this.mCallbacks.unregister(callback);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int sessionId = msg.arg1;
            int userId = msg.arg2;
            int n = this.mCallbacks.beginBroadcast();
            Computer snapshot = PackageInstallerService.m6732$$Nest$fgetmPm(this.this$0).snapshotComputer();
            int i = 0;
        L3:
            if (i >= n) goto L12;
            IPackageInstallerCallback callback = (IPackageInstallerCallback) this.mCallbacks.getBroadcastItem(i);
            BroadcastCookie cookie = (BroadcastCookie) this.mCallbacks.getBroadcastCookie(i);
            if (cookie.userCheck.test(userId) == false) goto L11;
            if (PackageInstallerService.m6740$$Nest$mshouldFilterSession(this.this$0, snapshot, cookie.callingUid, sessionId) == true) goto L11;
            invokeCallback(callback, msg);     // Catch: RemoteException -> L10
        L11:
            i = i + 1;
            goto L3
        L12:
            this.mCallbacks.finishBroadcast();
        }

        private void invokeCallback(IPackageInstallerCallback callback, Message msg) throws RemoteException {
            int sessionId = msg.arg1;
            switch(msg.what) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                default: goto L15;
            };
        L5:
            callback.onSessionFinished(sessionId, ((Boolean) msg.obj).booleanValue());
            return;
        L6:
            callback.onSessionProgressChanged(sessionId, ((Float) msg.obj).floatValue());
            return;
        L7:
            callback.onSessionActiveChanged(sessionId, ((Boolean) msg.obj).booleanValue());
            return;
        L8:
            callback.onSessionBadgingChanged(sessionId);
            return;
        L9:
            callback.onSessionCreated(sessionId);
            return;
        }

        private void notifySessionCreated(int sessionId, int userId) {
            obtainMessage(1, sessionId, userId).sendToTarget();
        }

        private void notifySessionBadgingChanged(int sessionId, int userId) {
            obtainMessage(2, sessionId, userId).sendToTarget();
        }

        private void notifySessionActiveChanged(int sessionId, int userId, boolean active) {
            obtainMessage(3, sessionId, userId, Boolean.valueOf(active)).sendToTarget();
        }

        private void notifySessionProgressChanged(int sessionId, int userId, float progress) {
            obtainMessage(4, sessionId, userId, Float.valueOf(progress)).sendToTarget();
        }

        public void notifySessionFinished(int sessionId, int userId, boolean success) {
            obtainMessage(5, sessionId, userId, Boolean.valueOf(success)).sendToTarget();
        }
    }

    public class InternalCallback {
        final /* synthetic */ PackageInstallerService this$0;

        public InternalCallback(PackageInstallerService this$0) {
            this.this$0 = this$0;
        }

        public void onSessionBadgingChanged(PackageInstallerSession session) {
            Callbacks.m6742$$Nest$mnotifySessionBadgingChanged(PackageInstallerService.m6728$$Nest$fgetmCallbacks(this.this$0), session.sessionId, session.userId);
            PackageInstallerService.m6734$$Nest$fgetmSettingsWriteRequest(this.this$0).schedule();
        }

        public void onSessionActiveChanged(PackageInstallerSession session, boolean active) {
            Callbacks.m6741$$Nest$mnotifySessionActiveChanged(PackageInstallerService.m6728$$Nest$fgetmCallbacks(this.this$0), session.sessionId, session.userId, active);
        }

        public void onSessionProgressChanged(PackageInstallerSession session, float progress) {
            Callbacks.m6744$$Nest$mnotifySessionProgressChanged(PackageInstallerService.m6728$$Nest$fgetmCallbacks(this.this$0), session.sessionId, session.userId, progress);
        }

        public void onSessionChanged(PackageInstallerSession session) {
            session.markUpdated();
            PackageInstallerService.m6734$$Nest$fgetmSettingsWriteRequest(this.this$0).schedule();
            if (PackageInstallerService.m6731$$Nest$fgetmOkToSendBroadcasts(this.this$0) == true) goto L5;
            return;
        L5:
            if (session.isDestroyed() == false) goto L7;
            return;
        L7:
            if (session.isStaged() == false) goto L12;
            PackageInstallerService.m6739$$Nest$msendSessionUpdatedBroadcast(this.this$0, session.generateInfoForCaller(false, 1000), session.userId);
            return;
        }

        public void onSessionFinished(final PackageInstallerSession session, final boolean success) {
            if (success == false) goto L4;
            PackageInstallerService.m6728$$Nest$fgetmCallbacks(this.this$0).notifySessionFinished(session.sessionId, session.userId, success);
        L4:
            PackageInstallerService.m6730$$Nest$fgetmInstallHandler(this.this$0).post(new AnonymousClass1(this, session, success));
        }

        public void onSessionPrepared(PackageInstallerSession session) {
            PackageInstallerService.m6734$$Nest$fgetmSettingsWriteRequest(this.this$0).schedule();
        }

        public void onSessionSealedBlocking(PackageInstallerSession session) {
            PackageInstallerService.m6734$$Nest$fgetmSettingsWriteRequest(this.this$0).runNow();
        }
    }

    private static final class Lifecycle extends SystemService {
        private final PackageInstallerService mPackageInstallerService;

        Lifecycle(Context context, PackageInstallerService service) {
            super(context);
            this.mPackageInstallerService = service;
        }

        @Override // com.android.server.SystemService
        public void onStart() {
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 550) goto L6;
            PackageInstallerService.m6737$$Nest$monBroadcastReady(this.mPackageInstallerService);
            return;
        }
    }

    static class PackageDeleteObserverAdapter extends PackageDeleteObserver {
        private final Context mContext;
        private final int mFlags;
        private final Notification mNotification;
        private final PackageArchiver mPackageArchiver;
        private final String mPackageName;
        private final IntentSender mTarget;
        private final int mUserId;

        public static /* synthetic */ String $r8$lambda$hNnPztBEJi9YVNB7bd_4FShKIvA(PackageDeleteObserverAdapter r0) {
            return r0.lambda$getDeviceOwnerDeletedPackageMsg$0();
        }

        PackageDeleteObserverAdapter(Context context, IntentSender target, String packageName, boolean showNotification, int userId) {
            this(context, target, packageName, showNotification, userId, null, 0);
        }

        PackageDeleteObserverAdapter(Context context, IntentSender target, String packageName, boolean showNotification, int userId, PackageArchiver packageArchiver, int flags) {
            this.mContext = context;
            this.mTarget = target;
            this.mPackageName = packageName;
            if (showNotification == false) goto L5;
            this.mNotification = PackageInstallerService.buildSuccessNotification(this.mContext, getDeviceOwnerDeletedPackageMsg(), packageName, userId);
        L6:
            this.mUserId = userId;
            this.mPackageArchiver = packageArchiver;
            this.mFlags = flags;
            return;
        L5:
            this.mNotification = null;
            goto L6
        }

        private String getDeviceOwnerDeletedPackageMsg() {
            long ident = Binder.clearCallingIdentity();
            DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class);     // Catch: Throwable -> L6
            String r3 = dpm.getResources().getString("Core.PACKAGE_DELETED_BY_DO", new PackageInstallerService$PackageDeleteObserverAdapter$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        private /* synthetic */ String lambda$getDeviceOwnerDeletedPackageMsg$0() {
            return this.mContext.getString(R.string.permdesc_use_exact_alarm);
        }

        public void onUserActionRequired(Intent intent) {
            if (this.mTarget != null) goto L5;
            return;
        L5:
            Intent fillIn = new Intent();
            fillIn.putExtra("android.content.pm.extra.PACKAGE_NAME", this.mPackageName);
            fillIn.putExtra("android.content.pm.extra.STATUS", -1);
            fillIn.putExtra("android.intent.extra.INTENT", intent);
            BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L8
            options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L8
            this.mTarget.sendIntent(this.mContext, 0, fillIn, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L8
            return;
        }

        public void onPackageDeleted(String basePackageName, int returnCode, String msg) {
            if (1 != returnCode) goto L8;
            if (this.mNotification == null) goto L8;
            NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            notificationManager.notify(basePackageName, 21, this.mNotification);
        L8:
            if (this.mPackageArchiver == null) goto L14;
            if (1 == returnCode) goto L14;
            if ((this.mFlags & 16) == 0) goto L14;
            this.mPackageArchiver.clearArchiveState(this.mPackageName, this.mUserId);
        L14:
            if (this.mTarget != null) goto L16;
            return;
        L16:
            Intent fillIn = new Intent();
            fillIn.putExtra("android.content.pm.extra.PACKAGE_NAME", this.mPackageName);
            fillIn.putExtra("android.content.pm.extra.STATUS", PackageManager.deleteStatusToPublicStatus(returnCode));
            fillIn.putExtra("android.content.pm.extra.STATUS_MESSAGE", PackageManager.deleteStatusToString(returnCode, msg));
            fillIn.putExtra("android.content.pm.extra.LEGACY_STATUS", returnCode);
            BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L19
            options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L19
            this.mTarget.sendIntent(this.mContext, 0, fillIn, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L19
            return;
        }
    }

    static class ParentChildSessionMap {
        private final Comparator<PackageInstallerSession> mSessionCreationComparator;
        private final TreeMap<PackageInstallerSession, TreeSet<PackageInstallerSession>> mSessionMap;

        public static /* synthetic */ long $r8$lambda$GF22nS7Qs_ierPHIUES5T2p5q_A(PackageInstallerSession r2) {
            return lambda$new$0(r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$u1-kmM7EaM41j3EHPEBqKs9rReI, reason: not valid java name */
        public static /* synthetic */ int m6745$r8$lambda$u1kmM7EaM41j3EHPEBqKs9rReI(PackageInstallerSession r0) {
            return lambda$new$1(r0);
        }

        private static /* synthetic */ long lambda$new$0(PackageInstallerSession sess) {
            if (sess != null) goto L6;
            return -1;
        L6:
            return sess.createdMillis;
        }

        private static /* synthetic */ int lambda$new$1(PackageInstallerSession sess) {
            if (sess != null) goto L6;
            return -1;
        L6:
            return sess.sessionId;
        }

        ParentChildSessionMap() {
            this.mSessionCreationComparator = Comparator.comparingLong(new PackageInstallerService$ParentChildSessionMap$$ExternalSyntheticLambda0()).thenComparingInt(new PackageInstallerService$ParentChildSessionMap$$ExternalSyntheticLambda1());
            this.mSessionMap = new TreeMap(this.mSessionCreationComparator);
        }

        boolean containsSession() {
            return !this.mSessionMap.isEmpty();
        }

        private void addParentSession(PackageInstallerSession session) {
            if (this.mSessionMap.containsKey(session) == true) goto L6;
            this.mSessionMap.put(session, new TreeSet(this.mSessionCreationComparator));
            return;
        }

        private void addChildSession(PackageInstallerSession session, PackageInstallerSession parentSession) {
            addParentSession(parentSession);
            this.mSessionMap.get(parentSession).add(session);
        }

        void addSession(PackageInstallerSession session, PackageInstallerSession parentSession) {
            if (session.hasParentSessionId() == false) goto L5;
            addChildSession(session, parentSession);
            return;
        L5:
            addParentSession(session);
        }

        void dump(String tag, IndentingPrintWriter pw) {
            pw.println(tag + " install sessions:");
            pw.increaseIndent();
            Iterator<Map.Entry<PackageInstallerSession, TreeSet<PackageInstallerSession>>> r0 = this.mSessionMap.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L13;
            Map.Entry<PackageInstallerSession, TreeSet<PackageInstallerSession>> entry = r0.next();
            PackageInstallerSession parentSession = entry.getKey();
            if (parentSession == null) goto L8;
            pw.print(tag + " ");
            parentSession.dump(pw);
            pw.println();
            pw.increaseIndent();
        L8:
            Iterator<PackageInstallerSession> r3 = entry.getValue().iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            PackageInstallerSession childSession = r3.next();
            pw.print(tag + " Child ");
            childSession.dump(pw);
            pw.println();
            goto L10
        L12:
            pw.decreaseIndent();
            goto L4
        L13:
            pw.println();
            pw.decreaseIndent();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$5BGglUfl9HvL3D5V1sZPxjvg-qk, reason: not valid java name */
    public static /* synthetic */ String m6722$r8$lambda$5BGglUfl9HvL3D5V1sZPxjvgqk(PackageInstallerService r0, int r1) {
        return r0.lambda$isSystemAppProtectionRoleHolder$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5JSFIXErxJYX5g1H-eDAdRoQbDM, reason: not valid java name */
    public static /* synthetic */ void m6723$r8$lambda$5JSFIXErxJYX5g1HeDAdRoQbDM(PackageInstallerService r0, VersionedPackage r1, PackageDeleteObserverAdapter r2, int r3, int r4) {
        r0.lambda$uninstall$4(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$9JcdCkjEXbZhEv1lLVaJ7PYSs1o(PackageInstallerService r0, Computer r1, int r2, PackageInstaller.SessionInfo r3) {
        return r0.lambda$getStagedSessions$1(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$IsWteF3jo_zvtDryir4OvsCAgBU(PackageInstallerService r0, Computer r1, int r2, PackageInstaller.SessionInfo r3) {
        return r0.lambda$getHistoricalSessions$3(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$KKlPn0QYNfoCKBd_pb1NZFXk-RQ, reason: not valid java name */
    public static /* synthetic */ boolean m6724$r8$lambda$KKlPn0QYNfoCKBd_pb1NZFXkRQ(int r0, int r1) {
        return lambda$registerCallback$8(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OhY-ca6Inhh15HdNzu2YfcJrzYU, reason: not valid java name */
    public static /* synthetic */ boolean m6725$r8$lambda$OhYca6Inhh15HdNzu2YfcJrzYU(PackageInstallerService r0, Computer r1, int r2, PackageInstaller.SessionInfo r3) {
        return r0.lambda$getAllSessions$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$mF4Pn7tOjO0TfGLhqagHksstTYE(PackageInstallerService r0, List r1, PackageInstaller.InstallConstraints r2, IntentSender r3, PackageInstaller.InstallConstraintsResult r4) {
        r0.lambda$waitForInstallConstraints$7(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$swWvh-INaudF9yud2iLs6ys3UHc, reason: not valid java name */
    public static /* synthetic */ void m6726$r8$lambda$swWvhINaudF9yud2iLs6ys3UHc(RemoteCallback r0, PackageInstaller.InstallConstraintsResult r1) {
        lambda$checkInstallConstraints$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$u9klzBPJX7UOBx7yrSKn10eR-r8, reason: not valid java name */
    public static /* synthetic */ void m6727$r8$lambda$u9klzBPJX7UOBx7yrSKn10eRr8(PackageInstallerService r0, PackageInstaller.SessionParams r1, String r2, int r3, PackageManagerShellCommandDataLoader.Metadata r4, IntentSender r5, ArchivedPackageParcel r6) {
        r0.lambda$installPackageArchived$9(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Boolean $r8$lambda$wY7L0Z422az4MHHhP9QFuryN2S8(PackageInstallerService r0) {
        return r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callbacks m6728$$Nest$fgetmCallbacks(PackageInstallerService r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstallDependencyHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ InstallDependencyHelper m6729$$Nest$fgetmInstallDependencyHelper(PackageInstallerService r0) {
        return r0.mInstallDependencyHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstallHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6730$$Nest$fgetmInstallHandler(PackageInstallerService r0) {
        return r0.mInstallHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOkToSendBroadcasts, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6731$$Nest$fgetmOkToSendBroadcasts(PackageInstallerService r0) {
        return r0.mOkToSendBroadcasts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPm, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerService m6732$$Nest$fgetmPm(PackageInstallerService r0) {
        return r0.mPm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m6733$$Nest$fgetmSessions(PackageInstallerService r0) {
        return r0.mSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingsWriteRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ RequestThrottle m6734$$Nest$fgetmSettingsWriteRequest(PackageInstallerService r0) {
        return r0.mSettingsWriteRequest;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStagingManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ StagingManager m6735$$Nest$fgetmStagingManager(PackageInstallerService r0) {
        return r0.mStagingManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildAppIconFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m6736$$Nest$mbuildAppIconFile(PackageInstallerService r0, int r1) {
        return r0.buildAppIconFile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monBroadcastReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6737$$Nest$monBroadcastReady(PackageInstallerService r0) {
        r0.onBroadcastReady();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveActiveSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6738$$Nest$mremoveActiveSession(PackageInstallerService r0, PackageInstallerSession r1) {
        r0.removeActiveSession(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendSessionUpdatedBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6739$$Nest$msendSessionUpdatedBroadcast(PackageInstallerService r0, PackageInstaller.SessionInfo r1, int r2) {
        r0.sendSessionUpdatedBroadcast(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldFilterSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6740$$Nest$mshouldFilterSession(PackageInstallerService r0, Computer r1, int r2, int r3) {
        return r0.shouldFilterSession(r1, r2, r3);
    }

    static {
        LOGD = Log.isLoggable(TAG, 3);
        DEBUG = Build.IS_DEBUGGABLE;
        INSTALLER_CHANGEABLE_APP_OP_PERMISSIONS = Set.of("android.permission.USE_FULL_SCREEN_INTENT");
        sStageFilter = new AnonymousClass1();
    }

    private /* synthetic */ Boolean lambda$new$0() {
        return Boolean.valueOf(writeSessions());
    }

    public PackageInstallerService(Context context, PackageManagerService pm, Supplier<PackageParser2> apexParserSupplier) {
        this.mOkToSendBroadcasts = false;
        this.mBypassNextStagedInstallerCheck = false;
        this.mBypassNextAllowedApexUpdateCheck = false;
        this.mDisableVerificationForUid = -1;
        this.mInternalCallback = new InternalCallback(this);
        this.mRandom = new SecureRandom();
        this.mAllocatedSessions = new SparseBooleanArray();
        this.mSessions = new SparseArray();
        this.mHistoricalSessions = new ArrayList();
        this.mHistoricalSessionsByInstaller = new SparseIntArray();
        this.mLegacySessions = new SparseBooleanArray();
        this.mSilentUpdatePolicy = new SilentUpdatePolicy();
        this.mSettingsWriteRequest = new RequestThrottle(IoThread.getHandler(), new PackageInstallerService$$ExternalSyntheticLambda9(this));
        this.mContext = context;
        this.mPm = pm;
        this.mInstallThread = new HandlerThread(TAG);
        this.mInstallThread.start();
        this.mInstallHandler = new Handler(this.mInstallThread.getLooper());
        this.mCallbacks = new Callbacks(this, this.mInstallThread.getLooper());
        this.mSessionsFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), "install_sessions.xml"), "package-session");
        this.mSessionsDir = new File(Environment.getDataSystemDirectory(), "install_sessions");
        this.mSessionsDir.mkdirs();
        this.mApexManager = ApexManager.getInstance();
        this.mStagingManager = new StagingManager(context);
        this.mSessionVerifier = new PackageSessionVerifier(context, this.mPm, this.mApexManager, apexParserSupplier, this.mInstallThread.getLooper());
        this.mGentleUpdateHelper = new GentleUpdateHelper(context, this.mInstallThread.getLooper(), new AppStateHelper(context));
        this.mPackageArchiver = new PackageArchiver(this.mContext, this.mPm);
        this.mInstallDependencyHelper = new InstallDependencyHelper(this.mContext, this.mPm.mInjector.getSharedLibrariesImpl(), this);
        ((SystemServiceManager) LocalServices.getService(SystemServiceManager.class)).startService(new Lifecycle(context, this));
    }

    StagingManager getStagingManager() {
        return this.mStagingManager;
    }

    InstallDependencyHelper getInstallDependencyHelper() {
        return this.mInstallDependencyHelper;
    }

    boolean okToSendBroadcasts() {
        return this.mOkToSendBroadcasts;
    }

    public void systemReady() {
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mStagingManager.systemReady();
        this.mGentleUpdateHelper.systemReady();
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        readSessionsLocked();     // Catch: Throwable -> L8
        expireSessionsLocked();     // Catch: Throwable -> L8
        reconcileStagesLocked(StorageManager.UUID_PRIVATE_INTERNAL);     // Catch: Throwable -> L8
        ArraySet<File> unclaimedIcons = newArraySet(this.mSessionsDir.listFiles());     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mSessions.size()) goto L10;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L8
        unclaimedIcons.remove(buildAppIconFile(session.sessionId));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        Iterator<File> r2 = unclaimedIcons.iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        File icon = r2.next();     // Catch: Throwable -> L8
        Slog.w(TAG, "Deleting orphan icon " + icon);     // Catch: Throwable -> L8
        icon.delete();     // Catch: Throwable -> L8
        goto L12
    L14:
        this.mSettingsWriteRequest.runNow();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onBroadcastReady() {
        this.mOkToSendBroadcasts = true;
    }

    void restoreAndApplyStagedSessionIfNeeded() {
        List<StagingManager.StagedSession> stagedSessionsToRestore = new ArrayList();
        SparseArray<PackageInstallerSession> r1 = this.mSessions;
        monitor-enter(r1);
        int i = 0;
    L33:
    L17:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSessions.size()) goto L28;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L17
        if (session.isStaged() == false) goto L26;
        StagingManager.StagedSession stagedSession = session.mStagedSession;     // Catch: Throwable -> L17
        if (stagedSession.isInTerminalState() == true) goto L20;
        if (stagedSession.hasParentSessionId() == false) goto L20;
        if (getSession(stagedSession.getParentSessionId()) != null) goto L20;
        stagedSession.setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "An orphan staged session " + stagedSession.sessionId() + " is found, parent " + stagedSession.getParentSessionId() + " is missing");     // Catch: Throwable -> L17
    L20:
        if (stagedSession.hasParentSessionId() == true) goto L26;
        if (stagedSession.isCommitted() == false) goto L26;
        if (stagedSession.isInTerminalState() == true) goto L26;
        stagedSessionsToRestore.add(stagedSession);     // Catch: Throwable -> L17
    L26:
        i = i + 1;     // Catch: Throwable -> L17
        goto L33
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L17
        this.mStagingManager.restoreSessions(stagedSessionsToRestore, this.mPm.isDeviceUpgrading());
    }

    private void reconcileStagesLocked(String volumeUuid) {
        ArraySet<File> unclaimedStages = getStagingDirsOnVolume(volumeUuid);
        int i = 0;
    L4:
        if (i >= this.mSessions.size()) goto L6;
        PackageInstallerSession session = this.mSessions.valueAt(i);
        unclaimedStages.remove(session.stageDir);
        i = i + 1;
        goto L4
    L6:
        removeStagingDirs(unclaimedStages);
    }

    private ArraySet<File> getStagingDirsOnVolume(String volumeUuid) {
        File stagingDir = getTmpSessionDir(volumeUuid);
        ArraySet<File> stagingDirs = newArraySet(stagingDir.listFiles(sStageFilter));
        File stagedSessionStagingDir = Environment.getDataStagingDirectory(volumeUuid);
        stagingDirs.addAll(newArraySet(stagedSessionStagingDir.listFiles()));
        return stagingDirs;
    }

    private void removeStagingDirs(ArraySet<File> stagingDirsToRemove) {
        Iterator<File> r0 = stagingDirsToRemove.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        File stage = r0.next();
        Slog.w(TAG, "Deleting orphan stage " + stage);
        this.mPm.removeCodePath(stage);
        goto L4
    }

    public void onPrivateVolumeMounted(String volumeUuid) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        reconcileStagesLocked(volumeUuid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void freeStageDirs(String volumeUuid) {
        ArraySet<File> unclaimedStagingDirsOnVolume = getStagingDirsOnVolume(volumeUuid);
        long currentTimeMillis = System.currentTimeMillis();
        SparseArray<PackageInstallerSession> r3 = this.mSessions;
        monitor-enter(r3);
        int i = 0;
    L32:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSessions.size()) goto L27;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L18
        if (unclaimedStagingDirsOnVolume.contains(session.stageDir) == false) goto L25;
        long age = currentTimeMillis - session.createdMillis;     // Catch: Throwable -> L18
        if (age >= MAX_SESSION_AGE_ON_LOW_STORAGE_MILLIS) goto L13;
        unclaimedStagingDirsOnVolume.remove(session.stageDir);     // Catch: Throwable -> L18
        goto L25
    L13:
        if (session.hasParentSessionId() == true) goto L15;
        PackageInstallerSession root = session;
    L16:
        if (root != null) goto L21;
        Slog.e(TAG, "freeStageDirs: found an orphaned session: " + session.sessionId + " parent=" + session.getParentSessionId());     // Catch: Throwable -> L18
        goto L25
    L21:
        if (root.isDestroyed() == true) goto L25;
        root.abandon();     // Catch: Throwable -> L18
        goto L25
    L15:
        root = this.mSessions.get(session.getParentSessionId());     // Catch: Throwable -> L18
    L25:
        i = i + 1;     // Catch: Throwable -> L18
        goto L32
    L27:
        monitor-exit(r3);     // Catch: Throwable -> L18
        removeStagingDirs(unclaimedStagingDirsOnVolume);
    }

    @Deprecated
    public File allocateStageDirLegacy(String volumeUuid, boolean isEphemeral) throws IOException {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        int sessionId = allocateSessionIdLocked();     // Catch: Throwable -> L7 IllegalStateException -> L9
        this.mLegacySessions.put(sessionId, true);     // Catch: Throwable -> L7 IllegalStateException -> L9
        File sessionStageDir = buildTmpSessionDir(sessionId, volumeUuid);     // Catch: Throwable -> L7 IllegalStateException -> L9
        prepareStageDir(sessionStageDir);     // Catch: Throwable -> L7 IllegalStateException -> L9
        monitor-exit(r0);     // Catch: Throwable -> L7
        return sessionStageDir;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L7
    }

    @Deprecated
    public String allocateExternalStageCidLegacy() {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        int sessionId = allocateSessionIdLocked();     // Catch: Throwable -> L7
        this.mLegacySessions.put(sessionId, true);     // Catch: Throwable -> L7
        String r2 = "smdl" + sessionId + ".tmp";     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private void readSessionsLocked() {
        if (LOGD == false) goto L5;
        Slog.v(TAG, "readSessionsLocked()");
    L5:
        this.mSessions.clear();
        TypedXmlPullParser in = null;
        TypedXmlPullParser r0 = this.mSessionsFile.openRead();     // Catch: Throwable -> L28 Throwable -> L30 FileNotFoundException -> L32
        goto L36
    L46:
        in = Xml.resolvePullParser(r0);     // Catch: Throwable -> L17 Throwable -> L19 FileNotFoundException -> L21
    L9:
        int type = in.next();     // Catch: Throwable -> L17 Throwable -> L19 FileNotFoundException -> L21
        if (type == 1) goto L27;
        if (type != 2) goto L9;
        String tag = in.getName();     // Catch: Throwable -> L17 Throwable -> L19 FileNotFoundException -> L21
        if ("session".equals(tag) == false) goto L9;
        PackageInstallerSession session = PackageInstallerSession.readFromXml(in, this.mInternalCallback, this.mContext, this.mPm, this.mInstallThread.getLooper(), this.mStagingManager, this.mSessionsDir, this, this.mSilentUpdatePolicy, this.mInstallDependencyHelper);     // Catch: Throwable -> L17 Exception -> L23
        this.mSessions.put(session.sessionId, session);     // Catch: Throwable -> L17 Throwable -> L19 Throwable -> L19 Throwable -> L19 FileNotFoundException -> L21
        this.mAllocatedSessions.put(session.sessionId, true);     // Catch: Throwable -> L17 Throwable -> L19 Throwable -> L19 Throwable -> L19 FileNotFoundException -> L21
    L23:
        e = move-exception;
        Slog.e(TAG, "Could not read session", e);     // Catch: Throwable -> L17 Throwable -> L19 Throwable -> L19 Throwable -> L19 FileNotFoundException -> L21
        goto L9
    L27:
        IoUtils.closeQuietly(r0);
    L40:
        int i = 0;
    L42:
        if (i >= this.mSessions.size()) goto L45;
        this.mSessions.valueAt(i).onAfterSessionRead(this.mSessions);
        i = i + 1;
        goto L42
    L45:
        return;
    L17:
        th = th;
        in = r0;
    L37:
        IoUtils.closeQuietly(in);
        throw th;
    L19:
        e = e;
        in = r0;
    L35:
        Slog.wtf(TAG, "Failed reading install sessions", e);     // Catch: Throwable -> L28
    L22:
        in = r0;
    L28:
        th = th;
    L30:
        e = e;
    L36:
        IoUtils.closeQuietly(in);
        goto L40
    }

    private void expireSessionsLocked() {
        SparseArray<PackageInstallerSession> tmp = this.mSessions.clone();
        int n = tmp.size();
        int i = 0;
    L3:
        if (i >= n) goto L25;
        PackageInstallerSession session = tmp.valueAt(i);
        if (session.hasParentSessionId() == true) goto L23;
        long age = System.currentTimeMillis() - session.createdMillis;
        long timeSinceUpdate = System.currentTimeMillis() - session.getUpdatedMillis();
        if (session.isStaged() == false) goto L18;
        if (session.isStagedAndInTerminalState() == true) goto L12;
    L15:
        boolean valid = true;
    L21:
        if (valid == true) goto L23;
        Slog.w(TAG, "Remove old session: " + session.sessionId);
        removeActiveSession(session);
        goto L23
    L12:
        if (timeSinceUpdate < MAX_TIME_SINCE_UPDATE_MILLIS) goto L15;
        valid = false;
        goto L21
    L18:
        if (age < MAX_AGE_MILLIS) goto L20;
        Slog.w(TAG, "Abandoning old session created at " + session.createdMillis);
        valid = false;
        goto L21
    L20:
        valid = true;
    L23:
        i = i + 1;
        goto L3
    }

    private void removeActiveSession(PackageInstallerSession session) {
        this.mSessions.remove(session.sessionId);
        addHistoricalSessionLocked(session);
        Iterator<PackageInstallerSession> r0 = session.getChildSessions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageInstallerSession child = r0.next();
        this.mSessions.remove(child.sessionId);
        addHistoricalSessionLocked(child);
        goto L4
    }

    private void addHistoricalSessionLocked(PackageInstallerSession session) {
        if (this.mHistoricalSessions.size() <= 500) goto L5;
        Slog.d(TAG, "Historical sessions size reaches threshold, clear the oldest");
        this.mHistoricalSessions.subList(0, 400).clear();
    L5:
        this.mHistoricalSessions.add(session.createHistoricalSession());
        int installerUid = session.getInstallerUid();
        this.mHistoricalSessionsByInstaller.put(installerUid, this.mHistoricalSessionsByInstaller.get(installerUid) + 1);
    }

    private boolean writeSessions() {
        if (LOGD == false) goto L5;
        Slog.v(TAG, "writeSessions()");
    L5:
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        int size = this.mSessions.size();     // Catch: Throwable -> L10
        PackageInstallerSession[] sessions = new PackageInstallerSession[size];     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= size) goto L13;
        sessions[i] = this.mSessions.valueAt(i);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        FileOutputStream fos = null;
        fos = this.mSessionsFile.startWrite();     // Catch: IOException -> L18
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L18
        out.startDocument(null, true);     // Catch: IOException -> L18
        out.startTag(null, TAG_SESSIONS);     // Catch: IOException -> L18
        int r5 = sessions.length;     // Catch: IOException -> L18
        int r7 = 0;
    L16:
        if (r7 >= r5) goto L20;
        PackageInstallerSession session = sessions[r7];     // Catch: IOException -> L18
        session.write(out, this.mSessionsDir);     // Catch: IOException -> L18
        r7 = r7 + 1;     // Catch: IOException -> L18
        goto L16
    L20:
        out.endTag(null, TAG_SESSIONS);     // Catch: IOException -> L18
        out.endDocument();     // Catch: IOException -> L18
        this.mSessionsFile.finishWrite(fos);     // Catch: IOException -> L18
        return true;
    L23:
        if (fos == null) goto L25;
        this.mSessionsFile.failWrite(fos);
    L25:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    private File buildAppIconFile(int sessionId) {
        return new File(this.mSessionsDir, "app_icon." + sessionId + ".png");
    }

    public int createSession(PackageInstaller.SessionParams params, String installerPackageName, String callingAttributionTag, int userId) {
    L17:
        e = e;
    L20:
        throw ExceptionUtils.wrap(e);
    L3:
        if (params.dataLoaderParams != null) goto L21;
    L11:
        params.installFlags &= -536870913;     // Catch: IOException -> L17
        return createSessionInternal(params, installerPackageName, callingAttributionTag, Binder.getCallingUid(), userId);
    L15:
        e = e;
        goto L20
    L21:
    L9:
        e = e;
        goto L20
    L5:
        if (this.mContext.checkCallingOrSelfPermission("com.android.permission.USE_INSTALLER_V2") == 0) goto L11;
        throw new SecurityException("You need the com.android.permission.USE_INSTALLER_V2 permission to use a data loader");     // Catch: IOException -> L9
    }

    int createSessionInternal(PackageInstaller.SessionParams params, String installerPackageName, String installerAttributionTag, int callingUid, int userId) throws IOException {
        SeempLog.record(90);
        Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, true, "createSession");
        if (this.mPm.isUserRestricted(userId, "no_install_apps") == true) goto L332;
        if (params.installReason != 5) goto L14;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_ROLLBACKS") == 0) goto L14;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.TEST_MANAGE_ROLLBACKS") == 0) goto L14;
        throw new SecurityException("INSTALL_REASON_ROLLBACK requires the MANAGE_ROLLBACKS permission or the TEST_MANAGE_ROLLBACKS permission");
    L14:
        if (params.appPackageName != null) goto L16;
    L18:
        params.appLabel = (String) TextUtils.trimToSize(params.appLabel, 1000);
        if (params.installerPackageName != null) goto L21;
    L23:
        if (installerPackageName != null) goto L25;
    L27:
        String installerPackageName2 = installerPackageName;
    L29:
        if (params.installerPackageName == null) goto L31;
        String requestedInstallerPackageName = params.installerPackageName;
    L33:
        if (PackageManagerServiceUtils.isRootOrShell(callingUid) == false) goto L35;
    L55:
        params.installFlags |= 32;
        String installerPackageName3 = "com.android.shell";
    L56:
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (umi == null) goto L62;
        if (umi.exists(10) == false) goto L62;
        Slog.i(TAG, "doppelganger user exists, installFlags &= ~PackageManager.INSTALL_ALL_USERS");
        params.installFlags &= -65;
    L62:
        if (params.originatingUid != (-1)) goto L64;
    L70:
        String originatingPackageName = null;
    L72:
        if (Build.IS_DEBUGGABLE == false) goto L74;
    L77:
        params.installFlags |= 1048576;
    L79:
        if (this.mDisableVerificationForUid == (-1)) goto L86;
        if (callingUid != this.mDisableVerificationForUid) goto L83;
        params.installFlags |= 524288;
    L84:
        this.mDisableVerificationForUid = -1;
    L89:
        if (params.rollbackLifetimeMillis > 0) goto L91;
        long r15 = 0;
        if (params.rollbackLifetimeMillis < 0) goto L330;
    L102:
        if (params.rollbackImpactLevel == 1) goto L112;
        if (params.rollbackImpactLevel == 2) goto L112;
        if (params.rollbackImpactLevel >= 0) goto L116;
        throw new IllegalArgumentException("rollbackImpactLevel can't be negative.");
    L116:
        if ((params.installFlags & 131072) == 0) goto L118;
        boolean r0 = true;
    L119:
        boolean isApex = r0;
        if (isApex == false) goto L129;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGE_UPDATES") == (-1)) goto L124;
    L131:
        if (isApex == false) goto L148;
        if (this.mApexManager.isApexSupported() == false) goto L146;
        if (params.isMultiPackage == true) goto L144;
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == false) goto L139;
    L142:
        params.installFlags |= 8388608;
        goto L148
    L139:
        if (this.mBypassNextAllowedApexUpdateCheck == true) goto L142;
        params.installFlags &= -8388609;
        goto L148
    L144:
        throw new IllegalArgumentException("A multi-session can't be set as APEX.");
    L146:
        throw new IllegalArgumentException("This device doesn't support the installation of APEX files");
    L148:
        if ((params.installFlags & 16777216) != 0) goto L150;
    L156:
        params.installFlags &= -1073741825;
        if (PackageArchiver.isArchivingEnabled() == false) goto L168;
        if (params.appPackageName == null) goto L168;
        PackageStateInternal ps = this.mPm.snapshotComputer().getPackageStateInternal(params.appPackageName, 1000);
        if (ps == null) goto L168;
        if (PackageArchiver.isArchived(ps.getUserStateOrDefault(userId)) == false) goto L168;
        if (TextUtils.equals(PackageArchiver.getResponsibleInstallerPackage(ps), requestedInstallerPackageName) == false) goto L168;
        params.installFlags |= 1073741824;
    L168:
        if ((params.installFlags & 2048) == 0) goto L177;
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == true) goto L177;
        if ((snapshot.getFlagsForUid(callingUid) & 1) != 0) goto L177;
        throw new SecurityException("Only system apps could use the PackageManager.INSTALL_INSTANT_APP flag.");
    L177:
        if (params.isStaged == true) goto L179;
    L187:
        if (isApex == true) goto L189;
    L197:
        this.mBypassNextStagedInstallerCheck = false;
        this.mBypassNextAllowedApexUpdateCheck = false;
        if (params.isMultiPackage == true) goto L253;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_GRANT_RUNTIME_PERMISSIONS") != 0) goto L202;
        boolean hasInstallGrantRuntimePermissions = true;
    L204:
        if ((params.installFlags & 256) == 0) goto L209;
        if (hasInstallGrantRuntimePermissions == true) goto L209;
        throw new SecurityException("You need the android.permission.INSTALL_GRANT_RUNTIME_PERMISSIONS permission to use the PackageManager.INSTALL_GRANT_ALL_REQUESTED_PERMISSIONS flag");
    L209:
        ArrayMap<String, Integer> permissionStates = params.getPermissionStates();
        if (permissionStates.isEmpty() == true) goto L221;
        if (hasInstallGrantRuntimePermissions == true) goto L221;
        int index = 0;
    L214:
        if (index >= permissionStates.size()) goto L221;
        String permissionName = permissionStates.keyAt(index);
        if (INSTALLER_CHANGEABLE_APP_OP_PERMISSIONS.contains(permissionName) == false) goto L219;
        index = index + 1;
        goto L214
    L219:
        throw new SecurityException("You need the android.permission.INSTALL_GRANT_RUNTIME_PERMISSIONS permission to grant runtime permissions for a session");
    L221:
        if (params.appIcon == null) goto L228;
        ActivityManager am = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        int iconSize = am.getLauncherLargeIconSize();
        if (params.appIcon.getWidth() <= (iconSize * 2)) goto L225;
    L226:
        params.appIcon = Bitmap.createScaledBitmap(params.appIcon, iconSize, iconSize, true);
        goto L228
    L225:
        if (params.appIcon.getHeight() > (iconSize * 2)) goto L226;
    L228:
        switch(params.mode) {
            case 1: goto L232;
            case 2: goto L232;
            default: goto L230;
        };
    L230:
        throw new IllegalArgumentException("Invalid install mode: " + params.mode);
    L232:
        if ((params.installFlags & 16) == 0) goto L239;
        if (InstallLocationUtils.fitsOnInternal(this.mContext, params) == true) goto L253;
        throw new IOException("No suitable internal storage available");
    L239:
        if ((params.installFlags & 512) == 0) goto L246;
        params.installFlags |= 16;
        StorageManager.convert(params.volumeUuid);     // Catch: IllegalArgumentException -> L243
    L245:
        throw new IllegalArgumentException("Invalid volumeUuid value in session params: " + params.volumeUuid);
    L246:
        params.installFlags |= 16;
        long ident = Binder.clearCallingIdentity();
        params.volumeUuid = InstallLocationUtils.resolveInstallVolume(this.mContext, params);     // Catch: Throwable -> L249
        Binder.restoreCallingIdentity(ident);
    L249:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L202:
        hasInstallGrantRuntimePermissions = false;
    L253:
        if (requestedInstallerPackageName == null) goto L255;
        int requestedInstallerPackageUid = snapshot.getPackageUid(requestedInstallerPackageName, r15, userId);
        int requestedInstallerPackageUid2 = requestedInstallerPackageUid;
    L257:
        if (requestedInstallerPackageUid2 != (-1)) goto L259;
        String requestedInstallerPackageName2 = null;
    L260:
        SparseArray<PackageInstallerSession> r3 = this.mSessions;
        monitor-enter(r3);
        int activeCount = getSessionCount(this.mSessions, callingUid);     // Catch: Throwable -> L314
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") != 0) goto L272;
        if (activeCount >= 1024) goto L338;
    L273:
        int historicalCount = this.mHistoricalSessionsByInstaller.get(callingUid);     // Catch: Throwable -> L314
        if (historicalCount >= 1048576) goto L318;
        int existingDraftSessionId = getExistingDraftSessionId(requestedInstallerPackageUid2, params, userId);     // Catch: Throwable -> L314
        if (existingDraftSessionId == (-1)) goto L278;
        int r9 = existingDraftSessionId;
    L279:
        int existingDraftSessionId2 = r9;
        monitor-exit(r3);     // Catch: Throwable -> L314
        long createdMillis = System.currentTimeMillis();
        File stageDir = null;
        String stageCid = null;
        if (params.isMultiPackage == true) goto L288;
        if ((params.installFlags & 16) == 0) goto L286;
        stageDir = buildSessionDir(existingDraftSessionId2, params);
        goto L288
    L286:
        stageCid = buildExternalStageCid(existingDraftSessionId2);
    L288:
        if (params.forceQueryableOverride == true) goto L290;
    L292:
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        params.installFlags &= -67108865;
        if (dpmi != null) goto L295;
    L297:
        if (isApex == true) goto L301;
        int requestedInstallerPackageUid3 = requestedInstallerPackageUid2;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ENFORCE_UPDATE_OWNERSHIP") == (-1)) goto L302;
    L303:
        InstallSource installSource = InstallSource.create(installerPackageName3, originatingPackageName, requestedInstallerPackageName2, requestedInstallerPackageUid3, requestedInstallerPackageName2, installerAttributionTag, params.packageSource);
        PackageInstallerSession session = new PackageInstallerSession(this.mInternalCallback, this.mContext, this.mPm, this, this.mSilentUpdatePolicy, this.mInstallThread.getLooper(), this.mStagingManager, existingDraftSessionId2, userId, callingUid, installSource, params, createdMillis, 0, stageDir, stageCid, null, null, false, false, false, false, null, -1, false, false, false, 0, "", null, this.mInstallDependencyHelper);
        SparseArray<PackageInstallerSession> r2 = this.mSessions;
        monitor-enter(r2);
        this.mSessions.put(existingDraftSessionId2, session);     // Catch: Throwable -> L311
        monitor-exit(r2);     // Catch: Throwable -> L311
        this.mPm.addInstallerPackageName(session.getInstallSource());
        Callbacks.m6743$$Nest$mnotifySessionCreated(this.mCallbacks, session.sessionId, session.userId);
        this.mSettingsWriteRequest.schedule();
        if (LOGD == false) goto L310;
        Slog.d(TAG, "Created session id=" + existingDraftSessionId2 + " staged=" + params.isStaged);
    L310:
        return existingDraftSessionId2;
    L311:
        th = move-exception;
        throw th;
    L302:
        params.installFlags &= -33554433;
        goto L303
    L301:
        requestedInstallerPackageUid3 = requestedInstallerPackageUid2;
        goto L302
    L295:
        if (dpmi.isUserOrganizationManaged(userId) == false) goto L297;
        params.installFlags |= 67108864;
        goto L297
    L290:
        if (PackageManagerServiceUtils.isRootOrShell(callingUid) == true) goto L292;
        params.forceQueryableOverride = false;
        goto L292
    L278:
        r9 = allocateSessionIdLocked();     // Catch: Throwable -> L314
        goto L279
    L318:
        throw new IllegalStateException("Too many historical sessions for UID " + callingUid);     // Catch: Throwable -> L319
    L338:
    L269:
        th = th;
    L323:
        monitor-exit(r3);     // Catch: Throwable -> L319
        throw th;
    L268:
        throw new IllegalStateException("Too many active sessions for UID " + callingUid);     // Catch: Throwable -> L269
    L272:
        if (activeCount < MAX_ACTIVE_SESSIONS_NO_PERMISSION) goto L273;
        throw new IllegalStateException("Too many active sessions for UID " + callingUid);     // Catch: Throwable -> L319
    L319:
        th = th;
    L314:
        th = th;
        goto L323
    L259:
        requestedInstallerPackageName2 = requestedInstallerPackageName;
        goto L260
    L255:
        requestedInstallerPackageUid2 = -1;
        goto L257
    L189:
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == true) goto L197;
        if (this.mBypassNextStagedInstallerCheck == true) goto L197;
        if (isStagedInstallerAllowed(requestedInstallerPackageName) == true) goto L197;
        throw new SecurityException("Installer not allowed to commit non-staged APEX install");
    L179:
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == true) goto L187;
        if (this.mBypassNextStagedInstallerCheck == true) goto L187;
        if (isStagedInstallerAllowed(requestedInstallerPackageName) == true) goto L187;
        throw new SecurityException("Installer not allowed to commit staged install");
    L150:
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == true) goto L156;
        if (Build.IS_DEBUGGABLE == true) goto L156;
        if (PackageManagerServiceUtils.isAdoptedShell(callingUid, this.mContext) == true) goto L156;
        params.installFlags &= -16777217;
        goto L156
    L124:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") != (-1)) goto L131;
        throw new SecurityException("Not allowed to perform APEX updates");
    L129:
        if (params.isStaged == false) goto L131;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INSTALL_PACKAGES", TAG);
        goto L131
    L118:
        r0 = false;
    L112:
        if ((params.installFlags & 262144) == 0) goto L328;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_ROLLBACKS") == 0) goto L116;
        throw new SecurityException("Setting rollbackImpactLevel requires the MANAGE_ROLLBACKS permission");
    L328:
        throw new IllegalArgumentException("Can't set rollbackImpactLevel when rollback is not enabled");
    L330:
        throw new IllegalArgumentException("rollbackLifetimeMillis can't be negative.");
    L91:
        if ((params.installFlags & 262144) == 0) goto L98;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_ROLLBACKS") != 0) goto L96;
        r15 = 0;
        goto L102
    L96:
        throw new SecurityException("Setting rollback lifetime requires the MANAGE_ROLLBACKS permission");
    L98:
        throw new IllegalArgumentException("Can't set rollbackLifetimeMillis when rollback is not enabled");
    L83:
        params.installFlags &= -524289;
        goto L84
    L86:
        if ((params.installFlags & 36) == 36) goto L89;
        params.installFlags &= -524289;
        goto L89
    L74:
        if (PackageManagerServiceUtils.isSystemOrRoot(callingUid) == true) goto L77;
        params.installFlags &= -1048577;
        goto L79
    L64:
        if (params.originatingUid == callingUid) goto L70;
        String[] packages = snapshot.getPackagesForUid(params.originatingUid);
        if (packages == null) goto L70;
        if (packages.length <= 0) goto L70;
        String originatingPackageName2 = packages[0];
        originatingPackageName = originatingPackageName2;
        goto L72
    L35:
        if (PackageInstallerSession.isSystemDataLoaderInstallation(params) == true) goto L55;
        if (PackageManagerServiceUtils.isAdoptedShell(callingUid, this.mContext) == true) goto L55;
        if (callingUid == 1000) goto L42;
        this.mAppOps.checkPackage(callingUid, installerPackageName2);
    L42:
        if (TextUtils.equals(requestedInstallerPackageName, installerPackageName2) == false) goto L44;
    L46:
        params.installFlags &= -33;
        params.installFlags &= -65;
        params.installFlags &= -134217729;
        params.installFlags |= 2;
        if ((params.installFlags & 65536) == 0) goto L52;
        if (this.mPm.isCallerVerifier(snapshot, callingUid) == true) goto L52;
        params.installFlags &= -65537;
    L52:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_TEST_ONLY_PACKAGE") == 0) goto L54;
        params.installFlags &= -5;
    L54:
        params.developmentInstallFlags = 0;
        installerPackageName3 = installerPackageName2;
        goto L56
    L44:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") == 0) goto L46;
        this.mAppOps.checkPackage(callingUid, requestedInstallerPackageName);
        goto L46
    L31:
        requestedInstallerPackageName = installerPackageName2;
        goto L33
    L25:
        if (isValidPackageName(installerPackageName) == true) goto L27;
        installerPackageName2 = null;
        goto L29
    L21:
        if (isValidPackageName(params.installerPackageName) == true) goto L23;
        params.installerPackageName = null;
        goto L23
    L16:
        if (isValidPackageName(params.appPackageName) == true) goto L18;
        params.appPackageName = null;
        goto L18
    L332:
        throw new SecurityException("User restriction prevents installing");
    }

    int getExistingDraftSessionId(int installerUid, PackageInstaller.SessionParams sessionParams, int userId) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        int r1 = getExistingDraftSessionIdInternal(installerUid, sessionParams, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private int getExistingDraftSessionIdInternal(int installerUid, PackageInstaller.SessionParams sessionParams, int userId) {
        String appPackageName = sessionParams.appPackageName;
        if (PackageArchiver.isArchivingEnabled() == false) goto L34;
        if (installerUid == (-1)) goto L34;
        if (appPackageName == null) goto L34;
        PackageStateInternal ps = this.mPm.snapshotComputer().getPackageStateInternal(appPackageName, 1000);
        if (ps != null) goto L10;
    L33:
        return -1;
    L10:
        if (PackageArchiver.isArchived(ps.getUserStateOrDefault(userId)) == false) goto L33;
        if (sessionParams.unarchiveId <= 0) goto L21;
        PackageInstallerSession session = this.mSessions.get(sessionParams.unarchiveId);
        if (session != null) goto L17;
    L20:
        return -1;
    L17:
        if (isValidDraftSession(session, appPackageName, installerUid, userId) == false) goto L20;
        return session.sessionId;
    L21:
        int i = 0;
    L23:
        if (i >= this.mSessions.size()) goto L32;
        PackageInstallerSession session2 = this.mSessions.valueAt(i);
        if (session2 == null) goto L30;
        if (isValidDraftSession(session2, appPackageName, installerUid, userId) == false) goto L30;
        return session2.sessionId;
    L30:
        i = i + 1;
        goto L23
    L32:
        return -1;
    L34:
        return -1;
    }

    private boolean isValidDraftSession(PackageInstallerSession session, String appPackageName, int installerUid, int userId) {
        if ((session.getInstallFlags() & 536870912) != 0) goto L5;
    L11:
        return false;
    L5:
        if (appPackageName.equals(session.params.appPackageName) == false) goto L11;
        if (session.userId != userId) goto L11;
        if (installerUid != session.getInstallerUid()) goto L11;
        return true;
    }

    void cleanupDraftIfUnclaimed(int sessionId) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession session = this.mPm.mInstallerService.getSession(sessionId);     // Catch: Throwable -> L9
        if (session != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if ((session.getInstallFlags() & 536870912) == 0) goto L11;
        session.abandon();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isStagedInstallerAllowed(String installerName) {
        return SystemConfig.getInstance().getWhitelistedStagedInstallers().contains(installerName);
    }

    public void updateSessionAppIcon(int sessionId, Bitmap appIcon) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession session = this.mSessions.get(sessionId);     // Catch: Throwable -> L14
        if (session == null) goto L21;
        if (isCallingUidOwner(session) == false) goto L21;
        if (appIcon == null) goto L17;
        ActivityManager am = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);     // Catch: Throwable -> L14
        int iconSize = am.getLauncherLargeIconSize();     // Catch: Throwable -> L14
        if (appIcon.getWidth() <= (iconSize * 2)) goto L12;
    L16:
        appIcon = Bitmap.createScaledBitmap(appIcon, iconSize, iconSize, true);     // Catch: Throwable -> L14
        goto L17
    L12:
        if (appIcon.getHeight() > (iconSize * 2)) goto L16;
    L17:
        session.params.appIcon = appIcon;     // Catch: Throwable -> L14
        session.params.appIconLastModified = -1;     // Catch: Throwable -> L14
        this.mInternalCallback.onSessionBadgingChanged(session);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L21:
        throw new SecurityException("Caller has no access to session " + sessionId);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void updateSessionAppLabel(int sessionId, String appLabel) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession session = this.mSessions.get(sessionId);     // Catch: Throwable -> L11
        if (session == null) goto L16;
        if (isCallingUidOwner(session) == false) goto L16;
        if (appLabel.equals(session.params.appLabel) == true) goto L13;
        session.params.appLabel = appLabel;     // Catch: Throwable -> L11
        this.mInternalCallback.onSessionBadgingChanged(session);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        throw new SecurityException("Caller has no access to session " + sessionId);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void abandonSession(int sessionId) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession session = this.mSessions.get(sessionId);     // Catch: Throwable -> L11
        if (session == null) goto L14;
        if (isCallingUidOwner(session) == false) goto L14;
        session.abandon();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new SecurityException("Caller has no access to session " + sessionId);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public IPackageInstallerSession openSession(int sessionId) {
        return openSessionInternal(sessionId);
    L4:
        e = move-exception;
        throw ExceptionUtils.wrap(e);
    }

    private boolean checkOpenSessionAccess(PackageInstallerSession session) {
        if (session != null) goto L5;
    L16:
        return false;
    L5:
        if ((session.getInstallFlags() & 536870912) != 0) goto L16;
        if (isCallingUidOwner(session) == false) goto L11;
        return true;
    L11:
        if (session.isSealed() == true) goto L13;
    L15:
        return false;
    L13:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.PACKAGE_VERIFICATION_AGENT") != 0) goto L15;
        return true;
    }

    private PackageInstallerSession openSessionInternal(int sessionId) throws IOException {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession session = this.mSessions.get(sessionId);     // Catch: Throwable -> L9
        if (checkOpenSessionAccess(session) == false) goto L12;
        session.open();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return session;
    L12:
        throw new SecurityException("Caller has no access to session " + sessionId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private int allocateSessionIdLocked() {
        int n = 0;
    L3:
        int sessionId = this.mRandom.nextInt(2147483646) + 1;
        if (this.mAllocatedSessions.get(sessionId, false) == false) goto L5;
        int n2 = n + 1;
        if (n >= 32) goto L11;
        n = n2;
        goto L3
    L11:
        throw new IllegalStateException("Failed to allocate session ID");
    L5:
        this.mAllocatedSessions.put(sessionId, true);
        return sessionId;
    }

    static boolean isStageName(String name) {
        if (name.startsWith("vmdl") == true) goto L5;
    L7:
        boolean isFile = false;
    L9:
        if (name.startsWith("smdl") == true) goto L11;
    L13:
        boolean isContainer = false;
    L14:
        boolean isLegacyContainer = name.startsWith("smdl2tmp");
        if (isFile == true) goto L19;
        if (isContainer == true) goto L19;
        if (isLegacyContainer == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (name.endsWith(".tmp") == false) goto L13;
        isContainer = true;
        goto L14
    L5:
        if (name.endsWith(".tmp") == false) goto L7;
        isFile = true;
        goto L9
    }

    static int tryParseSessionId(String tmpSessionDir) throws IllegalArgumentException {
        if (tmpSessionDir.startsWith("vmdl") == false) goto L9;
        if (tmpSessionDir.endsWith(".tmp") == false) goto L9;
        String sessionId = tmpSessionDir.substring("vmdl".length(), tmpSessionDir.length() - ".tmp".length());
        return Integer.parseInt(sessionId);
    L9:
        throw new IllegalArgumentException("Not a temporary session directory");
    }

    private static boolean isValidPackageName(String packageName) {
        if (packageName.length() <= 255) goto L5;
        return false;
    L5:
        String errorMessage = FrameworkParsingPackageUtils.validateName(packageName, false, true);
        if (errorMessage == null) goto L8;
        return false;
    L8:
        return true;
    }

    private File getTmpSessionDir(String volumeUuid) {
        return Environment.getDataAppDirectory(volumeUuid);
    }

    private File buildTmpSessionDir(int sessionId, String volumeUuid) {
        File sessionStagingDir = getTmpSessionDir(volumeUuid);
        return new File(sessionStagingDir, "vmdl" + sessionId + ".tmp");
    }

    private File buildSessionDir(int sessionId, PackageInstaller.SessionParams params) {
        if (params.isStaged == false) goto L5;
    L15:
        File sessionStagingDir = Environment.getDataStagingDirectory(params.volumeUuid);
        return new File(sessionStagingDir, "session_" + sessionId);
    L5:
        if ((params.installFlags & 131072) != 0) goto L15;
        File result = buildTmpSessionDir(sessionId, params.volumeUuid);
        if (DEBUG == true) goto L10;
    L14:
        return result;
    L10:
        if (Objects.equals(Integer.valueOf(tryParseSessionId(result.getName())), Integer.valueOf(sessionId)) == true) goto L14;
        throw new RuntimeException("session folder format is off: " + result.getName() + " (" + sessionId + ")");
    }

    static void prepareStageDir(File stageDir) throws IOException {
        if (stageDir.exists() == true) goto L21;
        Os.mkdir(stageDir.getAbsolutePath(), 509);     // Catch: ErrnoException -> L17
        Os.chmod(stageDir.getAbsolutePath(), 509);     // Catch: ErrnoException -> L17
        if (SELinux.restorecon(stageDir) == true) goto L16;
        String path = stageDir.getCanonicalPath();
        String ctx = SELinux.fileSelabelLookup(path);
        boolean success = SELinux.setFileContext(path, ctx);
        StringBuilder r3 = new StringBuilder();
        r3.append("Failed to SELinux.restorecon session dir, path: [");
        r3.append(path);
        r3.append("], ctx: [");
        r3.append(ctx);
        r3.append("]. Retrying via SELinux.fileSelabelLookup/SELinux.setFileContext: ");
        if (success == false) goto L10;
        String r4 = "SUCCESS";
    L11:
        r3.append(r4);
        Slog.e(TAG, r3.toString());
        if (success == false) goto L15;
        return;
    L15:
        throw new IOException("Failed to restorecon session dir: " + stageDir);
    L10:
        r4 = "FAILURE";
        goto L11
    L16:
        return;
    L17:
        e = move-exception;
        throw new IOException("Failed to prepare session dir: " + stageDir, e);
    L21:
        throw new IOException("Session dir already exists: " + stageDir);
    }

    private String buildExternalStageCid(int sessionId) {
        return "smdl" + sessionId + ".tmp";
    }

    private boolean shouldFilterSession(Computer snapshot, int uid, PackageInstaller.SessionInfo info) {
        if (info != null) goto L6;
        return false;
    L6:
        if (uid != info.getInstallerUid()) goto L8;
        return false;
    L8:
        if (snapshot.canQueryPackage(uid, info.getAppPackageName()) == true) goto L13;
        return true;
    L13:
        return false;
    }

    public PackageInstaller.SessionInfo getSessionInfo(int sessionId) {
        int callingUid = Binder.getCallingUid();
        SparseArray<PackageInstallerSession> r1 = this.mSessions;
        monitor-enter(r1);
        PackageInstallerSession session = this.mSessions.get(sessionId);     // Catch: Throwable -> L11
        if (session != null) goto L7;
    L14:
        PackageInstaller.SessionInfo result = null;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (shouldFilterSession(this.mPm.snapshotComputer(), callingUid, result) == false) goto L21;
        return null;
    L21:
        return result;
    L7:
        if (session.isStaged() == false) goto L13;
        if (session.isDestroyed() == true) goto L14;
    L13:
        result = session.generateInfoForCaller(true, callingUid);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public ParceledListSlice<PackageInstaller.SessionInfo> getStagedSessions() {
        final int callingUid = Binder.getCallingUid();
        List<PackageInstaller.SessionInfo> result = new ArrayList();
        SparseArray<PackageInstallerSession> r2 = this.mSessions;
        monitor-enter(r2);
        int i = 0;
    L21:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSessions.size()) goto L16;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L12
        if (session.isStaged() == false) goto L14;
        if (session.isDestroyed() == true) goto L14;
        result.add(session.generateInfoForCaller(false, callingUid));     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L21
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L12
        final Computer snapshot = this.mPm.snapshotComputer();
        result.removeIf(new PackageInstallerService$$ExternalSyntheticLambda8(this, snapshot, callingUid));
        return new ParceledListSlice(result);
    }

    private /* synthetic */ boolean lambda$getStagedSessions$1(Computer snapshot, int callingUid, PackageInstaller.SessionInfo info) {
        return shouldFilterSession(snapshot, callingUid, info);
    }

    public ParceledListSlice<PackageInstaller.SessionInfo> getAllSessions(int userId) {
        final int callingUid = Binder.getCallingUid();
        final Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "getAllSessions");
        List<PackageInstaller.SessionInfo> result = new ArrayList();
        SparseArray<PackageInstallerSession> r4 = this.mSessions;
        monitor-enter(r4);
        int i = 0;
    L26:
    L16:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSessions.size()) goto L21;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L16
        if (session.userId != userId) goto L19;
        if (session.hasParentSessionId() == true) goto L19;
        if (session.isStaged() == false) goto L18;
        if (session.isDestroyed() == true) goto L19;
    L18:
        result.add(session.generateInfoForCaller(false, callingUid));     // Catch: Throwable -> L16
    L19:
        i = i + 1;     // Catch: Throwable -> L16
        goto L26
    L21:
        monitor-exit(r4);     // Catch: Throwable -> L16
        result.removeIf(new PackageInstallerService$$ExternalSyntheticLambda5(this, snapshot, callingUid));
        return new ParceledListSlice(result);
    }

    private /* synthetic */ boolean lambda$getAllSessions$2(Computer snapshot, int callingUid, PackageInstaller.SessionInfo info) {
        return shouldFilterSession(snapshot, callingUid, info);
    }

    public ParceledListSlice<PackageInstaller.SessionInfo> getMySessions(String installerPackageName, int userId) {
        Computer snapshot = this.mPm.snapshotComputer();
        int callingUid = Binder.getCallingUid();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "getMySessions");
        this.mAppOps.checkPackage(callingUid, installerPackageName);
        List<PackageInstaller.SessionInfo> result = new ArrayList();
        SparseArray<PackageInstallerSession> r4 = this.mSessions;
        monitor-enter(r4);
        int i = 0;
    L27:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSessions.size()) goto L22;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L18
        PackageInstaller.SessionInfo info = session.generateInfoForCaller(false, 1000);     // Catch: Throwable -> L18
        if (Objects.equals(info.getInstallerPackageName(), installerPackageName) == false) goto L20;
        if (session.userId != userId) goto L20;
        if (session.hasParentSessionId() == true) goto L20;
        if (isCallingUidOwner(session) == false) goto L20;
        if ((session.getInstallFlags() & 536870912) != 0) goto L20;
        result.add(info);     // Catch: Throwable -> L18
    L20:
        i = i + 1;     // Catch: Throwable -> L18
        goto L27
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L18
        return new ParceledListSlice(result);
    }

    ParceledListSlice<PackageInstaller.SessionInfo> getHistoricalSessions(int userId) {
        final int callingUid = Binder.getCallingUid();
        final Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "getAllSessions");
        List<PackageInstaller.SessionInfo> result = new ArrayList();
        SparseArray<PackageInstallerSession> r4 = this.mSessions;
        monitor-enter(r4);
        int i = 0;
    L22:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mHistoricalSessions.size()) goto L17;
        PackageInstallerHistoricalSession session = this.mHistoricalSessions.get(i);     // Catch: Throwable -> L12
        if (userId == (-1)) goto L14;
        if (session.userId == userId) goto L14;
    L15:
        i = i + 1;     // Catch: Throwable -> L12
    L14:
        result.add(session.generateInfo());     // Catch: Throwable -> L12
        goto L15
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L12
        result.removeIf(new PackageInstallerService$$ExternalSyntheticLambda0(this, snapshot, callingUid));
        return new ParceledListSlice(result);
    }

    private /* synthetic */ boolean lambda$getHistoricalSessions$3(Computer snapshot, int callingUid, PackageInstaller.SessionInfo info) {
        return shouldFilterSession(snapshot, callingUid, info);
    }

    public void uninstall(VersionedPackage versionedPackage, String callerPackageName, int flags, IntentSender statusReceiver, int userId) {
        uninstall(versionedPackage, callerPackageName, flags, statusReceiver, userId, Binder.getCallingUid(), Binder.getCallingPid());
    }

    void uninstall(final VersionedPackage versionedPackage, String callerPackageName, final int flags, IntentSender statusReceiver, final int userId, int callingUid, int callingPid) {
        Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, true, "uninstall");
        if (PackageManagerServiceUtils.isRootOrShell(callingUid) == true) goto L5;
        this.mAppOps.checkPackage(callingUid, callerPackageName);
    L5:
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (dpmi == null) goto L10;
        if (dpmi.canSilentlyInstallPackage(callerPackageName, callingUid) == false) goto L10;
    L11:
        boolean r0 = true;
    L12:
        boolean canSilentlyInstallPackage = r0;
        final PackageDeleteObserverAdapter adapter = new PackageDeleteObserverAdapter(this.mContext, statusReceiver, versionedPackage.getPackageName(), canSilentlyInstallPackage, userId, this.mPackageArchiver, flags);
        if (this.mContext.checkPermission("android.permission.DELETE_PACKAGES", callingPid, callingUid) != 0) goto L18;
        this.mPm.deletePackageVersioned(versionedPackage, adapter.getBinder(), userId, flags, callingUid);
        return;
    L18:
        if (canSilentlyInstallPackage == false) goto L31;
        long ident = Binder.clearCallingIdentity();
        this.mPm.deletePackageVersioned(versionedPackage, adapter.getBinder(), userId, flags);     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(ident);
        DevicePolicyEventLogger.createEvent(113).setAdmin(callerPackageName).write();
        return;
    L24:
        th = th;
    L28:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L26:
        th = th;
        goto L28
    L31:
        if (isSystemAppProtectionRoleHolder(snapshot, userId, callingUid).booleanValue() == false) goto L33;
        Binder.withCleanCallingIdentity(new PackageInstallerService$$ExternalSyntheticLambda4(this, versionedPackage, adapter, userId, flags));
        return;
    L33:
        ApplicationInfo appInfo = snapshot.getApplicationInfo(callerPackageName, 0, userId);
        if (appInfo.targetSdkVersion < 28) goto L36;
        this.mContext.enforcePermission("android.permission.REQUEST_DELETE_PACKAGES", callingPid, callingUid, null);
    L36:
        Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE");
        intent.setData(Uri.fromParts(Settings.ATTR_PACKAGE, versionedPackage.getPackageName(), null));
        intent.putExtra("android.content.pm.extra.CALLBACK", new PackageManager.UninstallCompleteCallback(adapter.getBinder().asBinder()));
        if ((flags & 16) == 0) goto L39;
        intent.putExtra("android.content.pm.extra.DELETE_FLAGS", flags);
    L39:
        adapter.onUserActionRequired(intent);
        return;
    L10:
        if (PackageInstallerSession.isEmergencyInstallerEnabled(versionedPackage.getPackageName(), snapshot, userId, callingUid) == true) goto L11;
        r0 = false;
        goto L12
    }

    private /* synthetic */ void lambda$uninstall$4(VersionedPackage versionedPackage, PackageDeleteObserverAdapter adapter, int userId, int flags) throws Exception {
        this.mPm.deletePackageVersioned(versionedPackage, adapter.getBinder(), userId, flags);
    }

    private Boolean isSystemAppProtectionRoleHolder(Computer snapshot, final int userId, int callingUid) {
        String holderPackageName = (String) Binder.withCleanCallingIdentity(new PackageInstallerService$$ExternalSyntheticLambda2(this, userId));
        boolean r1 = false;
        if (holderPackageName != null) goto L7;
        return false;
    L7:
        if (snapshot.getPackageUid(holderPackageName, 0, userId) != callingUid) goto L10;
        r1 = true;
    L10:
        return Boolean.valueOf(r1);
    }

    private /* synthetic */ String lambda$isSystemAppProtectionRoleHolder$5(int userId) throws Exception {
        RoleManager roleManager = (RoleManager) this.mPm.mContext.getSystemService(RoleManager.class);
        if (roleManager != null) goto L5;
        return null;
    L5:
        List<String> holders = roleManager.getRoleHoldersAsUser(ROLE_SYSTEM_APP_PROTECTION_SERVICE, UserHandle.of(userId));
        if (holders.isEmpty() == false) goto L9;
        return null;
    L9:
        return holders.get(0);
    }

    public void uninstallExistingPackage(VersionedPackage versionedPackage, String callerPackageName, IntentSender statusReceiver, int userId) {
        int callingUid = Binder.getCallingUid();
        this.mContext.enforceCallingOrSelfPermission("android.permission.DELETE_PACKAGES", null);
        Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, true, "uninstall");
        if (PackageManagerServiceUtils.isRootOrShell(callingUid) == true) goto L5;
        this.mAppOps.checkPackage(callingUid, callerPackageName);
    L5:
        PackageDeleteObserverAdapter adapter = new PackageDeleteObserverAdapter(this.mContext, statusReceiver, versionedPackage.getPackageName(), false, userId);
        this.mPm.deleteExistingPackageAsUser(versionedPackage, adapter.getBinder(), userId);
    }

    public void installExistingPackage(String packageName, int installFlags, int installReason, IntentSender statusReceiver, int userId, List<String> allowListedPermissions) {
        Pair<Integer, IntentSender> result = this.mPm.installExistingPackageAsUser(packageName, userId, installFlags, installReason, allowListedPermissions, statusReceiver);
        int returnCode = ((Integer) result.first).intValue();
        IntentSender onCompleteSender = (IntentSender) result.second;
        if (onCompleteSender == null) goto L6;
        InstallPackageHelper.onInstallComplete(returnCode, this.mContext, onCompleteSender);
        return;
    }

    public void setPermissionsResult(int sessionId, boolean accepted) {
        setPermissionsResult_enforcePermission();
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession session = this.mSessions.get(sessionId);     // Catch: Throwable -> L7
        if (session == null) goto L9;
        session.setPermissionsResult(accepted);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isValidForInstallConstraints(PackageStateInternal ps, String installerPackageName, int installerUid, String packageName) {
        Computer snapshot = this.mPm.snapshotComputer();
        if (snapshot.checkUidPermission("android.permission.INSTALL_SELF_UPDATES", installerUid) != 0) goto L5;
        boolean isSelfUpdatePermissionGranted = true;
    L6:
        if (isSelfUpdatePermissionGranted == true) goto L8;
    L10:
        boolean isSelfUpdateAllowed = false;
    L12:
        if (TextUtils.equals(ps.getInstallSource().mInstallerPackageName, installerPackageName) == true) goto L17;
        if (TextUtils.equals(ps.getInstallSource().mUpdateOwnerPackageName, installerPackageName) == true) goto L17;
        if (isSelfUpdateAllowed == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (TextUtils.equals(packageName, installerPackageName) == false) goto L10;
        isSelfUpdateAllowed = true;
        goto L12
    L5:
        isSelfUpdatePermissionGranted = false;
        goto L6
    }

    private CompletableFuture<PackageInstaller.InstallConstraintsResult> checkInstallConstraintsInternal(String installerPackageName, List<String> packageNames, PackageInstaller.InstallConstraints constraints, long timeoutMillis) {
        packageNames.getClass();
        constraints.getClass();
        Computer snapshot = this.mPm.snapshotComputer();
        int callingUid = Binder.getCallingUid();
        String callingPackageName = snapshot.getNameForUid(callingUid);
        if (TextUtils.equals(callingPackageName, installerPackageName) == false) goto L19;
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == true) goto L17;
        Iterator<String> r3 = packageNames.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        String packageName = r3.next();
        PackageStateInternal ps = snapshot.getPackageStateInternal(packageName);
        if (ps == null) goto L15;
        if (isValidForInstallConstraints(ps, installerPackageName, callingUid, packageName) == true) goto L8;
    L15:
        throw new SecurityException("Caller has no access to package " + packageName);
    L17:
        return this.mGentleUpdateHelper.checkInstallConstraints(packageNames, constraints, timeoutMillis);
    L19:
        throw new SecurityException("The installerPackageName set by the caller doesn't match the caller's own package name.");
    }

    public void checkInstallConstraints(String installerPackageName, List<String> packageNames, PackageInstaller.InstallConstraints constraints, final RemoteCallback callback) {
        callback.getClass();
        CompletableFuture<PackageInstaller.InstallConstraintsResult> future = checkInstallConstraintsInternal(installerPackageName, packageNames, constraints, 0);
        future.thenAccept(new PackageInstallerService$$ExternalSyntheticLambda6(callback));
    }

    private static /* synthetic */ void lambda$checkInstallConstraints$6(RemoteCallback callback, PackageInstaller.InstallConstraintsResult result) {
        Bundle b = new Bundle();
        b.putParcelable(MemoryManagerService.RESULT_KEY, result);
        callback.sendResult(b);
    }

    public void waitForInstallConstraints(String installerPackageName, final List<String> packageNames, final PackageInstaller.InstallConstraints constraints, final IntentSender callback, long timeoutMillis) {
        callback.getClass();
        if (timeoutMillis < 0) goto L9;
        if (timeoutMillis > 604800000) goto L9;
        CompletableFuture<PackageInstaller.InstallConstraintsResult> future = checkInstallConstraintsInternal(installerPackageName, packageNames, constraints, timeoutMillis);
        future.thenAccept(new PackageInstallerService$$ExternalSyntheticLambda3(this, packageNames, constraints, callback));
        return;
    L9:
        throw new IllegalArgumentException("Invalid timeoutMillis=" + timeoutMillis);
    }

    private /* synthetic */ void lambda$waitForInstallConstraints$7(List packageNames, PackageInstaller.InstallConstraints constraints, IntentSender callback, PackageInstaller.InstallConstraintsResult result) {
        Intent intent = new Intent();
        intent.putExtra("android.intent.extra.PACKAGES", (String[]) packageNames.toArray(new String[0]));
        intent.putExtra("android.content.pm.extra.INSTALL_CONSTRAINTS", constraints);
        intent.putExtra("android.content.pm.extra.INSTALL_CONSTRAINTS_RESULT", result);
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L9
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L9
        callback.sendIntent(this.mContext, 0, intent, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L7
        return;
    L17:
        return;
    }

    public void registerCallback(IPackageInstallerCallback callback, final int userId) {
        Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(Binder.getCallingUid(), userId, true, false, "registerCallback");
        registerCallback(callback, new PackageInstallerService$$ExternalSyntheticLambda7(userId));
    }

    private static /* synthetic */ boolean lambda$registerCallback$8(int userId, int eventUserId) {
        if (userId != eventUserId) goto L4;
        return true;
    L4:
        return false;
    }

    public void registerCallback(IPackageInstallerCallback callback, IntPredicate userCheck) {
        this.mCallbacks.register(callback, new BroadcastCookie(Binder.getCallingUid(), userCheck));
    }

    public void unregisterCallback(IPackageInstallerCallback callback) {
        this.mCallbacks.unregister(callback);
    }

    @Override // com.android.server.pm.PackageSessionProvider
    public PackageInstallerSession getSession(int sessionId) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        PackageInstallerSession r1 = this.mSessions.get(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.PackageSessionProvider
    public PackageSessionVerifier getSessionVerifier() {
        return this.mSessionVerifier;
    }

    @Override // com.android.server.pm.PackageSessionProvider
    public GentleUpdateHelper getGentleUpdateHelper() {
        return this.mGentleUpdateHelper;
    }

    public void bypassNextStagedInstallerCheck(boolean value) {
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(Binder.getCallingUid()) == false) goto L7;
        this.mBypassNextStagedInstallerCheck = value;
        return;
    L7:
        throw new SecurityException("Caller not allowed to bypass staged installer check");
    }

    public void bypassNextAllowedApexUpdateCheck(boolean value) {
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(Binder.getCallingUid()) == false) goto L7;
        this.mBypassNextAllowedApexUpdateCheck = value;
        return;
    L7:
        throw new SecurityException("Caller not allowed to bypass allowed apex update check");
    }

    public void disableVerificationForUid(int uid) {
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(Binder.getCallingUid()) == false) goto L7;
        this.mDisableVerificationForUid = uid;
        return;
    L7:
        throw new SecurityException("Operation not allowed for caller");
    }

    public void setAllowUnlimitedSilentUpdates(String installerPackageName) {
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(Binder.getCallingUid()) == false) goto L7;
        this.mSilentUpdatePolicy.setAllowUnlimitedSilentUpdates(installerPackageName);
        return;
    L7:
        throw new SecurityException("Caller not allowed to unlimite silent updates");
    }

    public void setSilentUpdatesThrottleTime(long throttleTimeInSeconds) {
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(Binder.getCallingUid()) == false) goto L7;
        this.mSilentUpdatePolicy.setSilentUpdatesThrottleTime(throttleTimeInSeconds);
        return;
    L7:
        throw new SecurityException("Caller not allowed to set silent updates throttle time");
    }

    public void requestArchive(String packageName, String callerPackageName, int flags, IntentSender intentSender, UserHandle userHandle) {
        this.mPackageArchiver.requestArchive(packageName, callerPackageName, flags, intentSender, userHandle);
    }

    public void requestUnarchive(String packageName, String callerPackageName, IntentSender statusReceiver, UserHandle userHandle) {
        this.mPackageArchiver.requestUnarchive(packageName, callerPackageName, statusReceiver, userHandle);
    }

    public void installPackageArchived(final ArchivedPackageParcel archivedPackageParcel, final PackageInstaller.SessionParams params, final IntentSender statusReceiver, final String installerPackageName, UserHandle userHandle) {
        params.getClass();
        archivedPackageParcel.getClass();
        statusReceiver.getClass();
        installerPackageName.getClass();
        userHandle.getClass();
        Slog.i(TAG, TextUtils.formatSimple("Requested archived install of package %s for user %s.", new Object[]{archivedPackageParcel.packageName, Integer.valueOf(userHandle.getIdentifier())}));
        int callingUid = Binder.getCallingUid();
        final int userId = userHandle.getIdentifier();
        Computer snapshot = this.mPm.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, true, "installPackageArchived");
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") != 0) goto L11;
        params.installFlags |= 134217728;
        if (params.dataLoaderParams != null) goto L9;
        params.setDataLoaderParams(PackageManagerShellCommandDataLoader.getStreamingDataLoaderParams(null));
        final PackageManagerShellCommandDataLoader.Metadata metadata = PackageManagerShellCommandDataLoader.Metadata.forArchived(archivedPackageParcel);
        Binder.withCleanCallingIdentity(new PackageInstallerService$$ExternalSyntheticLambda1(this, params, installerPackageName, userId, metadata, statusReceiver, archivedPackageParcel));
        return;
    L9:
        throw new IllegalArgumentException("Incompatible session param: dataLoaderParams has to be null");
    L11:
        throw new SecurityException("You need the com.android.permission.INSTALL_PACKAGES permission to request archived package install");
    }

    private /* synthetic */ void lambda$installPackageArchived$9(PackageInstaller.SessionParams params, String installerPackageName, int userId, PackageManagerShellCommandDataLoader.Metadata metadata, IntentSender statusReceiver, ArchivedPackageParcel archivedPackageParcel) throws Exception {
        PackageInstallerSession session = null;
        int sessionId = createSessionInternal(params, installerPackageName, null, Binder.getCallingUid(), userId);     // Catch: Throwable -> L24 IOException -> L26
        PackageInstallerSession session2 = openSessionInternal(sessionId);     // Catch: Throwable -> L24 IOException -> L26
    L41:
        session2.addFile(0, "base", 0, metadata.toByteArray(), null);     // Catch: Throwable -> L20 IOException -> L22
    L37:
        session2.commit(statusReceiver, false);     // Catch: Throwable -> L16 IOException -> L18
    L43:
        Slog.i(TAG, TextUtils.formatSimple("Installed archived app %s.", new Object[]{archivedPackageParcel.packageName}));     // Catch: Throwable -> L12 IOException -> L14
        session2.close();
        return;
    L14:
        e = e;
    L15:
        session = session2;
    L35:
    L31:
        e = th;
    L32:
        if (session == null) goto L34;
        session.close();
    L34:
        throw e;
    L30:
        throw ExceptionUtils.wrap(e);     // Catch: Throwable -> L31
    L12:
        e = th;
    L13:
        session = session2;
    L18:
        e = e;
    L16:
        e = th;
    L22:
        e = e;
    L20:
        e = th;
    L26:
        e = e;
    L24:
        e = th;
        goto L32
    }

    public void reportUnarchivalStatus(int unarchiveId, int status, long requiredStorageBytes, PendingIntent userActionIntent, UserHandle userHandle) {
        verifyReportUnarchiveStatusInput(status, requiredStorageBytes, userActionIntent, userHandle);
        int userId = userHandle.getIdentifier();
        int binderUid = Binder.getCallingUid();
        SparseArray<PackageInstallerSession> r3 = this.mSessions;
        monitor-enter(r3);
        PackageInstallerSession session = this.mSessions.get(unarchiveId);     // Catch: Throwable -> L15
        if (session == null) goto L20;
        if (session.userId != userId) goto L20;
        if (session.params.appPackageName == null) goto L20;
        if (isCallingUidOwner(session) == false) goto L18;
        session.reportUnarchivalStatus(status, unarchiveId, requiredStorageBytes, userActionIntent);     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L18:
        throw new SecurityException(TextUtils.formatSimple("The caller UID %s does not have access to the session with unarchiveId %d.", new Object[]{Integer.valueOf(binderUid), Integer.valueOf(unarchiveId)}));     // Catch: Throwable -> L15
    L20:
        throw new ParcelableException(new PackageManager.NameNotFoundException(TextUtils.formatSimple("No valid session with unarchival ID %s found for user %s.", new Object[]{Integer.valueOf(unarchiveId), Integer.valueOf(userId)})));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static void verifyReportUnarchiveStatusInput(int status, long requiredStorageBytes, PendingIntent userActionIntent, UserHandle userHandle) {
        userHandle.getClass();
        if (status != 1) goto L6;
        userActionIntent.getClass();
    L6:
        if (status == 2) goto L8;
    L12:
        if (status == 2) goto L19;
        if (requiredStorageBytes <= 0) goto L19;
        throw new IllegalStateException(TextUtils.formatSimple("requiredStorageBytes set, but error is %s.", new Object[]{Integer.valueOf(status)}));
    L19:
        if (List.of(0, 1, 2, 3, 4, 5, 100).contains(Integer.valueOf(status)) == false) goto L22;
        return;
    L22:
        throw new IllegalStateException("Invalid status code passed " + status);
    L8:
        if (requiredStorageBytes > 0) goto L12;
        throw new IllegalStateException("Insufficient storage error set, but requiredStorageBytes unspecified.");
    }

    private static int getSessionCount(SparseArray<PackageInstallerSession> sessions, int installerUid) {
        int count = 0;
        int size = sessions.size();
        int i = 0;
    L3:
        if (i >= size) goto L9;
        PackageInstallerSession session = sessions.valueAt(i);
        if (session.getInstallerUid() != installerUid) goto L7;
        count = count + 1;
    L7:
        i = i + 1;
        goto L3
    L9:
        return count;
    }

    private boolean isCallingUidOwner(PackageInstallerSession session) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
        return true;
    L5:
        if (session != null) goto L7;
    L9:
        return false;
    L7:
        if (callingUid != session.getInstallerUid()) goto L9;
        return true;
    }

    private boolean shouldFilterSession(Computer snapshot, int uid, int sessionId) {
        PackageInstallerSession session = getSession(sessionId);
        if (session != null) goto L6;
        return false;
    L6:
        if (uid != session.getInstallerUid()) goto L8;
        return false;
    L8:
        if (snapshot.canQueryPackage(uid, session.getPackageName()) == true) goto L13;
        return true;
    L13:
        return false;
    }

    static Notification buildSuccessNotification(Context context, String contentText, String basePackageName, int userId) {
        PackageInfo packageInfo = null;
        packageInfo = AppGlobals.getPackageManager().getPackageInfo(basePackageName, 67108864, userId);     // Catch: RemoteException -> L5
    L6:
        if (packageInfo != null) goto L8;
    L12:
        Slog.w(TAG, "Notification not built for package: " + basePackageName);
        return null;
    L8:
        if (packageInfo.applicationInfo == null) goto L12;
        PackageManager pm = context.getPackageManager();
        Bitmap packageIcon = ImageUtils.buildScaledBitmap(packageInfo.applicationInfo.loadIcon(pm), context.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_width), context.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_height));
        CharSequence packageLabel = packageInfo.applicationInfo.loadLabel(pm);
        return new Notification.Builder(context, "DEVICE_ADMIN_ALERTS").setSmallIcon(R.drawable.ic_star_black_48dp).setColor(context.getResources().getColor(R.color.system_notification_accent_color)).setContentTitle(packageLabel).setContentText(contentText).setStyle(new Notification.BigTextStyle().bigText(contentText)).setLargeIcon(packageIcon).build();
    }

    public static <E> ArraySet<E> newArraySet(E... elements) {
        ArraySet<E> set = new ArraySet();
        if (elements == null) goto L5;
        set.ensureCapacity(elements.length);
        Collections.addAll(set, elements);
    L5:
        return set;
    }

    void dump(IndentingPrintWriter pw) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        ParentChildSessionMap activeSessionMap = new ParentChildSessionMap();     // Catch: Throwable -> L9
        ParentChildSessionMap orphanedChildSessionMap = new ParentChildSessionMap();     // Catch: Throwable -> L9
        ParentChildSessionMap finalizedSessionMap = new ParentChildSessionMap();     // Catch: Throwable -> L9
        int N = this.mSessions.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= N) goto L20;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L9
        if (session.hasParentSessionId() == false) goto L11;
        PackageInstallerSession rootSession = getSession(session.getParentSessionId());     // Catch: Throwable -> L9
    L13:
        if (rootSession != null) goto L16;
        orphanedChildSessionMap.addSession(session, rootSession);     // Catch: Throwable -> L9
    L19:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L16:
        if (rootSession.isStagedAndInTerminalState() == false) goto L18;
        finalizedSessionMap.addSession(session, rootSession);     // Catch: Throwable -> L9
        goto L19
    L18:
        activeSessionMap.addSession(session, rootSession);     // Catch: Throwable -> L9
        goto L19
    L11:
        rootSession = session;
        goto L13
    L20:
        activeSessionMap.dump("Active", pw);     // Catch: Throwable -> L9
        if (orphanedChildSessionMap.containsSession() == false) goto L23;
        orphanedChildSessionMap.dump("Orphaned", pw);     // Catch: Throwable -> L9
    L23:
        finalizedSessionMap.dump("Finalized", pw);     // Catch: Throwable -> L9
        pw.println("Historical install sessions:");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        int N2 = this.mHistoricalSessions.size();     // Catch: Throwable -> L9
        int i2 = 0;
    L24:
        if (i2 >= N2) goto L26;
        this.mHistoricalSessions.get(i2).dump(pw);     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        i2 = i2 + 1;     // Catch: Throwable -> L9
        goto L24
    L26:
        pw.println();     // Catch: Throwable -> L9
        pw.decreaseIndent();     // Catch: Throwable -> L9
        pw.println("Legacy install sessions:");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        pw.println(this.mLegacySessions.toString());     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        pw.decreaseIndent();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mSilentUpdatePolicy.dump(pw);
        this.mGentleUpdateHelper.dump(pw);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void sendSessionUpdatedBroadcast(PackageInstaller.SessionInfo sessionInfo, int userId) {
        if (TextUtils.isEmpty(sessionInfo.installerPackageName) == false) goto L5;
        return;
    L5:
        Intent sessionUpdatedIntent = new Intent("android.content.pm.action.SESSION_UPDATED").putExtra("android.content.pm.extra.SESSION", sessionInfo).setPackage(sessionInfo.installerPackageName);
        this.mContext.sendBroadcastAsUser(sessionUpdatedIntent, UserHandle.of(userId));
    }

    void onInstallerPackageDeleted(int installerAppId, int userId) {
        SparseArray<PackageInstallerSession> r0 = this.mSessions;
        monitor-enter(r0);
        int i = 0;
    L28:
    L20:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSessions.size()) goto L24;
        PackageInstallerSession session = this.mSessions.valueAt(i);     // Catch: Throwable -> L20
        if (matchesInstaller(session, installerAppId, userId) == true) goto L11;
    L22:
        i = i + 1;     // Catch: Throwable -> L20
        goto L28
    L11:
        if (session.hasParentSessionId() == true) goto L13;
        PackageInstallerSession root = session;
    L14:
        if (root == null) goto L22;
        if (matchesInstaller(root, installerAppId, userId) == false) goto L22;
        if (root.isDestroyed() == true) goto L22;
        root.abandon();     // Catch: Throwable -> L20
        goto L22
    L13:
        root = this.mSessions.get(session.getParentSessionId());     // Catch: Throwable -> L20
        goto L14
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L20
    }

    private boolean matchesInstaller(PackageInstallerSession session, int installerAppId, int userId) {
        int installerUid = session.getInstallerUid();
        if (installerAppId != (-1)) goto L9;
        if (UserHandle.getAppId(installerUid) == installerAppId) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (UserHandle.getUid(userId, installerAppId) == installerUid) goto L11;
        return false;
    L11:
        return true;
    }
}
