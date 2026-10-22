package com.android.server.am;

import android.os.UserHandle;
import com.android.server.appop.AppOpsService;
import com.android.server.pm.permission.AccessCheckDelegate;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AccessCheckDelegateHelper {
    private AccessCheckDelegate mAccessCheckDelegate;
    private final List<ActiveInstrumentation> mActiveInstrumentation;
    private final AppOpsService mAppOpsService;
    private final PermissionManagerServiceInternal mPermissionManagerInternal;
    private final ActivityManagerGlobalLock mProcLock;

    AccessCheckDelegateHelper(ActivityManagerGlobalLock procLock, List<ActiveInstrumentation> activeInstrumentation, AppOpsService appOpsService, PermissionManagerServiceInternal permissionManagerInternal) {
        this.mProcLock = procLock;
        this.mActiveInstrumentation = activeInstrumentation;
        this.mAppOpsService = appOpsService;
        this.mPermissionManagerInternal = permissionManagerInternal;
    }

    private AccessCheckDelegate getAccessCheckDelegateLPr(boolean create) {
        if (create == false) goto L7;
        if (this.mAccessCheckDelegate != null) goto L7;
        this.mAccessCheckDelegate = new AccessCheckDelegate.AccessCheckDelegateImpl();
        this.mAppOpsService.setCheckOpsDelegate(this.mAccessCheckDelegate);
        this.mPermissionManagerInternal.setCheckPermissionDelegate(this.mAccessCheckDelegate);
    L7:
        return this.mAccessCheckDelegate;
    }

    private void removeAccessCheckDelegateLPr() {
        this.mAccessCheckDelegate = null;
        this.mAppOpsService.setCheckOpsDelegate(null);
        this.mPermissionManagerInternal.setCheckPermissionDelegate(null);
    }

    void startDelegateShellPermissionIdentity(int delegateUid, String[] permissions) {
        if (UserHandle.getCallingAppId() != 2000) goto L5;
    L9:
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L19
        if (delegate == null) goto L21;
        if (delegate.isDelegateAndOwnerUid(delegateUid) == true) goto L21;
        throw new SecurityException("Shell can delegate permissions only to one instrumentation at a time");     // Catch: Throwable -> L19
    L21:
        int instrCount = this.mActiveInstrumentation.size();     // Catch: Throwable -> L19
        int i = 0;
    L22:
        if (i >= instrCount) goto L35;
        ActiveInstrumentation instr = this.mActiveInstrumentation.get(i);     // Catch: Throwable -> L19
        if (instr.mTargetInfo.uid == delegateUid) goto L27;
        i = i + 1;     // Catch: Throwable -> L19
        goto L22
    L27:
        if (instr.mUiAutomationConnection == null) goto L33;
        String packageName = instr.mTargetInfo.packageName;     // Catch: Throwable -> L19
        getAccessCheckDelegateLPr(true).setShellPermissionDelegate(delegateUid, packageName, permissions);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L33:
        throw new SecurityException("Shell can delegate its permissions only to an instrumentation started from the shell");     // Catch: Throwable -> L19
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L19
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L19:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L5:
        if (UserHandle.getCallingAppId() == 0) goto L9;
        throw new SecurityException("Only the shell can delegate its permissions");
    }

    void stopDelegateShellPermissionIdentity() {
        if (UserHandle.getCallingAppId() != 2000) goto L5;
    L9:
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L17
        if (delegate != null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L17
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L20:
        if (delegate.hasShellPermissionDelegate() == true) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L17
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L24:
        delegate.removeShellPermissionDelegate();     // Catch: Throwable -> L17
        if (delegate.hasDelegateOrOverrides() == true) goto L27;
        removeAccessCheckDelegateLPr();     // Catch: Throwable -> L17
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L17
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L17:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L5:
        if (UserHandle.getCallingAppId() == 0) goto L9;
        throw new SecurityException("Only the shell can delegate its permissions");
    }

    List<String> getDelegatedShellPermissions() {
        if (UserHandle.getCallingAppId() != 2000) goto L5;
    L9:
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L18
        if (delegate != null) goto L20;
        List<String> r2 = Collections.EMPTY_LIST;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r2;
    L20:
        List<String> r3 = delegate.getDelegatedPermissionNames();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r3;
    L18:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L5:
        if (UserHandle.getCallingAppId() == 0) goto L9;
        throw new SecurityException("Only the shell can get delegated permissions");
    }

    void addOverridePermissionState(int originatingUid, int uid, String permission, int result) {
        if (UserHandle.getCallingAppId() != 0) goto L38;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        int instrCount = this.mActiveInstrumentation.size();     // Catch: Throwable -> L22
        int i = 0;
    L7:
        if (i >= instrCount) goto L31;
        ActiveInstrumentation instr = this.mActiveInstrumentation.get(i);     // Catch: Throwable -> L22
        if (instr.mTargetInfo.uid == originatingUid) goto L12;
        i = i + 1;     // Catch: Throwable -> L22
        goto L7
    L12:
        if (instr.mSourceUid != 0) goto L29;
        if (instr.mUiAutomationConnection == null) goto L29;
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(true);     // Catch: Throwable -> L22
        if (delegate.hasOverriddenPermissions() == true) goto L18;
    L24:
        delegate.addOverridePermissionState(originatingUid, uid, permission, result);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L18:
        if (delegate.isDelegateAndOwnerUid(originatingUid) == true) goto L24;
        throw new SecurityException("Only one instrumentation to grant overrides is allowed at a time.");     // Catch: Throwable -> L22
    L29:
        throw new SecurityException("Root can only override permissions only if the owning app was instrumented from root.");     // Catch: Throwable -> L22
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L22
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L22:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L38:
        throw new SecurityException("Only root can override permissions");
    }

    void removeOverridePermissionState(int originatingUid, int uid, String permission) {
        if (UserHandle.getCallingAppId() != 0) goto L33;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L12
        if (delegate != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L15:
        if (delegate.isDelegateAndOwnerUid(originatingUid) == false) goto L17;
        delegate.removeOverridePermissionState(uid, permission);     // Catch: Throwable -> L12
        if (delegate.hasDelegateOrOverrides() == true) goto L26;
        removeAccessCheckDelegateLPr();     // Catch: Throwable -> L12
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L17:
        if (delegate.hasOverriddenPermissions() == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L22:
        throw new SecurityException("Only the granter of current overrides can remove them.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L33:
        throw new SecurityException("Only root can override permissions.");
    }

    void clearOverridePermissionStates(int originatingUid, int uid) {
        if (UserHandle.getCallingAppId() != 0) goto L33;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L12
        if (delegate != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L15:
        if (delegate.isDelegateAndOwnerUid(originatingUid) == false) goto L17;
        delegate.clearOverridePermissionStates(uid);     // Catch: Throwable -> L12
        if (delegate.hasDelegateOrOverrides() == true) goto L26;
        removeAccessCheckDelegateLPr();     // Catch: Throwable -> L12
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L17:
        if (delegate.hasOverriddenPermissions() == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L22:
        throw new SecurityException("Only the granter of current overrides can remove them.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L33:
        throw new SecurityException("Only root can override permissions.");
    }

    void clearAllOverridePermissionStates(int originatingUid) {
        if (UserHandle.getCallingAppId() != 0) goto L33;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L12
        if (delegate != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L15:
        if (delegate.isDelegateAndOwnerUid(originatingUid) == false) goto L17;
        delegate.clearAllOverridePermissionStates();     // Catch: Throwable -> L12
        if (delegate.hasDelegateOrOverrides() == true) goto L26;
        removeAccessCheckDelegateLPr();     // Catch: Throwable -> L12
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L17:
        if (delegate.hasOverriddenPermissions() == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L22:
        throw new SecurityException("Only the granter of current overrides can remove them.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L33:
        throw new SecurityException("Only root can override permissions.");
    }

    void onInstrumentationFinished(int uid, String packageName) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        AccessCheckDelegate delegate = getAccessCheckDelegateLPr(false);     // Catch: Throwable -> L10
        if (delegate != null) goto L8;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L8:
        if (delegate.isDelegatePackage(uid, packageName) == false) goto L13;
        delegate.removeShellPermissionDelegate();     // Catch: Throwable -> L10
    L13:
        if (delegate.isDelegateAndOwnerUid(uid) == false) goto L16;
        delegate.clearAllOverridePermissionStates();     // Catch: Throwable -> L10
    L16:
        if (delegate.hasDelegateOrOverrides() == true) goto L18;
        removeAccessCheckDelegateLPr();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }
}
