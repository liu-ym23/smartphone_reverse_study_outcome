package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SkillFileReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final by f19630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f19631b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.o.k f19632c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<byte[]> f19633d = null;

    private by() {
    }

    public final cf a(Context r11, Intent r12, bx r13, d.h.a.a<d.x> r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r12, "data");
        d.h.b.o.e(r13, "limits");
        d.h.b.o.e(r9, "checkCancelled");
        r9.invoke();
        Uri r4 = r12.getData();
        if (r4 == null) goto L10;
        String r15 = a(r3, r4);
        r9.invoke();
        a(r15, bw.f19620a);
        File r16 = a(r3, "skill_import");
        File r17 = new File(r16, c(r15));     // Catch: Throwable -> L7
        a(r3, r4, r17, r13.a(), r9);     // Catch: Throwable -> L7
        return a(r17, r15, r16, r13, r9);
    L7:
        th = move-exception;
        d.f.k.h(r16);
        throw th;
    L10:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    public final cb a(Context r11, Intent r12, bx r13, Integer r14, d.h.a.a<d.x> r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r12, "data");
        d.h.b.o.e(r13, "limits");
        d.h.b.o.e(r9, "checkCancelled");
        r9.invoke();
        Uri r4 = r12.getData();
        if (r4 == null) goto L11;
        String r16 = a(r3, r4);
        r9.invoke();
        a(r16, bw.f19621b);
        File r17 = a(r3, "skill_form_upload");
        File r18 = new File(r17, c(r16));     // Catch: Throwable -> L8
        a(r3, r4, r18, r13.a(), r9);     // Catch: Throwable -> L8
        cb r10 = a(r18, r16, r13, r14, r9);     // Catch: Throwable -> L8
        d.f.k.h(r17);
        return r10;
    L8:
        th = move-exception;
        d.f.k.h(r17);
        throw th;
    L11:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    public final String a(Context r9, Uri r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        d.h.b.o.e(r10, "uri");
        Cursor r11 = ZeusProviderTransform.query(r8.getContentResolver(), r10, null, null, null, null, "com.obric.aiagent.plugin");
        String r12 = null;
        if (r11 == null) goto L26;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.aiagent.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        int r2 = r1.getColumnIndex("_display_name");     // Catch: Throwable -> L21
        if (r2 >= 0) goto L8;
    L19:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L21
        d.f.c.a(r13, null);
        goto L26
    L8:
        if (r1.moveToFirst() == false) goto L19;
        String r4 = r1.getString(r2);     // Catch: Throwable -> L21
        if (r4 == null) goto L19;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        d.f.c.a(r13, null);
        return r4;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        d.f.c.a(r13, th);
        throw th;
    L26:
        String r14 = r10.getLastPathSegment();
        if (r14 == null) goto L35;
        String r15 = d.o.o.c(r14, '/', null, 2, null);
        if (r15 == null) goto L35;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L33;
        r12 = r15;
    L33:
        if (r12 == null) goto L35;
        return r12;
    L35:
        return "SKILL.md";
    }

    public final cb a(File r15, String r16, bx r17, Integer r18, d.h.a.a<d.x> r19) {
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "sourceFile");
        d.h.b.o.e(r16, "selectedFileName");
        d.h.b.o.e(r17, "limits");
        d.h.b.o.e(r9, "checkCancelled");
        r9.invoke();
        a(r15, r17);
        a(r16, bw.f19621b);
        if (a(r15) == true) goto L13;
        String r0 = a(r15, r17.e(), (bt) ZeusTransformUtils.preCheckCast(new bt.v(r17.e()), bt.class, "com.obric.aiagent.plugin"), (bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), r9);
        r9.invoke();
        if (r18 != null) goto L7;
    L11:
        da r1 = db.a(db.f19721a, r0, 0, 2, null);
        return new cb(r16, r1.e(), r1.b(), r1.c());
    L7:
        if (r0.length() <= r18.intValue()) goto L11;
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.a(r18.intValue()), bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L13:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.m.f19605a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    public final cf a(File r18, String r19, File r20, bx r21, d.h.a.a<d.x> r22) {
        d.h.a.a<d.x> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r18, "sourceFile");
        d.h.b.o.e(r19, "selectedFileName");
        d.h.b.o.e(r20, "stagingDir");
        d.h.b.o.e(r21, "limits");
        d.h.b.o.e(r12, "checkCancelled");
        r12.invoke();
        a(r18, r21);
        a(r19, bw.f19620a);
        b(r20);
    L14:
        th = move-exception;
        d.f.k.h(r20);
        throw th;
    L5:
        if (d.o.o.c(r19, ".zip", true) == false) goto L8;
        File r13 = a(r18, new File(r20, "package"), r21, r12);     // Catch: Throwable -> L14
    L10:
        String r0 = a(new File(r13, "SKILL.md"), r21.e(), (bt) ZeusTransformUtils.preCheckCast(new bt.v(r21.e()), bt.class, "com.obric.aiagent.plugin"), (bt) ZeusTransformUtils.preCheckCast(bt.n.f19606a, bt.class, "com.obric.aiagent.plugin"), r12);     // Catch: Throwable -> L14
        r12.invoke();     // Catch: Throwable -> L14
        return new cf(r19, r13, r20, db.a(db.f19721a, r0, 0, 2, null));
    L8:
        if (a(r18) == true) goto L12;
        File r7 = new File(r20, "package");     // Catch: Throwable -> L14
        b(r7);     // Catch: Throwable -> L14
        File r3 = new File(r7, "SKILL.md");     // Catch: Throwable -> L14
        long r4 = r21.e();     // Catch: Throwable -> L14
        bt r6 = (bt) ZeusTransformUtils.preCheckCast(new bt.v(r21.e()), bt.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r13 = r7;
        a(r18, r3, r4, r6, r12);     // Catch: Throwable -> L14
        goto L10
    L12:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.m.f19605a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L14
        throw new d.d();     // Catch: Throwable -> L14
    }

    private final File a(File r36, File r37, bx r38, d.h.a.a<d.x> r39) {
        File r1 = r37;
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r39, d.h.a.a.class, "com.obric.aiagent.plugin");
        r2.invoke();
        b(r1);
        String r15 = r37.getCanonicalPath() + File.separator;
        List<? extends d.m<String, ? extends File>> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        HashSet r13 = new HashSet();
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r36), Closeable.class, "com.obric.aiagent.plugin");     // Catch: ZipException -> L130
        ZipFile r11 = (ZipFile) ZeusTransformUtils.preCheckCast(r12, ZipFile.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L122
        Enumeration<? extends ZipEntry> r16 = r11.entries();     // Catch: Throwable -> L122
        long r7 = 0;
        int r4 = 0;
    L5:
        if (r16.hasMoreElements() == false) goto L112;
        r2.invoke();     // Catch: Throwable -> L110
        ZipEntry r5 = (ZipEntry) ZeusTransformUtils.preCheckCast(r16.nextElement(), ZipEntry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L110
        int r6 = r4 + 1;     // Catch: Throwable -> L110
        if (r6 > r38.b()) goto L106;
        by r8 = f19630a;     // Catch: Throwable -> L110
        String r9 = r5.getName();     // Catch: Throwable -> L110
        d.h.b.o.c(r9, "getName(...)");     // Catch: Throwable -> L110
        String r10 = r8.a(r9, r5.isDirectory());     // Catch: Throwable -> L110
        if (r8.b(r10) == true) goto L104;
        if (r5.isDirectory() == true) goto L13;
        if (r5.getSize() > r38.c()) goto L102;
        ZipFile r22 = r11;
        Closeable r21 = r12;
        long r17 = r38.d() - r7;
    L100:
        th = move-exception;
        Throwable r3 = th;
        Closeable r18 = r21;
    L149:
        throw r3;     // Catch: Throwable -> L126
    L126:
        th = move-exception;
        d.f.c.a(r18, r3);     // Catch: ZipException -> L130
        throw th;     // Catch: ZipException -> L130
    L38:
        if (r5.getSize() > r17) goto L98;
        long r19 = r7;
        long r20 = Math.min(r38.c(), r17);     // Catch: Throwable -> L100
        if (r17 > r38.c()) goto L42;
        bt r23 = (bt) ZeusTransformUtils.preCheckCast(new bt.ab(r38.d()), bt.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L100
    L43:
        bt r24 = r23;
        File r110 = new File(r1, r10);     // Catch: Throwable -> L100
        String r25 = r110.getCanonicalPath();     // Catch: Throwable -> L100
        if (d.h.b.o.a(r25, r37.getCanonicalPath()) == true) goto L52;
        d.h.b.o.a(r25);     // Catch: Throwable -> L100
        if (d.o.o.b(r25, r15, false, 2, null) == true) goto L52;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.y.f19617a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L100
        throw new d.d();     // Catch: Throwable -> L100
    L52:
        if (r13.add(r25) == false) goto L96;
        File r26 = r110.getParentFile();     // Catch: Throwable -> L100
        if (r26 != null) goto L56;
    L62:
        Closeable r27 = (Closeable) ZeusTransformUtils.preCheckCast(r22.getInputStream(r5), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L100
        InputStream r28 = (InputStream) ZeusTransformUtils.preCheckCast(r27, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        Closeable r29 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r110), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        FileOutputStream r30 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r29, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L78
        d.h.b.o.a(r28);     // Catch: Throwable -> L78
        Closeable r33 = r21;
        HashSet r111 = r13;
        List<? extends d.m<String, ? extends File>> r31 = r14;
        long r32 = a(r8, r28, (OutputStream) ZeusTransformUtils.preCheckCast(r30, OutputStream.class, "com.obric.aiagent.plugin"), r20, r24, (bt) ZeusTransformUtils.preCheckCast(bt.l.f19604a, bt.class, "com.obric.aiagent.plugin"), null, r2, 16, null);     // Catch: Throwable -> L76
        d.f.c.a(r29, null);     // Catch: Throwable -> L74
        d.f.c.a(r27, null);     // Catch: Throwable -> L108
        r7 = r8.a(r19, r32);     // Catch: Throwable -> L108
        if (r8.a(r10) == false) goto L73;
        ((Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.aiagent.plugin")).add(d.s.a(r10, r110));     // Catch: Throwable -> L108
    L73:
        r14 = r31;
        r4 = r6;
        r13 = r111;
        r11 = r22;
        r12 = r33;
        r1 = r37;
    L108:
        th = move-exception;
        r3 = th;
        r18 = r33;
    L74:
        th = th;
        Closeable r34 = r27;
    L90:
        Throwable r35 = th;
        throw r35;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        d.f.c.a(r34, r35);     // Catch: Throwable -> L108
        throw th;     // Catch: Throwable -> L108
    L76:
        th = th;
        r34 = r27;
        r29 = r29;
    L80:
        Throwable r40 = th;
        throw r40;     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        d.f.c.a(r29, r40);     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L86:
        th = th;
    L78:
        th = th;
        r34 = r27;
        r33 = r21;
    L88:
        th = th;
        r34 = r27;
        r33 = r21;
        goto L90
    L56:
        if (r26.mkdirs() == true) goto L62;
        if (r26.isDirectory() == true) goto L62;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L100
        throw new d.d();     // Catch: Throwable -> L100
    L96:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.f.f19598a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L108
        throw new d.d();     // Catch: Throwable -> L108
    L42:
        r23 = (bt) ZeusTransformUtils.preCheckCast(new bt.aa(r38.c()), bt.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L100
        goto L43
    L98:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.ab(r38.d()), bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L108
        throw new d.d();     // Catch: Throwable -> L108
    L102:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.aa(r38.c()), bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L108
        throw new d.d();     // Catch: Throwable -> L108
    L13:
        File r41 = new File(r1, r10);     // Catch: Throwable -> L110
        String r42 = r41.getCanonicalPath();     // Catch: Throwable -> L110
        if (d.h.b.o.a(r42, r37.getCanonicalPath()) == true) goto L22;
        d.h.b.o.a(r42);     // Catch: Throwable -> L110
        if (d.o.o.b(r42, r15, false, 2, null) == true) goto L22;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.y.f19617a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L110
        throw new d.d();     // Catch: Throwable -> L110
    L22:
        if (r13.add(r42) == false) goto L31;
        if (r41.mkdirs() == false) goto L26;
    L30:
        r4 = r6;
        goto L5
    L26:
        if (r41.isDirectory() == true) goto L30;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L110
        throw new d.d();     // Catch: Throwable -> L110
    L31:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.f.f19598a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L110
        throw new d.d();     // Catch: Throwable -> L110
    L104:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.x.f19616a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L108
        throw new d.d();     // Catch: Throwable -> L108
    L106:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.ac(r38.b()), bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L108
        throw new d.d();     // Catch: Throwable -> L108
    L110:
        th = move-exception;
        r3 = th;
        r18 = r12;
        goto L149
    L112:
        Closeable r310 = r12;
        List<? extends d.m<String, ? extends File>> r43 = r14;
        d.x r44 = d.x.f38692a;     // Catch: Throwable -> L120
        d.f.c.a(r310, null);     // Catch: ZipException -> L130
        File r0 = ((File) ZeusTransformUtils.preCheckCast(a(r43).d(), File.class, "com.obric.aiagent.plugin")).getParentFile();
        if (r0 == null) goto L119;
        return r0;
    L119:
        return r37;
    L120:
        th = th;
        r18 = r310;
    L124:
        r3 = th;
    L122:
        th = th;
        r18 = r12;
    L130:
        e = move-exception;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.l.f19604a, bt.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new d.d();
    }

    private final d.m<String, File> a(List<? extends d.m<String, ? extends File>> r14) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        if (r13.isEmpty() == false) goto L5;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.n.f19606a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L5:
        if (r13.size() != 1) goto L15;
        d.m<String, File> r15 = (d.m) ZeusTransformUtils.preCheckCast(d.a.p.o(r13), d.m.class, "com.obric.aiagent.plugin");
        List r16 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((String) ZeusTransformUtils.preCheckCast(r15.a(), String.class, "com.obric.aiagent.plugin"), new char[]{'/'}), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null);
        if (r16.size() == 1) goto L11;
        if (r16.size() == 2) goto L11;
    L13:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.k.f19603a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L11:
        if (d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r15.b(), File.class, "com.obric.aiagent.plugin")).getName(), "SKILL.md") == false) goto L13;
        return r15;
    L15:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.o.f19607a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final void a(File r6, bx r7) {
        if (r6.isFile() == true) goto L5;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L5:
        if (r6.length() > r7.a()) goto L7;
        return;
    L7:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.w(r7.a()), bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final void a(String r1, bw r2) {
        if (r2.a(r1) == false) goto L5;
        return;
    L5:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.z(r2), bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final boolean a(File r6) {
        byte[] r0 = new byte[4];
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r6), Closeable.class, "com.obric.aiagent.plugin");
        int r1 = ((FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.aiagent.plugin")).read(r0);     // Catch: Throwable -> L21
        d.f.c.a(r7, null);
        if (r1 != 4) goto L20;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(f19633d, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L9;
    L11:
        Iterator r8 = r5.iterator();
    L13:
        if (r8.hasNext() == false) goto L10;
        if (Arrays.equals(r0, (byte[]) ZeusTransformUtils.preCheckCast(r8.next(), byte[].class, "com.obric.aiagent.plugin")) == false) goto L13;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L20;
        return true;
    L10:
        r9 = false;
        goto L17
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L20:
        return false;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        d.f.c.a(r7, th);
        throw th;
    }

    private final String a(String r12, boolean r13) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L38;
        boolean r4 = false;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), '\\', false, 2, null) == false) goto L7;
    L36:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.y.f19617a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L7:
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L36;
        if (f19631b.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        if (r13 == false) goto L13;
        r12 = d.o.o.c(r12, new char[]{'/'});
    L13:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L16;
    L18:
        Iterator r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L32;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L24;
    L29:
        boolean r5 = true;
    L30:
        if (r5 == false) goto L20;
        r4 = true;
        goto L32
    L24:
        if (d.h.b.o.a(r3, ".") == true) goto L29;
        if (d.h.b.o.a(r3, DownloadConstants.VULNERABILITY_PATH) == true) goto L29;
        r5 = false;
    L32:
        if (r4 == true) goto L34;
        return r12;
    L34:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.y.f19617a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    L38:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.y.f19617a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final boolean a(String r3) {
        return d.h.b.o.a(d.o.o.c(r3, '/', null, 2, null), "SKILL.md");
    }

    private final boolean b(String r10) {
        List r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r10, new char[]{'/'}), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null);
        int r0 = r11.size();
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L8;
    L16:
        return false;
    L8:
        if (d.h.b.o.a(r11.get(1), ".obric") == false) goto L16;
        if (d.h.b.o.a(r11.get(2), "manifest.json") == false) goto L16;
        return true;
    L13:
        if (d.h.b.o.a(r11.get(0), ".obric") == false) goto L16;
        if (d.h.b.o.a(r11.get(1), "manifest.json") == false) goto L16;
        return true;
    }

    private final void a(Context r16, Uri r17, File r18, long r19, d.h.a.a<d.x> r21) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
        r11.invoke();
        InputStream r4 = r0.getContentResolver().openInputStream(r17);     // Catch: SecurityException -> L32 IOException -> L35
    L5:
        if (r4 == null) goto L30;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.aiagent.plugin");
        InputStream r3 = (InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        FileOutputStream r5 = new FileOutputStream(r18);     // Catch: IOException -> L21 Throwable -> L24
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        FileOutputStream r6 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r14, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        a(f19630a, r4, (OutputStream) ZeusTransformUtils.preCheckCast(r5, OutputStream.class, "com.obric.aiagent.plugin"), r19, (bt) ZeusTransformUtils.preCheckCast(new bt.w(r19), bt.class, "com.obric.aiagent.plugin"), (bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), null, r11, 16, null);     // Catch: Throwable -> L14
        d.f.c.a(r14, null);     // Catch: Throwable -> L24
        d.f.c.a(r2, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.f.c.a(r14, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L21:
        e = move-exception;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L24
        throw new d.d();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        d.f.c.a(r2, th);
        throw th;
    L30:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L35:
        e = move-exception;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new d.d();
    L32:
        e = move-exception;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new d.d();
    }

    private final void a(File r16, File r17, long r18, bt r20, d.h.a.a<d.x> r21) {
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r16), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r0 = (FileInputStream) ZeusTransformUtils.preCheckCast(r13, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r17), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        FileOutputStream r2 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r14, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        a(f19630a, (InputStream) ZeusTransformUtils.preCheckCast(r0, InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.aiagent.plugin"), r18, r20, null, null, r10, 24, null);     // Catch: Throwable -> L9
    L6:
        d.f.c.a(r14, null);     // Catch: Throwable -> L16
        d.f.c.a(r13, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.f.c.a(r14, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        d.f.c.a(r13, th);
        throw th;
    }

    private final String a(File r9, long r10, bt r12, bt r13, d.h.a.a<d.x> r14) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        r6.invoke();
        if (r9.isFile() == true) goto L5;
        bv.a(r13, null, 2, null);
        throw new d.d();
    L5:
        if (r9.length() > r10) goto L15;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r9), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r11 = (FileInputStream) ZeusTransformUtils.preCheckCast(r8, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        String r15 = new String(f19630a.a((InputStream) ZeusTransformUtils.preCheckCast(r11, InputStream.class, "com.obric.aiagent.plugin"), r10, r12, r6), d.o.d.f38623b);     // Catch: Throwable -> L10
        d.f.c.a(r8, null);
        return r15;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.f.c.a(r8, th);
        throw th;
    L15:
        bv.a(r12, null, 2, null);
        throw new d.d();
    }

    private final byte[] a(InputStream r14, long r15, bt r17, d.h.a.a<d.x> r18) {
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.a.class, "com.obric.aiagent.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        a(this, r14, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin"), r15, r17, null, null, r10, 24, null);
        byte[] r1 = r0.toByteArray();
        d.h.b.o.c(r1, "toByteArray(...)");
        return r1;
    }

    static /* synthetic */ long a(by r11, InputStream r12, OutputStream r13, long r14, bt r16, bt r17, bt r18, d.h.a.a r19, int r20, Object r21) {
        d.h.a.a<d.x> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r20 & 8) == 0) goto L5;
        bt r8 = (bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin");
    L7:
        if ((r20 & 16) == 0) goto L9;
        bt r9 = (bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin");
    L11:
        return r11.a(r12, r13, r14, r16, r8, r9, r10);
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    private final long a(InputStream r8, OutputStream r9, long r10, bt r12, bt r13, bt r14, d.h.a.a<d.x> r15) {
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        byte[] r0 = new byte[8192];
        long r2 = 0;
    L3:
        r16.invoke();
        int r4 = r8.read(r0);     // Catch: IOException -> L17
        if (r4 < 0) goto L16;
        r2 = a(r2, r4);
        if (r2 > r10) goto L14;
        r9.write(r0, 0, r4);     // Catch: IOException -> L11
    L11:
        e = move-exception;
        bv.a(r14, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new d.d();
    L14:
        bv.a(r12, null, 2, null);
        throw new d.d();
    L16:
        return r2;
    L17:
        e = move-exception;
        bv.a(r13, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new d.d();
    }

    private final long a(long r3, long r5) {
        if (r5 >= 0) goto L5;
    L8:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L5:
        if (r3 > (Long.MAX_VALUE - r5)) goto L8;
        return r3 + r5;
    }

    private final File a(Context r5, String r6) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getCacheDir(), r6 + '_' + System.currentTimeMillis() + '_' + System.nanoTime());
        b(r0);
        return r0;
    }

    private final void b(File r2) {
        if (r2.mkdirs() == false) goto L5;
        return;
    L5:
        if (r2.isDirectory() == true) goto L10;
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final String c(String r3) {
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(f19632c.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), "_"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L9;
        return "skill_file";
    L9:
        return r2;
    }

    static {
        f19630a = new by();
        f19631b = new d.o.k("^[A-Za-z]:");
        f19632c = new d.o.k("[\\\\/:*?\"<>|]");
        f19633d = d.a.p.b((Object[]) ZeusTransformUtils.preCheckCast(new byte[][]{new byte[]{80, 75, 3, 4}, new byte[]{80, 75, 5, 6}, new byte[]{80, 75, 7, 8}}, Object[].class, "com.obric.aiagent.plugin"));
    }
}
