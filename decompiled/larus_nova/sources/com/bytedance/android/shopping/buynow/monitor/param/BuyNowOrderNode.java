package com.bytedance.android.shopping.buynow.monitor.param;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/buynow/monitor/param/BuyNowOrderNode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ORDER_SUBMIT", "ORDER_CREATE_START", "ORDER_CREATE_NET_START", "ORDER_CREATE_NET_END", "ORDER_CREATE_END", "ORDER_TTPAY_CALL_START", "ORDER_TTPAY_START", "ORDER_TTPAY_CONFIRM_PAY_START", "ORDER_TTPAY_CHECK_PAY_START", "ORDER_TTPAY_END", "ORDER_TTPAY_CALL_END", "ORDER_CHECK_START", "ORDER_CHECK_END", GXAnimation.STATE_END, "INITIAL", "REQUEST_START", "REQUEST_END", "STANDARD_RENDER_START", "STANDARD_RENDER_END", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowOrderNode extends Enum<BuyNowOrderNode> {
    public static final BuyNowOrderNode END = null;
    public static final BuyNowOrderNode INITIAL = null;
    public static final BuyNowOrderNode ORDER_CHECK_END = null;
    public static final BuyNowOrderNode ORDER_CHECK_START = null;
    public static final BuyNowOrderNode ORDER_CREATE_END = null;
    public static final BuyNowOrderNode ORDER_CREATE_NET_END = null;
    public static final BuyNowOrderNode ORDER_CREATE_NET_START = null;
    public static final BuyNowOrderNode ORDER_CREATE_START = null;
    public static final BuyNowOrderNode ORDER_SUBMIT = null;
    public static final BuyNowOrderNode ORDER_TTPAY_CALL_END = null;
    public static final BuyNowOrderNode ORDER_TTPAY_CALL_START = null;
    public static final BuyNowOrderNode ORDER_TTPAY_CHECK_PAY_START = null;
    public static final BuyNowOrderNode ORDER_TTPAY_CONFIRM_PAY_START = null;
    public static final BuyNowOrderNode ORDER_TTPAY_END = null;
    public static final BuyNowOrderNode ORDER_TTPAY_START = null;
    public static final BuyNowOrderNode REQUEST_END = null;
    public static final BuyNowOrderNode REQUEST_START = null;
    public static final BuyNowOrderNode STANDARD_RENDER_END = null;
    public static final BuyNowOrderNode STANDARD_RENDER_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowOrderNode[] f171026a = null;
    private final String value;

    public static BuyNowOrderNode valueOf(String r100) {
        return (BuyNowOrderNode) a.a(BuyNowOrderNode.class, r100);
    }

    public static BuyNowOrderNode[] values() {
        return (BuyNowOrderNode[]) f171026a.clone();
    }

    static {
        BuyNowOrderNode r100 = new BuyNowOrderNode("ORDER_SUBMIT", 0, "C_ORDER_SUBMIT");
        ORDER_SUBMIT = r100;
        BuyNowOrderNode r101 = new BuyNowOrderNode("ORDER_CREATE_START", 1, "C_ORDER_CREATE_START");
        ORDER_CREATE_START = r101;
        BuyNowOrderNode r102 = new BuyNowOrderNode("ORDER_CREATE_NET_START", 2, "C_ORDER_CREATE_NET_START");
        ORDER_CREATE_NET_START = r102;
        BuyNowOrderNode r103 = new BuyNowOrderNode("ORDER_CREATE_NET_END", 3, "C_ORDER_CREATE_NET_END");
        ORDER_CREATE_NET_END = r103;
        BuyNowOrderNode r104 = new BuyNowOrderNode("ORDER_CREATE_END", 4, "C_ORDER_CREATE_END");
        ORDER_CREATE_END = r104;
        BuyNowOrderNode r105 = new BuyNowOrderNode("ORDER_TTPAY_CALL_START", 5, "C_ORDER_TTPAY_CALL_START");
        ORDER_TTPAY_CALL_START = r105;
        BuyNowOrderNode r106 = new BuyNowOrderNode("ORDER_TTPAY_START", 6, "C_ORDER_TTPAY_START");
        ORDER_TTPAY_START = r106;
        BuyNowOrderNode r107 = new BuyNowOrderNode("ORDER_TTPAY_CONFIRM_PAY_START", 7, "C_ORDER_TTPAY_CONFIRM_PAY_START");
        ORDER_TTPAY_CONFIRM_PAY_START = r107;
        BuyNowOrderNode r108 = new BuyNowOrderNode("ORDER_TTPAY_CHECK_PAY_START", 8, "C_ORDER_TTPAY_CHECK_PAY_START");
        ORDER_TTPAY_CHECK_PAY_START = r108;
        BuyNowOrderNode r109 = new BuyNowOrderNode("ORDER_TTPAY_END", 9, "C_ORDER_TTPAY_END");
        ORDER_TTPAY_END = r109;
        BuyNowOrderNode r110 = new BuyNowOrderNode("ORDER_TTPAY_CALL_END", 10, "C_ORDER_TTPAY_CALL_END");
        ORDER_TTPAY_CALL_END = r110;
        BuyNowOrderNode r111 = new BuyNowOrderNode("ORDER_CHECK_START", 11, "C_ORDER_CHECK_START");
        ORDER_CHECK_START = r111;
        BuyNowOrderNode r112 = new BuyNowOrderNode("ORDER_CHECK_END", 12, "C_ORDER_CHECK_END");
        ORDER_CHECK_END = r112;
        BuyNowOrderNode r113 = new BuyNowOrderNode(GXAnimation.STATE_END, 13, "C_END");
        END = r113;
        BuyNowOrderNode r114 = new BuyNowOrderNode("INITIAL", 14, "initial");
        INITIAL = r114;
        BuyNowOrderNode r115 = new BuyNowOrderNode("REQUEST_START", 15, "request_start");
        REQUEST_START = r115;
        BuyNowOrderNode r116 = new BuyNowOrderNode("REQUEST_END", 16, "request_end");
        REQUEST_END = r116;
        BuyNowOrderNode r117 = new BuyNowOrderNode("STANDARD_RENDER_START", 17, "render_start");
        STANDARD_RENDER_START = r117;
        BuyNowOrderNode r118 = new BuyNowOrderNode("STANDARD_RENDER_END", 18, "render_end");
        STANDARD_RENDER_END = r118;
        f171026a = new BuyNowOrderNode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public final String getValue() {
        return this.value;
    }

    public BuyNowOrderNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
