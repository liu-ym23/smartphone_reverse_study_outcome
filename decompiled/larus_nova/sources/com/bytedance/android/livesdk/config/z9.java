package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.ToolbarWatchLaterSettingConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class z9 extends SSettingKey<ToolbarWatchLaterSettingConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z9 f121744a = null;

    static {
        f121744a = new z9();
    }

    public z9() {
        super("live_add_toolbar_watch_later_config", "是否增加面板-稍后再看按钮", new ToolbarWatchLaterSettingConfig(), new ToolbarWatchLaterSettingConfig());
    }
}
