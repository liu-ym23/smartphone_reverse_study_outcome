package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class k5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k5 f65341a = null;

    static {
        f65341a = new k5();
    }

    public k5() {
        Boolean r100 = Boolean.TRUE;
        super("live_stream_stall_switch", "直播流卡特征", r100, r100);
    }
}
