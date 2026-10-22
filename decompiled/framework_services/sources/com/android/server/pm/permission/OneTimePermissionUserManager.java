package com.android.server.pm.permission;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AlarmManager;
import android.app.IActivityManager;
import android.app.IUidObserver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.RemoteException;
import android.permission.PermissionControllerManager;
import android.provider.DeviceConfig;
import android.util.Log;
import android.util.SparseArray;
import com.android.server.LocalServices;
import com.android.server.PermissionThread;

/* JADX INFO: loaded from: classes2.dex */
public class OneTimePermissionUserManager {
    private static final boolean DEBUG = false;
    private static final long DEFAULT_KILLED_DELAY_MILLIS = 5000;
    private static final String LOG_TAG = null;
    public static final String PROPERTY_KILLED_DELAY_CONFIG_KEY = "one_time_permissions_killed_delay_millis";
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AlarmManager mAlarmManager;
    private final Context mContext;
    private final Handler mHandler;
    private final IActivityManager mIActivityManager;
    private final SparseArray<PackageInactivityListener> mListeners;
    private final Object mLock;
    private final PermissionControllerManager mPermissionControllerManager;
    private final BroadcastReceiver mUninstallListener;

    private class PackageInactivityListener implements AlarmManager.OnAlarmListener {
        private static final int STATE_ACTIVE = 2;
        private static final int STATE_GONE = 0;
        private static final int STATE_TIMER = 1;
        private static final long TIMER_INACTIVE = -1;
        private final int mDeviceId;
        private final Object mInnerLock;
        private boolean mIsAlarmSet;
        private boolean mIsFinished;
        private final IUidObserver mObserver;
        private final String mPackageName;
        private long mRevokeAfterKilledDelay;
        private long mTimeout;
        private long mTimerStart;
        private final Object mToken;
        private final int mUid;
        final /* synthetic */ OneTimePermissionUserManager this$0;

        public static /* synthetic */ void $r8$lambda$4TS9jIh4Kf1WcuK8uLGThkegols(PackageInactivityListener r0) {
            r0.lambda$updateUidState$0();
        }

