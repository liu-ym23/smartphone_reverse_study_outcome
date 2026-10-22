package com.bytedance.android.live.core.setting;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class v0 extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f65428a = null;

    static {
        f65428a = new v0();
    }

    public v0() {
        super("live_effect_sdk_config", "effect ab配置", SliceInitService.DEFAULT_SWITCH, SliceInitService.DEFAULT_SWITCH, false);
    }
}
