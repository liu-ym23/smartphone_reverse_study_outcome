package com.bytedance.android.shopping.anchorv3.utils.purchaseV2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/utils/purchaseV2/Business;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "VIDEO_SKU", "VIDEO_SUBMIT_ORDER", "VIDEO_ULTIMATE_BUY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Business extends Enum<Business> {
    public static final Business VIDEO_SKU = null;
    public static final Business VIDEO_SUBMIT_ORDER = null;
    public static final Business VIDEO_ULTIMATE_BUY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Business[] f165318a = null;
    private final String value;

    static {
        Business r100 = new Business("VIDEO_SKU", 0, "video_sku_android");
        VIDEO_SKU = r100;
        Business r101 = new Business("VIDEO_SUBMIT_ORDER", 1, "video_submit_order_android");
        VIDEO_SUBMIT_ORDER = r101;
        Business r102 = new Business("VIDEO_ULTIMATE_BUY", 2, "video_ultimate_buy_android");
        VIDEO_ULTIMATE_BUY = r102;
        f165318a = new Business[]{r100, r101, r102};
    }

    public static Business valueOf(String r100) {
        return (Business) r27.a.a(Business.class, r100);
    }

    public static Business[] values() {
        return (Business[]) f165318a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Business(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
