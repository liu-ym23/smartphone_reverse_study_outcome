package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class m30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m30 f120729a = null;

    static {
        f120729a = new m30();
    }

    public m30() {
        Boolean r100 = Boolean.TRUE;
        super("live_interact_xplay_launch_optimize_enable", "弹幕玩法云启动耗时并发优化", r100, r100);
    }
}
