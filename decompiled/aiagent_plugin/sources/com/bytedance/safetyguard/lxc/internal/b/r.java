package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: SecureTargetResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutboundPolicyEvaluator f9795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f9796c;

    public r(i r3, a r4, OutboundPolicyEvaluator r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        OutboundPolicyEvaluator r7 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r5, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "config");
        d.h.b.o.e(r6, "dnsResolver");
        d.h.b.o.e(r7, "businessPolicy");
        this.f9794a = r6;
        this.f9795b = r7;
        this.f9796c = new l(r3);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.b.n
    public m a(com.bytedance.safetyguard.lxc.internal.c.d r9) {
        d.h.b.o.e(r9, Ext.KEY_REQUEST);
        m r10 = this.f9796c.a(r9.c(), r9.e(), r9.b(), r9.d(), this.f9795b);
        if (ZeusTransformUtils.instanceOf(r10, m.c.class) == true) goto L10;
        return r10;
    L10:
        List<InetAddress> r1 = this.f9794a.resolve(((m.c) ZeusTransformUtils.preCheckCast(r10, m.c.class, "com.obric.aiagent.plugin")).a().a());     // Catch: Exception -> L8
        return this.f9796c.a((m.c) ZeusTransformUtils.preCheckCast(r10, m.c.class, "com.obric.aiagent.plugin"), r1, this.f9795b);
    L9:
        return (m) ZeusTransformUtils.preCheckCast(new m.b(j.f9758a.c("DNS resolution failed")), m.class, "com.obric.aiagent.plugin");
    }
}
