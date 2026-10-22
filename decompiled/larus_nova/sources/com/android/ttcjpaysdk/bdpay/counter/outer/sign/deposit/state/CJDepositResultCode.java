package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositResultCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAILED", "CANCELED", "PROCESSING", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJDepositResultCode extends Enum<CJDepositResultCode> {
    private static final /* synthetic */ CJDepositResultCode[] $VALUES = null;
    public static final CJDepositResultCode CANCELED = null;
    public static final CJDepositResultCode FAILED = null;
    public static final CJDepositResultCode PROCESSING = null;
    public static final CJDepositResultCode SUCCESS = null;
    private final int value;

    private static final /* synthetic */ CJDepositResultCode[] $values() {
        return new CJDepositResultCode[]{SUCCESS, FAILED, CANCELED, PROCESSING};
    }

    public static CJDepositResultCode valueOf(String r100) {
        return (CJDepositResultCode) a.a(CJDepositResultCode.class, r100);
    }

    public static CJDepositResultCode[] values() {
        return (CJDepositResultCode[]) $VALUES.clone();
    }

    static {
        SUCCESS = new CJDepositResultCode("SUCCESS", 0, 0);
        FAILED = new CJDepositResultCode("FAILED", 1, 102);
        CANCELED = new CJDepositResultCode("CANCELED", 2, 104);
        PROCESSING = new CJDepositResultCode("PROCESSING", 3, 101);
        $VALUES = $values();
    }

    public final int getValue() {
        return this.value;
    }

    private CJDepositResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
