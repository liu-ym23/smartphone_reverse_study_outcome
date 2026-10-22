package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OutboundPolicyApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutboundTarget {
    private final String host;
    private final OutboundIngressProxy ingressProxy;
    private final int port;
    private final OutboundTargetType type;

    public static /* synthetic */ OutboundTarget copy$default(OutboundTarget r0, String r1, int r2, OutboundTargetType r3, OutboundIngressProxy r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.host;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.port;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.ingressProxy;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.host;
    }

    public final int component2() {
        return this.port;
    }

    public final OutboundTargetType component3() {
        return this.type;
    }

    public final OutboundIngressProxy component4() {
        return this.ingressProxy;
    }

    public final OutboundTarget copy(String r1, int r2, OutboundTargetType r3, OutboundIngressProxy r4) {
        o.e(r1, "host");
        o.e(r3, "type");
        o.e(r4, "ingressProxy");
        return new OutboundTarget(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OutboundTarget.class) == true) goto L8;
        return false;
    L8:
        OutboundTarget r6 = (OutboundTarget) ZeusTransformUtils.preCheckCast(r5, OutboundTarget.class, "com.obric.aiagent.plugin");
        if (o.a(this.host, r6.host) == true) goto L12;
        return false;
    L12:
        if (this.port == r6.port) goto L15;
        return false;
    L15:
        if (this.type == r6.type) goto L18;
        return false;
    L18:
        if (this.ingressProxy == r6.ingressProxy) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.host.hashCode() * 31) + Integer.hashCode(this.port)) * 31) + this.type.hashCode()) * 31) + this.ingressProxy.hashCode();
    }

    public String toString() {
        return "OutboundTarget(host=" + this.host + ", port=" + this.port + ", type=" + this.type + ", ingressProxy=" + this.ingressProxy + ')';
    }

    public OutboundTarget(String r2, int r3, OutboundTargetType r4, OutboundIngressProxy r5) {
        o.e(r2, "host");
        o.e(r4, "type");
        o.e(r5, "ingressProxy");
        this.host = r2;
        this.port = r3;
        this.type = r4;
        this.ingressProxy = r5;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final OutboundTargetType getType() {
        return this.type;
    }

    public final OutboundIngressProxy getIngressProxy() {
        return this.ingressProxy;
    }
}
