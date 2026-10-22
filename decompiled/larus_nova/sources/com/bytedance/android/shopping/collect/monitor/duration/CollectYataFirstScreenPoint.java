package com.bytedance.android.shopping.collect.monitor.duration;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/collect/monitor/duration/CollectYataFirstScreenPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", GXAnimation.STATE_START, "REQUEST_START", "QUERY_NET_START", "QUERY_NET_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "REQUEST_END", ChameleonOpenTracker.EventType.RENDER_START, ChameleonOpenTracker.EventType.RENDER_END, GXAnimation.STATE_END, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectYataFirstScreenPoint extends Enum<CollectYataFirstScreenPoint> {
    public static final CollectYataFirstScreenPoint END = null;
    public static final CollectYataFirstScreenPoint PARSE_RESPONSE_END = null;
    public static final CollectYataFirstScreenPoint PARSE_RESPONSE_START = null;
    public static final CollectYataFirstScreenPoint QUERY_NET_END = null;
    public static final CollectYataFirstScreenPoint QUERY_NET_START = null;
    public static final CollectYataFirstScreenPoint RENDER_END = null;
    public static final CollectYataFirstScreenPoint RENDER_START = null;
    public static final CollectYataFirstScreenPoint REQUEST_END = null;
    public static final CollectYataFirstScreenPoint REQUEST_START = null;
    public static final CollectYataFirstScreenPoint START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectYataFirstScreenPoint[] f172236a = null;
    private final String value;

    public static CollectYataFirstScreenPoint valueOf(String r100) {
        return (CollectYataFirstScreenPoint) a.a(CollectYataFirstScreenPoint.class, r100);
    }

    public static CollectYataFirstScreenPoint[] values() {
        return (CollectYataFirstScreenPoint[]) f172236a.clone();
    }

    static {
        CollectYataFirstScreenPoint r100 = new CollectYataFirstScreenPoint(GXAnimation.STATE_START, 0, "initial");
        START = r100;
        CollectYataFirstScreenPoint r101 = new CollectYataFirstScreenPoint("REQUEST_START", 1, "request_start");
        REQUEST_START = r101;
        CollectYataFirstScreenPoint r102 = new CollectYataFirstScreenPoint("QUERY_NET_START", 2, "query_net_start");
        QUERY_NET_START = r102;
        CollectYataFirstScreenPoint r103 = new CollectYataFirstScreenPoint("QUERY_NET_END", 3, "query_net_end");
        QUERY_NET_END = r103;
        CollectYataFirstScreenPoint r104 = new CollectYataFirstScreenPoint("PARSE_RESPONSE_START", 4, "parse_response_start");
        PARSE_RESPONSE_START = r104;
        CollectYataFirstScreenPoint r105 = new CollectYataFirstScreenPoint("PARSE_RESPONSE_END", 5, "parse_response_end");
        PARSE_RESPONSE_END = r105;
        CollectYataFirstScreenPoint r106 = new CollectYataFirstScreenPoint("REQUEST_END", 6, "request_end");
        REQUEST_END = r106;
        CollectYataFirstScreenPoint r107 = new CollectYataFirstScreenPoint(ChameleonOpenTracker.EventType.RENDER_START, 7, "render_start");
        RENDER_START = r107;
        CollectYataFirstScreenPoint r108 = new CollectYataFirstScreenPoint(ChameleonOpenTracker.EventType.RENDER_END, 8, "render_end");
        RENDER_END = r108;
        CollectYataFirstScreenPoint r109 = new CollectYataFirstScreenPoint(GXAnimation.STATE_END, 9, "end");
        END = r109;
        f172236a = new CollectYataFirstScreenPoint[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getValue() {
        return this.value;
    }

    public CollectYataFirstScreenPoint(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
