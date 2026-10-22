package com.android.ttcjpaysdk.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/OuterSceneSource;", "", "name", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DEFAULT", "NFCPAY", "FKMPAY", "SKMPAY", "JSAPI", "IMPAY", "NATIVE_PAY", "E_PAY", "AP_SIGN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OuterSceneSource extends Enum<OuterSceneSource> {
    private static final /* synthetic */ OuterSceneSource[] $VALUES = null;
    public static final OuterSceneSource AP_SIGN = null;
    public static final OuterSceneSource DEFAULT = null;
    public static final OuterSceneSource E_PAY = null;
    public static final OuterSceneSource FKMPAY = null;
    public static final OuterSceneSource IMPAY = null;
    public static final OuterSceneSource JSAPI = null;
    public static final OuterSceneSource NATIVE_PAY = null;
    public static final OuterSceneSource NFCPAY = null;
    public static final OuterSceneSource SKMPAY = null;

    private static final /* synthetic */ OuterSceneSource[] $values() {
        return new OuterSceneSource[]{DEFAULT, NFCPAY, FKMPAY, SKMPAY, JSAPI, IMPAY, NATIVE_PAY, E_PAY, AP_SIGN};
    }

    public static OuterSceneSource valueOf(String r100) {
        return (OuterSceneSource) r27.a.a(OuterSceneSource.class, r100);
    }

    public static OuterSceneSource[] values() {
        return (OuterSceneSource[]) $VALUES.clone();
    }

    static {
        DEFAULT = new OuterSceneSource("DEFAULT", 0, "DEFAULT");
        NFCPAY = new OuterSceneSource("NFCPAY", 1, "NFCPAY");
        FKMPAY = new OuterSceneSource("FKMPAY", 2, "FKMPAY");
        SKMPAY = new OuterSceneSource("SKMPAY", 3, "SKMPAY");
        JSAPI = new OuterSceneSource("JSAPI", 4, "JSAPI");
        IMPAY = new OuterSceneSource("IMPAY", 5, "IMPAY");
        NATIVE_PAY = new OuterSceneSource("NATIVE_PAY", 6, "NATIVE_PAY");
        E_PAY = new OuterSceneSource("E_PAY", 7, "E_PAY");
        AP_SIGN = new OuterSceneSource("AP_SIGN", 8, "AP_SIGN");
        $VALUES = $values();
    }

    private OuterSceneSource(String r100, int r101, String r102) {
        super(r100, r101);
    }
}
