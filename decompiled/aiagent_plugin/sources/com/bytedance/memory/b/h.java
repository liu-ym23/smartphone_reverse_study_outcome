package com.bytedance.memory.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: ZipUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static File a(File r6, boolean r7) {
        File r0 = new File(r6.getParentFile(), r6.getName().substring(0, r6.getName().lastIndexOf(".")) + ".zip");
        a(r6, r0);
        if (r0.exists() == false) goto L6;
        if (r7 == false) goto L6;
        r6.delete();
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0045 -> B:27:0x0048). Please report as a decompilation issue!!! */
    public static void a(File r6, File r7) {
        long r0 = System.currentTimeMillis();
        ?? r3 = 0;
        ZipOutputStream r4 = null;
        r3 = 0;
        ZipOutputStream r8 = new ZipOutputStream(new FileOutputStream(r7));     // Catch: Throwable -> L11 Exception -> L13
        a(r6, r8, r6.getName());     // Catch: Throwable -> L7 Exception -> L9
        long r5 = System.currentTimeMillis() - r0;     // Catch: Throwable -> L7 Exception -> L9
        c.a("Compress over cost： %d ms", new Object[]{Long.valueOf(r5)});     // Catch: Throwable -> L7 Exception -> L9
        r8.close();     // Catch: IOException -> L18
        r3 = r5;
    L27:
        return;
    L9:
        e = e;
        r4 = r8;
    L14:
        c.a(e, "HeapFile compress failed", new Object[0]);     // Catch: Throwable -> L11
        r3 = r4;
        if (r4 == null) goto L27;
        r4.close();     // Catch: IOException -> L18
        r3 = r4;
    L7:
        th = th;
        r3 = r8;
    L21:
        if (r3 != 0) goto L33;
    L26:
        throw th;
    L33:
        r3.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L11:
        th = th;
    L13:
        e = e;
    L18:
        e = move-exception;
        e.printStackTrace();
        r3 = r3;
        goto L27
    }

    private static void a(File r2, ZipOutputStream r3, String r4) {
        byte[] r0 = new byte[2048];
        r3.putNextEntry(new ZipEntry(r4));
        FileInputStream r5 = new FileInputStream(r2);
    L3:
        int r6 = r5.read(r0);
        if (r6 == (-1)) goto L6;
        r3.write(r0, 0, r6);
        goto L3
    L6:
        r3.closeEntry();
        r5.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0073 -> B:60:0x0076). Please report as a decompilation issue!!! */
    public static void a(File r9, File r10, boolean r11) {
        long r0 = System.currentTimeMillis();
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        FileInputStream r4 = new FileInputStream(r9);     // Catch: Throwable -> L26 Exception -> L28
        DeflaterOutputStream r5 = new DeflaterOutputStream(new FileOutputStream(r10));     // Catch: Exception -> L24 Throwable -> L42
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L20 Exception -> L22
    L7:
        int r6 = r4.read(r3);     // Catch: Throwable -> L20 Exception -> L22
        if (r6 == (-1)) goto L10;
        r5.write(r3, 0, r6);     // Catch: Throwable -> L20 Exception -> L22
        goto L7
    L10:
        r2 = "Compress over cost： %d ms";
        c.a("Compress over cost： %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r0)});     // Catch: Throwable -> L20 Exception -> L22
        if (r10.exists() == false) goto L58;
        if (r11 == false) goto L58;
        r9.delete();     // Catch: Throwable -> L20 Exception -> L22
    L58:
        r5.close();     // Catch: IOException -> L16
    L18:
        r4.close();     // Catch: IOException -> L39
    L60:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = e;
        r2 = r5;
    L30:
        c.a(e, "HeapFile compress failed", new Object[0]);     // Catch: Throwable -> L42
        if (r2 != 0) goto L54;
    L36:
        if (r4 == null) goto L60;
        r4.close();     // Catch: IOException -> L39
        goto L60
    L54:
        r2.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L20:
        th = th;
        r2 = r5;
    L43:
        if (r2 != 0) goto L68;
    L48:
        if (r4 == null) goto L74;
        r4.close();     // Catch: IOException -> L51
        throw th;
    L51:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L68:
        r2.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = e;
        goto L30
    L42:
        th = th;
    L28:
        e = e;
        r4 = null;
    L26:
        th = th;
        r4 = null;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L60
    }
}
