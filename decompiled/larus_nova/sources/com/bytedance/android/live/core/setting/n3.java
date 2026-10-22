package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class n3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n3 f65366a = null;

    static {
        f65366a = new n3();
    }

    public n3() {
        Boolean r100 = Boolean.TRUE;
        super("live_opt_get_launch_task_switch_enable", "优化launch task是否延迟执行的开关获取", r100, r100, true);
    }
}
