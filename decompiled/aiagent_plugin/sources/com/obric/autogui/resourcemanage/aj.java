package com.obric.autogui.resourcemanage;

import com.bytedance.crypto.utils.CryptoConst;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ZipVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aj f30612a = null;

    static {
        f30612a = new aj();
    }

    private aj() {
    }

    public final boolean a(File r8, DownloadBean r9) {
        d.h.b.o.e(r8, "file");
        d.h.b.o.e(r9, "bean");
        if (r8.exists() == true) goto L9;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L7;
        Loog.INSTANCE.d("resource_downloader", "verifyDownloadedFile: file not exist: " + r8.getAbsolutePath());
    L7:
        return false;
    L9:
        if (r8.length() <= 0) goto L11;
        String r10 = r9.getMMd5();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L37;
        String r2 = a(r8);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L25;
    L28:
        boolean r4 = true;
    L29:
        if (r4 == true) goto L33;
        if (d.o.o.a(r2, r10, true) == true) goto L37;
    L33:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L35;
        Loog.INSTANCE.d("resource_downloader", "verifyDownloadedFile: md5 not match, expected=" + r10 + ", actual=" + r2);
    L35:
        return false;
    L25:
        if (r3.length() == 0) goto L28;
        r4 = false;
    L37:
        if (b(r8) == false) goto L39;
        return true;
    L39:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L41;
        Loog.INSTANCE.d("resource_downloader", "verifyDownloadedFile: zip invalid: " + r8.getAbsolutePath());
    L41:
        return false;
    L17:
        if (r0.length() == 0) goto L20;
        r1 = false;
        goto L21
    L11:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L13;
        Loog.INSTANCE.d("resource_downloader", "verifyDownloadedFile: file length <= 0: " + r8.getAbsolutePath());
    L13:
        return false;
    }

    private final String a(File r6) {
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L16
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r6), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        FileInputStream r5 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L11
    L5:
        int r3 = r5.read(r2);     // Catch: Throwable -> L11
        if (r3 <= 0) goto L8;
        r1.update(r2, 0, r3);     // Catch: Throwable -> L11
        goto L5
    L8:
        d.x r8 = d.x.f38692a;     // Catch: Throwable -> L11
        d.f.c.a(r7, null);     // Catch: Exception -> L16
        return e.f30619a.a(r1.digest());
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.f.c.a(r7, th);     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L27;
        Loog.INSTANCE.d("resource_downloader", "calculateFileMd5 error: " + e);
        return null;
    L27:
        return null;
    }

    private final boolean b(File r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r3), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        boolean r2 = ((ZipFile) ZeusTransformUtils.preCheckCast(r4, ZipFile.class, "com.obric.aiagent.plugin")).entries().hasMoreElements();     // Catch: Throwable -> L8
        d.f.c.a(r4, null);     // Catch: Exception -> L13
        return r2;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.f.c.a(r4, th);     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L17;
        Loog.INSTANCE.d("resource_downloader", "isZipFileValid failed: " + e);
    L17:
        return false;
    }
}
