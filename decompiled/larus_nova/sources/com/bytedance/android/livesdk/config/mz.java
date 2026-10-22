package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class mz extends SSettingKey<GroupLiveGameConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mz f120793a = null;

    static {
        mz r100 = new mz();
        f120793a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public mz() {
        super("live_group_live_game_config", GroupLiveGameConfig.class, "社交群/IM一起玩功能配置", new GroupLiveGameConfig(), new GroupLiveGameConfig());
    }
}
