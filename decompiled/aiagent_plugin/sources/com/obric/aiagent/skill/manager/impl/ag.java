package com.obric.aiagent.skill.manager.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: PersistentSkillRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ag implements gh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ca f19465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final df f19466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ac f19467e;
    private final ed f;
    private final d.h.a.a<Long> g;
    private final bl h;
    private final Gson i;
    private final Object j;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ag$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersistentSkillRepository.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f19468a = null;

        static {
            f19468a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: PersistentSkillRepository.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).getName(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin")).getName(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f19463a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-Lnggnu-BZ2FsIo5BFDbJzzuAU8, reason: not valid java name */
    public static /* synthetic */ boolean m271lambda$LnggnuBZ2FsIo5BFDbJzzuAU8(File r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$6M1weyEvU8US1uMztCA-8TbiVEg, reason: not valid java name */
    public static /* synthetic */ boolean m272lambda$6M1weyEvU8US1uMztCA8TbiVEg(File r0, File r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ d.x lambda$BI5jpdNhdnx2TcGhMT5HdCrS58E() {
        return d();
    }

    public static /* synthetic */ CharSequence lambda$FRGO01jD0NVjLtd3dNbpGeZUQfA(byte r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$K9Xs-0nxuyjp5bqjDU1VpF1p3og, reason: not valid java name */
    public static /* synthetic */ d.x m273lambda$K9Xs0nxuyjp5bqjDU1VpF1p3og() {
        return e();
    }

    public ag(File r3, ca r4, df r5, ac r6, ed r7, d.h.a.a<Long> r8, bl r9) {
        ca r10 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
        df r11 = (df) ZeusTransformUtils.wrapperContextForParams(r5, df.class, "com.obric.aiagent.plugin");
        ed r12 = (ed) ZeusTransformUtils.wrapperContextForParams(r7, ed.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "cacheDir");
        d.h.b.o.e(r10, "fileStore");
        d.h.b.o.e(r11, "metadataStore");
        d.h.b.o.e(r12, "logger");
        d.h.b.o.e(r13, "nowMillis");
        d.h.b.o.e(r9, "existencePolicy");
        this.f19464b = r3;
        this.f19465c = r10;
        this.f19466d = r11;
        this.f19467e = r6;
        this.f = r12;
        this.g = r13;
        this.h = r9;
        this.i = new GsonBuilder().setPrettyPrinting().create();
        this.j = new Object();
    }

    public /* synthetic */ ag(File r8, ca r9, df r10, ac r11, ed r12, d.h.a.a r13, bl r14, int r15, d.h.b.h r16) {
        ca r0 = (ca) ZeusTransformUtils.wrapperContextForParams(r9, ca.class, "com.obric.aiagent.plugin");
        df r2 = (df) ZeusTransformUtils.wrapperContextForParams(r10, df.class, "com.obric.aiagent.plugin");
        ed r3 = (ed) ZeusTransformUtils.wrapperContextForParams(r12, ed.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r15 & 8) == 0) goto L5;
        ac r5 = null;
    L7:
        if ((r15 & 16) == 0) goto L10;
        r3 = (ed) ZeusTransformUtils.preCheckCast(c.f19635a, ed.class, "com.obric.aiagent.plugin");
    L10:
        if ((r15 & 32) == 0) goto L12;
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f19468a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L14:
        if ((r15 & 64) == 0) goto L16;
        bl r6 = bl.f19568a;
    L17:
        this(r8, r0, r2, r5, r3, r1, r6);
        return;
    L16:
        r6 = r14;
        goto L17
    L12:
        r1 = r4;
        goto L14
    L5:
        r5 = r11;
        goto L7
    }

    public final List<com.obric.aiagent.skill.manager.api.e> a(boolean r10) {
        Object r0 = this.j;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L51
        if (r10 == false) goto L7;
        c();     // Catch: Throwable -> L51
    L8:
        Map<String, com.obric.aiagent.skill.manager.api.e> r11 = this.f19466d.a();     // Catch: Throwable -> L51
        File r1 = this.f19465c.b();     // Catch: Throwable -> L51
        if (this.f19465c.c(r1) == true) goto L11;
        List<com.obric.aiagent.skill.manager.api.e> r9 = d.a.p.b();     // Catch: Throwable -> L51
    L49:
        monitor-exit(r0);
        return r9;
    L11:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r1), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L51
    L13:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();     // Catch: Throwable -> L51
        File r6 = (File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        boolean r7 = false;
        if (this.f19465c.c(r6) == false) goto L19;
        String r8 = r6.getName();     // Catch: Throwable -> L51
        d.h.b.o.c(r8, "getName(...)");     // Catch: Throwable -> L51
        if (d.o.o.b(r8, ".", false, 2, null) == true) goto L19;
        r7 = true;
    L19:
        if (r7 == false) goto L13;
        r3.add(r5);     // Catch: Throwable -> L51
        goto L13
    L21:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L51
    L23:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();     // Catch: Throwable -> L51
        File r16 = (File) ZeusTransformUtils.preCheckCast(r15, File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        bl r17 = this.h;     // Catch: Throwable -> L51
        String r18 = r16.getName();     // Catch: Throwable -> L51
        d.h.b.o.c(r18, "getName(...)");     // Catch: Throwable -> L51
        if (r17.a(r18) == false) goto L23;
        r13.add(r15);     // Catch: Throwable -> L51
        goto L23
    L27:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Iterator r21 = r19.iterator();     // Catch: Throwable -> L51
    L29:
        if (r21.hasNext() == false) goto L47;
        File r22 = (File) ZeusTransformUtils.preCheckCast(r21.next(), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        com.obric.aiagent.skill.manager.api.e r23 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r11.get(r22.getName()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (r23 != null) goto L55;
    L32:
        com.obric.aiagent.skill.manager.api.e r24 = null;
    L45:
        if (r24 == null) goto L29;
        r20.add(r24);     // Catch: Throwable -> L51
        goto L29
    L55:
        r24 = b(r22, r23);     // Catch: Exception -> L43 Throwable -> L51
        if (r24 == null) goto L32;
        if (ZeusTransformUtils.instanceOf(r24.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == true) goto L40;
        if (d.h.b.o.a(r24.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L45;
    L40:
        if (d.h.b.o.a(r24.b(), r23.b()) == true) goto L45;
        this.f19466d.a(r24);     // Catch: Exception -> L43 Throwable -> L51
        goto L45
    L43:
        e = move-exception;
        this.f.a("Installed Skill package skipped without deletion: slug=" + r22.getName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L51
        goto L32
    L47:
        List<com.obric.aiagent.skill.manager.api.e> r110 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        this.f.a("Persistent skills loaded: count=" + r110.size());     // Catch: Throwable -> L51
        r9 = r110;
        goto L49
    L7:
        this.f.a("Stale Skill commit staging cleanup skipped by config");     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    public final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r4) {
        d.h.b.o.e(r4, "skill");
        String r0 = a(r4.a());
        if (r0 != null) goto L6;
        r0 = r4.k();
    L6:
        return a(r4, r4.a(), r0, r4.l());
    }

    public final com.obric.aiagent.skill.manager.api.e a(String r2, File r3, com.obric.aiagent.skill.manager.api.e r4) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "zipFile");
        d.h.b.o.e(r4, "shopSkill");
        Object r1 = a(r3, r2, r4);
        d.o.a(r1);
        return (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r26, d.h.a.a<d.x> r27) {
        d.h.a.a<d.x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r26, "skill");
        d.h.b.o.e(r1, "checkCancelled");
        String r3 = r26.a();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        String r2 = r26.k();
        e(r2);
        da r4 = db.a(db.f19721a, r2, 0, 2, null);
        String r6 = r4.e();
        if (ZeusTransformUtils.instanceOf(r26.g(), com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L9;
        a(r4.e(), r26.g());
        int r13 = hj.f20114a.a();
        com.obric.aiagent.skill.manager.api.e r5 = a(com.obric.aiagent.skill.manager.api.e.a(r26, null, r6, r4.b(), null, null, null, null, null, null, r13, null, false, false, null, null, null, null, 130553, null), null, "Created skill", r1);
        this.f.a("Custom skill persisted: slug=" + r3 + ", source=" + r5.g() + ", version=" + r13 + ", enabled=" + r5.l());
        return r5;
    L9:
        throw new IllegalArgumentException("Custom Skill source type must be created_gui or created_chat.".toString());
    L11:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e a(ag r1, File r2, com.obric.aiagent.skill.manager.api.e r3, boolean r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r8 = $$Lambda$ag$BI5jpdNhdnx2TcGhMT5HdCrS58E.INSTANCE;
    L9:
        return r1.a(r2, r3, r4, r8);
    }

    private static final d.x d() {
        return d.x.f38692a;
    }

    public final com.obric.aiagent.skill.manager.api.e a(File r54, com.obric.aiagent.skill.manager.api.e r55, boolean r56, d.h.a.a<d.x> r57) {
        d.h.a.a<d.x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r57, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r54, "sourceDir");
        d.h.b.o.e(r55, "skill");
        d.h.b.o.e(r1, "checkCancelled");
        String r6 = r55.a();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L115;
        if (this.f19465c.c(r54) == false) goto L113;
        d(r54);
        File r2 = new File(r54, "SKILL.md");
        if (this.f19465c.b(r2) == false) goto L111;
        com.obric.aiagent.skill.manager.api.aq r8 = r55.g();
        Object r12 = null;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L23;
        if (r55.h() != null) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L21;
        if ((!d.f.k.a(new File(r54, ".obric"), "manifest.json").isFile()) == false) goto L19;
    L17:
        com.obric.aiagent.skill.manager.api.a r28 = null;
    L37:
        String r3 = this.f19465c.f(r2);
        da r29 = db.a(db.f19721a, r3, 0, 2, null);
        String r30 = r29.e();
        a(r29.e(), r55.g());
        r1.invoke();
        int r10 = c(r54);
        Object r15 = this.j;
        monitor-enter(r15);
        Map<String, com.obric.aiagent.skill.manager.api.e> r11 = this.f19466d.a();     // Catch: Throwable -> L102
        if (r28 == null) goto L64;
        String r13 = r28.a();     // Catch: Throwable -> L102
        if (r13 == null) goto L64;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.values(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L102
    L45:
        if (r5.hasNext() == false) goto L59;
        Object r14 = r5.next();     // Catch: Throwable -> L102
        com.obric.aiagent.skill.manager.api.e r16 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        if (d.h.b.o.a(r16.a(), r6) == true) goto L55;
        com.obric.aiagent.skill.manager.api.a r17 = r16.h();     // Catch: Throwable -> L102
        if (r17 == null) goto L51;
        String r18 = r17.a();     // Catch: Throwable -> L102
    L53:
        if (d.h.b.o.a(r18, r13) == false) goto L55;
        boolean r19 = true;
    L56:
        if (r19 == false) goto L45;
        r12 = r14;
        goto L59
    L51:
        r18 = null;
    L55:
        r19 = false;
    L59:
        com.obric.aiagent.skill.manager.api.e r7 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        if (r7 == null) goto L64;
        throw new cd(r7.a(), ce.f19648b);     // Catch: Throwable -> L102
    L64:
        com.obric.aiagent.skill.manager.api.e r20 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r11.get(r6), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        if (r56 == false) goto L116;
        if (r20 != null) goto L116;
        throw new dl();     // Catch: Throwable -> L102
    L116:
        if (r56 == false) goto L77;
        if (r20 == null) goto L75;
        a(r20, com.obric.aiagent.skill.manager.api.e.a(r55, null, null, null, null, null, null, null, r28, null, 0, null, false, false, null, null, null, null, 130943, null));     // Catch: Throwable -> L100
        goto L77
    L75:
        throw new dl();     // Catch: Throwable -> L100
    L77:
        String r110 = r29.b();     // Catch: Throwable -> L100
        if (r20 == null) goto L81;
        com.obric.aiagent.skill.manager.api.aq r21 = r20.g();     // Catch: Throwable -> L100
        if (r21 == null) goto L81;
    L82:
        com.obric.aiagent.skill.manager.api.e r33 = com.obric.aiagent.skill.manager.api.e.a(r55, null, r30, r110, null, null, null, r21, r28, null, 0, r3, false, false, null, null, null, null, 129849, null);     // Catch: Throwable -> L100
        if (r56 == false) goto L92;
        if (r20 == null) goto L91;
        int r22 = hj.f20114a.c(r20.j());     // Catch: Throwable -> L100
        com.obric.aiagent.skill.manager.api.e r23 = com.obric.aiagent.skill.manager.api.e.a(r33, null, null, null, null, null, null, null, null, null, r22, null, false, false, null, null, null, null, 130559, null);     // Catch: Throwable -> L100
        if (d.h.b.o.a(r55.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L88;
        String r4 = "Updated AppFunction skill";
    L89:
        com.obric.aiagent.skill.manager.api.e r24 = a(r6, r23, r54, r22, r4);     // Catch: Throwable -> L100
    L97:
        monitor-exit(r15);
        this.f.a("Imported skill package persisted: slug=" + r6 + ", isUpdate=" + r56 + ", source=" + r24.g() + ", version=" + r24.j() + ", packageEntries=" + r10 + ", enabled=" + r24.l());
        return r24;
    L88:
        r4 = "Updated imported skill";
        goto L89
    L91:
        throw new dl();     // Catch: Throwable -> L100
    L92:
        com.obric.aiagent.skill.manager.api.e r25 = com.obric.aiagent.skill.manager.api.e.a(r33, null, null, null, null, null, null, null, null, null, hj.f20114a.a(), null, false, false, null, null, null, null, 130559, null);     // Catch: Throwable -> L100
        if (d.h.b.o.a(r55.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L95;
        String r26 = "Imported AppFunction skill";
    L96:
        r24 = a(r25, r54, r26, r1);     // Catch: Throwable -> L100
        goto L97
    L95:
        r26 = "Imported skill";
    L81:
        r21 = r55.g();     // Catch: Throwable -> L100
    L100:
        th = th;
    L104:
        monitor-exit(r15);
        throw th;
    L102:
        th = th;
        goto L104
    L19:
        throw new IllegalArgumentException("Obric Skill packages can only be installed from the Skill Store.".toString());
    L21:
        throw new IllegalArgumentException("Imported Skill must not contain AppFunction metadata.".toString());
    L13:
        r9 = false;
        goto L14
    L23:
        if (d.h.b.o.a(r8, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L109;
        com.obric.aiagent.skill.manager.api.a r27 = r55.h();
        if (r27 == null) goto L29;
        String r31 = r27.a();
        if (r31 == null) goto L29;
        String r32 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L30:
        if (r32 != null) goto L33;
        r32 = "";
    L33:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r32, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L107;
        a(r54, r6);
        com.obric.aiagent.skill.manager.api.a r34 = r55.h();
        if (r34 == null) goto L17;
        r28 = com.obric.aiagent.skill.manager.api.a.a(r34, r32, null, 2, null);
        goto L37
    L107:
        throw new IllegalArgumentException("AppFunction Skill package name must not be blank.".toString());
    L29:
        r32 = null;
        goto L30
    L109:
        throw new IllegalArgumentException("Skill source is not supported for package import.");
    L111:
        throw new IllegalArgumentException("Skill package must contain SKILL.md.".toString());
    L113:
        throw new IllegalArgumentException(("Skill package directory does not exist: " + r54.getAbsolutePath()).toString());
    L115:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r2, com.obric.aiagent.skill.manager.api.e r3) {
        com.obric.aiagent.skill.manager.api.aq r1 = r3.g();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r2.g(), com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L8;
        return;
    L8:
        throw new cd(r2.a(), ce.f19647a);
    L10:
        if (d.h.b.o.a(r1, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L28;
        if (d.h.b.o.a(r2.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L26;
        com.obric.aiagent.skill.manager.api.a r4 = r2.h();
        String r0 = null;
        if (r4 == null) goto L16;
        String r5 = r4.a();
    L17:
        com.obric.aiagent.skill.manager.api.a r6 = r3.h();
        if (r6 == null) goto L21;
        r0 = r6.a();
    L21:
        if (d.h.b.o.a(r5, r0) == false) goto L24;
        return;
    L24:
        throw new cd(r2.a(), ce.f19648b);
    L16:
        r5 = null;
        goto L17
    L26:
        throw new cd(r2.a(), ce.f19647a);
    L28:
        throw new cd(r2.a(), ce.f19647a);
    }

    public final com.obric.aiagent.skill.manager.api.e a(File r25, com.obric.aiagent.skill.manager.api.e r26, d.h.a.a<d.x> r27) {
        d.h.a.a<d.x> r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r25, "sourceDir");
        d.h.b.o.e(r26, "skill");
        d.h.b.o.e(r2, "checkCancelled");
        if (ZeusTransformUtils.instanceOf(r26.g(), com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L7;
        e(r25);
        String r3 = this.f19465c.f(new File(r25, "SKILL.md"));
        da r4 = db.a(db.f19721a, r3, 0, 2, null);
        a(r4.e(), r26.g());
        return a(com.obric.aiagent.skill.manager.api.e.a(r26, null, r4.e(), r4.b(), null, null, null, null, null, null, hj.f20114a.a(), r3, false, false, null, null, null, null, 129529, null), r25, "Created from OVirt package", r2);
    L7:
        throw new IllegalArgumentException("Applied Skill creation source must be created_chat.".toString());
    }

    public final x a(File r29, com.obric.aiagent.skill.manager.api.e r30) {
        d.h.b.o.e(r29, "sourceDir");
        d.h.b.o.e(r30, "baseSkill");
        e(r29);
        File r1 = new File(r29, "SKILL.md");
        String r2 = this.f19465c.f(r1);
        da r3 = db.a(db.f19721a, r2, 0, 2, null);
        Object r15 = this.j;
        monitor-enter(r15);
        String r12 = r30.a();     // Catch: Throwable -> L28
        this.h.b(r12);     // Catch: Throwable -> L28
        File r8 = this.f19465c.a(r12);     // Catch: Throwable -> L28
        com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f19466d.a().get(r12), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r9 == null) goto L25;
        com.obric.aiagent.skill.manager.api.e r25 = b(r8, r9);     // Catch: Throwable -> L28
        if (r25 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r25.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L21;
        da r5 = db.a(db.f19721a, r25.k(), 0, 2, null);     // Catch: Throwable -> L28
        if (d.h.b.o.a(r3.a(), r5.a()) == false) goto L19;
        a(r3.e(), r25.g());     // Catch: Throwable -> L28
        b(r3.e(), r12);     // Catch: Throwable -> L28
        bg.c(r30);     // Catch: Throwable -> L28
        int r26 = hj.f20114a.c(r25.j());     // Catch: Throwable -> L28
        String r7 = r3.e();     // Catch: Throwable -> L28
        String r10 = r3.b();     // Catch: Throwable -> L28
        com.obric.aiagent.skill.manager.api.aq r4 = r25.g();     // Catch: Throwable -> L28
        x r6 = new x(a(r12, com.obric.aiagent.skill.manager.api.e.a(r25, null, r7, r10, null, null, r25.f(), r4, null, null, r26, r2, r25.l(), r25.m(), r25.n(), r25.o(), null, null, 98713, null), r29, r26, "Applied from OVirt package"), r25.j());     // Catch: Throwable -> L26
        monitor-exit(r15);
        return r6;
    L19:
        throw new dj();     // Catch: Throwable -> L26
    L21:
        throw new dk();     // Catch: Throwable -> L26
    L23:
        throw new dl();     // Catch: Throwable -> L26
    L25:
        throw new dl();     // Catch: Throwable -> L26
    L26:
        th = th;
    L30:
        monitor-exit(r15);
        throw th;
    L28:
        th = th;
        goto L30
    }

    public final boolean a(String r3, File r4) {
        d.h.b.o.e(r3, "slug");
        d.h.b.o.e(r4, "sourceDir");
        e(r4);
        Object r0 = this.j;
        monitor-enter(r0);
        File r5 = this.f19465c.a(r3);     // Catch: Throwable -> L12
        if (this.f19465c.c(r5) == false) goto L9;
        if (d.h.b.o.a(f(r5), f(r4)) == false) goto L9;
        boolean r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L9:
        r2 = false;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r36, File r37, String r38, d.h.a.a<d.x> r39) {
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r39, d.h.a.a.class, "com.obric.aiagent.plugin");
        Object r10 = this.j;
        monitor-enter(r10);
        r9.invoke();     // Catch: Throwable -> L65
        String r11 = r36.a();     // Catch: Throwable -> L65
        this.h.b(r11);     // Catch: Throwable -> L65
        String r1 = r36.b();     // Catch: Throwable -> L65
        a(r36, a(r36, r37));     // Catch: Throwable -> L65
        a(r1, r36.g());     // Catch: Throwable -> L65
        if (g(r11) == true) goto L64;
        File r14 = this.f19465c.a(r11);     // Catch: Throwable -> L65
        if (this.f19465c.a(r14) == true) goto L62;
        File r13 = 2;
        a(this, r1, null, 2, null);     // Catch: Throwable -> L65
        File r12 = a();     // Catch: Throwable -> L65
        File r7 = new File(r12, r11);     // Catch: Throwable -> L65
        boolean r32 = true;
        File r6 = null;
        this.f19465c.d(r7);     // Catch: Throwable -> L50 Exception -> L52
        if (r37 != null) goto L80;
    L16:
        File r2 = new File(r7, "SKILL.md");     // Catch: Throwable -> L50 Exception -> L52
        if (r37 != null) goto L68;
        e(r36.k());     // Catch: Exception -> L14 Throwable -> L50
        this.f19465c.a(r2, r36.k());     // Catch: Exception -> L14 Throwable -> L50
    L14:
        e = e;
        r32 = false;
        r13 = r7;
    L55:
        if (r32 == true) goto L57;
        this.f19465c.g(r13);     // Catch: Throwable -> L58
    L57:
        throw e;     // Catch: Throwable -> L58
    L68:
        if (this.f19465c.b(r2) == false) goto L47;
        String r0 = this.f19465c.f(r2);     // Catch: Throwable -> L50 Exception -> L52
        da r16 = db.a(db.f19721a, r0, 0, 2, null);     // Catch: Throwable -> L50 Exception -> L52
        r9.invoke();     // Catch: Throwable -> L50 Exception -> L52
        boolean r33 = false;
        long r3 = a(r7, hj.f20114a.b(r36.j()), r7, null, r38, r9);     // Catch: Exception -> L42 Throwable -> L50
    L74:
        com.obric.aiagent.skill.manager.api.e r4 = a(com.obric.aiagent.skill.manager.api.e.a(r36, null, null, r16.b(), null, null, null, null, null, null, 0, null, false, false, Long.valueOf(r3), null, Long.valueOf(r3), null, 73723, null), r11, r0, r36.l());     // Catch: Exception -> L40 Throwable -> L58
        ca r5 = this.f19465c;     // Catch: Exception -> L40 Throwable -> L58
        r13 = r7;
        File r8 = new File(r13, ".local_commit_pending");     // Catch: Exception -> L48 Throwable -> L58
        String r15 = this.i.toJson(d.a.ao.a(new d.m[]{d.s.a("slug", r11), d.s.a("createdAt", Long.valueOf(r3))}));     // Catch: Exception -> L48 Throwable -> L58
        d.h.b.o.c(r15, "toJson(...)");     // Catch: Exception -> L48 Throwable -> L58
        r5.a(r8, r15);     // Catch: Exception -> L48 Throwable -> L58
        r9.invoke();     // Catch: Exception -> L48 Throwable -> L58
        this.f19465c.a(r13, r14);     // Catch: Exception -> L48 Throwable -> L58
        this.f19466d.a(r4);     // Catch: Exception -> L33 Throwable -> L58
        b(r14, r11);     // Catch: Exception -> L38 Throwable -> L58
        this.f19465c.g(r12);     // Catch: Throwable -> L65
        monitor-exit(r10);
        return r4;
    L33:
        e = move-exception;
        if (this.f19465c.g(r14) == true) goto L37;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(new IOException("Failed to remove Skill directory after metadata rejection: " + r14.getAbsolutePath()), Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L38 Throwable -> L58
    L37:
        throw e;     // Catch: Exception -> L38 Throwable -> L58
    L38:
        e = e;
    L40:
        e = e;
    L44:
        r13 = r7;
    L54:
        r32 = r33;
    L42:
        e = e;
        goto L44
    L47:
        throw new IllegalArgumentException("Skill package must contain SKILL.md.");     // Catch: Exception -> L48 Throwable -> L58
    L48:
        e = e;
        goto L54
    L80:
        b(r37, r7, r9);     // Catch: Exception -> L14 Throwable -> L50
    L50:
        th = th;
        r6 = r12;
    L59:
        this.f19465c.g(r6);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L52:
        e = e;
        r33 = false;
        r13 = r7;
    L58:
        th = th;
        goto L59
    L62:
        throw new cd(r11, ce.f19647a);     // Catch: Throwable -> L65
    L64:
        throw new cd(r11, ce.f19647a);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        throw th;
    }

    public final com.obric.aiagent.skill.manager.api.e b(com.obric.aiagent.skill.manager.api.e r30) {
        d.h.b.o.e(r30, "skill");
        String r7 = r30.a();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L35;
        e(r30.k());
        Object r8 = this.j;
        monitor-enter(r8);
        this.h.b(r7);     // Catch: Throwable -> L31
        File r4 = this.f19465c.a(r7);     // Catch: Throwable -> L31
        if (this.f19465c.c(r4) == false) goto L30;
        com.obric.aiagent.skill.manager.api.e r1 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f19466d.a().get(r7), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r1 == null) goto L28;
        com.obric.aiagent.skill.manager.api.e r15 = b(r4, r1);     // Catch: Throwable -> L31
        if (r15 == null) goto L26;
        bg.a(r15);     // Catch: Throwable -> L31
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r30.b(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (d.o.o.d(r2) == false) goto L15;
        r2 = r15.b();     // Catch: Throwable -> L31
    L15:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r30.c(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (d.o.o.d(r3) == false) goto L18;
        r3 = r15.c();     // Catch: Throwable -> L31
    L18:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        da r5 = db.a(db.f19721a, r15.k(), 0, 2, null);     // Catch: Throwable -> L31
        a(r11, r15.g());     // Catch: Throwable -> L31
        b(r11, r7);     // Catch: Throwable -> L31
        String r14 = a(r30.k(), r11, r12, r5);     // Catch: Throwable -> L31
        String r13 = r30.f();     // Catch: Throwable -> L31
        if ((!d.h.b.o.a(r14, f(r15.k()))) == true) goto L21;
        com.obric.aiagent.skill.manager.api.e r0 = a(r15, r13);     // Catch: Throwable -> L31
    L23:
        monitor-exit(r8);
        return r0;
    L21:
        int r10 = hj.f20114a.c(r15.j());     // Catch: Throwable -> L31
        this.f19465c.a(new File(r4, "SKILL.md"), r14);     // Catch: Throwable -> L31
        com.obric.aiagent.skill.manager.api.e r6 = a(com.obric.aiagent.skill.manager.api.e.a(r15, null, r11, r12, null, null, r13, r15.g(), null, null, r10, null, false, false, null, r15.o(), Long.valueOf(a(r7, r10, r4, Integer.valueOf(r15.j()), "Edited skill")), null, 81305, null), r7, r14, r15.l());     // Catch: Throwable -> L31
        this.f19466d.a(r6);     // Catch: Throwable -> L31
        this.f.a("Installed skill saved: slug=" + r7 + ", source=" + r6.g() + ", version=" + r10);     // Catch: Throwable -> L31
        r0 = r6;
        goto L23
    L26:
        throw new IllegalArgumentException("Installed skill not found: " + r7);     // Catch: Throwable -> L31
    L28:
        throw new IllegalArgumentException("Installed skill not found: " + r7);     // Catch: Throwable -> L31
    L30:
        throw new IllegalArgumentException("Installed skill not found: " + r7);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L35:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    public final com.obric.aiagent.skill.manager.api.e a(String r6, String r7) {
        d.h.b.o.e(r6, "slug");
        d.h.b.o.e(r7, "coverUrl");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L25;
        Object r0 = this.j;
        monitor-enter(r0);
        this.h.b(r6);     // Catch: Throwable -> L21
        File r1 = this.f19465c.a(r6);     // Catch: Throwable -> L21
        if (this.f19465c.c(r1) == false) goto L20;
        com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f19466d.a().get(r6), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r2 == null) goto L18;
        com.obric.aiagent.skill.manager.api.e r3 = b(r1, r2);     // Catch: Throwable -> L21
        if (r3 == null) goto L16;
        bg.b(r3);     // Catch: Throwable -> L21
        com.obric.aiagent.skill.manager.api.e r5 = a(r3, r7);     // Catch: Throwable -> L21
        monitor-exit(r0);
        return r5;
    L16:
        throw new IllegalArgumentException("Installed skill not found: " + r6);     // Catch: Throwable -> L21
    L18:
        throw new IllegalArgumentException("Installed skill not found: " + r6);     // Catch: Throwable -> L21
    L20:
        throw new IllegalArgumentException("Installed skill not found: " + r6);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    private final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r23, String r24) {
        if (d.h.b.o.a(r24, r23.f()) == false) goto L5;
        return r23;
    L5:
        com.obric.aiagent.skill.manager.api.e r1 = com.obric.aiagent.skill.manager.api.e.a(r23, null, null, null, null, null, r24, null, null, null, 0, null, false, false, null, null, null, null, 131039, null);
        this.f19466d.a(r1);
        this.f.a("Installed skill cover saved without version change: slug=" + r23.a() + ", source=" + r23.g() + ", version=" + r23.j());
        return r1;
    }

    public final String a(String r5) {
        d.h.b.o.e(r5, "slug");
        Object r0 = this.j;
        monitor-enter(r0);
        String r2 = null;
        if (this.h.a(r5) == false) goto L11;
        File r1 = new File(this.f19465c.a(r5), "SKILL.md");     // Catch: Throwable -> L13
        if (this.f19465c.b(r1) == false) goto L11;
        r2 = this.f19465c.f(r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aiagent.skill.manager.impl.gh
    public dp b(String r11, File r12) {
        d.h.b.o.e(r11, "slug");
        d.h.b.o.e(r12, "targetFile");
        Object r0 = this.j;
        monitor-enter(r0);
        this.h.b(r11);     // Catch: Throwable -> L32
        File r1 = this.f19465c.a(r11);     // Catch: Throwable -> L32
        if (this.f19465c.c(r1) == false) goto L31;
        File r2 = new File(r1, "SKILL.md");     // Catch: Throwable -> L32
        if (this.f19465c.b(r2) == false) goto L29;
        String r9 = this.f19465c.f(r2);     // Catch: Throwable -> L32
        db.a(db.f19721a, r9, 0, 2, null);     // Catch: Throwable -> L32
        File r3 = r12.getParentFile();     // Catch: Throwable -> L32
        if (r3 == null) goto L12;
        r3.mkdirs();     // Catch: Throwable -> L32
    L12:
        if (r12.exists() == true) goto L14;
    L18:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r12), OutputStream.class, "com.obric.aiagent.plugin")), OutputStream.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        ZipOutputStream r5 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r4, ZipOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        r5.setLevel(-1);     // Catch: Throwable -> L23
        a(r1, r1, r5);     // Catch: Throwable -> L23
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L23
        d.f.c.a(r4, null);     // Catch: Throwable -> L32
        dp r7 = new dp(r12, r12.length(), h(r12), r9);     // Catch: Throwable -> L32
        this.f.a("Skill package exported: slug=" + r11 + ", fileSize=" + r7.b() + ", sha256=" + d.o.o.e(r7.c(), 12));     // Catch: Throwable -> L32
        monitor-exit(r0);
        return r7;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        d.f.c.a(r4, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L14:
        if (r12.delete() == true) goto L18;
        throw new IllegalStateException("Failed to clear exported skill package: " + r12.getAbsolutePath());     // Catch: Throwable -> L32
    L29:
        throw new IllegalArgumentException("Installed skill does not contain SKILL.md: " + r11);     // Catch: Throwable -> L32
    L31:
        throw new IllegalArgumentException("Installed skill not found: " + r11);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public final boolean b(String r3) {
        d.h.b.o.e(r3, "slug");
        Object r0 = this.j;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.h.a(r3) == true) goto L7;
        boolean r2 = false;
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        r2 = g(r3);     // Catch: Throwable -> L10
        goto L8
    }

    public final List<bp> a(Set<String> r14) {
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "slugs");
        if (r15.isEmpty() == true) goto L5;
        Object r0 = this.j;
        monitor-enter(r0);
        Map<String, com.obric.aiagent.skill.manager.api.e> r1 = this.f19466d.a();     // Catch: Throwable -> L34
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Iterator r17 = r16.iterator();     // Catch: Throwable -> L34
    L10:
        if (r17.hasNext() == false) goto L31;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        File r3 = this.f19465c.a(r5);     // Catch: Throwable -> L34
        boolean r7 = this.f19465c.a(r3);     // Catch: Throwable -> L34
        boolean r8 = r1.containsKey(r5);     // Catch: Throwable -> L34
        if (r7 == false) goto L14;
        this.f19465c.g(r3);     // Catch: Throwable -> L34
    L14:
        if (r8 == false) goto L16;
    L17:
        this.f19466d.b(r5);     // Catch: Throwable -> L34
    L18:
        boolean r4 = this.f19465c.a(r3);     // Catch: Throwable -> L34
        boolean r6 = this.f19466d.a(r5);     // Catch: Throwable -> L34
        if (r4 == true) goto L25;
        if (r6 == true) goto L25;
        if (r7 == true) goto L24;
        if (r8 == true) goto L24;
    L26:
        com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1.get(r5), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        boolean r10 = !r4;     // Catch: Throwable -> L34
        if (r6 == true) goto L29;
        boolean r11 = true;
    L30:
        r2.add(new bp(r5, r9, r7, r8, r10, r11));     // Catch: Throwable -> L34
        goto L10
    L29:
        r11 = false;
    L24:
        this.f.a("Disallowed Skill purged: slug=" + r5);     // Catch: Throwable -> L34
    L25:
        this.f.a("Disallowed Skill purge incomplete: slug=" + r5 + ", filesRemain=" + r4 + ", metadataRemains=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(new IOException("Disallowed Skill state remains after purge"), Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        goto L26
    L16:
        if (this.f19466d.a(r5) == false) goto L18;
    L31:
        List<bp> r13 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        monitor-exit(r0);
        return r13;
    L34:
        th = move-exception;
        throw th;
    L5:
        return d.a.p.b();
    }

    public final boolean c(String r8) {
        d.h.b.o.e(r8, "slug");
        Object r0 = this.j;
        monitor-enter(r0);
        File r1 = this.f19465c.a(r8);     // Catch: Throwable -> L17
        boolean r3 = true;
        if (this.f19465c.a(r1) == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        boolean r4 = this.f19466d.b(r8);     // Catch: Throwable -> L17
        this.f.a("Persistent skill deleted: slug=" + r8 + ", deletedFiles=" + r2 + ", deletedMetadata=" + r4);     // Catch: Throwable -> L17
        if (r2 == true) goto L15;
        if (r4 == true) goto L15;
        r3 = false;
    L15:
        monitor-exit(r0);
        return r3;
    L7:
        if (this.f19465c.g(r1) == false) goto L9;
        r2 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public final File d(String r6) {
        d.h.b.o.e(r6, "slug");
        File r0 = new File(this.f19464b, "skill_projection_" + System.nanoTime());
        Object r1 = this.j;     // Catch: Exception -> L16
        monitor-enter(r1);     // Catch: Exception -> L16
        this.h.b(r6);     // Catch: Throwable -> L13
        File r2 = this.f19465c.a(r6);     // Catch: Throwable -> L13
        if (this.f19465c.c(r2) == false) goto L12;
        this.f19465c.d(r0);     // Catch: Throwable -> L13
        c(r2, r0);     // Catch: Throwable -> L13
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Exception -> L16
        this.f.b("Skill projection package prepared: " + r6);     // Catch: Exception -> L16
        return r0;
    L12:
        throw new IllegalArgumentException(("Installed skill dir not found: " + r6).toString());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        this.f19465c.g(r0);
        throw e;
    }

    public final void a(File r2) {
        d.h.b.o.e(r2, "projectionDir");
        this.f19465c.g(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.aiagent.skill.manager.impl.ca] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.obric.aiagent.skill.manager.impl.ca] */
    /* JADX WARN: Type inference failed for: r36v3 */
    /* JADX WARN: Type inference failed for: r36v5 */
    /* JADX WARN: Type inference failed for: r37v0, types: [com.obric.aiagent.skill.manager.impl.ag] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final com.obric.aiagent.skill.manager.api.e a(String r38, com.obric.aiagent.skill.manager.api.e r39, File r40, int r41, String r42) {
        d(r40);
        File r1 = new File(r40, "SKILL.md");
        if (this.f19465c.b(r1) == false) goto L136;
        db.a(db.f19721a, this.f19465c.f(r1), 0, 2, null);
        Object r11 = this.j;
        monitor-enter(r11);
        this.h.b(r38);     // Catch: Throwable -> L131
        com.obric.aiagent.skill.manager.api.e r12 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f19466d.a().get(r38), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L131
        if (d.h.b.o.a(r39.a(), r38) == false) goto L128;
        com.obric.aiagent.skill.manager.api.e r14 = c(r12, r39);     // Catch: Throwable -> L131
        com.obric.aiagent.skill.manager.api.aq r15 = r39.g();     // Catch: Throwable -> L131
        int r6 = hj.f20114a.b(r41);     // Catch: Throwable -> L131
        if (r12 == null) goto L11;
        hj.f20114a.a(r38, r12.j(), r6);     // Catch: Throwable -> L131
    L11:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.b(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L131
        if (d.o.o.d(r2) == false) goto L14;
        r2 = r38;
    L14:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L131
        boolean r33 = true;
        if (r12 == null) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        String r5 = r38;
    L21:
        b(r3, r5);     // Catch: Throwable -> L131
        File r7 = this.f19465c.a(r38);     // Catch: Throwable -> L131
        this.f19465c.d(r7);     // Catch: Throwable -> L131
        Object r34 = r11;
        File r8 = new File(this.f19464b, new StringBuilder().append("skill_active_backup_").append(r38).append('_').append(System.nanoTime()).toString());     // Catch: Throwable -> L129
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r7), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L129
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L26;
    L28:
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L129
    L30:
        if (r10.hasNext() == false) goto L35;
        r11 = "com.obric.aiagent.plugin";
        if ((!d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r10.next(), File.class, "com.obric.aiagent.plugin")).getName(), ".versions")) == false) goto L30;
        ?? r13 = 1;
        ?? r16 = r11;
    L36:
        if (r13 != 0) goto L143;
    L142:
        File r17 = new File(this.f19465c.b(r38), String.valueOf(r6));     // Catch: Throwable -> L129
        b(r7);     // Catch: Throwable -> L96 Exception -> L98
        a(r40, r7);     // Catch: Throwable -> L96 Exception -> L98
        File r0 = new File(r7, "SKILL.md");     // Catch: Throwable -> L96 Exception -> L98
        String r18 = this.f19465c.f(r0);     // Catch: Throwable -> L96 Exception -> L98
        if (d.h.b.o.a(h(r0), h(r1)) == false) goto L93;
        if (r12 != null) goto L138;
        Integer r19 = null;
    L52:
        long r20 = a(r38, r6, r7, r19, r42);     // Catch: Exception -> L94 Throwable -> L122
        if (r12 == null) goto L56;
        Long r21 = r12.n();     // Catch: Exception -> L94 Throwable -> L122
        if (r21 == null) goto L56;
    L70:
        Long r27 = r21;
    L72:
        if (r12 == null) goto L74;
        Long r28 = r12.o();     // Catch: Exception -> L94 Throwable -> L122
    L75:
        com.obric.aiagent.skill.manager.api.e r22 = com.obric.aiagent.skill.manager.api.e.a(r14, null, null, null, null, null, null, null, null, null, r6, null, false, false, r27, r28, Long.valueOf(r20), null, 73215, null);     // Catch: Exception -> L94 Throwable -> L122
        if (r12 == null) goto L78;
        r33 = r12.l();     // Catch: Exception -> L94 Throwable -> L122
    L78:
        com.obric.aiagent.skill.manager.api.e r23 = a(r22, r38, r18, r33);     // Catch: Exception -> L94 Throwable -> L122
        this.f19466d.a(r23);     // Catch: Exception -> L94 Throwable -> L122
        ed r24 = this.f;     // Catch: Exception -> L94 Throwable -> L122
        StringBuilder r25 = new StringBuilder().append("Skill package saved: slug=").append(r38).append(", source=").append(r15).append(", reason=");     // Catch: Exception -> L94 Throwable -> L122
        if (r42 != null) goto L81;
        String r26 = "";
    L82:
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L94 Throwable -> L122
        if (d.o.o.d(r29) == false) goto L85;
        r29 = "-";
    L85:
        r24.a(r25.append((String) ZeusTransformUtils.preCheckCast(r29, String.class, "com.obric.aiagent.plugin")).append(", version=").append(r23.j()).toString());     // Catch: Exception -> L94 Throwable -> L122
        if (this.f19465c.a(r8) == false) goto L89;
        this.f19465c.g(r8);     // Catch: Throwable -> L129
    L89:
        monitor-exit(r34);
        return r23;
    L81:
        r26 = r42;
        goto L82
    L74:
        r28 = null;
    L56:
        r21 = r39.n();     // Catch: Exception -> L94 Throwable -> L122
        if (r21 != null) goto L70;
        r21 = Long.valueOf(r20);     // Catch: Exception -> L94 Throwable -> L122
        ((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Exception -> L94 Throwable -> L122
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L61;
    L66:
        boolean r110 = true;
    L67:
        if (r110 == true) goto L70;
        r27 = null;
        goto L72
    L61:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L66;
        if (d.h.b.o.a(r15, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L66;
        r110 = false;
        goto L67
    L138:
        r19 = Integer.valueOf(r12.j());     // Catch: Exception -> L48 Throwable -> L96
    L48:
        e = move-exception;
        Exception r30 = e;
        r16 = r8;
        ?? r111 = r7;
    L148:
        d.n.a r31 = d.n.f38560a;     // Catch: Throwable -> L116
        b(r111);     // Catch: Throwable -> L116
        if (r13 == 0) goto L105;
        a(r16, r111);     // Catch: Throwable -> L116
    L105:
        if (this.f19465c.a(r17) == true) goto L107;
    L111:
        if (r12 != null) goto L113;
        Object r32 = Boolean.valueOf(this.f19466d.b(r38));     // Catch: Throwable -> L116
    L114:
        Object r35 = d.n.f(r32);     // Catch: Throwable -> L116
    L118:
        Throwable r36 = d.n.c(r35);     // Catch: Throwable -> L122
        if (r36 == null) goto L152;
        r30.addSuppressed(r36);     // Catch: Throwable -> L122
        throw r30;     // Catch: Throwable -> L122
    L152:
        throw r30;     // Catch: Throwable -> L122
    L113:
        this.f19466d.a(r12);     // Catch: Throwable -> L116
        r32 = d.x.f38692a;     // Catch: Throwable -> L116
        goto L114
    L107:
        if (this.f19465c.g(r17) == true) goto L111;
        throw new IllegalStateException("Failed to remove incomplete Skill version.");     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        d.n.a r37 = d.n.f38560a;     // Catch: Throwable -> L122
        r35 = d.n.f(d.o.a(th));     // Catch: Throwable -> L122
        goto L118
    L93:
        throw new IllegalStateException("Persisted SKILL.md differs from source package.");     // Catch: Exception -> L94 Throwable -> L122
    L94:
        e = e;
    L100:
        r30 = e;
        r111 = r13;
        r16 = r17;
    L96:
        th = th;
        r16 = r8;
    L124:
        if (this.f19465c.a(r16) == false) goto L126;
        this.f19465c.g(r16);     // Catch: Throwable -> L129
    L126:
        throw th;     // Catch: Throwable -> L129
    L98:
        e = e;
        r17 = r8;
        r13 = r7;
    L122:
        th = th;
        goto L124
    L143:
        this.f19465c.d(r8);     // Catch: Exception -> L39 Throwable -> L129
        b(r7, r8);     // Catch: Exception -> L39 Throwable -> L129
    L39:
        e = move-exception;
        this.f19465c.g(r8);     // Catch: Throwable -> L129
        throw e;     // Catch: Throwable -> L129
    L35:
        r13 = 0;
        r16 = r11;
        goto L36
    L26:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L28;
    L20:
        r5 = null;
        goto L21
    L17:
        r4 = false;
        goto L18
    L128:
        throw new IllegalArgumentException("Skill package slug does not match the authoritative slug.".toString());     // Catch: Throwable -> L129
    L129:
        th = th;
    L133:
        monitor-exit(r34);
        throw th;
    L131:
        th = th;
        r34 = r11;
        goto L133
    L136:
        throw new IllegalArgumentException("Skill package must contain SKILL.md.".toString());
    }

    private final void a(File r4, String r5) {
        ac r0 = this.f19467e;
        if (r0 == null) goto L5;
        ab r6 = r0.a(r4, r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, ab.c.class) == false) goto L18;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(((ab.c) ZeusTransformUtils.preCheckCast(r6, ab.c.class, "com.obric.aiagent.plugin")).b().a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L16;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f19467e.a(r5, (ab.c) ZeusTransformUtils.preCheckCast(r6, ab.c.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("AppFunction Skill package must contain a readable Obric Tool Schema.".toString());
    L16:
        throw new IllegalArgumentException("AppFunction Skill package must declare an Obric Tool Schema.".toString());
    L18:
        if (ZeusTransformUtils.instanceOf(r6, ab.a.class) == true) goto L28;
        if (d.h.b.o.a(r6, ab.b.f19436a) == true) goto L26;
        if (r6 == null) goto L26;
        throw new d.k();
    L26:
        throw new IllegalArgumentException("AppFunction Skill package must contain a valid Obric manifest.");
    L28:
        throw new IllegalArgumentException("Invalid AppFunction Obric Skill manifest: " + ((ab.a) ZeusTransformUtils.preCheckCast(r6, ab.a.class, "com.obric.aiagent.plugin")).a(), ((ab.a) ZeusTransformUtils.preCheckCast(r6, ab.a.class, "com.obric.aiagent.plugin")).b());
    L5:
        r6 = null;
        goto L7
    }

    private final Object a(File r7, String r8, com.obric.aiagent.skill.manager.api.e r9) {
        File r1 = new File(this.f19464b, "skill_zip_" + System.nanoTime());
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        ag r6 = (ag) ZeusTransformUtils.preCheckCast(this, ag.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r1.mkdirs();     // Catch: Throwable -> L5
        r6.d(r7, r1);     // Catch: Throwable -> L5
        Object r10 = r6.b(r1, r8, r9);     // Catch: Throwable -> L5
        d.o.a(r10);     // Catch: Throwable -> L5
        Object r11 = d.n.f((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        d.f.k.h(r1);
        return r11;
    L5:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L7
    }

    private final Object b(File r29, String r30, com.obric.aiagent.skill.manager.api.e r31) {
        String r2 = r30;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L52
        ag r1 = (ag) ZeusTransformUtils.preCheckCast(this, ag.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (ZeusTransformUtils.instanceOf(r31.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L51;
        File r5 = r1.g(r29);     // Catch: Throwable -> L52
        if (r5 == null) goto L49;
        File r6 = r5.getParentFile();     // Catch: Throwable -> L52
        if (r6 != null) goto L10;
        File r7 = r29;
    L11:
        ab r8 = null;
        db.a(db.f19721a, d.f.k.a(r5, null, 1, null), 0, 2, null);     // Catch: Throwable -> L52
        if (r2 != null) goto L14;
    L19:
        String r9 = r31.a();     // Catch: Throwable -> L52
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r9 = null;
    L23:
        if (r9 == null) goto L47;
    L24:
        ac r4 = r1.f19467e;     // Catch: Throwable -> L52
        if (r4 == null) goto L28;
        r8 = r4.a(r7, r9);     // Catch: Throwable -> L52
    L28:
        if (ZeusTransformUtils.instanceOf(r8, ab.a.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r8, ab.c.class) == false) goto L32;
    L37:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r31.a(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (d.o.o.d(r10) == false) goto L40;
        r10 = r9;
    L40:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r31.b(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (d.o.o.d(r12) == false) goto L43;
        r12 = r9;
    L43:
        Object r3 = d.n.f(r1.b(r31, r1.a(r9, com.obric.aiagent.skill.manager.api.e.a(r31, r11, (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, 131068, null), r7, hj.f20114a.a(Integer.valueOf(r31.j())), "Imported from zip")));     // Catch: Throwable -> L52
    L54:
        Throwable r13 = d.n.c(r3);
        if (r13 == null) goto L63;
        ed r14 = this.f;
        StringBuilder r15 = new StringBuilder().append("Install skill directory package failed: overrideSlug=");
        if (r2 != null) goto L59;
        r2 = "";
    L59:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r16) == false) goto L62;
        r16 = "-";
    L62:
        r14.a(r15.append((String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin")).toString(), r13);
    L63:
        return r3;
    L32:
        if (d.h.b.o.a(r8, ab.b.f19436a) == true) goto L37;
        if (r8 == null) goto L37;
        throw new d.k();     // Catch: Throwable -> L52
    L45:
        throw new IllegalArgumentException("Invalid Obric Skill manifest: " + ((ab.a) ZeusTransformUtils.preCheckCast(r8, ab.a.class, "com.obric.aiagent.plugin")).a(), ((ab.a) ZeusTransformUtils.preCheckCast(r8, ab.a.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L52
    L47:
        throw new IllegalArgumentException("Downloaded Skill slug must not be blank.");     // Catch: Throwable -> L52
    L14:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L16;
        r9 = r2;
    L17:
        if (r9 == null) goto L19;
    L16:
        r9 = null;
        goto L17
    L10:
        r7 = r6;
        goto L11
    L49:
        throw new IllegalArgumentException("Directory does not contain SKILL.md");     // Catch: Throwable -> L52
    L51:
        throw new IllegalArgumentException("Downloaded Skill source must be store.".toString());     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L54
    }

    private final long a(String r11, int r12, File r13, Integer r14, String r15) {
        return a(this, this.f19465c.a(r11), r12, r13, r14, r15, null, 32, null);
    }

    static /* synthetic */ long a(ag r7, File r8, int r9, File r10, Integer r11, String r12, d.h.a.a r13, int r14, Object r15) {
        d.h.a.a<d.x> r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r14 & 32) == 0) goto L6;
        r16 = $$Lambda$ag$K9Xs0nxuyjp5bqjDU1VpF1p3og.INSTANCE;
    L6:
        return r7.a(r8, r9, r10, r11, r12, r16);
    }

    private static final d.x e() {
        return d.x.f38692a;
    }

    private final long a(File r6, int r7, File r8, Integer r9, String r10, d.h.a.a<d.x> r11) {
        d.h.a.a<d.x> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        int r13 = hj.f20114a.b(r7);
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        File r2 = new File(new File(r6, ".versions"), String.valueOf(r13));
        this.f19465c.d(r2);
        a(r8, new File(r2, "package"), r12);
        r12.invoke();
        Map r14 = d.a.ao.a(new d.m[]{d.s.a("version", Integer.valueOf(r13)), d.s.a("parentVersion", r9), d.s.a("lastUpdatedAt", Long.valueOf(r0)), d.s.a("reason", r10)});
        ca r15 = this.f19465c;
        File r16 = new File(r2, "manifest.json");
        String r5 = this.i.toJson(r14);
        d.h.b.o.c(r5, "toJson(...)");
        r15.a(r16, r5);
        return r0;
    }

    private final void a(File r3, File r4, d.h.a.a<d.x> r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (this.f19465c.a(r4) == true) goto L5;
    L9:
        this.f19465c.d(r4);
        b(r3, r4, r6);
        return;
    L5:
        if (this.f19465c.g(r4) == true) goto L9;
        throw new IllegalStateException("Failed to clear version package: " + r4.getAbsolutePath());
    }

    private final void b(File r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r6), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r2 = r8.next();
        if ((!d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).getName(), ".versions")) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r9.hasNext() == false) goto L16;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r9.next(), File.class, "com.obric.aiagent.plugin");
        if (this.f19465c.g(r1) == true) goto L10;
        throw new IllegalStateException("Failed to clear skill file: " + r1.getAbsolutePath());
    }

    private final void a(File r7, File r8) {
        this.f19465c.d(r8);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r7), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r2 = r10.next();
        if ((true ^ d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).getName(), ".versions")) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r11.next(), File.class, "com.obric.aiagent.plugin");
        File r3 = new File(r8, r1.getName());
        this.f19465c.a(r1, r3, true);
        goto L10
    }

    private final void b(File r7, File r8, d.h.a.a<d.x> r9) {
        d.h.a.a<d.x> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        r10.invoke();
        this.f19465c.d(r8);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r7), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r2 = r12.next();
        if ((true ^ d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).getName(), ".versions")) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r13.next(), File.class, "com.obric.aiagent.plugin");
        r10.invoke();
        this.f19465c.a(r1, new File(r8, r1.getName()), true, r10);
        goto L10
    }

    private final void b(File r7, File r8) {
        this.f19465c.d(r8);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r7), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r2 = r10.next();
        if ((true ^ d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).getName(), ".versions")) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r11.next(), File.class, "com.obric.aiagent.plugin");
        this.f19465c.a(r1, new File(r8, r1.getName()), true);
        goto L10
    }

    private final void c(File r8, File r9) {
        this.f19465c.d(r9);
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r8), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L3:
        boolean r3 = true;
        if (r11.hasNext() == false) goto L13;
        Object r2 = r11.next();
        File r4 = (File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r4.getName(), ".versions") == false) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L3;
        r0.add(r2);
        goto L3
    L8:
        if (d.h.b.o.a(r4.getName(), ".local_commit_pending") == true) goto L10;
    L13:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r12.hasNext() == false) goto L17;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r12.next(), File.class, "com.obric.aiagent.plugin");
        this.f19465c.a(r1, new File(r9, r1.getName()), true);
        goto L15
    }

    private final int c(File r2) {
        if (r2.exists() == true) goto L7;
        return 0;
    L7:
        return d.n.m.k(d.n.m.a((d.n.j) ZeusTransformUtils.preCheckCast(d.f.k.d(r2), d.n.j.class, "com.obric.aiagent.plugin"), $$Lambda$ag$LnggnuBZ2FsIo5BFDbJzzuAU8.INSTANCE));
    }

    private static final boolean i(File r1) {
        d.h.b.o.e(r1, "it");
        if (r1.isFile() == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(r1.getName(), "manifest.json") == true) goto L7;
        return true;
    }

    private final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r25, String r26, String r27, boolean r28) {
        if (d.h.b.o.a(r25.a(), r26) == false) goto L17;
        da r0 = db.a(db.f19721a, r27, 0, 2, null);
        if (ZeusTransformUtils.instanceOf(r25.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L7;
    L13:
        String r1 = r0.e();
    L15:
        return com.obric.aiagent.skill.manager.api.e.a(r25, null, r1, r0.b(), null, null, null, null, null, null, hj.f20114a.b(r25.j()), r27, r28, false, null, null, null, null, 127481, null);
    L7:
        if (d.h.b.o.a(r25.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L13;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r25.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r2) == false) goto L12;
        r2 = r25.a();
    L12:
        r1 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        goto L15
    L17:
        throw new IllegalArgumentException("Installed Skill slug does not match the authoritative slug.".toString());
    }

    private final com.obric.aiagent.skill.manager.api.e b(com.obric.aiagent.skill.manager.api.e r24, com.obric.aiagent.skill.manager.api.e r25) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r24.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r0) == false) goto L5;
        r0 = r25.a();
    L5:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        String r7 = r24.d();
        String r6 = r25.c();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r25.k(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L8;
        r1 = r24.k();
    L8:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        boolean r15 = r25.l();
        boolean r16 = r25.m();
        int r13 = r25.j();
        return com.obric.aiagent.skill.manager.api.e.a(r24, r4, null, r6, r7, null, null, r24.g(), null, null, r13, r14, r15, r16, r25.n(), r25.o(), r25.p(), null, 65970, null);
    }

    private final com.obric.aiagent.skill.manager.api.e b(File r9, com.obric.aiagent.skill.manager.api.e r10) {
        File r1 = new File(r9, "SKILL.md");
        if (this.f19465c.b(r1) == true) goto L20;
        return null;
    L20:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r3 = d.n.f(((ag) ZeusTransformUtils.preCheckCast(this, ag.class, "com.obric.aiagent.plugin")).f19465c.f(r1));     // Catch: Throwable -> L7
    L9:
        Throwable r4 = d.n.c(r3);
        if (r4 == null) goto L13;
        this.f.a("Failed to read " + r1, r4);
    L13:
        if (d.n.b(r3) == false) goto L15;
        r3 = null;
    L15:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L18;
        return null;
    L18:
        String r11 = r9.getName();
        d.h.b.o.c(r11, "getName(...)");
        return a(r10, r11, r0, r10.l());
    L7:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L9
    }

    private final com.obric.aiagent.skill.manager.api.e c(com.obric.aiagent.skill.manager.api.e r21, com.obric.aiagent.skill.manager.api.e r22) {
        if (r21 != null) goto L4;
        return r22;
    L4:
        boolean r0 = ZeusTransformUtils.instanceOf(r22.g(), com.obric.aiagent.skill.manager.api.aq.e.class);
        if (r0 == false) goto L7;
        String r2 = r22.b();
    L11:
        if (r0 == false) goto L14;
        String r3 = r22.d();
    L13:
        String r4 = r3;
        if (r0 == false) goto L21;
        String r1 = r22.f();
    L20:
        String r6 = r1;
        if (r0 == false) goto L27;
        com.obric.aiagent.skill.manager.api.aq r5 = r22.g();
    L30:
        com.obric.aiagent.skill.manager.api.aq r7 = r5;
        boolean r13 = r21.m();
        int r10 = r22.j();
        Long r8 = r21.n();
        if (r8 != null) goto L33;
        r8 = r22.n();
    L33:
        Long r14 = r8;
        Long r15 = r21.o();
        Long r9 = r22.p();
        if (r9 != null) goto L37;
        r9 = r21.p();
    L37:
        return com.obric.aiagent.skill.manager.api.e.a(r22, null, r2, null, r4, null, r6, r7, null, null, r10, null, false, r13, r14, r15, r9, null, 69013, null);
    L27:
        r5 = r22.g();
        if (r5 != null) goto L30;
        r5 = r21.g();
        goto L30
    L21:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r22.f(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r11) == false) goto L24;
        r11 = r21.f();
    L24:
        r1 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        goto L20
    L14:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r22.d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r12) == false) goto L17;
        r12 = r21.d();
    L17:
        r3 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
        goto L13
    L7:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r16) == false) goto L10;
        r16 = r21.b();
    L10:
        r2 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
        goto L11
    }

    private final void e(String r2) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("SKILL.md content must not be blank.".toString());
    }

    private final void a(String r3, com.obric.aiagent.skill.manager.api.aq r4) {
        com.obric.aiagent.skill.manager.api.aq r2 = (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.al r5 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L6;
        int r6 = r5.c();
    L19:
        if (r3.length() > r6) goto L21;
        return;
    L21:
        bv.a((bt) ZeusTransformUtils.preCheckCast(new bt.r(r6), bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L8;
    L17:
        r6 = r5.e();
        goto L19
    L8:
        if (d.h.b.o.a(r2, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L16;
        if (r2 != null) goto L15;
        return;
    L15:
        throw new d.k();
    }

    private final void d(File r4) {
        if ((!this.f19465c.a(new File(r4, ".versions"))) == false) goto L10;
        if ((!this.f19465c.a(new File(r4, ".local_commit_pending"))) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Skill package contains reserved commit marker.".toString());
    L10:
        throw new IllegalArgumentException("Skill package contains reserved versions directory.".toString());
    }

    private final void e(File r3) {
        if (this.f19465c.c(r3) == false) goto L14;
        d(r3);
        if (this.f19465c.b(new File(r3, "SKILL.md")) == false) goto L12;
        if ((!d.f.k.a(new File(r3, ".obric"), "manifest.json").isFile()) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Obric Skill packages can only be installed from the Skill Store.".toString());
    L12:
        throw new IllegalArgumentException("Skill package must contain SKILL.md.".toString());
    L14:
        throw new IllegalArgumentException("Skill package directory does not exist.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String> f(File r6) {
        final File r7 = r6.getCanonicalFile();
        d.h.b.o.a(r7);
        d.n.j r0 = d.n.m.a((d.n.j) ZeusTransformUtils.preCheckCast(d.f.k.d(r7), d.n.j.class, "com.obric.aiagent.plugin"), new $$Lambda$ag$6M1weyEvU8US1uMztCA8TbiVEg(r7));
        Map<String, String> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.a();
    L4:
        if (r2.hasNext() == false) goto L6;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r2.next(), File.class, "com.obric.aiagent.plugin");
        d.m r4 = d.s.a(d.f.k.g(d.f.k.b(r3, r7)), h(r3));
        r1.put(r4.a(), r4.b());
        goto L4
    L6:
        return r1;
    }

    private static final boolean e(File r3, File r4) {
        d.h.b.o.e(r4, "file");
        if (r4.isFile() == true) goto L5;
        return false;
    L5:
        if (d.h.b.o.a(r4.getName(), ".local_commit_pending") == true) goto L11;
        d.h.b.o.a(r3);
        if (d.o.o.b(d.f.k.g(d.f.k.b(r4, r3)), ".versions/", false, 2, null) == true) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    private final String a(String r12, String r13, String r14, da r15) {
        if (d.o.o.b(r12, "---", false, 2, null) == false) goto L8;
        da r3 = db.a(db.f19721a, r12, 0, 2, null);
        String r4 = r15.a();
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r11) == false) goto L7;
        r11 = r3.b();
    L7:
        da r16 = da.a(r3, r4, (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"), null, r13, null, 20, null);
    L10:
        return r16.f();
    L8:
        r16 = new da(r15.a(), r14, r12, r13, null, 16, null);
        goto L10
    }

    private final String f(String r4) {
        if (d.o.o.c(r4, "\n", false, 2, null) == false) goto L6;
        return r4;
    L6:
        return r4 + '\n';
    }

    private final File a() {
        File r0 = new File(this.f19465c.a(), ".staging");
        this.f19465c.d(r0);
        File r1 = new File(r0, "local_commit_" + ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() + '_' + System.nanoTime());
        if (this.f19465c.d(r1) == false) goto L6;
        return r1;
    L6:
        throw new IOException("Failed to create Skill commit staging directory: " + r1.getAbsolutePath());
    }

    private final void b() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(this.f19465c.b()), Iterable.class, "com.obric.aiagent.plugin");
        ca r1 = this.f19465c;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r4 = r2.next();
        if (r1.c((File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.aiagent.plugin")) == false) goto L4;
        r3.add(r4);
        goto L4
    L8:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        Object r8 = r7.next();
        if (this.f19465c.b(new File((File) ZeusTransformUtils.preCheckCast(r8, File.class, "com.obric.aiagent.plugin"), ".local_commit_pending")) == false) goto L10;
        r6.add(r8);
        goto L10
    L14:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r9.hasNext() == false) goto L24;
        File r10 = (File) ZeusTransformUtils.preCheckCast(r9.next(), File.class, "com.obric.aiagent.plugin");
        String r11 = r10.getName();
        df r12 = this.f19466d;
        d.h.b.o.a(r11);
        if (r12.a(r11) == true) goto L19;
        if (this.f19465c.g(r10) == false) goto L22;
        this.f.a("Removed interrupted local Skill commit: slug=" + r11);
        goto L16
    L22:
        this.f.a("Failed to remove interrupted local Skill commit: slug=" + r11, (Throwable) ZeusTransformUtils.preCheckCast(new IOException("Failed to remove interrupted Skill directory: " + r10.getAbsolutePath()), Throwable.class, "com.obric.aiagent.plugin"));
        goto L16
    L19:
        b(r10, r11);
        this.f.a("Recovered committed local Skill: slug=" + r11);
        goto L16
    }

    private final void c() {
        File r0 = new File(this.f19465c.a(), ".staging");
        if (this.f19465c.c(r0) == true) goto L5;
        return;
    L5:
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19465c.e(r0), Iterable.class, "com.obric.aiagent.plugin");
        ca r4 = this.f19465c;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r6 = r3.next();
        if (r4.c((File) ZeusTransformUtils.preCheckCast(r6, File.class, "com.obric.aiagent.plugin")) == false) goto L7;
        r5.add(r6);
        goto L7
    L11:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L20;
        Object r10 = r9.next();
        if ((r1 - ((File) ZeusTransformUtils.preCheckCast(r10, File.class, "com.obric.aiagent.plugin")).lastModified()) < 86400000) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L13;
        r8.add(r10);
        goto L13
    L17:
        r11 = false;
        goto L18
    L20:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        File r13 = (File) ZeusTransformUtils.preCheckCast(r12.next(), File.class, "com.obric.aiagent.plugin");
        if (this.f19465c.g(r13) == true) goto L22;
        this.f.a("Failed to remove stale Skill commit staging", (Throwable) ZeusTransformUtils.preCheckCast(new IOException("Failed to remove stale Skill staging directory: " + r13.getAbsolutePath()), Throwable.class, "com.obric.aiagent.plugin"));
        goto L22
    }

    private final void b(File r4, String r5) {
        File r0 = new File(r4, ".local_commit_pending");
        if (this.f19465c.a(r0) == true) goto L5;
        return;
    L5:
        if (this.f19465c.g(r0) == true) goto L9;
        this.f.a("Failed to remove local Skill commit marker: slug=" + r5, (Throwable) ZeusTransformUtils.preCheckCast(new IOException("Failed to delete Skill commit marker: " + r0.getAbsolutePath()), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final boolean g(String r3) {
        File r4 = this.f19465c.a(r3);
        File r0 = new File(r4, "SKILL.md");
        if (this.f19465c.c(r4) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f19465c.b(r0) == false) goto L7;
        return true;
    }

    private final da a(com.obric.aiagent.skill.manager.api.e r4, File r5) {
        if (r5 != null) goto L5;
        String r3 = r4.k();
    L9:
        return db.a(db.f19721a, r3, 0, 2, null);
    L5:
        File r6 = new File(r5, "SKILL.md");
        if (this.f19465c.b(r6) == false) goto L10;
        r3 = this.f19465c.f(r6);
        goto L9
    L10:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.n.f19606a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r11, da r12) {
        com.obric.aiagent.skill.manager.api.aq r0 = r11.g();
        Object r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L6;
        int r1 = com.obric.aiagent.skill.manager.api.al.f19195a.a().c();
    L19:
        String r13 = cv.a(r12, r1);
        if (d.h.b.o.a(r11.a(), r13) == false) goto L65;
        Map<String, com.obric.aiagent.skill.manager.api.e> r2 = this.f19466d.a();
        com.obric.aiagent.skill.manager.api.e r14 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2.get(r11.a()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L64;
        String r15 = cu.f19706a.b(r13);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L25:
        if (r16.hasNext() == false) goto L58;
        Object r4 = r16.next();
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r7 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r5.getValue(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        File r8 = new File(this.f19465c.a(r6), "SKILL.md");
        if (this.f19465c.b(r8) == true) goto L30;
        r8 = null;
    L30:
        boolean r9 = false;
        if (r8 == null) goto L35;
        String r10 = this.f19465c.f(r8);
        if (r10 == null) goto L35;
    L67:
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L43
        ag r18 = (ag) ZeusTransformUtils.preCheckCast(this, ag.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        Object r19 = d.n.f(db.a(db.f19721a, r10, 0, 2, null).a());     // Catch: Throwable -> L43
    L45:
        Throwable r20 = d.n.c(r19);
        if (r20 == null) goto L49;
        this.f.a("Installed Skill package name skipped during identity check: slug=" + r6, r20);
    L49:
        if (d.n.b(r19) == false) goto L51;
        r19 = null;
    L51:
        String r21 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L54;
        String r22 = cu.f19706a.b(r21);
    L55:
        r9 = d.h.b.o.a(r22, r15);
    L56:
        if (r9 == false) goto L25;
        r3 = r4;
        goto L58
    L54:
        r22 = null;
    L43:
        th = move-exception;
        d.n.a r23 = d.n.f38560a;
        r19 = d.n.f(d.o.a(th));
    L35:
        String r24 = r7.k();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L38;
        r10 = r24;
    L39:
        if (r10 != null) goto L67;
    L38:
        r10 = null;
    L58:
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L62;
        return;
    L62:
        throw new cd((String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.aiagent.plugin"), ce.f19648b);
    L64:
        throw new cd(r14.a(), ce.f19647a);
    L65:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.p.f19608a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L8;
    L18:
        r1 = com.obric.aiagent.skill.manager.api.al.f19195a.a().e();
        goto L19
    L8:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L16;
        if (r0 == null) goto L16;
        throw new d.k();
    L16:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.p.f19608a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    }

    static /* synthetic */ void a(ag r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.b(r1, r2);
    }

    private final void b(String r6, String r7) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f19466d.a().entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Object r0 = r5.next();
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r4 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2.getValue(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r3, r7) == false) goto L8;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == false) goto L4;
    L14:
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L18;
        return;
    L18:
        throw new be((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin"));
    L8:
        if (d.h.b.o.a(r4.b(), r6) == false) goto L10;
        r8 = true;
        goto L11
    L13:
        r0 = null;
        goto L14
    }

    private final File g(File r8) {
        File r7 = new File(r8, "SKILL.md");
        Object r2 = null;
        if (r7.isFile() == true) goto L6;
        r7 = null;
    L6:
        if (r7 == null) goto L8;
        return r7;
    L8:
        File[] r9 = r8.listFiles();
        int r10 = 0;
        if (r9 != null) goto L11;
        r9 = new File[0];
    L11:
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r3 = r9.length;
    L12:
        if (r10 >= r3) goto L17;
        File r5 = r9[r10];
        if (r5.isDirectory() == false) goto L16;
        r1.add(r5);
    L16:
        r10 = r10 + 1;
        goto L12
    L17:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r12.add(new File((File) ZeusTransformUtils.preCheckCast(r13.next(), File.class, "com.obric.aiagent.plugin"), "SKILL.md"));
        goto L19
    L21:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r14.hasNext() == false) goto L28;
        Object r15 = r14.next();
        if (((File) ZeusTransformUtils.preCheckCast(r15, File.class, "com.obric.aiagent.plugin")).isFile() == false) goto L23;
        r2 = r15;
    L28:
        return (File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin");
    }

    private final void d(File r12, File r13) {
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r12), Closeable.class, "com.obric.aiagent.plugin");
        ZipFile r14 = (ZipFile) ZeusTransformUtils.preCheckCast(r11, ZipFile.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        String r1 = r13.getCanonicalPath() + File.separator;     // Catch: Throwable -> L35
        Enumeration<? extends ZipEntry> r2 = r14.entries();     // Catch: Throwable -> L35
        d.h.b.o.c(r2, "entries(...)");     // Catch: Throwable -> L35
        Iterator r3 = d.n.m.a(d.a.p.a(r2)).a();     // Catch: Throwable -> L35
    L5:
        if (r3.hasNext() == false) goto L32;
        ZipEntry r4 = (ZipEntry) ZeusTransformUtils.preCheckCast(r3.next(), ZipEntry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        File r5 = new File(r13, r4.getName());     // Catch: Throwable -> L35
        String r6 = r5.getCanonicalPath();     // Catch: Throwable -> L35
        d.h.b.o.a(r6);     // Catch: Throwable -> L35
        if (d.o.o.b(r6, r1, false, 2, null) == false) goto L31;
        if (r4.isDirectory() == true) goto L10;
        File r7 = r5.getParentFile();     // Catch: Throwable -> L35
        if (r7 == null) goto L14;
        r7.mkdirs();     // Catch: Throwable -> L35
    L14:
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r14.getInputStream(r4), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        InputStream r9 = (InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r5), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        FileOutputStream r15 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r10, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        d.h.b.o.a(r9);     // Catch: Throwable -> L20
        d.f.b.a(r9, (OutputStream) ZeusTransformUtils.preCheckCast(r15, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L20
        d.x r16 = d.x.f38692a;     // Catch: Throwable -> L20
        d.f.c.a(r10, null);     // Catch: Throwable -> L25
        d.x r17 = d.x.f38692a;     // Catch: Throwable -> L25
        d.f.c.a(r8, null);     // Catch: Throwable -> L35
        goto L5
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        d.f.c.a(r10, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        d.f.c.a(r8, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L10:
        r5.mkdirs();     // Catch: Throwable -> L35
        goto L5
    L31:
        throw new SecurityException("Zip entry escapes target dir: " + r4.getName());     // Catch: Throwable -> L35
    L32:
        d.x r18 = d.x.f38692a;     // Catch: Throwable -> L35
        d.f.c.a(r11, null);
        return;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        d.f.c.a(r11, th);
        throw th;
    }

    private final void a(File r6, File r7, ZipOutputStream r8) {
        if (d.h.b.o.a(r7.getName(), ".versions") == false) goto L6;
        return;
    L6:
        if (r7.isDirectory() == false) goto L16;
        File[] r9 = r7.listFiles();
        if (r9 != null) goto L10;
        r9 = new File[0];
    L10:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.i.c(r9, (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        File r0 = (File) ZeusTransformUtils.preCheckCast(r10.next(), File.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        a(r6, r0, r8);
        goto L12
    L14:
        return;
    L16:
        if (r7.isFile() == true) goto L18;
        return;
    L18:
        String r5 = d.f.k.g(d.f.k.b(r7, r6));
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
        return;
    L21:
        ZipEntry r11 = new ZipEntry(r5);
        r11.setTime(315532800000L);
        r8.putNextEntry(r11);
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r7), Closeable.class, "com.obric.aiagent.plugin");
        d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r12, FileInputStream.class, "com.obric.aiagent.plugin"), InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r8, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L25
        d.f.c.a(r12, null);
        r8.closeEntry();
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        d.f.c.a(r12, th);
        throw th;
    }

    private final String h(File r12) {
        MessageDigest r11 = MessageDigest.getInstance("SHA-256");
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r12), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r0 = (FileInputStream) ZeusTransformUtils.preCheckCast(r13, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r3 = r0.read(r2);     // Catch: Throwable -> L10
        if (r3 <= 0) goto L7;
        r11.update(r2, 0, r3);     // Catch: Throwable -> L10
        goto L4
    L7:
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L10
        d.f.c.a(r13, null);
        byte[] r4 = r11.digest();
        d.h.b.o.c(r4, "digest(...)");
        return d.a.i.a(r4, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$ag$FRGO01jD0NVjLtd3dNbpGeZUQfA.INSTANCE, 30, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.f.c.a(r13, th);
        throw th;
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        d.h.b.o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }
}
