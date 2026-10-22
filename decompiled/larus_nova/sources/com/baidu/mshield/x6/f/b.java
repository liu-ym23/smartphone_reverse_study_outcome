package com.baidu.mshield.x6.f;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static String a(Context r100) {
    L73:
        th = move-exception;
        f.b(th);
        return "4";
    L4:
        if (com.baidu.mshield.x6.c.b.b() == false) goto L6;
        String r101 = new com.baidu.mshield.x6.b.b(r100).Q();     // Catch: Throwable -> L73
        String r102 = b(r100, "x_o_b_d");     // Catch: Throwable -> L73
        String r103 = a(r100, ".x_o_b_d");     // Catch: Throwable -> L73
    L7:
        boolean r104 = k.a(r100, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});     // Catch: Throwable -> L73
        boolean r105 = k.a(r100, new String[]{"android.permission.WRITE_SETTINGS"});     // Catch: Throwable -> L73
        if (r104 == false) goto L33;
        if (r105 == false) goto L33;
        if (TextUtils.isEmpty(r101) == false) goto L19;
        if (TextUtils.isEmpty(r102) == false) goto L19;
        if (TextUtils.isEmpty(r103) == false) goto L19;
        return "1";
    L19:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        if (TextUtils.isEmpty(r102) == true) goto L26;
        if (TextUtils.isEmpty(r103) == true) goto L26;
        return "2";
    L26:
        if (TextUtils.isEmpty(r101) == true) goto L28;
    L32:
        return "4";
    L28:
        if (TextUtils.isEmpty(r102) == true) goto L32;
        if (TextUtils.isEmpty(r103) == true) goto L32;
        return "3";
    L33:
        if (r104 == false) goto L51;
        if (r105 == true) goto L51;
        if (TextUtils.isEmpty(r101) == false) goto L41;
        if (TextUtils.isEmpty(r103) == false) goto L41;
        return "1";
    L41:
        if (TextUtils.isEmpty(r101) == true) goto L46;
        if (TextUtils.isEmpty(r103) == true) goto L46;
        return "2";
    L46:
        if (TextUtils.isEmpty(r101) == true) goto L48;
    L50:
        return "4";
    L48:
        if (TextUtils.isEmpty(r103) == true) goto L50;
        return "3";
    L51:
        if (r104 == true) goto L70;
        if (r105 == false) goto L70;
        if (TextUtils.isEmpty(r101) == false) goto L59;
        if (TextUtils.isEmpty(r102) == false) goto L59;
        return "1";
    L59:
        if (TextUtils.isEmpty(r101) == true) goto L64;
        if (TextUtils.isEmpty(r102) == true) goto L64;
        return "2";
    L64:
        if (TextUtils.isEmpty(r101) == true) goto L66;
    L68:
        return "4";
    L66:
        if (TextUtils.isEmpty(r102) == true) goto L68;
        return "3";
    L70:
        if (TextUtils.isEmpty(r101) == true) goto L72;
        return "2";
    L72:
        return "4";
    L6:
        r101 = new com.baidu.mshield.x6.b.b(r100).A();     // Catch: Throwable -> L73
        r102 = b(r100, "x_b_d");     // Catch: Throwable -> L73
        r103 = a(r100, ".x_b_d");     // Catch: Throwable -> L73
        goto L7
    }

    public static String b(Context r100) {
    L21:
        th = move-exception;
        f.b(th);
        return "";
    L3:
        if (com.baidu.mshield.x6.c.b.b() == false) goto L5;
        String r101 = new com.baidu.mshield.x6.b.b(r100).Q();     // Catch: Throwable -> L21
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        if (com.baidu.mshield.x6.c.b.b() == false) goto L11;
        r101 = b(r100, "x_o_b_d");     // Catch: Throwable -> L21
        goto L13
    L11:
        r101 = b(r100, "x_b_d");     // Catch: Throwable -> L21
    L13:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        return r101;
    L15:
        if (com.baidu.mshield.x6.c.b.b() == false) goto L18;
        String r102 = a(r100, ".x_o_b_d");     // Catch: Throwable -> L21
    L25:
        return r102;
    L18:
        r102 = a(r100, ".x_b_d");     // Catch: Throwable -> L21
        goto L25
    L5:
        r101 = new com.baidu.mshield.x6.b.b(r100).A();     // Catch: Throwable -> L21
        goto L7
    }

    public static void c(Context r100) {
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L12
        String r102 = b(r100);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L10:
        r101.f(true);     // Catch: Throwable -> L12
        return;
    L5:
        if (r101.l() == true) goto L10;
        if (a(r102) == true) goto L9;
        return;
    L9:
        a(r100, 1);     // Catch: Throwable -> L12
        a(r100, 2);     // Catch: Throwable -> L12
        a(r100, 3);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        f.b(th);
    }

    public static boolean a(String r100) {
    L11:
        th = move-exception;
        f.b(th);
    L13:
        return false;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.length() <= 70) goto L13;
        return true;
    }

    public static void a(Context r100, int r101) {
        com.baidu.mshield.x6.b.b r102 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L43
        if (r101 != 1) goto L12;
        if (com.baidu.mshield.x6.c.b.b() == false) goto L9;
        r102.q("");     // Catch: Throwable -> L43
        String r103 = "x_o_b_d";
        String r104 = ".x_o_b_d";
    L46:
    L26:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L43
    L48:
    L40:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L43
        return;
    L29:
        if (TextUtils.isEmpty(r104) == false) goto L31;
        return;
    L31:
        if (com.baidu.sec.privacy.f.c.d(r100) == true) goto L33;
        return;
    L33:
        if (k.a(r100, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) == false) goto L54;
        File r105 = com.baidu.mshield.b.e.a.a(r100, Environment.getExternalStorageDirectory() + File.separator + r104);     // Catch: Throwable -> L40
        if (r105 != null) goto L37;
        return;
    L37:
        if (r105.exists() == false) goto L56;
        r105.delete();     // Catch: Throwable -> L40
    L57:
        return;
    L56:
        return;
    L54:
        return;
    L21:
        if (TextUtils.isEmpty(r103) == true) goto L48;
        if (k.a(r100, new String[]{"android.permission.WRITE_SETTINGS"}) == false) goto L48;
        com.baidu.mshield.b.e.a.a(r100, r103, "");     // Catch: Throwable -> L26
    L9:
        r102.i("");     // Catch: Throwable -> L43
        r103 = "x_b_d";
        r104 = ".x_b_d";
        goto L46
    L12:
        if (r101 != 2) goto L16;
        r102.y("");     // Catch: Throwable -> L43
        r103 = "g_b_d_v";
        r104 = ".g_b_d_v";
        goto L46
    L16:
        if (r101 != 3) goto L19;
        r102.k("");     // Catch: Throwable -> L43
        r103 = "g_c_o_m";
        r104 = ".g_c_o_m";
        goto L46
    L19:
        r103 = "";
        r104 = r103;
    L43:
        th = move-exception;
        f.b(th);
    }

    public static String b(Context r100, String r101) {
        return com.baidu.mshield.b.e.a.d(r100, r101);
    L4:
        th = move-exception;
        f.b(th);
        return "";
    }

    public static void c(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return;
    L14:
    L10:
        th = move-exception;
        f.b(th);
        return;
    L6:
        if (com.baidu.mshield.x6.c.b.b() == false) goto L8;
        new com.baidu.mshield.x6.b.b(r100).p(r101);     // Catch: Throwable -> L10
        b(r100, r101, "g_m_o_bs");     // Catch: Throwable -> L10
        a(r100, r101, ".g_m_o_bs");     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        new com.baidu.mshield.x6.b.b(r100).f(r101);     // Catch: Throwable -> L10
        b(r100, r101, "g_m_b_s");     // Catch: Throwable -> L10
        a(r100, r101, ".g_m_b_s");     // Catch: Throwable -> L10
        goto L13
    }

    public static void d(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return;
    L14:
    L10:
        th = move-exception;
        f.b(th);
        return;
    L6:
        if (com.baidu.mshield.x6.c.b.b() == false) goto L8;
        new com.baidu.mshield.x6.b.b(r100).q(r101);     // Catch: Throwable -> L10
        b(r100, r101, "x_o_b_d");     // Catch: Throwable -> L10
        a(r100, r101, ".x_o_b_d");     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        new com.baidu.mshield.x6.b.b(r100).i(r101);     // Catch: Throwable -> L10
        b(r100, r101, "x_b_d");     // Catch: Throwable -> L10
        a(r100, r101, ".x_b_d");     // Catch: Throwable -> L10
        goto L13
    }

    public static void e(Context r100, String r101) {
    L7:
        th = move-exception;
        f.b(th);
        return;
    L3:
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        new com.baidu.mshield.x6.b.b(r100).y(r101);     // Catch: Throwable -> L7
        b(r100, r101, "g_b_d_v");     // Catch: Throwable -> L7
        a(r100, r101, ".g_b_d_v");     // Catch: Throwable -> L7
    }

    public static String a(Context r100, String r101) {
    L16:
        th = move-exception;
        f.b(th);
        return "";
    L3:
        if (com.baidu.sec.privacy.f.c.d(r100) == true) goto L5;
        return "";
    L5:
        if (k.a(r100, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}) == false) goto L24;
        File r102 = com.baidu.mshield.b.e.a.a(r100, Environment.getExternalStorageDirectory() + File.separator + r101);     // Catch: Throwable -> L16
        if (r102 != null) goto L9;
        return "";
    L9:
        if (r102.exists() == false) goto L26;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper(r102));     // Catch: Throwable -> L16
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L16
    L11:
        String r105 = r103.readLine();     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r104.append(r105);     // Catch: Throwable -> L16
        goto L11
    L14:
        r103.close();     // Catch: Throwable -> L16
        return r104.toString().trim();
    L26:
        return "";
    L24:
        return "";
    }

    public static void a(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return;
    L17:
    L14:
        th = move-exception;
        f.b(th);
        return;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L9;
        return;
    L9:
        if (com.baidu.sec.privacy.f.c.d(r100) == true) goto L11;
        return;
    L11:
        if (k.a(r100, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) == false) goto L20;
        com.baidu.mshield.b.c.a.a("write Ext id");     // Catch: Throwable -> L14
        File r103 = com.baidu.mshield.b.e.a.a(r100, Environment.getExternalStorageDirectory() + File.separator + r102);     // Catch: Throwable -> L14
        new PolarisFileWrapper(r103.getParent()).mkdirs();     // Catch: Throwable -> L14
        PolarisFileWriterWrapper r104 = new PolarisFileWriterWrapper(r103, false);     // Catch: Throwable -> L14
        r104.write(r101);     // Catch: Throwable -> L14
        r104.flush();     // Catch: Throwable -> L14
        r104.close();     // Catch: Throwable -> L14
        return;
    }

    public static void b(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (k.a(r100, new String[]{"android.permission.WRITE_SETTINGS"}) == true) goto L15;
        return;
    L15:
        com.baidu.mshield.b.e.a.a(r100, r102, r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        f.b(th);
    }
}
