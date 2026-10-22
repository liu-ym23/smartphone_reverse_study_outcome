package com.android.server.wm;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.utils.UserTokenWatcher;

/* JADX INFO: loaded from: classes3.dex */
class KeyguardDisableHandler {
    private static final String TAG = "WindowManager";
    private final UserTokenWatcher mAppTokenWatcher;
    private final UserTokenWatcher.Callback mCallback;
    private int mCurrentUser;
    private Injector mInjector;
    private final UserTokenWatcher mSystemTokenWatcher;

    interface Injector {
        boolean dpmRequiresPassword(int r1);

        void enableKeyguard(boolean r1);

        int getProfileParentId(int r1);

        boolean isKeyguardSecure(int r1);
    }

    KeyguardDisableHandler(Injector injector, Handler handler) {
        this.mCurrentUser = 0;
        this.mCallback = new AnonymousClass1(this);
        this.mInjector = injector;
        this.mAppTokenWatcher = new UserTokenWatcher(this.mCallback, handler, TAG);
        this.mSystemTokenWatcher = new UserTokenWatcher(this.mCallback, handler, TAG);
    }

    public void setCurrentUser(int user) {
        monitor-enter(this);
        this.mCurrentUser = user;     // Catch: Throwable -> L6
        updateKeyguardEnabledLocked(-1);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void updateKeyguardEnabled(int userId) {
        monitor-enter(this);
        updateKeyguardEnabledLocked(userId);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateKeyguardEnabledLocked(int userId) {
        if (this.mCurrentUser != userId) goto L5;
    L6:
        this.mInjector.enableKeyguard(shouldKeyguardBeEnabled(this.mCurrentUser));
        return;
    L5:
        if (userId == (-1)) goto L6;
    }

    void disableKeyguard(IBinder token, String tag, int callingUid, int userId) {
        UserTokenWatcher watcherForCaller = watcherForCallingUid(token, callingUid);
        watcherForCaller.acquire(token, tag, this.mInjector.getProfileParentId(userId));
    }

    void reenableKeyguard(IBinder token, int callingUid, int userId) {
        UserTokenWatcher watcherForCaller = watcherForCallingUid(token, callingUid);
        watcherForCaller.release(token, this.mInjector.getProfileParentId(userId));
    }

    private UserTokenWatcher watcherForCallingUid(IBinder token, int callingUid) {
        if (Process.isApplicationUid(callingUid) == false) goto L7;
        return this.mAppTokenWatcher;
    L7:
        if (callingUid != 1000) goto L13;
        if ((token instanceof LockTaskController.LockTaskToken) == false) goto L13;
        return this.mSystemTokenWatcher;
    L13:
        throw new UnsupportedOperationException("Only apps can use the KeyguardLock API");
    }

    private boolean shouldKeyguardBeEnabled(int userId) {
        boolean dpmRequiresPassword = this.mInjector.dpmRequiresPassword(this.mCurrentUser);
        boolean keyguardSecure = this.mInjector.isKeyguardSecure(this.mCurrentUser);
        if (dpmRequiresPassword == true) goto L6;
        if (keyguardSecure == true) goto L6;
        boolean allowedFromApps = true;
    L7:
        boolean allowedFromSystem = !dpmRequiresPassword;
        if (allowedFromApps == true) goto L10;
    L12:
        if (allowedFromSystem == true) goto L14;
    L16:
        boolean shouldBeDisabled = false;
    L18:
        if (shouldBeDisabled == false) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (this.mSystemTokenWatcher.isAcquired(userId) == false) goto L16;
    L15:
        shouldBeDisabled = true;
        goto L18
    L10:
        if (this.mAppTokenWatcher.isAcquired(userId) == true) goto L15;
    L6:
        allowedFromApps = false;
        goto L7
    }

    static KeyguardDisableHandler create(Context context, final WindowManagerPolicy policy, Handler handler) {
        final UserManagerInternal userManager = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        return new KeyguardDisableHandler(new AnonymousClass2(policy, userManager), handler);
    }
}
