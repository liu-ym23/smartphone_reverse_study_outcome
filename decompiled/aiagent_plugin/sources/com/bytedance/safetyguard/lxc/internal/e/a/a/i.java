package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.l.n;
import d.x;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: OAuthPollingEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<Long> f10324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<Long, d.c.d<? super x>, Object> f10325b;

    /* JADX INFO: compiled from: OAuthPollingEngine.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10326a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.e.a.a.b.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.e.a.a.b.f10301a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.bytedance.safetyguard.lxc.internal.e.a.a.b.f10302b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.bytedance.safetyguard.lxc.internal.e.a.a.b.f10303c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10326a = r0;
        }
    }

    /* JADX INFO: compiled from: OAuthPollingEngine.kt */
    @d.c.b.a.f(b = "OAuthPollingEngine.kt", c = {66}, d = "awaitNextPoll", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.polling.OAuthPollingEngine")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f10329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10330d;

        b(i r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10329c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f10328b = r4;
            this.f10330d |= Integer.MIN_VALUE;
            return i.a(this.f10329c, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OAuthPollingEngine.kt */
    @d.c.b.a.f(b = "OAuthPollingEngine.kt", c = {24, 27}, d = "run", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.polling.OAuthPollingEngine")
    static final class c<S, P, R> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f10335e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ i h;
        int i;

        c(i r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public i(d.h.a.a<Long> r3, m<? super Long, ? super d.c.d<? super x>, ? extends Object> r4) {
        d.h.a.a<Long> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        m<Long, d.c.d<? super x>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "monotonicMillis");
        o.e(r6, "delayMillis");
        this.f10324a = r5;
        this.f10325b = r6;
    }

    public static final /* synthetic */ Object a(i r2, g r3, long r4, d.c.d r6) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.safetyguard.lxc.internal.e.a.a.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.safetyguard.lxc.internal.e.a.a.i] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17, types: [com.bytedance.safetyguard.lxc.internal.e.a.a.h] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.safetyguard.lxc.internal.e.a.a.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.bytedance.safetyguard.lxc.internal.e.a.a.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.safetyguard.lxc.internal.e.a.a.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x014b -> B:36:0x0155). Please report as a decompilation issue!!! */
    public final <S, P, R> Object a(S r22, d r23, h<S, P, R> r24, d.c.d<? super R> r25) {
        i r0 = this;
        h r2 = (h) ZeusTransformUtils.wrapperContextForParams(r24, h.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.g;
        Object r7 = d.c.a.b.a();
        int r8 = r5.i;
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L18;
        long r10 = r5.f;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r5.f10335e, g.class, "com.obric.aiagent.plugin");
        Object r3 = r5.f10334d;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r5.f10333c, d.class, "com.obric.aiagent.plugin");
        h r12 = (h) ZeusTransformUtils.preCheckCast(r5.f10332b, h.class, "com.obric.aiagent.plugin");
        i r11 = (i) ZeusTransformUtils.preCheckCast(r5.f10331a, i.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: CancellationException -> L15
        g r13 = r1;
        ?? r14 = r11;
        Object r15 = r3;
        d r16 = r9;
        Object r17 = r7;
        c r18 = r5;
        ?? r19 = r12;
    L36:
        com.bytedance.safetyguard.lxc.internal.e.a.a.c r20 = (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(r6, com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L15
        g r21 = g.a(r13, 0, r13.b() + 1, false, 5, null);
        if (ZeusTransformUtils.instanceOf(r20, com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c.class) == false) goto L42;
        r21 = r14.a(r21, r16.d());
    L40:
        ?? r26 = r19;
        ?? r27 = r14;
    L26:
        if (r27.a(r21, r16, r10) == false) goto L60;
        r18.f10331a = r27;
        r18.f10332b = r26;
        r18.f10333c = r16;
        r18.f10334d = r15;
        r18.f10335e = null;
        r18.f = r10;
        r18.i = 1;
        Object r28 = r27.a(r21, r10, r18);
        if (r28 != r17) goto L30;
        return r17;
    L30:
        Object r110 = r15;
        ?? r29 = r27;
        Object r30 = r110;
        Object r210 = r17;
        ?? r31 = r26;
        r6 = r28;
        r5 = r18;
        r7 = r210;
    L31:
        g r32 = (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin");
        r29.a(r10, r31);
        long r111 = r10 - ((Number) ZeusTransformUtils.preCheckCast(r29.f10324a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: CancellationException -> L15
        r5.f10331a = r29;     // Catch: CancellationException -> L15
        r5.f10332b = r31;     // Catch: CancellationException -> L15
        r5.f10333c = r16;     // Catch: CancellationException -> L15
        r5.f10334d = r30;     // Catch: CancellationException -> L15
        r5.f10335e = r32;     // Catch: CancellationException -> L15
        r5.f = r10;     // Catch: CancellationException -> L15
        r5.i = 2;     // Catch: CancellationException -> L15
        Object r112 = r31.a(r30, r111, r5);     // Catch: CancellationException -> L15
        if (r112 != r7) goto L35;
        return r7;
    L35:
        r13 = r32;
        r6 = r112;
        r19 = r31;
        r17 = r7;
        r18 = r5;
        ?? r113 = r29;
        r15 = r30;
        r14 = r113;
        goto L36
    L60:
        throw r26.a();
    L42:
        if (ZeusTransformUtils.instanceOf(r20, com.bytedance.safetyguard.lxc.internal.e.a.a.c.a.class) == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r20, com.bytedance.safetyguard.lxc.internal.e.a.a.c.b.class) == false) goto L40;
        e r33 = r19.a(r15, ((com.bytedance.safetyguard.lxc.internal.e.a.a.c.b) ZeusTransformUtils.preCheckCast(r20, com.bytedance.safetyguard.lxc.internal.e.a.a.c.b.class, "com.obric.aiagent.plugin")).a());
        if (ZeusTransformUtils.instanceOf(r33, e.a.class) == false) goto L50;
        return ((e.a) ZeusTransformUtils.preCheckCast(r33, e.a.class, "com.obric.aiagent.plugin")).a();
    L50:
        if (ZeusTransformUtils.instanceOf(r33, e.c.class) == true) goto L55;
        if (ZeusTransformUtils.instanceOf(r33, e.b.class) == false) goto L40;
        r15 = ((e.b) ZeusTransformUtils.preCheckCast(r33, e.b.class, "com.obric.aiagent.plugin")).a();
        r21 = r14.a(r21, ((e.b) ZeusTransformUtils.preCheckCast(r33, e.b.class, "com.obric.aiagent.plugin")).b(), r16.d());
        goto L40
    L55:
        throw ((e.c) ZeusTransformUtils.preCheckCast(r33, e.c.class, "com.obric.aiagent.plugin")).a();
    L57:
        throw ((com.bytedance.safetyguard.lxc.internal.e.a.a.c.a) ZeusTransformUtils.preCheckCast(r20, com.bytedance.safetyguard.lxc.internal.e.a.a.c.a.class, "com.obric.aiagent.plugin")).a();
    L15:
        e = move-exception;
        throw e;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r10 = r5.f;
        r30 = r5.f10334d;
        r16 = (d) ZeusTransformUtils.preCheckCast(r5.f10333c, d.class, "com.obric.aiagent.plugin");
        h r34 = (h) ZeusTransformUtils.preCheckCast(r5.f10332b, h.class, "com.obric.aiagent.plugin");
        i r35 = (i) ZeusTransformUtils.preCheckCast(r5.f10331a, i.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        r29 = r35;
        r31 = r34;
        goto L31
    L20:
        d.o.a(r6);
        d r36 = r23.f();
        r10 = ((Number) ZeusTransformUtils.preCheckCast(r0.f10324a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() + (((long) r36.b()) * 1000);
        int r37 = r36.a();
        if (r36.c() != com.bytedance.safetyguard.lxc.internal.e.a.a.a.f10298b) goto L23;
        boolean r114 = true;
    L24:
        g r38 = new g(r37, 0, r114);
        r17 = r7;
        r18 = r5;
        r21 = r38;
        r26 = r2;
        r16 = r36;
        r15 = r22;
        r27 = r0;
        goto L26
    L23:
        r114 = false;
    L7:
        r5 = new c(r0, r4);
        goto L8
    }

    private final <S, P, R> void a(long r3, h<S, P, R> r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.aiagent.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(this.f10324a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() >= r3) goto L6;
        return;
    L6:
        throw r6.a();
    }

    private final boolean a(g r3, d r4, long r5) {
        if (((Number) ZeusTransformUtils.preCheckCast(this.f10324a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() < r5) goto L5;
    L9:
        return false;
    L5:
        if (r4.e() != null) goto L7;
    L8:
        return true;
    L7:
        if (r3.b() >= r4.e().intValue()) goto L9;
        goto L8
    }

    private final Object a(g r12, long r13, d.c.d<? super g> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r16, b.class, "com.obric.aiagent.plugin");
        if ((r0.f10330d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10330d -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f10328b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10330d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        g r14 = (g) ZeusTransformUtils.preCheckCast(r0.f10327a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        if (r12.c() == false) goto L17;
        long r18 = r13 - ((Number) ZeusTransformUtils.preCheckCast(this.f10324a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r18 > 0) goto L21;
        return r12;
    L21:
        m<Long, d.c.d<? super x>, Object> r11 = this.f10325b;
        Long r19 = d.c.b.a.b.a(Math.min(((long) r12.a()) * 1000, r18));
        r0.f10327a = r12;
        r0.f10330d = 1;
        if (r11.invoke(r19, r0) != r2) goto L25;
        return r2;
    L25:
        return r12;
    L17:
        return g.a(r12, 0, 0, true, 3, null);
    L7:
        r0 = new b(this, r16);
        goto L8
    }

    private final g a(g r7, int r8) {
        return g.a(r7, n.d(r7.a() + 1, r8), 0, true, 2, null);
    }

    private final g a(g r7, com.bytedance.safetyguard.lxc.internal.e.a.a.b r8, int r9) {
        int r6 = a.f10326a[r8.ordinal()];
        if (r6 == 1) goto L13;
        if (r6 == 2) goto L15;
        if (r6 != 3) goto L10;
        return g.a(r7, n.d(r7.a() + 5, r9), 0, true, 2, null);
    L10:
        throw new k();
    L15:
        return g.a(r7, 0, 0, false, 3, null);
    L13:
        return g.a(r7, 0, 0, true, 3, null);
    }
}
