package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g4 f65306a = null;

    static {
        f65306a = new g4();
    }

    public g4() {
        Boolean r100 = Boolean.FALSE;
        super("live_resource_balance_switch", "资源平衡框架整体开关", r100, r100);
    }
}
