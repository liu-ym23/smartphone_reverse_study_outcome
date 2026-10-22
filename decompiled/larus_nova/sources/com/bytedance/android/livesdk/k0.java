package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class k0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f142261a = null;

    static {
        f142261a = new k0();
    }

    public k0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_flow_page", "是否开启Flow全页", r100, r100);
    }
}
