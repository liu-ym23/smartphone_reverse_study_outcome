package com.bytedance.ai.monitor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/monitor/AppletErrorCode;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "SUCCESS", "APPLET_NOT_FOUND", "MAIN_JS_EMPTY", "TEMPLATE_BUNDLE_EMPTY", "PAGE_NOT_FOUND", "RUNTIME_ENTRY_EMPTY", "PAGE_NOT_READY", "JS_ERROR", "JS_WARNING", "WIDGET_LOAD_ERROR", "WEB_VIEW_CREATE_ERROR", "WEB_VIEW_LOAD_ERROR", "APPLET_RUNTIME_LOAD_ERROR", "LYNX_VIEW_CREATE_ERROR", "HOST_ACTIVITY_EMPTY", "RENDER_VIEW_CREATE_ERROR", "WIDGET_BIND_CANCEL_ERROR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletErrorCode extends Enum<AppletErrorCode> {
    public static final AppletErrorCode APPLET_NOT_FOUND = null;
    public static final AppletErrorCode APPLET_RUNTIME_LOAD_ERROR = null;
    public static final AppletErrorCode HOST_ACTIVITY_EMPTY = null;
    public static final AppletErrorCode JS_ERROR = null;
    public static final AppletErrorCode JS_WARNING = null;
    public static final AppletErrorCode LYNX_VIEW_CREATE_ERROR = null;
    public static final AppletErrorCode MAIN_JS_EMPTY = null;
    public static final AppletErrorCode PAGE_NOT_FOUND = null;
    public static final AppletErrorCode PAGE_NOT_READY = null;
    public static final AppletErrorCode RENDER_VIEW_CREATE_ERROR = null;
    public static final AppletErrorCode RUNTIME_ENTRY_EMPTY = null;
    public static final AppletErrorCode SUCCESS = null;
    public static final AppletErrorCode TEMPLATE_BUNDLE_EMPTY = null;
    public static final AppletErrorCode WEB_VIEW_CREATE_ERROR = null;
    public static final AppletErrorCode WEB_VIEW_LOAD_ERROR = null;
    public static final AppletErrorCode WIDGET_BIND_CANCEL_ERROR = null;
    public static final AppletErrorCode WIDGET_LOAD_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletErrorCode[] f37129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37130b = null;
    private int type;

    public static EnumEntries<AppletErrorCode> getEntries() {
        return f37130b;
    }

    static {
        AppletErrorCode r100 = new AppletErrorCode("SUCCESS", 0, 0);
        SUCCESS = r100;
        AppletErrorCode r101 = new AppletErrorCode("APPLET_NOT_FOUND", 1, 101);
        APPLET_NOT_FOUND = r101;
        AppletErrorCode r102 = new AppletErrorCode("MAIN_JS_EMPTY", 2, 102);
        MAIN_JS_EMPTY = r102;
        AppletErrorCode r103 = new AppletErrorCode("TEMPLATE_BUNDLE_EMPTY", 3, 103);
        TEMPLATE_BUNDLE_EMPTY = r103;
        AppletErrorCode r104 = new AppletErrorCode("PAGE_NOT_FOUND", 4, 104);
        PAGE_NOT_FOUND = r104;
        AppletErrorCode r105 = new AppletErrorCode("RUNTIME_ENTRY_EMPTY", 5, 105);
        RUNTIME_ENTRY_EMPTY = r105;
        AppletErrorCode r110 = new AppletErrorCode("PAGE_NOT_READY", 6, 106);
        PAGE_NOT_READY = r110;
        AppletErrorCode r111 = new AppletErrorCode("JS_ERROR", 7, 201);
        JS_ERROR = r111;
        AppletErrorCode r112 = new AppletErrorCode("JS_WARNING", 8, 202);
        JS_WARNING = r112;
        AppletErrorCode r113 = new AppletErrorCode("WIDGET_LOAD_ERROR", 9, 401);
        WIDGET_LOAD_ERROR = r113;
        AppletErrorCode r114 = new AppletErrorCode("WEB_VIEW_CREATE_ERROR", 10, 402);
        WEB_VIEW_CREATE_ERROR = r114;
        AppletErrorCode r106 = new AppletErrorCode("WEB_VIEW_LOAD_ERROR", 11, 403);
        WEB_VIEW_LOAD_ERROR = r106;
        AppletErrorCode r107 = new AppletErrorCode("APPLET_RUNTIME_LOAD_ERROR", 12, 404);
        APPLET_RUNTIME_LOAD_ERROR = r107;
        AppletErrorCode r108 = new AppletErrorCode("LYNX_VIEW_CREATE_ERROR", 13, 405);
        LYNX_VIEW_CREATE_ERROR = r108;
        AppletErrorCode r109 = new AppletErrorCode("HOST_ACTIVITY_EMPTY", 14, 406);
        HOST_ACTIVITY_EMPTY = r109;
        AppletErrorCode r115 = new AppletErrorCode("RENDER_VIEW_CREATE_ERROR", 15, 407);
        RENDER_VIEW_CREATE_ERROR = r115;
        AppletErrorCode r116 = new AppletErrorCode("WIDGET_BIND_CANCEL_ERROR", 16, 408);
        WIDGET_BIND_CANCEL_ERROR = r116;
        AppletErrorCode[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116};
        f37129a = r117;
        f37130b = EnumEntriesKt.enumEntries(r117);
    }

    public static AppletErrorCode[] values() {
        return (AppletErrorCode[]) f37129a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AppletErrorCode valueOf(String r100) {
        return (AppletErrorCode) r27.a.a(AppletErrorCode.class, r100);
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public AppletErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
