package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20896a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<b> f20897c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.m<Long, d.c.d<? super d.x>, Object> f20898b;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.y$1, reason: invalid class name */
    /* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
    @d.c.b.a.f(b = "SkillDetailInstallProgressRunner.kt", c = {12}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailInstallProgressRunner$1")
    static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<Long, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ long f20900b;

        AnonymousClass1(d.c.d<? super AnonymousClass1> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(long r3, d.c.d<? super d.x> r5) {
            d.c.d<?> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Long.valueOf(r3), r6), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            AnonymousClass1 r4 = new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f20900b = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue();
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Long r5, d.c.d<? super d.x> r6) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20899a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            long r3 = this.f20900b;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20899a = 1;
            if (kotlinx.coroutines.ax.a(r3, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final List<b> a() {
            return y.b();
        }
    }

    /* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f20901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20902b;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f20901a == r10.f20901a) goto L12;
            return false;
        L12:
            if (this.f20902b == r10.f20902b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f20901a) * 31) + Integer.hashCode(this.f20902b);
        }

        public String toString() {
            return "ProgressStage(delayMillis=" + this.f20901a + ", progress=" + this.f20902b + ')';
        }

        public b(long r1, int r3) {
            this.f20901a = r1;
            this.f20902b = r3;
        }

        public final long a() {
            return this.f20901a;
        }

        public final int b() {
            return this.f20902b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
    @d.c.b.a.f(b = "SkillDetailInstallProgressRunner.kt", c = {33, 35, 35}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailInstallProgressRunner$run$2")
    static final class c<T> extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Integer, d.x> f20904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.c.d<? super T>, Object> f20905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f20906d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f20907e;

        /* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
        @d.c.b.a.f(b = "SkillDetailInstallProgressRunner.kt", c = {24}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailInstallProgressRunner$run$2$fakeProgress$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f20908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f20909b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f20910c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f20911d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f20912e;
            final /* synthetic */ y f;
            final /* synthetic */ d.h.a.b<Integer, d.x> g;

            a(y r3, d.h.a.b<? super Integer, d.x> r4, d.c.d<? super a> r5) {
                d.h.a.b<Integer, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                this.g = r6;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f, this.g, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x008c -> B:14:0x008f). Please report as a decompilation issue!!! */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20912e;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                b r2 = (b) ZeusTransformUtils.preCheckCast(this.f20911d, b.class, "com.obric.aiagent.plugin");
                Iterator<T> r4 = (Iterator) ZeusTransformUtils.preCheckCast(this.f20910c, Iterator.class, "com.obric.aiagent.plugin");
                d.h.a.b<Integer, d.x> r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(this.f20909b, d.h.a.b.class, "com.obric.aiagent.plugin");
                y r6 = (y) ZeusTransformUtils.preCheckCast(this.f20908a, y.class, "com.obric.aiagent.plugin");
                d.o.a(r10);
            L14:
                r5.invoke(d.c.b.a.b.a(r2.b()));
            L10:
                if (r4.hasNext() == false) goto L16;
                r2 = (b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.aiagent.plugin");
                d.h.a.m r11 = y.a(r6);
                Long r7 = d.c.b.a.b.a(r2.a());
                this.f20908a = r6;
                this.f20909b = r5;
                this.f20910c = r4;
                this.f20911d = r2;
                this.f20912e = 1;
                if (r11.invoke(r7, this) != r0) goto L14;
                return r0;
            L16:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r10);
                Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(y.a().a(), Iterable.class, "com.obric.aiagent.plugin");
                y r3 = this.f;
                d.h.a.b<Integer, d.x> r8 = this.g;
                r6 = r3;
                r5 = r8;
                r4 = r12.iterator();
                goto L10
            }
        }

        /* JADX INFO: compiled from: SkillDetailInstallProgressRunner.kt */
        @d.c.b.a.f(b = "SkillDetailInstallProgressRunner.kt", c = {20}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailInstallProgressRunner$run$2$realInstall$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20913a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<d.c.d<? super T>, Object> f20914b;

            b(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r3, d.c.d<? super b> r4) {
                d.h.a.b<d.c.d<? super T>, Object> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20914b = r5;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super T> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f20914b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, Object r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20913a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r4);
                d.h.a.b<d.c.d<? super T>, Object> r5 = this.f20914b;
                this.f20913a = 1;
                r4 = r5.invoke(this);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        c(d.h.a.b<? super Integer, d.x> r3, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r4, y r5, d.c.d<? super c> r6) {
            d.h.a.b<Integer, d.x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.a.b<d.c.d<? super T>, Object> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20904b = r7;
            this.f20905c = r8;
            this.f20906d = r5;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super T> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f20904b, this.f20905c, this.f20906d, r7);
            r0.f20907e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, Object r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20903a;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L8;
            Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(this.f20907e, Throwable.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
            throw r14;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            Object r2 = this.f20907e;
            d.o.a(r15);
        L27:
            this.f20904b.invoke(d.c.b.a.b.a(100));
            return r2;
        L11:
            kotlinx.coroutines.ca r3 = (kotlinx.coroutines.ca) ZeusTransformUtils.preCheckCast(this.f20907e, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
            d.o.a(r15);     // Catch: Throwable -> L14
        L23:
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20907e = r15;
            this.f20903a = 2;
            if (kotlinx.coroutines.ce.a(r3, r4) != r0) goto L26;
            return r0;
        L26:
            r2 = r15;
        L14:
            th = move-exception;
            th = th;
            kotlinx.coroutines.ca r16 = r3;
        L30:
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20907e = th;
            this.f20903a = 3;
            if (kotlinx.coroutines.ce.a(r16, r5) != r0) goto L34;
            return r0;
        L34:
            throw th;
        L16:
            d.o.a(r15);
            kotlinx.coroutines.am r17 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f20907e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.au r6 = kotlinx.coroutines.i.b(r17, null, kotlinx.coroutines.ao.f38854d, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f20905c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
            r16 = kotlinx.coroutines.i.a(r17, null, kotlinx.coroutines.ao.f38852b, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20906d, this.f20904b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
            if (r6.i() == true) goto L35;
            r16.s_();
        L35:
            d.c.d<? super T> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
            this.f20907e = r16;     // Catch: Throwable -> L29
            this.f20903a = 1;     // Catch: Throwable -> L29
            Object r8 = r6.a(r7);     // Catch: Throwable -> L29
            if (r8 != r0) goto L22;
            return r0;
        L22:
            r3 = r16;
            r15 = r8;
        L29:
            th = th;
            goto L30
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public y(d.h.a.m<? super Long, ? super d.c.d<? super d.x>, ? extends Object> r3) {
        d.h.a.m<Long, d.c.d<? super d.x>, Object> r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "wait");
        this.f20898b = r4;
    }

    public static final /* synthetic */ a a() {
        return f20896a;
    }

    public static final /* synthetic */ d.h.a.m a(y r0) {
        return r0.f20898b;
    }

    public static final /* synthetic */ List b() {
        return f20897c;
    }

    public /* synthetic */ y(d.h.a.m r2, int r3, d.h.b.h r4) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), d.h.a.m.class, "com.obric.aiagent.plugin");
    L5:
        this(r5);
    }

    public final <T> Object a(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r4, d.h.a.b<? super Integer, d.x> r5, d.c.d<? super T> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r8, r7, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
    }

    static {
        f20896a = new a(null);
        f20897c = d.a.p.b(new b[]{new b(200, 10), new b(250, 25), new b(300, 45), new b(350, 65), new b(400, 80), new b(500, 90)});
    }
}
