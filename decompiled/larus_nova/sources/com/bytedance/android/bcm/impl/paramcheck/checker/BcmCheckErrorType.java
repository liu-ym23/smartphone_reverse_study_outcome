package com.bytedance.android.bcm.impl.paramcheck.checker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/bcm/impl/paramcheck/checker/BcmCheckErrorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "errorTip", "getErrorTip", "UNNEEDED_PARAM", "MISS_PARAM", "TYPE_ERROR", "VALUE_ERROR", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum BcmCheckErrorType extends Enum<BcmCheckErrorType> {
    public static final BcmCheckErrorType MISS_PARAM = null;
    public static final BcmCheckErrorType TYPE_ERROR = null;
    public static final BcmCheckErrorType UNNEEDED_PARAM = null;
    public static final BcmCheckErrorType VALUE_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BcmCheckErrorType[] f41869a = null;
    private final String errorTip;
    private final String value;

    static {
        BcmCheckErrorType r100 = new BcmCheckErrorType("UNNEEDED_PARAM", 0, "unneeded_param", "多传");
        UNNEEDED_PARAM = r100;
        BcmCheckErrorType r101 = new BcmCheckErrorType("MISS_PARAM", 1, "miss_param", "少传");
        MISS_PARAM = r101;
        BcmCheckErrorType r102 = new BcmCheckErrorType("TYPE_ERROR", 2, "illegal_type", "类型错误");
        TYPE_ERROR = r102;
        BcmCheckErrorType r103 = new BcmCheckErrorType("VALUE_ERROR", 3, "illegal_value", "值错误");
        VALUE_ERROR = r103;
        f41869a = new BcmCheckErrorType[]{r100, r101, r102, r103};
    }

    public static BcmCheckErrorType valueOf(String r100) {
        return (BcmCheckErrorType) r27.a.a(BcmCheckErrorType.class, r100);
    }

    public static BcmCheckErrorType[] values() {
        return (BcmCheckErrorType[]) f41869a.clone();
    }

    public final String getErrorTip() {
        return this.errorTip;
    }

    public final String getValue() {
        return this.value;
    }

    public BcmCheckErrorType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.errorTip = r103;
    }
}
