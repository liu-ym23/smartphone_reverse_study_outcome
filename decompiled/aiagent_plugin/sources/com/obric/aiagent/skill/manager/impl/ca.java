package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillFileStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ca {

    /* JADX INFO: compiled from: SkillFileStore.kt */
    public static final class a {
        public static boolean a(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "file");
            return r3.exists();
        }

        public static boolean b(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "file");
            return r3.isFile();
        }

        public static boolean c(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "file");
            return r3.isDirectory();
        }

        public static boolean d(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "dir");
            if (r3.mkdirs() == false) goto L5;
        L8:
            return true;
        L5:
            if (r3.isDirectory() == true) goto L8;
            return false;
        }

        public static List<File> e(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "dir");
            File[] r5 = r3.listFiles();
            if (r5 != null) goto L6;
            r5 = new File[0];
        L6:
            return d.a.i.g(r5);
        }

        public static String f(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "file");
            return d.f.k.a(r3, null, 1, null);
        }

        public static boolean g(ca r2, File r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "file");
            if (r3.exists() == true) goto L5;
        L8:
            return true;
        L5:
            if (d.f.k.h(r3) == true) goto L8;
            return false;
        }

        public static void a(ca r4, File r5, File r6, boolean r7, d.h.a.a<d.x> r8) {
            ca r9 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
            d.h.a.a<d.x> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
            d.h.b.o.e(r6, "target");
            d.h.b.o.e(r10, "checkCancelled");
            r10.invoke();
            if (r5.isDirectory() == false) goto L14;
            if (r9.d(r6) == false) goto L12;
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.e(r5), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            File r0 = (File) ZeusTransformUtils.preCheckCast(r11.next(), File.class, "com.obric.aiagent.plugin");
            r9.a(r0, new File(r6, r0.getName()), r7, r10);
            goto L8
        L10:
            return;
        L12:
            throw new IOException("Failed to create Skill directory: " + r6.getAbsolutePath());
        L14:
            if (r5.isFile() == false) goto L46;
            if (r6.exists() == false) goto L21;
            if (r7 == true) goto L21;
            throw new IOException("Skill target file already exists: " + r6.getAbsolutePath());
        L21:
            File r12 = r6.getParentFile();
            if (r12 == null) goto L24;
            r9.d(r12);
        L24:
            Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.aiagent.plugin");
            FileInputStream r14 = (FileInputStream) ZeusTransformUtils.preCheckCast(r13, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
            Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
            FileOutputStream r16 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r15, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            byte[] r1 = new byte[8192];     // Catch: Throwable -> L35
        L27:
            r10.invoke();     // Catch: Throwable -> L35
            int r2 = r14.read(r1);     // Catch: Throwable -> L35
            if (r2 < 0) goto L30;
            r16.write(r1, 0, r2);     // Catch: Throwable -> L35
            goto L27
        L30:
            d.x r17 = d.x.f38692a;     // Catch: Throwable -> L35
        L32:
            d.f.c.a(r15, null);     // Catch: Throwable -> L40
            d.x r18 = d.x.f38692a;     // Catch: Throwable -> L40
            d.f.c.a(r13, null);
            return;
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            d.f.c.a(r15, th);     // Catch: Throwable -> L40
            throw th;     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            d.f.c.a(r13, th);
            throw th;
        L46:
            throw new IOException("Skill source file does not exist: " + r5.getAbsolutePath());
        }

        public static void a(ca r2, File r3, File r4) {
            ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, DBHelper.BATTERY_COL_SOURCE);
            d.h.b.o.e(r4, "target");
            if (r5.c(r3) == false) goto L17;
            if (r5.a(r4) == true) goto L15;
            File r0 = r4.getParentFile();
            if (r0 == null) goto L10;
            r5.d(r0);
        L10:
            if (r3.renameTo(r4) == false) goto L13;
            return;
        L13:
            throw new IOException("Failed to atomically commit Skill directory: " + r3.getAbsolutePath() + " -> " + r4.getAbsolutePath());
        L15:
            throw new IOException("Skill destination already exists: " + r4.getAbsolutePath());
        L17:
            throw new IOException("Skill staging directory does not exist: " + r3.getAbsolutePath());
        }
    }

    File a();

    File a(String r1);

    void a(File r1, File r2);

    void a(File r1, File r2, boolean r3);

    void a(File r1, File r2, boolean r3, d.h.a.a<d.x> r4);

    void a(File r1, String r2);

    boolean a(File r1);

    File b();

    File b(String r1);

    boolean b(File r1);

    boolean c(File r1);

    boolean d(File r1);

    List<File> e(File r1);

    String f(File r1);

    boolean g(File r1);
}
