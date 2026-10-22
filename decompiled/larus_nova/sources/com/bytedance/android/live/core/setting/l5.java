package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class l5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l5 f65351a = null;

    static {
        f65351a = new l5();
    }

    public l5() {
        Boolean r100 = Boolean.FALSE;
        super("live_support_activity_touch_dispatch", "直播Acitvity支持事件分发", r100, r100);
    }
}
