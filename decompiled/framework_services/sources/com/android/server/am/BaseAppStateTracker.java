package com.android.server.am;

import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.media.session.MediaSessionManager;
import android.os.BatteryManagerInternal;
import android.os.BatteryStatsInternal;
import android.os.Handler;
import android.os.ServiceManager;
import android.permission.PermissionManager;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.IAppOpsService;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.am.BaseAppStatePolicy;
import com.android.server.notification.NotificationManagerInternal;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAppStateTracker<T extends BaseAppStatePolicy> {
    static final long ONE_DAY = 86400000;
    static final long ONE_HOUR = 3600000;
    static final long ONE_MINUTE = 60000;
    static final int STATE_TYPE_FGS_LOCATION = 4;
    static final int STATE_TYPE_FGS_MEDIA_PLAYBACK = 2;
    static final int STATE_TYPE_FGS_WITH_NOTIFICATION = 8;
    static final int STATE_TYPE_INDEX_FGS_LOCATION = 2;
    static final int STATE_TYPE_INDEX_FGS_MEDIA_PLAYBACK = 1;
    static final int STATE_TYPE_INDEX_FGS_WITH_NOTIFICATION = 3;
    static final int STATE_TYPE_INDEX_MEDIA_SESSION = 0;
    static final int STATE_TYPE_INDEX_PERMISSION = 4;
    static final int STATE_TYPE_MEDIA_SESSION = 1;
    static final int STATE_TYPE_NUM = 5;
    static final int STATE_TYPE_PERMISSION = 16;
    protected static final String TAG = "ActivityManager";
    protected final AppRestrictionController mAppRestrictionController;
    protected final Handler mBgHandler;
    protected final Context mContext;
    final Injector<T> mInjector;
    protected final Object mLock;
    protected final ArrayList<StateListener> mStateListeners;

    static class Injector<T extends BaseAppStatePolicy> {
        ActivityManagerInternal mActivityManagerInternal;
        AppOpsManager mAppOpsManager;
        T mAppStatePolicy;
        BatteryManagerInternal mBatteryManagerInternal;
        BatteryStatsInternal mBatteryStatsInternal;
        Context mContext;
        DeviceIdleInternal mDeviceIdleInternal;
        IAppOpsService mIAppOpsService;
        MediaSessionManager mMediaSessionManager;
        NotificationManagerInternal mNotificationManagerInternal;
        PackageManager mPackageManager;
        PackageManagerInternal mPackageManagerInternal;
        PermissionManager mPermissionManager;
        PermissionManagerServiceInternal mPermissionManagerServiceInternal;
        RoleManager mRoleManager;
        UserManagerInternal mUserManagerInternal;

        Injector() {
        }

        void setPolicy(T policy) {
            this.mAppStatePolicy = policy;
        }

        void onSystemReady() {
            this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            this.mBatteryManagerInternal = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);
            this.mBatteryStatsInternal = (BatteryStatsInternal) LocalServices.getService(BatteryStatsInternal.class);
            this.mDeviceIdleInternal = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
            this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
            this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            this.mPermissionManagerServiceInternal = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
            Context context = this.mAppStatePolicy.mTracker.mContext;
            this.mPackageManager = context.getPackageManager();
            this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            this.mMediaSessionManager = (MediaSessionManager) context.getSystemService(MediaSessionManager.class);
            this.mPermissionManager = (PermissionManager) context.getSystemService(PermissionManager.class);
            this.mRoleManager = (RoleManager) context.getSystemService(RoleManager.class);
            this.mNotificationManagerInternal = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
            this.mIAppOpsService = IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
            this.mContext = context;
            getPolicy().onSystemReady();
        }

        ActivityManagerInternal getActivityManagerInternal() {
            return this.mActivityManagerInternal;
        }

        BatteryManagerInternal getBatteryManagerInternal() {
            return this.mBatteryManagerInternal;
        }

        BatteryStatsInternal getBatteryStatsInternal() {
            return this.mBatteryStatsInternal;
        }

        T getPolicy() {
            return this.mAppStatePolicy;
        }

        DeviceIdleInternal getDeviceIdleInternal() {
            return this.mDeviceIdleInternal;
        }

        UserManagerInternal getUserManagerInternal() {
            return this.mUserManagerInternal;
        }

        long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        PackageManager getPackageManager() {
            return this.mPackageManager;
        }

        PackageManagerInternal getPackageManagerInternal() {
            return this.mPackageManagerInternal;
        }

        PermissionManager getPermissionManager() {
            return this.mPermissionManager;
        }

        PermissionManagerServiceInternal getPermissionManagerServiceInternal() {
            return this.mPermissionManagerServiceInternal;
        }

        AppOpsManager getAppOpsManager() {
            return this.mAppOpsManager;
        }

        MediaSessionManager getMediaSessionManager() {
            return this.mMediaSessionManager;
        }

        long getServiceStartForegroundTimeout() {
            return this.mActivityManagerInternal.getServiceStartForegroundTimeout();
        }

        RoleManager getRoleManager() {
            return this.mRoleManager;
        }

        NotificationManagerInternal getNotificationManagerInternal() {
            return this.mNotificationManagerInternal;
        }

        IAppOpsService getIAppOpsService() {
            return this.mIAppOpsService;
        }

        int checkPermission(String perm, int pid, int uid) {
            return this.mContext.checkPermission(perm, pid, uid);
        }
    }

    interface StateListener {
        void onStateChange(int r1, String r2, boolean r3, long r4, int r6);
    }

    BaseAppStateTracker(Context context, AppRestrictionController controller, Constructor<? extends Injector<T>> injector, Object outerContext) {
        this.mStateListeners = new ArrayList();
        this.mContext = context;
        this.mAppRestrictionController = controller;
        this.mBgHandler = controller.getBackgroundHandler();
        this.mLock = controller.getLock();
        if (injector != null) goto L5;
        this.mInjector = new Injector();
        return;
    L5:
        Injector<T> localInjector = null;
        localInjector = injector.newInstance(new Object[]{outerContext});     // Catch: Exception -> L8
    L10:
        if (localInjector != null) goto L12;
        Injector<T> r1 = new Injector();
    L13:
        this.mInjector = r1;
        return;
    L12:
        r1 = localInjector;
    L8:
        e = move-exception;
        Slog.w(TAG, "Unable to instantiate " + injector, e);
        goto L10
    }

    static int stateTypeToIndex(int stateType) {
        return Integer.numberOfTrailingZeros(stateType);
    }

    static int stateIndexToType(int stateTypeIndex) {
        return 1 << stateTypeIndex;
    }

    static String stateTypesToString(int stateTypes) {
        StringBuilder sb = new StringBuilder("[");
        boolean needDelimiter = false;
        int stateType = Integer.highestOneBit(stateTypes);
    L3:
        if (stateType == 0) goto L16;
        if (needDelimiter == false) goto L6;
        sb.append('|');
    L6:
        needDelimiter = true;
        switch(stateType) {
            case 1: goto L14;
            case 2: goto L13;
            case 4: goto L12;
            case 8: goto L11;
            case 16: goto L10;
            default: goto L9;
        };
    L10:
        sb.append("PERMISSION");
    L15:
        stateTypes = stateTypes & (~stateType);
        stateType = Integer.highestOneBit(stateTypes);
        goto L3
    L11:
        sb.append("FGS_NOTIFICATION");
        goto L15
    L12:
        sb.append("FGS_LOCATION");
        goto L15
    L13:
        sb.append("FGS_MEDIA_PLAYBACK");
        goto L15
    L14:
        sb.append("MEDIA_SESSION");
        goto L15
    L9:
        return "[UNKNOWN(" + Integer.toHexString(stateTypes) + ")]";
    L16:
        sb.append("]");
        return sb.toString();
    }

    void registerStateListener(StateListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStateListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void notifyListenersOnStateChange(int uid, String packageName, boolean start, long now, int stateType) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
        int size = this.mStateListeners.size();     // Catch: Throwable -> L8
    L6:
        if (i >= size) goto L11;
        this.mStateListeners.get(i).onStateChange(uid, packageName, start, now, stateType);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    int getType() {
        return 0;
    }

    byte[] getTrackerInfoForStatsd(int uid) {
        return null;
    }

    T getPolicy() {
        return (T) this.mInjector.getPolicy();
    }

    void onSystemReady() {
        this.mInjector.onSystemReady();
    }

    void onUidAdded(int uid) {
    }

    void onUidRemoved(int uid) {
    }

    void onUserAdded(int userId) {
    }

    void onUserStarted(int userId) {
    }

    void onUserStopped(int userId) {
    }

    void onUserRemoved(int userId) {
    }

    void onLockedBootCompleted() {
    }

    void onPropertiesChanged(String name) {
        getPolicy().onPropertiesChanged(name);
    }

    void onUserInteractionStarted(String packageName, int uid) {
    }

    void onBackgroundRestrictionChanged(int uid, String pkgName, boolean restricted) {
    }

    void onUidProcStateChanged(int uid, int procState) {
    }

    void onUidGone(int uid) {
    }

    void dump(PrintWriter pw, String prefix) {
        this.mInjector.getPolicy().dump(pw, "  " + prefix);
    }

    void dumpAsProto(ProtoOutputStream proto, int uid) {
    }
}
