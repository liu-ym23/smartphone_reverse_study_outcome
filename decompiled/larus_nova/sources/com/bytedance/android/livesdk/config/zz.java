package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveHazyFrameConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class zz extends SSettingKey<LiveHazyFrameConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zz f121802a = null;

    static {
        zz r100 = new zz();
        f121802a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public zz() {
        super("live_hazy_frame_opt", "直播背景图抽帧优化", new LiveHazyFrameConfig(), new LiveHazyFrameConfig());
    }
}
