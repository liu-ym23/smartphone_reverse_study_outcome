package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: ProxySessionModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum ProxySessionErrorCode extends Enum<ProxySessionErrorCode> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ ProxySessionErrorCode[] $VALUES = null;
    public static final ProxySessionErrorCode BUSINESS_POLICY_DENIED = null;
    public static final ProxySessionErrorCode CONFIG_CONFLICT = null;
    public static final ProxySessionErrorCode DNS_FAILED = null;
    public static final ProxySessionErrorCode FRAME_TOO_LARGE = null;
    public static final ProxySessionErrorCode HELLO_TIMEOUT = null;
    public static final ProxySessionErrorCode INVALID_PROXY_FD = null;
    public static final ProxySessionErrorCode MALFORMED_FRAME = null;
    public static final ProxySessionErrorCode NETWORK_ERROR = null;
    public static final ProxySessionErrorCode PENDING_BYTES_EXCEEDED = null;
    public static final ProxySessionErrorCode READY_NOT_SUPPORTED = null;
    public static final ProxySessionErrorCode REQUIRED_FEATURE_MISSING = null;
    public static final ProxySessionErrorCode RESOURCE_EXHAUSTED = null;
    public static final ProxySessionErrorCode SERVICE_BIND_TIMEOUT = null;
    public static final ProxySessionErrorCode SERVICE_DIED = null;
    public static final ProxySessionErrorCode SERVICE_PROTOCOL_MISMATCH = null;
    public static final ProxySessionErrorCode SERVICE_RECOVERY_FAILED = null;
    public static final ProxySessionErrorCode SERVICE_UNAVAILABLE = null;
    public static final ProxySessionErrorCode SIDECAR_ERROR = null;
    public static final ProxySessionErrorCode SSRF_BLOCKED = null;
    public static final ProxySessionErrorCode TOO_MANY_STREAMS = null;

    private static final /* synthetic */ ProxySessionErrorCode[] $values() {
        return new ProxySessionErrorCode[]{REQUIRED_FEATURE_MISSING, HELLO_TIMEOUT, FRAME_TOO_LARGE, TOO_MANY_STREAMS, PENDING_BYTES_EXCEEDED, MALFORMED_FRAME, NETWORK_ERROR, SIDECAR_ERROR, READY_NOT_SUPPORTED, INVALID_PROXY_FD, SERVICE_UNAVAILABLE, SERVICE_PROTOCOL_MISMATCH, CONFIG_CONFLICT, RESOURCE_EXHAUSTED, SSRF_BLOCKED, BUSINESS_POLICY_DENIED, DNS_FAILED, SERVICE_DIED, SERVICE_RECOVERY_FAILED, SERVICE_BIND_TIMEOUT};
    }

    public static a<ProxySessionErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ProxySessionErrorCode valueOf(String r2) {
        return (ProxySessionErrorCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProxySessionErrorCode.class, r2), ProxySessionErrorCode.class, "com.obric.aiagent.plugin");
    }

    public static ProxySessionErrorCode[] values() {
        return (ProxySessionErrorCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProxySessionErrorCode[].class, "com.obric.aiagent.plugin");
    }

    private ProxySessionErrorCode(String r1, int r2) {
        super(r1, r2);
    }

    static {
        REQUIRED_FEATURE_MISSING = new ProxySessionErrorCode("REQUIRED_FEATURE_MISSING", 0);
        HELLO_TIMEOUT = new ProxySessionErrorCode("HELLO_TIMEOUT", 1);
        FRAME_TOO_LARGE = new ProxySessionErrorCode("FRAME_TOO_LARGE", 2);
        TOO_MANY_STREAMS = new ProxySessionErrorCode("TOO_MANY_STREAMS", 3);
        PENDING_BYTES_EXCEEDED = new ProxySessionErrorCode("PENDING_BYTES_EXCEEDED", 4);
        MALFORMED_FRAME = new ProxySessionErrorCode("MALFORMED_FRAME", 5);
        NETWORK_ERROR = new ProxySessionErrorCode("NETWORK_ERROR", 6);
        SIDECAR_ERROR = new ProxySessionErrorCode("SIDECAR_ERROR", 7);
        READY_NOT_SUPPORTED = new ProxySessionErrorCode("READY_NOT_SUPPORTED", 8);
        INVALID_PROXY_FD = new ProxySessionErrorCode("INVALID_PROXY_FD", 9);
        SERVICE_UNAVAILABLE = new ProxySessionErrorCode("SERVICE_UNAVAILABLE", 10);
        SERVICE_PROTOCOL_MISMATCH = new ProxySessionErrorCode("SERVICE_PROTOCOL_MISMATCH", 11);
        CONFIG_CONFLICT = new ProxySessionErrorCode("CONFIG_CONFLICT", 12);
        RESOURCE_EXHAUSTED = new ProxySessionErrorCode("RESOURCE_EXHAUSTED", 13);
        SSRF_BLOCKED = new ProxySessionErrorCode("SSRF_BLOCKED", 14);
        BUSINESS_POLICY_DENIED = new ProxySessionErrorCode("BUSINESS_POLICY_DENIED", 15);
        DNS_FAILED = new ProxySessionErrorCode("DNS_FAILED", 16);
        SERVICE_DIED = new ProxySessionErrorCode("SERVICE_DIED", 17);
        SERVICE_RECOVERY_FAILED = new ProxySessionErrorCode("SERVICE_RECOVERY_FAILED", 18);
        SERVICE_BIND_TIMEOUT = new ProxySessionErrorCode("SERVICE_BIND_TIMEOUT", 19);
        ProxySessionErrorCode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
