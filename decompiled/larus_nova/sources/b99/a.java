package b99;

import com.bytedance.android.livesdkapi.depend.constant.SchemaConstants;
import com.larus.platform.api.n2;
import com.larus.settings.value.e10;
import com.larus.settings.value.pz;
import com.larus.utils.l0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import qu9.c;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18345a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f18346b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f18347c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f18348d = null;

    public a() {
    }

    static {
        f18345a = new a();
        List<String> r100 = CollectionsKt.listOf(new String[]{"//flow/drive_search", "//flow/table_block_detail", "//flow/single_tts_speaker_setting", "//flow/plugin_detail", "//flow/plugin_list", "//flow/chat_page", "//flow/create_new_conversation", "//flow/chat", "//chat_page", "//flow/chat_page_bridge", "//flow/chat_debug", "//flow/ltm_settings", "//flow/chat_loading", "//flow/chat_search", "//flow/code_block_detail", "//flow/combine_search", "//flow/chat_setting", "//flow/app_setting", "//flow/model_settings", "//flow/creation_output_settings", "//flow/remove_ai_watermark", "//flow/camera/scan", "//flow/deep_research", "//flow/deep_research_process", "//flow/deep_search", "//flow/file_preview", "//flow/miaoda_artifact_preview", "//flow/search_setting", "//flow/setting_account_info", "//flow/setting_account_info_activity", "//flow/setting_primacy_permission", "//flow/change_app_icon", "//flow/about_app", "//flow/music_account", "//flow/font_and_theme_setting", "//flow/setting_block_list_activity", "//flow/multi_account_activity", "//flow/multi_account_switch", "//flow/multi_account_panel", "//flow/profile_edit", "//main_page", "//conversation_list", "//flow/home", "//main_tab_page", "//flow/phone_number_page", "//flow/drive_list", "//flow/drive_list", "//flow/drive_preview", "//flow/drive_permission_settings", "//flow/phone_login", "//flow/account_country_picker", "//flow/verification_code", "//flow/auth_verify", "//flow/half_account_login", "//flow/account_request_loading_page", "//flow/phone_one_key_login", "//flow/phone_login_account_discovery", "//flow/bot_edit_avatar_preview", "//flow/bot_language_setting", "//flow/bot_update", "//flow/edit_instruction", "//flow/instruction_half_independent_page", "//flow/instruction_independent_page", "//flow/image_edit/remove", "//flow/slides_detail", "//flow/slides_permission_settings", "//flow/slides_generate_image", "//flow/file_list_dispatch", "//flow/doc_detail", "//flow/doc/apply_permission", "//flow/doc/biz_page", "//flow/sheet_detail", "//flow/sheet_permission_settings", "//flow/profile_mine", "//flow/webview", SchemaConstants.SCHEMA_WEBVIEW, "//webview_native_nav", "//flow/applet_dispatch", "//flow/debug_activity", "//flow/skill_management", "//flow/scheduled_job_management", "//flow/scheduled_job_editor", "//flow/aggregate_search", "//flow/debug_image_loader", "//flow/debug_tt_protector", "//flow/float_window_debug", "//flow/bootprotector_debug", "//lynx_page", "//lynxview", "//lynxview_popup", "//flow/lynx_preview", "//flow/applet", "//applet", "//flow/audio_debug", "//flow/memory_debug", "//flow/lynx_preview", "//debug/stream", "//debug/markdown_input", "//debug/markdown_preview", "//flow/router_debug", "//flow/camera_debug", "//flow/ota_update", "//flow/input_debug", "//flow/social_conversation", "//flow/lark_address_book", "//flow/social_feed", "//doubao_apps"});
        f18346b = r100;
        List<String> r101 = CollectionsKt.listOf(new String[]{"//flow/skill_trial", "//flow/realtime_chat", "//dora_sound_settings", "//dora_device_name_settings", "//dora_proactive_settings", "//dora_notification_freq", "//dora_options_activity", "//dora_keep_alive", "//dora_general_settings", "//dora_gesture_settings", "//flow/dora/gesture_settings", "//flow/dora/simul_interpretat_detail", "//dora_gesture_wakeup", "//dora_onboarding_v2", "//dora_onboarding", "//dora_dynamic_list", "//flow/dora/device_list", "//flow/dora/smart_device", "//flow/dora/bind_device", "//dora_gesture_settings", "//flow/dora/gesture_settings", "//flow/dora/general_settings", "//dora_ota", "//flow/device_management", "//dora_ai_lab", "//flow/audio_tool_debug", "//main"});
        f18347c = r101;
        List<String> r102 = CollectionsKt.toMutableList(r100);
        r102.addAll(r101);
        f18348d = r102;
        e10 r103 = e10.f368561a;
        int r104 = l0.f375430a;
        List<String> r105 = ((c) l0.a(new c(null), new pz())).a();
        if (r105 == null) goto L6;
        List r106 = CollectionsKt.filterNotNull(r105);
        if (r106 == null) goto L6;
    L7:
        r102.addAll(r106);
        return;
    L6:
        r106 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.larus.platform.api.n2
    public final List<String> a() {
        return f18348d;
    }
}
