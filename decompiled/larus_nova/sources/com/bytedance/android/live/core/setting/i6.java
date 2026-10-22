package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i6 f65326a = null;

    static {
        f65326a = new i6();
    }

    public i6() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_optimize_buy_vip_toast", "会员进房付费直播toast文案", r100, r100);
    }
}
