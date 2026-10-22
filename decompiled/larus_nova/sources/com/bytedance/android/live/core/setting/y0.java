package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f65459a = null;

    static {
        f65459a = new y0();
    }

    public y0() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_ENABLE_HOST_REFLECT_OPT, "是否开启宿主服务的反射优化", r100, r100, false);
    }
}
