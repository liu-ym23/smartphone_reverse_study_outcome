package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class un0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final un0 f121388a = null;

    static {
        f121388a = new un0();
    }

    public un0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_battle_video_remote_mute_fallback", "视频厅战兜底muteRemoteVideo false", r100, r100);
    }
}
