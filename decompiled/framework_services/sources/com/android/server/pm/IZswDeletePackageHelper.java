package com.android.server.pm;

import android.content.pm.IPackageDeleteObserver2;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswDeletePackageHelper {
    void deletePackage(String r1, int r2, int r3, PackageManagerService r4);

    boolean deleteRestrictedByZTE(String r1, IPackageDeleteObserver2 r2, PackageManagerService r3);
}
