package com.bytedance.safetyguard.lxc.internal.e.e;

import com.bytedance.safetyguard.lxc.internal.b.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import okhttp3.q;

/* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g implements q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.b.a f10819c;

    public g(com.bytedance.safetyguard.lxc.internal.b.a r3) {
        com.bytedance.safetyguard.lxc.internal.b.a r4 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "resolver");
        this.f10819c = r4;
    }

    @Override // okhttp3.q
    public List<InetAddress> lookup(String r4) {
        o.e(r4, "hostname");
        List<InetAddress> r3 = this.f10819c.resolve(s.f9797a.a(r4));     // Catch: Exception -> L19
        if (r3.isEmpty() == true) goto L18;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L16;
        com.bytedance.safetyguard.lxc.internal.b.c r1 = com.bytedance.safetyguard.lxc.internal.b.d.f9735a.a((InetAddress) ZeusTransformUtils.preCheckCast(r5.next(), InetAddress.class, "com.obric.aiagent.plugin"));
        if (r1.c() == false) goto L9;
        throw new UnknownHostException("DNS candidate was blocked by outbound security policy: " + r1.a());
    L16:
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
    L18:
        throw new UnknownHostException("DNS returned no addresses");
    L19:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, UnknownHostException.class) == false) goto L23;
        throw e;
    L23:
        UnknownHostException r6 = new UnknownHostException("DNS resolution failed");
        r6.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.aiagent.plugin"));
    L25:
        e = move-exception;
        UnknownHostException r7 = new UnknownHostException("Invalid DNS hostname");
        r7.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
