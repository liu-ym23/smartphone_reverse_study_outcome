package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\u0001\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelPreloadView;", "", "", "layoutId", "I", "getLayoutId", "()I", "count", "getCount", "setCount", "(I)V", "", "supportTouchDown", "Z", "getSupportTouchDown", "()Z", "onlyTouchDown", "getOnlyTouchDown", "isPanelView", "isGiftItemView", "hasParent", "getHasParent", "maxCount", "getMaxCount", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GiftOnlineReceiverView", "GiftOnlineReceiverViewOld", "GroupLiveView", "GiftComboView", "ComboViewOpt", "GiftVerticalListView", "GiftTabView", "GiftRechargeView", "GiftTopView", "GiftActivityTopView", "GiftCustomBarTopView", "GiftDetailTopView", "GiftDIYTopView", "GiftGroupTopView", "GiftLynxGrowthTouchView", "GiftMarketingTopView", "GiftMinorsNoticeView", "GiftSeriesTopView", "GiftBuffCardTopView", "GiftLynxCarnivalTopView", "GiftDefaultTopView", "VerticalPageItem", "TabViewHolder", "GridViewHolderItem", "TopicViewPageItem", "GiftSearchView", "GiftGuideViewHolderItem", "GiftMostlyUsedHeaderViewHolderItem", "GiftDynamicPanel", "SendGiftView", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPanelPreloadView extends Enum<GiftPanelPreloadView> {
    public static final GiftPanelPreloadView ComboViewOpt = null;
    public static final a Companion = null;
    public static final GiftPanelPreloadView GiftActivityTopView = null;
    public static final GiftPanelPreloadView GiftBuffCardTopView = null;
    public static final GiftPanelPreloadView GiftComboView = null;
    public static final GiftPanelPreloadView GiftCustomBarTopView = null;
    public static final GiftPanelPreloadView GiftDIYTopView = null;
    public static final GiftPanelPreloadView GiftDefaultTopView = null;
    public static final GiftPanelPreloadView GiftDetailTopView = null;
    public static final GiftPanelPreloadView GiftDynamicPanel = null;
    public static final GiftPanelPreloadView GiftGroupTopView = null;
    public static final GiftPanelPreloadView GiftGuideViewHolderItem = null;
    public static final GiftPanelPreloadView GiftLynxCarnivalTopView = null;
    public static final GiftPanelPreloadView GiftLynxGrowthTouchView = null;
    public static final GiftPanelPreloadView GiftMarketingTopView = null;
    public static final GiftPanelPreloadView GiftMinorsNoticeView = null;
    public static final GiftPanelPreloadView GiftMostlyUsedHeaderViewHolderItem = null;
    public static final GiftPanelPreloadView GiftOnlineReceiverView = null;
    public static final GiftPanelPreloadView GiftOnlineReceiverViewOld = null;
    public static final GiftPanelPreloadView GiftRechargeView = null;
    public static final GiftPanelPreloadView GiftSearchView = null;
    public static final GiftPanelPreloadView GiftSeriesTopView = null;
    public static final GiftPanelPreloadView GiftTabView = null;
    public static final GiftPanelPreloadView GiftTopView = null;
    public static final GiftPanelPreloadView GiftVerticalListView = null;
    public static final GiftPanelPreloadView GridViewHolderItem = null;
    public static final GiftPanelPreloadView GroupLiveView = null;
    public static final GiftPanelPreloadView SendGiftView = null;
    public static final GiftPanelPreloadView TabViewHolder = null;
    public static final GiftPanelPreloadView TopicViewPageItem = null;
    public static final GiftPanelPreloadView VerticalPageItem = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftPanelPreloadView[] f128158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f128159b = null;
    private int count;
    private final boolean hasParent;
    private final boolean isGiftItemView;
    private final boolean isPanelView;
    private final int layoutId;
    private final int maxCount;
    private final boolean onlyTouchDown;
    private final boolean supportTouchDown;

    public static final class a {
        public a() {
        }
    }

    public GiftPanelPreloadView() {
        throw null;
    }

    public static GiftPanelPreloadView valueOf(String r100) {
        return (GiftPanelPreloadView) r27.a.a(GiftPanelPreloadView.class, r100);
    }

    public static GiftPanelPreloadView[] values() {
        return (GiftPanelPreloadView[]) f128158a.clone();
    }

    static {
        GiftPanelPreloadView[] r100 = new GiftPanelPreloadView[30];
        GiftPanelPreloadView r110 = new GiftPanelPreloadView("GiftOnlineReceiverView", 0, R.layout.ttlive_dialog_select_gift_receiver_widget_new, 1, false, false, false, false, false, 0, 252, null);
        GiftOnlineReceiverView = r110;
        r100[0] = r110;
        GiftPanelPreloadView r101 = new GiftPanelPreloadView("GiftOnlineReceiverViewOld", 1, R.layout.ttlive_dialog_select_gift_receiver_widget_old, 1, false, false, false, false, false, 0, 252, null);
        GiftOnlineReceiverViewOld = r101;
        r100[1] = r101;
        GiftPanelPreloadView r102 = new GiftPanelPreloadView("GroupLiveView", 2, R.layout.ttlive_dialog_group_live_room_widget_new, 1, false, false, false, false, false, 0, 252, null);
        GroupLiveView = r102;
        r100[2] = r102;
        GiftPanelPreloadView r103 = new GiftPanelPreloadView("GiftComboView", 3, R.layout.ttlive_base_gift_combo_widget, 1, false, false, false, false, false, 2, 124, null);
        GiftComboView = r103;
        r100[3] = r103;
        GiftPanelPreloadView r104 = new GiftPanelPreloadView("ComboViewOpt", 4, R.layout.ttlive_base_gift_combo_view_new_style_small, 1, false, false, false, false, false, 2, 124, null);
        ComboViewOpt = r104;
        r100[4] = r104;
        if (v.e() == false) goto L5;
        int r105 = R.layout.ttlive_mvi_vertical_gift_list_widget_new_framework;
    L6:
        GiftPanelPreloadView r106 = new GiftPanelPreloadView("GiftVerticalListView", 5, r105, 1, false, false, false, false, false, 0, 252, null);
        GiftVerticalListView = r106;
        r100[5] = r106;
        if (v.e() == false) goto L9;
        int r107 = R.layout.ttlive_base_gift_tab_view_new_structure;
    L10:
        GiftPanelPreloadView r108 = new GiftPanelPreloadView("GiftTabView", 6, r107, 1, false, !v.e(), false, false, false, 0, 244, null);
        GiftTabView = r108;
        r100[6] = r108;
        GiftPanelPreloadView r109 = new GiftPanelPreloadView("GiftRechargeView", 7, R.layout.ttlive_base_gift_recharge_view, 1, false, true, false, false, false, 0, 244, null);
        GiftRechargeView = r109;
        r100[7] = r109;
        GiftPanelPreloadView r111 = new GiftPanelPreloadView("GiftTopView", 8, R.layout.ttlive_base_gift_top_widget, 1, false, false, false, false, false, 0, 252, null);
        GiftTopView = r111;
        r100[8] = r111;
        if (v.e() == false) goto L13;
        int r112 = R.layout.ttlive_gift_activity_top_view_new_framework;
    L14:
        GiftPanelPreloadView r113 = new GiftPanelPreloadView("GiftActivityTopView", 9, r112, 1, false, false, false, false, false, 0, 252, null);
        GiftActivityTopView = r113;
        r100[9] = r113;
        GiftPanelPreloadView r114 = new GiftPanelPreloadView("GiftCustomBarTopView", 10, R.layout.ttlive_custom_gift_topbar_widget, 1, false, false, false, false, false, 0, 252, null);
        GiftCustomBarTopView = r114;
        r100[10] = r114;
        GiftPanelPreloadView r115 = new GiftPanelPreloadView("GiftDetailTopView", 11, R.layout.ttlive_dialog_top_detail_widget, 1, false, false, false, false, false, 0, 252, null);
        GiftDetailTopView = r115;
        r100[11] = r115;
        GiftPanelPreloadView r116 = new GiftPanelPreloadView("GiftDIYTopView", 12, R.layout.ttlive_top_gift_diy_view, 1, false, false, false, false, false, 0, 252, null);
        GiftDIYTopView = r116;
        r100[12] = r116;
        GiftPanelPreloadView r117 = new GiftPanelPreloadView("GiftGroupTopView", 13, R.layout.ttlive_top_gift_group_view, 1, false, false, false, false, false, 0, 252, null);
        GiftGroupTopView = r117;
        r100[13] = r117;
        GiftPanelPreloadView r118 = new GiftPanelPreloadView("GiftLynxGrowthTouchView", 14, R.layout.ttlive_growth_touch_lynx_view, 1, false, false, false, false, false, 0, 248, null);
        GiftLynxGrowthTouchView = r118;
        r100[14] = r118;
        GiftPanelPreloadView r119 = new GiftPanelPreloadView("GiftMarketingTopView", 15, R.layout.ttlive_top_gift_marketing_lynx_view, 1, false, false, false, false, false, 0, 248, null);
        GiftMarketingTopView = r119;
        r100[15] = r119;
        GiftPanelPreloadView r120 = new GiftPanelPreloadView("GiftMinorsNoticeView", 16, R.layout.ttlive_widget_forbiden_minors_consume_notice, 1, false, false, false, false, false, 0, 252, null);
        GiftMinorsNoticeView = r120;
        r100[16] = r120;
        GiftPanelPreloadView r121 = new GiftPanelPreloadView("GiftSeriesTopView", 17, R.layout.ttlive_top_gift_series_lynx_view, 1, false, false, false, false, false, 0, 248, null);
        GiftSeriesTopView = r121;
        r100[17] = r121;
        GiftPanelPreloadView r122 = new GiftPanelPreloadView("GiftBuffCardTopView", 18, R.layout.ttlive_top_gift_buff_view, 1, false, false, false, false, false, 0, 248, null);
        GiftBuffCardTopView = r122;
        r100[18] = r122;
        GiftPanelPreloadView r123 = new GiftPanelPreloadView("GiftLynxCarnivalTopView", 19, R.layout.ttlive_top_gift_carnival_lynx_view, 1, false, false, false, false, false, 0, 248, null);
        GiftLynxCarnivalTopView = r123;
        r100[19] = r123;
        GiftPanelPreloadView r124 = new GiftPanelPreloadView("GiftDefaultTopView", 20, R.layout.ttlive_top_default_view, 1, false, false, false, false, false, 0, 252, null);
        GiftDefaultTopView = r124;
        r100[20] = r124;
        c0.f127389d.getClass();
        GiftPanelPreloadView r125 = new GiftPanelPreloadView("VerticalPageItem", 21, R.layout.ttlive_mvi_vertical_pager, GiftPreloadSettingsKt.a().i(), false, false, false, false, false, 0, 252, null);
        VerticalPageItem = r125;
        r100[21] = r125;
        GiftPanelPreloadView r126 = new GiftPanelPreloadView("TabViewHolder", 22, R.layout.ttlive_gift_bottom_view_holder, 5, false, false, false, false, false, 7, 44, null);
        TabViewHolder = r126;
        r100[22] = r126;
        GiftPanelPreloadView r127 = new GiftPanelPreloadView("GridViewHolderItem", 23, R.layout.ttlive_base_gift_view_holder_new_vertical, 12, false, false, false, true, false, c0.f127388c.e(), 76, null);
        GridViewHolderItem = r127;
        r100[23] = r127;
        GiftPanelPreloadView r128 = new GiftPanelPreloadView("TopicViewPageItem", 24, R.layout.ttlive_mvi_viewpager_item, 1, false, false, false, false, false, 0, 252, null);
        TopicViewPageItem = r128;
        r100[24] = r128;
        GiftPanelPreloadView r129 = new GiftPanelPreloadView("GiftSearchView", 25, R.layout.ttlive_base_gift_search_container_view, 1, false, false, false, false, false, 0, 252, null);
        GiftSearchView = r129;
        r100[25] = r129;
        GiftPanelPreloadView r130 = new GiftPanelPreloadView("GiftGuideViewHolderItem", 26, R.layout.ttlive_gift_guide_view_holder_layout, 1, false, false, false, false, false, 0, 252, null);
        GiftGuideViewHolderItem = r130;
        r100[26] = r130;
        GiftPanelPreloadView r131 = new GiftPanelPreloadView("GiftMostlyUsedHeaderViewHolderItem", 27, R.layout.ttlive_base_mostly_used_header_holder, 1, false, false, false, false, false, 0, 252, null);
        GiftMostlyUsedHeaderViewHolderItem = r131;
        r100[27] = r131;
        GiftPanelPreloadView r132 = new GiftPanelPreloadView("GiftDynamicPanel", 28, R.layout.ttlive_gift_dynamic_panel, 1, false, false, false, false, false, 0, 252, null);
        GiftDynamicPanel = r132;
        r100[28] = r132;
        GiftPanelPreloadView r133 = new GiftPanelPreloadView("SendGiftView", 29, R.layout.ttlive_base_send_gift_animation_view_v2, 1, false, false, false, false, false, 0, 252, null);
        SendGiftView = r133;
        r100[29] = r133;
        f128158a = r100;
        Companion = new a();
        f128159b = LazyKt.lazy(GiftPanelPreloadView$Companion$allViews$2.INSTANCE);
        return;
    L13:
        r112 = R.layout.ttlive_gift_activity_top_view;
        goto L14
    L9:
        r107 = R.layout.ttlive_base_gift_tab_view;
        goto L10
    L5:
        r105 = R.layout.ttlive_mvi_vertical_gift_list_widget;
        goto L6
    }

    public static final /* synthetic */ Lazy access$getAllViews$cp() {
        return f128159b;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getHasParent() {
        return this.hasParent;
    }

    public final int getLayoutId() {
        return this.layoutId;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final boolean getOnlyTouchDown() {
        return this.onlyTouchDown;
    }

    public final boolean getSupportTouchDown() {
        return this.supportTouchDown;
    }

    public final boolean isGiftItemView() {
        return this.isGiftItemView;
    }

    public final boolean isPanelView() {
        return this.isPanelView;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public GiftPanelPreloadView(String r100, int r101, int r102, int r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L6;
        r104 = true;
    L6:
        if ((r113 & 8) == 0) goto L9;
        r105 = false;
    L9:
        if ((r113 & 16) == 0) goto L12;
        r106 = true;
    L12:
        if ((r113 & 32) == 0) goto L15;
        r110 = false;
    L15:
        if ((r113 & 64) == 0) goto L18;
        r111 = true;
    L18:
        if ((r113 & 128) == 0) goto L20;
        r112 = r103;
    L20:
        super(r100, r101);
        this.layoutId = r102;
        this.count = r103;
        this.supportTouchDown = r104;
        this.onlyTouchDown = r105;
        this.isPanelView = r106;
        this.isGiftItemView = r110;
        this.hasParent = r111;
        this.maxCount = r112;
    }
}
