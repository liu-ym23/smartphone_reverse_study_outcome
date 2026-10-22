package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.sdk.open.aweme.CommonConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f71510a = null;

    static {
        HashMap r100 = new HashMap();
        f71510a = r100;
        r100.put("rtc_turn_on", 10001);
        r100.put("rtc_turn_on_success", 10002);
        r100.put("rtc_turn_on_failed", 10003);
        r100.put("rtc_turn_off", 10004);
        r100.put("rtc_turn_off_success", 10005);
        r100.put("rtc_turn_off_failed", 10006);
        r100.put("rtc_first_frame", 10007);
        r100.put("rtc_user_leave", 10008);
        r100.put("rtc_user_join", 10009);
        r100.put("rtc_on_error", 10010);
        r100.put("rtc_mix_stream", 10011);
        r100.put("rtc_mix_sei", 10012);
        r100.put("rtc_mute_other", 10013);
        r100.put("rtc_switch_audio", 10014);
        r100.put("rtc_first_audio_frame", 10015);
        r100.put("rtc_mute_allremote", 10016);
        r100.put("rtc_mute_audio", 10017);
        r100.put("rtc_unmute_audio", 10018);
        r100.put("sei_too_long", 10019);
        r100.put("rtc_start_time_out", 10020);
        r100.put("rtc_stop_time_out", 10021);
        r100.put("join_channel_success", 20001);
        r100.put("join_channel_failed", 20002);
        r100.put("leave_channel_success", 20003);
        r100.put("leave_channel_failed", 20004);
        r100.put("finish_link_mic_success", 20005);
        r100.put("finish_link_mic_failed", 20006);
        r100.put("start_link_mic_success", 20007);
        r100.put("start_link_mic_failed", 20008);
        r100.put("guest_reply_success", 20007);
        r100.put("guest_reply_failed", 20008);
        r100.put("guest_apply_success", 20009);
        r100.put("guest_apply_failed", 20010);
        r100.put("guest_receive_kickout_msg", 2011);
        r100.put("guest_receive_permit_msg", 20012);
        r100.put("guest_receive_invite_msg", Integer.valueOf(CommonConstants.ShareErrorCode.CANCEL_PUBLISH));
        r100.put("kickout_audience_success", 20014);
        r100.put("kickout_audience_failed", Integer.valueOf(CommonConstants.ShareErrorCode.SAVE_TO_DRAFT));
        r100.put("silence_audience_success", Integer.valueOf(CommonConstants.ShareErrorCode.PUBLISH_FAIL_UNKNOWN));
        r100.put("silence_audience_failed", 20017);
        r100.put("unsilence_audience_success", 20018);
        r100.put("unsilence_audience_failed", 20019);
        r100.put("permit_audience_success", 20020);
        r100.put("permit_audience_failed", 20021);
        r100.put("invite_audience_success", 20022);
        r100.put("invite_audience_failed", 20023);
        r100.put("anchor_receive_auto_join_msg", 20024);
        r100.put("anchor_receive_reply_msg", 20025);
        r100.put("anchor_receive_admin_agree_msg", 20026);
        r100.put("anchor_continue_room_linkmic", 20027);
        r100.put("pk_first_frame_log_time_error", 20028);
        r100.put("self_mute_state_error", 20029);
        r100.put("self_not_on_seat", 20030);
        r100.put("kickout_when_rtc_user_lost", 20031);
        r100.put("on_pause_mute_error", 20032);
        r100.put("self_silence_but_unmute", 20033);
        r100.put("reset_mute_when_list_silence", 20034);
        r100.put("reset_mute_when_list_silence_failed", 20035);
        r100.put("rtc_switch_audio_mute", 20036);
        r100.put("rtc_switch_audio_unmute", 20037);
        r100.put("rtc_mute_allremote_audio", 20038);
        r100.put("rtc_unmute_allremote_audio", 20039);
        r100.put("audience_link_settings_error", 20040);
        r100.put("live_core_single_view", 20041);
        r100.put("video_state_conflict", 20042);
    }

    public static int a(String r100, int r101, boolean r102) {
        Map<String, Integer> r103 = f71510a;
        if (((HashMap) r103).containsKey(r100) == false) goto L10;
        int r104 = ((Integer) ((HashMap) r103).get(r100)).intValue() + (r101 * 100000);
        if (r102 == false) goto L7;
        int r105 = 1000000;
    L9:
        return r104 + r105;
    L7:
        r105 = 2000000;
        goto L9
    L10:
        return 0;
    }
}
