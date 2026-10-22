package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/EnumEntranceInfoScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ENTER_PRODUCT_DETAIL", "ENTER_ORDER_PAGE", "ENTER_SKU", "ECOM_LIVE_REQUEST", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnumEntranceInfoScene extends Enum<EnumEntranceInfoScene> {
    public static final EnumEntranceInfoScene ECOM_LIVE_REQUEST = null;
    public static final EnumEntranceInfoScene ENTER_ORDER_PAGE = null;
    public static final EnumEntranceInfoScene ENTER_PRODUCT_DETAIL = null;
    public static final EnumEntranceInfoScene ENTER_SKU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumEntranceInfoScene[] f153045a = null;
    private final String value;

    static {
        EnumEntranceInfoScene r100 = new EnumEntranceInfoScene("ENTER_PRODUCT_DETAIL", 0, "enterProductDetail");
        ENTER_PRODUCT_DETAIL = r100;
        EnumEntranceInfoScene r101 = new EnumEntranceInfoScene("ENTER_ORDER_PAGE", 1, "enterOrderPage");
        ENTER_ORDER_PAGE = r101;
        EnumEntranceInfoScene r102 = new EnumEntranceInfoScene("ENTER_SKU", 2, "enterSku");
        ENTER_SKU = r102;
        EnumEntranceInfoScene r103 = new EnumEntranceInfoScene("ECOM_LIVE_REQUEST", 3, "ecomLiveRequest");
        ECOM_LIVE_REQUEST = r103;
        f153045a = new EnumEntranceInfoScene[]{r100, r101, r102, r103};
    }

    public static EnumEntranceInfoScene valueOf(String r100) {
        return (EnumEntranceInfoScene) r27.a.a(EnumEntranceInfoScene.class, r100);
    }

    public static EnumEntranceInfoScene[] values() {
        return (EnumEntranceInfoScene[]) f153045a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public EnumEntranceInfoScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
