package com.android.server.pm;

/* JADX INFO: loaded from: classes2.dex */
interface PackageSender {
    void notifyPackageAdded(String r1, int r2);

    void notifyPackageChanged(String r1, int r2);

    void notifyPackageRemoved(String r1, int r2);
}
