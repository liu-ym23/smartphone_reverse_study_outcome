package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: ProxySessionModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum ProxySessionCloseReason extends Enum<ProxySessionCloseReason> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ ProxySessionCloseReason[] $VALUES = null;
    public static final ProxySessionCloseReason GATEWAY_CLOSED = null;
    public static final ProxySessionCloseReason HANDSHAKE_FAILED = null;
    public static final ProxySessionCloseReason HOST_CLOSED = null;
    public static final ProxySessionCloseReason INTERNAL_ERROR = null;
    public static final ProxySessionCloseReason IO_ERROR = null;
    public static final ProxySessionCloseReason NORMAL = null;
    public static final ProxySessionCloseReason POLICY_ERROR = null;
    public static final ProxySessionCloseReason PROTOCOL_ERROR = null;

    private static final /* synthetic */ ProxySessionCloseReason[] $values() {
        return new ProxySessionCloseReason[]{NORMAL, HOST_CLOSED, GATEWAY_CLOSED, HANDSHAKE_FAILED, PROTOCOL_ERROR, POLICY_ERROR, IO_ERROR, INTERNAL_ERROR};
    }

    public static a<ProxySessionCloseReason> getEntries() {
        return $ENTRIES;
    }

    public static ProxySessionCloseReason valueOf(String r2) {
        return (ProxySessionCloseReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProxySessionCloseReason.class, r2), ProxySessionCloseReason.class, "com.obric.aiagent.plugin");
    }

    public static ProxySessionCloseReason[] values() {
        return (ProxySessionCloseReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProxySessionCloseReason[].class, "com.obric.aiagent.plugin");
    }

    private ProxySessionCloseReason(String r1, int r2) {
        super(r1, r2);
    }

    static {
        NORMAL = new ProxySessionCloseReason("NORMAL", 0);
        HOST_CLOSED = new ProxySessionCloseReason("HOST_CLOSED", 1);
        GATEWAY_CLOSED = new ProxySessionCloseReason("GATEWAY_CLOSED", 2);
        HANDSHAKE_FAILED = new ProxySessionCloseReason("HANDSHAKE_FAILED", 3);
        PROTOCOL_ERROR = new ProxySessionCloseReason("PROTOCOL_ERROR", 4);
        POLICY_ERROR = new ProxySessionCloseReason("POLICY_ERROR", 5);
        IO_ERROR = new ProxySessionCloseReason("IO_ERROR", 6);
        INTERNAL_ERROR = new ProxySessionCloseReason("INTERNAL_ERROR", 7);
        ProxySessionCloseReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
