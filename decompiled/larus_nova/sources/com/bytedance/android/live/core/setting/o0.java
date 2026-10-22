package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class o0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f65371a = null;

    static {
        f65371a = new o0();
    }

    public o0() {
        Boolean r100 = Boolean.FALSE;
        super("live_dynamic_container_life_cycle_opt", "动态化架构优化-容器加载提前", r100, r100);
    }
}
