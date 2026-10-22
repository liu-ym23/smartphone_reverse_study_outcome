package com.bytedance.android.livehostapi.platform.depend;

import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public final enum Properties extends Enum<Properties> implements IPropertyCache.IProperty {
    private static final /* synthetic */ Properties[] $VALUES = null;
    public static final Properties CLICK_RECORD_BUTTON_IN_END_LIVE = null;
    public static final Properties DECORATION_ANCHOR_ID = null;
    public static final Properties DECORATION_CUSTOMIZE_TEXT = null;
    public static final Properties DECORATION_LIST = null;
    public static final Properties DECORATION_TEXT_PASS_LEVEL = null;
    public static final Properties FAST_GIFT_HIDE_CONFIRM_GIFT = null;
    public static final Properties FIRST_ENTER_LIVE_START = null;
    public static final Properties GIFT_LIST = null;
    public static final Properties HAS_SHOW_FILTER_GUIDE = null;
    public static final Properties LAST_SHARE_CHANNEL = null;
    public static final Properties LIVE_INTERACT_BEAUTY_LEVEL = null;
    public static final Properties LIVE_INTERACT_PK_AUTO_MATCH = null;
    public static final Properties LIVE_INTERACT_PK_AUTO_START_MATCH = null;
    public static final Properties LIVE_INTERACT_PK_SETTING_RED_POINT = null;
    public static final Properties LIVE_INTERACT_PK_THEME = null;
    public static final Properties LIVE_INTERACT_PK_TIME_INDEX = null;
    public static final Properties LIVE_INTERACT_SETTING_RED_POINT = null;
    public static final Properties LIVE_LAST_SHOW_RED_POINT_TIME = null;
    public static final Properties LOCATION_HINT_SHOWN_COUNT = null;
    public static final Properties NEED_FAST_GIFT_HINT = null;
    public static final Properties SEND_DELAY_RED_ENVELOPE = null;
    public static final Properties SHOW_INTERACT_GUIDE = null;
    public static final Properties SHOW_LIVE_LANDSCAPE_GUIDE = null;
    public static final Properties SHOW_LIVE_PORTRAIT_GUIDE = null;
    public static final Properties SHOW_ROOM_DECORATION_TOAST = null;
    private final Object defVal;
    private final String key;
    private final boolean supportPersist;
    private final IPropertyCache.PropertyType type;

    static {
        IPropertyCache.PropertyType r110 = IPropertyCache.PropertyType.String;
        Properties r100 = new Properties("GIFT_LIST", 0, "gift_list", r110, "", true);
        GIFT_LIST = r100;
        Properties r101 = new Properties("LAST_SHARE_CHANNEL", 1, "last_share_channel", r110, "", true);
        LAST_SHARE_CHANNEL = r101;
        IPropertyCache.PropertyType r102 = IPropertyCache.PropertyType.Boolean;
        Boolean r103 = Boolean.FALSE;
        Properties r104 = new Properties("SHOW_LIVE_PORTRAIT_GUIDE", 2, "show_live_portrait_guide", r102, r103, true);
        SHOW_LIVE_PORTRAIT_GUIDE = r104;
        Properties r105 = new Properties("SHOW_LIVE_LANDSCAPE_GUIDE", 3, "show_live_landscape_guide", r102, r103, true);
        SHOW_LIVE_LANDSCAPE_GUIDE = r105;
        Boolean r106 = Boolean.TRUE;
        Properties r107 = new Properties("FIRST_ENTER_LIVE_START", 4, "first_enter_live_start", r102, r106, true);
        FIRST_ENTER_LIVE_START = r107;
        Properties r111 = new Properties("CLICK_RECORD_BUTTON_IN_END_LIVE", 5, "click_record_button_in_end_live", r102, r103, true);
        CLICK_RECORD_BUTTON_IN_END_LIVE = r111;
        Properties r112 = new Properties("HAS_SHOW_FILTER_GUIDE", 6, "has_show_filter_guide", r102, r103, true);
        HAS_SHOW_FILTER_GUIDE = r112;
        IPropertyCache.PropertyType r210 = IPropertyCache.PropertyType.Long;
        Properties r211 = new Properties("FAST_GIFT_HIDE_CONFIRM_GIFT", 7, "fast_gift_hide_confirm_gift", r210, 0L, true);
        FAST_GIFT_HIDE_CONFIRM_GIFT = r211;
        Properties r113 = new Properties("DECORATION_ANCHOR_ID", 8, "room_decoration_anchor_id", r210, 0L, true);
        DECORATION_ANCHOR_ID = r113;
        IPropertyCache.PropertyType r212 = IPropertyCache.PropertyType.Integer;
        Properties r114 = new Properties("DECORATION_TEXT_PASS_LEVEL", 9, "room_decoration_text_pass_level", r212, 31, true);
        DECORATION_TEXT_PASS_LEVEL = r114;
        Properties r213 = new Properties("DECORATION_CUSTOMIZE_TEXT", 10, "room_decoration_customize_text", r110, "", true);
        DECORATION_CUSTOMIZE_TEXT = r213;
        Properties r214 = new Properties("DECORATION_LIST", 11, "room_decoration_list", r110, "", true);
        DECORATION_LIST = r214;
        Properties r215 = new Properties("SHOW_INTERACT_GUIDE", 12, "has_shown_interact_guide", r210, 0L, true);
        SHOW_INTERACT_GUIDE = r215;
        Properties r216 = new Properties("SEND_DELAY_RED_ENVELOPE", 13, "send_delay_red_envelope", r102, r106, true);
        SEND_DELAY_RED_ENVELOPE = r216;
        Properties r217 = new Properties("NEED_FAST_GIFT_HINT", 14, "need_fast_gift_hint", r102, r106, true);
        NEED_FAST_GIFT_HINT = r217;
        Properties r218 = new Properties("SHOW_ROOM_DECORATION_TOAST", 15, "show_room_decoration_toast", r102, r106, true);
        SHOW_ROOM_DECORATION_TOAST = r218;
        Properties r219 = new Properties("LOCATION_HINT_SHOWN_COUNT", 16, "location_hint_shown_count", r212, 0, true);
        LOCATION_HINT_SHOWN_COUNT = r219;
        Properties r310 = new Properties("LIVE_INTERACT_SETTING_RED_POINT", 17, "live_interact_red_point", r102, r106, true);
        LIVE_INTERACT_SETTING_RED_POINT = r310;
        Properties r311 = new Properties("LIVE_INTERACT_PK_SETTING_RED_POINT", 18, "live_interact_pk_red_point", r102, r106, true);
        LIVE_INTERACT_PK_SETTING_RED_POINT = r311;
        Properties r312 = new Properties("LIVE_INTERACT_PK_AUTO_MATCH", 19, "live_interact_pk_auto_match", r102, r106, true);
        LIVE_INTERACT_PK_AUTO_MATCH = r312;
        Properties r108 = new Properties("LIVE_INTERACT_PK_AUTO_START_MATCH", 20, "live_interact_pk_auto_start_match", r102, r103, true);
        LIVE_INTERACT_PK_AUTO_START_MATCH = r108;
        Properties r109 = new Properties("LIVE_INTERACT_PK_THEME", 21, "live_interact_pk_theme", r110, "", true);
        LIVE_INTERACT_PK_THEME = r109;
        Properties r115 = new Properties("LIVE_INTERACT_PK_TIME_INDEX", 22, "live_interact_pk_time_index", r212, 1, true);
        LIVE_INTERACT_PK_TIME_INDEX = r115;
        Properties r313 = new Properties("LIVE_LAST_SHOW_RED_POINT_TIME", 23, "live_last_show_red_point_time", r210, 0, true);
        LIVE_LAST_SHOW_RED_POINT_TIME = r313;
        Properties r220 = new Properties("LIVE_INTERACT_BEAUTY_LEVEL", 24, "live_interact_beauty_level", r212, 2, true);
        LIVE_INTERACT_BEAUTY_LEVEL = r220;
        $VALUES = new Properties[]{r100, r101, r104, r105, r107, r111, r112, r211, r113, r114, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r108, r109, r115, r313, r220};
    }

    public static Properties[] values() {
        return (Properties[]) $VALUES.clone();
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache.IProperty
    public Object defValue() {
        return this.defVal;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache.IProperty
    public String key() {
        return this.key;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache.IProperty
    public boolean supportPersist() {
        return this.supportPersist;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IPropertyCache.IProperty
    public IPropertyCache.PropertyType type() {
        return this.type;
    }

    public static Properties valueOf(String r100) {
        return (Properties) a.a(Properties.class, r100);
    }

    private Properties(String r100, int r101, String r102, IPropertyCache.PropertyType r103, Object r104, boolean r105) {
        super(r100, r101);
        this.key = r102;
        this.type = r103;
        this.defVal = r104;
        this.supportPersist = r105;
    }
}