        public static /* synthetic */ void $r8$lambda$GtdvPz8EtLsH3sUGLh93RYx9U90(PackageInactivityListener r0) {
            r0.lambda$onPackageInactiveLocked$1();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7080$$Nest$fgetmUid(PackageInactivityListener r0) {
            return r0.mUid;
        }

        /* JADX INFO: renamed from: -$$Nest$mcancel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7081$$Nest$mcancel(PackageInactivityListener r0) {
            r0.cancel();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateUidState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7082$$Nest$mupdateUidState(PackageInactivityListener r0, int r1) {
            r0.updateUidState(r1);
        }

        /* synthetic */ PackageInactivityListener(OneTimePermissionUserManager r1, int r2, String r3, int r4, long r5, long r7, OneTimePermissionUserManagerIA r9) {
            this(r1, r2, r3, r4, r5, r7);
        }

        private PackageInactivityListener(OneTimePermissionUserManager r6, int uid, String packageName, int deviceId, long timeout, long revokeAfterkilledDelay) {
            this.this$0 = r6;
            this.mTimerStart = -1;
            this.mInnerLock = new Object();
            this.mToken = new Object();
            this.mObserver = new AnonymousClass1(this);
            Log.i(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "Start tracking " + packageName + ". uid=" + uid + " timeout=" + timeout + " killedDelay=" + revokeAfterkilledDelay);
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mDeviceId = deviceId;
            this.mTimeout = timeout;
            if (revokeAfterkilledDelay != (-1)) goto L5;
            long r0 = DeviceConfig.getLong("permissions", OneTimePermissionUserManager.PROPERTY_KILLED_DELAY_CONFIG_KEY, OneTimePermissionUserManager.DEFAULT_KILLED_DELAY_MILLIS);
        L6:
            this.mRevokeAfterKilledDelay = r0;
            OneTimePermissionUserManager.m7075$$Nest$fgetmIActivityManager(r6).registerUidObserver(this.mObserver, 3, 4, null);     // Catch: RemoteException -> L9
        L14:
            updateUidState();
            return;
        L9:
            e = move-exception;
            Log.e(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "Couldn't check uid proc state", e);
            monitor-enter(this.mInnerLock);
            onPackageInactiveLocked();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        L5:
            r0 = revokeAfterkilledDelay;
            goto L6
        }

        public void updateSessionParameters(long timeoutMillis, long revokeAfterKilledDelayMillis) {
            Object r0 = this.mInnerLock;
            monitor-enter(r0);
            this.mTimeout = Math.min(this.mTimeout, timeoutMillis);     // Catch: Throwable -> L7
            long r1 = this.mRevokeAfterKilledDelay;     // Catch: Throwable -> L7
            if (revokeAfterKilledDelayMillis != (-1)) goto L9;
            long r3 = DeviceConfig.getLong("permissions", OneTimePermissionUserManager.PROPERTY_KILLED_DELAY_CONFIG_KEY, OneTimePermissionUserManager.DEFAULT_KILLED_DELAY_MILLIS);     // Catch: Throwable -> L7
        L10:
            this.mRevokeAfterKilledDelay = Math.min(r1, r3);     // Catch: Throwable -> L7
            Log.v(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "Updated params for " + this.mPackageName + ", device ID " + this.mDeviceId + ". timeout=" + this.mTimeout + " killedDelay=" + this.mRevokeAfterKilledDelay);     // Catch: Throwable -> L7
            updateUidState();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            r3 = revokeAfterKilledDelayMillis;
        L7:
            th = move-exception;
            throw th;
        }

        private int getCurrentState() {
            return getStateFromProcState(OneTimePermissionUserManager.m7072$$Nest$fgetmActivityManagerInternal(this.this$0).getUidProcessState(this.mUid));
        }

        private int getStateFromProcState(int procState) {
            if (procState != 20) goto L7;
            return 0;
        L7:
            if (procState <= 4) goto L10;
            return 1;
        L10:
            return 2;
        }

        private void updateUidState() {
            updateUidState(getCurrentState());
        }

        private void updateUidState(int state) {
            Log.v(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "Updating state for " + this.mPackageName + " (" + this.mUid + "). device ID=" + this.mDeviceId + ", state=" + state);
            Object r0 = this.mInnerLock;
            monitor-enter(r0);
            OneTimePermissionUserManager.m7074$$Nest$fgetmHandler(this.this$0).removeCallbacksAndMessages(this.mToken);     // Catch: Throwable -> L11
            if (state != 0) goto L17;
            if (this.mRevokeAfterKilledDelay != 0) goto L13;
            onPackageInactiveLocked();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            OneTimePermissionUserManager.m7074$$Nest$fgetmHandler(this.this$0).postDelayed(new OneTimePermissionUserManager$PackageInactivityListener$$ExternalSyntheticLambda0(this), this.mToken, this.mRevokeAfterKilledDelay);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L17:
            if (state != 1) goto L22;
            if (this.mTimerStart != (-1)) goto L24;
            this.mTimerStart = System.currentTimeMillis();     // Catch: Throwable -> L11
            setAlarmLocked();     // Catch: Throwable -> L11
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L22:
            if (state != 2) goto L24;
            this.mTimerStart = -1;     // Catch: Throwable -> L11
            cancelAlarmLocked();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$updateUidState$0() {
            Object r0 = this.mInnerLock;
            monitor-enter(r0);
            int currentState = getCurrentState();     // Catch: Throwable -> L9
            if (currentState != 0) goto L11;
            onPackageInactiveLocked();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            updateUidState(currentState);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void cancel() {
            Object r0 = this.mInnerLock;
            monitor-enter(r0);
            this.mIsFinished = true;     // Catch: Throwable -> L8
            cancelAlarmLocked();     // Catch: Throwable -> L8
            OneTimePermissionUserManager.m7075$$Nest$fgetmIActivityManager(this.this$0).unregisterUidObserver(this.mObserver);     // Catch: Throwable -> L8 RemoteException -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            e = move-exception;
            Log.e(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "Unable to unregister uid observer.", e);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private void setAlarmLocked() {
            if (this.mIsAlarmSet == false) goto L5;
            return;
        L5:
            long revokeTime = this.mTimerStart + this.mTimeout;
            if (revokeTime <= System.currentTimeMillis()) goto L8;
            OneTimePermissionUserManager.m7073$$Nest$fgetmAlarmManager(this.this$0).setExact(0, revokeTime, OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), this, OneTimePermissionUserManager.m7074$$Nest$fgetmHandler(this.this$0));
            this.mIsAlarmSet = true;
            return;
        L8:
            this.mIsAlarmSet = true;
            onAlarm();
        }

        private void cancelAlarmLocked() {
            if (this.mIsAlarmSet == false) goto L6;
            OneTimePermissionUserManager.m7073$$Nest$fgetmAlarmManager(this.this$0).cancel(this);
            this.mIsAlarmSet = false;
            return;
        }

        private void onPackageInactiveLocked() {
            if (this.mIsFinished == false) goto L5;
            return;
        L5:
            this.mIsFinished = true;
            cancelAlarmLocked();
            OneTimePermissionUserManager.m7074$$Nest$fgetmHandler(this.this$0).post(new OneTimePermissionUserManager$PackageInactivityListener$$ExternalSyntheticLambda1(this));
            OneTimePermissionUserManager.m7075$$Nest$fgetmIActivityManager(this.this$0).unregisterUidObserver(this.mObserver);     // Catch: RemoteException -> L8
        L10:
            Object r0 = OneTimePermissionUserManager.m7077$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            OneTimePermissionUserManager.m7076$$Nest$fgetmListeners(this.this$0).remove(this.mUid);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L8:
            e = move-exception;
            Log.e(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "Unable to unregister uid observer.", e);
            goto L10
        }

        private /* synthetic */ void lambda$onPackageInactiveLocked$1() {
            Log.i(OneTimePermissionUserManager.m7079$$Nest$sfgetLOG_TAG(), "One time session expired for " + this.mPackageName + " (" + this.mUid + "). deviceID " + this.mDeviceId);
            OneTimePermissionUserManager.m7078$$Nest$fgetmPermissionControllerManager(this.this$0).notifyOneTimePermissionSessionTimeout(this.mPackageName, this.mDeviceId);
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            Object r0 = this.mInnerLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mIsAlarmSet == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.mIsAlarmSet = false;     // Catch: Throwable -> L8
            onPackageInactiveLocked();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m7072$$Nest$fgetmActivityManagerInternal(OneTimePermissionUserManager r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlarmManager m7073$$Nest$fgetmAlarmManager(OneTimePermissionUserManager r0) {
        return r0.mAlarmManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7074$$Nest$fgetmHandler(OneTimePermissionUserManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIActivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IActivityManager m7075$$Nest$fgetmIActivityManager(OneTimePermissionUserManager r0) {
        return r0.mIActivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m7076$$Nest$fgetmListeners(OneTimePermissionUserManager r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7077$$Nest$fgetmLock(OneTimePermissionUserManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionControllerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionControllerManager m7078$$Nest$fgetmPermissionControllerManager(OneTimePermissionUserManager r0) {
        return r0.mPermissionControllerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOG_TAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7079$$Nest$sfgetLOG_TAG() {
        return LOG_TAG;
    }

    static {
        LOG_TAG = OneTimePermissionUserManager.class.getSimpleName();
    }

    OneTimePermissionUserManager(Context context) {
        this.mLock = new Object();
        this.mUninstallListener = new AnonymousClass1(this);
        this.mListeners = new SparseArray();
        this.mContext = context;
        this.mIActivityManager = ActivityManager.getService();
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mAlarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
        this.mPermissionControllerManager = new PermissionControllerManager(this.mContext, PermissionThread.getHandler());
        this.mHandler = context.getMainThreadHandler();
    }

    void startPackageOneTimeSession(String packageName, int deviceId, long timeoutMillis, long revokeAfterKilledDelayMillis) {
        int uid = this.mContext.getPackageManager().getPackageUid(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L17
        Object r11 = this.mLock;
        monitor-enter(r11);
        PackageInactivityListener listener = this.mListeners.get(uid);     // Catch: Throwable -> L10
        if (listener == null) goto L12;
        listener.updateSessionParameters(timeoutMillis, revokeAfterKilledDelayMillis);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L12:
        this.mListeners.put(uid, new PackageInactivityListener(this, uid, packageName, deviceId, timeoutMillis, revokeAfterKilledDelayMillis, null));     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        Log.e(LOG_TAG, "Unknown package name " + packageName + ", device ID " + deviceId, e);
    }

    void stopPackageOneTimeSession(String packageName) {
        int uid = this.mContext.getPackageManager().getPackageUid(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackageInactivityListener listener = this.mListeners.get(uid);     // Catch: Throwable -> L8
        if (listener == null) goto L10;
        this.mListeners.remove(uid);     // Catch: Throwable -> L8
        PackageInactivityListener.m7081$$Nest$mcancel(listener);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        Log.e(LOG_TAG, "Unknown package name " + packageName, e);
    }

    void registerUninstallListener() {
        this.mContext.registerReceiver(this.mUninstallListener, new IntentFilter("android.intent.action.UID_REMOVED"));
    }
}
