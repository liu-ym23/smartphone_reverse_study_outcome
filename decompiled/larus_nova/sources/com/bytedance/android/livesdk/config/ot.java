package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ot extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ot f120930a = null;

    static {
        f120930a = new ot();
    }

    public ot() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_xplay_show_sei_delay", "xplay云游戏容器是否显示操作延迟", r100, r100, true);
    }
}
