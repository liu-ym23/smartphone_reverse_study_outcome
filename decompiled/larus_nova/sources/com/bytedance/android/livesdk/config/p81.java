package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveTbArchOptConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class p81 extends SettingKey<LiveTbArchOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p81 f120959a = null;

    static {
        f120959a = new p81();
    }

    public p81() {
        super("live_tb_arch_opt", "toolbar架构优化", new LiveTbArchOptConfig(), new LiveTbArchOptConfig(), true);
    }
}
