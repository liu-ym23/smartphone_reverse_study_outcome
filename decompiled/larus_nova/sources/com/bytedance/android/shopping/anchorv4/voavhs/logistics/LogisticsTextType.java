package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsTextType;", "", "", "value", "I", "getValue", "()I", "DELIVERY", "DELIVERY_ADDRESS_WITH_EPIDEMIC", "SHIPPING_ADDRESS_WITH_EPIDEMIC", "DELIVERY_ADDRESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LogisticsTextType extends Enum<LogisticsTextType> {
    public static final LogisticsTextType DELIVERY = null;
    public static final LogisticsTextType DELIVERY_ADDRESS = null;
    public static final LogisticsTextType DELIVERY_ADDRESS_WITH_EPIDEMIC = null;
    public static final LogisticsTextType SHIPPING_ADDRESS_WITH_EPIDEMIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogisticsTextType[] f169978a = null;
    private final int value;

    static {
        LogisticsTextType r100 = new LogisticsTextType("DELIVERY", 0, 1);
        DELIVERY = r100;
        LogisticsTextType r101 = new LogisticsTextType("DELIVERY_ADDRESS_WITH_EPIDEMIC", 1, 2);
        DELIVERY_ADDRESS_WITH_EPIDEMIC = r101;
        LogisticsTextType r102 = new LogisticsTextType("SHIPPING_ADDRESS_WITH_EPIDEMIC", 2, 3);
        SHIPPING_ADDRESS_WITH_EPIDEMIC = r102;
        LogisticsTextType r103 = new LogisticsTextType("DELIVERY_ADDRESS", 3, 4);
        DELIVERY_ADDRESS = r103;
        f169978a = new LogisticsTextType[]{r100, r101, r102, r103};
    }

    public static LogisticsTextType valueOf(String r100) {
        return (LogisticsTextType) r27.a.a(LogisticsTextType.class, r100);
    }

    public static LogisticsTextType[] values() {
        return (LogisticsTextType[]) f169978a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LogisticsTextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
