package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class n4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n4 f65367a = null;

    static {
        f65367a = new n4();
    }

    public n4() {
        Boolean r100 = Boolean.TRUE;
        super("live_resource_balance_switch_v5", "资源平衡框架屏蔽开播端", r100, r100);
    }
}
