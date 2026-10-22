package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class dz extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dz f120074a = null;

    static {
        f120074a = new dz();
    }

    public dz() {
        super("live_gift_safely_init_model", "安全执行initmodel", Boolean.FALSE, Boolean.TRUE);
    }
}
