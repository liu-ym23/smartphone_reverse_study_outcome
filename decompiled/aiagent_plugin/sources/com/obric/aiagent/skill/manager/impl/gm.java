package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f20008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final gh f20009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final gc f20010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final gk f20011e;
    private final eh f;
    private final cz g;
    private final d.h.a.b<gj, d.x> h;
    private final d.h.a.b<eg, d.x> i;
    private final d.h.a.a<Long> j;
    private final gd k;
    private final hd l;
    private final el m;
    private final Gson n;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.gm$1, reason: invalid class name */
    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f20012a = null;

        static {
            f20012a = new AnonymousClass1();
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

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20013a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20014b = null;

        static {
            int[] r0 = new int[gi.values().length];
            r0[gi.f19990c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L64:
            r0[gi.f19988a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L74:
            r0[gi.f19989b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L8:
            f20013a = r0;
            int[] r1 = new int[dw.values().length];
            r1[dw.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L68:
            r1[dw.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L78:
            r1[dw.h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L44:
            r1[dw.i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L50:
            r1[dw.f19776a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L60:
            r1[dw.f19777b.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L72:
            r1[dw.f19778c.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L56:
            r1[dw.f19779d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L66:
            r1[dw.f19780e.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L70:
            r1[dw.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L48:
            r1[dw.k.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L62:
            r1[dw.l.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L76:
            r1[dw.m.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L46:
            r1[dw.n.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L52:
            r1[dw.o.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L24:
            f20014b = r1;
        }
    }

    static {
        f20007a = new a(null);
    }

    public static /* synthetic */ d.x lambda$MTjS8FJN46P42pCHLyuFDKdiBS4(eg r0) {
        return a(r0);
    }

    public static /* synthetic */ d.x lambda$QNvjjm8c_h2tTEN6b5g9btzqbpE(gj r0) {
        return b(r0);
    }

    public gm(File r3, gh r4, gc r5, gk r6, eh r7, cz r8, d.h.a.b<? super gj, d.x> r9, d.h.a.b<? super eg, d.x> r10, d.h.a.a<Long> r11, gd r12, hd r13, el r14) {
        gh r15 = (gh) ZeusTransformUtils.wrapperContextForParams(r4, gh.class, "com.obric.aiagent.plugin");
        gc r16 = (gc) ZeusTransformUtils.wrapperContextForParams(r5, gc.class, "com.obric.aiagent.plugin");
        gk r17 = (gk) ZeusTransformUtils.wrapperContextForParams(r6, gk.class, "com.obric.aiagent.plugin");
        eh r18 = (eh) ZeusTransformUtils.wrapperContextForParams(r7, eh.class, "com.obric.aiagent.plugin");
        cz r19 = (cz) ZeusTransformUtils.wrapperContextForParams(r8, cz.class, "com.obric.aiagent.plugin");
        d.h.a.b<gj, d.x> r20 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<eg, d.x> r110 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r111 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        gd r112 = (gd) ZeusTransformUtils.wrapperContextForParams(r12, gd.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "cacheDir");
        d.h.b.o.e(r15, "packageSource");
        d.h.b.o.e(r16, "apiClient");
        d.h.b.o.e(r17, "recordStore");
        d.h.b.o.e(r18, "decisionStore");
        d.h.b.o.e(r19, "signatureVerifier");
        d.h.b.o.e(r20, "onSigningRecordChanged");
        d.h.b.o.e(r110, "onDecisionChanged");
        d.h.b.o.e(r111, "nowMillis");
        d.h.b.o.e(r112, "logger");
        d.h.b.o.e(r13, "trackingReporter");
        d.h.b.o.e(r14, "performanceStateStore");
        this.f20008b = r3;
        this.f20009c = r15;
        this.f20010d = r16;
        this.f20011e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r110;
        this.j = r111;
        this.k = r112;
        this.l = r13;
        this.m = r14;
        Gson r21 = new GsonBuilder().disableHtmlEscaping().create();
        d.h.b.o.c(r21, "create(...)");
        this.n = r21;
    }

    public /* synthetic */ gm(File r17, gh r18, gc r19, gk r20, eh r21, cz r22, d.h.a.b r23, d.h.a.b r24, d.h.a.a r25, gd r26, hd r27, el r28, int r29, d.h.b.h r30) {
        gh r1 = (gh) ZeusTransformUtils.wrapperContextForParams(r18, gh.class, "com.obric.aiagent.plugin");
        gc r3 = (gc) ZeusTransformUtils.wrapperContextForParams(r19, gc.class, "com.obric.aiagent.plugin");
        gk r4 = (gk) ZeusTransformUtils.wrapperContextForParams(r20, gk.class, "com.obric.aiagent.plugin");
        eh r5 = (eh) ZeusTransformUtils.wrapperContextForParams(r21, eh.class, "com.obric.aiagent.plugin");
        cz r6 = (cz) ZeusTransformUtils.wrapperContextForParams(r22, cz.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r25, d.h.a.a.class, "com.obric.aiagent.plugin");
        gd r10 = (gd) ZeusTransformUtils.wrapperContextForParams(r26, gd.class, "com.obric.aiagent.plugin");
        if ((r29 & 64) == 0) goto L6;
        r7 = $$Lambda$gm$QNvjjm8c_h2tTEN6b5g9btzqbpE.INSTANCE;
    L6:
        if ((r29 & 128) == 0) goto L9;
        r8 = $$Lambda$gm$MTjS8FJN46P42pCHLyuFDKdiBS4.INSTANCE;
    L9:
        if ((r29 & 256) == 0) goto L12;
        r9 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f20012a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L12:
        if ((r29 & 512) == 0) goto L14;
        gd r2 = (gd) ZeusTransformUtils.preCheckCast(d.f19715a, gd.class, "com.obric.aiagent.plugin");
    L16:
        if ((r29 & 1024) == 0) goto L18;
        hd r11 = new hd(null, null, null, 7, null);
    L20:
        if ((r29 & 2048) == 0) goto L22;
        el r0 = new el();
    L23:
        this(r17, r1, r3, r4, r5, r6, r7, r8, r9, r2, r11, r0);
        return;
    L22:
        r0 = r28;
        goto L23
    L18:
        r11 = r27;
        goto L20
    L14:
        r2 = r10;
        goto L16
    }

    private static final d.x b(gj r1) {
        d.h.b.o.e(r1, "it");
        return d.x.f38692a;
    }

    private static final d.x a(eg r1) {
        d.h.b.o.e(r1, "it");
        return d.x.f38692a;
    }

    public final Object a(com.obric.aiagent.skill.manager.api.e r3, aw r4, d.c.d<? super com.obric.aiagent.skill.manager.api.an> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r3, r4, true);
    }

    private final com.obric.aiagent.skill.manager.api.an a(com.obric.aiagent.skill.manager.api.e r10, aw r11, boolean r12) {
        gl r1 = a(r10);     // Catch: Exception -> L32 CancellationException -> L35
        if (d.h.b.o.a(r1, gl.e.f20003a) == false) goto L7;
        return a(this, r10, com.obric.aiagent.skill.manager.api.am.f19201a, null, 4, null);
    L7:
        if (d.h.b.o.a(r1, gl.f.f20004a) == false) goto L10;
        return gn.a(b(r10, r11, r12), r10, com.obric.aiagent.skill.manager.api.am.f19205e);
    L10:
        if (ZeusTransformUtils.instanceOf(r1, gl.d.class) == false) goto L13;
        return gn.a(a(r10, ((gl.d) ZeusTransformUtils.preCheckCast(r1, gl.d.class, "com.obric.aiagent.plugin")).a(), r11, r12), r10, com.obric.aiagent.skill.manager.api.am.f19203c);
    L13:
        if (ZeusTransformUtils.instanceOf(r1, gl.c.class) == false) goto L16;
        return gn.a(a(r10, ((gl.c) ZeusTransformUtils.preCheckCast(r1, gl.c.class, "com.obric.aiagent.plugin")).a(), ((gl.c) ZeusTransformUtils.preCheckCast(r1, gl.c.class, "com.obric.aiagent.plugin")).b(), r11, r12), r10, com.obric.aiagent.skill.manager.api.am.f19204d);
    L16:
        if (ZeusTransformUtils.instanceOf(r1, gl.g.class) == false) goto L25;
        b(r10, ((gl.g) ZeusTransformUtils.preCheckCast(r1, gl.g.class, "com.obric.aiagent.plugin")).a(), r12);     // Catch: Exception -> L19 CancellationException -> L22
    L44:
        return gn.a(b(r10, ((gl.g) ZeusTransformUtils.preCheckCast(r1, gl.g.class, "com.obric.aiagent.plugin")).b(), r11, r12), r10, com.obric.aiagent.skill.manager.api.am.f19202b);
    L22:
        e = move-exception;
        throw e;     // Catch: Exception -> L32 CancellationException -> L35
    L19:
        e = move-exception;
        this.k.a("Skill signing manifest verification failed before decision: slug=" + r10.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L32 CancellationException -> L35
        goto L44
    L25:
        if (ZeusTransformUtils.instanceOf(r1, gl.b.class) == false) goto L28;
        return gn.a(b(r10, ((gl.b) ZeusTransformUtils.preCheckCast(r1, gl.b.class, "com.obric.aiagent.plugin")).a(), r11, r12), r10, com.obric.aiagent.skill.manager.api.am.f19202b);
    L28:
        if (ZeusTransformUtils.instanceOf(r1, gl.a.class) == false) goto L31;
        return a(r10, com.obric.aiagent.skill.manager.api.am.g, ((gl.a) ZeusTransformUtils.preCheckCast(r1, gl.a.class, "com.obric.aiagent.plugin")).a());
    L31:
        throw new d.k();     // Catch: Exception -> L32 CancellationException -> L35
    L35:
        e = move-exception;
        throw e;
    L32:
        e = move-exception;
        String r13 = a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        this.k.a("Skill signature refresh failed: slug=" + r10.a() + ", error=" + r13, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return a(r10, com.obric.aiagent.skill.manager.api.am.g, r13);
    }

    public final gl a(com.obric.aiagent.skill.manager.api.e r5) {
        d.h.b.o.e(r5, "skill");
        if (ZeusTransformUtils.instanceOf(r5.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L7;
        return (gl) ZeusTransformUtils.preCheckCast(gl.e.f20003a, gl.class, "com.obric.aiagent.plugin");
    L7:
        if (az.b(r5) == false) goto L9;
        int r0 = hj.f20114a.b(r5.j());
        gj r4 = this.f20011e.a(r5.a(), r0);
        if (r4 == null) goto L13;
        gp r6 = go.a(r4);
        if (r6 == null) goto L17;
        gi r1 = en.a(r6);
        int r2 = b.f20013a[r1.ordinal()];
        if (r2 == 1) goto L61;
        if (r2 != 2) goto L23;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L59;
        return (gl) ZeusTransformUtils.preCheckCast(gl.f.f20004a, gl.class, "com.obric.aiagent.plugin");
    L59:
        return (gl) ZeusTransformUtils.preCheckCast(new gl.d(r7), gl.class, "com.obric.aiagent.plugin");
    L23:
        if (r2 != 3) goto L54;
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L27;
        String r8 = r6.c();
        if (r8 != null) goto L31;
        r8 = "";
    L31:
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L36;
        return (gl) ZeusTransformUtils.preCheckCast(new gl.b(r3), gl.class, "com.obric.aiagent.plugin");
    L36:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.e(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L40;
        return (gl) ZeusTransformUtils.preCheckCast(new gl.c(r9, r3), gl.class, "com.obric.aiagent.plugin");
    L40:
        if (go.d(r4) == true) goto L44;
        return (gl) ZeusTransformUtils.preCheckCast(new gl.c(r9, r3), gl.class, "com.obric.aiagent.plugin");
    L44:
        if (go.b(r4) != null) goto L48;
        return (gl) ZeusTransformUtils.preCheckCast(new gl.a("FETCHED_MANIFEST_INVALID"), gl.class, "com.obric.aiagent.plugin");
    L48:
        if (en.a(r4) == true) goto L52;
        return (gl) ZeusTransformUtils.preCheckCast(new gl.g(r9, r3), gl.class, "com.obric.aiagent.plugin");
    L52:
        return (gl) ZeusTransformUtils.preCheckCast(new gl.b(r3), gl.class, "com.obric.aiagent.plugin");
    L27:
        return (gl) ZeusTransformUtils.preCheckCast(new gl.a("COMPLETED_TASK_MISSING_TASK_ID"), gl.class, "com.obric.aiagent.plugin");
    L54:
        throw new d.k();
    L61:
        return (gl) ZeusTransformUtils.preCheckCast(gl.f.f20004a, gl.class, "com.obric.aiagent.plugin");
    L17:
        return (gl) ZeusTransformUtils.preCheckCast(gl.f.f20004a, gl.class, "com.obric.aiagent.plugin");
    L13:
        return (gl) ZeusTransformUtils.preCheckCast(gl.f.f20004a, gl.class, "com.obric.aiagent.plugin");
    L9:
        return (gl) ZeusTransformUtils.preCheckCast(new gl.a("UNSUPPORTED_LOCAL_SOURCE"), gl.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void a(gm r0, com.obric.aiagent.skill.manager.api.e r1, ep r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r9, ep r10, String r11) {
        d.h.b.o.e(r9, "skill");
        d.h.b.o.e(r10, "triggerType");
        int r4 = hj.f20114a.b(r9.j());
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(this.j.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        gj r12 = this.f20011e.a(r9.a(), r4, r10.a(), r6);
        this.f.a(r9.a());
        this.m.a(r12, r11);
        this.h.invoke(r12);
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "slug");
        this.m.a(r2);
    }

    public final void b(String r2) {
        d.h.b.o.e(r2, "slug");
        this.f.a(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    private final s b(com.obric.aiagent.skill.manager.api.e r31, aw r32, boolean r33) {
        gm r1 = this;
        int r13 = hj.f20114a.b(r31.j());
        gj r2 = r1.f20011e.a(r31.a(), r13);
        r r16 = 0;
        String r17 = null;
        if (r2 != null) goto L5;
    L17:
        gk r4 = r1.f20011e;
        String r5 = r31.a();
        if (r2 == null) goto L21;
        String r3 = r2.h();
        if (r3 == null) goto L21;
    L22:
        gj r6 = r4.a(r5, r13, r3, ((Number) ZeusTransformUtils.preCheckCast(r1.j.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue());
        r1.h.invoke(r6);
    L23:
        gj r10 = r6;
        ei r7 = r1.m.a(r10, dy.f19790e);
        String r14 = "com.obric.aiagent.plugin";
        ea r19 = new ea(dy.f19790e, r1.l, r7.a().f(), r7.b(), r7.a().g(), 0, r33, 32, null);
        LinkedHashMap r12 = d.a.ao.d(new d.m[]{d.s.a("trigger_type", ep.f19833a.a(r10.h()).a())});
        String r8 = "package_export";
        long r9 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L123 Exception -> L125 CancellationException -> L130
        r r20 = b(r31);     // Catch: CancellationException -> L121 Throwable -> L123 Exception -> L125
    L159:
        ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14)).put("export_duration_ms", Long.valueOf(eb.a(r9)));     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14)).put("package_bytes", Long.valueOf(r20.a().b()));     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        r8 = "upload_token";
        long r11 = SystemClock.elapsedRealtime();     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        gr r15 = r1.f20010d.a(r31.a() + '_' + r13 + ".zip", r20.a().b());     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14)).put("token_duration_ms", Long.valueOf(eb.a(r11)));     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        Object r18 = r15.a();     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        if (r18 == null) goto L109;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, r14))) == false) goto L31;
        String r21 = r18;
    L32:
        if (r21 == 0) goto L109;
        String r22 = r15.c();     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, r14))) == true) goto L37;
        r22 = null;
    L37:
        if (r22 == null) goto L107;
        long r23 = SystemClock.elapsedRealtime();     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        r1.f20010d.b(r21, r20.a().a());     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14)).put("upload_duration_ms", Long.valueOf(eb.a(r23)));     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        r8 = "task_create";
        long r24 = SystemClock.elapsedRealtime();     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        gp r110 = r1.f20010d.a(r22, d.a.ao.a(new d.m[]{d.s.a("metadataBase64", r20.c().a()), d.s.a("metadataSha256", r20.c().b()), d.s.a("localSlug", r31.a()), d.s.a("localVersionId", String.valueOf(r13)), d.s.a("packageSha256", r20.b())}));     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14)).put("task_create_duration_ms", Long.valueOf(eb.a(r24)));     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
        String r25 = r110.a();     // Catch: Exception -> L115 CancellationException -> L118 Throwable -> L135
    L40:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, r14))) == true) goto L43;
        r25 = null;
    L43:
        if (r25 != null) goto L150;
        gj r111 = r10;
    L54:
        String r112 = "task_persist";
        long r26 = SystemClock.elapsedRealtime();     // Catch: Exception -> L98 CancellationException -> L102 Throwable -> L135
    L161:
        r1.a(r31, r110, r20.b(), r111);     // Catch: Exception -> L94 CancellationException -> L96 Throwable -> L135
        ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14)).put("persist_duration_ms", Long.valueOf(eb.a(r26)));     // Catch: Exception -> L94 CancellationException -> L96 Throwable -> L135
        r1.m.b(r111, r110.a());     // Catch: Exception -> L94 CancellationException -> L96 Throwable -> L135
        r12 = r12;
        gj r27 = r111;
        ea.a(r19, dz.f19791a, r31, null, null, null, r110.a(), null, null, null, null, (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14), 988, null);     // Catch: Exception -> L87 CancellationException -> L90 Throwable -> L135
        r1 = this;
        r1.a(r31, r27, r110, r33);     // Catch: Exception -> L83 CancellationException -> L85 Throwable -> L135
        gd r28 = r1.k;     // Catch: Exception -> L83 CancellationException -> L85 Throwable -> L135
        StringBuilder r29 = new StringBuilder().append("Skill signing task submitted: slug=").append(r31.a()).append(", version=").append(r13).append(", taskId=");     // Catch: Exception -> L83 CancellationException -> L85 Throwable -> L135
        r14 = r14;
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r110.a(), CharSequence.class, r14);     // Catch: Exception -> L79 CancellationException -> L81 Throwable -> L135
        CharSequence r113 = "-";
        if (d.o.o.d(r30) == false) goto L67;
        r30 = "-";
    L67:
        StringBuilder r34 = r29.append((String) ZeusTransformUtils.preCheckCast(r30, String.class, r14)).append(", status=");     // Catch: Exception -> L79 CancellationException -> L81 Throwable -> L135
        CharSequence r35 = (CharSequence) ZeusTransformUtils.preCheckCast(r110.b(), CharSequence.class, r14);     // Catch: Exception -> L79 CancellationException -> L81 Throwable -> L135
        if (d.o.o.d(r35) == true) goto L71;
        r113 = r35;
    L71:
        r28.a(r34.append((String) ZeusTransformUtils.preCheckCast(r113, String.class, r14)).toString());     // Catch: Exception -> L79 CancellationException -> L81 Throwable -> L135
        s r36 = r1.a(r31, r110, r32, r33);     // Catch: Exception -> L79 CancellationException -> L81 Throwable -> L135
        if (r20 == null) goto L78;
        dp r37 = r20.a();
        if (r37 == null) goto L78;
        File r38 = r37.a();
        if (r38 == null) goto L78;
        r38.delete();
    L78:
        return r36;
    L81:
        e = e;
    L93:
        CancellationException r114 = e;
    L114:
        r12 = r12;
    L133:
        ea.a(r19, dz.f19793c, r31, null, null, null, null, dw.n, r112, false, false, (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14), 60, null);     // Catch: Throwable -> L135
        throw r114;     // Catch: Throwable -> L135
    L79:
        e = e;
    L101:
        Exception r115 = e;
        gm r39 = r1;
    L128:
        dw r40 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(r115, Throwable.class, r14));     // Catch: Throwable -> L135
        ea.a(r19, dz.f19792b, r31, null, null, null, null, r40, r112, Boolean.valueOf(r39.a(r40)), false, (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, r14), 60, null);     // Catch: Throwable -> L135
        throw r115;     // Catch: Throwable -> L135
    L85:
        e = e;
    L92:
        r14 = r14;
    L83:
        e = e;
    L89:
        r14 = r14;
        goto L101
    L90:
        e = e;
    L87:
        e = e;
        r1 = this;
        goto L89
    L96:
        e = e;
    L104:
        r114 = e;
    L120:
        r12 = r12;
    L94:
        e = e;
    L100:
        r12 = r12;
        r14 = r14;
    L102:
        e = e;
    L98:
        e = e;
        goto L100
    L150:
        hd r41 = r1.l;     // Catch: Exception -> L49 CancellationException -> L51 Throwable -> L135
        ep.a r42 = ep.f19833a;     // Catch: Exception -> L49 CancellationException -> L51 Throwable -> L135
        r111 = r10;
        if (r111 == null) goto L47;
        r17 = r111.h();     // Catch: Exception -> L49 CancellationException -> L51 Throwable -> L135
    L47:
        r41.a(new eo(r25, r42.a(r17), r31.a(), r31.b()));     // Catch: Exception -> L49 CancellationException -> L51 Throwable -> L135
    L51:
        e = move-exception;
        r114 = e;
        r112 = "task_create";
        r12 = r12;
        r14 = r14;
    L49:
        e = move-exception;
        r115 = e;
        r39 = r1;
        r112 = "task_create";
        r12 = r12;
        r14 = r14;
        goto L128
    L107:
        throw new IllegalStateException("Skill signing object_key is empty.");     // Catch: Exception -> L110 CancellationException -> L112 Throwable -> L135
    L31:
        r21 = 0;
    L109:
        throw new IllegalStateException("Skill signing upload_url is empty.");     // Catch: Exception -> L110 CancellationException -> L112 Throwable -> L135
    L112:
        e = move-exception;
        r114 = e;
        r112 = "upload_token";
    L110:
        e = e;
    L117:
        r115 = e;
        Object r43 = r18;
    L127:
        r112 = r8;
        r39 = r43;
    L118:
        e = move-exception;
        r114 = e;
        r112 = r8;
    L115:
        e = e;
        r18 = r1;
    L121:
        e = move-exception;
        r114 = e;
    L132:
        r112 = "package_export";
    L135:
        th = move-exception;
        Throwable r44 = th;
        r16 = 32;
    L137:
        if (r16 == 0) goto L163;
        dp r45 = r16.a();
        if (r45 == null) goto L164;
        File r46 = r45.a();
        if (r46 == null) goto L165;
        r46.delete();
        throw r44;
    L165:
        throw r44;
    L164:
        throw r44;
    L163:
        throw r44;
    L130:
        e = move-exception;
        r114 = e;
    L125:
        e = move-exception;
        r43 = r1;
        r115 = e;
    L123:
        th = move-exception;
        r44 = th;
    L21:
        r3 = ep.l.a();
        goto L22
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.d(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
    L11:
        boolean r47 = false;
    L12:
        if (r47 == false) goto L14;
        r6 = r2;
    L15:
        if (r6 == null) goto L17;
    L14:
        r6 = null;
        goto L15
    L7:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.e(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.f(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        r47 = true;
        goto L12
    }

    private final s a(com.obric.aiagent.skill.manager.api.e r31, String r32, aw r33, boolean r34) {
        gj r9 = this.f20011e.a(r31.a(), hj.f20114a.b(r31.j()));
        if (r9 == null) goto L76;
        ei r3 = this.m.a(r9, dy.f);
        long r4 = SystemClock.elapsedRealtime();
        gp r0 = this.f20010d.d(r32);     // Catch: Exception -> L65
        long r6 = eb.a(r4);
        long r16 = SystemClock.elapsedRealtime();
        a(r31, r0, r9.f(), r9);     // Catch: Exception -> L55
        int r5 = b.f20013a[en.a(r0).ordinal()];
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L12;
        ej r14 = this.m.b(r9, r32);
        ej r7 = this.m.a(r9, r32, r6, com.obric.aiagent.skill.manager.api.al.f19195a.a().K());
        if (r14.m() == false) goto L19;
    L27:
        gp r22 = r0;
        String r29 = "com.obric.aiagent.plugin";
    L50:
        gd r1 = this.k;
        StringBuilder r2 = new StringBuilder().append("Skill signing task polled: slug=").append(r31.a()).append(", taskId=").append(r32).append(", status=");
        String r10 = r29;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, r10);
        if (d.o.o.d(r8) == false) goto L53;
        r8 = "-";
    L53:
        r1.a(r2.append((String) ZeusTransformUtils.preCheckCast(r8, String.class, r10)).toString());
        return a(r31, r22, r33, r34);
    L19:
        if (r7.m() == false) goto L27;
        ei r11 = this.m.a(r9, dy.g);
        if (r34 == false) goto L27;
        hd r12 = this.l;
        dy r13 = dy.g;
        dz r15 = dz.f;
        long r23 = ek.b(r7);
        String r24 = r7.f();
        int r25 = r11.b();
        String r26 = r31.a();
        Integer r27 = Integer.valueOf(r31.j());
        com.obric.aiagent.skill.manager.api.aq r17 = r31.g();
        if (r17 == null) goto L25;
        String r28 = r17.a();
    L26:
        r22 = r0;
        r29 = "com.obric.aiagent.plugin";
        r12.a(new dx(r13, r15, r23, r24, r25, r26, r27, r28, r32, r7.g(), dw.m, null, true, true, d.a.ao.a(d.a.ao.a(ek.a(r7), d.s.a("statistical_only", true)), d.s.a("business_result", "processing")), 2048, null));
        goto L50
    L25:
        r28 = null;
        goto L26
    L12:
        if (r5 == 3) goto L13;
        throw new d.k();
    L13:
        r22 = r0;
        r29 = "com.obric.aiagent.plugin";
        ej r18 = this.m.b(r9, r32);
        ei r19 = this.m.a(r9, dy.g);
        if (en.a(r22) != gi.f19990c) goto L31;
        boolean r110 = true;
    L32:
        if (r34 == false) goto L50;
        hd r111 = this.l;
        dy r20 = dy.g;
        if (r110 == false) goto L36;
        dz r21 = dz.f19792b;
    L37:
        long r30 = ek.b(r18);
        String r35 = r18.f();
        int r112 = r19.b();
        String r113 = r31.a();
        Integer r210 = Integer.valueOf(r31.j());
        com.obric.aiagent.skill.manager.api.aq r36 = r31.g();
        if (r36 == null) goto L40;
        String r211 = r36.a();
    L41:
        String r212 = r18.g();
        if (r110 == false) goto L44;
        dw r114 = dw.o;
    L45:
        Boolean r213 = Boolean.valueOf(r110);
        Map<String, Object> r37 = ek.a(r18);
        d.m[] r38 = new d.m[2];
        if (r110 == false) goto L48;
        String r39 = "failed";
    L49:
        r38[0] = d.s.a("business_result", r39);
        r38[1] = d.s.a("result_source", "get_task");
        r111.a(new dx(r20, r21, r30, r35, r112, r113, r210, r211, r32, r212, r114, null, r213, false, d.a.ao.a(r37, d.a.ao.a(r38)), 2048, null));
        goto L50
    L48:
        r39 = "completed";
        goto L49
    L44:
        r114 = null;
        goto L45
    L40:
        r211 = null;
        goto L41
    L36:
        r21 = dz.f19791a;
        goto L37
    L31:
        r110 = false;
    L55:
        e = move-exception;
        long r214 = eb.a(r16);
        if (r34 == false) goto L64;
        hd r115 = this.l;
        dy r215 = dy.f;
        dz r216 = dz.f19792b;
        long r40 = eb.a(r4);
        String r217 = r3.a().f();
        int r218 = r3.b();
        String r219 = r31.a();
        Integer r220 = Integer.valueOf(r31.j());
        com.obric.aiagent.skill.manager.api.aq r41 = r31.g();
        if (r41 == null) goto L61;
        String r116 = r41.a();
    L62:
        r115.a(new dx(r215, r216, r40, r217, r218, r219, r220, r116, r32, r3.a().g(), eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "task_persist", true, true, d.a.ao.a(ek.a(r3.a()), d.a.ao.a(new d.m[]{d.s.a("task_query_duration_ms", Long.valueOf(r6)), d.s.a("task_persist_duration_ms", Long.valueOf(r214))}))));
        throw e;
    L61:
        r116 = null;
        goto L62
    L64:
        throw e;
    L65:
        e = move-exception;
        long r42 = eb.a(r4);
        ej r43 = this.m.a(r9, r32, r42);
        if (r34 == false) goto L74;
        hd r117 = this.l;
        dy r44 = dy.f;
        dz r45 = dz.f19792b;
        String r221 = r43.f();
        int r222 = r3.b();
        String r223 = r31.a();
        Integer r224 = Integer.valueOf(r31.j());
        com.obric.aiagent.skill.manager.api.aq r46 = r31.g();
        if (r46 == null) goto L71;
        String r118 = r46.a();
    L72:
        r117.a(new dx(r44, r45, r42, r221, r222, r223, r224, r118, r32, r43.g(), eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "task_query", true, true, ek.a(r43)));
        throw e;
    L71:
        r118 = null;
        goto L72
    L74:
        throw e;
    L76:
        throw new IllegalStateException("Signing record disappeared before task poll.");
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r29, String r30, boolean r31) {
        gj r7 = this.f20011e.a(r29.a(), hj.f20114a.b(r29.j()));
        if (r7 == null) goto L38;
        ei r1 = this.m.a(r7, dy.h);
        ea r26 = new ea(dy.h, this.l, r1.a().f(), r1.b(), r1.a().g(), 0, r31, 32, null);
        String r2 = "manifest_request";
        ge r3 = this.f20010d.e(r30);     // Catch: Exception -> L29
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.d(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        if (d.o.o.d(r4) == true) goto L40;
    L11:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        r2 = "manifest_persist";
        d.h.b.o.a(r6);     // Catch: Exception -> L29
        gj r10 = r7;
        a(gj.a(r10, null, 0, 0, null, r6, null, "", null, 0, ((Number) ZeusTransformUtils.preCheckCast(this.j.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), BDNetworkSpeedTest.KeyIsEnableIntelligentSpeedTest, null));     // Catch: Exception -> L29
        JsonElement r5 = r3.b();     // Catch: Exception -> L26
        if (r5 == null) goto L23;
        dz r11 = dz.f19791a;     // Catch: Exception -> L26
        gp r8 = go.a(r7);     // Catch: Exception -> L26
        if (r8 == null) goto L17;
        String r16 = r8.a();     // Catch: Exception -> L26
    L18:
        ea.a(r26, r11, r29, null, null, null, r16, null, null, null, null, null, 2012, null);     // Catch: Exception -> L26
        a(r29, r30, r5, r3.c(), r6, r31);     // Catch: Exception -> L24
        this.k.a("Skill signing manifest fetched: slug=" + r29.a() + ", manifestId=" + r30);     // Catch: Exception -> L24
        return;
    L17:
        r16 = null;
        goto L18
    L23:
        throw new IllegalStateException("Signing manifest response is empty.");     // Catch: Exception -> L24
    L24:
        e = e;
    L28:
        String r18 = "manifest_parse";
    L31:
        dz r12 = dz.f19792b;
        gp r9 = go.a(r10);
        if (r9 == null) goto L34;
        String r17 = r9.a();
    L35:
        ea.a(r26, r12, r29, null, null, null, r17, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), r18, true, false, null, DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, null);
        throw e;
    L34:
        r17 = null;
    L26:
        e = e;
        r10 = r7;
        goto L28
    L40:
        r4 = this.n.toJson(r3);     // Catch: Exception -> L9
    L9:
        e = e;
        r18 = "manifest_request";
        r10 = r7;
    L29:
        e = e;
        r10 = r7;
        r18 = r2;
        goto L31
    L38:
        throw new IllegalStateException("Signing record disappeared before manifest fetch.");
    }

    private final s a(com.obric.aiagent.skill.manager.api.e r4, String r5, String r6, aw r7, boolean r8) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        ((gm) ZeusTransformUtils.preCheckCast(this, gm.class, "com.obric.aiagent.plugin")).a(r4, r5, r8);     // Catch: Throwable -> L4
        Object r9 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r10 = d.n.c(r9);
        if (r10 == null) goto L10;
        this.k.a("Skill signing manifest unavailable before decision: slug=" + r4.a(), r10);
    L10:
        return b(r4, r6, r7, r8);
    L4:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L6
    }

    private final void b(com.obric.aiagent.skill.manager.api.e r10, String r11, boolean r12) {
        int r0 = hj.f20114a.b(r10.j());
        gj r1 = this.f20011e.a(r10.a(), r0);
        if (r1 != null) goto L6;
        return;
    L6:
        if (en.a(r1) == false) goto L8;
        return;
    L8:
        gf r2 = go.c(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        a(r10, r11, r2.a(), r2.b(), r1.e(), r12);
    }

    private final s a(com.obric.aiagent.skill.manager.api.e r9, gp r10, aw r11, boolean r12) {
        String r3 = null;
        if (en.a(r10) == gi.f19989b) goto L5;
        return null;
    L5:
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        String r13 = r10.c();
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r5 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L56;
        gj r2 = this.f20011e.a(r9.a(), hj.f20114a.b(r9.j()));
        if (r2 == null) goto L17;
        r3 = r2.e();
    L17:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == true) goto L57;
        if (r2 != null) goto L27;
    L29:
        boolean r7 = false;
    L30:
        if (r7 == false) goto L57;
        if (go.b(r2) != null) goto L35;
        this.k.a("Fetched Skill signing manifest is invalid: slug=" + r9.a());
        goto L56
    L35:
        if (r2 != null) goto L37;
    L39:
        r5 = false;
    L40:
        if (r5 == false) goto L56;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L43
        ((gm) ZeusTransformUtils.preCheckCast(this, gm.class, "com.obric.aiagent.plugin")).b(r9, r14, r12);     // Catch: Throwable -> L43
        Object r15 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L43
    L45:
        Throwable r16 = d.n.c(r15);
        if (r16 == null) goto L56;
        this.k.a("Skill signing manifest verification failed before decision: slug=" + r9.a(), r16);
    L43:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
        goto L45
    L37:
        if (en.a(r2) == true) goto L39;
    L27:
        if (go.d(r2) != true) goto L29;
        r7 = true;
    L57:
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L50
        ((gm) ZeusTransformUtils.preCheckCast(this, gm.class, "com.obric.aiagent.plugin")).a(r9, r14, r12);     // Catch: Throwable -> L50
        Object r18 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L50
    L52:
        Throwable r19 = d.n.c(r18);
        if (r19 == null) goto L56;
        this.k.a("Skill signing manifest unavailable before decision: slug=" + r9.a(), r19);
    L50:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
        goto L52
    L20:
        if (d.o.o.d(r4) == true) goto L23;
        r6 = false;
    L56:
        return b(r9, r1, r11, r12);
    L8:
        return (s) ZeusTransformUtils.preCheckCast(new s.a("DECISION_TASK_ID_MISSING"), s.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2 */
    private final s b(com.obric.aiagent.skill.manager.api.e r36, String r37, aw r38, boolean r39) {
        int r7 = hj.f20114a.b(r36.j());
        gj r0 = this.f20011e.a(r36.a(), r7);
        if (r0 == null) goto L5;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L9;
        eg r17 = this.f.a(r36.a(), r7, r15);
        ei r4 = this.m.a(r0, dy.j);
        ?? r27 = 32;
        ea r29 = new ea(dy.j, this.l, r4.a().f(), r4.b(), r4.a().g(), 0, r39, 32, null);
        d.m[] r5 = new d.m[3];
        r5[0] = d.s.a("refresh_source", r38.a());
        String r6 = OProtocolTextEffectTextView.EffectNameNone;
        if (r17 == null) goto L18;
        com.obric.aiagent.skill.manager.api.ak r8 = r17.g();
        if (r8 == null) goto L18;
        SkillSecurityDecisionAction r9 = r8.a();
        if (r9 == null) goto L18;
        String r10 = r9.getRawValue();
        if (r10 == null) goto L18;
    L19:
        r5[1] = d.s.a("previous_action", r10);
        r5[2] = d.s.a("trigger_type", ep.f19833a.a(r0.h()).a());
        LinkedHashMap r13 = d.a.ao.d(r5);
        ef r1 = this.f20010d.f(r15);     // Catch: Exception -> L84
        SkillSecurityDecisionAction r14 = SkillSecurityDecisionAction.Companion.a(r1.d());     // Catch: Exception -> L84
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L84
        d.m[] r12 = new d.m[3];     // Catch: Exception -> L84
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L84
        if (d.o.o.d(r16) == false) goto L23;
        r16 = OProtocolTextEffectTextView.EffectNameNone;
    L23:
        r12[0] = d.s.a("scan_status", r16);     // Catch: Exception -> L84
        if (r14 == null) goto L29;
        String r18 = r14.getRawValue();     // Catch: Exception -> L84
        if (r18 == null) goto L29;
        r6 = r18;
    L29:
        r12[1] = d.s.a("decision_action", r6);     // Catch: Exception -> L84
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1.a(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L32;
        boolean r19 = true;
    L33:
        r12[2] = d.s.a("scan_id_present", Boolean.valueOf(r19));     // Catch: Exception -> L84
        Map r110 = d.a.ao.a(r11, d.a.ao.a(r12));     // Catch: Exception -> L84
        if (r14 != null) goto L37;
    L77:
        ea.a(r29, dz.f19792b, r36, null, null, null, r15, dw.f19779d, "decision_parse", false, false, d.a.ao.a(r110, d.s.a("decision_changed", false)), 28, null);     // Catch: Exception -> L82
        gd r20 = this.k;     // Catch: Exception -> L82
        StringBuilder r21 = new StringBuilder().append("Skill scan decision unresolved: slug=").append(r36.a()).append(", status=");     // Catch: Exception -> L82
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L82
        if (d.o.o.d(r2) == false) goto L80;
        r2 = "-";
    L80:
        r20.a(r21.append((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).toString());     // Catch: Exception -> L82
        return (s) ZeusTransformUtils.preCheckCast(new s.a("DECISION_UNRESOLVED"), s.class, "com.obric.aiagent.plugin");
    L37:
        if (ZeusTransformUtils.instanceOf(r14, SkillSecurityDecisionAction.Unknown.class) == true) goto L77;
        eg r111 = new eg(0, r36.a(), r7, r15, r1.a(), r1.b(), r14.getRawValue(), r1.c(), ((Number) ZeusTransformUtils.preCheckCast(this.j.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), 1, null);     // Catch: Exception -> L82
        if (this.f.a(r111) == true) goto L44;
        ea.a(r29, dz.f19792b, r36, null, null, null, r15, dw.i, "decision_persist", true, false, d.a.ao.a(r110, d.s.a("decision_changed", false)), 28, null);     // Catch: Exception -> L82
        return (s) ZeusTransformUtils.preCheckCast(new s.a("DECISION_PERSIST_FAILED"), s.class, "com.obric.aiagent.plugin");
    L44:
        this.i.invoke(r111);     // Catch: Exception -> L82
        String r22 = null;
        if (r17 == null) goto L47;
        String r23 = r17.e();     // Catch: Exception -> L82
    L49:
        if (d.h.b.o.a(r23, r111.e()) == false) goto L62;
        if (r17 == null) goto L52;
        Integer r24 = r17.f();     // Catch: Exception -> L82
    L54:
        if (d.h.b.o.a(r24, r111.f()) == false) goto L62;
        if (r17 == null) goto L57;
        String r25 = r17.d();     // Catch: Exception -> L82
    L59:
        if (d.h.b.o.a(r25, r111.d()) == false) goto L62;
        boolean r26 = false;
    L63:
        boolean r28 = ZeusTransformUtils.instanceOf(r14, SkillSecurityDecisionAction.Block.class);     // Catch: Exception -> L82
        if (r28 == false) goto L66;
        dz r30 = dz.f19795e;     // Catch: Exception -> L82
    L67:
        dz r31 = r30;
        if (r28 == false) goto L70;
        dw r112 = dw.l;     // Catch: Exception -> L82
    L71:
        if (r28 == false) goto L73;
        r22 = "security_policy";
    L73:
        ea.a(r29, r31, r36, null, null, null, r15, r112, r22, false, false, d.a.ao.a(r110, d.s.a("decision_changed", Boolean.valueOf(r26))), 28, null);     // Catch: Exception -> L82
        gd r32 = this.k;     // Catch: Exception -> L82
        StringBuilder r33 = new StringBuilder().append("Skill scan decision refreshed: slug=").append(r36.a()).append(", status=");     // Catch: Exception -> L82
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L82
        if (d.o.o.d(r3) == false) goto L76;
        r3 = "-";
    L76:
        r32.a(r33.append((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")).append(", decision=").append(r14.getRawValue()).append(", changed=").append(r26).toString());     // Catch: Exception -> L82
        return (s) ZeusTransformUtils.preCheckCast(s.b.f20165a, s.class, "com.obric.aiagent.plugin");
    L70:
        r112 = null;
        goto L71
    L66:
        r30 = dz.f19791a;     // Catch: Exception -> L82
        goto L67
    L57:
        r25 = null;
        goto L59
    L52:
        r24 = null;
    L62:
        r26 = true;
        goto L63
    L47:
        r23 = null;
    L82:
        e = e;
    L86:
        ea.a(r29, dz.f19792b, r36, null, null, null, r27, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "decision_request", true, false, d.a.ao.a((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin"), d.s.a("decision_changed", false)), 28, null);
        this.k.a("Skill scan decision fetch failed: slug=" + r36.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (s) ZeusTransformUtils.preCheckCast(new s.a("DECISION_FETCH_FAILED"), s.class, "com.obric.aiagent.plugin");
    L32:
        r19 = false;
    L84:
        e = e;
        r27 = r15;
    L18:
        r10 = OProtocolTextEffectTextView.EffectNameNone;
        goto L19
    L9:
        return (s) ZeusTransformUtils.preCheckCast(new s.a("DECISION_TASK_ID_MISSING"), s.class, "com.obric.aiagent.plugin");
    L5:
        return (s) ZeusTransformUtils.preCheckCast(new s.a("DECISION_RECORD_MISSING"), s.class, "com.obric.aiagent.plugin");
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r22, String r23, JsonElement r24, String r25, String r26, boolean r27) {
        gj r1 = this.f20011e.a(r22.a(), hj.f20114a.b(r22.j()));
        if (r1 == null) goto L32;
        ei r2 = this.m.a(r1, dy.i);
        ea r17 = new ea(dy.i, this.l, r2.a().f(), r2.b(), r2.a().g(), 0, r27, 32, null);
        fz r15 = a(r22, r23, r24, r25);     // Catch: Exception -> L24
        a(r22, a(r26, r15));     // Catch: Exception -> L24
        if (r15.a() != ga.f19969b) goto L13;
        dz r4 = dz.f19792b;     // Catch: Exception -> L24
        gp r3 = go.a(r1);     // Catch: Exception -> L24
        if (r3 == null) goto L10;
        String r9 = r3.a();     // Catch: Exception -> L24
    L11:
        ea.a(r17, r4, r22, null, null, null, r9, dw.k, "manifest_verify", false, false, a(r15), 28, null);     // Catch: Exception -> L24
        this.k.a("Skill signing manifest verification failed: slug=" + r22.a() + ", reason=" + r15.b());     // Catch: Exception -> L24
        return;
    L10:
        r9 = null;
        goto L11
    L13:
        dz r5 = dz.f19791a;     // Catch: Exception -> L24
        gp r6 = go.a(r1);     // Catch: Exception -> L24
        if (r6 == null) goto L16;
        String r10 = r6.a();     // Catch: Exception -> L24
    L17:
        ea.a(r17, r5, r22, null, null, null, r10, null, null, false, false, a(r15), 220, null);     // Catch: Exception -> L24
        gd r0 = this.k;     // Catch: Exception -> L24
        StringBuilder r7 = new StringBuilder().append("Skill signing manifest verified: slug=").append(r22.a()).append(", profile=");     // Catch: Exception -> L24
        fw r8 = r15.c();     // Catch: Exception -> L24
        if (r8 == null) goto L21;
        String r11 = r8.a();     // Catch: Exception -> L24
        if (r11 == null) goto L21;
    L22:
        r0.a(r7.append(r11).toString());     // Catch: Exception -> L24
        return;
    L21:
        r11 = OProtocolTextEffectTextView.EffectNameNone;
        goto L22
    L16:
        r10 = null;
    L24:
        e = move-exception;
        dz r12 = dz.f19792b;
        gp r13 = go.a(r1);
        if (r13 == null) goto L28;
        String r14 = r13.a();
    L29:
        ea.a(r17, r12, r22, null, null, null, r14, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "manifest_verify", true, false, null, DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, null);
        throw e;
    L28:
        r14 = null;
        goto L29
    L32:
        throw new IllegalStateException("Signing record disappeared before manifest verify.");
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r27, gj r28, gp r29, boolean r30) {
        gi r2 = en.a(r29);
        if (r2 != gi.f19988a) goto L5;
        return;
    L5:
        ej r3 = this.m.b(r28, r29.a());
        ei r1 = this.m.a(r28, dy.g);
        if (r2 != gi.f19990c) goto L8;
        boolean r4 = true;
    L9:
        if (r30 == false) goto L28;
        hd r0 = this.l;
        dy r8 = dy.g;
        if (r4 == false) goto L13;
        dz r7 = dz.f19792b;
    L14:
        dz r9 = r7;
        long r10 = ek.b(r3);
        String r12 = r3.f();
        int r13 = r1.b();
        String r14 = r27.a();
        Integer r15 = Integer.valueOf(r27.j());
        com.obric.aiagent.skill.manager.api.aq r5 = r27.g();
        if (r5 == null) goto L17;
        String r16 = r5.a();
    L18:
        String r17 = r29.a();
        String r18 = r3.g();
        if (r4 == false) goto L21;
        dw r19 = dw.o;
    L22:
        Boolean r21 = Boolean.valueOf(r4);
        Map<String, Object> r6 = ek.a(r3);
        d.m[] r11 = new d.m[2];
        if (r4 == false) goto L25;
        String r20 = "failed";
    L26:
        r11[0] = d.s.a("business_result", r20);
        r11[1] = d.s.a("result_source", "create_task");
        r0.a(new dx(r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, null, r21, false, d.a.ao.a(r6, d.a.ao.a(r11)), 2048, null));
        return;
    L25:
        r20 = "completed";
        goto L26
    L21:
        r19 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L13:
        r7 = dz.f19791a;
        goto L14
    L28:
        return;
    L8:
        r4 = false;
        goto L9
    }

    private final boolean a(dw r1) {
        switch(b.f20014b[r1.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new d.k();
    }

    private final fz a(com.obric.aiagent.skill.manager.api.e r11, String r12, JsonElement r13, String r14) {
        r r0 = b(r11);
        fz r10 = this.g.a(new fy(r12, r11.a(), hj.f20114a.b(r11.j()), r0.b(), r0.c().b(), r13, r14));     // Catch: Throwable -> L6
        r0.a().a().delete();
        return r10;
    L6:
        th = move-exception;
        r0.a().a().delete();
        throw th;
    }

    private final String a(String r2, fz r3) {
        if (r3.a() != ga.f19968a) goto L6;
        return en.a(r2);
    L6:
        return en.a(r2, r3.b());
    }

    private final Map<String, Object> a(fz r5) {
        d.m[] r4 = new d.m[4];
        String r2 = "verified";
        if (r5.a() != ga.f19968a) goto L5;
        String r0 = "verified";
    L6:
        r4[0] = d.s.a("business_result", r0);
        if (r5.a() == ga.f19968a) goto L10;
        r2 = "failed";
    L10:
        r4[1] = d.s.a("verification_status", r2);
        String r1 = r5.b().name();
        Locale r3 = Locale.ROOT;
        d.h.b.o.c(r3, "ROOT");
        String r6 = r1.toLowerCase(r3);
        d.h.b.o.c(r6, "toLowerCase(...)");
        r4[2] = d.s.a("verification_reason", r6);
        fw r7 = r5.c();
        if (r7 == null) goto L14;
        String r8 = r7.a();
        if (r8 == null) goto L14;
    L15:
        r4[3] = d.s.a("payload_profile", r8);
        return (Map) ZeusTransformUtils.preCheckCast(d.a.ao.d(r4), Map.class, "com.obric.aiagent.plugin");
    L14:
        r8 = OProtocolTextEffectTextView.EffectNameNone;
        goto L15
    L5:
        r0 = "verification_failed";
        goto L6
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r21, String r22) {
        int r1 = hj.f20114a.b(r21.j());
        gj r4 = this.f20011e.a(r21.a(), r1);
        if (r4 != null) goto L6;
        return;
    L6:
        if (d.h.b.o.a(r4.g(), r22) == false) goto L8;
        return;
    L8:
        a(gj.a(r4, null, 0, 0, null, null, null, r22, null, 0, ((Number) ZeusTransformUtils.preCheckCast(this.j.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), 447, null));
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r19, gp r20, String r21, gj r22) {
        long r16 = ((Number) ZeusTransformUtils.preCheckCast(this.j.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        JsonElement r1 = r20.f();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = this.n.toJson(r1);
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r22 == null) goto L13;
        gp r5 = go.a(r22);
        if (r5 == null) goto L13;
        r2 = r5.a();
    L13:
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L18;
    L20:
        String r6 = r19.a();
        int r7 = hj.f20114a.b(r19.j());
        if (r22 == null) goto L43;
        long r8 = r22.c();
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r20.g(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r4) == false) goto L25;
        r4 = this.n.toJson(r20);
    L25:
        d.h.b.o.c(r4, "ifBlank(...)");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r10) == false) goto L30;
        r10 = r22.e();
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L36;
        String r12 = r22.g();
        if (r12 == null) goto L36;
        String r13 = r12;
    L37:
        String r14 = r22.h();
        if (r14 != null) goto L40;
        r14 = ep.l.a();
    L40:
        a(new gj(r6, r7, r8, r9, r11, r21, r13, r14, r22.i(), r16));
        return;
    L36:
        r13 = "";
        goto L37
    L43:
        throw new IllegalStateException("Current signing generation is required.".toString());
    L18:
        if (d.h.b.o.a(r2, r20.a()) == true) goto L20;
        this.f.a(r19.a());
        goto L20
    L5:
        r3 = null;
        goto L7
    }

    private final void a(gj r4) {
        if (this.f20011e.update(r4) == false) goto L5;
        this.h.invoke(r4);
        return;
    L5:
        this.k.a("Stale Skill signing result ignored: slug=" + r4.a() + ", generation=" + r4.c());
    }

    private final r b(com.obric.aiagent.skill.manager.api.e r8) {
        File r1 = new File(this.f20008b, "skill_signing_" + r8.a() + '_' + hj.f20114a.b(r8.j()) + '_' + System.nanoTime() + ".zip");
        dp r0 = this.f20009c.b(r8.a(), r1);     // Catch: Throwable -> L5
        return new r(r0, r0.c(), gg.f19984a.a(r8, db.a(db.f19721a, r0.d(), 0, 2, null), this.n));
    L5:
        th = move-exception;
        r1.delete();
        throw th;
    }

    static /* synthetic */ com.obric.aiagent.skill.manager.api.an a(gm r0, com.obric.aiagent.skill.manager.api.e r1, com.obric.aiagent.skill.manager.api.am r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final com.obric.aiagent.skill.manager.api.an a(com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.api.am r4, String r5) {
        String r2 = r3.a();
        if (r5 != null) goto L5;
    L7:
        r5 = null;
    L9:
        return new com.obric.aiagent.skill.manager.api.an(r2, r4, r5);
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        goto L7
    }

    private final String a(Throwable r4) {
        String r3 = r4.getMessage();
        if (r3 == null) goto L7;
        String r5 = new d.o.k("https?://\\S+").a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), "<redacted-url>");
        if (r5 == null) goto L7;
        String r6 = d.o.o.e(r5, 300);
    L8:
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        String r7 = r4.getClass().getSimpleName();
        d.h.b.o.c(r7, "getSimpleName(...)");
        return r7;
    L14:
        return r4.getClass().getSimpleName() + ": " + r6;
    L7:
        r6 = null;
        goto L8
    }
}
