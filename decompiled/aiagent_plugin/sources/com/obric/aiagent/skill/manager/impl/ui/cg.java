package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.ft;
import com.obric.aiagent.skill.manager.impl.gy;
import com.obric.aiagent.skill.manager.impl.gz;
import com.obric.aiagent.skill.manager.impl.hd;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillShopViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cg extends androidx.lifecycle.aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ft f20719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final hd f20720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ca f20721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<String, b> f20722e;
    private final bu.c f;
    private final kotlinx.coroutines.b.x<cf> g;
    private final kotlinx.coroutines.b.ak<cf> h;
    private boolean i;
    private kotlinx.coroutines.ca j;
    private kotlinx.coroutines.ca k;

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final gz<com.obric.aiagent.skill.manager.impl.am> f20723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private kotlinx.coroutines.ca f20724b;

        /* JADX INFO: renamed from: lambda$tGd-woReu36UZvZ3PLn6agzRGIc, reason: not valid java name */
        public static /* synthetic */ String m340lambda$tGdwoReu36UZvZ3PLn6agzRGIc(com.obric.aiagent.skill.manager.impl.am r0) {
            return a(r0);
        }

        public b() {
            this.f20723a = new gz(0, $$Lambda$cg$b$tGdwoReu36UZvZ3PLn6agzRGIc.INSTANCE, 1, null);
        }

        private static final String a(com.obric.aiagent.skill.manager.impl.am r1) {
            d.h.b.o.e(r1, "item");
            return r1.a().a();
        }

        public final gz<com.obric.aiagent.skill.manager.impl.am> a() {
            return this.f20723a;
        }

        public final void a(kotlinx.coroutines.ca r3) {
            this.f20724b = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    @d.c.b.a.f(b = "SkillShopViewModel.kt", c = {333}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopViewModel$loadBanner$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ cg f20726b;

        /* JADX INFO: compiled from: SkillShopViewModel.kt */
        @d.c.b.a.f(b = "SkillShopViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopViewModel$loadBanner$1$banner$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.manager.impl.aj>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20727a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ cg f20728b;

            a(cg r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20728b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.impl.aj> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20728b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.impl.aj> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f20727a != 0) goto L7;
                d.o.a(r2);
                return cg.a(this.f20728b).b();
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(cg r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20726b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f20726b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20725a;
            if (r1 == 0) goto L15;
            if (r1 != 1) goto L14;
            d.o.a(r15);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L19:
            com.obric.aiagent.skill.manager.impl.aj r16 = (com.obric.aiagent.skill.manager.impl.aj) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.impl.aj.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            kotlinx.coroutines.b.x r2 = cg.c(this.f20726b);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cf r5 = (cf) ZeusTransformUtils.preCheckCast(cg.c(this.f20726b).c(), cf.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r16 == null) goto L22;
            bs r17 = (bs) ZeusTransformUtils.preCheckCast(new bs.a(r16), bs.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L23:
            r2.b(cf.a(r5, null, r17, null, null, null, null, 61, null));     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cg.b(this.f20726b).b(true);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L24:
            cg.b(this.f20726b, null);
            return d.x.f38692a;
        L22:
            r17 = (bs) ZeusTransformUtils.preCheckCast(bs.c.f20668a, bs.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            goto L23
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.o.a(r15);
            d.c.g r18 = (d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.h.a.m r3 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20726b, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            this.f20725a = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r15 = kotlinx.coroutines.i.a(r18, r3, r6);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r15 != r0) goto L19;
            return r0;
        L7:
            th = move-exception;
            cg.b(this.f20726b, null);
            throw th;
        L11:
            e = move-exception;
            throw e;     // Catch: Throwable -> L7
        L9:
            e = move-exception;
            cg.c(this.f20726b).b(cf.a((cf) ZeusTransformUtils.preCheckCast(cg.c(this.f20726b).c(), cf.class, "com.obric.aiagent.plugin"), null, (bs) ZeusTransformUtils.preCheckCast(bs.c.f20668a, bs.class, "com.obric.aiagent.plugin"), null, null, null, null, 61, null));     // Catch: Throwable -> L7
            cg.b(this.f20726b).b(false);     // Catch: Throwable -> L7
            cl.a("SkillManager", "load discovery banner", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            goto L24
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    @d.c.b.a.f(b = "SkillShopViewModel.kt", c = {294}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopViewModel$loadCategories$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ cg f20730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bu.c f20731c;

        /* JADX INFO: compiled from: SkillShopViewModel.kt */
        @d.c.b.a.f(b = "SkillShopViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopViewModel$loadCategories$1$categories$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends com.obric.aiagent.skill.manager.impl.ak>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20732a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ cg f20733b;

            /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.cg$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Comparisons.kt */
            public static final class C0435a<T> implements Comparator {
                public C0435a() {
                }

                @Override // java.util.Comparator
                public final int compare(T r2, T r3) {
                    return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiagent.skill.manager.impl.ak) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.impl.ak.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiagent.skill.manager.impl.ak) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.impl.ak.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"));
                }
            }

            a(cg r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20733b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<com.obric.aiagent.skill.manager.impl.ak>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20733b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends com.obric.aiagent.skill.manager.impl.ak>> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f20732a != 0) goto L24;
                d.o.a(r7);
                Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(cg.a(this.f20733b).a(), Iterable.class, "com.obric.aiagent.plugin");
                Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r9 = r8.iterator();
            L6:
                if (r9.hasNext() == false) goto L15;
                Object r2 = r9.next();
                com.obric.aiagent.skill.manager.impl.ak r3 = (com.obric.aiagent.skill.manager.impl.ak) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.impl.ak.class, "com.obric.aiagent.plugin");
                boolean r5 = true;
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
            L12:
                r5 = false;
            L13:
                if (r5 == false) goto L6;
                r0.add(r2);
                goto L6
            L10:
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L12;
            L15:
                Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
                cg r6 = this.f20733b;
                Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r11 = r10.iterator();
            L17:
                if (r11.hasNext() == false) goto L22;
                Object r4 = r11.next();
                if (cg.a(r6, (com.obric.aiagent.skill.manager.impl.ak) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.impl.ak.class, "com.obric.aiagent.plugin")) == true) goto L17;
                r1.add(r4);
                goto L17
            L22:
                return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0435a(), Comparator.class, "com.obric.aiagent.plugin"));
            L24:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(cg r3, bu.c r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20730b = r3;
            this.f20731c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f20730b, this.f20731c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20729a;
            if (r1 == 0) goto L15;
            if (r1 != 1) goto L14;
            d.o.a(r15);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L19:
            List r16 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            bu.c r2 = this.f20731c;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            List r3 = d.a.p.a();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r3.add(r2);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L21:
            if (r17.hasNext() == false) goto L23;
            com.obric.aiagent.skill.manager.impl.ak r4 = (com.obric.aiagent.skill.manager.impl.ak) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aiagent.skill.manager.impl.ak.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r3.add(new bu.a(r4.a(), r4.b()));     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            goto L21
        L23:
            List r6 = d.a.p.a(r3);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cf r5 = (cf) ZeusTransformUtils.preCheckCast(cg.c(this.f20730b).c(), cf.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cg.c(this.f20730b).b(cf.a(r5, r6, null, null, null, null, null, 62, null));     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cg.b(this.f20730b).a(true);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L26:
            cg.a(this.f20730b, null);
            return d.x.f38692a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.o.a(r15);
            d.c.g r18 = (d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20730b, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            this.f20729a = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r15 = kotlinx.coroutines.i.a(r18, r7, r8);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r15 != r0) goto L19;
            return r0;
        L7:
            th = move-exception;
            cg.a(this.f20730b, null);
            throw th;
        L11:
            e = move-exception;
            throw e;     // Catch: Throwable -> L7
        L9:
            e = move-exception;
            cg.b(this.f20730b).a(false);     // Catch: Throwable -> L7
            cl.a("SkillManager", "load discovery categories", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            goto L26
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    @d.c.b.a.f(b = "SkillShopViewModel.kt", c = {161}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopViewModel$loadNextPage$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f20735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ cg f20736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ea f20737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ bu f20738e;
        final /* synthetic */ gy f;
        final /* synthetic */ b g;

        /* JADX INFO: compiled from: SkillShopViewModel.kt */
        @d.c.b.a.f(b = "SkillShopViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopViewModel$loadNextPage$2$result$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.manager.impl.an<? extends com.obric.aiagent.skill.manager.impl.am>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20739a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ cg f20740b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ bu f20741c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ gy f20742d;

            a(cg r3, bu r4, gy r5, d.c.d<? super a> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20740b = r3;
                this.f20741c = r4;
                this.f20742d = r5;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.impl.an<com.obric.aiagent.skill.manager.impl.am>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20740b, this.f20741c, this.f20742d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.impl.an<? extends com.obric.aiagent.skill.manager.impl.am>> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20739a != 0) goto L7;
                d.o.a(r4);
                return cg.a(this.f20740b).a(this.f20741c.c(), this.f20741c.f(), this.f20742d.b(), this.f20742d.c());
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e(boolean r3, cg r4, ea r5, bu r6, gy r7, b r8, d.c.d<? super e> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20735b = r3;
            this.f20736c = r4;
            this.f20737d = r5;
            this.f20738e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r10);
        }

        public static /* synthetic */ cd lambda$05yFjUv8Poz4IfDI7gjKmvNBzks(cd r0) {
            return b(r0);
        }

        public static /* synthetic */ cd lambda$49a5M6qpjhN7yb1ekezuGZa8o4A(cd r0) {
            return a(r0);
        }

        public static /* synthetic */ cd lambda$wVbMTyEE9elS_q_IJlgapILy34c(b r0, cd r1) {
            return a(r0, r1);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f20735b, this.f20736c, this.f20737d, this.f20738e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f20734a;
            if (r2 == 0) goto L15;
            if (r2 != 1) goto L14;
            d.o.a(r25);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            Object r3 = r25;
        L19:
            com.obric.aiagent.skill.manager.impl.an<? extends com.obric.aiagent.skill.manager.impl.am> r1 = (com.obric.aiagent.skill.manager.impl.an) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.impl.an.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (this.f20735b == false) goto L22;
            cg.b(this.f20736c).c(true);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L26:
            if (this.g.a().a(this.f, r1) == false) goto L28;
            cg r4 = this.f20736c;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            bu r5 = this.f20738e;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            final b r6 = this.g;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cg.a(r4, r5, new $$Lambda$cg$e$wVbMTyEE9elS_q_IJlgapILy34c(r6));     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L28:
            this.g.a(null);
            return d.x.f38692a;
        L22:
            ea r10 = this.f20737d;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r10 == null) goto L26;
            ea.a(r10, dz.f19791a, null, null, null, null, null, null, null, null, null, d.a.ao.a(new d.m[]{d.s.a("page_type", this.f20738e.d()), d.s.a("item_count", d.c.b.a.b.a(r1.a().size())), d.s.a("page_number", d.c.b.a.b.a(this.f.b()))}), DownloadErrorCode.ERROR_NO_CONNECTION, null);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            goto L26
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.o.a(r25);
            d.c.g r7 = (d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20736c, this.f20738e, this.f, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            this.f20734a = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r3 = kotlinx.coroutines.i.a(r7, r11, r12);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r3 != r0) goto L19;
            return r0;
        L7:
            th = move-exception;
            this.g.a(null);
            throw th;
        L11:
            e = move-exception;
            this.g.a().a(this.f);     // Catch: Throwable -> L7
            ea r13 = this.f20737d;     // Catch: Throwable -> L7
            if (r13 == null) goto L49;
            ea.a(r13, dz.f19793c, null, null, null, null, null, dw.n, "page_destroyed", null, null, d.a.ao.a(new d.m[]{d.s.a("page_type", this.f20738e.d()), d.s.a("page_number", d.c.b.a.b.a(this.f.b()))}), 830, null);     // Catch: Throwable -> L7
        L49:
            cg.a(this.f20736c, this.f20738e, $$Lambda$cg$e$49a5M6qpjhN7yb1ekezuGZa8o4A.INSTANCE);     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L7
        L9:
            e = move-exception;
            if (this.f20735b == false) goto L32;
            cg.b(this.f20736c).c(false);     // Catch: Throwable -> L7
        L40:
            if (this.g.a().a(this.f) == false) goto L42;
            cg.a(this.f20736c, this.f20738e, $$Lambda$cg$e$05yFjUv8Poz4IfDI7gjKmvNBzks.INSTANCE);     // Catch: Throwable -> L7
        L42:
            cl.a("SkillManager", "load discovery skills", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            goto L28
        L32:
            ea r8 = this.f20737d;     // Catch: Throwable -> L7
            if (r8 == null) goto L40;
            dz r14 = dz.f19792b;     // Catch: Throwable -> L7
            dw r16 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            if (this.f20738e.f() == false) goto L37;
            String r9 = "featured_request";
        L38:
            ea.a(r8, r14, null, null, null, null, null, r16, r9, d.c.b.a.b.a(true), null, d.a.ao.a(new d.m[]{d.s.a("page_type", this.f20738e.d()), d.s.a("page_number", d.c.b.a.b.a(this.f.b()))}), 574, null);     // Catch: Throwable -> L7
            goto L40
        L37:
            r9 = "category_request";
            goto L38
        }

        private static final cd a(b r3, cd r4) {
            return new cd(r3.a().a(), false, true, r3.a().b());
        }

        private static final cd a(cd r7) {
            return cd.a(r7, null, false, false, false, 13, null);
        }

        private static final cd b(cd r7) {
            return cd.a(r7, null, false, false, false, 13, null);
        }
    }

    static {
        f20718a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$BzaFftMP6-1yJA9cM63g-BZULQQ, reason: not valid java name */
    public static /* synthetic */ cd m339lambda$BzaFftMP61yJA9cM63gBZULQQ(cd r0) {
        return a(r0);
    }

    public cg() {
        this.f20719b = new ft();
        hd r0 = new hd(null, null, null, 7, null);
        this.f20720c = r0;
        this.f20721d = new ca(r0);
        this.f20722e = new LinkedHashMap();
        bu.c r1 = new bu.c("");
        this.f = r1;
        kotlinx.coroutines.b.x<cf> r2 = kotlinx.coroutines.b.am.a(new cf(d.a.p.a(r1), null, d.a.ao.a(d.s.a(r1.a(), new cd(null, false, false, false, 15, null))), null, null, null, 58, null));
        this.g = r2;
        this.h = kotlinx.coroutines.b.j.a(r2);
    }

    public static final /* synthetic */ ft a(cg r0) {
        return r0.f20719b;
    }

    public static final /* synthetic */ void a(cg r2, bu r3, d.h.a.b r4) {
        r2.a(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(cg r2, kotlinx.coroutines.ca r3) {
        r2.j = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ boolean a(cg r0, com.obric.aiagent.skill.manager.impl.ak r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ca b(cg r0) {
        return r0.f20721d;
    }

    public static final /* synthetic */ void b(cg r2, kotlinx.coroutines.ca r3) {
        r2.k = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ kotlinx.coroutines.b.x c(cg r0) {
        return r0.g;
    }

    public final kotlinx.coroutines.b.ak<cf> b() {
        return this.h;
    }

    public final void a(String r15) {
        d.h.b.o.e(r15, "recommendedTitle");
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        bu.c r0 = new bu.c(r15);
        kotlinx.coroutines.b.x<cf> r16 = this.g;
        r16.b(cf.a((cf) ZeusTransformUtils.preCheckCast(r16.c(), cf.class, "com.obric.aiagent.plugin"), d.a.p.a(r0), null, d.a.ao.a(d.s.a(r0.a(), new cd(null, false, false, false, 15, null))), null, null, null, 58, null));
        a(r0);
        c();
        a((bu) ZeusTransformUtils.preCheckCast(r0, bu.class, "com.obric.aiagent.plugin"));
    }

    public final void a(bu r4) {
        d.h.b.o.e(r4, "channel");
        cd r0 = ((cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin")).a(r4);
        if (r0.c() == false) goto L5;
        return;
    L5:
        if (r0.b() == true) goto L10;
        b(r4);
        return;
    }

    public final void b(bu r22) {
        d.h.b.o.e(r22, "channel");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.f20722e, Map.class, "com.obric.aiagent.plugin");
        String r1 = r22.a();
        Object r3 = r0.get(r1);
        if (r3 != null) goto L5;
        r3 = new b();
        r0.put(r1, r3);
    L5:
        b r9 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        gy r5 = r9.a().d();
        if (r5 != null) goto L8;
        return;
    L8:
        cd r2 = ((cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin")).a(r22);
        if (r2.c() == true) goto L11;
    L14:
        a(r22, $$Lambda$cg$BzaFftMP61yJA9cM63gBZULQQ.INSTANCE);
        boolean r4 = true;
        if (r22.f() == true) goto L17;
    L21:
        r4 = false;
    L22:
        if (r4 == false) goto L24;
        ea r6 = null;
    L25:
        r9.a(kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((androidx.lifecycle.aj) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r4, this, r6, r22, r5, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null));
        return;
    L24:
        r6 = new ea(dy.q, this.f20720c, null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        goto L25
    L17:
        if (r5.b() != 1) goto L21;
        if (this.f20721d.a() == false) goto L21;
    L11:
        if (r2.d() == true) goto L14;
        r9.a().a(r5);
    }

    private static final cd a(cd r8) {
        d.h.b.o.e(r8, "page");
        return cd.a(r8, null, true, false, false, 13, null);
    }

    public final void a(List<com.obric.aiagent.skill.manager.api.e> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "skills");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        Object r2 = r15.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(d.a.ao.a(d.a.p.a(r16, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        Object r1 = r17.next();
        r6.put(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r1);
        goto L10
    L12:
        kotlinx.coroutines.b.x<cf> r11 = this.g;
        r11.b(cf.a((cf) ZeusTransformUtils.preCheckCast(r11.c(), cf.class, "com.obric.aiagent.plugin"), null, null, null, r6, null, null, 55, null));
    }

    public final boolean c(String r13) {
        d.h.b.o.e(r13, "slug");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return false;
    L5:
        cf r3 = (cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin");
        if (r3.e().contains(r13) == false) goto L8;
        return false;
    L8:
        this.g.b(cf.a(r3, null, null, null, null, d.a.ax.b(r3.e(), r13), d.a.ax.a(r3.f(), r13), 15, null));
        return true;
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r11) {
        d.h.b.o.e(r11, "skill");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        cf r1 = (cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin");
        this.g.b(cf.a(r1, null, null, null, d.a.ao.a(r1.d(), d.s.a(r11.a(), r11)), d.a.ax.a(r1.e(), r11.a()), d.a.ax.b(r1.f(), r11.a()), 7, null));
    }

    public final void d(String r11) {
        d.h.b.o.e(r11, "slug");
        cf r1 = (cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin");
        this.g.b(cf.a(r1, null, null, null, null, d.a.ax.a(r1.e(), r11), d.a.ax.a(r1.f(), r11), 15, null));
    }

    public final void e(String r11) {
        d.h.b.o.e(r11, "slug");
        cf r1 = (cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin");
        if (r1.f().contains(r11) == true) goto L5;
        return;
    L5:
        this.g.b(cf.a(r1, null, null, null, null, null, d.a.ax.a(r1.f(), r11), 31, null));
    }

    public final com.obric.aiagent.skill.manager.api.e f(String r3) {
        d.h.b.o.e(r3, "slug");
        return (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin")).d().get(r3), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        this.f20721d.b();
        super.a();
    }

    private final void a(bu.c r9) {
        if (this.j == null) goto L5;
        return;
    L5:
        this.j = kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((androidx.lifecycle.aj) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void c() {
        if (this.k == null) goto L5;
        return;
    L5:
        this.k = kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((androidx.lifecycle.aj) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(bu r11, d.h.a.b<? super cd, cd> r12) {
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        cf r1 = (cf) ZeusTransformUtils.preCheckCast(this.g.c(), cf.class, "com.obric.aiagent.plugin");
        cd r0 = r1.a(r11);
        this.g.b(cf.a(r1, null, null, d.a.ao.a(r1.c(), d.s.a(r11.a(), r13.invoke(r0))), null, null, null, 59, null));
    }

    private final boolean a(com.obric.aiagent.skill.manager.impl.ak r2) {
        if (d.h.b.o.a(r2.a(), "9") == false) goto L5;
        return true;
    L5:
        if (d.o.o.a(r2.c(), "hot", true) == true) goto L10;
        return false;
    L10:
        return true;
    }
}
