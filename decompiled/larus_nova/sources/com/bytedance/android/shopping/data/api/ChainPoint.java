package com.bytedance.android.shopping.data.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/data/api/ChainPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PAGE_INIT", "SKU_CHECK_START", "SKU_CHECK_END", "AUTO_COUPON_START", "PAGE_START", "AUTO_COUPON_END", "CREATE_SCHEMA_START", "CREATE_SCHEMA_END", "SKU_PARAM_START", "SKU_PARAM_END", "DELAY_START", "DELAY_END", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ChainPoint extends Enum<ChainPoint> {
    public static final ChainPoint AUTO_COUPON_END = null;
    public static final ChainPoint AUTO_COUPON_START = null;
    public static final ChainPoint CREATE_SCHEMA_END = null;
    public static final ChainPoint CREATE_SCHEMA_START = null;
    public static final ChainPoint DELAY_END = null;
    public static final ChainPoint DELAY_START = null;
    public static final ChainPoint PAGE_INIT = null;
    public static final ChainPoint PAGE_START = null;
    public static final ChainPoint PARSE_SCHEMA_END = null;
    public static final ChainPoint PARSE_SCHEMA_START = null;
    public static final ChainPoint SKU_CHECK_END = null;
    public static final ChainPoint SKU_CHECK_START = null;
    public static final ChainPoint SKU_PARAM_END = null;
    public static final ChainPoint SKU_PARAM_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChainPoint[] f172988a = null;
    private final String value;

    public static ChainPoint valueOf(String r100) {
        return (ChainPoint) a.a(ChainPoint.class, r100);
    }

    public static ChainPoint[] values() {
        return (ChainPoint[]) f172988a.clone();
    }

    static {
        ChainPoint r100 = new ChainPoint("PAGE_INIT", 0, "C_PAGE_INIT");
        PAGE_INIT = r100;
        ChainPoint r101 = new ChainPoint("SKU_CHECK_START", 1, "C_SKU_CHECK_START");
        SKU_CHECK_START = r101;
        ChainPoint r102 = new ChainPoint("SKU_CHECK_END", 2, "C_SKU_CHECK_END");
        SKU_CHECK_END = r102;
        ChainPoint r103 = new ChainPoint("AUTO_COUPON_START", 3, "C_AUTO_COUPON_START");
        AUTO_COUPON_START = r103;
        ChainPoint r104 = new ChainPoint("PAGE_START", 4, "C_PAGE_START");
        PAGE_START = r104;
        ChainPoint r105 = new ChainPoint("AUTO_COUPON_END", 5, "C_AUTO_COUPON_END");
        AUTO_COUPON_END = r105;
        ChainPoint r106 = new ChainPoint("CREATE_SCHEMA_START", 6, "C_SCHEMA_CREATE_START");
        CREATE_SCHEMA_START = r106;
        ChainPoint r107 = new ChainPoint("CREATE_SCHEMA_END", 7, "C_SCHEMA_CREATE_END");
        CREATE_SCHEMA_END = r107;
        ChainPoint r108 = new ChainPoint("SKU_PARAM_START", 8, "C_SKU_PARAM_START");
        SKU_PARAM_START = r108;
        ChainPoint r109 = new ChainPoint("SKU_PARAM_END", 9, "C_SKU_PARAM_END");
        SKU_PARAM_END = r109;
        ChainPoint r110 = new ChainPoint("DELAY_START", 10, "C_DELAY_START");
        DELAY_START = r110;
        ChainPoint r111 = new ChainPoint("DELAY_END", 11, "C_DELAY_END");
        DELAY_END = r111;
        ChainPoint r112 = new ChainPoint("PARSE_SCHEMA_START", 12, "C_PARSE_SCHEMA_START");
        PARSE_SCHEMA_START = r112;
        ChainPoint r113 = new ChainPoint("PARSE_SCHEMA_END", 13, "C_PARSE_SCHEMA_END");
        PARSE_SCHEMA_END = r113;
        f172988a = new ChainPoint[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public final String getValue() {
        return this.value;
    }

    public ChainPoint(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
