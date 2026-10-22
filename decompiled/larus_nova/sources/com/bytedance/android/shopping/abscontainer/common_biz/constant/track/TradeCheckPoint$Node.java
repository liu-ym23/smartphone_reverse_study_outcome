package com.bytedance.android.shopping.abscontainer.common_biz.constant.track;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"com/bytedance/android/shopping/abscontainer/common_biz/constant/track/TradeCheckPoint$Node", "", "Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/track/TradeCheckPoint$Node;", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "ENTER_PAGE", "RENDER_REQUEST_START", "RENDER_REQUEST_SUCCESS", "RENDER_REQUEST_FAILED", "ERROR_PAGE_SHOW", "EDIT_REQUEST_START", "EDIT_REQUEST_SUCCESS", "EDIT_REQUEST_FAILED", "ORDER_REQUEST_START", "ORDER_REQUEST_SUCCESS", "ORDER_REQUEST_FAILED", "PAY_START", "CHECK_ORDER_START", "GOTO_PAGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TradeCheckPoint$Node extends Enum<TradeCheckPoint$Node> {
    public static final TradeCheckPoint$Node CHECK_ORDER_START = null;
    public static final TradeCheckPoint$Node EDIT_REQUEST_FAILED = null;
    public static final TradeCheckPoint$Node EDIT_REQUEST_START = null;
    public static final TradeCheckPoint$Node EDIT_REQUEST_SUCCESS = null;
    public static final TradeCheckPoint$Node ENTER_PAGE = null;
    public static final TradeCheckPoint$Node ERROR_PAGE_SHOW = null;
    public static final TradeCheckPoint$Node GOTO_PAGE = null;
    public static final TradeCheckPoint$Node ORDER_REQUEST_FAILED = null;
    public static final TradeCheckPoint$Node ORDER_REQUEST_START = null;
    public static final TradeCheckPoint$Node ORDER_REQUEST_SUCCESS = null;
    public static final TradeCheckPoint$Node PAY_START = null;
    public static final TradeCheckPoint$Node RENDER_REQUEST_FAILED = null;
    public static final TradeCheckPoint$Node RENDER_REQUEST_START = null;
    public static final TradeCheckPoint$Node RENDER_REQUEST_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TradeCheckPoint$Node[] f164230a = null;
    private final String rawValue;

    public static TradeCheckPoint$Node valueOf(String r100) {
        return (TradeCheckPoint$Node) a.a(TradeCheckPoint$Node.class, r100);
    }

    public static TradeCheckPoint$Node[] values() {
        return (TradeCheckPoint$Node[]) f164230a.clone();
    }

    static {
        TradeCheckPoint$Node r100 = new TradeCheckPoint$Node("ENTER_PAGE", 0, CheckPointType.ENTER_PAGE);
        ENTER_PAGE = r100;
        TradeCheckPoint$Node r101 = new TradeCheckPoint$Node("RENDER_REQUEST_START", 1, CheckPointType.RENDER_REQUEST_START);
        RENDER_REQUEST_START = r101;
        TradeCheckPoint$Node r102 = new TradeCheckPoint$Node("RENDER_REQUEST_SUCCESS", 2, CheckPointType.RENDER_REQUEST_SUCCESS);
        RENDER_REQUEST_SUCCESS = r102;
        TradeCheckPoint$Node r103 = new TradeCheckPoint$Node("RENDER_REQUEST_FAILED", 3, CheckPointType.RENDER_REQUEST_FAILED);
        RENDER_REQUEST_FAILED = r103;
        TradeCheckPoint$Node r104 = new TradeCheckPoint$Node("ERROR_PAGE_SHOW", 4, CheckPointType.ERROR_PAGE_SHOW);
        ERROR_PAGE_SHOW = r104;
        TradeCheckPoint$Node r105 = new TradeCheckPoint$Node("EDIT_REQUEST_START", 5, CheckPointType.EDIT_REQUEST_START);
        EDIT_REQUEST_START = r105;
        TradeCheckPoint$Node r106 = new TradeCheckPoint$Node("EDIT_REQUEST_SUCCESS", 6, CheckPointType.EDIT_REQUEST_SUCCESS);
        EDIT_REQUEST_SUCCESS = r106;
        TradeCheckPoint$Node r107 = new TradeCheckPoint$Node("EDIT_REQUEST_FAILED", 7, CheckPointType.EDIT_REQUEST_FAILED);
        EDIT_REQUEST_FAILED = r107;
        TradeCheckPoint$Node r108 = new TradeCheckPoint$Node("ORDER_REQUEST_START", 8, CheckPointType.ORDER_REQUEST_START);
        ORDER_REQUEST_START = r108;
        TradeCheckPoint$Node r109 = new TradeCheckPoint$Node("ORDER_REQUEST_SUCCESS", 9, CheckPointType.ORDER_REQUEST_SUCCESS);
        ORDER_REQUEST_SUCCESS = r109;
        TradeCheckPoint$Node r110 = new TradeCheckPoint$Node("ORDER_REQUEST_FAILED", 10, CheckPointType.ORDER_REQUEST_FAILED);
        ORDER_REQUEST_FAILED = r110;
        TradeCheckPoint$Node r111 = new TradeCheckPoint$Node("PAY_START", 11, CheckPointType.PAY_START);
        PAY_START = r111;
        TradeCheckPoint$Node r112 = new TradeCheckPoint$Node("CHECK_ORDER_START", 12, CheckPointType.CHECK_ORDER_START);
        CHECK_ORDER_START = r112;
        TradeCheckPoint$Node r113 = new TradeCheckPoint$Node("GOTO_PAGE", 13, CheckPointType.GOTO_PAGE);
        GOTO_PAGE = r113;
        f164230a = new TradeCheckPoint$Node[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public TradeCheckPoint$Node(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
