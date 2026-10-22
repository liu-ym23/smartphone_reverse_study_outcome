package com.bytedance.android.ec.host.api.search;

import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/host/api/search/MALLSCENE;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MALLSCENE_NATIVE", "MALLSCENE_HALF_LYNX", "MALLSCENE_FULL_NATIVE", "MALLSCENE_ORDER_LIST", "MALLSCENE_PROFILE", "MALLSCENE_UNKNOWN", "MALLSCENE_PAYMENT_SUCCESS_PAGE", "MALLSCENE_ORDER_DETAILS_PAGE", "MALLSCENE_PRODUCT_CARD", "MALLSCENE_MESSAGE_CUSTOMER_SERVICE", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MALLSCENE extends Enum<MALLSCENE> {
    public static final MALLSCENE MALLSCENE_FULL_NATIVE = null;
    public static final MALLSCENE MALLSCENE_HALF_LYNX = null;
    public static final MALLSCENE MALLSCENE_MESSAGE_CUSTOMER_SERVICE = null;
    public static final MALLSCENE MALLSCENE_NATIVE = null;
    public static final MALLSCENE MALLSCENE_ORDER_DETAILS_PAGE = null;
    public static final MALLSCENE MALLSCENE_ORDER_LIST = null;
    public static final MALLSCENE MALLSCENE_PAYMENT_SUCCESS_PAGE = null;
    public static final MALLSCENE MALLSCENE_PRODUCT_CARD = null;
    public static final MALLSCENE MALLSCENE_PROFILE = null;
    public static final MALLSCENE MALLSCENE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MALLSCENE[] f46185a = null;
    private final String value;

    public static MALLSCENE valueOf(String r100) {
        return (MALLSCENE) a.a(MALLSCENE.class, r100);
    }

    public static MALLSCENE[] values() {
        return (MALLSCENE[]) f46185a.clone();
    }

    static {
        MALLSCENE r100 = new MALLSCENE("MALLSCENE_NATIVE", 0, "native");
        MALLSCENE_NATIVE = r100;
        MALLSCENE r101 = new MALLSCENE("MALLSCENE_HALF_LYNX", 1, "half_lynx");
        MALLSCENE_HALF_LYNX = r101;
        MALLSCENE r102 = new MALLSCENE("MALLSCENE_FULL_NATIVE", 2, "full_native");
        MALLSCENE_FULL_NATIVE = r102;
        MALLSCENE r103 = new MALLSCENE("MALLSCENE_ORDER_LIST", 3, BuyNowUrlType.ORDER_LIST);
        MALLSCENE_ORDER_LIST = r103;
        MALLSCENE r104 = new MALLSCENE("MALLSCENE_PROFILE", 4, "profile");
        MALLSCENE_PROFILE = r104;
        MALLSCENE r105 = new MALLSCENE("MALLSCENE_UNKNOWN", 5, "unknown");
        MALLSCENE_UNKNOWN = r105;
        MALLSCENE r106 = new MALLSCENE("MALLSCENE_PAYMENT_SUCCESS_PAGE", 6, "payment_success_page");
        MALLSCENE_PAYMENT_SUCCESS_PAGE = r106;
        MALLSCENE r107 = new MALLSCENE("MALLSCENE_ORDER_DETAILS_PAGE", 7, "order_details_page");
        MALLSCENE_ORDER_DETAILS_PAGE = r107;
        MALLSCENE r108 = new MALLSCENE("MALLSCENE_PRODUCT_CARD", 8, "product_cart_page");
        MALLSCENE_PRODUCT_CARD = r108;
        MALLSCENE r109 = new MALLSCENE("MALLSCENE_MESSAGE_CUSTOMER_SERVICE", 9, "message_customer_service");
        MALLSCENE_MESSAGE_CUSTOMER_SERVICE = r109;
        f46185a = new MALLSCENE[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getValue() {
        return this.value;
    }

    public MALLSCENE(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
