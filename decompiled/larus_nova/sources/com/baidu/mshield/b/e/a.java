package com.baidu.mshield.b.e;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static String a(Context r100) {
        return a(r100, false);
    }

    public static String b(Context r100) {
        return b(r100, false);
    }

    public static Class c(Context r100) {
        com.baidu.mshield.b.c.a.a("---privacy getServiceManagerClass---" + System.currentTimeMillis());     // Catch: ClassNotFoundException -> L5
        return com.baidu.sec.privacy.e.a.a(r100).a(r100.getClassLoader(), "android.os.ServiceManager");
    L5:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
        return null;
    }

    public static boolean d(Context r100) {
        boolean r101 = com.baidu.sec.privacy.e.a.a(r100).g();
        com.baidu.mshield.b.c.a.a("---privacy isCanRequestNetBackground---" + r101 + " time: " + System.currentTimeMillis());
        return r101;
    }

    public static File a(Context r100, String r101) {
        com.baidu.mshield.b.c.a.a("---privacy getFile---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.a.a(r100).a(r101);
    }

    public static int b(Context r100, String r101) {
        com.baidu.mshield.b.c.a.a("---privacy getIntFromSystemSecure---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.a.a(r100).a(r101, false);
    }

    public static int c(Context r100, String r101) {
        com.baidu.mshield.b.c.a.a("---privacy getIntFromSystemSetting---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.a.a(r100).b(r101, false);
    }

    public static String d(Context r100, String r101) {
        return a(r100, r101, false);
    }

    public static String a(Context r100, boolean r101) {
        com.baidu.mshield.b.c.a.a("---privacy getCuidV3ByFile---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.a.a(r100).a(r101);
    }

    public static String b(Context r100, boolean r101) {
        com.baidu.mshield.b.c.a.a("---privacy getCuidV3ByIPC---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.a.a(r100).b(r101);
    }

    public static String a(Context r100, String r101, boolean r102) {
        com.baidu.mshield.b.c.a.a("---privacy getStringFromSystemSetting---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.a.a(r100).c(r101, true, r102);
    }

    public static void a(Context r100, String r101, String r102) {
        com.baidu.mshield.b.c.a.a("---privacy setStringFromSystemSetting---" + System.currentTimeMillis());
        com.baidu.sec.privacy.e.a.a(r100).a(r101, r102);
    }
}
