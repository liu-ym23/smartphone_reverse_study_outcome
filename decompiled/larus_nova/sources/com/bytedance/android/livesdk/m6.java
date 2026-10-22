package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class m6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m6 f153489a = null;

    static {
        f153489a = new m6();
    }

    public m6() {
        Boolean r100 = Boolean.FALSE;
        super("live_multi_device_entry_opt", "多设备续播入口优化", r100, r100);
    }
}
