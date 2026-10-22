package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/utils/GiftPanelNitaViewInfo;", "", "Lzo2/a;", "", "getResId", "()I", "resId", "", "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW", "TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW", "TTLIVE_BASE_GIFT_COMBO_WIDGET", "TTLIVE_BASE_GIFT_TAB_VIEW", "TTLIVE_BASE_GIFT_RECHARGE_VIEW", "TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3", "TTLIVE_GROWTH_TOUCH_LYNX_VIEW", "TTLIVE_TOP_GIFT_GROUP_VIEW", "TTLIVE_GIFT_ACTIVITY_TOP_VIEW", "TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET", "TTLIVE_DIALOG_TOP_DETAIL_WIDGET", "TTLIVE_TOP_GIFT_DIY_VIEW", "TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE", "TTLIVE_TOP_GIFT_BUFF_VIEW", "TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL", "TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET", "TTLIVE_GIFT_BAG_TOPBAR_WIDGET", "TTLIVE_TOP_DEFAULT_VIEW", "TTLIVE_MVI_VERTICAL_PAGER", "TTLIVE_MVI_COUNTER_PAGE", "TTLIVE_BASE_COUNTER_VIEW_ITEM", "TTLIVE_BASE_COUNTER_GIFT_ITEM", "TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM", "TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL", "TTLIVE_MVI_VIEW_PAGER_PAGE", "TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPanelNitaViewInfo extends Enum<GiftPanelNitaViewInfo> implements zo2.a {
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_COUNTER_GIFT_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_COUNTER_VIEW_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_COMBO_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_RECHARGE_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_TAB_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL = null;
    public static final GiftPanelNitaViewInfo TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_DIALOG_TOP_DETAIL_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_ACTIVITY_TOP_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_BAG_TOPBAR_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3 = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GROWTH_TOUCH_LYNX_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_MVI_COUNTER_PAGE = null;
    public static final GiftPanelNitaViewInfo TTLIVE_MVI_VERTICAL_PAGER = null;
    public static final GiftPanelNitaViewInfo TTLIVE_MVI_VIEW_PAGER_PAGE = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_DEFAULT_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_GIFT_BUFF_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_GIFT_DIY_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_GIFT_GROUP_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftPanelNitaViewInfo[] f132017a = null;

    static {
        GiftPanelNitaViewInfo r100 = new GiftPanelNitaViewInfo("TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW", 0);
        TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW = r100;
        GiftPanelNitaViewInfo r101 = new GiftPanelNitaViewInfo("TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW", 1);
        TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW = r101;
        GiftPanelNitaViewInfo r102 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_COMBO_WIDGET", 2);
        TTLIVE_BASE_GIFT_COMBO_WIDGET = r102;
        GiftPanelNitaViewInfo r103 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_TAB_VIEW", 3);
        TTLIVE_BASE_GIFT_TAB_VIEW = r103;
        GiftPanelNitaViewInfo r104 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_RECHARGE_VIEW", 4);
        TTLIVE_BASE_GIFT_RECHARGE_VIEW = r104;
        GiftPanelNitaViewInfo r105 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3", 5);
        TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3 = r105;
        GiftPanelNitaViewInfo r106 = new GiftPanelNitaViewInfo("TTLIVE_GROWTH_TOUCH_LYNX_VIEW", 6);
        TTLIVE_GROWTH_TOUCH_LYNX_VIEW = r106;
        GiftPanelNitaViewInfo r107 = new GiftPanelNitaViewInfo("TTLIVE_TOP_GIFT_GROUP_VIEW", 7);
        TTLIVE_TOP_GIFT_GROUP_VIEW = r107;
        GiftPanelNitaViewInfo r108 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_ACTIVITY_TOP_VIEW", 8);
        TTLIVE_GIFT_ACTIVITY_TOP_VIEW = r108;
        GiftPanelNitaViewInfo r109 = new GiftPanelNitaViewInfo("TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET", 9);
        TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET = r109;
        GiftPanelNitaViewInfo r110 = new GiftPanelNitaViewInfo("TTLIVE_DIALOG_TOP_DETAIL_WIDGET", 10);
        TTLIVE_DIALOG_TOP_DETAIL_WIDGET = r110;
        GiftPanelNitaViewInfo r111 = new GiftPanelNitaViewInfo("TTLIVE_TOP_GIFT_DIY_VIEW", 11);
        TTLIVE_TOP_GIFT_DIY_VIEW = r111;
        GiftPanelNitaViewInfo r112 = new GiftPanelNitaViewInfo("TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE", 12);
        TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE = r112;
        GiftPanelNitaViewInfo r113 = new GiftPanelNitaViewInfo("TTLIVE_TOP_GIFT_BUFF_VIEW", 13);
        TTLIVE_TOP_GIFT_BUFF_VIEW = r113;
        GiftPanelNitaViewInfo r114 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL", 14);
        TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL = r114;
        GiftPanelNitaViewInfo r115 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET", 15);
        TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET = r115;
        GiftPanelNitaViewInfo r116 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_BAG_TOPBAR_WIDGET", 16);
        TTLIVE_GIFT_BAG_TOPBAR_WIDGET = r116;
        GiftPanelNitaViewInfo r117 = new GiftPanelNitaViewInfo("TTLIVE_TOP_DEFAULT_VIEW", 17);
        TTLIVE_TOP_DEFAULT_VIEW = r117;
        GiftPanelNitaViewInfo r118 = new GiftPanelNitaViewInfo("TTLIVE_MVI_VERTICAL_PAGER", 18);
        TTLIVE_MVI_VERTICAL_PAGER = r118;
        GiftPanelNitaViewInfo r119 = new GiftPanelNitaViewInfo("TTLIVE_MVI_COUNTER_PAGE", 19);
        TTLIVE_MVI_COUNTER_PAGE = r119;
        GiftPanelNitaViewInfo r120 = new GiftPanelNitaViewInfo("TTLIVE_BASE_COUNTER_VIEW_ITEM", 20);
        TTLIVE_BASE_COUNTER_VIEW_ITEM = r120;
        GiftPanelNitaViewInfo r121 = new GiftPanelNitaViewInfo("TTLIVE_BASE_COUNTER_GIFT_ITEM", 21);
        TTLIVE_BASE_COUNTER_GIFT_ITEM = r121;
        GiftPanelNitaViewInfo r122 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM", 22);
        TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM = r122;
        GiftPanelNitaViewInfo r123 = new GiftPanelNitaViewInfo("TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL", 23);
        TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL = r123;
        GiftPanelNitaViewInfo r124 = new GiftPanelNitaViewInfo("TTLIVE_MVI_VIEW_PAGER_PAGE", 24);
        TTLIVE_MVI_VIEW_PAGER_PAGE = r124;
        GiftPanelNitaViewInfo r125 = new GiftPanelNitaViewInfo("TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM", 25);
        TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM = r125;
        f132017a = new GiftPanelNitaViewInfo[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
    }

    public static GiftPanelNitaViewInfo valueOf(String r100) {
        return (GiftPanelNitaViewInfo) r27.a.a(GiftPanelNitaViewInfo.class, r100);
    }

    public static GiftPanelNitaViewInfo[] values() {
        return (GiftPanelNitaViewInfo[]) f132017a.clone();
    }

    @Override // zo2.a
    public int getType() {
        return 0;
    }

    @Override // zo2.a
    public int getCount() {
        switch(r.f132059b[ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L6;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            case 23: goto L8;
            case 24: goto L8;
            case 25: goto L8;
            case 26: goto L8;
            default: goto L5;
        };
    L6:
        return 20;
    L8:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zo2.a
    public int getResId() {
        switch(r.f132058a[ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            case 25: goto L7;
            case 26: goto L6;
            default: goto L5;
        };
    L6:
        return R.layout.ttlive_mvi_viewpager_item;
    L7:
        return R.layout.ttlive_base_load_more_view_holder_layout;
    L8:
        return R.layout.ttlive_base_prop_view_holder_new_vertical;
    L9:
        return R.layout.ttlive_gift_backpack_check_record_item;
    L10:
        return R.layout.ttlive_base_counter_gift_view_holder;
    L11:
        return R.layout.ttlive_base_counter_view_holder;
    L12:
        return R.layout.ttlive_mvi_counter_pager;
    L13:
        return R.layout.ttlive_mvi_vertical_pager;
    L14:
        return R.layout.ttlive_top_default_view;
    L15:
        return R.layout.ttlive_gift_bag_topbar_widget;
    L16:
        return R.layout.ttlive_gift_fans_club_top_bar_widget;
    L17:
        return R.layout.ttlive_base_gift_view_holder_new_vertical;
    L18:
        return R.layout.ttlive_top_gift_buff_view;
    L19:
        return R.layout.ttlive_widget_forbiden_minors_consume_notice;
    L20:
        return R.layout.ttlive_top_gift_diy_view;
    L21:
        return R.layout.ttlive_dialog_top_detail_widget;
    L22:
        return R.layout.ttlive_custom_gift_topbar_widget;
    L23:
        return R.layout.ttlive_gift_activity_top_view;
    L24:
        return R.layout.ttlive_top_gift_group_view;
    L25:
        return R.layout.ttlive_growth_touch_lynx_view;
    L26:
        return R.layout.ttlive_gift_honor_level_view_v3;
    L27:
        return R.layout.ttlive_base_gift_recharge_view;
    L28:
        return R.layout.ttlive_base_gift_tab_view;
    L29:
        return R.layout.ttlive_base_gift_combo_widget;
    L30:
        return R.layout.ttlive_dialog_group_live_room_widget_new;
    L31:
        return R.layout.ttlive_dialog_select_gift_receiver_widget_new;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zo2.a
    public String getTag() {
        return name();
    }

    public GiftPanelNitaViewInfo(String r100, int r101) {
        super(r100, r101);
    }
}
