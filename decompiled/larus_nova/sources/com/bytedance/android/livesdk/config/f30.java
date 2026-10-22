package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class f30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f30 f120173a = null;

    static {
        f120173a = new f30();
    }

    public f30() {
        Boolean r100 = Boolean.TRUE;
        super("live_interact_tool_enable_debug_mode", "开播互动工具支持debug模式", r100, r100);
    }
}
