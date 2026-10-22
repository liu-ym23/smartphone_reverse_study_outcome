package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q5 f65393a = null;

    static {
        f65393a = new q5();
    }

    public q5() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_component_strategy_in_landscape", "直播组件是否接入动态策略(横屏)", r100, r100, false);
    }
}
