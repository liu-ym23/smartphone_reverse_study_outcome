package com.bytedance.android.shopping.buynow.monitor.param;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/buynow/monitor/param/BuyNowFirstScreenNode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PRELOAD_TEMPLATE_START", "PRELOAD_TEMPLATE_END", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "QUERY_PARAM_START", "QUERY_PARAM_END", "NATIVE_NET_START", "NATIVE_NET_END", "FETCH_START", "FETCH_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "T_REAL_SERVER_START", "T_REAL_SERVER_END", "CONTAINER_INIT_START", "PAGE_START", "PAGE_INIT_END", "YATA_INIT_START", "YATA_INIT_END", "YATA_RENDER_START", "YATA_RENDER_END", "CACHE_RENDER_START", "CACHE_RENDER_END", ChameleonOpenTracker.EventType.RENDER_START, ChameleonOpenTracker.EventType.RENDER_END, "INTERACTIVE", "INITIAL", "REQUEST_START", "REQUEST_END", "STANDARD_RENDER_START", "STANDARD_RENDER_END", GXAnimation.STATE_END, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowFirstScreenNode extends Enum<BuyNowFirstScreenNode> {
    public static final BuyNowFirstScreenNode CACHE_RENDER_END = null;
    public static final BuyNowFirstScreenNode CACHE_RENDER_START = null;
    public static final BuyNowFirstScreenNode CONTAINER_INIT_START = null;
    public static final BuyNowFirstScreenNode END = null;
    public static final BuyNowFirstScreenNode FETCH_END = null;
    public static final BuyNowFirstScreenNode FETCH_START = null;
    public static final BuyNowFirstScreenNode INITIAL = null;
    public static final BuyNowFirstScreenNode INTERACTIVE = null;
    public static final BuyNowFirstScreenNode NATIVE_NET_END = null;
    public static final BuyNowFirstScreenNode NATIVE_NET_START = null;
    public static final BuyNowFirstScreenNode PAGE_INIT_END = null;
    public static final BuyNowFirstScreenNode PAGE_START = null;
    public static final BuyNowFirstScreenNode PARSE_RESPONSE_END = null;
    public static final BuyNowFirstScreenNode PARSE_RESPONSE_START = null;
    public static final BuyNowFirstScreenNode PARSE_SCHEMA_END = null;
    public static final BuyNowFirstScreenNode PARSE_SCHEMA_START = null;
    public static final BuyNowFirstScreenNode PRELOAD_TEMPLATE_END = null;
    public static final BuyNowFirstScreenNode PRELOAD_TEMPLATE_START = null;
    public static final BuyNowFirstScreenNode QUERY_PARAM_END = null;
    public static final BuyNowFirstScreenNode QUERY_PARAM_START = null;
    public static final BuyNowFirstScreenNode RENDER_END = null;
    public static final BuyNowFirstScreenNode RENDER_START = null;
    public static final BuyNowFirstScreenNode REQUEST_END = null;
    public static final BuyNowFirstScreenNode REQUEST_START = null;
    public static final BuyNowFirstScreenNode STANDARD_RENDER_END = null;
    public static final BuyNowFirstScreenNode STANDARD_RENDER_START = null;
    public static final BuyNowFirstScreenNode T_REAL_SERVER_END = null;
    public static final BuyNowFirstScreenNode T_REAL_SERVER_START = null;
    public static final BuyNowFirstScreenNode YATA_INIT_END = null;
    public static final BuyNowFirstScreenNode YATA_INIT_START = null;
    public static final BuyNowFirstScreenNode YATA_RENDER_END = null;
    public static final BuyNowFirstScreenNode YATA_RENDER_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowFirstScreenNode[] f171025a = null;
    private final String value;

    public static BuyNowFirstScreenNode valueOf(String r100) {
        return (BuyNowFirstScreenNode) a.a(BuyNowFirstScreenNode.class, r100);
    }

    public static BuyNowFirstScreenNode[] values() {
        return (BuyNowFirstScreenNode[]) f171025a.clone();
    }

    static {
        BuyNowFirstScreenNode r100 = new BuyNowFirstScreenNode("PRELOAD_TEMPLATE_START", 0, "preload_template_start");
        PRELOAD_TEMPLATE_START = r100;
        BuyNowFirstScreenNode r101 = new BuyNowFirstScreenNode("PRELOAD_TEMPLATE_END", 1, "preload_template_end");
        PRELOAD_TEMPLATE_END = r101;
        BuyNowFirstScreenNode r102 = new BuyNowFirstScreenNode("PARSE_SCHEMA_START", 2, "C_PARSE_SCHEMA_START");
        PARSE_SCHEMA_START = r102;
        BuyNowFirstScreenNode r103 = new BuyNowFirstScreenNode("PARSE_SCHEMA_END", 3, "C_PARSE_SCHEMA_END");
        PARSE_SCHEMA_END = r103;
        BuyNowFirstScreenNode r104 = new BuyNowFirstScreenNode("QUERY_PARAM_START", 4, "C_QUERY_PARAM_START");
        QUERY_PARAM_START = r104;
        BuyNowFirstScreenNode r105 = new BuyNowFirstScreenNode("QUERY_PARAM_END", 5, "C_QUERY_PARAM_END");
        QUERY_PARAM_END = r105;
        BuyNowFirstScreenNode r106 = new BuyNowFirstScreenNode("NATIVE_NET_START", 6, "C_native_net_start_time");
        NATIVE_NET_START = r106;
        BuyNowFirstScreenNode r107 = new BuyNowFirstScreenNode("NATIVE_NET_END", 7, "C_native_net_end_time");
        NATIVE_NET_END = r107;
        BuyNowFirstScreenNode r108 = new BuyNowFirstScreenNode("FETCH_START", 8, "T_MAIN_FETCH_START");
        FETCH_START = r108;
        BuyNowFirstScreenNode r109 = new BuyNowFirstScreenNode("FETCH_END", 9, "T_MAIN_FETCH_END");
        FETCH_END = r109;
        BuyNowFirstScreenNode r110 = new BuyNowFirstScreenNode("PARSE_RESPONSE_START", 10, "C_PARSE_RESPONSE_START");
        PARSE_RESPONSE_START = r110;
        BuyNowFirstScreenNode r111 = new BuyNowFirstScreenNode("PARSE_RESPONSE_END", 11, "C_PARSE_RESPONSE_END");
        PARSE_RESPONSE_END = r111;
        BuyNowFirstScreenNode r112 = new BuyNowFirstScreenNode("T_REAL_SERVER_START", 12, "T_REAL_SERVER_START");
        T_REAL_SERVER_START = r112;
        BuyNowFirstScreenNode r113 = new BuyNowFirstScreenNode("T_REAL_SERVER_END", 13, "T_REAL_SERVER_END");
        T_REAL_SERVER_END = r113;
        BuyNowFirstScreenNode r114 = new BuyNowFirstScreenNode("CONTAINER_INIT_START", 14, "T_CONTAINER_INIT");
        CONTAINER_INIT_START = r114;
        BuyNowFirstScreenNode r115 = new BuyNowFirstScreenNode("PAGE_START", 15, "T_PAGE_START");
        PAGE_START = r115;
        BuyNowFirstScreenNode r116 = new BuyNowFirstScreenNode("PAGE_INIT_END", 16, "C_PAGE_INIT_END");
        PAGE_INIT_END = r116;
        BuyNowFirstScreenNode r117 = new BuyNowFirstScreenNode("YATA_INIT_START", 17, "C_INIT_YATA_START");
        YATA_INIT_START = r117;
        BuyNowFirstScreenNode r118 = new BuyNowFirstScreenNode("YATA_INIT_END", 18, "C_INIT_YATA_END");
        YATA_INIT_END = r118;
        BuyNowFirstScreenNode r119 = new BuyNowFirstScreenNode("YATA_RENDER_START", 19, "C_YATA_RENDER_START");
        YATA_RENDER_START = r119;
        BuyNowFirstScreenNode r120 = new BuyNowFirstScreenNode("YATA_RENDER_END", 20, "C_YATA_RENDER_END");
        YATA_RENDER_END = r120;
        BuyNowFirstScreenNode r121 = new BuyNowFirstScreenNode("CACHE_RENDER_START", 21, "C_CACHE_RENDER_START");
        CACHE_RENDER_START = r121;
        BuyNowFirstScreenNode r122 = new BuyNowFirstScreenNode("CACHE_RENDER_END", 22, "C_CACHE_RENDER_END");
        CACHE_RENDER_END = r122;
        BuyNowFirstScreenNode r123 = new BuyNowFirstScreenNode(ChameleonOpenTracker.EventType.RENDER_START, 23, "T_RENDER_START");
        RENDER_START = r123;
        BuyNowFirstScreenNode r124 = new BuyNowFirstScreenNode(ChameleonOpenTracker.EventType.RENDER_END, 24, "T_RENDER_END");
        RENDER_END = r124;
        BuyNowFirstScreenNode r125 = new BuyNowFirstScreenNode("INTERACTIVE", 25, "T_INTERACTIVE");
        INTERACTIVE = r125;
        BuyNowFirstScreenNode r126 = new BuyNowFirstScreenNode("INITIAL", 26, "initial");
        INITIAL = r126;
        BuyNowFirstScreenNode r127 = new BuyNowFirstScreenNode("REQUEST_START", 27, "request_start");
        REQUEST_START = r127;
        BuyNowFirstScreenNode r128 = new BuyNowFirstScreenNode("REQUEST_END", 28, "request_end");
        REQUEST_END = r128;
        BuyNowFirstScreenNode r129 = new BuyNowFirstScreenNode("STANDARD_RENDER_START", 29, "render_start");
        STANDARD_RENDER_START = r129;
        BuyNowFirstScreenNode r130 = new BuyNowFirstScreenNode("STANDARD_RENDER_END", 30, "render_end");
        STANDARD_RENDER_END = r130;
        BuyNowFirstScreenNode r131 = new BuyNowFirstScreenNode(GXAnimation.STATE_END, 31, "end");
        END = r131;
        f171025a = new BuyNowFirstScreenNode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
    }

    public final String getValue() {
        return this.value;
    }

    public BuyNowFirstScreenNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
