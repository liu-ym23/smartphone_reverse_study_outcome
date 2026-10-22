package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class lk0 extends SSettingKey<LivePreviewDanmakuConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lk0 f120689a = null;

    static {
        f120689a = new lk0();
    }

    public lk0() {
        super("live_pre_stream_danmaku_config", "直播预流弹幕配置", new LivePreviewDanmakuConfig(), new LivePreviewDanmakuConfig());
    }
}
