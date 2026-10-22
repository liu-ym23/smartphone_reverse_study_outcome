package com.bytedance.android.shopping.api.mall;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/ECMallHostType;", "", "XIGUA", "TOUTIAO", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ECMallHostType extends Enum<ECMallHostType> {
    public static final ECMallHostType TOUTIAO = null;
    public static final ECMallHostType XIGUA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECMallHostType[] f170200a = null;

    static {
        ECMallHostType r100 = new ECMallHostType("XIGUA", 0);
        XIGUA = r100;
        ECMallHostType r101 = new ECMallHostType("TOUTIAO", 1);
        TOUTIAO = r101;
        f170200a = new ECMallHostType[]{r100, r101};
    }

    public static ECMallHostType valueOf(String r100) {
        return (ECMallHostType) r27.a.a(ECMallHostType.class, r100);
    }

    public static ECMallHostType[] values() {
        return (ECMallHostType[]) f170200a.clone();
    }

    public ECMallHostType(String r100, int r101) {
        super(r100, r101);
    }
}
