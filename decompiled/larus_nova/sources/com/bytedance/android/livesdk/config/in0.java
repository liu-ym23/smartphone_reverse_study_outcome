package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class in0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final in0 f120467a = null;

    static {
        f120467a = new in0();
    }

    public in0() {
        Boolean r100 = Boolean.TRUE;
        super("live_revenue_protobuff_enable", "控制fetch是否开启protobuf", r100, r100);
    }
}
