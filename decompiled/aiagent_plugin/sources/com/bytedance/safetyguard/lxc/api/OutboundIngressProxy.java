package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: OutboundPolicyApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum OutboundIngressProxy extends Enum<OutboundIngressProxy> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ OutboundIngressProxy[] $VALUES = null;
    public static final OutboundIngressProxy HTTP_CONNECT = null;
    public static final OutboundIngressProxy HTTP_FORWARD = null;
    public static final OutboundIngressProxy SIDECAR_AUTH = null;
    public static final OutboundIngressProxy SOCKS5_CONNECT = null;

    private static final /* synthetic */ OutboundIngressProxy[] $values() {
        return new OutboundIngressProxy[]{HTTP_FORWARD, HTTP_CONNECT, SOCKS5_CONNECT, SIDECAR_AUTH};
    }

    public static a<OutboundIngressProxy> getEntries() {
        return $ENTRIES;
    }

    public static OutboundIngressProxy valueOf(String r2) {
        return (OutboundIngressProxy) ZeusTransformUtils.preCheckCast(Enum.valueOf(OutboundIngressProxy.class, r2), OutboundIngressProxy.class, "com.obric.aiagent.plugin");
    }

    public static OutboundIngressProxy[] values() {
        return (OutboundIngressProxy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutboundIngressProxy[].class, "com.obric.aiagent.plugin");
    }

    private OutboundIngressProxy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        HTTP_FORWARD = new OutboundIngressProxy("HTTP_FORWARD", 0);
        HTTP_CONNECT = new OutboundIngressProxy("HTTP_CONNECT", 1);
        SOCKS5_CONNECT = new OutboundIngressProxy("SOCKS5_CONNECT", 2);
        SIDECAR_AUTH = new OutboundIngressProxy("SIDECAR_AUTH", 3);
        OutboundIngressProxy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
