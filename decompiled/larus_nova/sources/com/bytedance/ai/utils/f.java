package com.bytedance.ai.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {
    public static final boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        return new PolarisFileWrapper(r100).exists();
    }

    public static final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (TextUtils.isEmpty(r100) == true) goto L10;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return false;
    L8:
        return FilesKt.deleteRecursively(r101);
    L10:
        return false;
    }

    public static final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (TextUtils.isEmpty(r100) == true) goto L10;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return false;
    L8:
        return r101.delete();
    L10:
        return false;
    }

    public static final boolean delete(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (TextUtils.isEmpty(r100) == true) goto L14;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return false;
    L8:
        if (r101.isDirectory() == false) goto L11;
        return FilesKt.deleteRecursively(r101);
    L11:
        return r101.delete();
    L14:
        return false;
    }

    public static final long f(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r101 = 0;
        if (r100.exists() == false) goto L13;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L13;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L11;
        Intrinsics.checkNotNull(r105);
        long r106 = f(r105);
    L12:
        r101 = r101 + r106;
        r104 = r104 + 1;
        goto L7
    L11:
        r106 = r105.length();
    L13:
        return r101;
    }

    public static final boolean g(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L6;
        r101.mkdirs();
        return;
    }

    public static final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        g.f37637a.d("applet_performance", r100);
    }

    public static final String k(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r100));
        String r103 = r102.readLine();     // Catch: Throwable -> L9
    L4:
        if (r103 == null) goto L6;
        r101.append(r103);     // Catch: Throwable -> L9
        r101.append("\n");     // Catch: Throwable -> L9
        r103 = r102.readLine();     // Catch: Throwable -> L9
        goto L4
    L6:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r102, null);
        return r101.toString();
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public static final void b(InputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "inputStream");
        Intrinsics.checkNotNullParameter(r101, "destFile");
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r101);
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L10
    L4:
        int r104 = r100.read(r103);     // Catch: Throwable -> L10
        if (r104 <= 0) goto L7;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L7:
        r102.flush();     // Catch: Throwable -> L10
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r102, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public static final boolean i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        if (TextUtils.isEmpty(r100) == true) goto L11;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L10;
        g.f37637a.e("ExtentionFunc", r102 + " is invalid");
        return false;
    L10:
        return r102.renameTo(new PolarisFileWrapper(r101));
    L11:
        return false;
    }

    public static final boolean l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dstFile");
        Intrinsics.checkNotNullParameter(r101, "assetsFolderName");
        Context r102 = f2.k.a();     // Catch: Exception -> L17
        String r103 = new PolarisFileWrapper(r100).getName();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L17
        InputStream r104 = e(r102, r101, r103);     // Catch: Exception -> L17
        if (r104 != null) goto L20;
        g.f37637a.d("ExtentionFunc", "Resource " + r103 + " does not exist in the assets directory");     // Catch: Exception -> L17
        return false;
    L20:
        g.f37637a.i("ExtentionFunc", "The assets directory contains resource " + r103);     // Catch: Throwable -> L10
        b(r104, r100);     // Catch: Throwable -> L10
    L7:
        CloseableKt.closeFinally(r104, null);     // Catch: Exception -> L17
        return true;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        g r105 = g.f37637a;
        StringBuilder r106 = new StringBuilder("check assets exist error : ");
        e.printStackTrace();
        r106.append(Unit.INSTANCE);
        r105.e("ExtentionFunc", r106.toString());
        return false;
    }

    public static final InputStream e(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "folderName");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        AssetManager r103 = r100.getAssets();
        String[] r104 = r103.list(r101);
        if (r104 != null) goto L5;
        return null;
    L5:
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        String r107 = r104[r106];
        if (Intrinsics.areEqual(r107, r102) == true) goto L10;
        r106 = r106 + 1;
        goto L6
    L10:
        return r103.open(r101 + '/' + r107);
    L12:
        return null;
    }
}
