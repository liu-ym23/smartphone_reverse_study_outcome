package com.apm.lite.k;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f30012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PolarisFileWrapper f30013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f30014c;

    public static PolarisFileWrapper a(Context r100) {
        return new PolarisFileWrapper(g(r100), "apmlite/CrashLogJava");
    }

    public static PolarisFileWrapper b(Context r100, String r101) {
        return new PolarisFileWrapper(g(r100) + "/apmlite/CrashCommonLog/" + r101);
    }

    public static PolarisFileWrapper d(Context r100, String r101) {
        return new PolarisFileWrapper(g(r100) + "/apmlite/CustomFile/" + r101);
    }

    public static PolarisFileWrapper e(File r100) {
        return new PolarisFileWrapper(r100, "tombstone.txt");
    }

    public static File f(Context r100) {
        if (f30014c != null) goto L6;
        f30014c = new PolarisFileWrapper(g(r100) + "/apmlite/CrashCommonLog/" + com.apm.lite.e.f());
    L6:
        return f30014c;
    }

    public static String g(Context r100) {
        if (TextUtils.isEmpty(f30012a) == false) goto L9;
        f30012a = r100.getFilesDir().getAbsolutePath();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        f30012a = "/sdcard/";
        e.printStackTrace();
    L9:
        return f30012a;
    }

    public static void h(Context r100) {
        new PolarisFileWrapper(g(r100) + "/apmlite/CustomFile/" + com.apm.lite.e.f());
    }

    public static File c() {
        PolarisFileWrapper r100 = f30013b;
        if (r100 != null) goto L9;
        Context r101 = com.apm.lite.e.f29909a;
        if (f30013b != null) goto L8;
        f30013b = new PolarisFileWrapper(g(r101), "apmlite/CrashLogNative");
    L8:
        return f30013b;
    L9:
        return r100;
    }
}
