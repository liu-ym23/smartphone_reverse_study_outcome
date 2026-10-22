package com.baidu.sec.privacy.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.ttcjpaysdk.facelive.utils.CJPayUploadVideoUtil;

/* JADX INFO: loaded from: classes39.dex */
public class f {
    public static boolean a(String r100) {
        if ((System.currentTimeMillis() - com.baidu.sec.privacy.d.a.a(r100 + "la_in", 0)) >= 86400000) goto L6;
        return false;
    L6:
        return true;
    }

    public static String a(Context r100, boolean r101) {
        if (r101 == true) goto L6;
        return "";
    L6:
        if (c.c(r100) == true) goto L9;
        return CJPayUploadVideoUtil.ERROR_CODE_FILE_SIZE_ZERO;
    L9:
        return "-1001";
    }

    public static boolean b(Context r100, int r101) {
        if (com.baidu.sec.privacy.d.a.a(r101) == false) goto L7;
        return true;
    L7:
        return c.d(r100);
    }

    public static boolean a(Context r100, int r101) {
        if (com.baidu.sec.privacy.d.a.b(r101) == true) goto L7;
        return false;
    L7:
        return b(r100, r101);
    }

    public static int a(Context r100, int r101, boolean r102) {
        if (r102 == true) goto L5;
        return r101;
    L5:
        if (c.c(r100) == true) goto L8;
        return -1000;
    L8:
        return -1001;
    }

    public static String a(Context r100, int r101, boolean r102, com.baidu.sec.privacy.e.d.a<String> r103, Object... r110) {
        return a(r100, r101, null, r102, r103, r110);
    }

    public static String a(Context r100, int r101, String r102, boolean r103, com.baidu.sec.privacy.e.d.a<String> r110, Object... r111) {
        boolean r104 = true;
        if (r101 == 64) goto L56;
    L9:
        boolean r105 = true;
    L10:
        if (r105 == true) goto L12;
    L14:
        String r106 = r101 + "";     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r102) == true) goto L18;
        r106 = r106 + Base64.encodeToString(r102.getBytes(), 0);     // Catch: Throwable -> L7
    L18:
        if (a(r106) == false) goto L20;
        if (r105 == false) goto L35;
        r104 = b(r100, r101);     // Catch: Throwable -> L7
    L35:
        if (r104 == false) goto L46;
        String r107 = r110.a(r102, r111);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r107) == true) goto L39;
        com.baidu.sec.privacy.d.a.b(r106, r107);     // Catch: Throwable -> L7
        return r107;
    L39:
        if (com.baidu.sec.privacy.d.a.a(r106) == true) goto L41;
        return "";
    L41:
        return com.baidu.sec.privacy.d.a.a(r106, "");
    L46:
        if (com.baidu.sec.privacy.d.a.a(r106) == false) goto L53;
        String r108 = com.baidu.sec.privacy.d.a.a(r106, "");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r108) == true) goto L50;
        return r108;
    L50:
        return a(r100, r103);
    L53:
        return a(r100, r103);
    L20:
        if (com.baidu.sec.privacy.d.a.a(r106) == false) goto L24;
        String r109 = com.baidu.sec.privacy.d.a.a(r106, "");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r109) == true) goto L24;
        return r109;
    L24:
        if (r105 == false) goto L26;
        r104 = b(r100, r101);     // Catch: Throwable -> L7
    L26:
        if (r104 == false) goto L32;
        String r112 = r110.a(r102, r111);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r112) == true) goto L30;
        com.baidu.sec.privacy.d.a.b(r106, r112);     // Catch: Throwable -> L7
    L30:
        return r112;
    L32:
        return a(r100, r103);
    L12:
        if (com.baidu.sec.privacy.d.a.b(r101) == true) goto L14;
        return "";
    L56:
    L7:
        th = move-exception;
        c.a(th);
        return "";
    L5:
        if (com.baidu.sec.privacy.d.a.b() == false) goto L9;
        r105 = false;
        goto L10
    }

    public static int a(Context r100, int r101, String r102, int r103, boolean r104, com.baidu.sec.privacy.e.d.a<Integer> r105, Object... r106) {
    L43:
        th = move-exception;
        c.a(th);
        return r103;
    L3:
        if (com.baidu.sec.privacy.d.a.b(r101) == true) goto L5;
        return r103;
    L5:
        String r107 = r101 + "";     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r107 = r107 + Base64.encodeToString(r102.getBytes(), 0);     // Catch: Throwable -> L43
    L9:
        if (a(r107) == true) goto L24;
        if (com.baidu.sec.privacy.d.a.a(r107) == false) goto L16;
        int r108 = com.baidu.sec.privacy.d.a.a(r107, r103);     // Catch: Throwable -> L43
        if (r108 == r103) goto L16;
        return r108;
    L16:
        if (b(r100, r101) == false) goto L22;
        int r109 = r105.a(r102, r106).intValue();     // Catch: Throwable -> L43
        if (r109 == r103) goto L20;
        com.baidu.sec.privacy.d.a.b(r107, r109);     // Catch: Throwable -> L43
    L20:
        return r109;
    L22:
        return a(r100, r103, r104);
    L24:
        if (b(r100, r101) == false) goto L35;
        int r110 = r105.a(r102, r106).intValue();     // Catch: Throwable -> L43
        if (r110 == r103) goto L28;
        com.baidu.sec.privacy.d.a.b(r107, r110);     // Catch: Throwable -> L43
        return r110;
    L28:
        if (com.baidu.sec.privacy.d.a.a(r107) == true) goto L30;
        return r103;
    L30:
        return com.baidu.sec.privacy.d.a.a(r107, r103);
    L35:
        if (com.baidu.sec.privacy.d.a.a(r107) == false) goto L42;
        int r111 = com.baidu.sec.privacy.d.a.a(r107, r103);     // Catch: Throwable -> L43
        if (r111 == r103) goto L39;
        return r111;
    L39:
        return a(r100, r103, r104);
    L42:
        return a(r100, r103, r104);
    }
}
