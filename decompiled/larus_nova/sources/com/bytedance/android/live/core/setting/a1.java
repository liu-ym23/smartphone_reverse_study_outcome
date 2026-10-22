package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f65203a = null;

    static {
        f65203a = new a1();
    }

    public a1() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_new_condition", "短触临态策略新旧频控开关", r100, r100);
    }
}
