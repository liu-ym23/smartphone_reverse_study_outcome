package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveLongPressPanelItemConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class m70 extends SSettingKey<LiveLongPressPanelItemConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m70 f120734a = null;

    static {
        f120734a = new m70();
    }

    public m70() {
        super("live_long_press_item_config", "长按面板item的一些配置", new LiveLongPressPanelItemConfig(), new LiveLongPressPanelItemConfig());
    }
}
