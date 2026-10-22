package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class v3 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v3 f65438a = null;

    static {
        f65438a = new v3();
    }

    public v3() {
        super("live_player_trace_category", "播放器trace上报category白名单", CollectionsKt.mutableListOf(new String[]{"stream_format", "stream_type", "resolution", "create_scene", "use_scene", "decode_type", "exception_type", "exception_reason", "live_player_is_mute", "network_type", "render_view_type", "app_is_background", "codec", "decode_type", "is_share_player", "mixed_audio_trigger", "error_code", "app_update_version_code"}), CollectionsKt.mutableListOf(new String[]{"stream_format", "stream_type", "resolution", "create_scene", "use_scene", "decode_type", "exception_type", "exception_reason", "live_player_is_mute", "network_type", "render_view_type", "app_is_background", "codec", "decode_type", "is_share_player", "mixed_audio_trigger", "error_code", "app_update_version_code"}));
    }
}
