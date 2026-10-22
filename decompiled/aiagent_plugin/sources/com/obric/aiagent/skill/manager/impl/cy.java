package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: SkillManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.o.k f19712a = null;

    /* JADX INFO: compiled from: SkillManager.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19713a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19714b = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.api.p.values().length];
            r0[com.obric.aiagent.skill.manager.api.p.g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L64:
            r0[com.obric.aiagent.skill.manager.api.p.f19291b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L74:
            r0[com.obric.aiagent.skill.manager.api.p.f19290a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r0[com.obric.aiagent.skill.manager.api.p.f19294e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L48:
            r0[com.obric.aiagent.skill.manager.api.p.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L58:
            r0[com.obric.aiagent.skill.manager.api.p.f19292c.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L68:
            r0[com.obric.aiagent.skill.manager.api.p.f19293d.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L16:
            f19713a = r0;
            int[] r1 = new int[com.obric.aiagent.skill.manager.api.q.values().length];
            r1[com.obric.aiagent.skill.manager.api.q.f19295a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L62:
            r1[com.obric.aiagent.skill.manager.api.q.f19296b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L72:
            r1[com.obric.aiagent.skill.manager.api.q.f19297c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L44:
            r1[com.obric.aiagent.skill.manager.api.q.f19298d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L50:
            r1[com.obric.aiagent.skill.manager.api.q.f19299e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L60:
            r1[com.obric.aiagent.skill.manager.api.q.h.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L70:
            r1[com.obric.aiagent.skill.manager.api.q.i.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L56:
            r1[com.obric.aiagent.skill.manager.api.q.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L66:
            r1[com.obric.aiagent.skill.manager.api.q.f.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L26:
            f19714b = r1;
        }
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.u a(com.obric.aiagent.skill.manager.api.u r2) {
        return b((com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ cm a(com.obric.aiagent.skill.manager.api.o r0, String r1) {
        return c(r0, r1);
    }

    public static final /* synthetic */ String a(File r0) {
        return b(r0);
    }

    public static final /* synthetic */ String a(String r0) {
        return c(r0);
    }

    public static final /* synthetic */ boolean a(com.obric.aiagent.skill.manager.api.e r0) {
        return b(r0);
    }

    public static final /* synthetic */ boolean a(com.obric.aiagent.skill.manager.api.q r0) {
        return f(r0);
    }

    public static final /* synthetic */ cm b(com.obric.aiagent.skill.manager.api.o r0, String r1) {
        return d(r0, r1);
    }

    public static final /* synthetic */ ep b(com.obric.aiagent.skill.manager.api.q r0) {
        return d(r0);
    }

    public static final /* synthetic */ boolean b(String r0) {
        return d(r0);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.p c(com.obric.aiagent.skill.manager.api.q r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$qfwqtcCS9siAW9gM0RjWjwamg-8, reason: not valid java name */
    public static /* synthetic */ CharSequence m281lambda$qfwqtcCS9siAW9gM0RjWjwamg8(byte r0) {
        return a(r0);
    }

    private static final cm<com.obric.aiagent.skill.manager.api.aq.b> c(com.obric.aiagent.skill.manager.api.o r9, String r10) {
        int r0 = a.f19713a[r9.a().ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.b(com.obric.aiagent.skill.manager.api.ar.f19224c, r10), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.f19296b, null, 4, null);
    L8:
        throw new IllegalArgumentException("Install entry '" + r9.a() + "' is not valid for Skill creation.");
    L10:
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.b(com.obric.aiagent.skill.manager.api.ar.f19223b, r10), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.g, null, 4, null);
    }

    private static final cm<com.obric.aiagent.skill.manager.api.aq> d(com.obric.aiagent.skill.manager.api.o r14, String r15) {
        int r0 = a.f19713a[r14.a().ordinal()];
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L23;
        if (r0 == 5) goto L22;
        if (r0 == 6) goto L21;
        if (r0 != 7) goto L14;
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.c(com.obric.aiagent.skill.manager.api.ar.f19224c, com.obric.aiagent.skill.manager.api.n.f19284b, r15), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.f19299e, a(r14));
    L14:
        throw new IllegalArgumentException("Install entry '" + r14.a() + "' is not valid for Skill import.");
    L21:
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.c(com.obric.aiagent.skill.manager.api.ar.f19224c, com.obric.aiagent.skill.manager.api.n.f19285c, r15), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.f19298d, a(r14));
    L22:
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.c(com.obric.aiagent.skill.manager.api.ar.f19223b, com.obric.aiagent.skill.manager.api.n.f19285c, r15), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.i, a(r14));
    L23:
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.c(com.obric.aiagent.skill.manager.api.ar.f19223b, com.obric.aiagent.skill.manager.api.n.f19284b, r15), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.h, null, 4, null);
    L19:
        return new cm((com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aq.a.f19212a, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.q.f19295a, null, 4, null);
    }

    private static final ep d(com.obric.aiagent.skill.manager.api.q r1) {
        switch(a.f19714b[r1.ordinal()]) {
            case 1: goto L15;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            default: goto L5;
        };
    L5:
        throw new d.k();
    L16:
        return ep.g;
    L17:
        return ep.j;
    L18:
        return ep.i;
    L19:
        return ep.h;
    L20:
        return ep.f;
    L21:
        return ep.f19837e;
    L22:
        return ep.f19836d;
    L23:
        return ep.f19835c;
    L15:
        return ep.f19834b;
    }

    private static final com.obric.aiagent.skill.manager.api.p e(com.obric.aiagent.skill.manager.api.q r3) {
        int r0 = a.f19714b[r3.ordinal()];
        if (r0 == 4) goto L13;
        if (r0 == 5) goto L15;
        if (r0 != 7) goto L10;
        return com.obric.aiagent.skill.manager.api.p.f;
    L10:
        throw new IllegalArgumentException("Install method '" + r3 + "' is not valid for package installation.");
    L15:
        return com.obric.aiagent.skill.manager.api.p.f19293d;
    L13:
        return com.obric.aiagent.skill.manager.api.p.f19292c;
    }

    private static final boolean f(com.obric.aiagent.skill.manager.api.q r1) {
        if (r1 != com.obric.aiagent.skill.manager.api.q.f19298d) goto L5;
    L10:
        return true;
    L5:
        if (r1 == com.obric.aiagent.skill.manager.api.q.f19299e) goto L10;
        if (r1 == com.obric.aiagent.skill.manager.api.q.i) goto L10;
        return false;
    }

    private static final String a(com.obric.aiagent.skill.manager.api.o r3) {
        String r4 = r3.b();
        CharSequence r0 = null;
        if (r4 == null) goto L12;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L13;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r6) == true) goto L11;
        r0 = r6;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L13:
        return null;
    L12:
        return null;
    }

    public static final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r3, boolean r4, d.h.a.m<? super String, ? super Boolean, com.obric.aiagent.skill.manager.api.e> r5, d.h.a.m<? super com.obric.aiagent.skill.manager.api.e, ? super Boolean, d.x> r6) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "current");
        d.h.b.o.e(r7, "persist");
        d.h.b.o.e(r8, "report");
        if (r3.l() != r4) goto L5;
        return r3;
    L5:
        com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r7.invoke(r3.a(), Boolean.valueOf(r4)), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        if (r9.l() != r4) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L15;
        r8.invoke(r3, Boolean.valueOf(r4));
        return r9;
    L15:
        throw new IllegalStateException(("Skill enabled state was not persisted: slug=" + r3.a() + ", enabled=" + r4).toString());
    L10:
        r0 = false;
        goto L11
    L17:
        throw new IllegalArgumentException("Skill not found: " + r3.a());
    }

    public static final com.obric.aiagent.skill.manager.api.e a(String r29, String r30, String r31, String r32) {
        d.h.b.o.e(r29, "displayName");
        d.h.b.o.e(r30, "description");
        d.h.b.o.e(r31, "content");
        d.h.b.o.e(r32, "coverUrl");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L21;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L19;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L17;
        if (r29.length() <= com.obric.aiagent.skill.manager.api.al.f19195a.a().c()) goto L11;
    L14:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.p.f19608a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L11:
        if (cu.f19706a.a(r29) == false) goto L14;
        return new com.obric.aiagent.skill.manager.api.e(r29, r29, r30, null, null, r32, null, null, null, 0, new da(r29, r30, r31, r29, null, 16, null).f(), false, false, null, null, null, null, 130008, null);
    L17:
        throw new IllegalArgumentException("SKILL.md content must not be blank.".toString());
    L19:
        throw new IllegalArgumentException("Skill description must not be blank.".toString());
    L21:
        throw new IllegalArgumentException("Skill display name must not be blank.".toString());
    }

    public static final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.d r24) {
        d.h.b.o.e(r24, "<this>");
        File r0 = new File(r24.a(), "SKILL.md");
        if (r0.isFile() == false) goto L7;
        String r1 = d.f.k.a(r0, null, 1, null);
        da r2 = db.a(db.f19721a, r1, 0, 2, null);
        return new com.obric.aiagent.skill.manager.api.e(cv.a(r2, com.obric.aiagent.skill.manager.api.al.f19195a.a().e()), r2.e(), r2.b(), null, null, r24.b(), null, null, null, 0, r1, false, false, null, null, null, null, 130008, null);
    L7:
        throw new IllegalArgumentException("Imported Skill package must contain SKILL.md.".toString());
    }

    public static final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r20, String r21, com.obric.aiagent.skill.manager.api.aq.b r22) {
        d.h.b.o.e(r20, "<this>");
        d.h.b.o.e(r21, "slug");
        d.h.b.o.e(r22, DBHelper.BATTERY_COL_SOURCE);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        return com.obric.aiagent.skill.manager.api.e.a(r20, r21, null, null, null, null, null, (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(r22, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin"), null, null, 0, null, true, true, null, null, null, null, 124862, null);
    L7:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    public static final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r22, com.obric.aiagent.skill.manager.api.aq r23, com.obric.aiagent.skill.manager.api.a r24, com.obric.aiagent.skill.manager.api.e r25) {
        com.obric.aiagent.skill.manager.api.aq r9 = (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.wrapperContextForParams(r23, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r22, "<this>");
        d.h.b.o.e(r9, DBHelper.BATTERY_COL_SOURCE);
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L39;
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L37;
        if (r25 == null) goto L15;
        int r10 = r25.j();
    L16:
        int r12 = r10;
        if (r25 == null) goto L21;
        r3 = r25.l();
    L19:
        boolean r14 = r3;
    L23:
        if (r25 == null) goto L25;
        r1 = r25.m();
    L25:
        boolean r15 = r1;
        Long r2 = null;
        if (r25 == null) goto L28;
        Long r16 = r25.n();
    L29:
        if (r25 == null) goto L31;
        Long r17 = r25.o();
    L32:
        if (r25 == null) goto L35;
        r2 = r25.p();
    L35:
        return com.obric.aiagent.skill.manager.api.e.a(r22, null, null, null, null, null, null, r9, r24, null, r12, null, r14, r15, r16, r17, r2, null, 66879, null);
    L31:
        r17 = null;
        goto L32
    L28:
        r16 = null;
        goto L29
    L21:
        if (d.h.b.o.a(r9, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L19;
        r14 = true;
        goto L23
    L15:
        r10 = hj.f20114a.a();
        goto L16
    L37:
        throw new IllegalArgumentException("Skill source is not supported for package import.".toString());
    L7:
        if (d.h.b.o.a(r9, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L10;
        r0 = false;
        goto L11
    L39:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    public static final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r20, String r21, com.obric.aiagent.skill.manager.api.aq r22) {
        com.obric.aiagent.skill.manager.api.aq r7 = (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r20, "<this>");
        d.h.b.o.e(r21, "slug");
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L9;
        return com.obric.aiagent.skill.manager.api.e.a(r20, r21, null, null, null, null, null, r7, null, null, 0, null, true, true, null, null, null, null, 124862, null);
    L9:
        throw new IllegalArgumentException("Ordinary Skill import source must be imported_gui or imported_chat.".toString());
    L11:
        throw new IllegalArgumentException("Skill slug must not be blank.".toString());
    }

    private static final boolean b(com.obric.aiagent.skill.manager.api.e r2) {
        com.obric.aiagent.skill.manager.api.aq r3 = r2.g();
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L5;
        com.obric.aiagent.skill.manager.api.aq.c r4 = (com.obric.aiagent.skill.manager.api.aq.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.aq.c.class, "com.obric.aiagent.plugin");
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r4.b() != com.obric.aiagent.skill.manager.api.ar.f19224c) goto L13;
        return true;
    L13:
        return false;
    L5:
        r4 = null;
        goto L7
    }

    private static final String c(String r13) {
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r2 = null;
        if (r0 == false) goto L9;
    L60:
        return null;
    L9:
        if (r14.length() > 8192) goto L60;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L52
        URI r3 = new URI(r14);     // Catch: Throwable -> L52
        String r15 = r3.getScheme();     // Catch: Throwable -> L52
        if (r15 == null) goto L16;
        String r16 = r15.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L52
        d.h.b.o.c(r16, "toLowerCase(...)");     // Catch: Throwable -> L52
    L18:
        if (r16 != null) goto L20;
        String r6 = "";
    L21:
        String r17 = r3.getHost();     // Catch: Throwable -> L52
        if (r17 == null) goto L24;
        String r18 = r17.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L52
        d.h.b.o.c(r18, "toLowerCase(...)");     // Catch: Throwable -> L52
    L25:
        if (r18 != null) goto L27;
        String r8 = "";
    L29:
        if (d.h.b.o.a(r6, "https") == true) goto L34;
        if (d.h.b.o.a(r6, "http") == true) goto L34;
        return null;
    L34:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L36;
    L51:
        return null;
    L36:
        if (r3.getUserInfo() != null) goto L51;
        int r9 = r3.getPort();     // Catch: Throwable -> L52
        String r19 = r3.getPath();     // Catch: Throwable -> L52
        if (r19 == null) goto L48;
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (d.o.o.d(r110) == false) goto L44;
        r110 = "/";
    L44:
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (r111 == null) goto L48;
        String r10 = r111;
    L49:
        Object r112 = d.n.f(new URI(r6, null, r8, r9, r10, null, null).toASCIIString());     // Catch: Throwable -> L52
    L55:
        if (d.n.b(r112) == true) goto L59;
        r2 = r112;
    L59:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L48:
        r10 = "/";
        goto L49
    L27:
        r8 = r18;
        goto L29
    L24:
        r18 = null;
        goto L25
    L20:
        r6 = r16;
        goto L21
    L16:
        r16 = null;
    L52:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r112 = d.n.f(d.o.a(th));
        goto L55
    L5:
        r0 = false;
        goto L6
    }

    private static final boolean d(String r3) {
        if (r3 != null) goto L4;
    L7:
        return true;
    L4:
        if (f19712a.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return false;
    }

    private static final String b(File r13) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        InputStream r14 = (InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r13), InputStream.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, BufferedInputStream.class) == false) goto L5;
        BufferedInputStream r15 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r14, BufferedInputStream.class, "com.obric.aiagent.plugin");
    L6:
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.aiagent.plugin");
        BufferedInputStream r4 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r16, BufferedInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L14
    L8:
        int r5 = r4.read(r3);     // Catch: Throwable -> L14
        if (r5 < 0) goto L11;
        r0.update(r3, 0, r5);     // Catch: Throwable -> L14
        goto L8
    L11:
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L14
        d.f.c.a(r16, null);
        byte[] r7 = r0.digest();
        d.h.b.o.c(r7, "digest(...)");
        return d.a.i.a(r7, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$cy$qfwqtcCS9siAW9gM0RjWjwamg8.INSTANCE, 30, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.f.c.a(r16, th);
        throw th;
    L5:
        r15 = new BufferedInputStream(r14, 8192);
        goto L6
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        d.h.b.o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> b(com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.av> r3) {
        com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r4 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L6;
        return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.u.b(((com.obric.aiagent.skill.manager.api.av) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.av.class, "com.obric.aiagent.plugin")).b()), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L9;
        return r4;
    L9:
        throw new d.k();
    }

    static {
        f19712a = new d.o.k("^[0-9a-f]{64}$");
    }
}
