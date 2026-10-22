package com.android.server.pm;

/* JADX INFO: loaded from: classes2.dex */
final class ReconcileFailure extends PackageManagerException {
    public static ReconcileFailure ofInternalError(String message, int internalErrorCode) {
        return new ReconcileFailure(message, internalErrorCode);
    }

    private ReconcileFailure(String message, int internalErrorCode) {
        super(-110, "Reconcile failed: " + message, internalErrorCode);
    }

    ReconcileFailure(int reason, String message) {
        super(reason, "Reconcile failed: " + message);
    }

    ReconcileFailure(PackageManagerException e) {
        this(e.error, e.getMessage());
    }
}
