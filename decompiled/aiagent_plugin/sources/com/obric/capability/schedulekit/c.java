package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.h;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: ExecuteResultManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f31892a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, d.h.a.b<JobResultWrapper, x>> f31893b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f31894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ExecuteResultManager$resultReceiver$1 f31895d = null;

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExecuteResultManager.kt */
    static final class AnonymousClass1 extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f31896a = null;

        static {
            f31896a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            c r0 = c.f31892a;
            c.a(true);
        }
    }

    /* JADX INFO: compiled from: ExecuteResultManager.kt */
    @d.c.b.a.f(b = "ExecuteResultManager.kt", c = {71}, d = "getResultWithTimeout", e = "com.obric.capability.schedulekit.ExecuteResultManager")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f31897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f31899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31900d;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31899c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f31898b = r7;
            this.f31900d |= Integer.MIN_VALUE;
            return this.f31899c.a(0, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecuteResultManager.kt */
    @d.c.b.a.f(b = "ExecuteResultManager.kt", c = {82}, d = "invokeSuspend", e = "com.obric.capability.schedulekit.ExecuteResultManager$getResultWithTimeout$result$1")
    static final class b extends l implements m<am, d.c.d<? super JobResultWrapper>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f31901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f31903c;

        /* JADX INFO: compiled from: ExecuteResultManager.kt */
        static final class a extends p implements d.h.a.b<JobResultWrapper, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n<JobResultWrapper> f31904a;

            a(n<? super JobResultWrapper> r3) {
                this.f31904a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(JobResultWrapper r3) {
                a((JobResultWrapper) ZeusTransformUtils.preCheckCast(r3, JobResultWrapper.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(JobResultWrapper r3) {
                o.e(r3, "resp");
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f31904a, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r0 = d.n.f38560a;
                r2.resumeWith(d.n.f(r3));
            }
        }

        b(long r3, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31903c = r3;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super JobResultWrapper> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f31903c, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super JobResultWrapper> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31902b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L13:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            long r3 = this.f31903c;
            this.f31901a = r3;
            this.f31902b = 1;
            kotlinx.coroutines.o r5 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r5.e();
            n r8 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
            Long r2 = d.c.b.a.b.a(r3);
            ((Map) ZeusTransformUtils.preCheckCast(c.a(), Map.class, "com.obric.aiagent.plugin")).put(r2, new a(r8));
            r7 = r5.h();
            if (r7 != d.c.a.b.a()) goto L11;
            h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L11:
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    private c() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f31893b;
    }

    public static final /* synthetic */ void a(boolean r0) {
        f31894c = r0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.capability.schedulekit.ExecuteResultManager$resultReceiver$1, java.lang.Object] */
    static {
        f31892a = new c();
        f31893b = new ConcurrentHashMap();
        ?? r0 = new ExecuteResultManager$resultReceiver$1();
        f31895d = r0;
        com.obric.capability.schedulekit.a.f31846a.a((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r0, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin"));
        com.obric.capability.schedulekit.a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f31896a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(long r6, long r8, d.c.d<? super JobResultWrapper> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if ((r0.f31900d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31900d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f31898b;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f31900d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = r0.f31897a;
        d.o.a(r5);
    L20:
        JobResultWrapper r7 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r5, JobResultWrapper.class, "com.obric.aiagent.plugin");
        f31893b.remove(d.c.b.a.b.a(r6));
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        if (f31894c == false) goto L17;
        f31894c = false;
        com.obric.capability.schedulekit.a.f31846a.a((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(f31895d, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin"));
    L17:
        m r9 = (m) ZeusTransformUtils.preCheckCast(new b(r6, null), m.class, "com.obric.aiagent.plugin");
        r0.f31897a = r6;
        r0.f31900d = 1;
        r5 = dg.b(r8, r9, r0);
        if (r5 != r12) goto L20;
        return r12;
    L7:
        r0 = new a(this, r11);
        goto L8
    }
}
