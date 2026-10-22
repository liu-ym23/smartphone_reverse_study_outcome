package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class p5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p5 f65384a = null;

    static {
        f65384a = new p5();
    }

    public p5() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_component_strategy_in_anchor", "直播组件是否接入动态策略(主播)", r100, r100, false);
    }
}
