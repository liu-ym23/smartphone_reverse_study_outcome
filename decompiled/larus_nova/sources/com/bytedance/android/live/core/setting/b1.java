package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f65216a = null;

    static {
        f65216a = new b1();
    }

    public b1() {
        Boolean r100 = Boolean.TRUE;
        super("live_shorttouch_strategy_condition_enable", "短触临态策略展示频控开关", r100, r100);
    }
}
