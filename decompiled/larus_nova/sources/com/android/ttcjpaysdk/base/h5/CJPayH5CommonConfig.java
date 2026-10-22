package com.android.ttcjpaysdk.base.h5;

import android.text.TextUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayH5CommonConfig {
    public static String CJ_ABTEST_KEYS = "cj_abtest_keys";
    public static String CJ_SAAS = "is_caijing_saas";
    public static String CJ_SETTINGS_KEYS = "cj_settings_keys";
    static final String DEFAULT_BACK_BUTTON_COLOR = "";
    public static String KERNEL_TYPE = "kernel_type";
    static final String KEY_BACKGROUND_COLOR = "key_background_color";
    static final String KEY_BACK_BUTTON_COLOR = "key_back_button_color";
    static final String KEY_BACK_BUTTON_ICON = "key_back_button_icon";
    public static String KEY_BACK_HOOK_ACTION = "key_back_hook_action";
    public static final String KEY_CALLBACK_ID = "key_callback_id";
    static final String KEY_CANVAS_MODE = "key_canvas_mode";
    static final String KEY_DISABLE_CLOSE = "key_disable_close";
    static final String KEY_ENABLE_FONT_SCALE = "key_enable_font_scale";
    public static final String KEY_EXTEND_PARAMS = "key_extend_params";
    static final String KEY_FROM_DOU_PLUS = "key_from_dou_plus";
    static final String KEY_FROM_WX_INDEPENDENT_SIGN = "key_from_wx_independent_sign";
    public static final String KEY_IS_FROM_BANNER = "key_is_from_banner";
    static final String KEY_IS_NEED_TRANSPARENT = "key_is_need_transparent";
    static final String KEY_IS_SHOW_TITLE = "show_title";
    static final String KEY_IS_SHOW_TITLE_BAR = "key_is_show_title_bar";
    static final String KEY_IS_SUPPORT_MULTIPLE_THEME = "key_is_support_multiple_theme";
    static final String KEY_IS_TRANS_TITLE_BAR = "key_is_trans_title_bar";
    public static final String KEY_KEEP_ORIGINAL_QUERY = "keep_original_query";
    static final String KEY_LINK = "link";
    public static final String KEY_LINK_ORIGIN = "link_origin";
    static final String KEY_NAVIGATION_BAR_COLOR = "key_navigation_bar_color";
    static final String KEY_OPEN_H5_CONTEXT = "key_open_h5_context";
    public static final String KEY_PARAMS_HOST_BACK_URL = "host_back_url";
    static final String KEY_SCREEN_TYPE = "key_screen_type";
    static final String KEY_SHOW_LOADING = "key_show_loading";
    public static String KEY_STATUS_BAR_COLOR = "status_bar_color";
    static final String KEY_STATUS_BAR_TEXT_STYLE = "key_status_bar_text_style";
    static final String KEY_TIMEOUT = "key_timeout";
    static final String KEY_TITLE = "title";
    static final String KEY_TITLE_BAR_BG_COLOR = "key_title_bar_bg_color";
    static final String KEY_TITLE_TEXT_COLOR = "key_title_text_color";
    static final String KEY_WX_PAY_IS_HIDE_WEBVIEW = "key_wx_pay_is_hide_webview";
    static final String KEY_WX_PAY_REFER = "key_wx_pay_refer";
    public static String RIFLE_MEGA_OBJECT = "rifle_mega_object";
    public static String RIFLE_MEGA_OBJECT_ID = "rifle_mega_object_id";
    public static String RIGHT_BUTTON_COLOR = "right_button_color";
    public static String RIGHT_BUTTON_TYPE = "right_button_type";

    public static final enum RightButtonType extends Enum<RightButtonType> {
        private static final /* synthetic */ RightButtonType[] $VALUES = null;
        public static final RightButtonType NULL = null;
        public static final RightButtonType SHARE = null;
        private final String name;

        private static /* synthetic */ RightButtonType[] $values() {
            return new RightButtonType[]{NULL, SHARE};
        }

        static {
            NULL = new RightButtonType("NULL", 0, "null");
            SHARE = new RightButtonType("SHARE", 1, "share");
            $VALUES = $values();
        }

        public static RightButtonType[] values() {
            return (RightButtonType[]) $VALUES.clone();
        }

        public static RightButtonType valueOf(String r100) {
            return (RightButtonType) r27.a.a(RightButtonType.class, r100);
        }

        public static void invokeRightButtonAction(String r100, Function1<RightButtonType, Unit> r101) {
            RightButtonType r102 = SHARE;
            if (TextUtils.equals(r102.name, r100) == false) goto L5;
            r101.invoke(r102);
            return;
        L5:
            r101.invoke(NULL);
        }

        private RightButtonType(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public CJPayH5CommonConfig() {
    }
}
