package com.bytedance.android.shopping.sku.common.controller;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/controller/SkuHandleEventOpportunity;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CLOTHES_SIZE_ASSISTANT", "PAGE_APPEAR_START", "PAGE_APPEAR_RESUME", "CAR_ADAPTER", "POI_STORE_ENTRY", "RECEIVE_LIVE_ROOM_NOTICE", "RECEIVE_UPDATE_SKU_NOTICE", "PAY_FOR_FIX_NEXT_PAGE_EVENT", "PREVIEW_CLICK_DETAIL", "QUIT_BUYNOW_PAGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuHandleEventOpportunity extends Enum<SkuHandleEventOpportunity> {
    public static final SkuHandleEventOpportunity CAR_ADAPTER = null;
    public static final SkuHandleEventOpportunity CLOTHES_SIZE_ASSISTANT = null;
    public static final SkuHandleEventOpportunity PAGE_APPEAR_RESUME = null;
    public static final SkuHandleEventOpportunity PAGE_APPEAR_START = null;
    public static final SkuHandleEventOpportunity PAY_FOR_FIX_NEXT_PAGE_EVENT = null;
    public static final SkuHandleEventOpportunity POI_STORE_ENTRY = null;
    public static final SkuHandleEventOpportunity PREVIEW_CLICK_DETAIL = null;
    public static final SkuHandleEventOpportunity QUIT_BUYNOW_PAGE = null;
    public static final SkuHandleEventOpportunity RECEIVE_LIVE_ROOM_NOTICE = null;
    public static final SkuHandleEventOpportunity RECEIVE_UPDATE_SKU_NOTICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuHandleEventOpportunity[] f182623a = null;
    private final String value;

    public static SkuHandleEventOpportunity valueOf(String r100) {
        return (SkuHandleEventOpportunity) r27.a.a(SkuHandleEventOpportunity.class, r100);
    }

    public static SkuHandleEventOpportunity[] values() {
        return (SkuHandleEventOpportunity[]) f182623a.clone();
    }

    static {
        SkuHandleEventOpportunity r100 = new SkuHandleEventOpportunity("CLOTHES_SIZE_ASSISTANT", 0, "clothes_size_assistant");
        CLOTHES_SIZE_ASSISTANT = r100;
        SkuHandleEventOpportunity r101 = new SkuHandleEventOpportunity("PAGE_APPEAR_START", 1, "page_appear_start");
        PAGE_APPEAR_START = r101;
        SkuHandleEventOpportunity r102 = new SkuHandleEventOpportunity("PAGE_APPEAR_RESUME", 2, "page_appear_resume");
        PAGE_APPEAR_RESUME = r102;
        SkuHandleEventOpportunity r103 = new SkuHandleEventOpportunity("CAR_ADAPTER", 3, "car_adapter");
        CAR_ADAPTER = r103;
        SkuHandleEventOpportunity r104 = new SkuHandleEventOpportunity("POI_STORE_ENTRY", 4, "poi_store_entry");
        POI_STORE_ENTRY = r104;
        SkuHandleEventOpportunity r105 = new SkuHandleEventOpportunity("RECEIVE_LIVE_ROOM_NOTICE", 5, "receive_live_room_notice");
        RECEIVE_LIVE_ROOM_NOTICE = r105;
        SkuHandleEventOpportunity r106 = new SkuHandleEventOpportunity("RECEIVE_UPDATE_SKU_NOTICE", 6, "receive_update_sku_notice");
        RECEIVE_UPDATE_SKU_NOTICE = r106;
        SkuHandleEventOpportunity r107 = new SkuHandleEventOpportunity("PAY_FOR_FIX_NEXT_PAGE_EVENT", 7, "pay_for_fix_next_page_event");
        PAY_FOR_FIX_NEXT_PAGE_EVENT = r107;
        SkuHandleEventOpportunity r108 = new SkuHandleEventOpportunity("PREVIEW_CLICK_DETAIL", 8, "preview_click_detail");
        PREVIEW_CLICK_DETAIL = r108;
        SkuHandleEventOpportunity r109 = new SkuHandleEventOpportunity("QUIT_BUYNOW_PAGE", 9, "quit_buynow_page");
        QUIT_BUYNOW_PAGE = r109;
        f182623a = new SkuHandleEventOpportunity[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getValue() {
        return this.value;
    }

    public SkuHandleEventOpportunity(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
