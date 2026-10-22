package com.android.server;

import android.content.ContentResolver;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import android.provider.Settings;
import com.android.server.am.ActivityManagerService;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.Slogf;
import com.android.server.utils.TimingsTraceAndSlog;

/* JADX INFO: loaded from: classes.dex */
final class HsumBootUserInitializer {
    private static final String TAG = null;
    private final ActivityManagerService mAms;
    private final ContentResolver mContentResolver;
    private final ContentObserver mDeviceProvisionedObserver;
    private final PackageManagerService mPms;
    private final boolean mShouldAlwaysHaveMainUser;
    private final UserManagerInternal mUmi;

    /* JADX INFO: renamed from: -$$Nest$fgetmContentResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m253$$Nest$fgetmContentResolver(HsumBootUserInitializer r0) {
        return r0.mContentResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceProvisionedObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentObserver m254$$Nest$fgetmDeviceProvisionedObserver(HsumBootUserInitializer r0) {
        return r0.mDeviceProvisionedObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$misDeviceProvisioned, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m255$$Nest$misDeviceProvisioned(HsumBootUserInitializer r0) {
        return r0.isDeviceProvisioned();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m256$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = HsumBootUserInitializer.class.getSimpleName();
    }

    public static HsumBootUserInitializer createInstance(ActivityManagerService am, PackageManagerService pms, ContentResolver contentResolver, boolean shouldAlwaysHaveMainUser) {
        if (UserManager.isHeadlessSystemUserMode() == true) goto L7;
        return null;
    L7:
        return new HsumBootUserInitializer((UserManagerInternal) LocalServices.getService(UserManagerInternal.class), am, pms, contentResolver, shouldAlwaysHaveMainUser);
    }

    private HsumBootUserInitializer(UserManagerInternal umi, ActivityManagerService am, PackageManagerService pms, ContentResolver contentResolver, boolean shouldAlwaysHaveMainUser) {
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mDeviceProvisionedObserver = new AnonymousClass1(this, r1);
        this.mUmi = umi;
        this.mAms = am;
        this.mPms = pms;
        this.mContentResolver = contentResolver;
        this.mShouldAlwaysHaveMainUser = shouldAlwaysHaveMainUser;
    }

    public void init(TimingsTraceAndSlog t) {
        Slogf.i(TAG, "init())");
        if (this.mShouldAlwaysHaveMainUser == false) goto L6;
        t.traceBegin("createMainUserIfNeeded");
        createMainUserIfNeeded();
        t.traceEnd();
        return;
    }

    private void createMainUserIfNeeded() {
        int mainUser = this.mUmi.getMainUserId();
        if (mainUser == (-10000)) goto L6;
        Slogf.d(TAG, "Found existing MainUser, userId=%d", new Object[]{Integer.valueOf(mainUser)});
        return;
    L6:
        Slogf.d(TAG, "Creating a new MainUser");
        UserInfo newInitialUser = this.mUmi.createUserEvenWhenDisallowed(null, "android.os.usertype.full.SECONDARY", 16386, null, null);     // Catch: UserManager.CheckedUserOperationException -> L9
        Slogf.i(TAG, "Successfully created MainUser, userId=%d", new Object[]{Integer.valueOf(newInitialUser.id)});     // Catch: UserManager.CheckedUserOperationException -> L9
        return;
    L9:
        e = move-exception;
        Slogf.wtf(TAG, "Initial bootable MainUser creation failed", e);
    }

    public void systemRunning(TimingsTraceAndSlog t) {
        observeDeviceProvisioning();
        unlockSystemUser(t);
        t.traceBegin("getBootUser");     // Catch: UserManager.CheckedUserOperationException -> L5
        int bootUser = this.mUmi.getBootUser(this.mPms.hasSystemFeature("android.hardware.type.automotive", 0));     // Catch: UserManager.CheckedUserOperationException -> L5
        t.traceEnd();     // Catch: UserManager.CheckedUserOperationException -> L5
        t.traceBegin("switchToBootUser-" + bootUser);     // Catch: UserManager.CheckedUserOperationException -> L5
        switchToBootUser(bootUser);     // Catch: UserManager.CheckedUserOperationException -> L5
        t.traceEnd();     // Catch: UserManager.CheckedUserOperationException -> L5
        return;
    L6:
        Slogf.wtf(TAG, "Failed to switch to boot user since there isn't one.");
    }

    private void observeDeviceProvisioning() {
        if (isDeviceProvisioned() == false) goto L5;
        return;
    L5:
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("device_provisioned"), false, this.mDeviceProvisionedObserver);
    }

    private boolean isDeviceProvisioned() {
        if (Settings.Global.getInt(this.mContentResolver, "device_provisioned") == 1) goto L7;
        return false;
    L7:
        return true;
    L8:
        e = move-exception;
        Slogf.wtf(TAG, "DEVICE_PROVISIONED setting not found.", e);
        return false;
    }

    private void unlockSystemUser(TimingsTraceAndSlog t) {
        Slogf.i(TAG, "Unlocking system user");
        t.traceBegin("unlock-system-user");
        t.traceBegin("am.startUser");     // Catch: Throwable -> L9
        boolean started = this.mAms.startUserInBackgroundWithListener(0, null);     // Catch: Throwable -> L9
        t.traceEnd();     // Catch: Throwable -> L9
        if (started == true) goto L11;
        Slogf.w(TAG, "could not restart system user in background; trying unlock instead");     // Catch: Throwable -> L9
        t.traceBegin("am.unlockUser");     // Catch: Throwable -> L9
        boolean unlocked = this.mAms.unlockUser(0, null, null, null);     // Catch: Throwable -> L9
        t.traceEnd();     // Catch: Throwable -> L9
        if (unlocked == true) goto L11;
        Slogf.w(TAG, "could not unlock system user either");     // Catch: Throwable -> L9
    L11:
        t.traceEnd();
        return;
    L9:
        th = move-exception;
        t.traceEnd();
        throw th;
    }

    private void switchToBootUser(int bootUserId) {
        Slogf.i(TAG, "Switching to boot user %d", new Object[]{Integer.valueOf(bootUserId)});
        boolean started = this.mAms.startUserInForegroundWithListener(bootUserId, null);
        if (started == true) goto L6;
        Slogf.wtf(TAG, "Failed to start user %d in foreground", new Object[]{Integer.valueOf(bootUserId)});
        return;
    }
}
