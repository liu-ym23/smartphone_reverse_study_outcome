package com.bytedance.android.shopping.abscontainer.arch.core.lifecycle;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/core/lifecycle/LifecycleEnum;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ON_CATCH_ERROR", "PAGE_DID_MOUNT", "PAGE_WILL_UNMOUNT", "PAGE_DID_APPEAR", "PAGE_WILL_DISAPPEAR", "FLOW_QUERY_FETCH_SUCCEED", "FLOW_QUERY_FETCH_FAILED", "FLOW_FIRST_SCREEN_RENDER_FINISHED", "FLOW_UPLINK_START", "FLOW_UPLINK_SUCCEED", "FLOW_UPLINK_FAILED", "FLOW_PROTOCOL_DISPATCH_END", "FLOW_PROTOCOL_RELOAD_END", "INTERCEPT_UPLINK", "INTERCEPT_TRACKER", "INTERCEPT_YATA_TRIGGER", "INTERCEPT_PROCESSOR", "INTERCEPT_CLOSE_PAGE", "ON_POPUP_CONTAINER_SCROLLED", "ON_BODY_CONTAINER_WILL_BEGIN_DRAGGING", "ON_BODY_CONTAINER_SCROLLED", "ON_PAGE_LOADING", "ON_POPUP_SHOW", "ON_POPUP_DISMISS", "ON_POPUP_WILL_SHOW", "ON_POPUP_MASK_CLICK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LifecycleEnum extends Enum<LifecycleEnum> {
    public static final LifecycleEnum FLOW_FIRST_SCREEN_RENDER_FINISHED = null;
    public static final LifecycleEnum FLOW_PROTOCOL_DISPATCH_END = null;
    public static final LifecycleEnum FLOW_PROTOCOL_RELOAD_END = null;
    public static final LifecycleEnum FLOW_QUERY_FETCH_FAILED = null;
    public static final LifecycleEnum FLOW_QUERY_FETCH_SUCCEED = null;
    public static final LifecycleEnum FLOW_UPLINK_FAILED = null;
    public static final LifecycleEnum FLOW_UPLINK_START = null;
    public static final LifecycleEnum FLOW_UPLINK_SUCCEED = null;
    public static final LifecycleEnum INTERCEPT_CLOSE_PAGE = null;
    public static final LifecycleEnum INTERCEPT_PROCESSOR = null;
    public static final LifecycleEnum INTERCEPT_TRACKER = null;
    public static final LifecycleEnum INTERCEPT_UPLINK = null;
    public static final LifecycleEnum INTERCEPT_YATA_TRIGGER = null;
    public static final LifecycleEnum ON_BODY_CONTAINER_SCROLLED = null;
    public static final LifecycleEnum ON_BODY_CONTAINER_WILL_BEGIN_DRAGGING = null;
    public static final LifecycleEnum ON_CATCH_ERROR = null;
    public static final LifecycleEnum ON_PAGE_LOADING = null;
    public static final LifecycleEnum ON_POPUP_CONTAINER_SCROLLED = null;
    public static final LifecycleEnum ON_POPUP_DISMISS = null;
    public static final LifecycleEnum ON_POPUP_MASK_CLICK = null;
    public static final LifecycleEnum ON_POPUP_SHOW = null;
    public static final LifecycleEnum ON_POPUP_WILL_SHOW = null;
    public static final LifecycleEnum PAGE_DID_APPEAR = null;
    public static final LifecycleEnum PAGE_DID_MOUNT = null;
    public static final LifecycleEnum PAGE_WILL_DISAPPEAR = null;
    public static final LifecycleEnum PAGE_WILL_UNMOUNT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LifecycleEnum[] f164134a = null;
    private final String value;

    public static LifecycleEnum valueOf(String r100) {
        return (LifecycleEnum) r27.a.a(LifecycleEnum.class, r100);
    }

    public static LifecycleEnum[] values() {
        return (LifecycleEnum[]) f164134a.clone();
    }

    static {
        LifecycleEnum r100 = new LifecycleEnum("ON_CATCH_ERROR", 0, "onCatchError");
        ON_CATCH_ERROR = r100;
        LifecycleEnum r101 = new LifecycleEnum("PAGE_DID_MOUNT", 1, "pageDidMount");
        PAGE_DID_MOUNT = r101;
        LifecycleEnum r102 = new LifecycleEnum("PAGE_WILL_UNMOUNT", 2, "pageWillUnmount");
        PAGE_WILL_UNMOUNT = r102;
        LifecycleEnum r103 = new LifecycleEnum("PAGE_DID_APPEAR", 3, "pageDidAppear");
        PAGE_DID_APPEAR = r103;
        LifecycleEnum r104 = new LifecycleEnum("PAGE_WILL_DISAPPEAR", 4, "pageWillDisappear");
        PAGE_WILL_DISAPPEAR = r104;
        LifecycleEnum r105 = new LifecycleEnum("FLOW_QUERY_FETCH_SUCCEED", 5, "flowQueryFetchSucceed");
        FLOW_QUERY_FETCH_SUCCEED = r105;
        LifecycleEnum r106 = new LifecycleEnum("FLOW_QUERY_FETCH_FAILED", 6, "flowQueryFetchFailed");
        FLOW_QUERY_FETCH_FAILED = r106;
        LifecycleEnum r107 = new LifecycleEnum("FLOW_FIRST_SCREEN_RENDER_FINISHED", 7, "flowFirstScreenRenderFinished");
        FLOW_FIRST_SCREEN_RENDER_FINISHED = r107;
        LifecycleEnum r108 = new LifecycleEnum("FLOW_UPLINK_START", 8, "flowUplinkStart");
        FLOW_UPLINK_START = r108;
        LifecycleEnum r109 = new LifecycleEnum("FLOW_UPLINK_SUCCEED", 9, "flowUplinkSucceed");
        FLOW_UPLINK_SUCCEED = r109;
        LifecycleEnum r110 = new LifecycleEnum("FLOW_UPLINK_FAILED", 10, "flowUplinkFailed");
        FLOW_UPLINK_FAILED = r110;
        LifecycleEnum r111 = new LifecycleEnum("FLOW_PROTOCOL_DISPATCH_END", 11, "flowProtocolDispatchEnd");
        FLOW_PROTOCOL_DISPATCH_END = r111;
        LifecycleEnum r112 = new LifecycleEnum("FLOW_PROTOCOL_RELOAD_END", 12, "flowProtocolReloadEnd");
        FLOW_PROTOCOL_RELOAD_END = r112;
        LifecycleEnum r113 = new LifecycleEnum("INTERCEPT_UPLINK", 13, "interceptUplink");
        INTERCEPT_UPLINK = r113;
        LifecycleEnum r114 = new LifecycleEnum("INTERCEPT_TRACKER", 14, "interceptTracker");
        INTERCEPT_TRACKER = r114;
        LifecycleEnum r115 = new LifecycleEnum("INTERCEPT_YATA_TRIGGER", 15, "interceptYataTrigger");
        INTERCEPT_YATA_TRIGGER = r115;
        LifecycleEnum r116 = new LifecycleEnum("INTERCEPT_PROCESSOR", 16, "interceptProcessor");
        INTERCEPT_PROCESSOR = r116;
        LifecycleEnum r117 = new LifecycleEnum("INTERCEPT_CLOSE_PAGE", 17, "interceptClosePage");
        INTERCEPT_CLOSE_PAGE = r117;
        LifecycleEnum r118 = new LifecycleEnum("ON_POPUP_CONTAINER_SCROLLED", 18, "onPopupContainerScrolled");
        ON_POPUP_CONTAINER_SCROLLED = r118;
        LifecycleEnum r119 = new LifecycleEnum("ON_BODY_CONTAINER_WILL_BEGIN_DRAGGING", 19, "onBodyContainerWillBeginDragging");
        ON_BODY_CONTAINER_WILL_BEGIN_DRAGGING = r119;
        LifecycleEnum r120 = new LifecycleEnum("ON_BODY_CONTAINER_SCROLLED", 20, "onBodyContainerScrolled");
        ON_BODY_CONTAINER_SCROLLED = r120;
        LifecycleEnum r121 = new LifecycleEnum("ON_PAGE_LOADING", 21, "onPageLoading");
        ON_PAGE_LOADING = r121;
        LifecycleEnum r122 = new LifecycleEnum("ON_POPUP_SHOW", 22, "onPopupShow");
        ON_POPUP_SHOW = r122;
        LifecycleEnum r123 = new LifecycleEnum("ON_POPUP_DISMISS", 23, "onPopupDismiss");
        ON_POPUP_DISMISS = r123;
        LifecycleEnum r124 = new LifecycleEnum("ON_POPUP_WILL_SHOW", 24, "onPopupWillShow");
        ON_POPUP_WILL_SHOW = r124;
        LifecycleEnum r125 = new LifecycleEnum("ON_POPUP_MASK_CLICK", 25, "onPopupMaskClick");
        ON_POPUP_MASK_CLICK = r125;
        f164134a = new LifecycleEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
    }

    public final String getValue() {
        return this.value;
    }

    public LifecycleEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
