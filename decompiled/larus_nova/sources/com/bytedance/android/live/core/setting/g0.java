package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f65302a = null;

    static {
        f65302a = new g0();
    }

    public g0() {
        Boolean r100 = Boolean.FALSE;
        super("live_component_strategy_default", "组件加载策略配置默认值", r100, r100);
    }
}
