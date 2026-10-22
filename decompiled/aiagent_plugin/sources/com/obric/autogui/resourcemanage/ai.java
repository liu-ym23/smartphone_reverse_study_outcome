package com.obric.autogui.resourcemanage;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.attribute.FileTime;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ZipExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ai f30611a = null;

    static {
        f30611a = new ai();
    }

    private ai() {
    }

    public final boolean a(File r6, File r7, int r8) {
        d.h.b.o.e(r6, "zipFile");
        d.h.b.o.e(r7, "targetDir");
        int r1 = 0;
    L3:
        if (r1 > r8) goto L11;
        if (a(r6, r7) == true) goto L6;
        r1 = r1 + 1;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L3;
        Loog.INSTANCE.d("resource_downloader", "unzipWithRetry: retry " + r1 + " for " + r6.getAbsolutePath());
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.obric.autogui.resourcemanage.ai] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    private final boolean a(File r21, File r22) {
        ?? r2 = r22;
        ?? r3 = "com.obric.aiagent.plugin";
        File r0 = r22.getParentFile();
        boolean r4 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        File r5 = new File(r0, r22.getName() + "_tmp");
        if (r5.exists() == false) goto L9;
        a(r5);
    L9:
        if (r5.mkdirs() == false) goto L11;
    L169:
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r21), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L150
        ZipFile r9 = (ZipFile) ZeusTransformUtils.preCheckCast(r8, ZipFile.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
        Enumeration<? extends ZipEntry> r10 = r9.entries();     // Catch: Throwable -> L140
        d.h.b.o.c(r10, "entries(...)");     // Catch: Throwable -> L140
        byte[] r11 = new byte[8192];     // Catch: Throwable -> L140
    L18:
        if (r10.hasMoreElements() == false) goto L115;
        ZipEntry r1 = (ZipEntry) ZeusTransformUtils.preCheckCast(r10.nextElement(), ZipEntry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
        String r13 = r1.getName();     // Catch: Throwable -> L140
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        String r14 = d.o.o.a(r13, '\\', '/', false, 4, null);     // Catch: Throwable -> L140
    L24:
        Enumeration<? extends ZipEntry> r23 = r10;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), '/', r4, 2, null) == false) goto L28;
        r14 = r14.substring(1);     // Catch: Throwable -> L140
        d.h.b.o.c(r14, "substring(...)");     // Catch: Throwable -> L140
        r10 = r23;
        goto L24
    L28:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == false) goto L33;
    L113:
        File r19 = r5;
    L114:
        r10 = r23;
        r5 = r19;
        r4 = false;
        goto L18
    L33:
        if (d.h.b.o.a(r14, ".") == true) goto L113;
        File r16 = new File(r5, r14);     // Catch: Throwable -> L140
        String r6 = new StringBuilder().append(r5.getCanonicalPath()).append(File.separator).toString();     // Catch: Throwable -> L110
        String r7 = r16.getCanonicalPath();     // Catch: Throwable -> L110
        d.h.b.o.a(r7);     // Catch: Throwable -> L110
        r19 = r5;
        if (d.o.o.b(r7, r6, false, 2, null) == true) goto L44;
    L105:
        th = move-exception;
        Throwable r12 = th;
        File r17 = r19;
    L112:
        r2 = 0;
        r3 = r17;
    L165:
        throw r12;     // Catch: Throwable -> L144
    L144:
        th = move-exception;
        d.f.c.a(r8, r12);     // Catch: Exception -> L148
        throw th;     // Catch: Exception -> L148
    L41:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L114;
        Loog.INSTANCE.d("resource_downloader", "unzipOnce: skip entry outside target dir: " + r13 + " -> " + r7);     // Catch: Throwable -> L105
        goto L114
    L44:
        if (r1.isDirectory() == true) goto L87;
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L87;
        File r18 = r16.getParentFile();     // Catch: Throwable -> L105
        if (r18 != null) goto L53;
    L64:
        Closeable r20 = (Closeable) ZeusTransformUtils.preCheckCast(r9.getInputStream(r1), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        InputStream r24 = (InputStream) ZeusTransformUtils.preCheckCast(r20, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77
        Closeable r25 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r16), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77
        FileOutputStream r110 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r25, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        ai r111 = f30611a;     // Catch: Throwable -> L70
        d.h.b.o.a(r24);     // Catch: Throwable -> L70
        r111.a(r24, (OutputStream) ZeusTransformUtils.preCheckCast(r110, OutputStream.class, "com.obric.aiagent.plugin"), r11);     // Catch: Throwable -> L70
        d.x r26 = d.x.f38692a;     // Catch: Throwable -> L70
        d.f.c.a(r25, null);     // Catch: Throwable -> L77
        d.x r27 = d.x.f38692a;     // Catch: Throwable -> L77
        d.f.c.a(r20, null);     // Catch: Throwable -> L105
    L161:
        FileTime r28 = r1.getLastModifiedTime();     // Catch: Throwable -> L102
        if (r28 == null) goto L114;
        r16.setLastModified(r28.toMillis());     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        com.obric.autogui.resourcemanage.a.b.a("resource_downloader", "exception happen: ", th);     // Catch: Throwable -> L105
        goto L114
    L70:
        th = move-exception;
        throw th;     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        d.f.c.a(r25, th);     // Catch: Throwable -> L77
        throw th;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        d.f.c.a(r20, th);     // Catch: Throwable -> L105
        throw th;     // Catch: Throwable -> L105
    L53:
        if (r18.exists() == true) goto L64;
        if (r18.mkdirs() == true) goto L64;
        if (r18.exists() == true) goto L64;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L61;
        Loog.INSTANCE.d("resource_downloader", "unzipOnce: create parent dir failed: " + r18.getAbsolutePath());     // Catch: Throwable -> L105
    L61:
        d.f.c.a(r8, null);     // Catch: Exception -> L135
        return false;
    L84:
        th = move-exception;
        r12 = th;
        boolean r29 = false;
    L109:
        r3 = r19;
        r2 = r29;
    L87:
        if (r16.exists() == true) goto L161;
        if (r16.mkdirs() == true) goto L161;
        if (r16.exists() == true) goto L161;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L95;
        Loog.INSTANCE.d("resource_downloader", "unzipOnce: create dir failed: " + r16.getAbsolutePath());     // Catch: Throwable -> L105
    L95:
        d.f.c.a(r8, null);     // Catch: Exception -> L135
        return false;
    L107:
        th = move-exception;
        r12 = th;
        r29 = false;
    L110:
        th = move-exception;
        r12 = th;
        r17 = r5;
        goto L112
    L30:
        r15 = r4;
        goto L31
    L115:
        File r112 = r5;
        d.x r30 = d.x.f38692a;     // Catch: Throwable -> L138
        d.f.c.a(r8, null);     // Catch: Exception -> L135
        if (r22.exists() == false) goto L120;
        a(r2);     // Catch: Exception -> L135
    L120:
        r3 = r112;
    L133:
        e = e;
    L137:
        r2 = 0;
    L153:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L155;
        Loog.INSTANCE.d("resource_downloader", "unzipOnce failed: " + e);
    L155:
        a(r3);
        return r2;
    L122:
        if (r3.renameTo(r2) == false) goto L124;
    L132:
        return true;
    L124:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L126;
        Loog.INSTANCE.d("resource_downloader", "unzipOnce: rename tempDir failed: " + r3.getAbsolutePath() + ", try copy fallback");     // Catch: Exception -> L133
    L126:
        if (b(r3, r2) == true) goto L131;
        return false;
    L131:
        a(r3);     // Catch: Exception -> L148
    L138:
        th = th;
        File r31 = r112;
        boolean r32 = false;
    L142:
        r12 = th;
        r2 = r32;
        r3 = r31;
    L135:
        e = e;
        r3 = r19;
    L140:
        th = th;
        r32 = r4;
        r31 = r5;
    L150:
        e = e;
        r2 = 0;
        r3 = r5;
    L148:
        e = e;
        goto L153
    L11:
        if (r5.exists() == true) goto L169;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L15;
        Loog.INSTANCE.d("resource_downloader", "unzipOnce: create tempDir failed: " + r5.getAbsolutePath());
    L15:
        return false;
    }

    private final void a(InputStream r2, OutputStream r3, byte[] r4) {
    L2:
        int r1 = r2.read(r4);
        if (r1 == (-1)) goto L6;
        if (r1 <= 0) goto L2;
        r3.write(r4, 0, r1);
        goto L2
    }

    private final boolean b(File r13, File r14) {
        if (r14.exists() == false) goto L5;
    L9:
        File[] r15 = r13.listFiles();
        if (r15 != null) goto L12;
        return true;
    L12:
        int r3 = r15.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L45;
        File r5 = r15[r4];
        File r6 = new File(r14, r5.getName());
        if (r5.isDirectory() == false) goto L54;
        d.h.b.o.a(r5);
        if (b(r5, r6) == true) goto L29;
        return false;
    L29:
        r4 = r4 + 1;
        goto L13
    L54:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L40
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        FileOutputStream r10 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r9, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        byte[] r11 = new byte[8192];     // Catch: Throwable -> L30
    L22:
        int r12 = r8.read(r11);     // Catch: Throwable -> L30
        if (r12 <= 0) goto L25;
        r10.write(r11, 0, r12);     // Catch: Throwable -> L30
        goto L22
    L25:
        d.x r16 = d.x.f38692a;     // Catch: Throwable -> L30
        d.f.c.a(r9, null);     // Catch: Throwable -> L35
        d.x r17 = d.x.f38692a;     // Catch: Throwable -> L35
        d.f.c.a(r7, null);     // Catch: Exception -> L40
        goto L29
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        d.f.c.a(r9, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        d.f.c.a(r7, th);     // Catch: Exception -> L40
        throw th;     // Catch: Exception -> L40
    L40:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L44;
        Loog.INSTANCE.d("resource_downloader", "copy file failed: " + r5.getAbsolutePath() + ", e=" + e);
    L44:
        return false;
    L45:
        return true;
    L5:
        if (r14.mkdirs() == true) goto L9;
        if (r14.exists() == true) goto L9;
        return false;
    }

    private final void a(File r5) {
        if (r5.isDirectory() == false) goto L9;
        File[] r4 = r5.listFiles();
        if (r4 == null) goto L9;
        int r0 = 0;
        int r1 = r4.length;
    L7:
        if (r0 >= r1) goto L9;
        File r2 = r4[r0];
        ai r3 = f30611a;
        d.h.b.o.a(r2);
        r3.a(r2);
        r0 = r0 + 1;
    L9:
        r5.delete();
    }
}
