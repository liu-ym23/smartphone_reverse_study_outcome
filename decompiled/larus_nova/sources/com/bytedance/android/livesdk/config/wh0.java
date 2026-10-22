package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerTextureRenderConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class wh0 extends SSettingKey<PlayerTextureRenderConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wh0 f121525a = null;

    static {
        f121525a = new wh0();
    }

    public wh0() {
        super("live_player_disable_texture_render_config", "拉流播放器离屏渲染降级开关配置", new PlayerTextureRenderConfig(), new PlayerTextureRenderConfig());
    }
}
