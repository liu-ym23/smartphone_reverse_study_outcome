package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f65214a = null;

    static {
        f65214a = new b();
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_net_hint", "弱网情况下是否弹toast", r100, r100);
    }
}
