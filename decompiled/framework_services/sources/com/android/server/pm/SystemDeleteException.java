package com.android.server.pm;

/* JADX INFO: loaded from: classes2.dex */
final class SystemDeleteException extends Exception {
    final PackageManagerException mReason;

    SystemDeleteException(PackageManagerException reason) {
        this.mReason = reason;
    }
}
