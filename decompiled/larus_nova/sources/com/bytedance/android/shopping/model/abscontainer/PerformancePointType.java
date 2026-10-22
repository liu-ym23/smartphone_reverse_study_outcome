package com.bytedance.android.shopping.model.abscontainer;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/model/abscontainer/PerformancePointType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "C_PAGE_START", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "INNER_START", "QUERY_PARAM_START", "QUERY_PARAM_END", "REQUEST_START", "REQUEST_END", "FETCH_START", "FETCH_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "CONTAINER_INIT_START", "T_PAGE_START", ChameleonOpenTracker.EventType.RENDER_START, ChameleonOpenTracker.EventType.RENDER_END, "INTERACTIVE", "YATA_RENDER_START", "YATA_RENDER_END", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PerformancePointType extends Enum<PerformancePointType> {
    public static final PerformancePointType CONTAINER_INIT_START = null;
    public static final PerformancePointType C_PAGE_START = null;
    public static final PerformancePointType FETCH_END = null;
    public static final PerformancePointType FETCH_START = null;
    public static final PerformancePointType INNER_START = null;
    public static final PerformancePointType INTERACTIVE = null;
    public static final PerformancePointType PARSE_RESPONSE_END = null;
    public static final PerformancePointType PARSE_RESPONSE_START = null;
    public static final PerformancePointType PARSE_SCHEMA_END = null;
    public static final PerformancePointType PARSE_SCHEMA_START = null;
    public static final PerformancePointType QUERY_PARAM_END = null;
    public static final PerformancePointType QUERY_PARAM_START = null;
    public static final PerformancePointType RENDER_END = null;
    public static final PerformancePointType RENDER_START = null;
    public static final PerformancePointType REQUEST_END = null;
    public static final PerformancePointType REQUEST_START = null;
    public static final PerformancePointType T_PAGE_START = null;
    public static final PerformancePointType YATA_RENDER_END = null;
    public static final PerformancePointType YATA_RENDER_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerformancePointType[] f178653a = null;
    private final String value;

    public static PerformancePointType valueOf(String r100) {
        return (PerformancePointType) a.a(PerformancePointType.class, r100);
    }

    public static PerformancePointType[] values() {
        return (PerformancePointType[]) f178653a.clone();
    }

    static {
        PerformancePointType r100 = new PerformancePointType("C_PAGE_START", 0, "C_PAGE_START");
        C_PAGE_START = r100;
        PerformancePointType r101 = new PerformancePointType("PARSE_SCHEMA_START", 1, "C_PARSE_SCHEMA_START");
        PARSE_SCHEMA_START = r101;
        PerformancePointType r102 = new PerformancePointType("PARSE_SCHEMA_END", 2, "C_PARSE_SCHEMA_END");
        PARSE_SCHEMA_END = r102;
        PerformancePointType r103 = new PerformancePointType("INNER_START", 3, "C_INNER_START");
        INNER_START = r103;
        PerformancePointType r104 = new PerformancePointType("QUERY_PARAM_START", 4, "C_QUERY_PARAM_START");
        QUERY_PARAM_START = r104;
        PerformancePointType r105 = new PerformancePointType("QUERY_PARAM_END", 5, "C_QUERY_PARAM_END");
        QUERY_PARAM_END = r105;
        PerformancePointType r106 = new PerformancePointType("REQUEST_START", 6, "request_start");
        REQUEST_START = r106;
        PerformancePointType r107 = new PerformancePointType("REQUEST_END", 7, "request_end");
        REQUEST_END = r107;
        PerformancePointType r108 = new PerformancePointType("FETCH_START", 8, "T_MAIN_FETCH_START");
        FETCH_START = r108;
        PerformancePointType r109 = new PerformancePointType("FETCH_END", 9, "T_MAIN_FETCH_END");
        FETCH_END = r109;
        PerformancePointType r110 = new PerformancePointType("PARSE_RESPONSE_START", 10, "C_PARSE_RESPONSE_START");
        PARSE_RESPONSE_START = r110;
        PerformancePointType r111 = new PerformancePointType("PARSE_RESPONSE_END", 11, "C_PARSE_RESPONSE_END");
        PARSE_RESPONSE_END = r111;
        PerformancePointType r112 = new PerformancePointType("CONTAINER_INIT_START", 12, "T_CONTAINER_INIT");
        CONTAINER_INIT_START = r112;
        PerformancePointType r113 = new PerformancePointType("T_PAGE_START", 13, "T_PAGE_START");
        T_PAGE_START = r113;
        PerformancePointType r114 = new PerformancePointType(ChameleonOpenTracker.EventType.RENDER_START, 14, "T_RENDER_START");
        RENDER_START = r114;
        PerformancePointType r115 = new PerformancePointType(ChameleonOpenTracker.EventType.RENDER_END, 15, "T_RENDER_END");
        RENDER_END = r115;
        PerformancePointType r116 = new PerformancePointType("INTERACTIVE", 16, "T_INTERACTIVE");
        INTERACTIVE = r116;
        PerformancePointType r117 = new PerformancePointType("YATA_RENDER_START", 17, "C_YATA_RENDER_START");
        YATA_RENDER_START = r117;
        PerformancePointType r118 = new PerformancePointType("YATA_RENDER_END", 18, "C_YATA_RENDER_END");
        YATA_RENDER_END = r118;
        f178653a = new PerformancePointType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public final String getValue() {
        return this.value;
    }

    public PerformancePointType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
