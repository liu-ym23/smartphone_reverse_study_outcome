package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN", "SUCCESS", "CANCELLED", "TIMEOUT", "INTERRUPTED", "INVALID_RENDER_TIMING", "WIDGET_RENDER_ERROR", "RENDER_VIEW_CREATE_ERROR", "PAGE_RENDER_ERROR", "ROUTE_ERROR", "LOAD_PACKAGE_ERROR", "SCRIPT_EVALUATION_ERROR", "SCRIPT_LOAD_ERROR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceErrorCode extends Enum<AppletPerformanceErrorCode> {
    public static final AppletPerformanceErrorCode CANCELLED = null;
    public static final AppletPerformanceErrorCode INTERRUPTED = null;
    public static final AppletPerformanceErrorCode INVALID_RENDER_TIMING = null;
    public static final AppletPerformanceErrorCode LOAD_PACKAGE_ERROR = null;
    public static final AppletPerformanceErrorCode PAGE_RENDER_ERROR = null;
    public static final AppletPerformanceErrorCode RENDER_VIEW_CREATE_ERROR = null;
    public static final AppletPerformanceErrorCode ROUTE_ERROR = null;
    public static final AppletPerformanceErrorCode SCRIPT_EVALUATION_ERROR = null;
    public static final AppletPerformanceErrorCode SCRIPT_LOAD_ERROR = null;
    public static final AppletPerformanceErrorCode SUCCESS = null;
    public static final AppletPerformanceErrorCode TIMEOUT = null;
    public static final AppletPerformanceErrorCode UNKNOWN = null;
    public static final AppletPerformanceErrorCode WIDGET_RENDER_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletPerformanceErrorCode[] f34233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34234b = null;
    private final int code;

    public static EnumEntries<AppletPerformanceErrorCode> getEntries() {
        return f34234b;
    }

    static {
        AppletPerformanceErrorCode r100 = new AppletPerformanceErrorCode("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        AppletPerformanceErrorCode r101 = new AppletPerformanceErrorCode("SUCCESS", 1, 0);
        SUCCESS = r101;
        AppletPerformanceErrorCode r102 = new AppletPerformanceErrorCode("CANCELLED", 2, 1);
        CANCELLED = r102;
        AppletPerformanceErrorCode r103 = new AppletPerformanceErrorCode("TIMEOUT", 3, 2);
        TIMEOUT = r103;
        AppletPerformanceErrorCode r104 = new AppletPerformanceErrorCode("INTERRUPTED", 4, 3);
        INTERRUPTED = r104;
        AppletPerformanceErrorCode r105 = new AppletPerformanceErrorCode("INVALID_RENDER_TIMING", 5, 100);
        INVALID_RENDER_TIMING = r105;
        AppletPerformanceErrorCode r110 = new AppletPerformanceErrorCode("WIDGET_RENDER_ERROR", 6, 101);
        WIDGET_RENDER_ERROR = r110;
        AppletPerformanceErrorCode r111 = new AppletPerformanceErrorCode("RENDER_VIEW_CREATE_ERROR", 7, 102);
        RENDER_VIEW_CREATE_ERROR = r111;
        AppletPerformanceErrorCode r112 = new AppletPerformanceErrorCode("PAGE_RENDER_ERROR", 8, 103);
        PAGE_RENDER_ERROR = r112;
        AppletPerformanceErrorCode r113 = new AppletPerformanceErrorCode("ROUTE_ERROR", 9, 104);
        ROUTE_ERROR = r113;
        AppletPerformanceErrorCode r114 = new AppletPerformanceErrorCode("LOAD_PACKAGE_ERROR", 10, 105);
        LOAD_PACKAGE_ERROR = r114;
        AppletPerformanceErrorCode r106 = new AppletPerformanceErrorCode("SCRIPT_EVALUATION_ERROR", 11, 200);
        SCRIPT_EVALUATION_ERROR = r106;
        AppletPerformanceErrorCode r107 = new AppletPerformanceErrorCode("SCRIPT_LOAD_ERROR", 12, 201);
        SCRIPT_LOAD_ERROR = r107;
        AppletPerformanceErrorCode[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
        f34233a = r108;
        f34234b = EnumEntriesKt.enumEntries(r108);
    }

    public static AppletPerformanceErrorCode[] values() {
        return (AppletPerformanceErrorCode[]) f34233a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static AppletPerformanceErrorCode valueOf(String r100) {
        return (AppletPerformanceErrorCode) r27.a.a(AppletPerformanceErrorCode.class, r100);
    }

    public AppletPerformanceErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
