package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class l0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f146984a = null;

    static {
        f146984a = new l0();
    }

    public l0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_lite_page", "是否开启轻量级全页", r100, r100);
    }
}
