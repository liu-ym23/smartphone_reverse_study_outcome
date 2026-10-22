package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class t6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t6 f158509a = null;

    static {
        f158509a = new t6();
    }

    public t6() {
        Boolean r100 = Boolean.TRUE;
        super("live_personalized_channel_trace_enable", "个性化通道trace开关", r100, r100);
    }
}
