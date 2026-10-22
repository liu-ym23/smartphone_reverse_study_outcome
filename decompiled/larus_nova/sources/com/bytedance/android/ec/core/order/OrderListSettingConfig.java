package com.bytedance.android.ec.core.order;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001DB\u009d\u0001\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006¢\u0006\u0004\bA\u0010BJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u009f\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006HÆ\u0001J\t\u0010%\u001a\u00020\u0002HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b-\u0010,R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b.\u0010,R\u001a\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b2\u00101R\u001a\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u00105R\u001a\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b6\u00101R\u001a\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b7\u00101R\u001a\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b8\u00101R\u001a\u0010\u001e\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;R\u001a\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b<\u00101R\u001a\u0010 \u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\b=\u0010;R\u001a\u0010!\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b>\u00101R\u001a\u0010\"\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b?\u00101R\u001a\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b@\u00101¨\u0006E"}, d2 = {"Lcom/bytedance/android/ec/core/order/OrderListSettingConfig;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "component5", "", "component6", "component7", "component8", "component9", "", "component10", "component11", "component12", "component13", "component14", "component15", "orderListGULUrl", "orderSearchGULUrl", "lynxBridgeUrl", "bigFontSwitch", "clickDebounceSwitch", "clickDebounceDuration", "enableNewEventChainLogic", "disableIncrementalFacade", "enableFirstEnterQuickDispatch", "yataRenderMaxDuration", "optCartTrack", "hideSkeletonDelayDuration", "enableContainerClipChildren", "drawableResetPreFetch", "enableOverflowClick", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getOrderListGULUrl", "()Ljava/lang/String;", "getOrderSearchGULUrl", "getLynxBridgeUrl", "Z", "getBigFontSwitch", "()Z", "getClickDebounceSwitch", "I", "getClickDebounceDuration", "()I", "getEnableNewEventChainLogic", "getDisableIncrementalFacade", "getEnableFirstEnterQuickDispatch", "J", "getYataRenderMaxDuration", "()J", "getOptCartTrack", "getHideSkeletonDelayDuration", "getEnableContainerClipChildren", "getDrawableResetPreFetch", "getEnableOverflowClick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZIZZZJZJZZZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListSettingConfig implements Serializable {
    public static final a Companion = null;
    public static final String ORDER_SEARCH_RESULT_GUL_URL = "sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Fffh.jinritemai.com%2Fforest%2Frender%2Ffe%2Ftemplate%2Fchannel%2Fecommerce_orders_yata%2Fhtml%2Fsearch_gyl.html%3F__pia_manifest__%3D%257B%2522page_name%2522%253A%2522search_gyl%2522%252C%2522public_path%2522%253A%2522https%253A%252F%252Flf-webcast-sourcecdn-tos.bytegecko.com%252Fobj%252Fbyte-gurd-source%252F10181%252Fgecko%252Fresource%252Fecommerce_orders_yata%252F%2522%257D&disable_host_jsb_method=1&disable_thread_spread=1&warmup_pia_worker=1&loader_name=forest&hide_nav_bar=1&status_bar_color=black&trans_status_bar=1&web_bg_color=%23FFFFFF&disable_input_scroll=1&use_pia=1&use_wk_falcon=1";

    @SerializedName("big_font_switch")
    private final boolean bigFontSwitch;

    @SerializedName("click_debounce_duration")
    private final int clickDebounceDuration;

    @SerializedName("click_debounce_switch")
    private final boolean clickDebounceSwitch;

    @SerializedName("disable_incremental_facade")
    private final boolean disableIncrementalFacade;

    @SerializedName("drawable_reset_pre_fetch")
    private final boolean drawableResetPreFetch;

    @SerializedName("enable_container_clip_children")
    private final boolean enableContainerClipChildren;

    @SerializedName("enable_first_enter_quick_dispatch")
    private final boolean enableFirstEnterQuickDispatch;

    @SerializedName("enableNewEventChainLogic")
    private final boolean enableNewEventChainLogic;

    @SerializedName("enable_overflow_click")
    private final boolean enableOverflowClick;

    @SerializedName("opt_search_skeleton_delay_hide_duration")
    private final long hideSkeletonDelayDuration;

    @SerializedName("bridge_lynx_url")
    private final String lynxBridgeUrl;

    @SerializedName("opt_cart_track")
    private final boolean optCartTrack;

    @SerializedName("order_list_recommend_lynx_url")
    private final String orderListGULUrl;

    @SerializedName("order_search_result_recommend_h5_url")
    private final String orderSearchGULUrl;

    @SerializedName("yata_render_max_duration")
    private final long yataRenderMaxDuration;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public OrderListSettingConfig() {
        this(null, null, null, false, false, 0, false, false, false, 0, false, 0, false, false, false, 32767, null);
    }

    public static /* synthetic */ OrderListSettingConfig copy$default(OrderListSettingConfig r110, String r111, String r112, String r113, boolean r210, boolean r211, int r212, boolean r213, boolean r214, boolean r215, long r216, boolean r217, long r218, boolean r310, boolean r311, boolean r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        String r100 = r110.orderListGULUrl;
    L7:
        if ((r313 & 2) == 0) goto L9;
        String r101 = r110.orderSearchGULUrl;
    L11:
        if ((r313 & 4) == 0) goto L13;
        String r102 = r110.lynxBridgeUrl;
    L15:
        if ((r313 & 8) == 0) goto L17;
        boolean r103 = r110.bigFontSwitch;
    L19:
        if ((r313 & 16) == 0) goto L21;
        boolean r104 = r110.clickDebounceSwitch;
    L23:
        if ((r313 & 32) == 0) goto L25;
        int r105 = r110.clickDebounceDuration;
    L27:
        if ((r313 & 64) == 0) goto L29;
        boolean r106 = r110.enableNewEventChainLogic;
    L31:
        if ((r313 & 128) == 0) goto L33;
        boolean r107 = r110.disableIncrementalFacade;
    L35:
        if ((r313 & 256) == 0) goto L37;
        boolean r114 = r110.enableFirstEnterQuickDispatch;
    L39:
        if ((r313 & 512) == 0) goto L41;
        long r115 = r110.yataRenderMaxDuration;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        boolean r116 = r110.optCartTrack;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        long r117 = r110.hideSkeletonDelayDuration;
    L50:
        long r219 = r117;
        if ((r313 & 4096) == 0) goto L53;
        boolean r118 = r110.enableContainerClipChildren;
    L55:
        if ((r313 & 8192) == 0) goto L57;
        boolean r119 = r110.drawableResetPreFetch;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        boolean r108 = r110.enableOverflowClick;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r219, r118, r119, r108);
    L61:
        r108 = r312;
        goto L63
    L57:
        r119 = r311;
        goto L59
    L53:
        r118 = r310;
        goto L55
    L49:
        r117 = r218;
        goto L50
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.orderListGULUrl;
    }

    public final long component10() {
        return this.yataRenderMaxDuration;
    }

    public final boolean component11() {
        return this.optCartTrack;
    }

    public final long component12() {
        return this.hideSkeletonDelayDuration;
    }

    public final boolean component13() {
        return this.enableContainerClipChildren;
    }

    public final boolean component14() {
        return this.drawableResetPreFetch;
    }

    public final boolean component15() {
        return this.enableOverflowClick;
    }

    public final String component2() {
        return this.orderSearchGULUrl;
    }

    public final String component3() {
        return this.lynxBridgeUrl;
    }

    public final boolean component4() {
        return this.bigFontSwitch;
    }

    public final boolean component5() {
        return this.clickDebounceSwitch;
    }

    public final int component6() {
        return this.clickDebounceDuration;
    }

    public final boolean component7() {
        return this.enableNewEventChainLogic;
    }

    public final boolean component8() {
        return this.disableIncrementalFacade;
    }

    public final boolean component9() {
        return this.enableFirstEnterQuickDispatch;
    }

    public final OrderListSettingConfig copy(String r210, String r211, String r212, boolean r213, boolean r214, int r215, boolean r216, boolean r217, boolean r218, long r310, boolean r311, long r312, boolean r313, boolean r314, boolean r315) {
        Intrinsics.checkNotNullParameter(r210, "orderListGULUrl");
        Intrinsics.checkNotNullParameter(r211, "orderSearchGULUrl");
        Intrinsics.checkNotNullParameter(r212, "lynxBridgeUrl");
        return new OrderListSettingConfig(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderListSettingConfig) == false) goto L36;
        OrderListSettingConfig r101 = (OrderListSettingConfig) r100;
        if (Intrinsics.areEqual(this.orderListGULUrl, r101.orderListGULUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderSearchGULUrl, r101.orderSearchGULUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxBridgeUrl, r101.lynxBridgeUrl) == true) goto L12;
        return false;
    L12:
        if (this.bigFontSwitch == r101.bigFontSwitch) goto L14;
        return false;
    L14:
        if (this.clickDebounceSwitch == r101.clickDebounceSwitch) goto L16;
        return false;
    L16:
        if (this.clickDebounceDuration == r101.clickDebounceDuration) goto L18;
        return false;
    L18:
        if (this.enableNewEventChainLogic == r101.enableNewEventChainLogic) goto L20;
        return false;
    L20:
        if (this.disableIncrementalFacade == r101.disableIncrementalFacade) goto L22;
        return false;
    L22:
        if (this.enableFirstEnterQuickDispatch == r101.enableFirstEnterQuickDispatch) goto L24;
        return false;
    L24:
        if (this.yataRenderMaxDuration == r101.yataRenderMaxDuration) goto L26;
        return false;
    L26:
        if (this.optCartTrack == r101.optCartTrack) goto L28;
        return false;
    L28:
        if (this.hideSkeletonDelayDuration == r101.hideSkeletonDelayDuration) goto L30;
        return false;
    L30:
        if (this.enableContainerClipChildren == r101.enableContainerClipChildren) goto L32;
        return false;
    L32:
        if (this.drawableResetPreFetch == r101.drawableResetPreFetch) goto L34;
        return false;
    L34:
        if (this.enableOverflowClick == r101.enableOverflowClick) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public int hashCode() {
        String r100 = this.orderListGULUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.orderSearchGULUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lynxBridgeUrl;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.bigFontSwitch;
        ?? r110 = 1;
        ?? r111 = r109;
        if (r109 == false) goto L16;
        r111 = 1;
    L16:
        int r112 = (r108 + r111) * 31;
        boolean r113 = this.clickDebounceSwitch;
        ?? r114 = r113;
        if (r113 == false) goto L19;
        r114 = 1;
    L19:
        int r115 = (((r112 + r114) * 31) + this.clickDebounceDuration) * 31;
        boolean r116 = this.enableNewEventChainLogic;
        ?? r117 = r116;
        if (r116 == false) goto L22;
        r117 = 1;
    L22:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.disableIncrementalFacade;
        ?? r120 = r119;
        if (r119 == false) goto L25;
        r120 = 1;
    L25:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.enableFirstEnterQuickDispatch;
        ?? r123 = r122;
        if (r122 == false) goto L28;
        r123 = 1;
    L28:
        long r124 = this.yataRenderMaxDuration;
        int r125 = (((r121 + r123) * 31) + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        boolean r126 = this.optCartTrack;
        ?? r127 = r126;
        if (r126 == false) goto L31;
        r127 = 1;
    L31:
        int r128 = (r125 + r127) * 31;
        long r129 = this.hideSkeletonDelayDuration;
        int r130 = (r128 + ((int) (r129 ^ (r129 >>> 32)))) * 31;
        boolean r131 = this.enableContainerClipChildren;
        ?? r132 = r131;
        if (r131 == false) goto L34;
        r132 = 1;
    L34:
        int r133 = (r130 + r132) * 31;
        boolean r134 = this.drawableResetPreFetch;
        ?? r135 = r134;
        if (r134 == false) goto L37;
        r135 = 1;
    L37:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.enableOverflowClick;
        if (r137 == true) goto L42;
        r110 = r137;
    L42:
        return r136 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "OrderListSettingConfig(orderListGULUrl=" + this.orderListGULUrl + ", orderSearchGULUrl=" + this.orderSearchGULUrl + ", lynxBridgeUrl=" + this.lynxBridgeUrl + ", bigFontSwitch=" + this.bigFontSwitch + ", clickDebounceSwitch=" + this.clickDebounceSwitch + ", clickDebounceDuration=" + this.clickDebounceDuration + ", enableNewEventChainLogic=" + this.enableNewEventChainLogic + ", disableIncrementalFacade=" + this.disableIncrementalFacade + ", enableFirstEnterQuickDispatch=" + this.enableFirstEnterQuickDispatch + ", yataRenderMaxDuration=" + this.yataRenderMaxDuration + ", optCartTrack=" + this.optCartTrack + ", hideSkeletonDelayDuration=" + this.hideSkeletonDelayDuration + ", enableContainerClipChildren=" + this.enableContainerClipChildren + ", drawableResetPreFetch=" + this.drawableResetPreFetch + ", enableOverflowClick=" + this.enableOverflowClick + ")";
    }

    public final boolean getBigFontSwitch() {
        return this.bigFontSwitch;
    }

    public final int getClickDebounceDuration() {
        return this.clickDebounceDuration;
    }

    public final boolean getClickDebounceSwitch() {
        return this.clickDebounceSwitch;
    }

    public final boolean getDisableIncrementalFacade() {
        return this.disableIncrementalFacade;
    }

    public final boolean getDrawableResetPreFetch() {
        return this.drawableResetPreFetch;
    }

    public final boolean getEnableContainerClipChildren() {
        return this.enableContainerClipChildren;
    }

    public final boolean getEnableFirstEnterQuickDispatch() {
        return this.enableFirstEnterQuickDispatch;
    }

    public final boolean getEnableNewEventChainLogic() {
        return this.enableNewEventChainLogic;
    }

    public final boolean getEnableOverflowClick() {
        return this.enableOverflowClick;
    }

    public final long getHideSkeletonDelayDuration() {
        return this.hideSkeletonDelayDuration;
    }

    public final String getLynxBridgeUrl() {
        return this.lynxBridgeUrl;
    }

    public final boolean getOptCartTrack() {
        return this.optCartTrack;
    }

    public final String getOrderListGULUrl() {
        return this.orderListGULUrl;
    }

    public final String getOrderSearchGULUrl() {
        return this.orderSearchGULUrl;
    }

    public final long getYataRenderMaxDuration() {
        return this.yataRenderMaxDuration;
    }

    public OrderListSettingConfig(String r100, String r101, String r102, boolean r103, boolean r110, int r111, boolean r112, boolean r113, boolean r114, long r115, boolean r116, long r117, boolean r210, boolean r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r100, "orderListGULUrl");
        Intrinsics.checkNotNullParameter(r101, "orderSearchGULUrl");
        Intrinsics.checkNotNullParameter(r102, "lynxBridgeUrl");
        this.orderListGULUrl = r100;
        this.orderSearchGULUrl = r101;
        this.lynxBridgeUrl = r102;
        this.bigFontSwitch = r103;
        this.clickDebounceSwitch = r110;
        this.clickDebounceDuration = r111;
        this.enableNewEventChainLogic = r112;
        this.disableIncrementalFacade = r113;
        this.enableFirstEnterQuickDispatch = r114;
        this.yataRenderMaxDuration = r115;
        this.optCartTrack = r116;
        this.hideSkeletonDelayDuration = r117;
        this.enableContainerClipChildren = r210;
        this.drawableResetPreFetch = r211;
        this.enableOverflowClick = r212;
    }

    public /* synthetic */ OrderListSettingConfig(String r110, String r111, String r210, boolean r211, boolean r212, int r213, boolean r214, boolean r215, boolean r216, long r217, boolean r218, long r310, boolean r311, boolean r312, boolean r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/yata_gul_container/app/template.js";
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = ORDER_SEARCH_RESULT_GUL_URL;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecommerce_lynx_event_page/lynx/views/app/template.js";
    L15:
        if ((r314 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r314 & 16) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r105 = 300;
    L27:
        if ((r314 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r314 & 128) == 0) goto L33;
        boolean r112 = false;
    L35:
        if ((r314 & 256) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r314 & 512) == 0) goto L41;
        long r114 = 1000;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        boolean r115 = false;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        long r116 = 2000;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        boolean r107 = false;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r108 = true;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        boolean r109 = true;
    L62:
        this(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r107, r108, r109);
        return;
    L61:
        r109 = r313;
        goto L62
    L57:
        r108 = r312;
        goto L59
    L53:
        r107 = r311;
        goto L55
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
