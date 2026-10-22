package com.bytedance.android.livesdkapi.broadcastgame;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/broadcastgame/GameSeiConstants;", "", "()V", "KEY_GAME_IN_CAST", "", "KEY_GAME_POD_MERGE_STREAM_SEI", "KEY_GAME_POD_MERGE_STREAM_TS", "KEY_GAME_POD_MERGE_STREAM_TT_NTP", "KEY_GAME_RATIO", "KEY_GAME_RENDER_MODE", "KEY_GAME_WTN_PUSH_STREAM", "KEY_SOURCE", "KEY_TIMOR_IN_CAST", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameSeiConstants {
    public static final GameSeiConstants INSTANCE = null;
    public static final String KEY_GAME_IN_CAST = "key_game_in_cast";
    public static final String KEY_GAME_POD_MERGE_STREAM_SEI = "key_game_pod_merge_stream_sei";
    public static final String KEY_GAME_POD_MERGE_STREAM_TS = "ts";
    public static final String KEY_GAME_POD_MERGE_STREAM_TT_NTP = "tt_ntp";
    public static final String KEY_GAME_RATIO = "game_ratio";
    public static final String KEY_GAME_RENDER_MODE = "render_mode";
    public static final String KEY_GAME_WTN_PUSH_STREAM = "wtn_push_stream";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_TIMOR_IN_CAST = "key_timor_in_cast";

    private GameSeiConstants() {
    }

    static {
        INSTANCE = new GameSeiConstants();
    }
}
