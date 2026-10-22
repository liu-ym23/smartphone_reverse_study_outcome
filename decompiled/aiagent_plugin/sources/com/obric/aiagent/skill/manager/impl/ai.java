package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SkillMetadataStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ai implements df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SkillMetadataDatabase f19475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final dc f19476c;

    /* JADX INFO: compiled from: SkillMetadataStore.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SkillMetadataStore.kt */
    @d.c.b.a.f(b = "SkillMetadataStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.RoomSkillMetadataStore$blockingQuery$1")
    static final class b<T> extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<T> f19478b;

        b(d.h.a.a<? extends T> r3, d.c.d<? super b> r4) {
            d.h.a.a<T> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19478b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super T> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f19478b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, Object r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f19477a != 0) goto L7;
            d.o.a(r2);
            return this.f19478b.invoke();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f19474a = new a(null);
    }

    public static /* synthetic */ Map lambda$5lZUnieFFI3mLWbsA7o4VViPqnE(ai r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$6o1H-3F6ge8lETZ28vF2YJ-wkOw, reason: not valid java name */
    public static /* synthetic */ boolean m274lambda$6o1H3F6ge8lETZ28vF2YJwkOw(ai r0, gj r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$7tDh8HLaMp9Rfg-ztw5_oyxj1hQ, reason: not valid java name */
    public static /* synthetic */ boolean m275lambda$7tDh8HLaMp9Rfgztw5_oyxj1hQ(ai r0, String r1, long r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ gj lambda$JAlsjzelIgjip__IbHVmzNlUJJ8(ai r0, String r1, int r2, String r3, long r4) {
        return b(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ gj lambda$ZiJ76854xGT9uPFR4ahu2pvII4M(ai r0, String r1, int r2, String r3, long r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean lambda$fjvhe_NPcBtilD_AejWGOGoR6dY(ai r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$kR2KaaDuS6zpzjuIurDVPPdwLjI(ai r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ gj lambda$khuB_o6z1623q22rCan_YKnQXDA(ai r0, String r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ d.x lambda$pQa8TSCWLg2vypa2eT8VQQRNfsE(ai r0, com.obric.aiagent.skill.manager.api.e r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$wsO36PA-VUkbjOnOX-RQn8ZU8A0, reason: not valid java name */
    public static /* synthetic */ Set m276lambda$wsO36PAVUkbjOnOXRQn8ZU8A0(ai r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$xA-7PirxN5j4j0JElcCdDEGldxA, reason: not valid java name */
    public static /* synthetic */ void m277lambda$xA7PirxN5j4j0JElcCdDEGldxA(ai r0, com.obric.aiagent.skill.manager.api.e r1) {
        a(r0, r1);
    }

    public ai(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        SkillMetadataDatabase r5 = SkillMetadataDatabase.f19415e.a(r4);
        this.f19475b = r5;
        this.f19476c = r5.o();
    }

    @Override // com.obric.aiagent.skill.manager.impl.df
    public Map<String, com.obric.aiagent.skill.manager.api.e> a() {
        return (Map) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$5lZUnieFFI3mLWbsA7o4VViPqnE(this)), Map.class, "com.obric.aiagent.plugin");
    }

    private static final Map a(ai r5) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r5.f19476c.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        com.obric.aiagent.skill.manager.api.e r3 = r5.a((de) ZeusTransformUtils.preCheckCast(r2.next(), de.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(d.a.ao.a(d.a.p.a(r6, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        Object r8 = r7.next();
        r4.put(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r8);
        goto L10
    L12:
        return r4;
    }

    @Override // com.obric.aiagent.skill.manager.impl.df
    public boolean a(final String r2) {
        d.h.b.o.e(r2, "slug");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$fjvhe_NPcBtilD_AejWGOGoR6dY(this, r2)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean a(ai r0, String r1) {
        if (r0.f19476c.a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> b() {
        return (Set) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$wsO36PAVUkbjOnOXRQn8ZU8A0(this)), Set.class, "com.obric.aiagent.plugin");
    }

    private static final Set b(ai r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5.f19476c.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r2 = r7.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.manager.impl.df
    public void a(final com.obric.aiagent.skill.manager.api.e r2) {
        d.h.b.o.e(r2, "skill");
        a(new $$Lambda$ai$pQa8TSCWLg2vypa2eT8VQQRNfsE(this, r2));
    }

    private static final d.x b(final ai r2, final com.obric.aiagent.skill.manager.api.e r3) {
        r2.f19475b.a(new $$Lambda$ai$xA7PirxN5j4j0JElcCdDEGldxA(r2, r3));
        return d.x.f38692a;
    }

    private static final void a(ai r5, com.obric.aiagent.skill.manager.api.e r6) {
        de r7 = r5.b(r6);
        de r0 = r5.f19476c.a(r7.a());
        if (r0 != null) goto L5;
        r5.f19476c.insert(r7);
        return;
    L5:
        boolean r3 = false;
        if (r0.o() == r7.o()) goto L16;
        if (r5.f19476c.b(r7.a()) != 1) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        throw new IllegalStateException(("Installed Skill metadata disappeared: " + r7.a()).toString());
    L10:
        r1 = false;
    L16:
        if (dg.a(r5.f19476c, r7) != 1) goto L18;
        r3 = true;
    L18:
        if (r3 == false) goto L21;
        return;
    L21:
        throw new IllegalStateException(("Installed Skill metadata disappeared: " + r7.a()).toString());
    }

    @Override // com.obric.aiagent.skill.manager.impl.df
    public boolean a(final String r2, final long r3) {
        d.h.b.o.e(r2, "slug");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$7tDh8HLaMp9Rfgztw5_oyxj1hQ(this, r2, r3)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean a(ai r0, String r1, long r2) {
        if (r0.f19476c.a(r1, r2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.aiagent.skill.manager.impl.df
    public boolean b(final String r2) {
        d.h.b.o.e(r2, "slug");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$kR2KaaDuS6zpzjuIurDVPPdwLjI(this, r2)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean b(ai r0, String r1) {
        if (r0.f19476c.delete(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.aiagent.skill.manager.impl.gk
    public gj a(final String r9, final int r10, final String r11, final long r12) {
        d.h.b.o.e(r9, "slug");
        d.h.b.o.e(r11, "scanTriggerType");
        Object r8 = a(new $$Lambda$ai$JAlsjzelIgjip__IbHVmzNlUJJ8(this, r9, r10, r11, r12));
        d.h.b.o.c(r8, "blockingQuery(...)");
        return (gj) ZeusTransformUtils.preCheckCast(r8, gj.class, "com.obric.aiagent.plugin");
    }

    private static final gj b(final ai r9, final String r10, final int r11, final String r12, final long r13) {
        return (gj) ZeusTransformUtils.preCheckCast(r9.f19475b.a(new $$Lambda$ai$ZiJ76854xGT9uPFR4ahu2pvII4M(r9, r10, r11, r12, r13)), gj.class, "com.obric.aiagent.plugin");
    }

    private static final gj a(ai r6, String r7, int r8, String r9, long r10) {
        int r11 = r6.f19476c.a(r7, hj.f20114a.b(r8), ep.f19833a.a(r9).a(), r10);
        boolean r12 = true;
        if (r11 == 1) goto L6;
        r12 = false;
    L6:
        if (r12 == false) goto L16;
        de r13 = r6.f19476c.a(r7);
        if (r13 == null) goto L10;
        gj r14 = r6.c(r13);
    L11:
        if (r14 == null) goto L14;
        return r14;
    L14:
        throw new IllegalStateException(("Current Skill scan was not persisted: " + r7).toString());
    L10:
        r14 = null;
        goto L11
    L16:
        throw new IllegalStateException(("Installed Skill metadata not found: " + r7).toString());
    }

    @Override // com.obric.aiagent.skill.manager.impl.gk
    public boolean update(final gj r2) {
        d.h.b.o.e(r2, "record");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$6o1H3F6ge8lETZ28vF2YJwkOw(this, r2)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean a(ai r14, gj r15) {
        if (r14.f19476c.a(r15.a(), hj.f20114a.b(r15.b()), r15.c(), dg.a(r15.d()), dg.a(r15.e()), dg.a(r15.f()), dg.a(r15.g()), ep.f19833a.a(r15.h()).a(), r15.i(), r15.j()) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.aiagent.skill.manager.impl.gk
    public gj a(String r3, int r4) {
        d.h.b.o.e(r3, "slug");
        gj r2 = c(r3);
        if (r2 == null) goto L11;
        if (r2.b() != hj.f20114a.b(r4)) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L11;
        return r2;
    L7:
        r5 = false;
    L11:
        return null;
    }

    @Override // com.obric.aiagent.skill.manager.impl.gk
    public gj c(final String r2) {
        d.h.b.o.e(r2, "slug");
        return (gj) ZeusTransformUtils.preCheckCast(a(new $$Lambda$ai$khuB_o6z1623q22rCan_YKnQXDA(this, r2)), gj.class, "com.obric.aiagent.plugin");
    }

    private static final gj c(ai r1, String r2) {
        de r3 = r1.f19476c.a(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r1.c(r3);
    }

    private final de b(com.obric.aiagent.skill.manager.api.e r31) {
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r31.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L64;
        com.obric.aiagent.skill.manager.api.aq r0 = r31.g();
        if (r0 == null) goto L62;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L18;
        if (r31.h() == null) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L16;
        String r2 = ((com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin")).b();
        String r3 = ((com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin")).c();
        String r17 = ((com.obric.aiagent.skill.manager.api.aq.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.e.class, "com.obric.aiagent.plugin")).d();
        String r15 = r2;
        String r12 = "store";
        String r16 = r3;
        String r13 = null;
        String r14 = null;
        String r18 = null;
        String r19 = null;
    L14:
        String r20 = r19;
    L56:
        return new de(r31.a(), r31.b(), r31.d(), r31.e(), r31.f(), r12, r13, r14, r15, r16, r17, r18, r19, r20, hj.f20114a.b(r31.j()), r31.l(), r31.m(), r31.n(), r31.o(), r31.p(), null, 1048576, null);
    L16:
        throw new IllegalArgumentException("Store Skill must not contain AppFunction metadata.".toString());
    L18:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L37;
        com.obric.aiagent.skill.manager.api.a r4 = r31.h();
        if (r4 == null) goto L24;
        String r5 = r4.a();
        if (r5 == null) goto L24;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L25:
        if (r6 != null) goto L28;
        r6 = "";
    L28:
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L35;
        com.obric.aiagent.skill.manager.api.a r7 = r31.h();
        if (r7 == null) goto L32;
        String r8 = r7.b();
    L33:
        r19 = r6;
        r20 = r8;
        r12 = "app_function";
        r13 = null;
        r14 = null;
        r15 = null;
        r16 = null;
        r17 = null;
        r18 = null;
        goto L56
    L32:
        r8 = null;
        goto L33
    L35:
        throw new IllegalArgumentException("AppFunction Skill package name must not be blank.".toString());
    L24:
        r6 = null;
        goto L25
    L37:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L48;
        if (r31.h() == null) goto L42;
        r1 = false;
    L42:
        if (r1 == false) goto L46;
        String r9 = ((com.obric.aiagent.skill.manager.api.aq.b) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.b.class, "com.obric.aiagent.plugin")).b().a();
        r18 = ((com.obric.aiagent.skill.manager.api.aq.b) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.b.class, "com.obric.aiagent.plugin")).c();
        r13 = r9;
        r12 = "created";
        r14 = null;
        r15 = null;
    L44:
        r16 = r15;
        r17 = r16;
        r19 = r17;
        goto L14
    L46:
        throw new IllegalArgumentException("Created Skill must not contain AppFunction metadata.".toString());
    L48:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.api.aq.c.class) == false) goto L60;
        if (r31.h() == null) goto L53;
        r1 = false;
    L53:
        if (r1 == false) goto L58;
        String r10 = ((com.obric.aiagent.skill.manager.api.aq.c) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.c.class, "com.obric.aiagent.plugin")).b().a();
        String r11 = ((com.obric.aiagent.skill.manager.api.aq.c) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.c.class, "com.obric.aiagent.plugin")).d().a();
        r18 = ((com.obric.aiagent.skill.manager.api.aq.c) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.aq.c.class, "com.obric.aiagent.plugin")).c();
        r13 = r10;
        r12 = "imported";
        r14 = r11;
        r15 = null;
        goto L44
    L58:
        throw new IllegalArgumentException("Imported Skill must not contain AppFunction metadata.".toString());
    L60:
        throw new d.k();
    L62:
        throw new IllegalArgumentException(("Installed Skill source must not be null: " + r31.a()).toString());
    L64:
        throw new IllegalArgumentException("Installed Skill slug must not be blank.".toString());
    }

    private final com.obric.aiagent.skill.manager.api.e a(de r34) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r34.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        a(r34.a(), "blank_slug");
        return null;
    L7:
        if (r34.o() >= 1) goto L10;
        a(r34.a(), "invalid_version");
        return null;
    L10:
        com.obric.aiagent.skill.manager.api.aq r11 = b(r34);
        if (r11 != null) goto L14;
        return null;
    L14:
        if (d.h.b.o.a(r11, com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L28;
        String r0 = r34.m();
        if (r0 != null) goto L18;
    L27:
        return null;
    L18:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
        r0 = null;
    L21:
        if (r0 == null) goto L27;
        String r4 = r34.n();
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        com.obric.aiagent.skill.manager.api.a r12 = new com.obric.aiagent.skill.manager.api.a(r0, r4);
    L34:
        com.obric.aiagent.skill.manager.api.e r1 = new com.obric.aiagent.skill.manager.api.e(r34.a(), r34.b(), null, r34.c(), r34.d(), r34.e(), r11, r12, null, r34.o(), null, r34.p(), r34.q(), r34.r(), r34.s(), r34.t(), null, 66820, null);     // Catch: Exception -> L31
        return com.obric.aiagent.skill.manager.api.e.a(r1, null, null, null, null, null, null, null, null, en.a(r1, c(r34), null), 0, null, false, false, null, null, null, null, 130815, null);
    L31:
        e = move-exception;
        String r3 = r34.a();
        String r2 = e.getClass().getSimpleName();
        d.h.b.o.c(r2, "getSimpleName(...)");
        a(r3, r2);
        return null;
    L28:
        r12 = null;
        goto L34
    }

    private final com.obric.aiagent.skill.manager.api.aq b(de r9) {
        Object r2 = null;
        if (d.h.b.o.a(r9.f(), "app_function") == false) goto L5;
    L10:
        String r0 = r9.f();
        String r6 = "";
        switch(r0.hashCode()) {
            case -422368508: goto L89;
            case 109770977: goto L67;
            case 1028554472: goto L42;
            case 1177813046: goto L14;
            default: goto L113;
        };
    L113:
        a(r9.a(), "unsupported_type");
        return null;
    L14:
        if (r0.equals("app_function") == false) goto L113;
        if (r9.g() == null) goto L19;
    L39:
        a(r9.a(), "app_function_contains_other_source_fields");
    L115:
        return (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
    L19:
        if (r9.h() != null) goto L39;
        if (r9.i() != null) goto L39;
        if (r9.j() != null) goto L39;
        if (r9.k() != null) goto L39;
        if (r9.l() != null) goto L39;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.m(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L32;
    L35:
        boolean r3 = true;
    L36:
        if (r3 == false) goto L38;
        a(r9.a(), "app_function_missing_package_name");
        goto L115
    L38:
        r2 = com.obric.aiagent.skill.manager.api.aq.a.f19212a;
        goto L115
    L32:
        if (d.o.o.d(r1) == true) goto L35;
        r3 = false;
        goto L36
    L42:
        if (r0.equals("created") == false) goto L113;
        if (r9.i() == null) goto L47;
    L64:
        a(r9.a(), "local_contains_store_fields");
        return null;
    L47:
        if (r9.j() != null) goto L64;
        if (r9.k() != null) goto L64;
        if (r9.h() == null) goto L55;
        a(r9.a(), "created_contains_import_kind");
        return null;
    L55:
        com.obric.aiagent.skill.manager.api.ar r4 = com.obric.aiagent.skill.manager.api.ar.f19222a.a(r9.g());
        if (r4 != null) goto L59;
        a(r9.a(), "unsupported_local_channel");
        return null;
    L59:
        String r10 = r9.l();
        if (r10 == null) goto L116;
        r6 = r10;
    L116:
        return (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.b(r4, r6), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
    L67:
        if (r0.equals("store") == false) goto L113;
        if (r9.g() == null) goto L71;
    L86:
        a(r9.a(), "store_contains_local_fields");
    L117:
        return (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
    L71:
        if (r9.h() != null) goto L86;
        if (r9.l() != null) goto L86;
        String r8 = r9.i();
        if (r8 != null) goto L78;
        r8 = "";
    L78:
        String r5 = r9.j();
        if (r5 != null) goto L81;
        r5 = "";
    L81:
        String r11 = r9.k();
        if (r11 == null) goto L85;
        r6 = r11;
    L85:
        r2 = new com.obric.aiagent.skill.manager.api.aq.e(r8, r5, r6);
        goto L117
    L89:
        if (r0.equals("imported") == false) goto L113;
        if (r9.i() == null) goto L94;
    L111:
        a(r9.a(), "local_contains_store_fields");
        return null;
    L94:
        if (r9.j() != null) goto L111;
        if (r9.k() != null) goto L111;
        com.obric.aiagent.skill.manager.api.ar r7 = com.obric.aiagent.skill.manager.api.ar.f19222a.a(r9.g());
        if (r7 != null) goto L102;
        a(r9.a(), "unsupported_local_channel");
        return null;
    L102:
        com.obric.aiagent.skill.manager.api.n r12 = com.obric.aiagent.skill.manager.api.n.f19283a.a(r9.h());
        if (r12 != null) goto L106;
        a(r9.a(), "unsupported_import_kind");
        return null;
    L106:
        String r13 = r9.l();
        if (r13 == null) goto L118;
        r6 = r13;
    L118:
        return (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.api.aq.c(r7, r12, r6), com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
    L5:
        if (r9.m() == null) goto L7;
    L8:
        a(r9.a(), "non_app_function_contains_app_function_metadata");
        return null;
    L7:
        if (r9.n() == null) goto L10;
        goto L8
    }

    private final gj c(de r19) {
        Integer r0 = r19.u().b();
        if (r0 == null) goto L29;
        int r3 = r0.intValue();
        String r2 = r19.a();
        long r4 = r19.u().a();
        String r1 = r19.u().c();
        if (r1 != null) goto L7;
        String r7 = "";
    L8:
        String r5 = r19.u().d();
        if (r5 != null) goto L11;
        String r8 = "";
    L12:
        String r6 = r19.u().e();
        if (r6 != null) goto L15;
        String r9 = "";
    L16:
        String r10 = r19.u().f();
        if (r10 != null) goto L19;
        String r11 = "";
    L20:
        String r12 = ep.f19833a.a(r19.u().g()).a();
        Long r13 = r19.u().h();
        long r14 = 0;
        if (r13 == null) goto L23;
        long r15 = r13.longValue();
    L24:
        Long r16 = r19.u().i();
        if (r16 == null) goto L28;
        r14 = r16.longValue();
    L28:
        return new gj(r2, r3, r4, r7, r8, r9, r11, r12, r15, r14);
    L23:
        r15 = 0;
        goto L24
    L19:
        r11 = r10;
        goto L20
    L15:
        r9 = r6;
        goto L16
    L11:
        r8 = r5;
        goto L12
    L7:
        r7 = r1;
        goto L8
    L29:
        return null;
    }

    private final <T> T a(d.h.a.a<? extends T> r4) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        return (T) kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void a(String r4, String r5) {
        ee r3 = ee.f19808a;
        StringBuilder r0 = new StringBuilder().append("Skill metadata row skipped without deletion: slug=");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r6) == false) goto L5;
        r6 = "-";
    L5:
        r3.c("SkillManager", "Skill metadata row skipped without deletion", r0.append((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin")).append(", reason=").append(r5).toString());
    }
}
