package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class s6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s6 f65410a = null;

    static {
        f65410a = new s6();
    }

    public s6() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_get_layout_config_from_gecko_opt", "获取多人场景布局配置优化开关", r100, r100);
    }
}
