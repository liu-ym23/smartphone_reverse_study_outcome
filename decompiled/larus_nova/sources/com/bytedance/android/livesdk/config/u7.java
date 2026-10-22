package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class u7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u7 f121349a = null;

    static {
        f121349a = new u7();
    }

    public u7() {
        Boolean r100 = Boolean.FALSE;
        super("interact_guest_frame_opt", "首帧优化开关", r100, r100);
    }
}
