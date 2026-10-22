package com.baidu.mshield.x0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static String[] a(Context r100, String r101) {
        String[] r102 = {"", "", ""};
        String r103 = r100.getExternalFilesDir(null).getParentFile().getParent();     // Catch: Throwable -> L13
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L13
        r104.append(r103);     // Catch: Throwable -> L13
        String r105 = File.separator;     // Catch: Throwable -> L13
        r104.append(r105);     // Catch: Throwable -> L13
        r104.append(r101);     // Catch: Throwable -> L13
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104.toString());     // Catch: Throwable -> L13
        if (r106.exists() == false) goto L6;
        r102[0] = r106.getAbsolutePath();     // Catch: Throwable -> L13
    L6:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103 + r105 + r101 + r105 + KevaImpl.PrivateConstants.FILES_DIR_NAME);     // Catch: Throwable -> L13
        if (r107.exists() == false) goto L9;
        r102[1] = r107.getAbsolutePath();     // Catch: Throwable -> L13
    L9:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r103 + r105 + r101 + r105 + "cache");     // Catch: Throwable -> L13
        if (r108.exists() == false) goto L15;
        r102[2] = r108.getAbsolutePath();     // Catch: Throwable -> L13
    L15:
        return r102;
    L13:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        goto L15
    }

    public static PackageInfo b(Context r100, String r101) {
        return com.baidu.mshield.b.e.c.a(r100, r101, 0);
    L5:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return null;
    }

    public static boolean c(Context r100, String r101) {
        if (new PolarisFileWrapper(r100.getExternalFilesDir(null).getParentFile().getParent() + File.separator + r101).exists() == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return false;
    }

    public static int a(Context r100, String r101, List<String> r110) {
    L30:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    L32:
        return 1;
    L4:
        if (c(r100, r101) == false) goto L6;
        return 0;
    L6:
        if (r110 != null) goto L8;
    L29:
        return 1;
    L8:
        if (r110.size() == 0) goto L29;
        int r102 = 0;
        boolean r103 = false;
    L12:
        if (r102 >= r110.size()) goto L26;
        String r104 = r110.get(r102);     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r104) == true) goto L25;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);     // Catch: Throwable -> L30
        if (r105.exists() == false) goto L25;
        PackageInfo r106 = b(r100, r101);     // Catch: Throwable -> L30
        if (r106 == null) goto L24;
        if (r106.firstInstallTime < r105.lastModified()) goto L24;
        return 0;
    L24:
        r103 = true;
    L25:
        r102 = r102 + 1;
        goto L12
    L26:
        if (r103 == true) goto L32;
        return 2;
    }
}
