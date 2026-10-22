package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a5 f102996a = null;

    static {
        f102996a = new a5();
    }

    public a5() {
        Boolean r100 = Boolean.FALSE;
        super("live_revenue_screen_cast_link_opt", "启用新的录屏开播连线逻辑", r100, r100);
    }
}
