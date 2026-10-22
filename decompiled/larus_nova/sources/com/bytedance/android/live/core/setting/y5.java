package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y5 f65464a = null;

    static {
        f65464a = new y5();
    }

    public y5() {
        Boolean r100 = Boolean.FALSE;
        super("live_vs_use_component_strategy_in_portrait", "直播组件是否接入动态策略(节目)", r100, r100, false);
    }
}
