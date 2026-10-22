package com.baidu.mshield.b.a;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.systemopt.SysPowerKit;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static String[] a(String r100) {
        String[] r101 = {"", "", "", ""};
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L36
        if (r102.exists() == true) goto L6;
    L38:
        return r101;
    L6:
        if (Build.VERSION.SDK_INT > 22) goto L9;
        r101[2] = a(r102.lastModified(), "yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L36
        return r101;
    L9:
        String[] r103 = f.a("stat " + r102.getAbsolutePath(), false).f32362b.split("\\|");     // Catch: Throwable -> L36
        int r104 = r103.length;     // Catch: Throwable -> L36
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L38;
        String r106 = r103[r105];     // Catch: Throwable -> L36
        if (r106.contains("Device") == false) goto L19;
        String[] r107 = r106.split("Inode:");     // Catch: Throwable -> L36
        if (r107.length <= 1) goto L19;
        String[] r108 = r107[1].split("Links");     // Catch: Throwable -> L36
        if (r108.length <= 0) goto L19;
        r101[0] = r108[0].trim();     // Catch: Throwable -> L36
    L19:
        if (r106.contains("Access") == false) goto L26;
        if (r106.contains(SysPowerKit.PWR_OVERUSE_UID) == true) goto L26;
        com.baidu.mshield.b.c.a.b("access " + r106);     // Catch: Throwable -> L36
        String[] r109 = r106.split("Access:");     // Catch: Throwable -> L36
        if (r109.length <= 1) goto L26;
        r101[1] = r109[1].trim();     // Catch: Throwable -> L36
    L26:
        if (r106.contains("Modify") == false) goto L31;
        com.baidu.mshield.b.c.a.b("Modify " + r106);     // Catch: Throwable -> L36
        String[] r110 = r106.split("Modify:");     // Catch: Throwable -> L36
        if (r110.length <= 1) goto L31;
        r101[2] = r110[1].trim();     // Catch: Throwable -> L36
    L31:
        if (r106.contains("Change") == false) goto L35;
        com.baidu.mshield.b.c.a.b("Change " + r106);     // Catch: Throwable -> L36
        String[] r111 = r106.split("Change:");     // Catch: Throwable -> L36
        if (r111.length <= 1) goto L35;
        r101[3] = r111[1].trim();     // Catch: Throwable -> L36
    L35:
        r105 = r105 + 1;
    L36:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        goto L38
    }

    public static String a(long r100, String r101) {
        if (r100 >= 0) goto L12;
    L11:
        return "";
    L12:
    L9:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        goto L11
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return new SimpleDateFormat(r101).format(new Date(r100));
    }
}
