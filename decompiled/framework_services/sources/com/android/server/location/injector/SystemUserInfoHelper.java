package com.android.server.location.injector;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.IActivityManager;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.pm.UserManagerInternal;
import java.io.FileDescriptor;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class SystemUserInfoHelper extends UserInfoHelper {
    private IActivityManager mActivityManager;
    private ActivityManagerInternal mActivityManagerInternal;
    private final Context mContext;
    private UserManager mUserManager;
    private UserManagerInternal mUserManagerInternal;

    public static /* synthetic */ void $r8$lambda$rmbCOanELEWco8WhmNYmOOvB1A0(SystemUserInfoHelper r0, int r1, boolean r2) {
        r0.lambda$onSystemReady$0(r1, r2);
    }

    public SystemUserInfoHelper(Context context) {
        this.mContext = context;
    }

    public synchronized void onSystemReady() {
        monitor-enter(this);
        UserManagerInternal r0 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);     // Catch: Throwable -> L6
        r0.getClass();     // Catch: Throwable -> L6
        this.mUserManagerInternal = r0;     // Catch: Throwable -> L6
        this.mUserManagerInternal.addUserVisibilityListener(new SystemUserInfoHelper$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onSystemReady$0(int userId, boolean visible) {
        dispatchOnVisibleUserChanged(userId, visible);
    }

    protected final ActivityManagerInternal getActivityManagerInternal() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mActivityManagerInternal != null) goto L8;
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return this.mActivityManagerInternal;
    }

    protected final IActivityManager getActivityManager() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mActivityManager != null) goto L8;
        this.mActivityManager = ActivityManager.getService();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return this.mActivityManager;
    }

    protected final UserManager getUserManager() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mUserManager != null) goto L8;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return this.mUserManager;
    }

    @Override // com.android.server.location.injector.UserInfoHelper
    public int[] getRunningUserIds() {
        IActivityManager activityManager = getActivityManager();
        if (activityManager == null) goto L16;
        long identity = Binder.clearCallingIdentity();
        int[] r3 = activityManager.getRunningUserIds();     // Catch: Throwable -> L8 RemoteException -> L10
        Binder.restoreCallingIdentity(identity);
        return r3;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L8
    L16:
        return new int[0];
    }

    @Override // com.android.server.location.injector.UserInfoHelper
    public boolean isCurrentUserId(int userId) {
        ActivityManagerInternal activityManagerInternal = getActivityManagerInternal();
        if (activityManagerInternal == null) goto L11;
        long identity = Binder.clearCallingIdentity();
        boolean r3 = activityManagerInternal.isCurrentProfile(userId);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return r3;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L11:
        return false;
    }

    @Override // com.android.server.location.injector.UserInfoHelper
    public int getCurrentUserId() {
        ActivityManagerInternal activityManagerInternal = getActivityManagerInternal();
        if (activityManagerInternal == null) goto L11;
        long identity = Binder.clearCallingIdentity();
        int r3 = activityManagerInternal.getCurrentUserId();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return r3;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L11:
        return ProcessList.INVALID_ADJ;
    }

    @Override // com.android.server.location.injector.UserInfoHelper
    public boolean isVisibleUserId(int userId) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.mUserManagerInternal == null) goto L6;
        boolean r0 = true;
    L7:
        Preconditions.checkState(r0);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        long identity = Binder.clearCallingIdentity();
        monitor-enter(this);     // Catch: Throwable -> L18
        boolean r2 = this.mUserManagerInternal.isUserVisible(userId);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);
        return r2;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L6:
        r0 = false;
        goto L7
    }

    @Override // com.android.server.location.injector.UserInfoHelper
    protected int[] getProfileIds(int userId) {
        UserManager userManager = getUserManager();
        if (userManager == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1);
        long identity = Binder.clearCallingIdentity();
        int[] r3 = userManager.getEnabledProfileIds(userId);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return r3;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.UserInfoHelper
    public void dump(FileDescriptor fd, IndentingPrintWriter pw, String[] args) {
        int[] runningUserIds = getRunningUserIds();
        if (runningUserIds.length <= 1) goto L5;
        pw.println("running users: u" + Arrays.toString(runningUserIds));
    L5:
        ActivityManagerInternal activityManagerInternal = getActivityManagerInternal();
        if (activityManagerInternal != null) goto L8;
        return;
    L8:
        int[] currentProfileIds = activityManagerInternal.getCurrentProfileIds();
        pw.println("current users: u" + Arrays.toString(currentProfileIds));
        UserManager userManager = getUserManager();
        if (userManager == null) goto L17;
        int r4 = currentProfileIds.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L21;
        int userId = currentProfileIds[r5];
        if (userManager.hasUserRestrictionForUser("no_share_location", UserHandle.of(userId)) == false) goto L16;
        pw.increaseIndent();
        pw.println("u" + userId + " restricted");
        pw.decreaseIndent();
    L16:
        r5 = r5 + 1;
        goto L12
    L21:
        return;
    }
}
