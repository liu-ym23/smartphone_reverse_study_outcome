package com.android.server.pm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtInstallPackageHelper extends IExtBase {
    void modifyPackageSetting(PackageSetting r1, InstallRequest r2);

    default void showUpdateAppToastIfNeed(InstallRequest installRequest) {
    }
}
