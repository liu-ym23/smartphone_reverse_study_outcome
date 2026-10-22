package com.android.server.pm;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswPackageInstallerSession {
    void doWriteInstallingPackage(String r1, File r2, String r3);

    void setIntallingPackageVerified(boolean r1);
}
