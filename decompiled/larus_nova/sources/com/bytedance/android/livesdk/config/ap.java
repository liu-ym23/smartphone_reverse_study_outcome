package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DrawerCardLynxConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ap extends SSettingKey<DrawerCardLynxConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ap f119809a = null;

    static {
        f119809a = new ap();
    }

    public ap() {
        super("live_drawer_card_lynx_config", DrawerCardLynxConfig.class, "更多直播中心化card参数配置", new DrawerCardLynxConfig(), null);
    }
}
