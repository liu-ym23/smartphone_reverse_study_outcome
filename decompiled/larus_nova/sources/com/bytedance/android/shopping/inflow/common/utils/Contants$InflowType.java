package com.bytedance.android.shopping.inflow.common.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/shopping/inflow/common/utils/Contants$InflowType", "", "Lcom/bytedance/android/shopping/inflow/common/utils/Contants$InflowType;", "ORIGIN", "MIXED_INFLOW_PRODUCT", "INFEED_PRODUCT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Contants$InflowType extends Enum<Contants$InflowType> {
    public static final Contants$InflowType INFEED_PRODUCT = null;
    public static final Contants$InflowType MIXED_INFLOW_PRODUCT = null;
    public static final Contants$InflowType ORIGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Contants$InflowType[] f176257a = null;

    static {
        Contants$InflowType r100 = new Contants$InflowType("ORIGIN", 0);
        ORIGIN = r100;
        Contants$InflowType r101 = new Contants$InflowType("MIXED_INFLOW_PRODUCT", 1);
        MIXED_INFLOW_PRODUCT = r101;
        Contants$InflowType r102 = new Contants$InflowType("INFEED_PRODUCT", 2);
        INFEED_PRODUCT = r102;
        f176257a = new Contants$InflowType[]{r100, r101, r102};
    }

    public static Contants$InflowType valueOf(String r100) {
        return (Contants$InflowType) a.a(Contants$InflowType.class, r100);
    }

    public static Contants$InflowType[] values() {
        return (Contants$InflowType[]) f176257a.clone();
    }

    public Contants$InflowType(String r100, int r101) {
        super(r100, r101);
    }
}
