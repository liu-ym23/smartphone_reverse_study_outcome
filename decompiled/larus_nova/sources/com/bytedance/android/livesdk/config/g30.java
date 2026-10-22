package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class g30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g30 f120253a = null;

    static {
        f120253a = new g30();
    }

    public g30() {
        Boolean r100 = Boolean.TRUE;
        super("live_interact_tool_plugin_repel_refactor", "开播互动工具插件互斥逻辑重构", r100, r100, true);
    }
}
