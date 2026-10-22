package com.android.server.pm.verify.domain;

import android.content.Context;
import android.os.Binder;
import com.android.server.pm.verify.domain.proxy.DomainVerificationProxy;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationEnforcer {
    private Callback mCallback;
    private final Context mContext;

    public interface Callback {
        boolean doesUserExist(int r1);

        boolean filterAppAccess(String r1, int r2, int r3);
    }

    public DomainVerificationEnforcer(Context context) {
        this.mContext = context;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void assertInternal(int callingUid) {
        switch(callingUid) {
            case 0: goto L6;
            case 1000: goto L6;
            case 2000: goto L6;
            default: goto L4;
        };
    L6:
        return;
    L4:
        throw new SecurityException("Caller " + callingUid + " is not allowed to change internal state");
    }

    public void assertApprovedQuerent(int callingUid, DomainVerificationProxy proxy) {
        switch(callingUid) {
            case 0: goto L10;
            case 1000: goto L10;
            case 2000: goto L10;
            default: goto L4;
        };
    L10:
        return;
    L4:
        if (proxy.isCallerVerifier(callingUid) == true) goto L6;
        this.mContext.enforcePermission("android.permission.DUMP", Binder.getCallingPid(), callingUid, "Caller " + callingUid + " is not allowed to query domain verification state");
        return;
    L6:
        this.mContext.enforcePermission("android.permission.QUERY_ALL_PACKAGES", Binder.getCallingPid(), callingUid, "Caller " + callingUid + " does not hold android.permission.QUERY_ALL_PACKAGES");
    }

    public void assertApprovedVerifier(int callingUid, DomainVerificationProxy proxy) throws SecurityException {
        switch(callingUid) {
            case 0: goto L18;
            case 1000: goto L18;
            case 2000: goto L18;
            default: goto L4;
        };
    L4:
        int callingPid = Binder.getCallingPid();
        boolean isLegacyVerificationAgent = false;
        if (this.mContext.checkPermission("android.permission.DOMAIN_VERIFICATION_AGENT", callingPid, callingUid) != 0) goto L7;
    L15:
        if (isLegacyVerificationAgent == true) goto L17;
        this.mContext.enforcePermission("android.permission.QUERY_ALL_PACKAGES", callingPid, callingUid, "Caller " + callingUid + " does not hold android.permission.QUERY_ALL_PACKAGES");
    L17:
        boolean isAllowed = proxy.isCallerVerifier(callingUid);
    L19:
        if (isAllowed == false) goto L22;
        return;
    L22:
        throw new SecurityException("Caller " + callingUid + " is not the approved domain verification agent");
    L7:
        if (this.mContext.checkPermission("android.permission.INTENT_FILTER_VERIFICATION_AGENT", callingPid, callingUid) != 0) goto L9;
        boolean r3 = true;
    L10:
        isLegacyVerificationAgent = r3;
        if (isLegacyVerificationAgent == true) goto L15;
        throw new SecurityException("Caller " + callingUid + " does not hold android.permission.DOMAIN_VERIFICATION_AGENT");
    L9:
        r3 = false;
        goto L10
    L18:
        isAllowed = true;
        goto L19
    }

    public boolean assertApprovedUserStateQuerent(int callingUid, int callingUserId, String packageName, int targetUserId) throws SecurityException {
        if (callingUserId == targetUserId) goto L5;
        this.mContext.enforcePermission("android.permission.INTERACT_ACROSS_USERS", Binder.getCallingPid(), callingUid, "Caller is not allowed to edit other users");
    L5:
        if (this.mCallback.doesUserExist(callingUserId) == false) goto L13;
        if (this.mCallback.doesUserExist(targetUserId) == false) goto L11;
        return !this.mCallback.filterAppAccess(packageName, callingUid, targetUserId);
    L11:
        throw new SecurityException("User " + targetUserId + " does not exist");
    L13:
        throw new SecurityException("User " + callingUserId + " does not exist");
    }

    public boolean assertApprovedUserSelector(int callingUid, int callingUserId, String packageName, int targetUserId) throws SecurityException {
        if (callingUserId == targetUserId) goto L4;
        this.mContext.enforcePermission("android.permission.INTERACT_ACROSS_USERS", Binder.getCallingPid(), callingUid, "Caller is not allowed to edit other users");
    L4:
        this.mContext.enforcePermission("android.permission.UPDATE_DOMAIN_VERIFICATION_USER_SELECTION", Binder.getCallingPid(), callingUid, "Caller is not allowed to edit user selections");
        if (this.mCallback.doesUserExist(callingUserId) == false) goto L16;
        if (this.mCallback.doesUserExist(targetUserId) == false) goto L14;
        if (packageName != null) goto L12;
        return true;
    L12:
        return true ^ this.mCallback.filterAppAccess(packageName, callingUid, targetUserId);
    L14:
        throw new SecurityException("User " + targetUserId + " does not exist");
    L16:
        throw new SecurityException("User " + callingUserId + " does not exist");
    }

    public boolean callerIsLegacyUserSelector(int callingUid, int callingUserId, String packageName, int targetUserId) {
        this.mContext.enforcePermission("android.permission.SET_PREFERRED_APPLICATIONS", Binder.getCallingPid(), callingUid, "Caller is not allowed to edit user state");
        if (callingUserId == targetUserId) goto L9;
        if (this.mContext.checkPermission("android.permission.INTERACT_ACROSS_USERS", Binder.getCallingPid(), callingUid) == 0) goto L9;
        return false;
    L9:
        if (this.mCallback.doesUserExist(callingUserId) == false) goto L17;
        if (this.mCallback.doesUserExist(targetUserId) == false) goto L15;
        return !this.mCallback.filterAppAccess(packageName, callingUid, targetUserId);
    L15:
        throw new SecurityException("User " + targetUserId + " does not exist");
    L17:
        throw new SecurityException("User " + callingUserId + " does not exist");
    }

    public boolean callerIsLegacyUserQuerent(int callingUid, int callingUserId, String packageName, int targetUserId) {
        if (callingUserId == targetUserId) goto L5;
        this.mContext.enforcePermission("android.permission.INTERACT_ACROSS_USERS_FULL", Binder.getCallingPid(), callingUid, "Caller is not allowed to edit other users");
    L5:
        if (this.mCallback.doesUserExist(callingUserId) == false) goto L13;
        if (this.mCallback.doesUserExist(targetUserId) == false) goto L11;
        return !this.mCallback.filterAppAccess(packageName, callingUid, targetUserId);
    L11:
        throw new SecurityException("User " + targetUserId + " does not exist");
    L13:
        throw new SecurityException("User " + callingUserId + " does not exist");
    }

    public void assertOwnerQuerent(int callingUid, int callingUserId, int targetUserId) {
        int callingPid = Binder.getCallingPid();
        if (callingUserId == targetUserId) goto L5;
        this.mContext.enforcePermission("android.permission.INTERACT_ACROSS_USERS", callingPid, callingUid, "Caller is not allowed to query other users");
    L5:
        this.mContext.enforcePermission("android.permission.QUERY_ALL_PACKAGES", callingPid, callingUid, "Caller " + callingUid + " does not hold android.permission.QUERY_ALL_PACKAGES");
        this.mContext.enforcePermission("android.permission.UPDATE_DOMAIN_VERIFICATION_USER_SELECTION", callingPid, callingUid, "Caller is not allowed to query user selections");
        if (this.mCallback.doesUserExist(callingUserId) == false) goto L13;
        if (this.mCallback.doesUserExist(targetUserId) == false) goto L11;
        return;
    L11:
        throw new SecurityException("User " + targetUserId + " does not exist");
    L13:
        throw new SecurityException("User " + callingUserId + " does not exist");
    }
}
