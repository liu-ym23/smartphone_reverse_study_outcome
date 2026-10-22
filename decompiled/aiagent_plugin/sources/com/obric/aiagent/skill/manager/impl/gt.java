package com.obric.aiagent.skill.manager.impl;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> f20031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> f20032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> f20033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.am f20034e;
    private final hd f;
    private final Object g;
    private final LinkedHashMap<String, kotlinx.coroutines.au<gw>> h;
    private final kotlinx.coroutines.f.d i;

    /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
    @d.c.b.a.f(b = "SkillStoreMetadataRefreshCoordinator.kt", c = {265}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillStoreMetadataRefreshCoordinator$awaitSharedRefresh$request$1$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super gw>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f20036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f20037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f20038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ gt f20039e;
        final /* synthetic */ String f;

        b(gt r3, String r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20039e = r3;
            this.f = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super gw> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f20039e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super gw> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20038d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) ZeusTransformUtils.preCheckCast(this.f20037c, String.class, "com.obric.aiagent.plugin");
            gt r3 = (gt) ZeusTransformUtils.preCheckCast(this.f20036b, gt.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.d r6 = (kotlinx.coroutines.f.d) ZeusTransformUtils.preCheckCast(this.f20035a, kotlinx.coroutines.f.d.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
        L18:
            gw r8 = gt.a(r3, r2);     // Catch: Throwable -> L15
            r6.c();
            return r8;
        L15:
            th = move-exception;
            r6.c();
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.f.d r9 = gt.a(this.f20039e);
            r3 = this.f20039e;
            String r4 = this.f;
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20035a = r9;
            this.f20036b = r3;
            this.f20037c = r4;
            this.f20038d = 1;
            if (r9.a(r5) != r0) goto L11;
            return r0;
        L11:
            r6 = r9;
            r2 = r4;
            goto L18
        }
    }

    /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
    @d.c.b.a.f(b = "SkillStoreMetadataRefreshCoordinator.kt", c = {67}, d = "refresh", e = "com.obric.aiagent.skill.manager.impl.SkillStoreMetadataRefreshCoordinator")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f20040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ gt f20041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20042c;

        c(gt r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20041b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f20040a = r3;
            this.f20042c |= Integer.MIN_VALUE;
            return this.f20041b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f20043a = null;

        static {
            f20043a = new d();
        }

        d() {
            super(1, d.o.o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
        }

        public final String a(String r2) {
            d.h.b.o.e(r2, "p0");
            return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f20044a = null;

        static {
            f20044a = new e();
        }

        e() {
            super(1, d.o.o.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r1 = true;
        L7:
            return Boolean.valueOf(r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
    @d.c.b.a.f(b = "SkillStoreMetadataRefreshCoordinator.kt", c = {70}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillStoreMetadataRefreshCoordinator$refresh$results$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends gw>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f20046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ gt f20047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f20048d;

        /* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
        @d.c.b.a.f(b = "SkillStoreMetadataRefreshCoordinator.kt", c = {69}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillStoreMetadataRefreshCoordinator$refresh$results$1$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super gw>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20049a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ gt f20050b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20051c;

            a(gt r3, String r4, d.c.d<? super a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20050b = r3;
                this.f20051c = r4;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super gw> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20050b, this.f20051c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super gw> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20049a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                gt r7 = this.f20050b;
                String r2 = this.f20051c;
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20049a = 1;
                r6 = gt.a(r7, r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        f(List<String> r3, gt r4, d.c.d<? super f> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20046b = r6;
            this.f20047c = r4;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<gw>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f20046b, this.f20047c, r6);
            r0.f20048d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends gw>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20045a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r13);
        L15:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            kotlinx.coroutines.am r14 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f20048d, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f20046b, Iterable.class, "com.obric.aiagent.plugin");
            gt r10 = this.f20047c;
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            r11.add(kotlinx.coroutines.i.b(r14, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null));
            goto L10
        L12:
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20045a = 1;
            r13 = kotlinx.coroutines.f.a(r15, r4);
            if (r13 != r0) goto L15;
            return r0;
        }
    }

    static {
        f20030a = new a(null);
    }

    public static /* synthetic */ d.x lambda$dh8YslqQH5FjPH1ZxmdjI91W4A0(gt r0, String r1, kotlinx.coroutines.au r2, Throwable r3) {
        return a(r0, r1, r2, r3);
    }

    public gt(d.h.a.b<? super String, com.obric.aiagent.skill.manager.api.e> r3, d.h.a.b<? super String, com.obric.aiagent.skill.manager.api.e> r4, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r5, int r6, kotlinx.coroutines.am r7, hd r8) {
        d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r12 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "findInstalledSkill");
        d.h.b.o.e(r10, "loadRemotePresentation");
        d.h.b.o.e(r11, "persistPresentation");
        d.h.b.o.e(r12, "refreshScope");
        d.h.b.o.e(r8, "trackingReporter");
        this.f20031b = r9;
        this.f20032c = r10;
        this.f20033d = r11;
        this.f20034e = r12;
        this.f = r8;
        this.g = new Object();
        this.h = new LinkedHashMap();
        this.i = kotlinx.coroutines.f.f.a(r6, 0, 2, null);
    }

    public static final /* synthetic */ gw a(gt r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(gt r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.f.d a(gt r0) {
        return r0.i;
    }

    public /* synthetic */ gt(d.h.a.b r12, d.h.a.b r13, d.h.a.b r14, int r15, kotlinx.coroutines.am r16, hd r17, int r18, d.h.b.h r19) {
        d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r4 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r16, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        if ((r18 & 8) == 0) goto L5;
        int r5 = 4;
    L7:
        if ((r18 & 16) == 0) goto L9;
        kotlinx.coroutines.am r1 = kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L11:
        if ((r18 & 32) == 0) goto L13;
        hd r6 = new hd(null, null, null, 7, null);
    L14:
        this(r0, r2, r3, r5, r1, r6);
        return;
    L13:
        r6 = r17;
        goto L14
    L9:
        r1 = r4;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public final Object a(Set<String> r6, d.c.d<? super gx> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f20042c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f20042c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f20040a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f20042c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
    L18:
        return new gx((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(d.n.m.g(d.n.m.f(d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f20043a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f20044a, d.h.a.b.class, "com.obric.aiagent.plugin"))))), this, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f20042c = 1;
        r10 = kotlinx.coroutines.an.a(r5, r0);
        if (r10 != r2) goto L18;
        return r2;
    L7:
        r0 = new c(this, r9);
        goto L8
    }

    private final Object a(final String r9, d.c.d<? super gw> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        Object r0 = this.g;
        monitor-enter(r0);
        final kotlinx.coroutines.au r1 = (kotlinx.coroutines.au) ZeusTransformUtils.preCheckCast(this.h.get(r9), kotlinx.coroutines.au.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
    L11:
        r1 = kotlinx.coroutines.i.b(this.f20034e, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L15
        ((Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.aiagent.plugin")).put(r9, r1);     // Catch: Throwable -> L15
        r1.a_(new $$Lambda$gt$dh8YslqQH5FjPH1ZxmdjI91W4A0(this, r9, r1));     // Catch: Throwable -> L15
    L12:
        monitor-exit(r0);
        return r1.a(r11);
    L7:
        if (r1.b() == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
    L15:
        th = move-exception;
        throw th;
    }

    private static final d.x a(gt r1, String r2, kotlinx.coroutines.au r3, Throwable r4) {
        kotlinx.coroutines.au<gw> r5 = (kotlinx.coroutines.au) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.au.class, "com.obric.aiagent.plugin");
        Object r6 = r1.g;
        monitor-enter(r6);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r1.h.get(r2) != r5) goto L7;
        r1.h.remove(r2);     // Catch: Throwable -> L11
    L7:
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r6);
        return d.x.f38692a;
    }

    private final gw a(String r26) {
        ea r19 = new ea(dy.r, this.f, null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        com.obric.aiagent.skill.manager.api.e r15 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20031b.invoke(r26), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L59 CancellationException -> L62
        if (r15 != null) goto L8;
        return a(r26, gv.f20054c);
    L8:
        if (ZeusTransformUtils.instanceOf(r15.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L10;
        com.obric.aiagent.skill.manager.api.e r5 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20032c.invoke(r26), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L53 CancellationException -> L56
    L13:
        if (r5 != null) goto L17;
        gt r0 = (gt) ZeusTransformUtils.preCheckCast(this, gt.class, "com.obric.aiagent.plugin");
        ea.a(r19, dz.f19792b, r15, null, null, null, null, dw.f19777b, "remote_presentation", true, null, d.a.ao.a(d.s.a("business_result", "not_found")), 572, null);
        return r0.a(r26, gv.f20055d);
    L17:
        if (d.h.b.o.a(r5.a(), r26) == true) goto L19;
    L51:
        ee.f19808a.c("SkillManager", "Store Skill presentation refresh response rejected", "Store Skill presentation refresh response rejected: slug=" + r26 + ", remoteSlug=" + r5.a() + ", source=" + r5.g());
        ea.a(r19, dz.f19792b, r15, null, null, null, null, dw.f19776a, "response_validate", false, null, null, 1596, null);
        return a(r26, gv.f20056e);
    L19:
        if (ZeusTransformUtils.instanceOf(r5.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L51;
        com.obric.aiagent.skill.manager.api.e r7 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20033d.invoke(r5), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L43 CancellationException -> L47
        if (r7 != null) goto L32;
        gt r1 = (gt) ZeusTransformUtils.preCheckCast(this, gt.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L43 CancellationException -> L47
        ea.a(r19, dz.f19793c, r15, null, null, null, null, dw.f19777b, "presentation_persist", false, null, d.a.ao.a(d.s.a("business_result", "local_state_changed")), 572, null);     // Catch: Exception -> L27 CancellationException -> L29
        return r1.a(r26, gv.f20054c);
    L29:
        e = e;
        com.obric.aiagent.skill.manager.api.e r24 = r15;
    L49:
        ea.a(r19, dz.f19793c, r24, null, null, null, null, dw.n, "presentation_persist", null, null, null, 1852, null);
        throw e;
    L27:
        e = e;
        r24 = r15;
    L45:
        ee.f19808a.a("SkillManager", "Store Skill presentation refresh persistence failed", "Store Skill presentation refresh persistence failed: slug=" + r26, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        ea.a(r19, dz.f19792b, r24, null, null, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "presentation_persist", true, null, null, 1596, null);
        return a(r26, gv.f20056e);
    L32:
        if (d.h.b.o.a(r7, r15) == false) goto L34;
        gv r2 = gv.f20053b;     // Catch: Exception -> L43 CancellationException -> L47
    L35:
        dz r8 = dz.f19791a;     // Catch: Exception -> L43 CancellationException -> L47
        String r6 = r2.name().toLowerCase(Locale.ROOT);     // Catch: Exception -> L43 CancellationException -> L47
        d.h.b.o.c(r6, "toLowerCase(...)");     // Catch: Exception -> L43 CancellationException -> L47
        r24 = r15;
        ea.a(r19, r8, r7, null, null, null, null, null, null, null, null, d.a.ao.a(d.s.a("business_result", r6)), DownloadErrorCode.ERROR_THREAD_INTERRUPT, null);     // Catch: Exception -> L39 CancellationException -> L41
    L74:
        return a(r26, r2);
    L41:
        e = e;
    L39:
        e = e;
        goto L45
    L34:
        r2 = gv.f20052a;     // Catch: Exception -> L43 CancellationException -> L47
    L47:
        e = e;
        r24 = r15;
    L43:
        e = e;
        r24 = r15;
    L56:
        e = move-exception;
        ea.a(r19, dz.f19793c, r15, null, null, null, null, dw.n, "remote_presentation", null, null, null, 1852, null);
        throw e;
    L53:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Store Skill presentation search failed", "Store Skill presentation search failed: slug=" + r26, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        ea.a(r19, dz.f19792b, r15, null, null, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "remote_presentation", true, null, null, 1596, null);
        return a(r26, gv.f20056e);
    L10:
        return a(r26, gv.f20054c);
    L62:
        e = move-exception;
        ea.a(r19, dz.f19793c, null, r26, null, null, null, dw.n, "installed_lookup", null, null, null, 1850, null);
        throw e;
    L59:
        e = move-exception;
        ea.a(r19, dz.f19792b, null, r26, null, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "installed_lookup", true, null, null, 1594, null);
        throw e;
    }

    private final gw a(String r1, gv r2) {
        return new gw(r1, r2);
    }
}
