package com.android.ttcjpaysdk.verify.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifySmsMobileType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BANK_MOBILE", "BIND_MOBILE", "YF_MOBILE", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum DyVerifySmsMobileType extends Enum<DyVerifySmsMobileType> {
    private static final /* synthetic */ DyVerifySmsMobileType[] $VALUES = null;
    public static final DyVerifySmsMobileType BANK_MOBILE = null;
    public static final DyVerifySmsMobileType BIND_MOBILE = null;
    public static final DyVerifySmsMobileType YF_MOBILE = null;
    private final String value;

    private static final /* synthetic */ DyVerifySmsMobileType[] $values() {
        return new DyVerifySmsMobileType[]{BANK_MOBILE, BIND_MOBILE, YF_MOBILE};
    }

    public static DyVerifySmsMobileType valueOf(String r100) {
        return (DyVerifySmsMobileType) a.a(DyVerifySmsMobileType.class, r100);
    }

    public static DyVerifySmsMobileType[] values() {
        return (DyVerifySmsMobileType[]) $VALUES.clone();
    }

    static {
        BANK_MOBILE = new DyVerifySmsMobileType("BANK_MOBILE", 0, "bank_mobile");
        BIND_MOBILE = new DyVerifySmsMobileType("BIND_MOBILE", 1, "bind_mobile");
        YF_MOBILE = new DyVerifySmsMobileType("YF_MOBILE", 2, "yf_mobile");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private DyVerifySmsMobileType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
