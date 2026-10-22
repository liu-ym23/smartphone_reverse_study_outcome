package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.r3;
import com.larus.nova.R;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes9.dex */
public class c implements k {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.k
    public j create() {
        j r100 = new j();
        GiftConfigKey r101 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        r100.b(r101, new DiamondConfig(r3.a(), r3.c(), r3.b(), 8));
        GiftConfigKey r102 = GiftConfigKey.KEY_GIFT_DIALOG_SYNC_XG_COIN;
        Boolean r103 = Boolean.FALSE;
        r100.b(r102, r103);
        DiamondConfig.f126567d.getClass();
        r100.b(r101, DiamondConfig.a.a());
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_ITEM_HEIGHT_DIP, 104);
        GiftConfigKey r104 = GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_FIRST_CHARGE;
        Boolean r105 = Boolean.TRUE;
        r100.b(r104, r105);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_HONOR_LEVEL, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_DEFAULT_TOP_TEXT, Integer.valueOf(R.string.ttlive_gift_top_bar_xt_default_text));
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_GROUP_DESC, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_NEED_PROMOTION_AD, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_NEW_STYLE_VH, r105);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_SHOW_FIRST_RECHARGE_NOT_LOGIN, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_SEND_GIFT_FANS_CLUB_PRE_CHECK, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_PROP_PANEL_UPDATE_ON_SEND_FINISH, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_NEW_GROUP, r105);
        r100.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_TRAY_BG_EFFECT, r103);
        r100.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_DISPLAY_USER_NAME, r103);
        r100.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, r103);
        r100.b(GiftConfigKey.KEY_NORMAL_GIFT_ENABLE_LANDSCAPE_ANIM_IN_MEDIA, r105);
        r100.b(GiftConfigKey.KEY_NORMAL_GIFT_NEED_RESET_VISIBILITY, r103);
        r100.b(GiftConfigKey.KEY_NORMAL_GIFT_NEED_HAND_SHOW, r103);
        r100.b(GiftConfigKey.KEY_NORMAL_GIFT_COMBO_ANIM_STYLE, 0);
        r100.b(GiftConfigKey.KEY_NORMAL_GIFT_ENABLE_TRAY_GRADIENT, r103);
        r100.b(GiftConfigKey.KEY_GIFT_SHOW_HONOR_ICON, r105);
        r100.b(GiftConfigKey.KEY_GIFT_SHOW_AVATAR_BORDER, r105);
        r100.b(GiftConfigKey.KEY_GIFT_TRAY_ADJUST_WITH_DIALOG_IN_LANDSCAPE, r103);
        r100.b(GiftConfigKey.KEY_CORE_DOWNLOAD_RES_MAX_TASK_COUNT, 3);
        r100.b(GiftConfigKey.KEY_CORE_DOWNLOAD_ENSURE_INIT_IN_SDK, r103);
        r100.b(GiftConfigKey.KEY_CORE_EFFECT_MESSAGE_DES_NEED_DETAIL, r103);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_USE_NEW_DATA_SOURCE, r103);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_USE_NEW_MARGIN, r103);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_NEED_LABEL_COLOR, r103);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_VIEW_USE_PIC, r103);
        r100.b(GiftConfigKey.KEY_GIFT_DEFAULT_ICON, Integer.valueOf(R.drawable.ttlive_ic_default_gift));
        r100.b(GiftConfigKey.KEY_GIFT_SELECTED_IMAGE_BG, Integer.valueOf(R.drawable.ttlive_bg_gift_selected));
        r100.b(GiftConfigKey.KEY_PAGER_BOTTOM_SHOWER_ICON, TuplesKt.to(Integer.valueOf(R.drawable.ttlive_bg_gift_pager_shower_normal), Integer.valueOf(R.drawable.ttlive_bg_gift_pager_shower_selected)));
        r100.b(GiftConfigKey.KEY_PAGER_BOTTOM_SHOWER_MARGIN_TOP, 8);
        r100.b(GiftConfigKey.KEY_PAGER_BOTTOM_SHOWER_MARGIN, 0);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_LANDSCAPE_SINGLE_LIST, r103);
        r100.b(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, Integer.valueOf(R.drawable.ttlive_empty_content_dark));
        r100.b(GiftConfigKey.KEY_BACKPACK_GIFT_LIST_EMPTY_CHECK_RECORD_TEXT, Integer.valueOf(R.string.ttlive_gift_backpack_empty_check_record_text));
        r100.b(GiftConfigKey.KEY_BACKPACK_GIFT_LIST_EMPTY_CHECK_RECORD_ICON, Integer.valueOf(R.drawable.ttlive_ui_gift_backpack_check_record_arrow));
        r100.b(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, TuplesKt.to(Integer.valueOf(R.color.ttlive_gift_bottom_tab_selected_color), Integer.valueOf(R.color.ttlive_gift_bottom_tab_normal_color)));
        r100.b(GiftConfigKey.KEY_GIFT_BOTTOM_RECHARGE_COLOR, Integer.valueOf(R.color.ttlive_gift_bottom_recharge_color));
        r100.b(GiftConfigKey.KEY_GIFT_EMPTY_SEND_VIEW_ICON, Integer.valueOf(R.drawable.ttlive_bg_live_red_normal_btn));
        r100.b(GiftConfigKey.KEY_GIFT_SEND_VIEW_ICON, Integer.valueOf(R.drawable.ttlive_bg_live_gray_normal_btn));
        r100.b(GiftConfigKey.KEY_GIFT_GRAY_SEND_GROUP_COUNT_BTN_RTL, Integer.valueOf(R.drawable.ttlive_bg_live_gray_select_group_rtl_btn));
        r100.b(GiftConfigKey.KEY_GIFT_GRAY_SEND_GROUP_COUNT_BTN, Integer.valueOf(R.drawable.ttlive_bg_live_gray_select_group_btn));
        r100.b(GiftConfigKey.KEY_GROUP_SELECTOR_BACKGROUND_ICON, Integer.valueOf(R.drawable.ttlive_bg_gift_group_count_style));
        r100.b(GiftConfigKey.KEY_GROUP_SELECTOR_SIZE, TuplesKt.to(Integer.valueOf(R.dimen.ttlive_gift_group_count_popup_width), Integer.valueOf(R.dimen.ttlive_gift_group_count_popup_height)));
        r100.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_NEED_LABEL_COLOR_RES, TuplesKt.to(Integer.valueOf(R.color.ttlive_level_honor_need_label_highlight), Integer.valueOf(R.color.ttlive_level_honor_need_label_normal)));
        r100.b(GiftConfigKey.KEY_SHOW_SPECIAL_RECHARGE_GUIDE, r103);
        r100.b(GiftConfigKey.KEY_NEED_INIT_RECHARGE_GUIDE, r103);
        r100.b(GiftConfigKey.KET_GIFT_GUIDE_SHOW_BLANK_HINT, r103);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SEND_GIFT_TIP_STR, Integer.valueOf(R.string.ttlive_send_gift_tip));
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_PROTECT_UNDERAGE_STR, Integer.valueOf(R.string.ttlive_live_protect_underage));
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_FIRST_CHARGE_GUIDE, r103);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_AUTO_DISMISS, r103);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW, r105);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_SPECIAL_NICK, r103);
        r100.b(GiftConfigKey.KEY_GIFT_SPLIT_NAME, r103);
        r100.b(GiftConfigKey.KEY_PROP_SHOW_NUM, r105);
        r100.b(GiftConfigKey.KEY_PROP_FIX_TEXT, r103);
        r100.a(m.class, new e());
        r100.a(n12.f.class, new n12.d());
        r100.a(o.class, new g());
        r100.a(l.class, new d());
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        p r106 = new w02.e();
    L9:
        r100.a(w02.g.class, r106);
        r100.a(n.class, new f());
        r100.a(w02.h.class, new w02.a());
        r100.a(w02.i.class, new w02.b());
        if (PadConfigUtils.c() == false) goto L12;
    L15:
        p r107 = new w02.f();
    L16:
        r100.a(w02.j.class, r107);
        return r100;
    L12:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L15;
        r107 = new w02.d();
        goto L16
    L5:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L8;
        r106 = new w02.c();
        goto L9
    }
}
