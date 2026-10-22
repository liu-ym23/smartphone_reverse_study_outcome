package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i5 f65325a = null;

    static {
        f65325a = new i5();
    }

    public i5() {
        super("live_smooth_enter_feed_sv_opt", "平滑进房SurfaceView黑屏优化", Boolean.FALSE, Boolean.TRUE);
    }
}
