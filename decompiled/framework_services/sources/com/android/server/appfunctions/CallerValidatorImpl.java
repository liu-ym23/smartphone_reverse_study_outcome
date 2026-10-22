package com.android.server.appfunctions;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.UserHandle;
import com.android.internal.infra.AndroidFuture;

/* JADX INFO: loaded from: classes.dex */
class CallerValidatorImpl implements CallerValidator {
    private final Context mContext;

    CallerValidatorImpl(Context context) {
        context.getClass();
        this.mContext = context;
    }

    @Override // com.android.server.appfunctions.CallerValidator
    public String validateCallingPackage(String claimedCallingPackage) {
        int callingUid = Binder.getCallingUid();
        long callingIdentityToken = Binder.clearCallingIdentity();
        validateCallingPackageInternal(callingUid, claimedCallingPackage);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(callingIdentityToken);
        return claimedCallingPackage;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentityToken);
        throw th;
    }

    @Override // com.android.server.appfunctions.CallerValidator
    public UserHandle verifyTargetUserHandle(UserHandle targetUserHandle, String claimedCallingPackage) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long callingIdentityToken = Binder.clearCallingIdentity();
        UserHandle r4 = handleIncomingUser(claimedCallingPackage, targetUserHandle, callingPid, callingUid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(callingIdentityToken);
        return r4;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentityToken);
        throw th;
    }

    @Override // com.android.server.appfunctions.CallerValidator
    public AndroidFuture<Integer> verifyCallerCanExecuteAppFunction(int callingUid, int callingPid, UserHandle targetUser, String callerPackageName, String targetPackageName, String functionId) {
        if (this.mContext.checkPermission("android.permission.EXECUTE_APP_FUNCTIONS", callingPid, callingUid) != 0) goto L5;
        boolean hasExecutionPermission = true;
    L6:
        if (hasExecutionPermission == false) goto L10;
        return AndroidFuture.completedFuture(2);
    L10:
        if (callerPackageName.equals(targetPackageName) == false) goto L14;
        return AndroidFuture.completedFuture(1);
    L14:
        return AndroidFuture.completedFuture(0);
    L5:
        hasExecutionPermission = false;
        goto L6
    }

    @Override // com.android.server.appfunctions.CallerValidator
    public boolean verifyEnterprisePolicyIsAllowed(UserHandle callingUser, UserHandle targetUser) {
        int callingUserPolicy = getDevicePolicyManagerAsUser(callingUser).getAppFunctionsPolicy();
        int targetUserPolicy = getDevicePolicyManagerAsUser(targetUser).getAppFunctionsPolicy();
        boolean isSameUser = callingUser.equals(targetUser);
        if (isAppFunctionPolicyAllowed(targetUserPolicy, isSameUser) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppFunctionPolicyAllowed(callingUserPolicy, isSameUser) == false) goto L7;
        return true;
    }

    private UserHandle handleIncomingUser(String callingPackageName, UserHandle targetUserHandle, int callingPid, int callingUid) {
        UserHandle callingUserHandle = UserHandle.getUserHandleForUid(callingUid);
        if (callingUserHandle.equals(targetUserHandle) == false) goto L6;
        return targetUserHandle;
    L6:
        if (targetUserHandle.getIdentifier() < 0) goto L17;
        if (this.mContext.checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingPid, callingUid) != 0) goto L15;
        this.mContext.createPackageContextAsUser(callingPackageName, 0, targetUserHandle);     // Catch: PackageManager.NameNotFoundException -> L11
        return targetUserHandle;
    L13:
        throw new SecurityException("Package: " + callingPackageName + " haven't installed for user " + targetUserHandle.getIdentifier());
    L15:
        throw new SecurityException("Permission denied while calling from uid " + callingUid + " with " + targetUserHandle + "; Requires permission: android.permission.INTERACT_ACROSS_USERS_FULL");
    L17:
        throw new IllegalArgumentException("Call does not support special user " + targetUserHandle);
    }

    private void validateCallingPackageInternal(int actualCallingUid, String claimedCallingPackage) {
        UserHandle callingUserHandle = UserHandle.getUserHandleForUid(actualCallingUid);
        Context actualCallingUserContext = this.mContext.createContextAsUser(callingUserHandle, 0);
        int claimedCallingUid = getPackageUid(actualCallingUserContext, claimedCallingPackage);
        if (claimedCallingUid != actualCallingUid) goto L6;
        return;
    L6:
        throw new SecurityException("Specified calling package [" + claimedCallingPackage + "] does not match the calling uid " + actualCallingUid);
    }

    private int getPackageUid(Context context, String packageName) {
        return context.getPackageManager().getPackageUid(packageName, 0);
    L5:
        return -1;
    }

    private boolean isAppFunctionPolicyAllowed(int userPolicy, boolean isSameUser) {
        switch(userPolicy) {
            case 0: goto L5;
            case 1: goto L3;
            case 2: goto L8;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    L8:
        return isSameUser;
    }

    private DevicePolicyManager getDevicePolicyManagerAsUser(UserHandle targetUser) {
        return (DevicePolicyManager) this.mContext.createContextAsUser(targetUser, 0).getSystemService(DevicePolicyManager.class);
    }
}
