package com.baidu.xclient.gdid.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sec.privacy.f.g;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33626a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r100) {
            return r100.getName().matches("^cpu\\d+");
        }
    }

    public static JSONObject a(Context r100, JSONObject r101, String r102) {
        if (r101 != null) goto L30;
        return null;
    L30:
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L27
        r103.put(r101);     // Catch: Throwable -> L27
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L27
        r104.put("1", d(r100));     // Catch: Throwable -> L27
        r104.put("2", com.baidu.xclient.gdid.d.a().a(r100));     // Catch: Throwable -> L27
        r104.put("3", b(r100));     // Catch: Throwable -> L27
        r104.put("4", com.baidu.mshield.b.b.a.a(r100));     // Catch: Throwable -> L27
        r104.put("5", r102);     // Catch: Throwable -> L27
        r104.put("6", System.currentTimeMillis());     // Catch: Throwable -> L27
        r104.put("7", "");     // Catch: Throwable -> L27
        r104.put("8", com.baidu.xclient.gdid.d.f33592c);     // Catch: Throwable -> L27
        r104.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, com.baidu.xclient.gdid.f.f33613b);     // Catch: Throwable -> L27
        r104.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, com.baidu.xclient.gdid.f.f33614c);     // Catch: Throwable -> L27
        r104.put("11", "");     // Catch: Throwable -> L27
        r104.put("12", "");     // Catch: Throwable -> L27
        r104.put("13", 1);     // Catch: Throwable -> L27
        r104.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, com.baidu.xclient.gdid.d.a().c("ws"));     // Catch: Throwable -> L27
        r104.put("20", com.baidu.mshield.b.b.a.c(r100));     // Catch: Throwable -> L27
        r104.put("21", com.baidu.mshield.b.b.a.b(r100));     // Catch: Throwable -> L27
        r104.put("22", "");     // Catch: Throwable -> L27
        r104.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "");     // Catch: Throwable -> L27
        r104.put(BDLocationException.ERROR_SDK_NO_PERMISSION, "");     // Catch: Throwable -> L27
        r104.put("module_section", r103);     // Catch: Throwable -> L27
        return r104;
    L27:
        th = move-exception;
        a(th);
        return null;
    }

    public static void a(Throwable r100) {
    }

    public static boolean a(Context r100) {
        NetworkInfo r101 = com.baidu.mshield.b.e.b.a(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.isConnected();
    L8:
        th = move-exception;
        a(th);
        return false;
    }

    public static byte[] a() {
        char[] r100 = new char[16];
        char[] r101 = f33626a.toCharArray();     // Catch: Throwable -> L11
        int r102 = 0;
    L4:
        if (r102 >= 16) goto L14;
        int r103 = new Random().nextInt(62);     // Catch: Throwable -> L11
        if (r103 < 0) goto L10;
        if (r103 >= r101.length) goto L10;
        r100[r102] = r101[r103];     // Catch: Throwable -> L11
    L10:
        r102 = r102 + 1;
    L14:
        return new String(r100).getBytes();
    L11:
        th = move-exception;
        a(th);
        goto L14
    }

    public static String b() {
        return g.a("ro.build.fingerprint", "");
    L5:
        th = move-exception;
        a(th);
        return "";
    }

    public static String b(Context r100) {
        String r101 = "";
        PackageInfo r102 = com.baidu.mshield.b.e.c.a(r100, com.baidu.xclient.gdid.d.a().a(r100), 0);     // Catch: Throwable -> L14
        if (r102 == null) goto L7;
        String r103 = r102.versionName;     // Catch: Throwable -> L14
    L19:
        if (TextUtils.isEmpty(r103) == false) goto L21;
        return "";
    L21:
        return r103;
    L12:
        th = move-exception;
        r101 = r103;
        th = th;
    L15:
        a(th);
        return r101;
    L7:
        r103 = "";
    L14:
        th = th;
        goto L15
    }

    public static int c() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/sys/devices/system/cpu");     // Catch: Throwable -> L14
        if (r100.exists() == true) goto L6;
        return -1;
    L6:
        if (r100.isDirectory() == false) goto L20;
        File[] r101 = r100.listFiles(new a());     // Catch: Throwable -> L14
        if (r101 != null) goto L12;
        return 0;
    L12:
        return r101.length;
    L20:
        return -1;
    L14:
        th = move-exception;
        a(th);
        return -1;
    }

    public static Pair<String, String> c(Context r100) {
        Pair<String, String> r101 = com.baidu.sec.privacy.e.a.a(r100).c();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new Pair("", "");
    }

    public static String d(Context r100) {
        return r100.getApplicationInfo().loadLabel(r100.getPackageManager()).toString();
    L4:
        th = move-exception;
        a(th);
        return "";
    }
}
