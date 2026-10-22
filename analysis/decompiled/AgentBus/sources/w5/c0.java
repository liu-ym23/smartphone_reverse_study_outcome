package w5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c0 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ c0[] $VALUES;
    private final String label;
    public static final c0 SERVICE_NOT_READY = new c0("SERVICE_NOT_READY", 0, "Service 未就绪");
    public static final c0 GATEWAY_OFFLINE = new c0("GATEWAY_OFFLINE", 1, "Gateway 离线");
    public static final c0 POOL_EMPTY = new c0("POOL_EMPTY", 2, "连接池为空");
    public static final c0 NO_NETWORK = new c0("NO_NETWORK", 3, "无网络连接");
    public static final c0 DNS_FAILURE = new c0("DNS_FAILURE", 4, "DNS 全局解析失败");
    public static final c0 DNS_PARTIAL = new c0("DNS_PARTIAL", 5, "DNS 部分解析失败");
    public static final c0 TCP_BLOCKED = new c0("TCP_BLOCKED", 6, "TCP 连接被阻断");
    public static final c0 TLS_CERT_ERROR = new c0("TLS_CERT_ERROR", 7, "TLS 证书验证失败");
    public static final c0 SECURE_SDK_NOT_READY = new c0("SECURE_SDK_NOT_READY", 8, "SecureData SDK 未就绪");
    public static final c0 ACCOUNT_TOKEN_EXPIRED = new c0("ACCOUNT_TOKEN_EXPIRED", 9, "账户 Token 过期");
    public static final c0 ACCOUNT_NOT_LOGGED_IN = new c0("ACCOUNT_NOT_LOGGED_IN", 10, "账户未登录");
    public static final c0 DEVICE_TOKEN_EXPIRED = new c0("DEVICE_TOKEN_EXPIRED", 11, "设备 Token 过期");
    public static final c0 DEVICE_IDENTITY_CORRUPT = new c0("DEVICE_IDENTITY_CORRUPT", 12, "设备身份密钥损坏");
    public static final c0 WS_SERVER_REJECT = new c0("WS_SERVER_REJECT", 13, "服务端拒绝连接");
    public static final c0 WS_TIMEOUT = new c0("WS_TIMEOUT", 14, "WebSocket 连接超时");
    public static final c0 PING_PONG_FAILURE = new c0("PING_PONG_FAILURE", 15, "心跳超时");
    public static final c0 KEEPALIVE_DEAD = new c0("KEEPALIVE_DEAD", 16, "保活失效");
    public static final c0 VPN_INTERFERENCE = new c0("VPN_INTERFERENCE", 17, "VPN/代理干扰");
    public static final c0 UNKNOWN = new c0("UNKNOWN", 18, "未知原因");

    private static final /* synthetic */ c0[] $values() {
        return new c0[]{SERVICE_NOT_READY, GATEWAY_OFFLINE, POOL_EMPTY, NO_NETWORK, DNS_FAILURE, DNS_PARTIAL, TCP_BLOCKED, TLS_CERT_ERROR, SECURE_SDK_NOT_READY, ACCOUNT_TOKEN_EXPIRED, ACCOUNT_NOT_LOGGED_IN, DEVICE_TOKEN_EXPIRED, DEVICE_IDENTITY_CORRUPT, WS_SERVER_REJECT, WS_TIMEOUT, PING_PONG_FAILURE, KEEPALIVE_DEAD, VPN_INTERFERENCE, UNKNOWN};
    }

    static {
        c0[] c0VarArr$values = $values();
        $VALUES = c0VarArr$values;
        $ENTRIES = w7.e0.s(c0VarArr$values);
    }

    private c0(String str, int i2, String str2) {
        this.label = str2;
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) $VALUES.clone();
    }

    public final String getLabel() {
        return this.label;
    }
}
