package com.amap.api.col.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f26193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f26194b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f26195c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f26196d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f26197e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f26198f = "";

    public static boolean a() {
        if (f26194b == false) goto L7;
        return true;
    L7:
        if (b(f26193a) == false) goto L11;
        f26194b = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(f26193a) == true) goto L15;
        f26194b = false;     // Catch: Throwable -> L23
        f26193a = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (b(f26196d) == false) goto L19;
        f26194b = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(f26196d) == true) goto L22;
        f26194b = false;     // Catch: Throwable -> L23
        f26196d = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    public static String a(Context r100) {
        return h(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return f26198f;
    }

    private static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L21;
        r100.toCharArray();
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L19;
        char r104 = r101[r103];
        if ('A' > r104) goto L11;
        if (r104 > 'z') goto L11;
    L18:
        r103 = r103 + 1;
    L11:
        if ('0' > r104) goto L15;
        if (r104 <= ':') goto L18;
    L15:
        if (r104 == '.') goto L18;
        cg.b(bs.a(), r100, "errorPackage");     // Catch: Throwable -> L22
    L17:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static String c(Context r100) {
        String r101 = f26196d;     // Catch: Throwable -> L12
        if (r101 != null) goto L5;
    L8:
        String r102 = r100.getPackageName();     // Catch: Throwable -> L12
        f26196d = r102;     // Catch: Throwable -> L12
        if (b(r102) == true) goto L15;
        f26196d = r100.getPackageName();     // Catch: Throwable -> L12
    L15:
        return f26196d;
    L5:
        if ("".equals(r101) == true) goto L8;
        return f26196d;
    L12:
        th = move-exception;
        cd.a(th, "AI", "gpck");
        goto L15
    }

    public static String d(Context r100) {
    L9:
        th = move-exception;
        cd.a(th, "AI", "gAV");
    L11:
        String r101 = f26197e;
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L4:
        if ("".equals(f26197e) == false) goto L6;
        f26197e = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return f26197e;
    }

    public static String e(Context r100) {
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64);     // Catch: Throwable -> L18
        int r102 = 0;
        byte[] r103 = r101.signatures[0].toByteArray();     // Catch: Throwable -> L18
        byte[] r104 = MessageDigest.getInstance(bs.c("IU0hBMQ")).digest(r103);     // Catch: Throwable -> L18
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L18
    L4:
        if (r102 >= r104.length) goto L9;
        String r106 = Integer.toHexString(r104[r102] & UByte.MAX_VALUE).toUpperCase(Locale.US);     // Catch: Throwable -> L18
        if (r106.length() != 1) goto L8;
        r105.append("0");     // Catch: Throwable -> L18
    L8:
        r105.append(r106);     // Catch: Throwable -> L18
        r105.append(":");     // Catch: Throwable -> L18
        r102 = r102 + 1;     // Catch: Throwable -> L18
        goto L4
    L9:
        String r107 = r101.packageName;     // Catch: Throwable -> L18
        if (b(r107) == false) goto L13;
        r107 = r101.packageName;     // Catch: Throwable -> L18
    L13:
        if (TextUtils.isEmpty(f26196d) == true) goto L16;
        r107 = c(r100);     // Catch: Throwable -> L18
    L16:
        r105.append(r107);     // Catch: Throwable -> L18
        String r108 = r105.toString();     // Catch: Throwable -> L18
        f26193a = r108;     // Catch: Throwable -> L18
        return r108;
    L18:
        th = move-exception;
        cd.a(th, "AI", "gsp");
        return f26193a;
    }

    public static String f(Context r100) {
        bj.a(r100);     // Catch: Throwable -> L8
    L11:
        return h(r100);
    L5:
        th = move-exception;
        cd.a(th, "AI", "gKy");
        return f26198f;
    }

    private static String g(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(ce.c(r100, "k.store"));
        String r102 = "";
        if (r101.exists() == true) goto L50;
        return "";
    L50:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L18
        byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L16
        r103.read(r104);     // Catch: Throwable -> L16
        String r105 = bs.a(r104);     // Catch: Throwable -> L16
        if (r105.length() != 32) goto L42;
        r102 = r105;
    L42:
        r103.close();     // Catch: Throwable -> L13
    L15:
        return r102;
    L13:
        th = move-exception;
        th.printStackTrace();
    L16:
        Throwable th10 = th;
    L52:
        cd.a(th10, "AI", "gKe");     // Catch: Throwable -> L33
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L27:
        if (r103 != null) goto L48;
    L32:
        return "";
    L48:
        r103.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L22:
        if (r101.exists() == false) goto L27;
        r101.delete();     // Catch: Throwable -> L25
    L33:
        th = move-exception;
        if (r103 != null) goto L44;
    L39:
        throw th;
    L44:
        r103.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = move-exception;
        r103 = null;
        th10 = th;
        goto L52
    }

    private static String h(Context r100) throws PackageManager.NameNotFoundException {
        String r101 = f26198f;
        if (r101 != null) goto L5;
    L6:
        ApplicationInfo r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);
        if (r102 == null) goto L17;
        Bundle r103 = r102.metaData;
        if (r103 == null) goto L17;
        String r104 = r103.getString("com.amap.api.v2.apikey");
        f26198f = r104;
        if (r104 != null) goto L15;
        f26198f = g(r100);
    L15:
        return f26198f;
    L17:
        return f26198f;
    L5:
        if (r101.equals("") == false) goto L15;
        goto L6
    }

    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        f26198f = r100;
    }

    public static String b(Context r100) {
    L8:
        th = move-exception;
        cd.a(th, "AI", "gAN");
    L11:
        return f26195c;
    L3:
        if ("".equals(f26195c) == false) goto L5;
        PackageManager r101 = r100.getPackageManager();     // Catch: Throwable -> L8
        f26195c = (String) r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 0));     // Catch: Throwable -> L8
        goto L11
    L5:
        return f26195c;
    }
}
