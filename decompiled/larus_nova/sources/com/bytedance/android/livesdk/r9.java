package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.VideoHeadSurfaceControlConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class r9 extends SettingKey<VideoHeadSurfaceControlConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r9 f156937a = null;

    static {
        f156937a = new r9();
    }

    public r9() {
        super("video_head_surface_control_config", "直播头像进房surfaceControl优化", new VideoHeadSurfaceControlConfig(), new VideoHeadSurfaceControlConfig());
    }
}
