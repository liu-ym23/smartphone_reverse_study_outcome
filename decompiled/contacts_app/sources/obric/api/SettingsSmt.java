package obric.api;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.util.Singleton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class SettingsSmt {
    public static final String ACTION_WIFI_DISPLAY_SETTINGS = "android.settings.WIFI_DISPLAY_SETTINGS";
    static final String TAG = "SettingsSmt";
    static final Singleton<SettingsSmt> sSettingsSmt = null;

    public static class ACL_MODE {
        public static final int ACL_MODE_DEFAULT = 1;
        public static final int ACL_MODE_OFF = 0;
        public static final int ACL_MODE_ON = 1;

        public ACL_MODE() {
        }
    }

    public static final class BRIGHTNESS_KEY_FUNCTION_VALUE {
        public static final int BRIGHTNESS_ADJUSTMENT = 1;
        public static final int LIGHTEN_DARKEN_SCREEN = 2;
        public static final int UNDEFINED = 0;

        @Deprecated
        public static final int VOICE_ASSIST = 3;

        @Deprecated
        public static final int VOLUME_ADJUSTMENT = 2;

        public BRIGHTNESS_KEY_FUNCTION_VALUE() {
        }
    }

    public interface ClockTheme {
        public static final int TYPE_FIRST = 0;
        public static final int TYPE_FOURTH = 3;
        public static final int TYPE_SECOND = 1;
        public static final int TYPE_THIRD = 2;
    }

    public interface CustomKeyValue {
        public static final String CUSTOM_KEY_ALBUM_DRAWER_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_APP_DRAWER_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_CLOSE_ALL_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_CLOSE_OTHER_WINDOW_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_CLOSE_WINDOW_VALUE = "NONE$META_ALT_ON+KEYCODE_F4";
        public static final String CUSTOM_KEY_DESKTOP_VALUE = "KEYCODE_F11$META_META_ON+KEYCODE_D";
        public static final String CUSTOM_KEY_EXIT_APP_VALUE = "META_META_ON+KEYCODE_Q$NONE";
        public static final String CUSTOM_KEY_FILE_DRAWER_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_FULLSCREEN_TO_THE_LEFT_VALUE = "META_CTRL_ON+KEYCODE_DPAD_LEFT$META_CTRL_ON+META_META_ON+KEYCODE_DPAD_LEFT";
        public static final String CUSTOM_KEY_FULLSCREEN_TO_THE_RIGHT_VALUE = "META_CTRL_ON+KEYCODE_DPAD_RIGHT$META_CTRL_ON+META_META_ON+KEYCODE_DPAD_RIGHT";
        public static final String CUSTOM_KEY_FULLSCREEN_VALUE = "META_CTRL_ON+META_META_ON+KEYCODE_F$KEYCODE_F11";
        public static final String CUSTOM_KEY_HIDE_APP_ALL_WINDOWS_VALUE = "META_META_ON+KEYCODE_H$NONE";
        public static final String CUSTOM_KEY_HIDE_OTHER_APP_WINDOW_VALUE = "META_META_ON+META_ALT_ON+KEYCODE_H$NONE";
        public static final String CUSTOM_KEY_LOCK_VALUE = "META_CTRL_ON+META_META_ON+KEYCODE_Q$META_META_ON+KEYCODE_L";
        public static final String CUSTOM_KEY_MINIMIZE_CURRENT_WINDOW_VALUE = "META_META_ON+KEYCODE_M$NONE";
        public static final String CUSTOM_KEY_MINIMIZE_OTHER_WINDOW_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_MULTI_TASKS_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_MULTI_TASKS_WITHIN_APP_VALUE = "META_CTRL_ON+KEYCODE_DPAD_DOWN$NONE";
        public static final String CUSTOM_KEY_NOTIFICATION_CENTER_VALUE = "NONE$META_META_ON+KEYCODE_A";
        public static final String CUSTOM_KEY_OPEN_NEW_FILE_MANAGER_WINDOW_VALUE = "NONE$META_META_ON+KEYCODE_E";
        public static final String CUSTOM_KEY_ORGANIZE_SMALL_WINDOW_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_QUICK_SWITCH_CENTER_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_RESUME_WINDOW_VALUE = "NONE$NONE";
        public static final String CUSTOM_KEY_SCRAPBOOK_DRAWER_VALUE = "NONE$META_META_ON+KEYCODE_V";
        public static final String CUSTOM_KEY_SCREEN_SHOT_FULLSCREEN_VALUE = "META_SHIFT_ON+META_META_ON+KEYCODE_3$KEYCODE_PrintScreen";
        public static final String CUSTOM_KEY_SCREEN_SHOT_VALUE = "META_SHIFT_ON+META_META_ON+KEYCODE_4$META_SHIFT_ON+META_META_ON+KEYCODE_S";
        public static final String CUSTOM_KEY_START_GLOBAL_SEARCH_DEFAULT_VALUE = "META_META_ON+KEYCODE_SPACE$KEYCODE_ALT_LEFT+KEYCODE_ALT_LEFT";
        public static final String CUSTOM_KEY_TITLE_BAR_SWITCH_VALUE = "NONE$NONE";
        public static final String NONE_VALUE = "NONE";
        public static final String SEPARATE = "$";
        public static final String SEPARATE_PARSE = "\\$";
    }

    public static final class FORCE_TOUCH {
        public FORCE_TOUCH() {
        }

        public static boolean isForceTouch(ContentResolver r2, float r3) {
            if (r3 < Settings.Global.getFloat(r2, "pressure_of_forcetouch", 0.6f)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class GestureKey {
        public static final String SCREEN_GESTURE_CONTROL_CENTER = "screen_gesture_control_center";
        public static final String SCREEN_GESTURE_MAGIC_FLOW = "screen_gesture_magic_flow";
        public static final String SCREEN_GESTURE_NAV_BACK = "screen_gesture_nav_back";
        public static final String SCREEN_GESTURE_NAV_MENU = "screen_gesture_nav_menu";
        public static final String SCREEN_GESTURE_SCROLL_CANVAS = "screen_gesture_scroll_canvas";
        public static final String SCREEN_GESTURE_SWITCH_TASK = "screen_gesture_switch_task";
        public static final String SCREEN_GESTURE_TASK_MANAGER = "screen_gesture_task_manager";
        public static final String SCREEN_GESTURE_TASK_MANAGER_4_FINGERS = "screen_gesture_task_manager_4_fingers";
        public static final String SCREEN_GESTURE_WINDOW_MAX = "screen_gesture_window_max";
        public static final String SCREEN_GESTURE_WINDOW_MIN = "screen_gesture_window_min";
        public static final String SCREEN_GESTURE_WINDOW_MOVE = "screen_gesture_window_move";
        public static final String SCREEN_GESTURE_WINDOW_RESET = "screen_gesture_window_reset";
        public static final String SCREEN_GESTURE_ZOOM_CANVAS = "screen_gesture_zoom_canvas";
        public static final String TOUCHPAD_GESTURE_CONTROL_CENTER = "touchpad_gesture_control_center";
        public static final String TOUCHPAD_GESTURE_DISABLE_WHEN_MOUSE_CONNECTED = "touchpad_gesture_disable_when_mouse_connected";
        public static final String TOUCHPAD_GESTURE_MAGIC_FLOW = "touchpad_gesture_magic_flow";
        public static final String TOUCHPAD_GESTURE_NAV_BACK = "touchpad_gesture_nav_back";
        public static final String TOUCHPAD_GESTURE_NAV_MENU = "touchpad_gesture_nav_menu";
        public static final String TOUCHPAD_GESTURE_NAV_MENU_2_FINGERS = "touchpad_gesture_nav_menu_2_fingers";
        public static final String TOUCHPAD_GESTURE_SCROLL_CANVAS = "touchpad_gesture_scroll_canvas";
        public static final String TOUCHPAD_GESTURE_SELECT_TEXT = "touchpad_gesture_select_text";
        public static final String TOUCHPAD_GESTURE_SWIPE_REVERSE = "touchpad_gesture_swipe_reverse";
        public static final String TOUCHPAD_GESTURE_SWITCH_TASK = "touchpad_gesture_switch_task";
        public static final String TOUCHPAD_GESTURE_TASK_MANAGER = "touchpad_gesture_task_manager";
        public static final String TOUCHPAD_GESTURE_TASK_MANAGER_4_FINGERS = "touchpad_gesture_task_manager_4_fingers";
        public static final String TOUCHPAD_GESTURE_WINDOW_MAX = "touchpad_gesture_window_max";
        public static final String TOUCHPAD_GESTURE_WINDOW_MIN = "touchpad_gesture_window_min";
        public static final String TOUCHPAD_GESTURE_WINDOW_MOVE = "touchpad_gesture_window_move";
        public static final String TOUCHPAD_GESTURE_WINDOW_RESET = "touchpad_gesture_window_reset";
        public static final String TOUCHPAD_GESTURE_ZOOM_CANVAS = "touchpad_gesture_zoom_canvas";

        public GestureKey() {
        }
    }

    public static final class Global {
        public static final String ACTION_LIST_CANCEL_BUTTON = "action_list_cancel_button";
        public static final String ALLOW_CALL = "allow_call";
        public static final int ALLOW_CALL_ADRESS = 1;
        public static final int ALLOW_CALL_ALL = 0;
        public static final int ALLOW_CALL_DESIGNATED = 3;
        public static final int ALLOW_CALL_FAVORITES = 2;
        public static final int ALLOW_CALL_NONE = 4;
        public static final String APP_DRAWER_ENABLE = "app_drawer_enable";
        public static final String AUTO_SWITCH_LOCKSCREEN_WALLPAPER_EARLIEST_ID = "auto_switch_lockscreen_wallpaper_earliest_id";
        public static final String AUTO_SWITCH_LOCKSCREEN_WALLPAPER_ENABLE = "auto_switch_lockscreen_wallpaper_enable";
        public static final String AUTO_SWITCH_LOCKSCREEN_WALLPAPER_FREQUENCY = "auto_switch_lockscreen_wallpaper_frequency";
        public static final String AUTO_SWITCH_LOCKSCREEN_WALLPAPER_LATEST_ID = "auto_switch_lockscreen_wallpaper_latest_id";
        public static final String BACK_VIA_HOME_KEY = "back_via_home_key";
        public static final String BACK_VIA_HOME_VIBRATION = "back_via_home_vibration";
        public static final String BACK_WITH_ESC_ENABLED = "back_with_esc_enabled";
        public static final String BIG_BANG_DEFAULT_DICT = "big_bang_default_dict";
        public static final String BIG_BANG_DISABLE_OCR_IN_GAME = "big_bang_disable_ocr_in_game";
        public static final String BIG_BANG_HOT_WORD_CARD = "big_bang_hot_word_card";
        public static final String BIG_BANG_OCR = "big_bang_ocr";
        public static final String BIG_BANG_OCR_AUDIO_LANGUAGE = "big_bang_ocr_audio_language";
        public static final String BIG_BANG_OCR_LANGUAGE = "big_bang_ocr_language";
        public static final String BOOM_TEXT_TRIGGER_AREA = "boom_text_trigger_area";
        public static final int BOOM_TEXT_TRIGGER_AREA_LARGE = 3;
        public static final int BOOM_TEXT_TRIGGER_AREA_LARGEST = 4;
        public static final int BOOM_TEXT_TRIGGER_AREA_MIDDLE = 2;
        public static final int BOOM_TEXT_TRIGGER_AREA_SMALL = 1;
        public static final int BOOM_TEXT_TRIGGER_AREA_SMALLEST = 0;
        public static final String BRIGHTNESS_KEY_FUNCTION = "brightness_key_function";
        public static final String BRIGHTNESS_KEY_FUNCTION_SCREEN_OFF = "brightness_key_function_screen_off";
        public static final String BUTTON_LIGHTS_ON = "button_lights_on";
        public static final String CALCULATOR_RESET = "calculator_reset";
        public static final String CAMERA_ENABLE_BY_POWER_KEY_DOUBLE_CLICK = "camera_enable_by_power_key_double_click";
        public static final String CANCEL_WECHA_FROM_DRAWER_BY_SELF = "cancel_wechat_from_drawer_by_self";
        public static final String CAST_RELAY_MODE = "cast_relay_mode";
        public static final String CHARGE_UP_MAX_POWER = "charge_up_max_power";
        public static final String CHARGE_UP_PHONE_MODE = "charge_up_phone_mode";
        public static final String CLICK_ENABLE_SCREEN_ON = "click_enable_screen_on";
        public static final String CLOCK_THEME_STYLE = "clock_theme_style";
        public static final String CLOUD_GALLERY_SYNC_ONLY_WIFI = "cloud_gallery_sync_only_wifi";
        public static final String COLOR_TEMPERATURE_ENABLE = "color_temperature_enable";
        public static final String CONTACTS_DIALPAD_CHANGE_LAYOUT = "contacts_dialpad_change_layout";
        public static final String CONTACTS_DIALPAD_LEFT_MODE = "contacts_dialpad_left_mode";
        public static final String CONTACTS_VOICE_SEARCH_BTN_ENABLED = "contacts_voice_search_btn_enabled";
        public static final String CONTACTS_WITH_PHONES_ONLY = "list_contacts_with_phones_only";
        public static final String COUNTDOWN_SEC_FOR_VIRTUAL_CALL = "countdown_sec_for_virtual_call";
        public static final String COVER_COLOR_CALIBRATED = "cover_color_calibrated";
        public static final String CURSOR_SHAPE = "cursor_shape";
        public static final String CURSOR_WATER_DROP_SWITCH = "cursor_water_drop_switch";
        public static final String CUSTOM_KEY_ALBUM_DRAWER = "custom_key_album_drawer";
        public static final String CUSTOM_KEY_APP_DRAWER = "custom_key_app_drawer";
        public static final String CUSTOM_KEY_CLOSE_ALL = "custom_key_close_all";
        public static final String CUSTOM_KEY_CLOSE_OTHER_WINDOW = "custom_key_close_other_window";
        public static final String CUSTOM_KEY_CLOSE_WINDOW = "custom_key_close_window";
        public static final String CUSTOM_KEY_DESKTOP = "custom_key_desktop";
        public static final String CUSTOM_KEY_EXIT_APP = "custom_key_exit_app";
        public static final String CUSTOM_KEY_FILE_DRAWER = "custom_key_file_drawer";
        public static final String CUSTOM_KEY_FULLSCREEN = "custom_key_fullscreen";
        public static final String CUSTOM_KEY_FULLSCREEN_TO_THE_LEFT = "custom_key_fullscreen_to_the_left";
        public static final String CUSTOM_KEY_FULLSCREEN_TO_THE_RIGHT = "custom_key_fullscreen_to_the_right";
        public static final String CUSTOM_KEY_HEADSET_HOOK = "custom_key_headset_hook";
        public static final String CUSTOM_KEY_HIDE_APP_ALL_WINDOWS = "custom_key_hide_app_all_windows";
        public static final String CUSTOM_KEY_HIDE_OTHER_APP_WINDOW = "custom_key_hide_other_app_window";
        public static final String CUSTOM_KEY_LOCK = "custom_key_lock";
        public static final String CUSTOM_KEY_MINIMIZE_CURRENT_WINDOW = "custom_key_minimize_current_window";
        public static final String CUSTOM_KEY_MINIMIZE_OTHER_WINDOW = "custom_key_minimize_other_window";
        public static final String CUSTOM_KEY_MULTI_TASKS = "custom_key_multi_tasks";
        public static final String CUSTOM_KEY_MULTI_TASKS_WITHIN_APP = "custom_key_multi_tasks_within_app";
        public static final String CUSTOM_KEY_NOTIFICATION_CENTER = "custom_key_notification_center";
        public static final String CUSTOM_KEY_OPEN_NEW_FILE_MANAGER_WINDOW = "custom_key_open_new_file_manager_window";
        public static final String CUSTOM_KEY_ORGANIZE_SMALL_WINDOW = "custom_key_organize_small_window";
        public static final String CUSTOM_KEY_QUICK_SWITCH_CENTER = "custom_key_quick_switch_center";
        public static final String CUSTOM_KEY_RESUME_WINDOW = "custom_key_resume_window";
        public static final String CUSTOM_KEY_SCRAPBOOK_DRAWER = "custom_key_scrapbook_drawer";
        public static final String CUSTOM_KEY_SCREEN_SHOT = "custom_key_screen_shot";
        public static final String CUSTOM_KEY_SCREEN_SHOT_FULL = "custom_key_screen_shot_full";
        public static final String CUSTOM_KEY_START_GLOBAL_SEARCH = "custom_key_start_global_search";
        public static final String CUSTOM_KEY_TITLE_BAR_SWITCH = "custom_key_title_bar_switch";
        public static final String CUSTOM_KEY_VOLUME_DOWN = "custom_key_volume_down";
        public static final String CUSTOM_KEY_VOLUME_UP = "custom_key_volume_up";
        public static final String CUSTOM_KEY_WIRELESS_CAST_NAME = "custom_key_wireless_cast_name";
        public static final String CUSTOM_THUMB_PULLDOWN_WALLPAPER_URI = "custom_thumb_pulldown_wallpaper_uri";
        public static final String DATA_USAGE_CYCLE = "data_usage_cycle";
        public static final String DATA_USAGE_LIMIT = "data_usage_limit";
        public static final String DATA_USAGE_LIMIT_SUB2 = "data_usage_limit_sub2";
        public static final String DATA_USAGE_LIMIT_UNIT = "data_usage_limit_unit";
        public static final String DATA_USAGE_LIMIT_UNIT_SUB2 = "data_usage_limit_unit_sub2";
        public static final String DATA_USAGE_WARNING = "data_usage_warning";
        public static final String DATA_USAGE_WARNING_SUB2 = "data_usage_warning_sub2";
        public static final String DEFAULT_BROWSER_SETTING_DONE = "default_browser_setting_done";
        public static final String DEFAULT_BUBBLE_TYPE = "default_bubble_type";
        public static final String DEFAULT_CALENDAR_NOTIFICATION_SOUND_PATH = "default_notification_calendar_sound_path";
        public static final String DEFAULT_LAUNCHER_THEME = "default_launcher_theme";
        public static final String DEFAULT_LOCKSCREEN_URI = "default_lockscreen_uri";
        public static final String DEFAULT_MMS_NOTIFICATION_SOUND_PATH = "default_notification_mms_sound_path";
        public static final String DEFAULT_NEW_EMAIL_NOTIFICATION_SOUND_PATH = "default_notification_receive_email_sound_path";
        public static final String DEFAULT_SEND_EMAIL_NOTIFICATION_SOUND_PATH = "default_notification_send_email_sound_path";
        public static final String DEFAULT_THUMB_PULLDOWN_WALLPAPER_URI = "default_thumb_pulldown_wallpaper_uri";

        @Deprecated
        public static final String DESKTOP_EDGE_ADSORPTION_SWITCH = "desktop_edge_adsorption_switch";
        public static final String DESKTOP_MEETING_WALLPAPER_URI = "desktop_meeting_wallpaper_uri";
        public static final String DESKTOP_SLIDE_DOWN_SEARCH = "desktop_slide_down_search";
        public static final String DESKTOP_WALLPAPER_URI = "desktop_wallpaper_uri";
        public static final String DEVELOPMENT_FINGERPRINT_USE_MASK = "development_fingerprint_use_mask";
        public static final String DEVICE_OWNER = "device_owner";
        public static final String DIALOG_CLOSE_BUTTON = "dialog_close_button";
        public static final String DISABLE_HW_OVERLAY = "disable_hw_overlay";
        public static final String DISPLAY_LARGE_BATTERY_IN_LOCKSCREEN = "display_large_battery_in_lockscreen";
        public static final String DISPLAY_WHEN_SCREEN_OFF_ENABLE = "display_when_screen_off_enable";
        public static final String DOUBLE_CLICK_BACK = "double_click_back";
        public static final String DOUBLE_CLICK_HOME = "double_click_home";
        public static final String DOUBLE_CLICK_MENU = "double_click_menu";
        public static final String DTS_SOUND_ENABLE = "dts_sound_enable";
        public static final String DYNAMIC_RES_STATE = "dynamic_resolution_state";
        public static final String EDGE_PALM_REJECTION = "edge_palm_rejection";
        public static final String ELDERSHIP_MODE_ENABLE = "eldership_mode_enable";
        public static final String ENABLE_DEBUG_HW_OVERLAY = "enable_debug_hw_overlay";
        public static final String ENABLE_QUICK_APP_VIA_FINGERPRINT = "enable_quick_app_via_fingerprint";
        public static final String ENABLE_TIKTOK_ON_KEYGUARD = "enable_tiktok_on_keyguard";
        public static final String EVER_ENABLE_MEMORY_OPT = "ever_enable_memory_opt";
        public static final String EXTRACT_TEXT_RULES = "extract_text_rules";
        public static final String FACE_DATA_ENABLE_WHEN_NOTIFICATION_TURN_ON_SCREEN = "face_data_enable_when_notification_turn_on_screen";
        public static final String FACE_DATA_LOCK_SCREEN_ENABLE = "faceid_enable";
        public static final String FACE_RECOGNITION_ENABLED = "face_recognition_enabled";
        public static final String FEATURE_PHONE_MODE = "feature_phone_mode";
        public static final String FINGER_SLIDE_SWITCH_WALLPAPER = "finger_slide_switch_wallpaper";
        public static final String FIVEG_POWER_SAVER_ENABLED = "fiveg_power_saver_enabled";
        public static final String FOODISPLAY_UI_STYLE = "foodisplay_ui_style";
        public static final String FORCE_TOUCH_PUSHPIN_STATE = "force_touch_pushpin_state";
        public static final String FORCE_TOUCH_STATE = "force_touch_state";
        public static final String FOUR_FINGERS_CHANGE_LOCKSCREEN_ENABLE = "four_fingers_change_lockscreen_enable";
        public static final String FUZZY_TONES_ENABLED = "fuzzy_tones_enabled";
        public static final String GAME_FLOAT_APP = "game_float_app";
        public static final String GAME_MODE_ACCELERATE_ENABLE = "game_mode_accelerate_enable";
        public static final String GAME_MODE_ENABLE = "game_mode_enable";
        public static final String GAME_MODE_LOCK_AUTO_BRIGHTNESS_ENABLE = "game_mode_lock_auto_brightness_enable";
        public static final String GAME_MODE_NAV_BAR_BTN_FORBIDDEN = "game_mode_nav_bar_btn_forbidden";

        @Deprecated
        public static final String GAME_MODE_NOTIFICATION_CENTER_FORBIDDEN = "game_mode_notification_center_forbidden";
        public static final String GAME_MODE_NO_DISTURB_ENABLE = "game_mode_no_disturb_enable";
        public static final String GAME_MODE_SHORTCUT_KEY_FORBIDDEN = "game_mode_shortcut_key_forbidden";
        public static final String GAME_NOT_ACCELERATE_PACKAGES = "game_not_accelerate_packages";
        public static final String GAME_SIDEBAR_MENU = "game_sidebar_menu";
        public static final String GLOBAL_DEFAULT_WIKI = "global_default_wiki";
        public static final String GLOBAL_HOURLY_CHIME_END = "accessibility_hourly_chime_end";
        public static final String GLOBAL_HOURLY_CHIME_FREQUENCY = "accessibility_hourly_chime_frequency";
        public static final String GLOBAL_HOURLY_CHIME_REPORT_RING_TYPE = "accessibility_hourly_chime_ringtone_type";
        public static final String GLOBAL_HOURLY_CHIME_REPORT_TYPE = "accessibility_hourly_chime_type";
        public static final String GLOBAL_HOURLY_CHIME_START = "accessibility_hourly_chime_start";
        public static final String GLOBAL_HOURLY_CHIME_STATE = "accessibility_hourly_chime";
        public static final String GLOBAL_LEFT_SWIPE_GESTURE = "global_left_swipe_gesture";
        public static final String GLOBAL_OCR_STATE = "accessibility_global_ocr";
        public static final String GLOBAL_PC_MODE_SETTINGS = "global_pc_mode_settings";
        public static final String GLOBAL_PC_VERSION = "global_pc_version";
        public static final String GLOBAL_PRE_EXIT_PC_MODE_SETTINGS = "global_pre_exit_pc_mode_settings";
        public static final String GLOBAL_QUICK_SHARE_ENABLE = "global_quick_share_enable";
        public static final String GLOBAL_VIBRATION_ENABLED = "global_vibration_enabled";
        public static final String GLOBAL_VOICE_INPUT_SWITCH = "global_voice_input_switch";
        public static final String GLOVE_MODE_ENABLE = "glove_mode_enable";
        public static final String HALL_SENSOR_ENABLE = "hall_sensor_enable";
        public static final String HAND_IN_HAND_LOGGED_IN = "hand_in_hand_logged_in";
        public static final String HARDWARE_BUTTONS = "hardware_buttons";
        public static final String HARDWARE_DETAIL_INFO = "hardware_detail_info";
        public static final String HEARING_DOUBLE_CLICK_PILLS_KEY = "double_click_pill_key";
        public static final String HEARING_REAL_CAPTION = "hearing_real_caption";
        public static final String HEARING_SPEAKER_SOUND = "hearing_speaker_sound";
        public static final String HEARING_SWITCH = "hearing_switch";
        public static final String HIDE_TODO_OVER_BUBBLE = "hide_todo_over_bubble";
        public static final String HIGH_PERFORMANCE_MODE = "high_performance_mode";
        public static final String HOME_SWIPE_VIBRATION = "home_swipe_vibration";
        public static final String ICONS_ON_LOCK_SCREEN = "icons_on_lock_screen";
        public static final String ICON_ILLUMINATION = "icon_illumination";
        public static final String IDEA_PILLS_VISIBLE = "idea_pills_visible";
        public static final String IFLY_SPEAKER_INDEX = "ifly_speaker_index";
        public static final String IMAGE_SECTOR_VIEW_ENABLE = "image_sector_view_enable";
        public static final String INNERDRAG_ICON_STATE = "innerdrag_icon_state";
        public static final String INPUT_KEYBOARD_MODE = "input_keyboard_mode";
        public static final String INTELLIGENT_SORT_SHARELIST = "intelligent_sort_sharelist";
        public static final String INTELLIGENT_WORDS_ENABLE = "intelligent_words_enable";
        public static final String IS_FIRST_GET_SHARE_KEY = "if_first_get_sharekey";
        public static final String IS_FIRST_GET_SHORTCUT_KEY = "is_first_get_shortcut_key";
        public static final String JOIN_UE_ON = "join_ue_on";
        public static final String KEEP_APP_ALIVE_AFTER_WINDOW_CLOSED = "keep_app_alive_after_window_closed";
        public static final String KEEP_MEDIA_PANEL_EXPANDED = "keep_media_panel_expanded";
        public static final String KEYBOARD_CUSTOM_KEY = "keyboard_custom_key";
        public static final String KEYBOARD_CUSTOM_KEY_START_APP_PKG = "keyboard_custom_key_start_app_pkg";
        public static final String KEYBOARD_KEYS_REPEAT_DELAY = "keyboard_keys_repeat_delay";
        public static final String KEYBOARD_KEYS_REPEAT_INTERVAL = "keyboard_keys_repeat_interval";
        public static final String KEYBOARD_PREFERENCE = "keyboard_preference";
        public static final String KEYBOARD_STYLE = "keyboard_style";
        public static final String KEYGUARD_CHARGE_ANIM = "keyguard_charging_anim";
        public static final String KEYGUARD_STYLE = "keyguard_style";
        public static final String KEYGUARD_WALLPAPER_THEME = "keyguard_wallpaper_theme";
        public static final String KEYPAD_MODE = "keypad_mode";
        public static final String KEY_CALL_VOLUME_MUTE = "key_call_volume_mute";
        public static final String KEY_HIDDEN_FILES_VISIBILITY = "hidden_files_visibility";
        public static final String KEY_STYLUS_BATTERY = "key_stylus_battery";
        public static final String KEY_TNT_VOLUME_MUTE = "key_tnt_volume_mute";
        public static final String KEY_VOLUME_ADJUST_FEEDBACK = "key_volume_adjust_feedback";
        public static final String LAST_BRIGHTNESS_KEY_FUNCTION = "last_brightness_key_function";
        public static final String LAST_GRID_LAUNCHER_MODE = "last_grid_launcher_mode";
        public static final String LAUNCHER_FLIP_ANIM = "launcher_page_animation";

        @Deprecated
        public static final String LAUNCHER_FLIP_ANIMATION = "launcher_flip_animation";
        public static final String LAUNCHER_GRIDS_COUNT_X = "launcher_grids_x";
        public static final String LAUNCHER_GRIDS_COUNT_Y = "launcher_grids_y";
        public static final String LAUNCHER_GRID_THEME = "launcher_grid_theme";
        public static final String LAUNCHER_MODE = "launcher_mode";

        @Deprecated
        public static final String LAUNCHER_MULTI_BLOCK_FAST_LAUNCH_APP = "fast_launch_app_on";
        public static final String LAUNCHER_MULTI_BLOCK_MODE = "multi_block_mode";
        public static final String LAUNCHER_SWITCHING_ORIENTATION = "launcher_switching_orientation";
        public static final String LAUNCHER_THEME = "launcher_theme";
        public static final String LAUNCHER_TRASH_GEAR = "launcher_trash_gear";
        public static final String LAUNCHER_UNLOCK_ANIMATION_ENABLED = "launcher_unlock_animation_enabled";
        public static final String LAUNCHER_WALLPAPER_URI = "launcher_wallpaper_uri";
        public static final String LED_LIGHTS_ON = "led_lights_on";
        public static final String LEFT_SLIDE_LUNCH_GLOBAL_PILLS = "left_slide_lunch_global_pills";
        public static final String LIGHT_NOTIFY_FOR_CALL = "light_notify_for_call";
        public static final String LIMIT_SCREEN_REFRESH_RATE = "limit_screen_refresh_rate";
        public static final String LOCKSCREEN_HOME_TRIGGER_TYPE = "lockscreen_home_trigger_type";
        public static final String LOCKSCREEN_NOTIFICATION_FOR = "lockscreen_notification_for";

        @Deprecated
        public static final String LOCKSCREEN_STYLE = "lockscreen_style";
        public static final String LONG_CLICK_BACK = "long_click_back";
        public static final String LONG_CLICK_BRIGHTNESS_KEY = "long_click_brightness_key";
        public static final String LONG_CLICK_HOME = "long_click_home";
        public static final String LONG_CLICK_HOME_VOLUME_DOWN = "long_click_home_volume_down";
        public static final String LONG_CLICK_HOME_VOLUME_UP = "long_click_home_volume_up";
        public static final String LONG_CLICK_MENU = "long_click_menu";
        public static final String MANUAL_ROTATION_STATE = "manual_rotation_state";
        public static final String MAYBE_LAUNCH_PKG_FROM_PREDICT_RESULT = "maybe_launch_pkg_from_predict_result";
        public static final String MEMORY_OPT_ENABLE = "memory_opt_enable";
        public static final String MEMORY_OPT_NO_DISTURB = "memory_opt_no_disturb";
        public static final String MENU_MOVE_DOWN_NC = "menu_move_down_nc";
        public static final String MENU_MOVE_DOWN_WHEN = "menu_move_down_when";
        public static final String MESSAGE_BARRAGE_NOTIFICATION = "message_barrage_notification";
        public static final String MOUSE_LEFT_MAIN_BUTTON_ENABLE = "mouse_left_main_button_enable";
        public static final String MOUSE_SCROLL_ORIENTATION = "mouse_scroll_orientation";
        public static final String MOUSE_SCROLL_SPEED = "mouse_scroll_speed";
        public static final String MUSIC_VOICE_SEARCH_BTN_ENABLED = "music_voice_search_btn_enabled";
        public static final String MUTE_DOUBLE_CHECK_ENABLE = "mute_double_check_enable";
        public static final String NAVBAR_TAP_OR_SWIPE = "navbar_tap_or_swipe";
        public static final String NAVIGATIONBAR_APP_SWITCH_GESTURE = "navigationbar_app_switch_gesture";

        @Deprecated
        public static final String NAVIGATIONBAR_LAYOUT = "hardware_buttons";
        public static final String NAVIGATIONBAR_STYLE = "navigationbar_style";
        public static final String NAVIGATIONBAR_THEME = "navigationbar_theme";
        public static final String NAVIGATIONBAR_TRIGGER_MODE = "navigationbar_trigger_mode";
        public static final String NAVIGATION_BAR_MODE = "navigation_bar_mode";
        public static final String NAV_FIXED_MODE = "nav_fixed_mode";
        public static final String NETWORK_PROTECTION = "network_protection";
        public static final String NET_ON_NON_DATA_SIM = "temp_switch_dds";
        public static final String NOTCH_LANDSCAPE_STATE = "notch_landscape_state";
        public static final String NOTCH_STATUS_BAR_STATE = "notch_status_bar_state";
        public static final String NOTIFICATION_TABLET_ONLY = "bytedanceos.phone.silence";
        public static final String OCEAN_2K_RESOLUTION_DISPLAY_SWITCH = "ocean_2k_resolution_display_switch";
        public static final String ONESTEP_MAIN_APP_VOLUME = "onestep_main_app_volume";
        public static final String ONE_HAND_MODE = "one_hand_mode";
        public static final String OPTIMIZATION_APPS = "optimization_APPS";
        public static final String ORIGINAL_LAUNCHER_WALLPAPER_BLUR_ON = "original_launcher_wallpaper_blur_on";
        public static final String OTA_ENABLE_AUTO_DOWNLOAD = "ota_enable_auto_download";
        public static final String PERSPECTIVE_CAMERA_ZOOM_SWITCH = "perspective_camera_zoom_switch";
        public static final String PERSPECTIVE_COMBINE_KEY_SWITCH = "perspective_combine_key_switch";
        public static final String PERSPECTIVE_GALLERY_SUPPORT_SWITCH = "perspective_gallery_support_switch";
        public static final String PERSPECTIVE_GAODE_MAP_SUPPORT_SWITCH = "perspective_gaode_map_support_switch";
        public static final String PERSPECTIVE_SWITCH = "perspective_switch";
        public static final String PERSPECTIVE_TASK_FOCUS_STYLE_SWITCH = "perspective_task_focus_style_switch";
        public static final String PHONE_CASE_MATCH_STATE = "phone_case_match_state";
        public static final String PHONE_CASE_SHORTCUT_KEY1 = "phone_case_shortcut_key_1";
        public static final String PHONE_CASE_SHORTCUT_KEY2 = "phone_case_shortcut_key_2";
        public static final String PHONE_CASE_SHORTCUT_KEY3 = "phone_case_shortcut_key_3";
        public static final String PHONE_CASE_STATE = "phone_case_state";
        public static final String PHONE_LOCKED_BY_CLOUDSERVICE = "phone_locked_by_cloud";
        public static final String PICKUP_ENABLE_FINGERPRINT = "pickup_enable_fingerprint";
        public static final String PICKUP_SHOW_FP_ICON = "pickup_show_fp_icon";
        public static final String PINNED_TASK_COMPONENT = "PINNED_TASK_COMPONENT";
        public static final String PINNED_TASK_ID = "PINNED_TASK_ID";
        public static final String PINNED_TASK_USER_ID = "PINNED_TASK_USER_ID";
        public static final String PINNED_WINDOW_SHOW = "PINNED_WINDOW_SHOW";
        public static final String POPCORN_SOUND = "popcorn_sound";
        public static final String POWER_ACL_MODE_ENABLE = "acl_mode_enable";
        public static final String POWER_SLEEP_MODE_ENABLE = "sleep_mode_enable";
        public static final String PRESSURE_OF_FORCETOUCH = "pressure_of_forcetouch";
        public static final String PRESS_HOME_AND_BACK = "press_home_and_back";
        public static final String PRESS_MENU_AND_BACK = "press_menu_and_back";
        public static final String PRESS_MENU_AND_HOME = "press_menu_and_home";
        public static final String PREVENT_LOCKED_SCREEN_WRONG_TOUCH_ENABLE = "prevent_locked_screen_wrong_touch_enable";
        public static final String PROTECT_EYES_AUTO_TIMER_ENABLE = "protect_eyes_auto_timer_enable";
        public static final String PROTECT_EYES_COLOR_VALUE = "protect_eyes_color_value";
        public static final String PROTECT_EYES_ENABLE = "protect_eyes_enable";
        public static final String PROTECT_EYES_FEATURE_ENABLE = "protect_eyes_feature_enable";
        public static final String PROTECT_EYES_MODE = "protect_eyes_mode";
        public static final String PROTECT_EYES_TIMER_VALUE = "protect_eyes_timer_value";
        public static final String PUSH_DOWN_HOVER = "push_down_hover";
        public static final String QUICK_ACCESS_CONTACTS = "quick_access_contacts";
        public static final String QUICK_APP_VIA_FINGERPRINT_ID_ = "quick_app_via_fingerprint_id_";
        public static final String QUICK_PHRASE_ENABLED = "quick_phrases_enabled";
        public static final String QUICK_UNLOCK_WHEN_SCREEN_OFF = "quick_unlock_when_screen_off";
        public static final String READ_MODE_ENABLE = "read_mode_enable";
        public static final String RECOGNIZE_LANGUAGE = "language";
        public static final String RECORDER_RECORDING_STATE = "recorder_recording_state";
        public static final String REDUCE_SCREEN_STROBE = "reduce_screen_strobe";
        public static final String REJECT_CALL = "reject_call";
        public static final String REPEATED_CALL = "repeated_call";
        public static final String RESIDENT_TIMEZONE = "resident_timezone";
        public static final String REVONE_DESKTOP_MODE_SWITCH = "revone_desktop_mode_switch";
        public static final String REVONE_DP_LANE_NUM = "revone_dp_lane_num";
        public static final String REVONE_PROTECT_EYES_SWITCH = "revone_protect_eyes_switch";
        public static final String REVONE_REALTIME_SCREEN_BRIGHTNESS = "revone_realtime_screen_brightness";
        public static final String REVONE_SCREEN_BRIGHTNESS = "revone_screen_brightness";
        public static final String REVONE_SCREEN_BRIGHTNESS_MODE = "revone_screen_brightness_mode";
        public static final String SAFE_KEYBOARD_SWITCH = "safe_keyboard_switch";
        public static final String SAVE_VOICE_RECORDER = "save_voice_to_recorder";
        public static final String SCRATCHING_RECORDS = "scratching_records";
        public static final String SCREENSHOT_NOTIFICATION = "screenshot_notification_enabled";
        public static final String SCREEN_COLOR_MODE = "screen_color_mode";
        public static final String SCREEN_COLOR_MODE_PREVIOUS = "screen_color_mode_previous";
        public static final String SCREEN_RECORDER_STATUS = "screen_recorder_status";
        public static final String SCREEN_SHOT_WHEN_SHOW_QUICK_PANEL = "screen_shot_when_show_quick_panel";
        public static final String SEARCH_APPLICATION_SUGGESTIONS = "search_application_suggestions";
        public static final String SEARCH_HISTORY = "search_history";
        public static final String SEARCH_POPULAR_INFORMATION = "search_popular_information";
        public static final String SELECTED_QUESTION = "selected_question";
        public static final String[] SETTINGS_TO_BACKUP = null;
        public static final String SHARE_ITEM_INFOS = "share_item_infos";
        public static final String SHIELDED_STATUS_BAR_NOTIFICATION = "shielded_status_bar_notification";
        public static final String SHORTCUT_APP_INFOS = "shortcut_app_infos";
        public static final String SHOW_DATE_OF_CURRENT_TIMEZONE = "show_date_of_current_timezone";
        public static final String SHOW_FLOAT_WINDOW_WHEN_COPY_URL = "show_float_window_when_copy_url";
        public static final String SHOW_NETWORK_SPEED = "show_network_speed";
        public static final String SIDEBAR_INNERDRAG_STATE = "sidebar_innerdrag_state";
        public static final String SIDEBAR_TRIGGER_MODE = "sidebar_trigger_mode";
        public static final String SIDE_BAR_MODE = "side_bar_mode";
        public static final String SIDE_BAR_ZOOM_TYPE = "side_bar_zoom_type";
        public static final String SIDE_DIAL_CAR_MODE_SWITCH = "side_dial_car_mode_switch";
        public static final String SIDE_DIAL_CLEAN_MODE_SWITCH = "side_dial_clean_mode_switch";
        public static final String SIDE_DIAL_ENABLE = "side_dial_enable";
        public static final String SIDE_DIAL_TYPE = "side_dial_type";
        public static final String SIGHT_TRACKING_ENABLE = "sight_tracking_enable";
        public static final String SLEEP_MODE_LAST_MOBILE_STATE = "sleep_mode_last_mobile_state";
        public static final String SLEEP_MODE_LAST_NOTIFICATION_PULSE_STATE = "sleep_mode_last_notification_pulse_state";
        public static final String SLEEP_MODE_LAST_WIFIAP_STATE = "sleep_mode_last_wifiap_state";
        public static final String SLEEP_MODE_LAST_WIFI_STATE = "sleep_mode_last_wifi_state";
        public static final String SMART_DISPLAY_STATE = "smart_display_state";
        public static final String SMART_KEY_CLICK_FUNCTION = "smart_key_click_function";
        public static final String SMART_KEY_DOUBLE_CLICK_FUNCTION = "smart_key_double_click_function";

        @Deprecated
        public static final String SMART_KEY_ENABLED = "smart_key_enabled";
        public static final String SMART_KEY_LONG_CLICK_FUNCTION = "smart_key_long_click_function";
        public static final String SMART_KEY_LONG_CLICK_FUNCTION_WHEN_SCREEN_OFF = "smart_key_long_click_function_when_screen_off";
        public static final String SMART_KEY_SPECIAL_CASE = "smart_key_special_case";
        public static final String SMART_SCREEN_PROTECTOR = "smart_screen_protector";
        public static final String SMT_FP_ANIM_TYPE = "smt_fp_anim_type";
        public static final String SMT_IME_LEXICON_OPTION = "lexicon_option";
        public static final String SMT_IME_VOICE_OPTION = "voice_option";
        public static final String SM_BACK_CAMERA_VIDEO_SIZE = "bytedance_back_camera_video_size";
        public static final String SM_CAMERA_IMAGE_QUALITY = "bytedance_camera_image_quality";
        public static final String SM_CAMERA_LOCATION_ENABLED = "bytedance_camera_location_enabled";
        public static final String SM_CAMERA_MUTE = "bytedance_camera_mute";
        public static final String SM_CAMERA_SETUP_MODE = "bytedance_camera_setup_mode";
        public static final String SM_FRONT_CAMERA_VIDEO_SIZE = "bytedance_front_camera_video_size";
        public static final String SM_GLOBAL_LAUNCHER_LEFT_SCREEN_STATE = "sm_global_launcher_left_screen_state";
        public static final String SM_LAUNCHER_LEFT_SCREEN_STATE = "sm_launcher_left_screen_state";
        public static final String SPEECH_READING_STATE = "accessibility_speech_reading";
        public static final String SQUEEZE_SIDE_BUTTONS = "squeeze_side_buttons";
        public static final String SQUEEZE_SIDE_BUTTONS_ENABLED = "squeeze_side_buttons_enabled";
        public static final String SQUEEZE_SIDE_BUTTONS_SCREEN_OFF = "squeeze_side_buttons_screen_off";

        @Deprecated
        public static final String SQUEEZE_SIDE_DOWN_BUTTONS = "squeeze_side_down_buttons";
        public static final String SQUEEZE_SIDE_UP_BUTTONS = "squeeze_side_up_buttons";
        public static final String SQUEEZE_SIDE_UP_BUTTONS_SCREEN_OFF = "squeeze_side_up_buttons_screen_off";
        public static final String SQUEEZE_UP_SIDE_BUTTONS_ENABLED = "squeeze_up_side_buttons_enabled";
        public static final String SQUEEZE_WITH_POWER_ENABLED = "squeeze_with_power_enabled";
        public static final String SQUEEZE_WITH_POWER_FUNCTION = "squeeze_with_power_function";
        public static final String SQUEEZE_WITH_POWER_FUNCTION_HISTORY = "squeeze_with_power_function_history";
        public static final String STAY_IN_LOCKED_SCREEN_WHEN_FACE_RECOGNIZED = "stay_in_locked_screen_when_face_recognized";
        public static final String STAY_ON_ALLTIME = "stay_on_alltime";
        public static final String STORAGE_PATH_BROWSER_DOWNLOAD = "storage_path_browser_download";
        public static final String STORAGE_PATH_CAMERA = "storage_path_camera";
        public static final String STORAGE_PATH_CAPTIVATE = "storage_path_captivate";
        public static final String STORAGE_PATH_GALLERY = "storage_path_gallery";
        public static final String STORAGE_PATH_LOCAL_BACKUP = "storage_path_local_backup";
        public static final String STORAGE_PATH_MAIL_ATTACHMENT_DOWNLOAD = "storage_path_mail_attachment_download";
        public static final String STORAGE_PATH_MUSIC = "storage_path_music";
        public static final String STORAGE_PATH_RECORDING = "storage_path_recording";
        public static final String STORAGE_PATH_SCREENSHOT = "storage_path_screenshot";
        public static final String STYLUS_CUSTOM_KEY_APP_DOUBLE_CLICK = "stylus_custom_key_app_double_click";
        public static final String STYLUS_CUSTOM_KEY_APP_ONE_CLICK = "stylus_custom_key_app_one_click";
        public static final String STYLUS_CUSTOM_KEY_DOUBLE_CLICK = "stylus_custom_key_double_click";
        public static final String STYLUS_CUSTOM_KEY_LAUNCH_SPECIFIED_APP = "stylus_custom_key_launch_specified_app";
        public static final String STYLUS_CUSTOM_KEY_LONG_PRESS = "stylus_custom_key_long_press";
        public static final String STYLUS_CUSTOM_KEY_ONE_CLICK = "stylus_custom_key_one_click";
        public static final String STYLUS_CUSTOM_RENAME = "stylus_custom_rename";
        public static final String SWAP_STORAGE_HEALTH = "swap_storage_health";
        public static final String SWITCHER_ENABLE_TNT_MIC = "switcher_enable_TNT_mic";
        public static final String SWITCH_LEAK_CANARY = "open_close_leak_canary";
        public static final String SWITCH_WITH_BRIGHTNESS_KEYS = "switch_with_brightness_keys";
        public static final String SYSTEM_APP_CUSTOMIZED_STATUS_BAR = "system_app_customized_status_bar_";
        public static final String TABLET_DOCK_BAR_APP_DRAWER_SHOW = "tablet_dock_bar_app_drawer_show";
        public static final String TABLET_DOCK_BAR_BING_BANG_SHOW = "tablet_dock_bar_bing_bang_show";
        public static final String TABLET_DOCK_BAR_FUNCTION_KEY = "tablet_dock_bar_function_key";
        public static final String TABLET_DOCK_BAR_GLOBAL_SEARCH = "tablet_dock_bar_global_search";
        public static final String TABLET_DOCK_BAR_HIDE_SHOW_WINDOW_SHOW = "tablet_dock_bar_hide_show_window_show";
        public static final String TABLET_DOCK_BAR_MULTI_TASKS_SHOW = "tablet_dock_bar_multi_tasks_show";
        public static final String TABLET_DOCK_BAR_RECENT_FILES = "tablet_dock_bar_recent_files";
        public static final String TABLET_DOCK_BAR_SCREENSHOT = "tablet_dock_bar_screenshot";
        public static final String TABLET_DOCK_BAR_WHITE_PAD = "tablet_dock_bar_white_pad";
        public static final String TABLET_DOCK_BAR_WINDOW_TIDY = "tablet_dock_bar_window_tidy";
        public static final String TABLET_DOCK_BAR_WORD_CHOOSE_PATTERN = "tablet_dock_bar_word_choose_pattern";
        public static final String TABLET_DPI_SETTINGS = "tablet_dpi_settings";
        public static final String TABLET_ENABLED_SHORTCUT_BUTTONS = "tablet_enabled_shortcut_buttons";
        public static final String TABLET_HEARING_REAL_CAPTION = "tablet_hearing_real_caption";
        public static final String TABLET_SHORTCUT_BUTTONS_WITH_F_KEYS = "tablet_shortcut_buttons_with_f_keys";
        public static final String TABLET_SHORTCUT_BUTTON_SWITCH = "tablet_shortcut_button_switch";
        public static final String TABLET_STATUS_BAR_LOCAL_SEARCH_SHOW = "tablet_status_bar_local_search_show";
        public static final String TABLET_STATUS_BAR_NETWORK_SEARCH_SHOW = "tablet_status_bar_network_search_show";
        public static final String TABLET_STATUS_BAR_SCREEN_RECORD_SHOW = "tablet_status_bar_screen_record_show";
        public static final String TABLET_STATUS_BAR_SEARCH_WORD_SHOW = "tablet_status_bar_search_word_show";
        public static final String TABLET_TITLE_BAR_LOCATION = "tablet_title_bar_location";
        public static final String TABLE_TITLE_BAR_MODE = "tablet_title_bar_mode";
        public static final String TELEPHONY_VIBRATION_ENABLED = "telephony_vibration_enabled";
        public static final String TEXT_BOOM = "text_boom";
        public static final String TEXT_BOOM_SEARCH_METHOD = "text_boom_search_method";
        public static final String TEXT_SECTOR_VIEW_ENABLE = "text_sector_view_enable";
        public static final String THIRD_SEARCH_DEFAULT = "third_search_default";
        public static final String THUMB_PULLDOWN_WALLPAPER_ENABLED = "thumb_pulldown_wallpaper_enabled";
        public static final String THUMB_PUSH_DOWN = "thumb_push_down";
        public static final String THUMB_TRIGGER_AREA = "thumb_trigger_area";
        public static final int THUMB_TRIGGER_AREA_LARGE = 3;
        public static final int THUMB_TRIGGER_AREA_LARGEST = 4;
        public static final int THUMB_TRIGGER_AREA_MIDDLE = 2;
        public static final int THUMB_TRIGGER_AREA_SMALL = 1;
        public static final int THUMB_TRIGGER_AREA_SMALLEST = 0;
        public static final String TIMER_RING_PULL = "timer_ring_pull";
        public static final String TNT_COMPATIBILITY_MODE = "tnt_compatibility_mode";
        public static final String TNT_DISPLAY_CONNECTED = "tnt_display_connected";
        public static final String TNT_FOO_DISPLAY_STATE = "tnt_foo_display_state";
        public static final String TNT_PROTECT_EYES_ENABLE = "TNT_protect_eyes_enable";
        public static final String TNT_PROTECT_EYES_REAL_WORKING = "TNT_eye_protection_real_working";
        public static final String TNT_READ_MODE_ENABLE = "tnt_read_mode_enable";
        public static final String TNT_SCREEN_COLOR = "TNT_screen_color";
        public static final String TNT_TRANSLATE_MODE = "tnt_translate_mode";
        public static final String TOTAL_SHORTCUT_APP_INFOS = "total_shortcut_app_infos";
        public static final String TOUCHPAL_KEYBOARD_SOUND = "touchpal_keyboard_sound_enabled";
        public static final String TOUCH_TO_CLICK = "touch_to_click";
        public static final String TRACK_BALL_HEAVY_TAP_STATE = "track_ball_heavy_tap_state";
        public static final String TRACK_BALL_LIGHT_TAP_STATE = "track_ball_light_tap_state";
        public static final String TRACK_BALL_STATE = "track_ball_state";
        public static final String TRACK_BALL_SWIPE_DOWN_STATE = "track_ball_swipe_down_state";
        public static final String TRACK_BALL_SWIPE_LEFT_STATE = "track_ball_swipe_left_state";
        public static final String TRACK_BALL_SWIPE_RIGHT_STATE = "track_ball_swipe_right_state";
        public static final String TRACK_BALL_SWIPE_UP_STATE = "track_ball_swipe_up_state";
        public static final String TRADITIONAL_CHINESE_INPUT = "traditional_input";
        public static final String TRIGGER_SEARCH_VIA_SLIDE_UP = "trigger_search_via_slide_up";
        public static final String USE_ELDERSHIP_VOLUME = "use_eldership_volume";
        public static final String USE_FINGERPRINT_IN_LAUNCHER = "use_fingerprint_in_launcher";
        public static final String USE_FINGERPRINT_IN_LOCKSCREEN = "use_fingerprint_in_lockscreen";
        public static final String USE_FINGERPRINT_IN_WALLET = "use_fingerprint_in_wallet";
        public static final String USE_FINGERPRINT_WHEN_SCREENOFF = "use_fingerprint_when_screenoff";
        public static final String VIRTUAL_CALLIN_NAME = "virtual_callin_name";
        public static final String VIRTUAL_KEY_LANDSCAPE_DOUBLE_CLICK_STATE = "virtual_key_landscape_double_click_state";
        public static final String VOICE_ASSISTANT_AIUI_ENBALE = "voice_assist_aiui_enable";
        public static final String VOICE_ASSIST_BETA_ENABLE = "voice_assist_beta_enable";
        public static final String VOICE_ASSIT = "voice_assit";

        @Deprecated
        public static final String VOICE_ASSIT_BY_HOME = "voice_assit_by_home";
        public static final String VOICE_ASSIT_BY_MENU = "voice_assit_by_menu";
        public static final String VOICE_COMMAND_STATE = "voice_command_state";
        public static final String VOICE_DIAL = "voice_dial";
        public static final String VOICE_INPUT = "voice_input";
        public static final String VOICE_INPUT_LOCAL = "voice_input_local";
        public static final String VOICE_INPUT_MODE = "voice_input_mode";
        public static final String VOICE_INPUT_SEARCH_DICT = "voice_input_search_dict";
        public static final String VOICE_INPUT_SEARCH_METHOD = "voice_input_search_method";
        public static final String VOICE_INPUT_SHOW_RESULT_CHANGED_BY = "voice_input_show_result_changed_by";
        public static final String VOICE_INPUT_SHOW_RESULT_KEY = "voice_input_show_result_key";
        public static final String VOICE_INPUT_TODO = "voice_input_todo";
        public static final String VOICE_INPUT_WEB = "voice_input_web";
        public static final String VOICE_LANGUAGE = "voice_language";
        public static final String VOICE_TODO_OVER_CYCLE = "voice_todo_over_cycle";
        public static final String VOICE_WATER_DROP_SWITCH = "voice_water_drop_switch";
        public static final String VOLUME_KEY = "volume_key";
        public static final String VOLUME_KEY_FUNCTION = "volume_key_function";
        public static final String VOLUME_LIMIT = "volume_limit";
        public static final String WIFI_AP_BAND_SETTING = "wifi_ap_band";
        public static final String WIFI_AP_SECURITY_SETTING = "wifi_ap_security";
        public static final int WIFI_DISPLAY_INCALL_AUTO_REJECT = 1;
        public static final int WIFI_DISPLAY_INCALL_NORMAL_DISPLAY = 2;
        public static final int WIFI_DISPLAY_INCALL_PAUSE_DISPLAY_UNTIL_HANG_UP = 0;
        public static final String WIFI_DISPLAY_INCALL_SETTING = "wifi_display_while_incall";
        public static final String WIFI_DISPLAY_RECEIVE_SMS_SETTING = "wifi_display_while_receive_sms";
        public static final int WIFI_DISPLAY_SMS_NORMAL_DISPLAY = 1;
        public static final int WIFI_DISPLAY_SMS_SHIELD_DISPLAY = 0;
        public static final String WIRED_BOSTON_WALLPAPER_URI = "wired_boston_wallpaper_uri";
        public static final String WIRELESS_BOSTON_WALLPAPER_URI = "wireless_boston_wallpaper_uri";
        public static final String WIRELESS_LIGHTEN_AUTO = "wireless_lighten_auto";
        public static final String WIRELESS_TNT_AUTO = "wireless_tnt_auto";
        public static final String WORLD_CLOCK_SECOND_HAND_CONSISTENT = "world_clock_second_hand_consistent";
        public static final String ZOOM_SCREEN_ENABLED = "sm_zoom_screen_enabled";
        public static final String ZOOM_SCREEN_LOCATION = "sm_zoom_screen_location";

        public Global() {
        }

        static {
            SETTINGS_TO_BACKUP = SettingsSmtEx.Global.SETTINGS_TO_BACKUP;
        }
    }

    public static final class HOME_TRIGGER_TYPE {
        public static final int TYPE_MUSIC = 0;
        public static final int TYPE_WALLET = 1;

        public HOME_TRIGGER_TYPE() {
        }
    }

    public static final class KEYBOARD_CUSTOM_KEY_VALUE {
        public static final int CLEAN_UP_BACKGROUND_TASKS = 4;
        public static final int CLOSE_SCREEN = 1;

        @Deprecated
        public static final int HELP = 2;
        public static final int NONE = 0;
        public static final int START_APP = 3;
        public static final int TASKS_MANAGER = 5;

        public KEYBOARD_CUSTOM_KEY_VALUE() {
        }
    }

    public static final class KEYGUARD_STYLE_VALUE {
        public static final int CLASSIC = 1;
        public static final int CLOCK = 0;

        public KEYGUARD_STYLE_VALUE() {
        }
    }

    public interface KeyboardPreferenceValues {
        public static final int KEYBOARD_PREFERENCE_MAC = 1;
        public static final int KEYBOARD_PREFERENCE_WINDOWS = 0;
    }

    public static final class LAUNCHER_FLIP_ANIM_VALUE {
        public static final int ANIM_CUT_CARD = 6;
        public static final int ANIM_DEFAULT = 0;
        public static final int ANIM_GATHER = 5;
        public static final int ANIM_GRID_FLIP = 3;
        public static final int ANIM_LATTICE_FLIP = 1;
        public static final int ANIM_LATTICE_STRETCH = 2;
        public static final int ANIM_SHUTTER = 4;

        public LAUNCHER_FLIP_ANIM_VALUE() {
        }
    }

    public static final class LAUNCHER_MODE_VALUE {
        public static final int LAUNCHER_MODE_GRIDS_12 = 12;
        public static final int LAUNCHER_MODE_GRIDS_16 = 16;
        public static final int LAUNCHER_MODE_GRIDS_20 = 20;
        public static final int LAUNCHER_MODE_GRIDS_9 = 9;
        public static final int LAUNCHER_MODE_ORIGINAL = 0;
        public static final int LAUNCHER_MODE_POWER_SAVE = 1;

        public LAUNCHER_MODE_VALUE() {
        }
    }

    public static final class LAUNCHER_MULTI_BLOCK_MODE_VALUE {
        public static final int LAUNCHER_MULTI_BLOCK_MODE_GRIDS_36 = 36;
        public static final int LAUNCHER_MULTI_BLOCK_MODE_GRIDS_48 = 48;
        public static final int LAUNCHER_MULTI_BLOCK_MODE_GRIDS_64 = 64;
        public static final int LAUNCHER_MULTI_BLOCK_MODE_GRIDS_80 = 80;
        public static final int LAUNCHER_MULTI_BLOCK_MODE_GRIDS_81 = 81;
        public static final int LAUNCHER_MULTI_BLOCK_MODE_ORIGINAL = 0;

        public LAUNCHER_MULTI_BLOCK_MODE_VALUE() {
        }
    }

    @Deprecated
    public static final class LOCKSCREEN_STYLE_VALUE {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
        public static final String TRANSLUCENT = "translucent";

        public LOCKSCREEN_STYLE_VALUE() {
        }
    }

    public static final class LONG_CLICK_TYPE {
        public static final String IDEA_PILLS = "idea_pills";
        public static final String NONE = null;
        public static final String POWER = "power";
        public static final String TEXT_RECOGNITION = "text_recognition";
        public static final String VOICE_COMMAND = "voice_command";

        static {
        }

        public LONG_CLICK_TYPE() {
        }
    }

    public static final class NAVBAR_MODE {
        public static final int DYNAMIC = 1;
        public static final int PIN = 0;

        public NAVBAR_MODE() {
        }
    }

    public static final class NAVBAR_STYLE {
        public static final int ANDROID = 0;
        public static final int LITTLE_PLUS = 2;
        public static final int POINT = 1;

        public NAVBAR_STYLE() {
        }
    }

    public static final class NAVBAR_THEME {
        public static final int BLACK = 0;
        public static final int GRAY = 1;
        public static final int RED_WINE = 2;

        public NAVBAR_THEME() {
        }
    }

    public static final class NOTIFICATION_WIDGET {
        public static final String BUTTON_AIRPLANE = "toggleAirplane";
        public static final String BUTTON_AUTOROTATE = "toggleAutoRotate";
        public static final String BUTTON_AUTO_BRIGHTNESS = "toggleAutoBrightness";
        public static final String BUTTON_BLUETOOTH = "toggleBluetooth";
        public static final String BUTTON_CHARGE_PHONE = "toggleChargePhone";
        public static final String BUTTON_DELIMITER = "|";
        public static final String BUTTON_DISABLE_BUTTONS = "toggleDisableButtons";
        public static final String BUTTON_EYES_PROTECTION = "toggleProtectEyes";
        public static final String BUTTON_FAKE_CALL = "toggleFakeCall";
        public static final String BUTTON_FLASHLIGHT = "toggleFlashlight";
        public static final String BUTTON_GPS = "toggleGPS";
        public static final String BUTTON_KEEP_SCREEN_ON = "toggleKeepScreenOn";
        public static final String BUTTON_LOCKSCREEN = "toggleLockScreen";
        public static final String BUTTON_MOBILEDATA = "toggleMobileData";
        public static final String BUTTON_MUTE = "toggleMute";

        @Deprecated
        public static final String BUTTON_NFC = "toggleNFC";
        public static final String BUTTON_POWER_SAVE = "togglepowersave";
        public static final String BUTTON_READING_MODE = "toggleReadingMode";
        public static final String BUTTON_REALTIME_SUBTITLE = "toggleRealtimeSubtitle";
        public static final String BUTTON_RECORD_SCREEN = "togglerrecordscreen";
        public static final String BUTTON_RELAY = "toggleRelay";
        public static final String BUTTON_SCREEN_SHOT = "toggleScreenShot";
        public static final String BUTTON_VIBRATE = "toggleVibrate";
        public static final String BUTTON_VPN = "toggleVpn";
        public static final String BUTTON_WIFI = "toggleWifi";
        public static final String BUTTON_WIFIAP = "toggleWifiAp";
        public static final String BUTTON_WIRELESS_TNT = "toggleWirelessTNT";
        private static final List<String> sAllWidgets = null;

        static {
            ArrayList r0 = new ArrayList();
            sAllWidgets = r0;
            r0.add("toggleAirplane");
            r0.add("toggleWifi");
            r0.add("toggleMobileData");
            r0.add("toggleVpn");
            r0.add("toggleWifiAp");
            r0.add("toggleBluetooth");
            r0.add("toggleDisableButtons");
            r0.add("toggleGPS");
            r0.add("toggleFlashlight");
            r0.add("toggleAutoRotate");
            r0.add("togglerrecordscreen");
            r0.add("togglepowersave");
            r0.add("toggleScreenShot");
            r0.add("toggleVibrate");
            r0.add("toggleMute");
            r0.add("toggleKeepScreenOn");
            r0.add("toggleLockScreen");
            r0.add("toggleProtectEyes");
            r0.add("toggleReadingMode");
            r0.add("toggleAutoBrightness");
            r0.add("toggleWirelessTNT");
            r0.add("toggleFakeCall");
        }

        public NOTIFICATION_WIDGET() {
        }

        public static List<String> getAllWidgets() {
            ArrayList r0 = new ArrayList();
            r0.addAll(sAllWidgets);
            return r0;
        }

        public static boolean isWidgetButton(String r1) {
            return sAllWidgets.contains(r1);
        }
    }

    public static class OCR_LANGUAGE {
        public static final int DANISH = 8192;
        public static final int DUTCH = 1024;
        public static final int ENGLISH = 1;
        public static final int FINNISH = 4096;
        public static final int FRENCH = 32;
        public static final int GERMAN = 256;
        public static final int HUNGARIAN = 32768;
        public static final int ITALIAN = 512;
        public static final int JAPANESE = 8;
        public static final int KOREAN = 16;
        public static final int NORWEGIAN = 16384;
        public static final int PORTUGUESE = 128;
        public static final int SIMPLIFIED_CHINESE = 2;
        public static final int SPANISH = 64;
        public static final int SWEDISH = 2048;
        public static final int TRADITIONAL_CHINESE = 4;

        public OCR_LANGUAGE() {
        }
    }

    public interface Ocean2KSwitchValue {
        public static final int STATUS_CHECKED = 1;
        public static final int STATUS_UNCHECKED = 0;
    }

    public interface PCMode {
        public static final int DEFAULT_PC_MODE_MIRROR = 0;
        public static final int DEFAULT_PC_MODE_TNT = 1;
    }

    public static class ResourceId {
        public static final int BYTEDANCE_APP_NOTIFICATION_OPS_ARRAY_RES = 17236170;
        public static final int LEBO_INFOS_DEVICE_ICON_RES = 17304599;
        public static final int NOTIFICATION_CENTER_WHITE_LIST_ARRAY_RES = 17236144;
        public static final int WIFI_DISPLAY_DEVICE_ICON_RES = 17304602;

        public ResourceId() {
        }
    }

    public static final class SCREEN_COLOR_MODE_VALUE {
        public static final int COLORFUL = 2;
        public static final int DEFAULTS = 0;
        public static final int STANDARD = 1;

        public SCREEN_COLOR_MODE_VALUE() {
        }
    }

    public static class SHORTCUT_BTN {
        public static final int L1 = 1;
        public static final int L2 = 2;
        public static final int L3 = 4;
        public static final int L4 = 8;
        public static final int L5 = 16;
        public static final int R1 = 32;
        public static final int R2 = 64;
        public static final int R3 = 128;
        public static final int R4 = 256;
        public static final int R5 = 512;

        public SHORTCUT_BTN() {
        }
    }

    public static final class SHORTCUT_KEY_VALUE {
        public static final String ACCESSIBILITY_TRANSCRIPTION = "accessibility_transcription";
        public static final String ANSWER_CALL = "answer_all";
        public static final String BULLET_SMS = "bullet_sms";
        public static final String DARKEN_SCREEN = "darken_screen";
        public static final String FEATURE_CMEL = "feature_cmel";
        public static final String IDEA_PILLS_LIST = "idea_pills_list";
        public static final String KEEP_SCREEN_ON = "keep_screen_on";
        public static final String LAUNCH_CACULATOR = "launch_calculator";
        public static final String LAUNCH_CAMERA = "launch_camera";
        public static final String LIGHTEN_SCREEN = "lighten_screen";
        public static final String LOCKSCREEN = "lockscreen";
        public static final String NEW_CALENDAR_TASK = "new_calendar_task";
        public static final String NEW_EMAIL = "new_email";
        public static final String NEW_NOTE = "new_note";
        public static final String NEW_QUICK_PHRASE = "new_quick_phrase";
        public static final String NEW_VOICE_RECORD = "new_voice_record";
        public static final String NONE = null;
        public static final String NOTIFICATION_CENTER = "notification_center";
        public static final String PERSPECTIVE = "perspective";
        public static final String QR_CODE = "qr_code";
        public static final String QUICK_LAUNCH_PAD = "quick_launch_pad";
        public static final String QUICK_LAUNCH_PREVIOUS_APP = "quick_launch_previous_app";
        public static final String QUICK_SHOT = "quick_shot";
        public static final String RECORD_SCREEN = "record_screen";
        public static final String SCREENSHOT = "screenshot";
        public static final String SIDE_BAR = "side_bar";
        public static final String TASKS_MANAGER = "tasks_manager";
        public static final String TEXT_RECOGNITION = "text_recognition";
        public static final String TOGGLE_MUTE = "toggle_mute";
        public static final String TOGGLE_MUTE_ON = "toggle_mute_on";
        public static final String TOGGLE_SCREEN_MOVE_DOWN = "toggle_screen_move_down";
        public static final String TORCH = "torch";
        public static final String UNDEFINE = "undefine";
        public static final String VIRTUAL_CALLIN = "virtual_callin";
        public static final String VOICE_ASSISTANT = "voice_assistant";
        public static final String VOICE_COMMAND = "voice_command";
        public static final String WALLET = "wallet";

        public SHORTCUT_KEY_VALUE() {
        }

        public static String getShortcutSetting(ContentResolver r0, String r1) {
            return SettingsSmtEx.SHORTCUT_KEY_VALUE.getShortcutSetting(r0, r1);
        }

        static {
            NONE = SettingsSmtEx.SHORTCUT_KEY_VALUE.NONE;
        }
    }

    public static final class SIDEBAR_TRIGGER_MODE {
        public static final int NONE = 0;
        public static final int ONLY_SIDEBAR = 1;
        public static final int WHOLE_ONE_STEP = 2;

        public SIDEBAR_TRIGGER_MODE() {
        }
    }

    public static class SLEEP_MODE {
        public static final int SLEEP_MODE_LAST_OFF_STATE = 0;
        public static final int SLEEP_MODE_LAST_ON_STATE = 1;
        public static final int SLEEP_MODE_OFF = 0;
        public static final int SLEEP_MODE_ON = 1;

        public SLEEP_MODE() {
        }
    }

    public static final class Secure {
        public static final String DEFAULT_CHS_INPUT_METHOD = "default_chs_input_method";
        public static final String KEYWORD_SWITCH_STATE = "keyword_swtich_state";
        public static final String LAUNCHER_APP_LOCK = "launcher_app_lock_key";
        public static final String LAUNCHER_BLOCKS_GET_BACK_ANSWER = "4e7cb907a3655ea11fee6898f196ffacf1ee6aea";
        public static final String LAUNCHER_BLOCKS_LOCK_PW = "743bd8680e21f1e22a9d76fdf1a41ee9efb503a2";
        public static final String LIMITED_NO_DISTURB_ON = "LimitedNoDisturbOn";
        public static final String NO_DISTURB_NOTIFY_WHEN_SCREEN_ON = "NoDisturbNotifyWhenScreenOn";
        public static final String NO_DISTURB_NOTIFY_WHEN_SECOND_CALL = "NoDisturbNotifyWhenSecondCall";
        public static final String NO_DISTURB_ON = "NoDisturbOn";
        public static final String NO_DISTURB_START_TIME = "NoDisturbStartTime";
        public static final String NO_DISTURB_STOP_TIME = "NoDisturbStopTime";
        public static final String OAID_ENABLE = "oaid_enable";
        public static final String SAVED_USER_PC_MODE = "pc_mode_enable";
        public static final String SECURITY_APPLOCK = "security_applock";
        public static final String SECURITY_APPLOCK_PAGE = "applock_page";
        public static final String SECURITY_APPLOCK_PKG = "applock_pkg";
        public static final String SECURITY_PASSWORD_ESCAPE = "escape_key";
        public static final String SECURITY_PRIVACY = "security_privacy";
        public static final String SECURITY_PRIVACY_PASSWORD = "9c42c98d42ebfdac";
        public static final String[] SETTINGS_TO_BACKUP = null;
        public static final String SHOW_VIRTUAL_IME_ALWAYS = "show_virtual_ime_always";
        public static final String SMART_CALL_INTERCEPT_CLASSIFY = "SmartCallInterceptClassify";
        public static final String SMART_INTERCEPT_ON = "SmartInterceptOn";
        public static final String SM_SIM_EVER_READY = "sm_sim_ever_ready";
        public static final String SM_TIMES_OF_TWIST = "sm_times_of_twist";
        public static final String SPECIAL_TYPE = "specialtype";

        static {
            SETTINGS_TO_BACKUP = new String[]{"ui_night_mode", "lock_screen_owner_info_enabled", "lock_screen_owner_info", "spell_checker_enabled", "install_non_market_apps", "NoDisturbOn", "NoDisturbStartTime", "NoDisturbStopTime", "SmartInterceptOn", "specialtype", "NoDisturbNotifyWhenScreenOn", "NoDisturbNotifyWhenSecondCall", "SmartInterceptOn", "SmartCallInterceptClassify", "launcher_app_lock_key", "LimitedNoDisturbOn", "743bd8680e21f1e22a9d76fdf1a41ee9efb503a2", "4e7cb907a3655ea11fee6898f196ffacf1ee6aea", "keyword_swtich_state", "show_virtual_ime_always", "escape_key", "9c42c98d42ebfdac", "security_privacy"};
        }

        public Secure() {
        }
    }

    public static final class System {
        public static final String ADJUST_VOLUME_SOUND = "adjust_volume_sound";
        public static final String AUDIO_EFFECT_SWITCH = "com.bytedance.audioeffect";
        public static final String AUDIO_MAX_VOLUME_BYTEDANCE = "audio_max_volume_bytedance";
        public static final String AUTO_BRIGHTNESS_BACKLIGHT = "auto_brightness_backlight";
        public static final String AUTO_BRIGHTNESS_LUX = "auto_brightness_lux";
        public static final String AUTO_BRIGHTNESS_SCHEME_HASHCODE = "auto_brightness_scheme_hashcode";
        public static final String BATTERY_CHARGE_FULL_SOUND = "battery_charge_full_sound";
        public static final String BIND_APP_SWITCH = "bind_app_switch";
        public static final String BOSTON_EXPANDED_WIDGET_BUTTONS = "boston_expanded_widget_buttons";
        public static final String BRIGHTNESS_AUTO_ADJUSTMENT = "brightness_auto_adjustment";
        public static final int CALENDAR_FIRST_DAY_OF_WEEK_DEFAULT = 2;
        public static final String CALENDAR_KEY_FIRST_DAY_OF_WEEK = "calendar_key_first_day_of_week";
        public static final String CALENDAR_RINGTONE_URI = "calendar_ringtone_uri";
        public static final String CALENDER_NOTIFICATION_CACHE = "calender_notification_cache";
        public static final Uri CALENDER_NOTIFICATION_CACHE_URI = null;
        public static final String CBS_ENABLE_CHANNEL_50 = "cbs_enable_channel_50";
        public static final String CBS_ENABLE_CHANNEL_60 = "cbs_enable_channel_60";
        public static final String CBS_ENABLE_GLOABLE = "cbs_enable_gloable";
        public static final String CBS_ENABLE_READ = "cbs_enable_read";
        public static final String CBS_ENABLE_SOUND = "cbs_enable_sound";
        public static final String CBS_ENABLE_VIBRATE = "cbs_enable_vibrate";
        public static final String DEFAULT_RINGTONE = "ringtone_default";
        public static final Uri DEFAULT_RINGTONE_URI_2 = null;
        public static final Uri DEFAULT_RINGTONE_URI_3 = null;
        public static final String DISABLE_NOTIFICATION = "disable_notification";
        public static final String DISPLAY_CHARGE_REMAIN_TIME = "display_charge_remain_time";
        public static final String EMAIL_RECEIVE_RINGTONE_URI = "email_receive_ringtone_uri";
        public static final String EMAIL_SEND_RINGTONE_URI = "email_send_ringtone_uri";
        public static final String EXPANDED_FLASH_MODE = "expanded_flash_mode";
        public static final String EXTENDED_SCREEN_AUDIO_POLICY = "extended_screen_audio_policy";
        public static final String FONT_LOOKUP_SWITCH = "font_lookup_switch";
        public static final String FONT_SCALE_PC_DISPLAY = "font_scale_pcdisplay";
        public static final String HIFI_ENABLE = "hifi_enable";
        public static final String HOURLY_CHIME_RINGTONE_URI = "hourly_chime_ringtone_uri";
        public static final String IDEA_PILLS_RINGTONE_CACHE = "idea_pills_ringtone_cache";
        public static final Uri IDEA_PILLS_RINGTONE_CACHE_URI = null;
        public static final String IDEA_PILLS_RINGTONE_URI = "idea_pills_ringtone_uri";
        public static final String INCOMING_CALL_BANNER_SETTING = "incoming_call_banner_setting";
        public static final String LAST_TORCH_CHANGE_OWNER = "last_torch_change_owner";
        public static final String LAUNCHER_BADGE_SWIPE_CLEAN = "launcher_badge_swipe_clean";
        public static final String LAUNCHER_HIDE_BADGE = "launcher_hide_badge";
        public static final String LAUNCHER_HIDE_LABLE = "launcher_hide_lable";
        public static final String LOCKSCREEN_BACKGROUND = "lockscreen_background";
        public static final String MAIL_RECEIVE_NOTIFICATION_CACHE = "mail_receive_notification_cache";
        public static final Uri MAIL_RECEIVE_NOTIFICATION_CACHE_URI = null;
        public static final String MAIL_SEND_NOTIFICATION_CACHE = "mail_send_notification_cache";
        public static final Uri MAIL_SEND_NOTIFICATION_CACHE_URI = null;
        public static final String MMS_NOTIFICATION_SIM1_CACHE = "mms_notification_sim1_cache";
        public static final Uri MMS_NOTIFICATION_SIM1_CACHE_URI = null;
        public static final String MMS_NOTIFICATION_SIM2_CACHE = "mms_notification_sim2_cache";
        public static final Uri MMS_NOTIFICATION_SIM2_CACHE_URI = null;
        public static final String MMS_RINGTONE_URI = "mms_ringtone_uri";
        public static final String MMS_RINGTONE_URI_2 = "mms_ringtone_uri_2";
        public static final String MMS_SETTINGS_HIDE_SALARY = "pref_key_hide_salary";
        public static final String MMS_SETTINGS_TD_SMS = "pref_key_td_sms";
        public static final String MMS_SETTING_HIDE_VERIFICATION_CODE = "pref_key_hide_verification_code";
        public static final String MMS_SUB2_RINGTONE_SAMETO_SUB1 = "mms_sub2_ringtone_sameto_sub1";
        public static final String MOUSE_SCROLL_FLING_ENABLED = "mouse_scroll_fling_enabled";
        public static final String MUTE_TIMEOUT = "mute_timeout";

        @Deprecated
        public static final String PIN_PASSWORD_LENGTH_TYPE = "pin_password_length_type";
        public static final String PREF_KEY_MMS_AUTO_RETRIEVAL = "pref_key_mms_auto_retrieval";
        public static final String REALTIME_SCREEN_BRIGHTNESS = "realtime_screen_brightness";
        public static final String REAR_COVER_COLOR_FINAL = "rear_cover_color_final";
        public static final String REVONE_AUTO_BRIGHTNESS_BACKLIGHT = "revone_auto_brightness_backlight";
        public static final String REVONE_AUTO_BRIGHTNESS_LUX = "revone_auto_brightness_lux";

        @Deprecated
        public static final String REVONE_SCREEN_OFF_TIMEOUT = "revone_screen_off_timeout";
        public static final String REVONE_SCREEN_SAVER_TIMEOUT = "revone_screen_saver_timeout";
        public static final String RINGTONE2_CACHE = "ringtone2_cache";
        public static final Uri RINGTONE2_CACHE_URI = null;
        public static final String RINGTONE3_CACHE = "ringtone3_cache";
        public static final Uri RINGTONE3_CACHE_URI = null;
        public static final String RINGTONE_2 = "ringtone_2";
        public static final String RINGTONE_3 = "ringtone_3";
        public static final String SCREEN_BRIGHTNESS_TEMP = "screen_brightness_temp";
        public static final String SCREEN_LOCK_SLIDE_DELAY_TOGGLE = "screen_lock_slide_delay_toggle";
        public static final String SCREEN_LOCK_SLIDE_SCREENOFF_DELAY = "screen_lock_slide_screenoff_delay";
        public static final String SCREEN_LOCK_SLIDE_TIMEOUT_DELAY = "screen_lock_slide_timeout_delay";
        public static final String[] SETTINGS_TO_BACKUP = null;
        public static final String SIM_NAME_KEY_PREFIX = "perferred_name_sub";
        public static final String SMART_DENOISE_NORMAL_APPS = "smart_denoise_normal_apps";
        public static final String SMART_DENOISE_PHONE_CALL = "smart_denoise_phone_call";
        public static final String STATUS_BAR_AM_PM = "status_bar_am_pm";
        public static final String STATUS_BAR_BATTERY = "status_bar_battery";
        public static final String STATUS_BAR_CLOCK = "status_bar_clock";
        public static final String STATUS_BAR_NOTIF_COUNT = "status_bar_notif_count";
        public static final String STYLUS_ICON_ENABLED = "stylus_icon_enabled";
        public static final String SUB2_RINGTONE_SAMETO_SUB1 = "sub2_ringtone_sameto_sub1";
        public static final String SUNSHINE_SCREEN = "sunshine_screen";
        public static final String SWITCH_APP_SWITCH = "switch_app_switch";
        public static final String TEMPERATURE_UNIT = "temperature_unit";
        public static final int TEMPERATURE_UNIT_CELSIUS = 1;
        public static final int TEMPERATURE_UNIT_FAHRENHEIT = 2;
        public static final String TNT_WIDGET_BUTTONS = "tnt_expanded_widget_buttons";
        public static final String TORCH_STATE = "torch_state";
        public static final String TOUCH_POINTER_SPEED = "touch_pointer_speed";
        public static final String VISIBLE_WINDOW = "visible_window";
        public static final String VOLUME_ADJUST_SOUNDS_ENABLED = "volume_adjust_sounds_enabled";
        public static final String VOLUME_BUTTON_ENABLED = "volume_button_enabled";
        public static final String VOLUME_KEY_CURSOR_CONTROL = "volume_key_cursor_control";
        public static final String VOLUME_PANEL_IS_EXPANDED = "volume_panel_is_expanded";
        public static final String VOLUME_PANEL_MUTE_ENABLE = "volume_panel_mute_enable";
        public static final String WIDGET_BUTTONS = "expanded_widget_buttons";
        public static final String WIDGET_BUTTONS_ADDITIONAL = "expanded_widget_buttons_additional";
        public static final String WORD_LOOKUP_SWITCH = "word_lookup_switch";

        public System() {
        }

        static {
            DEFAULT_RINGTONE_URI_2 = SettingsSmtEx.System.DEFAULT_RINGTONE_URI_2;
            DEFAULT_RINGTONE_URI_3 = SettingsSmtEx.System.DEFAULT_RINGTONE_URI_3;
            MMS_NOTIFICATION_SIM1_CACHE_URI = SettingsSmtEx.System.MMS_NOTIFICATION_SIM1_CACHE_URI;
            MMS_NOTIFICATION_SIM2_CACHE_URI = SettingsSmtEx.System.MMS_NOTIFICATION_SIM2_CACHE_URI;
            MAIL_SEND_NOTIFICATION_CACHE_URI = SettingsSmtEx.System.MAIL_SEND_NOTIFICATION_CACHE_URI;
            MAIL_RECEIVE_NOTIFICATION_CACHE_URI = SettingsSmtEx.System.MAIL_RECEIVE_NOTIFICATION_CACHE_URI;
            CALENDER_NOTIFICATION_CACHE_URI = SettingsSmtEx.System.CALENDER_NOTIFICATION_CACHE_URI;
            IDEA_PILLS_RINGTONE_CACHE_URI = SettingsSmtEx.System.IDEA_PILLS_RINGTONE_CACHE_URI;
            RINGTONE2_CACHE_URI = SettingsSmtEx.System.RINGTONE2_CACHE_URI;
            RINGTONE3_CACHE_URI = SettingsSmtEx.System.RINGTONE3_CACHE_URI;
            SETTINGS_TO_BACKUP = SettingsSmtEx.System.SETTINGS_TO_BACKUP;
        }
    }

    public static final class TEXT_BOOM_SEARCH_VALUE {
        public static final int TYPE_360SO = 4;
        public static final int TYPE_BAIDU = 0;
        public static final int TYPE_BAIKE = 17;
        public static final int TYPE_BING = 2;
        public static final int TYPE_BINGDICT = 258;
        public static final int TYPE_GOOGLE = 1;
        public static final int TYPE_GOOGLE_TRANSLATE = 260;
        public static final int TYPE_HIDICT = 259;
        public static final int TYPE_KINGSOFT = 257;
        public static final int TYPE_SEARCH_WEIBO = 513;
        public static final int TYPE_SEARCH_WEIXIN = 512;
        public static final int TYPE_SEARCH_ZHIHU = 514;

        @Deprecated
        public static final int TYPE_SHENMA = 3;
        public static final int TYPE_SOGOU = 3;
        public static final int TYPE_WIKI = 16;
        public static final int TYPE_WIKI_CN = 19;
        public static final int TYPE_WIKI_EN = 18;
        public static final int TYPE_YOUDAO = 256;

        public TEXT_BOOM_SEARCH_VALUE() {
        }
    }

    public interface TabletTitleBarLocationValue {
        public static final int STYLE_BOTTOM = 1;
        public static final int STYLE_TOP = 0;
    }

    public interface TabletTitleBarModeValue {
        public static final int MODE_AUTO = 0;
        public static final int MODE_MANUAL = 1;
    }

    public interface TabletWidgetShowValue {
        public static final int STATUS_HIDE = 0;
        public static final int STATUS_SHOW = 1;
    }

    public static final class VOICE_SHOW_RESULT_CHANGED_BY {
        public static final int AUTO = 0;
        public static final int MANUAL = 1;

        public VOICE_SHOW_RESULT_CHANGED_BY() {
        }
    }

    public static final class VOICE_SHOW_RESULT_VALUE {
        public static final int BULLET = 1;
        public static final int DEFAULT_AUTO = -1;
        public static final int SEARCH = 0;

        public VOICE_SHOW_RESULT_VALUE() {
        }
    }

    public interface VoiceWaterDropValue {
        public static final int DROP_HIDE = 0;
        public static final int DROP_SHOW = 1;
    }

    public static int get_CALENDAR_FIRST_DAY_OF_WEEK_DEFAULT() {
        return 2;
    }

    public static String get_CALENDAR_KEY_FIRST_DAY_OF_WEEK() {
        return "calendar_key_first_day_of_week";
    }

    public static String get_CALENDAR_RINGTONE_URI() {
        return "calendar_ringtone_uri";
    }

    public static String get_CONTACTS_DIALPAD_CHANGE_LAYOUT() {
        return "contacts_dialpad_change_layout";
    }

    public static String get_CUSTOM_THUMB_PULLDOWN_WALLPAPER_URI() {
        return "custom_thumb_pulldown_wallpaper_uri";
    }

    public static String get_DATA_USAGE_WARNING() {
        return "data_usage_warning";
    }

    public static String get_DEFAULT_LOCKSCREEN_URI() {
        return "default_lockscreen_uri";
    }

    public static final String get_DEVICE_OWNER() {
        return "device_owner";
    }

    public static String get_DISABLE_NOTIFICATION() {
        return "disable_notification";
    }

    public static String get_EMAIL_RECEIVE_RINGTONE_URI() {
        return "email_receive_ringtone_uri";
    }

    public static String get_EMAIL_SEND_RINGTONE_URI() {
        return "email_send_ringtone_uri";
    }

    public static String get_FACE_RECOGNITION_ENABLED() {
        return "face_recognition_enabled";
    }

    public static String get_GLOBAL_VIBRATION_ENABLED() {
        return "global_vibration_enabled";
    }

    public static String get_HIFI_ENABLE() {
        return "hifi_enable";
    }

    public static final String get_JOIN_UE_ON() {
        return "join_ue_on";
    }

    public static String get_LAUNCHER_BADGE_SWIPE_CLEAN() {
        return "launcher_badge_swipe_clean";
    }

    public static String get_LAUNCHER_GRIDS_COUNT_X() {
        return "launcher_grids_x";
    }

    public static String get_LAUNCHER_GRIDS_COUNT_Y() {
        return "launcher_grids_y";
    }

    public static String get_LAUNCHER_HIDE_BADGE() {
        return "launcher_hide_badge";
    }

    public static String get_LAUNCHER_HIDE_LABLE() {
        return "launcher_hide_lable";
    }

    public static String get_LAUNCHER_MODE() {
        return "launcher_mode";
    }

    public static int get_LAUNCHER_MODE_VALUE_LAUNCHER_MODE_GRIDS_16() {
        return 16;
    }

    public static int get_LAUNCHER_MODE_VALUE_LAUNCHER_MODE_GRIDS_9() {
        return 9;
    }

    public static int get_LAUNCHER_MODE_VALUE_LAUNCHER_MODE_ORIGINAL() {
        return 0;
    }

    public static String get_LAUNCHER_MULTI_BLOCK_MODE() {
        return "multi_block_mode";
    }

    public static int get_LAUNCHER_MULTI_BLOCK_MODE_VALUE_LAUNCHER_MULTI_BLOCK_MODE_GRIDS_36() {
        return 36;
    }

    public static String get_LAUNCHER_THEME() {
        return "launcher_theme";
    }

    public static String get_LOCKSCREEN_BACKGROUND() {
        return "lockscreen_background";
    }

    public static String get_MMS_RINGTONE_URI() {
        return "mms_ringtone_uri";
    }

    public static String get_MUSIC_VOICE_SEARCH_BTN_ENABLED() {
        return "music_voice_search_btn_enabled";
    }

    public static String get_ONE_HAND_MODE() {
        return "one_hand_mode";
    }

    public static String get_ORIGINAL_LAUNCHER_WALLPAPER_BLUR_ON() {
        return "original_launcher_wallpaper_blur_on";
    }

    public static final String get_PHONE_LOCKED_BY_CLOUDSERVICE() {
        return "phone_locked_by_cloud";
    }

    public static String get_POPCORN_SOUND() {
        return "popcorn_sound";
    }

    public static String get_SCRATCHING_RECORDS() {
        return "scratching_records";
    }

    public static String get_SCREENSHOT_NOTIFICATION() {
        return "screenshot_notification_enabled";
    }

    public static String get_STATUS_BAR_BATTERY() {
        return "status_bar_battery";
    }

    public static String get_TEMPERATURE_UNIT() {
        return "temperature_unit";
    }

    public static int get_TEMPERATURE_UNIT_CELSIUS() {
        return 1;
    }

    public static int get_TEMPERATURE_UNIT_FAHRENHEIT() {
        return 2;
    }

    public static String get_THUMB_PUSH_DOWN() {
        return "thumb_push_down";
    }

    public static String get_THUMB_TRIGGER_AREA() {
        return "thumb_trigger_area";
    }

    public static int get_THUMB_TRIGGER_AREA_MIDDLE() {
        return 2;
    }

    public static String get_TIMER_RING_PULL() {
        return "timer_ring_pull";
    }

    public static String get_TORCH_STATE() {
        return "torch_state";
    }

    public static String get_VOICE_DIAL() {
        return "voice_dial";
    }

    public static String get_VOLUME_LIMIT() {
        return "volume_limit";
    }

    public static String get_VOLUME_PANEL_MUTE_ENABLE() {
        return "volume_panel_mute_enable";
    }

    public static String get_WIFI_DISPLAY_RECEIVE_SMS_SETTING() {
        return "wifi_display_while_receive_sms";
    }

    public static String get_WORLD_CLOCK_SECOND_HAND_CONSISTENT() {
        return "world_clock_second_hand_consistent";
    }

    /* synthetic */ SettingsSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sSettingsSmt = new AnonymousClass1();
    }

    public static SettingsSmt getInstance() {
        return (SettingsSmt) sSettingsSmt.get();
    }

    private SettingsSmt() {
    }
}
