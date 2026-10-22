package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ou0 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ou0 f120933a = null;

    static {
        f120933a = new ou0();
    }

    public ou0() {
        super("live_timebalance_log", "上报缩放比例", 100, 100);
    }
}
