package com.bytedance.android.live.revenue.platform.trace.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/trace/api/ProductId;", "", "", "string", "Ljava/lang/String;", "getString", "()Ljava/lang/String;", "REVENUE_LINK", "REVENUE_SEND_GIFT", "REVENUE_GIFT_PANEL_SEND_ACTION", "REVENUE_PROFIT_CHECK", "RED_PACKET", "TASK_CENTER", "RECHARGE", "MULTI_SCENE", "CHAT_CHANNEL", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ProductId extends Enum<ProductId> {
    public static final ProductId CHAT_CHANNEL = null;
    public static final ProductId MULTI_SCENE = null;
    public static final ProductId RECHARGE = null;
    public static final ProductId RED_PACKET = null;
    public static final ProductId REVENUE_GIFT_PANEL_SEND_ACTION = null;
    public static final ProductId REVENUE_LINK = null;
    public static final ProductId REVENUE_PROFIT_CHECK = null;
    public static final ProductId REVENUE_SEND_GIFT = null;
    public static final ProductId TASK_CENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductId[] f91704a = null;
    private final String string;

    public static ProductId valueOf(String r100) {
        return (ProductId) a.a(ProductId.class, r100);
    }

    public static ProductId[] values() {
        return (ProductId[]) f91704a.clone();
    }

    static {
        ProductId r100 = new ProductId("REVENUE_LINK", 0, "webcast_client_revenue_interact");
        REVENUE_LINK = r100;
        ProductId r101 = new ProductId("REVENUE_SEND_GIFT", 1, "webcast_client_revenue_gift");
        REVENUE_SEND_GIFT = r101;
        ProductId r102 = new ProductId("REVENUE_GIFT_PANEL_SEND_ACTION", 2, "webcast_client_revenue_gift_panel");
        REVENUE_GIFT_PANEL_SEND_ACTION = r102;
        ProductId r103 = new ProductId("REVENUE_PROFIT_CHECK", 3, "webcast_client_profit_check");
        REVENUE_PROFIT_CHECK = r103;
        ProductId r104 = new ProductId("RED_PACKET", 4, "webcast_client_red_packet");
        RED_PACKET = r104;
        ProductId r105 = new ProductId("TASK_CENTER", 5, "webcast_client_revenue_task_center");
        TASK_CENTER = r105;
        ProductId r106 = new ProductId("RECHARGE", 6, "webcast_client_recharge");
        RECHARGE = r106;
        ProductId r107 = new ProductId("MULTI_SCENE", 7, "webcast_client_multi_scene");
        MULTI_SCENE = r107;
        ProductId r108 = new ProductId("CHAT_CHANNEL", 8, "webcast_client_chat_channel");
        CHAT_CHANNEL = r108;
        f91704a = new ProductId[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getString() {
        return this.string;
    }

    public ProductId(String r100, int r101, String r102) {
        super(r100, r101);
        this.string = r102;
    }
}
