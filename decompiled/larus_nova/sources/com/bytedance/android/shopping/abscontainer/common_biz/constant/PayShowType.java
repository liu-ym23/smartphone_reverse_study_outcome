package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/PayShowType;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "DEFAULT", "AUCTION", "NO_PAYMENT", "ONLY_METHOD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PayShowType extends Enum<PayShowType> {
    public static final PayShowType AUCTION = null;
    public static final PayShowType DEFAULT = null;
    public static final PayShowType NO_PAYMENT = null;
    public static final PayShowType ONLY_METHOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PayShowType[] f164222a = null;
    private final String rawValue;

    static {
        PayShowType r100 = new PayShowType("DEFAULT", 0, "0");
        DEFAULT = r100;
        PayShowType r101 = new PayShowType("AUCTION", 1, "1");
        AUCTION = r101;
        PayShowType r102 = new PayShowType("NO_PAYMENT", 2, "2");
        NO_PAYMENT = r102;
        PayShowType r103 = new PayShowType("ONLY_METHOD", 3, "3");
        ONLY_METHOD = r103;
        f164222a = new PayShowType[]{r100, r101, r102, r103};
    }

    public static PayShowType valueOf(String r100) {
        return (PayShowType) a.a(PayShowType.class, r100);
    }

    public static PayShowType[] values() {
        return (PayShowType[]) f164222a.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public PayShowType(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
