package com.obric.autogui.util.f;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.c;
import d.h.b.o;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: ZipUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ZipUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31550a = null;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.aiagent.plugin")).lastModified()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.aiagent.plugin")).lastModified()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31550a = new b();
    }

    public static /* synthetic */ CharSequence lambda$71VwdmDeX0WfOlMkndsu6sUKU70(File r0) {
        return a(r0);
    }

    private b() {
    }

    public final boolean a(String r20, String r21, File r22, List<String> r23) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        o.e(r20, "sourceFolderPath");
        o.e(r21, "zipFileName");
        o.e(r22, "destinationFolder");
        o.e(r4, "extraZipFolders");
    L45:
        e = move-exception;
        System.out.println("压缩过程中发生错误: " + e.getMessage());
        e.printStackTrace();
        return false;
    L4:
        if (r22.exists() == true) goto L6;
        r22.mkdirs();     // Catch: Exception -> L45
    L6:
        File r7 = new File(r20);     // Catch: Exception -> L45
        if (r7.exists() == true) goto L10;
        System.out.println("源文件夹不存在: " + r20);     // Catch: Exception -> L45
        return false;
    L10:
        File[] r8 = r7.listFiles();     // Catch: Exception -> L45
        if (r8 == null) goto L43;
        boolean r9 = true;
        if (r8.length != 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L43;
        List r1 = p.c((Iterable) ZeusTransformUtils.preCheckCast(i.c(r8, (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), 1);     // Catch: Exception -> L45
        System.out.println("只压缩最新的三个文件或文件夹: " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$b$71VwdmDeX0WfOlMkndsu6sUKU70.INSTANCE, 31, null));     // Catch: Exception -> L45
        ZipOutputStream r2 = new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(new File(r22, File.separator + r21)), OutputStream.class, "com.obric.aiagent.plugin")), OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L45
        Iterator r3 = r1.iterator();     // Catch: Exception -> L45
    L21:
        if (r3.hasNext() == false) goto L32;
        File r5 = (File) ZeusTransformUtils.preCheckCast(r3.next(), File.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L45
        if (r5.isDirectory() == true) goto L24;
        byte[] r11 = new byte[2048];     // Catch: Exception -> L45
        r2.putNextEntry(new ZipEntry(r5.getName()));     // Catch: Exception -> L45
        FileInputStream r12 = new FileInputStream(r5);     // Catch: Exception -> L45
        BufferedInputStream r6 = new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(r12, InputStream.class, "com.obric.aiagent.plugin"), 2048);     // Catch: Exception -> L45
    L28:
        int r13 = r6.read(r11, 0, 2048);     // Catch: Exception -> L45
        if (r13 <= 0) goto L31;
        r2.write(r11, 0, r13);     // Catch: Exception -> L45
        goto L28
    L31:
        r6.close();     // Catch: Exception -> L45
        r12.close();     // Catch: Exception -> L45
        r2.closeEntry();     // Catch: Exception -> L45
        goto L21
    L24:
        o.a(r5);     // Catch: Exception -> L45
        String r14 = r5.getName();     // Catch: Exception -> L45
        o.c(r14, "getName(...)");     // Catch: Exception -> L45
        if (a(r5, r14, r2) == true) goto L21;
        r9 = false;
        goto L21
    L32:
        Iterator r15 = r4.iterator();     // Catch: Exception -> L45
    L34:
        if (r15.hasNext() == false) goto L41;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L45
        File r17 = new File(r16);     // Catch: Exception -> L45
        if (r17.exists() == false) goto L37;
        String r18 = r17.getName();     // Catch: Exception -> L45
        o.c(r18, "getName(...)");     // Catch: Exception -> L45
        if (a(r17, r18, r2) == true) goto L34;
    L40:
        r9 = false;
        goto L34
    L37:
        System.out.println("日志文件夹不存在: " + r16);     // Catch: Exception -> L45
        goto L40
    L41:
        r2.close();     // Catch: Exception -> L45
        return r9;
    L15:
        r10 = false;
    L43:
        System.out.println("源文件夹为空: " + r20);     // Catch: Exception -> L45
        return false;
    }

    private static final CharSequence a(File r2) {
        String r3 = r2.getName();
        o.c(r3, "getName(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final boolean a(File r10, String r11, ZipOutputStream r12) {
        File[] r13 = r10.listFiles();     // Catch: Exception -> L34
        if (r13 != null) goto L7;
        r12.putNextEntry(new ZipEntry(r11 + '/'));     // Catch: Exception -> L34
        r12.closeEntry();     // Catch: Exception -> L34
        return true;
    L7:
        Iterator r14 = c.a(r13);     // Catch: Exception -> L34
    L9:
        if (r14.hasNext() == false) goto L33;
        File r4 = (File) ZeusTransformUtils.preCheckCast(r14.next(), File.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        if (r4.isDirectory() == true) goto L13;
        byte[] r6 = new byte[2048];     // Catch: Exception -> L34
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        String r8 = r4.getName();     // Catch: Exception -> L34
    L27:
        r12.putNextEntry(new ZipEntry(r8));     // Catch: Exception -> L34
        FileInputStream r9 = new FileInputStream(r4);     // Catch: Exception -> L34
        BufferedInputStream r5 = new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.aiagent.plugin"), 2048);     // Catch: Exception -> L34
    L28:
        int r15 = r5.read(r6, 0, 2048);     // Catch: Exception -> L34
        if (r15 <= 0) goto L31;
        r12.write(r6, 0, r15);     // Catch: Exception -> L34
        goto L28
    L31:
        r5.close();     // Catch: Exception -> L34
        r9.close();     // Catch: Exception -> L34
        r12.closeEntry();     // Catch: Exception -> L34
        goto L9
    L26:
        r8 = r11 + '/' + r4.getName();     // Catch: Exception -> L34
        goto L27
    L23:
        r7 = false;
        goto L24
    L13:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L15;
        boolean r16 = true;
    L16:
        if (r16 == false) goto L18;
        String r17 = r4.getName();     // Catch: Exception -> L34
    L19:
        r12.putNextEntry(new ZipEntry(r17 + '/'));     // Catch: Exception -> L34
        r12.closeEntry();     // Catch: Exception -> L34
        o.a(r4);     // Catch: Exception -> L34
        o.a(r17);     // Catch: Exception -> L34
        a(r4, r17, r12);     // Catch: Exception -> L34
        goto L9
    L18:
        r17 = r11 + '/' + r4.getName();     // Catch: Exception -> L34
        goto L19
    L15:
        r16 = false;
        goto L16
    L33:
        return true;
    L34:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "压缩文件时发生错误: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
