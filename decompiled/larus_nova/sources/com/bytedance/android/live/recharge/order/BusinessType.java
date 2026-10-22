package com.bytedance.android.live.recharge.order;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/order/BusinessType;", "", "Generic", "ExchangeOnly", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BusinessType extends Enum<BusinessType> {
    public static final BusinessType ExchangeOnly = null;
    public static final BusinessType Generic = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BusinessType[] f90062a = null;

    static {
        BusinessType r100 = new BusinessType("Generic", 0);
        Generic = r100;
        BusinessType r101 = new BusinessType("ExchangeOnly", 1);
        ExchangeOnly = r101;
        f90062a = new BusinessType[]{r100, r101};
    }

    public static BusinessType valueOf(String r100) {
        return (BusinessType) r27.a.a(BusinessType.class, r100);
    }

    public static BusinessType[] values() {
        return (BusinessType[]) f90062a.clone();
    }

    public BusinessType(String r100, int r101) {
        super(r100, r101);
    }
}
