package com.android.server.pm;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswPackageManagerShellCommand {
    int getUninstallUserId(int r1, String r2);

    boolean isDisallowUninstallByAdb(String r1);
}
