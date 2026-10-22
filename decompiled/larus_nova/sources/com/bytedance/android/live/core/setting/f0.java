package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f65293a = null;

    static {
        f65293a = new f0();
    }

    public f0() {
        Boolean r100 = Boolean.FALSE;
        super("live_component_scheduler_visibility_enable", "旧调度器组件同时显隐控制是否生效", r100, r100, false);
    }
}
