package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f65443a = null;

    static {
        f65443a = new w0();
    }

    public w0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_activity_slardar_monitor", "允许活动区 sladar 上报", r100, r100);
    }
}
