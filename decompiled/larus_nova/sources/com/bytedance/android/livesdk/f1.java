package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class f1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f123399a = null;

    static {
        f123399a = new f1();
    }

    public f1() {
        Boolean r100 = Boolean.TRUE;
        super("live_lite_page_global_props_fix", "轻量级全页/并发加载全页电商首屏直出开关", r100, r100);
    }
}
