package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.AudioChatRoomVideoBgSei;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class ir0 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ir0 f120475a = null;

    static {
        f120475a = new ir0();
    }

    public ir0() {
        super("live_sei_source_list", "直播SEI source列表", CollectionsKt.mutableListOf(new String[]{"TTLiveSDK_Android", "TTLiveSDK_IOS", "TTLiveSDK_Harmony", "TTLiveSDK_Windows", "app_data", "ktv_sei", "ktv_midi_sei", "ktv_hot_sei", "ktv_score_sei", "interact_video_sei", "ktv_midi_feedback_sei", "ktv_order_song_sei", "audio_mv_sei", "hamlet_avatar_sei", "music_beat_result", "ktv_chorus_midi", "radio_sei", AudioChatRoomVideoBgSei.SEI_KEY}), CollectionsKt.mutableListOf(new String[]{"TTLiveSDK_Android", "TTLiveSDK_IOS", "TTLiveSDK_Windows", "app_data", "ktv_sei", "ktv_midi_sei", "ktv_hot_sei", "ktv_score_sei", "interact_video_sei", "ktv_midi_feedback_sei", "ktv_order_song_sei", "interact_full_video_sei", "audio_mv_sei", "hamlet_avatar_sei", "music_beat_result", "ktv_chorus_midi", "radio_sei", AudioChatRoomVideoBgSei.SEI_KEY}));
    }
}
