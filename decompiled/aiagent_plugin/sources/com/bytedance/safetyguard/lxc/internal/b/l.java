package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.safetyguard.lxc.api.OutboundPolicyDecision;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f9768a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f9769d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f9770e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f9771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f9772c;

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public l(i r2) {
        d.h.b.o.e(r2, "config");
        this.f9771b = r2;
        this.f9772c = new Object();
    }

    public /* synthetic */ l(i r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = i.f9754a.a();
    L5:
        this(r1);
    }

    public final m a(com.bytedance.safetyguard.lxc.internal.c.m r5, byte[] r6, int r7, com.bytedance.safetyguard.lxc.internal.c.c r8, OutboundPolicyEvaluator r9) {
        OutboundPolicyEvaluator r10 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r9, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "targetType");
        d.h.b.o.e(r6, "addressBytes");
        d.h.b.o.e(r8, "ingressProxy");
        d.h.b.o.e(r10, "businessPolicy");
        if (r8 == com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L5;
    L11:
        boolean r0 = false;
    L46:
        s r2 = s.f9797a;     // Catch: t -> L43
        u r3 = u.f9803a;     // Catch: t -> L43
        if (r0 == false) goto L15;
        r5 = com.bytedance.safetyguard.lxc.internal.c.m.f9854c;     // Catch: t -> L43
    L15:
        if (r0 == false) goto L17;
        r6 = f9769d;     // Catch: t -> L43
    L17:
        g r11 = r2.a(r3.a(r5, r6, r7));     // Catch: t -> L43
        if (r8 == com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L21;
    L24:
        h r12 = this.f9771b.a(r11);
        if (r12 == null) goto L29;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.b("Outbound restriction denied: " + r12)), m.class, "com.obric.aiagent.plugin");
    L29:
        if (ZeusTransformUtils.instanceOf(r11, g.a.class) == false) goto L32;
        return (m) ZeusTransformUtils.preCheckCast(new m.c((g.a) ZeusTransformUtils.preCheckCast(r11, g.a.class, "com.obric.aiagent.plugin"), r8, this.f9772c), m.class, "com.obric.aiagent.plugin");
    L32:
        if (ZeusTransformUtils.instanceOf(r11, g.b.class) == false) goto L42;
        if (r8 == com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L49;
        c r13 = d.f9735a.a(((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).d());
        if (r13.c() == false) goto L40;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(a(r13)), m.class, "com.obric.aiagent.plugin");
    L40:
        return a(q.f9787a.a(r11, d.a.p.a(((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).c())), r8, r10);
    L49:
        return a(q.f9787a.a(r11, d.a.p.a(((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).c())), r8, r10);
    L42:
        throw new d.k();
    L21:
        if (a(r11) == true) goto L24;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.a("SIDECAR_AUTH target must be IPV4 127.0.0.1:16384")), m.class, "com.obric.aiagent.plugin");
    L43:
        e = move-exception;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.a(e.getMessage())), m.class, "com.obric.aiagent.plugin");
    L5:
        if (r5 != com.bytedance.safetyguard.lxc.internal.c.m.f9853b) goto L11;
        if (r7 != 16384) goto L11;
        if (Arrays.equals(r6, f9770e) == false) goto L11;
        r0 = true;
        goto L46
    }

    public final m a(m.c r5, List<? extends InetAddress> r6, OutboundPolicyEvaluator r7) {
        List<? extends InetAddress> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        OutboundPolicyEvaluator r9 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r7, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "pending");
        d.h.b.o.e(r8, "addresses");
        d.h.b.o.e(r9, "businessPolicy");
        if (r5.c() == this.f9772c) goto L7;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.b("DNS continuation belongs to another pipeline")), m.class, "com.obric.aiagent.plugin");
    L7:
        if (r8.isEmpty() == true) goto L9;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r0.hasNext() == false) goto L18;
        InetAddress r2 = (InetAddress) ZeusTransformUtils.preCheckCast(r0.next(), InetAddress.class, "com.obric.aiagent.plugin");
        c r3 = d.f9735a.a(r2);
        if (r3.c() == false) goto L12;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(a(r3)), m.class, "com.obric.aiagent.plugin");
    L18:
        return a(q.f9787a.a((g) ZeusTransformUtils.preCheckCast(r5.a(), g.class, "com.obric.aiagent.plugin"), r8), r5.b(), r9);
    L9:
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.a.a(j.f9758a, null, 1, null)), m.class, "com.obric.aiagent.plugin");
    }

    private final m a(q r2, com.bytedance.safetyguard.lxc.internal.c.c r3, OutboundPolicyEvaluator r4) {
        OutboundPolicyDecision r1 = ((OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r4, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin")).evaluate(r2.a(r3));     // Catch: Exception -> L22
        if (ZeusTransformUtils.instanceOf(r1, OutboundPolicyDecision.Deny.class) == false) goto L8;
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.d(((OutboundPolicyDecision.Deny) ZeusTransformUtils.preCheckCast(r1, OutboundPolicyDecision.Deny.class, "com.obric.aiagent.plugin")).getReason())), m.class, "com.obric.aiagent.plugin");
    L8:
        if (d.h.b.o.a(r1, OutboundPolicyDecision.Allow.INSTANCE) == false) goto L14;
        if (r3 != com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L28;
        return (m) ZeusTransformUtils.preCheckCast(new m.d(r2), m.class, "com.obric.aiagent.plugin");
    L28:
        return (m) ZeusTransformUtils.preCheckCast(new m.a(r2), m.class, "com.obric.aiagent.plugin");
    L14:
        if (d.h.b.o.a(r1, OutboundPolicyDecision.SidecarAuth.INSTANCE) == false) goto L21;
        if (r3 != com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L19;
        return (m) ZeusTransformUtils.preCheckCast(new m.d(r2), m.class, "com.obric.aiagent.plugin");
    L19:
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.d("Business policy cannot convert ordinary ingress to sidecar auth")), m.class, "com.obric.aiagent.plugin");
    L21:
        throw new d.k();
    L23:
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.d("Business policy failed closed")), m.class, "com.obric.aiagent.plugin");
    }

    private final j a(c r4) {
        b r3 = r4.b();
        if (r3 == null) goto L5;
        String r5 = ", mappedIpv4=" + r3;
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        return j.f9758a.b("Address category is blocked: " + r4.a() + r5);
    L5:
        r5 = null;
        goto L6
    }

    private final boolean a(g r3) {
        g r2 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, g.b.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (r2.getType() != com.bytedance.safetyguard.lxc.internal.c.m.f9854c) goto L11;
        if (r2.b() != 16384) goto L11;
        if (Arrays.equals(((g.b) ZeusTransformUtils.preCheckCast(r2, g.b.class, "com.obric.aiagent.plugin")).d(), f9769d) == false) goto L11;
        return true;
    }

    static {
        f9768a = new a(null);
        f9769d = new byte[]{127, 0, 0, 1};
        Charset r0 = StandardCharsets.US_ASCII;
        d.h.b.o.c(r0, "US_ASCII");
        byte[] r1 = "127.0.0.1".getBytes(r0);
        d.h.b.o.c(r1, "getBytes(...)");
        f9770e = r1;
    }
}
