package com.android.server.pm;

import android.util.ExceptionUtils;

/* JADX INFO: loaded from: classes2.dex */
final class PrepareFailure extends PackageManagerException {
    public String mConflictingPackage;
    public String mConflictingPermission;

    PrepareFailure(int error) {
        super(error, "Failed to prepare for install.");
    }

    PrepareFailure(int error, String detailMessage) {
        super(error, detailMessage);
    }

    public static PrepareFailure ofInternalError(String detailMessage, int internalErrorCode) {
        return new PrepareFailure(-110, detailMessage, internalErrorCode);
    }

    private PrepareFailure(int error, String message, int internalErrorCode) {
        super(error, message, internalErrorCode);
    }

    PrepareFailure(String message, Exception e) {
        if ((e instanceof PackageManagerException) == false) goto L5;
        int r0 = ((PackageManagerException) e).error;
    L6:
        super(r0, ExceptionUtils.getCompleteMessage(message, e));
        return;
    L5:
        r0 = -110;
        goto L6
    }

    PrepareFailure conflictsWithExistingPermission(String conflictingPermission, String conflictingPackage) {
        this.mConflictingPermission = conflictingPermission;
        this.mConflictingPackage = conflictingPackage;
        return this;
    }
}
