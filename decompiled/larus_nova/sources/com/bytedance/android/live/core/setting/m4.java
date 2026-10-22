package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class m4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m4 f65359a = null;

    static {
        f65359a = new m4();
    }

    public m4() {
        Boolean r100 = Boolean.TRUE;
        super("live_resource_balance_switch_v4", "资源平衡框架支持批处理", r100, r100);
    }
}
