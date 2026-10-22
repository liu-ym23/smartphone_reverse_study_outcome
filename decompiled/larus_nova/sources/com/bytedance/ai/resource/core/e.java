package com.bytedance.ai.resource.core;

import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    static {
    }

    public e() {
    }

    public static void a(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r110, "path");
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(r100);
        Enumeration<? extends ZipEntry> r102 = r101.entries();     // Catch: Throwable -> L40
    L5:
        if (r102.hasMoreElements() == false) goto L37;
        ZipEntry r103 = r102.nextElement();     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.zip.ZipEntry");     // Catch: Throwable -> L40
        ZipEntry r104 = r103;     // Catch: Throwable -> L40
        if (StringsKt.contains$default(r104.getName(), "../", false, 2, null) == true) goto L35;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r110, r104.getName());     // Catch: Throwable -> L40
        if (StringsKt.startsWith$default(r105.getCanonicalPath(), new PolarisFileWrapper(r110).getCanonicalPath(), false, 2, null) == false) goto L33;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r110, r104.getName());     // Catch: Throwable -> L40
        if (r104.isDirectory() == true) goto L13;
        File r107 = r106.getParentFile();     // Catch: Throwable -> L40
        if (r107 == null) goto L17;
        r107.mkdirs();     // Catch: Throwable -> L40
    L17:
        InputStream r108 = r101.getInputStream(r104);     // Catch: Throwable -> L40
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(r106);     // Catch: Throwable -> L40
        ByteStreamsKt.copyTo$default(r108, r109, 0, 2, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r109, null);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r108, null);     // Catch: Throwable -> L40
        goto L5
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L13:
        r106.mkdirs();     // Catch: Throwable -> L40
        goto L5
    L33:
        g.f37637a.e("AIPackageZipExtractor", "canonicalPath path is not safe: " + r105.getCanonicalPath());     // Catch: Throwable -> L40
        throw new SecurityException("canonicalPath path is not safe");     // Catch: Throwable -> L40
    L35:
        g.f37637a.e("AIPackageZipExtractor", "entry path is not safe: " + r104.getName());     // Catch: Throwable -> L40
        throw new SecurityException("entry path is not safe");     // Catch: Throwable -> L40
    L37:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r101, null);
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public static boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "path");
        boolean r102 = true;
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        boolean r104 = new PolarisFileWrapper(r100).exists();
    L10:
        if (r104 == true) goto L13;
        g.f37637a.e("AIPackageZipExtractor", "Failed to unzip " + r100 + ": does not exist");
        return false;
    L13:
        if (r101.length() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L34;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101);
        if (r106.exists() == false) goto L20;
        FilesKt.deleteRecursively(r106);
    L20:
        r106.mkdirs();
    L34:
        a(r100, r101);     // Catch: Exception -> L23
        g.f37637a.d("AIPackageZipExtractor", "Unzip " + r100 + " to " + r101 + " successfully");     // Catch: Exception -> L23
        return true;
    L23:
        e = move-exception;
        g.f37637a.e("AIPackageZipExtractor", "Failed to unzip " + r100 + ": " + ExceptionsKt.stackTraceToString(e));
        if (r101.length() > 0) goto L28;
        r102 = false;
    L28:
        if (r102 == false) goto L32;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r101);
        if (r107.exists() == false) goto L32;
        FilesKt.deleteRecursively(r107);
    L32:
        f.d(r100);
        return false;
    L15:
        r105 = false;
        goto L16
    L8:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
