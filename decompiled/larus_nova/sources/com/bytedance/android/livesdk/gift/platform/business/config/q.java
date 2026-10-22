package com.bytedance.android.livesdk.gift.platform.business.config;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends c {
    @Override // com.bytedance.android.livesdk.gift.platform.business.config.c, com.bytedance.android.livesdk.gift.platform.business.config.k
    public final j create() {
        j r100 = super.create();
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_ITEM_HEIGHT_DIP, 110);
        GiftConfigKey r101 = GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_HONOR_LEVEL;
        Boolean r102 = Boolean.TRUE;
        r100.b(r101, r102);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_DEFAULT_TOP_TEXT, Integer.valueOf(R.string.ttlive_gift_top_bar_not_login));
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_SEND_GIFT_FANS_CLUB_PRE_CHECK, r102);
        r100.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_TRAY_BG_EFFECT, r102);
        GiftConfigKey r103 = GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT;
        Boolean r104 = Boolean.FALSE;
        r100.b(r103, r104);
        r100.b(GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_NEW_STYLE_VH, r102);
        r100.b(GiftConfigKey.KEY_NORMAL_GIFT_COMBO_ANIM_STYLE, 1);
        r100.b(GiftConfigKey.KEY_GIFT_SHOW_HONOR_ICON, r104);
        r100.b(GiftConfigKey.KEY_GIFT_SHOW_AVATAR_BORDER, r104);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_USE_NEW_MARGIN, r102);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_NEED_LABEL_COLOR, r102);
        r100.b(GiftConfigKey.KEY_CORE_HONOR_VIEW_USE_PIC, r102);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_FIRST_CHARGE_GUIDE, r102);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_AUTO_DISMISS, r102);
        r100.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_SPECIAL_NICK, r102);
        r100.a(m.class, new n12.a());
        r100.a(n12.f.class, new n12.c());
        r100.a(o.class, new i());
        r100.a(l.class, new h());
        r100.a(n.class, new n12.b());
        return r100;
    }

    public q() {
    }
}
