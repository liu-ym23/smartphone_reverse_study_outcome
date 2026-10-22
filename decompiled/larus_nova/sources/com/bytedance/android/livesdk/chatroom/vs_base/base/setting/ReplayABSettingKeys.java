package com.bytedance.android.livesdk.chatroom.vs_base.base.setting;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.ReplayEnterOptimize;
import oq1.g;
import oq1.i;

/* JADX INFO: loaded from: classes8.dex */
public interface ReplayABSettingKeys {
    public static final SettingKey<Boolean> LIVE_REPLAY_DANMU_USE_SURFACEVIEW = null;
    public static final SettingKey<ReplayEnterOptimize> LIVE_REPLAY_ENTER_OPTIMIZE = null;
    public static final SettingKey<Boolean> LIVE_REPLAY_PLAYER_USE_SURFACEVIEW = null;
    public static final SettingKey<i> LIVE_REPLAY_SHOW_PRELOAD_EPISODE_CONFIG = null;
    public static final SettingKey<Boolean> LIVE_REPLAY_VIDEO_ENABLE_PRE_PLAY = null;
    public static final SettingKey<g> REPLAY_GESTURE_CONFIG = null;

    static {
        Boolean r110 = Boolean.FALSE;
        LIVE_REPLAY_PLAYER_USE_SURFACEVIEW = new SettingKey("live_replay_player_use_surfaceview", "回放是否启用SurfaceView", r110, r110, true);
        LIVE_REPLAY_ENTER_OPTIMIZE = new SettingKey("live_replay_enter_optimize", "回放进房首帧优化", new ReplayEnterOptimize(), new ReplayEnterOptimize());
        LIVE_REPLAY_SHOW_PRELOAD_EPISODE_CONFIG = new SettingKey("live_vs_show_preload_episode_config", new i(), "vs show 时预拉取 Episode 和缓存视频");
        LIVE_REPLAY_DANMU_USE_SURFACEVIEW = new SettingKey("live_vs_episode_danmu_use_surfaceview", "回放弹幕使用surfaceview，和录播共用一个key", r110, r110, true);
        LIVE_REPLAY_VIDEO_ENABLE_PRE_PLAY = new SettingKey("live_replay_video_enable_pre_play", "起播时机提前", r110, r110);
        REPLAY_GESTURE_CONFIG = new SettingKey("replay_gesture_config", "回放播控优化控制开关", new g(), new g());
    }
}
