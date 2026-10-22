package com.bytedance.android.live.core.setting;

import android.util.SparseArray;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.config.x01;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public interface b6 {
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> A = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> B = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> C = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> D = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> E = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.q2> F = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> G = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> H = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65221J = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> K = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> L = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> M = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> N = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<String> O = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.interact.o1> P = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> Q = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> R = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> S = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> T = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<HashMap<Integer, Integer>> U = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> V = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> W = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> X = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> Y = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65222a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f65223a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, Pair<Long, Integer>>> f65224b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Set<Integer>> f65225b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65226c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65227c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65228d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<String> f65229d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65230e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65231e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65232f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f65233f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65234g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65235g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65236h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65237h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65238i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65239i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65240j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65241j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65242k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65243k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f65244l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65245l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f65246m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<SparseArray<Boolean>> f65247m0 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<Integer, Long>> f65248n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65249n0 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f65250o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, Double>> f65251o0 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65252p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<IAudioSubtitleContent> f65253p0 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65254q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<List<Integer>> f65255q0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<ILinkmicAudienceSetting.LinkmicSettingStatus> f65256r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65257r0 = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65258s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<String> f65259t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f65260u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> f65261v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65262w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f65263x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Pair<String, String>> f65264y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f65265z = null;

    static {
        Boolean r100 = Boolean.FALSE;
        new com.bytedance.android.livesdk.sharedpref.e("live_real_time_chorus_education_page_has_shown", r100);
        new com.bytedance.android.livesdk.sharedpref.e();
        new com.bytedance.android.livesdk.sharedpref.e("ktv_origin_mode_keep", 0);
        new com.bytedance.android.livesdk.sharedpref.e("solo_ktv_enter_flag", "1");
        Boolean r101 = Boolean.TRUE;
        f65222a = new com.bytedance.android.livesdk.sharedpref.e("live_lottery_retain_dialog_is_need_show", r101);
        f65224b = new com.bytedance.android.livesdk.sharedpref.e("toolbar_bubble_show_times", new HashMap());
        f65226c = new com.bytedance.android.livesdk.sharedpref.e("interact_audience_opened_camera", 0);
        f65228d = new com.bytedance.android.livesdk.sharedpref.e("video_talk_room_pre_linkmic", r101);
        f65230e = new com.bytedance.android.livesdk.sharedpref.e("audio_linkmic_setting_panel_yellow_dot", r101);
        f65232f = new com.bytedance.android.livesdk.sharedpref.e("audio_linkmic_setting_panel_paid_item_yellow_dot", r101);
        f65234g = new com.bytedance.android.livesdk.sharedpref.e("live_big_party_audience_default_open_camera", r100);
        f65236h = new com.bytedance.android.livesdk.sharedpref.e("link_mic_support_camera", r101);
        f65238i = new com.bytedance.android.livesdk.sharedpref.e("link_mic_support_admin_operate", r101);
        f65240j = new com.bytedance.android.livesdk.sharedpref.e("live_part_scene_float_window_open_state_new", 0);
        f65242k = new com.bytedance.android.livesdk.sharedpref.e("video_talk_anchor_enable_integration_link", r100);
        f65244l = new com.bytedance.android.livesdk.sharedpref.e("live_fetch_skin_recent_time", 0L);
        f65246m = new com.bytedance.android.livesdk.sharedpref.e("live_more_entrance_marquee_click_recent_time", 0L);
        f65248n = new com.bytedance.android.livesdk.sharedpref.e("live_more_entrance_marquee_related_type_show_time", new HashMap());
        f65250o = new com.bytedance.android.livesdk.sharedpref.e("live_more_entrance_marquee_next_show_time", 0L);
        f65252p = new com.bytedance.android.livesdk.sharedpref.e("video_talk_opened_camera", 0);
        f65254q = new com.bytedance.android.livesdk.sharedpref.e("enable_chatroom_distribute_to_friend", r101);
        f65256r = new com.bytedance.android.livesdk.sharedpref.e("chatroom_distribute_range", ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF);
        new com.bytedance.android.livesdk.sharedpref.e("live_ktv_digit_avatar_follow_face", r100);
        f65258s = new com.bytedance.android.livesdk.sharedpref.e("live_ktv_digit_avatar_no_yet_set", r101);
        new com.bytedance.android.livesdk.sharedpref.e("chat_channel_link_has_show_link_tips", r100);
        new com.bytedance.android.livesdk.sharedpref.e("chat_channel_live_mix_volume_value", -1);
        new com.bytedance.android.livesdk.sharedpref.e("chat_channel_link_rtc_volume_value_map", new HashMap());
        new com.bytedance.android.livesdk.sharedpref.e("chat_channel_link_rtc_volume_switch_map", new HashMap());
        f65259t = new com.bytedance.android.livesdk.sharedpref.e("live_interact_pk_theme", "");
        f65260u = new com.bytedance.android.livesdk.sharedpref.e("live_has_click_apply_icon", 0L);
        new com.bytedance.android.livesdk.sharedpref.e("live_interact_layout_config", "");
        new com.bytedance.android.livesdk.sharedpref.e("live_voice_room_ktv_sing_mode", 2);
        f65261v = new com.bytedance.android.livesdk.sharedpref.e("live_voice_room_ktv_digit_avatar", new HashMap());
        f65262w = new com.bytedance.android.livesdk.sharedpref.e("live_ktv_digit_avatar_user_agreement_agreed", r100);
        f65263x = new com.bytedance.android.livesdk.sharedpref.e("linkmic_subtitle_guest_setting", r101);
        f65264y = new com.bytedance.android.livesdk.sharedpref.e("linkmic_broadcast_game_config", new Pair("", ""));
        f65265z = new com.bytedance.android.livesdk.sharedpref.e("live_part_scene_float_window_retain_dialog_close_count", 0);
        A = new com.bytedance.android.livesdk.sharedpref.e("live_part_scene_float_window_retain_dialog_show_time", 0L);
        B = new com.bytedance.android.livesdk.sharedpref.e("waiting_list_sort_strategy", 40);
        C = new com.bytedance.android.livesdk.sharedpref.e("interact_audience_tips_show", r100);
        D = new com.bytedance.android.livesdk.sharedpref.e("interact_audience_first_apply", 0);
        E = new com.bytedance.android.livesdk.sharedpref.e("link_beauty_tip", r101);
        F = new com.bytedance.android.livesdk.sharedpref.e("interactive_song_turn_on_config", new com.bytedance.android.livesdk.chatroom.model.q2());
        G = new com.bytedance.android.livesdk.sharedpref.e("interactive_song_setting_state", 0);
        new com.bytedance.android.livesdk.sharedpref.e("interactive_song_setting_state_info", 0);
        H = new com.bytedance.android.livesdk.sharedpref.e("live_interact_helper_enable", r100);
        I = new com.bytedance.android.livesdk.sharedpref.e("live_interact_beauty_preview_has_shown", r100);
        f65221J = new com.bytedance.android.livesdk.sharedpref.e("live_shown_adventure_lead_panel", r100);
        K = new com.bytedance.android.livesdk.sharedpref.e("link_mic_guest_battle_anchor_enable", r101);
        L = new com.bytedance.android.livesdk.sharedpref.e("guest_battle_score_type", -1);
        M = new com.bytedance.android.livesdk.sharedpref.e("guest_battle_select_duration", 900);
        N = new com.bytedance.android.livesdk.sharedpref.e("guest_battle_admin_privilige_tips", r101);
        new com.bytedance.android.livesdk.sharedpref.e("team_fight_admin_privilige_tips", r101);
        O = new com.bytedance.android.livesdk.sharedpref.e("link_room_fight_setting_intro_content", "");
        P = new com.bytedance.android.livesdk.sharedpref.e("self_discipline_config", (com.bytedance.android.livesdk.chatroom.model.interact.o1) vh7.f.c(com.bytedance.android.livesdk.chatroom.model.interact.o1.class));
        Q = new com.bytedance.android.livesdk.sharedpref.e("self_discipline_setting_state", 0);
        R = new com.bytedance.android.livesdk.sharedpref.e("themed_competition_tips_show", r101);
        S = new com.bytedance.android.livesdk.sharedpref.e("interact_acting_tips_show", r101);
        T = new com.bytedance.android.livesdk.sharedpref.e("interact_acting_first_open", r101);
        int r102 = x01.f121570a;
        HashMap r103 = new HashMap();
        r103.put(1, 1);
        r103.put(2, 2);
        U = new com.bytedance.android.livesdk.sharedpref.e("live_interact_remenber_link_type", r103);
        V = new com.bytedance.android.livesdk.sharedpref.e("enable_shake_fast_match", r101);
        W = new com.bytedance.android.livesdk.sharedpref.e("live_room_forbid_fast_match", r100);
        X = new com.bytedance.android.livesdk.sharedpref.e("live_clear_screen_optimize", r100);
        Y = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_resolution_key", new HashMap());
        Z = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_resolution_save_time", 0L);
        f65223a0 = new com.bytedance.android.livesdk.sharedpref.e("video_friend_open_pair_time", 0L);
        new com.bytedance.android.livesdk.sharedpref.e("landscape_block_enable", r100);
        f65225b0 = new com.bytedance.android.livesdk.sharedpref.e("live_interact_playmode_red_dot", new HashSet());
        f65227c0 = new com.bytedance.android.livesdk.sharedpref.e("talk_room_opened_paid_linkmic", r100);
        f65229d0 = new com.bytedance.android.livesdk.sharedpref.e("live_start_source", "");
        f65231e0 = new com.bytedance.android.livesdk.sharedpref.e("live_link_mic_float_window_open", r100);
        f65233f0 = new com.bytedance.android.livesdk.sharedpref.e("live_link_mic_flaot_window_enter_room_id", 0L);
        f65235g0 = new com.bytedance.android.livesdk.sharedpref.e("live_link_mic_flaot_window_enter_room_count", 0);
        f65237h0 = new com.bytedance.android.livesdk.sharedpref.e("live_link_mic_float_window_enter_room_toast_show", r100);
        f65239i0 = new com.bytedance.android.livesdk.sharedpref.e("guest_battle_loser_num", 1);
        f65241j0 = new com.bytedance.android.livesdk.sharedpref.e("guest_battle_ui_type", -1);
        new com.bytedance.android.livesdk.sharedpref.e("room_fight_admin_privilige_tips", r101);
        new com.bytedance.android.livesdk.sharedpref.e("link_room_fight_rivals_search_history_uid_map", new HashMap());
        f65243k0 = new com.bytedance.android.livesdk.sharedpref.e("live_room_first_fast_match", r101);
        f65245l0 = new com.bytedance.android.livesdk.sharedpref.e("live_multi_scene_gameplay_toolbar_red_dot", r100);
        f65247m0 = new com.bytedance.android.livesdk.sharedpref.e("live_multi_scene_gameplay_toolbar_red_dot_map", new SparseArray());
        f65249n0 = new com.bytedance.android.livesdk.sharedpref.e("first_time_shake_fast_match", r101);
        f65251o0 = new com.bytedance.android.livesdk.sharedpref.e("live_theme_reddot_show_times", new HashMap());
        f65253p0 = new com.bytedance.android.livesdk.sharedpref.e("linkmic_subtitle_anchor_setting_new", (IAudioSubtitleContent) vh7.f.c(IAudioSubtitleContent.class));
        new com.bytedance.android.livesdk.sharedpref.e("live_broadcast_from_group_live", r100);
        f65255q0 = new com.bytedance.android.livesdk.sharedpref.e("linkmic_subtitle_anchor_drag_subtitle", new ArrayList());
        f65257r0 = new com.bytedance.android.livesdk.sharedpref.e("annie_contaniner_permission_disable", r100);
    }
}
