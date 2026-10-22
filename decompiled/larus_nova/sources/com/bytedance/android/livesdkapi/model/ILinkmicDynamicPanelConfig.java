package com.bytedance.android.livesdkapi.model;

import com.bytedance.revenue.platform.api.core.c;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(ILinkmicDynamicPanelConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00118VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\nR\u001a\u0010\u001e\u001a\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\nR.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00118VX\u0097\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicPanelConfig;", "Lvh7/j;", "", "getEmojiPanelOpen", "()Z", "getEmojiPanelOpen$annotations", "()V", "emojiPanelOpen", "", "getEmojiPanelUrl", "()Ljava/lang/String;", "getEmojiPanelUrl$annotations", "emojiPanelUrl", "getEmojiPanelSchema", "getEmojiPanelSchema$annotations", "emojiPanelSchema", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getEmojiPanelSettings", "()Ljava/util/List;", "getEmojiPanelSettings$annotations", "emojiPanelSettings", "getSettingPanelOpen", "getSettingPanelOpen$annotations", "settingPanelOpen", "getSettingPanelUrl", "getSettingPanelUrl$annotations", "settingPanelUrl", "getSettingPanelSchema", "getSettingPanelSchema$annotations", "settingPanelSchema", "getSettingPanelSettings", "getSettingPanelSettings$annotations", "settingPanelSettings", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicDynamicPanelConfig extends j<ILinkmicDynamicPanelConfig> {

    @JsonAdapter(ILinkmicDynamicPanelConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "emoji_panel_open")
        public static boolean getEmojiPanelOpen(ILinkmicDynamicPanelConfig r100) {
            return false;
        }

        @FieldName(name = "emoji_panel_open")
        public static /* synthetic */ void getEmojiPanelOpen$annotations() {
        }

        @FieldName(name = "emoji_panel_schema")
        public static String getEmojiPanelSchema(ILinkmicDynamicPanelConfig r100) {
            return "sslocal://webcast_lynxview?hybrid_type=lynx&type=popup&mask_alpha=0&landscape_custom_gravity=1&hide_nav_bar=1&gravity=bottom&enable_latch=1&rate_hegight=700&width_percent=100&height_percent=100&add_safe_area_height=0";
        }

        @FieldName(name = "emoji_panel_schema")
        public static /* synthetic */ void getEmojiPanelSchema$annotations() {
        }

        @FieldName(name = "emoji_panel_settings")
        public static /* synthetic */ void getEmojiPanelSettings$annotations() {
        }

        @FieldName(name = "emoji_panel_url")
        public static String getEmojiPanelUrl(ILinkmicDynamicPanelConfig r100) {
            return "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/linkmic_interaction_panel_douyin/pages/interaction_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%5D";
        }

        @FieldName(name = "emoji_panel_url")
        public static /* synthetic */ void getEmojiPanelUrl$annotations() {
        }

        @FieldName(name = "setting_panel_open")
        public static boolean getSettingPanelOpen(ILinkmicDynamicPanelConfig r100) {
            return false;
        }

        @FieldName(name = "setting_panel_open")
        public static /* synthetic */ void getSettingPanelOpen$annotations() {
        }

        @FieldName(name = "setting_panel_schema")
        public static String getSettingPanelSchema(ILinkmicDynamicPanelConfig r100) {
            return "sslocal://webcast_lynxview?hybrid_type=lynx&type=popup&mask_alpha=0&landscape_custom_gravity=1&hide_nav_bar=1&gravity=bottom&enable_latch=1&rate_hegight=700&width_percent=100&height_percent=100&add_safe_area_height=0";
        }

        @FieldName(name = "setting_panel_schema")
        public static /* synthetic */ void getSettingPanelSchema$annotations() {
        }

        @FieldName(name = "setting_panel_settings")
        public static /* synthetic */ void getSettingPanelSettings$annotations() {
        }

        @FieldName(name = "setting_panel_url")
        public static String getSettingPanelUrl(ILinkmicDynamicPanelConfig r100) {
            return "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/linkmic_interaction_panel_douyin/pages/setting_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%5D";
        }

        @FieldName(name = "setting_panel_url")
        public static /* synthetic */ void getSettingPanelUrl$annotations() {
        }

        @FieldName(name = "emoji_panel_settings")
        public static List<String> getEmojiPanelSettings(ILinkmicDynamicPanelConfig r110) {
            return c.a(new String[]{"live_enable_guest_honor_entry", "live_order_song_2d_virtual_avatar_opt_full_switch", "ktv_enable_open_camera", "ktv_audience_enable_open_camera", "live_ktv_room_video_performance_limit", "live_device_model_record_score", "live_device_model_overall_score", "live_video_talk_avatar_enabled_anchor", "live_video_avatar_performance_limit_anchor", "live_video_avatar_performance_limit_guest", "video_camera_effect_score", "live_linkmic_paid_config", "live_enable_anchor_mute_self", "live_ktv_chorus_guest_linkmic_enable", "live_interact_xplay_clean_screen_config"});
        }

        @FieldName(name = "setting_panel_settings")
        public static List<String> getSettingPanelSettings(ILinkmicDynamicPanelConfig r110) {
            return c.a(new String[]{"video_equal_1v8fix_switch", "live_playmode_entrance_optimize_enable", "live_anchor_new_manager_page_scheme", "send_gift_to_linker_setting", "live_cross_link_base_feat", "live_linkmic_announce", "live_chatroom_lynx_config", "live_guest_link_setting_config", "live_is_hit_paid_queue_enable", "ktv_enable_open_camera", "live_device_model_record_score", "live_device_model_overall_score", "live_ktv_room_video_performance_limit", "ktv_audience_enable_open_camera", "live_multi_link_video_startmode_setting"});
        }
    }

    @FieldName(name = "emoji_panel_open")
    boolean getEmojiPanelOpen();

    @FieldName(name = "emoji_panel_schema")
    String getEmojiPanelSchema();

    @FieldName(name = "emoji_panel_settings")
    List<String> getEmojiPanelSettings();

    @FieldName(name = "emoji_panel_url")
    String getEmojiPanelUrl();

    @FieldName(name = "setting_panel_open")
    boolean getSettingPanelOpen();

    @FieldName(name = "setting_panel_schema")
    String getSettingPanelSchema();

    @FieldName(name = "setting_panel_settings")
    List<String> getSettingPanelSettings();

    @FieldName(name = "setting_panel_url")
    String getSettingPanelUrl();
}
