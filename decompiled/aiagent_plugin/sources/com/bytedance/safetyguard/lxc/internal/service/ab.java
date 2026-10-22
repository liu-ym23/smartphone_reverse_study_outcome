package com.bytedance.safetyguard.lxc.internal.service;

import android.os.IBinder;
import com.bytedance.safetyguard.lxc.api.OutboundIngressProxy;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyDecision;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.IPolicyResultCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.PolicyDecisionParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ab implements OutboundPolicyEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<List<IOutboundPolicyCallback>> f10929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<IOutboundPolicyCallback, o> f10931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f10932d;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ab$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServiceProxySession.kt */
    static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<IOutboundPolicyCallback, f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10933a = null;

        static {
            f10933a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ f invoke(IOutboundPolicyCallback r3) {
            return a((IOutboundPolicyCallback) ZeusTransformUtils.preCheckCast(r3, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin"));
        }

        public final f a(IOutboundPolicyCallback r2) {
            IOutboundPolicyCallback r1 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r2, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "it");
            return new f(r1);
        }
    }

    public static /* synthetic */ void lambda$6a8v5GeCgXbu3x0nXokYhBuKj18(AtomicReference r0, CountDownLatch r1) {
        a(r0, r1);
    }

    public ab(d.h.a.a<? extends List<? extends IOutboundPolicyCallback>> r3, long r4, d.h.a.b<? super IOutboundPolicyCallback, ? extends o> r6) {
        d.h.a.a<List<IOutboundPolicyCallback>> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<IOutboundPolicyCallback, o> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "callbacksProvider");
        d.h.b.o.e(r7, "endpointFactory");
        this.f10929a = r5;
        this.f10930b = r4;
        this.f10931c = r7;
        this.f10932d = new AtomicLong(1);
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Policy callback timeout must be positive".toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ OutboundPolicyDecision a(ab r0, PolicyDecisionParcel r1, OutboundTarget r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(AtomicReference r2, CountDownLatch r3, p r4) {
        b(r2, r3, (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ ab(d.h.a.a r2, long r3, d.h.a.b r5, int r6, d.h.b.h r7) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 1000;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r8 = (d.h.a.b) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10933a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L8:
        this(r4, r3, r8);
    }

    @Override // com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator
    public OutboundPolicyDecision evaluate(OutboundTarget r11) {
        d.h.b.o.e(r11, "target");
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.f10929a.invoke(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        long r2 = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(this.f10930b);
        boolean r4 = false;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L22;
        IOutboundPolicyCallback r5 = (IOutboundPolicyCallback) ZeusTransformUtils.preCheckCast(r3.next(), IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        long r6 = r2 - System.nanoTime();
        if (r6 <= 0) goto L10;
        OutboundPolicyDecision r7 = a((o) ZeusTransformUtils.preCheckCast(this.f10931c.invoke(r5), o.class, "com.obric.aiagent.plugin"), r11, r6);
        if (d.h.b.o.a(r7, OutboundPolicyDecision.Allow.INSTANCE) == true) goto L6;
        if (d.h.b.o.a(r7, OutboundPolicyDecision.SidecarAuth.INSTANCE) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r7, OutboundPolicyDecision.Deny.class) == false) goto L6;
        return r7;
    L16:
        r4 = true;
    L21:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy callback failed"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L10:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy callback timed out"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L22:
        if (r4 == false) goto L25;
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.SidecarAuth.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L25:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.Allow.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L27:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy snapshot failed"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    }

    private final OutboundPolicyDecision a(o r18, final OutboundTarget r19, long r20) {
        o r10 = (o) ZeusTransformUtils.wrapperContextForParams(r18, o.class, "com.obric.aiagent.plugin");
        if (r10.a() == false) goto L5;
        final long r11 = this.f10932d.getAndIncrement();
        final AtomicReference r13 = new AtomicReference();
        boolean r15 = true;
        final CountDownLatch r14 = new CountDownLatch(1);
        IBinder.DeathRecipient r7 = new $$Lambda$ab$6a8v5GeCgXbu3x0nXokYhBuKj18(r13, r14);
        r10.a(r7);     // Catch: Exception -> L23
    L21:
        IBinder.DeathRecipient r16 = r7;
    L22:
        r15 = true;
    L24:
        b(r13, r14, (p) ZeusTransformUtils.preCheckCast(new p.b("Business policy callback failed"), p.class, "com.obric.aiagent.plugin"));
    L64:
    L33:
        IBinder.DeathRecipient r1 = r16;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L49
        b(r13, r14, (p) ZeusTransformUtils.preCheckCast(new p.b("Business policy callback was interrupted"), p.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L49
        if (r15 == true) goto L30;
    L37:
        p r0 = (p) ZeusTransformUtils.preCheckCast(r13.get(), p.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, p.a.class) == false) goto L41;
        return ((p.a) ZeusTransformUtils.preCheckCast(r0, p.a.class, "com.obric.aiagent.plugin")).a();
    L41:
        if (ZeusTransformUtils.instanceOf(r0, p.b.class) == false) goto L44;
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a(((p.b) ZeusTransformUtils.preCheckCast(r0, p.b.class, "com.obric.aiagent.plugin")).a()), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L44:
        if (r0 != null) goto L48;
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy callback failed"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L48:
        throw new d.k();
    L30:
        r10.b(r1);
    L49:
        th = th;
    L50:
        if (r15 == false) goto L52;
        r10.b(r1);
    L52:
        throw th;
    L31:
        th = th;
        r1 = r16;
        goto L50
    L26:
        if (r14.await(r20, TimeUnit.NANOSECONDS) == true) goto L28;
        b(r13, r14, (p) ZeusTransformUtils.preCheckCast(new p.b("Business policy callback timed out"), p.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31 InterruptedException -> L33
    L28:
        if (r15 == false) goto L37;
        r1 = r16;
        goto L30
    L9:
        if (r10.a() == true) goto L14;
        b(r13, r14, (p) ZeusTransformUtils.preCheckCast(new p.b("Business policy Binder died"), p.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
    L12:
        r16 = r7;
    L14:
        if (r13.get() != null) goto L19;
        r16 = r7;
        r10.a(r11, ae.a(r19), (IPolicyResultCallback) ZeusTransformUtils.preCheckCast(new ServiceOutboundPolicyEvaluator$evaluateOne$1(r11, this, r19, r13, r14), IPolicyResultCallback.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L53
    L20:
        r15 = true;
        goto L64
    L19:
        r16 = r7;
    L23:
        r16 = r7;
        r15 = false;
        goto L24
    L5:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy Binder is dead"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    }

    private static final void b(AtomicReference<p> r2, CountDownLatch r3, p r4) {
        if (r2.compareAndSet(null, (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin")) == false) goto L6;
        r3.countDown();
        return;
    }

    private static final void a(AtomicReference r3, CountDownLatch r4) {
        d.h.b.o.e(r3, "$completion");
        d.h.b.o.e(r4, "$signal");
        b(r3, r4, (p) ZeusTransformUtils.preCheckCast(new p.b("Business policy Binder died"), p.class, "com.obric.aiagent.plugin"));
    }

    private final OutboundPolicyDecision a(PolicyDecisionParcel r4, OutboundTarget r5) {
        int r0 = r4.getDecision();
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L7;
        String r6 = r4.getReason();
        if (r6 != null) goto L22;
        r6 = "Business policy denied";
    L22:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a(r6), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L7:
        if (r0 == 2) goto L10;
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy returned an invalid decision"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L10:
        if (r5.getIngressProxy() != OutboundIngressProxy.SIDECAR_AUTH) goto L21;
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.SidecarAuth.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L21:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(a("Business policy cannot convert ordinary ingress to sidecar auth"), OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    L18:
        return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.Allow.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
    }

    private final OutboundPolicyDecision.Deny a(String r1) {
        return new OutboundPolicyDecision.Deny(r1);
    }
}
