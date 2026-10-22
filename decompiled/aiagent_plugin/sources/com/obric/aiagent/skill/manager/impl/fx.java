package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SkillSignatureRefreshCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> f19933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.q<com.obric.aiagent.skill.manager.api.e, aw, d.c.d<? super com.obric.aiagent.skill.manager.api.an>, Object> f19934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, kotlinx.coroutines.w<com.obric.aiagent.skill.manager.api.an>> f19935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.f.d f19936e;

    /* JADX INFO: compiled from: SkillSignatureRefreshCoordinator.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillSignatureRefreshCoordinator.kt */
    @d.c.b.a.f(b = "SkillSignatureRefreshCoordinator.kt", c = {41}, d = "refresh", e = "com.obric.aiagent.skill.manager.impl.SkillSignatureRefreshCoordinator")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ fx f19938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19939c;

        b(fx r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19938b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19937a = r3;
            this.f19939c |= Integer.MIN_VALUE;
            return this.f19938b.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillSignatureRefreshCoordinator.kt */
    @d.c.b.a.f(b = "SkillSignatureRefreshCoordinator.kt", c = {46}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillSignatureRefreshCoordinator$refresh$results$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends com.obric.aiagent.skill.manager.api.an>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f19941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ fx f19942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ aw f19943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f19944e;

        /* JADX INFO: compiled from: SkillSignatureRefreshCoordinator.kt */
        @d.c.b.a.f(b = "SkillSignatureRefreshCoordinator.kt", c = {111, 44}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillSignatureRefreshCoordinator$refresh$results$1$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.manager.api.an>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f19945a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f19946b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f19947c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f19948d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f19949e;
            final /* synthetic */ fx f;
            final /* synthetic */ String g;
            final /* synthetic */ aw h;

            a(fx r3, String r4, aw r5, d.c.d<? super a> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                this.g = r4;
                this.h = r5;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.api.an> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f, this.g, this.h, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.api.an> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f19949e;
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L13;
                if (r1 != 2) goto L12;
                kotlinx.coroutines.f.d r9 = (kotlinx.coroutines.f.d) ZeusTransformUtils.preCheckCast(this.f19945a, kotlinx.coroutines.f.d.class, "com.obric.aiagent.plugin");
                d.o.a(r10);     // Catch: Throwable -> L9
            L22:
                com.obric.aiagent.skill.manager.api.an r11 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
                r9.c();
                return r11;
            L9:
                Throwable th = th;
            L27:
                r9.c();
                throw th;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L13:
                aw r2 = (aw) ZeusTransformUtils.preCheckCast(this.f19948d, aw.class, "com.obric.aiagent.plugin");
                String r3 = (String) ZeusTransformUtils.preCheckCast(this.f19947c, String.class, "com.obric.aiagent.plugin");
                fx r5 = (fx) ZeusTransformUtils.preCheckCast(this.f19946b, fx.class, "com.obric.aiagent.plugin");
                kotlinx.coroutines.f.d r6 = (kotlinx.coroutines.f.d) ZeusTransformUtils.preCheckCast(this.f19945a, kotlinx.coroutines.f.d.class, "com.obric.aiagent.plugin");
                d.o.a(r10);
                kotlinx.coroutines.f.d r12 = r6;
            L29:
                this.f19945a = r12;     // Catch: Throwable -> L25
                this.f19946b = null;     // Catch: Throwable -> L25
                this.f19947c = null;     // Catch: Throwable -> L25
                this.f19948d = null;     // Catch: Throwable -> L25
                this.f19949e = 2;     // Catch: Throwable -> L25
                Object r13 = fx.a(r5, r3, r2, this);     // Catch: Throwable -> L25
                if (r13 != r0) goto L21;
                return r0;
            L21:
                kotlinx.coroutines.f.d r8 = r12;
                r10 = r13;
                r9 = r8;
            L25:
                th = move-exception;
                kotlinx.coroutines.f.d r14 = r12;
                th = th;
                r9 = r14;
                goto L27
            L14:
                d.o.a(r10);
                r12 = fx.a(this.f);
                r5 = this.f;
                String r4 = this.g;
                aw r7 = this.h;
                d.c.d<? super d.x> r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19945a = r12;
                this.f19946b = r5;
                this.f19947c = r4;
                this.f19948d = r7;
                this.f19949e = 1;
                if (r12.a(r15) != r0) goto L17;
                return r0;
            L17:
                r3 = r4;
                r2 = r7;
                goto L29
            }
        }

        c(List<String> r3, fx r4, aw r5, d.c.d<? super c> r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19941b = r7;
            this.f19942c = r4;
            this.f19943d = r5;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<com.obric.aiagent.skill.manager.api.an>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f19941b, this.f19942c, this.f19943d, r7);
            r0.f19944e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends com.obric.aiagent.skill.manager.api.an>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19940a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r14);
        L15:
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r14);
            kotlinx.coroutines.am r15 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f19944e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19941b, Iterable.class, "com.obric.aiagent.plugin");
            fx r10 = this.f19942c;
            aw r11 = this.f19943d;
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
            r12.add(kotlinx.coroutines.i.b(r15, (d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, r4, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null));
            goto L10
        L12:
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19940a = 1;
            r14 = kotlinx.coroutines.f.a(r16, r5);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillSignatureRefreshCoordinator.kt */
    @d.c.b.a.f(b = "SkillSignatureRefreshCoordinator.kt", c = {59, 65, 66}, d = "refreshSerialized", e = "com.obric.aiagent.skill.manager.impl.SkillSignatureRefreshCoordinator")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f19953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f19954e;
        final /* synthetic */ fx f;
        int g;

        d(fx r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19954e = r3;
            this.g |= Integer.MIN_VALUE;
            return fx.a(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f19932a = new a(null);
    }

    public fx(d.h.a.b<? super String, com.obric.aiagent.skill.manager.api.e> r3, d.h.a.q<? super com.obric.aiagent.skill.manager.api.e, ? super aw, ? super d.c.d<? super com.obric.aiagent.skill.manager.api.an>, ? extends Object> r4, int r5) {
        d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.q<com.obric.aiagent.skill.manager.api.e, aw, d.c.d<? super com.obric.aiagent.skill.manager.api.an>, Object> r7 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "findSkill");
        d.h.b.o.e(r7, "refreshOne");
        this.f19933b = r6;
        this.f19934c = r7;
        this.f19935d = new ConcurrentHashMap();
        this.f19936e = kotlinx.coroutines.f.f.a(r5, 0, 2, null);
    }

    public /* synthetic */ fx(d.h.a.b r2, d.h.a.q r3, int r4, int r5, d.h.b.h r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.q r8 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.q.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = 4;
    L5:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ Object a(fx r2, String r3, aw r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.f.d a(fx r0) {
        return r0.f19936e;
    }

    public final Object a(com.obric.aiagent.skill.manager.api.ap r7, List<com.obric.aiagent.skill.manager.api.e> r8, aw r9, d.c.d<? super com.obric.aiagent.skill.manager.api.ao> r10) {
        com.obric.aiagent.skill.manager.api.ap r11 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin");
        if ((r0.f19939c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19939c -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f19937a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19939c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r14);
    L38:
        return new com.obric.aiagent.skill.manager.api.ao((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        if (d.h.b.o.a(r11, com.obric.aiagent.skill.manager.api.ap.a.f19210a) == false) goto L22;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        r16.add(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a());
        goto L18
    L20:
        List r18 = d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L34:
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r18, this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f19939c = 1;
        r14 = kotlinx.coroutines.an.a(r6, r0);
        if (r14 != r2) goto L38;
        return r2;
    L22:
        if (ZeusTransformUtils.instanceOf(r11, com.obric.aiagent.skill.manager.api.ap.b.class) == false) goto L40;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.ap.b) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.manager.api.ap.b.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r19.iterator();
    L25:
        if (r21.hasNext() == false) goto L27;
        r20.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L25
    L27:
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r24 = r22.iterator();
    L29:
        if (r24.hasNext() == false) goto L33;
        Object r110 = r24.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L29;
        r23.add(r110);
        goto L29
    L33:
        r18 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        goto L34
    L40:
        throw new d.k();
    L7:
        r0 = new b(this, r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<com.obric.aiagent.skill.manager.impl.fx>] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.obric.aiagent.skill.manager.impl.fx, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.obric.aiagent.skill.manager.impl.fx] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.lang.Object, kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.obric.aiagent.skill.manager.impl.fx] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [com.obric.aiagent.skill.manager.impl.fx] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.obric.aiagent.skill.manager.impl.aw, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.lang.Object, kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.lang.Object, kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private final Object a(String r11, aw r12, d.c.d<? super com.obric.aiagent.skill.manager.api.an> r13) {
        ?? r0 = fx.class;
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        ?? r15 = r1.f19954e;
        Object r3 = d.c.a.b.a();
        int r4 = r1.g;
        if (r4 == 0) goto L32;
        if (r4 != 1) goto L94;
        d.o.a(r15);
    L45:
        return r15;
    L94:
        if (r4 == 2) goto L19;
        if (r4 != 3) goto L18;
        kotlinx.coroutines.w r10 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(r1.f19953d, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r1.f19952c, String.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r1.f19951b, String.class, "com.obric.aiagent.plugin");
        fx r2 = (fx) ZeusTransformUtils.preCheckCast(r1.f19950a, r0, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L23 Exception -> L25 CancellationException -> L29
        ?? r9 = r15;
        ?? r18 = r10;
        ?? r19 = r2;
        ?? r110 = r16;
        ?? r111 = r17;
    L71:
        com.obric.aiagent.skill.manager.api.an r5 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61 Exception -> L63 CancellationException -> L65
        ?? r112 = r19;
        ?? r113 = r110;
        r12 = r111;
        ?? r114 = r18;
    L72:
        ?? r20 = r113;
        r11 = r112;
        fx this = r114;
        r15 = r5;
        r0 = r20;
        this = this;
        ?? r115 = r11;
        ?? r116 = r12;
        ?? r117 = r15;
    L95:
        this.a(r117);     // Catch: Throwable -> L75 Exception -> L77 CancellationException -> L79
        r115.f19935d.remove(r0, this);
        return r117;
    L79:
        e = e;
    L89:
        this.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L77:
        e = move-exception;
        Exception r21 = e;
        r15 = this;
        this = r115;
        ?? r6 = r0;
        ?? r118 = r116;
    L28:
        r11 = r118;
        Exception e2 = r21;
    L82:
        String r119 = e2.getClass().getSimpleName();     // Catch: Throwable -> L85
        d.h.b.o.c(r119, "getSimpleName(...)");     // Catch: Throwable -> L85
        com.obric.aiagent.skill.manager.api.an r120 = this.a(r11, r119);     // Catch: Throwable -> L85
        r15.a(r120);     // Catch: Throwable -> L85
        this.f19935d.remove(r6, r15);
        return r120;
    L75:
        th = th;
        r15 = this;
        this = r115;
    L86:
        r11 = r0;
    L91:
        this.f19935d.remove(r11, r15);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.w r121 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(r1.f19953d, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        String r122 = (String) ZeusTransformUtils.preCheckCast(r1.f19952c, String.class, "com.obric.aiagent.plugin");
        String r123 = (String) ZeusTransformUtils.preCheckCast(r1.f19951b, String.class, "com.obric.aiagent.plugin");
        fx r7 = (fx) ZeusTransformUtils.preCheckCast(r1.f19950a, r0, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L23 Exception -> L25 CancellationException -> L29
        ?? r22 = r15;
        ?? r124 = r121;
        ?? r125 = r7;
        ?? r126 = r122;
        ?? r127 = r123;
    L59:
        r5 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r22, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61 Exception -> L63 CancellationException -> L65
        r112 = r125;
        r113 = r126;
        r12 = r127;
        r114 = r124;
    L29:
        e = e;
    L25:
        e = move-exception;
        r21 = e;
        ?? r128 = this;
        ?? r129 = r0;
        ?? r130 = r11;
        ?? r131 = r12;
    L27:
        r6 = r130;
        this = r129;
        r118 = r131;
        r15 = r128;
        goto L28
    L32:
        d.o.a(r15);
        com.obric.aiagent.skill.manager.api.e r132 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f19933b.invoke(r11), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r132 == null) goto L35;
        r6 = b(r132);
        if (r6 == 0) goto L39;
        r15 = kotlinx.coroutines.y.a(null, 1, null);
        kotlinx.coroutines.w r8 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(this.f19935d.putIfAbsent((String) r6, (kotlinx.coroutines.w<com.obric.aiagent.skill.manager.api.an>) r15), kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L97;
        r1.g = 1;
        r15 = r8.a(r1);
        if (r15 != r3) goto L45;
        return r3;
    L97:
        com.obric.aiagent.skill.manager.api.e r23 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f19933b.invoke(r11), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        if (r23 != null) goto L51;
        com.obric.aiagent.skill.manager.api.an r133 = a(r11);     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
    L49:
        r115 = this;
        this = r15;
        r117 = r133;
        r116 = r11;
        r0 = r6;
        goto L95
    L51:
        if (b(r23) != null) goto L54;
        r133 = a(r23);     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        goto L49
    L54:
        if (d.h.b.o.a(b(r23), r6) == true) goto L67;
        r1.f19950a = this;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19951b = r11;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19952c = r6;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19953d = r15;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.g = 2;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        Object r134 = a(r11, r12, r1);     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        if (r134 != r3) goto L58;
        return r3;
    L58:
        r22 = r134;
        r127 = r11;
        r126 = r6;
        this = this;
        r124 = r15;
        goto L59
    L67:
        d.h.a.q<com.obric.aiagent.skill.manager.api.e, aw, d.c.d<? super com.obric.aiagent.skill.manager.api.an>, Object> r24 = this.f19934c;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19950a = this;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19951b = r11;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19952c = r6;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.f19953d = r15;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        r1.g = 3;     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        Object r135 = r24.invoke(r23, r12, r1);     // Catch: Exception -> L81 Throwable -> L85 CancellationException -> L87
        if (r135 != r3) goto L70;
        return r3;
    L70:
        r9 = r135;
        r111 = r11;
        r110 = r6;
        this = this;
        r18 = r15;
    L87:
        e = e;
    L66:
        this = r15;
    L81:
        e2 = e;
        goto L82
    L39:
        return a(r132);
    L35:
        return a(r11);
    L85:
        th = th;
    L23:
        th = th;
        r15 = this;
        this = r0;
    L65:
        e = e;
    L63:
        e = move-exception;
        r21 = e;
        r129 = this;
        r130 = r11;
        r131 = r12;
        r128 = r15;
    L61:
        th = th;
    L7:
        r1 = new d(this, r14);
        goto L8
    }

    private final com.obric.aiagent.skill.manager.api.an a(String r3) {
        return new com.obric.aiagent.skill.manager.api.an(r3, com.obric.aiagent.skill.manager.api.am.f, "Installed Skill not found.");
    }

    private final com.obric.aiagent.skill.manager.api.an a(com.obric.aiagent.skill.manager.api.e r2) {
        return a(r2.a(), "INVALID_VERSION");
    }

    private final com.obric.aiagent.skill.manager.api.an a(String r2, String r3) {
        return new com.obric.aiagent.skill.manager.api.an(r2, com.obric.aiagent.skill.manager.api.am.g, r3);
    }

    private final String b(com.obric.aiagent.skill.manager.api.e r2) {
        if (hj.f20114a.a(r2.j()) == true) goto L7;
        return null;
    L7:
        return r2.a() + ':' + r2.j();
    }
}
