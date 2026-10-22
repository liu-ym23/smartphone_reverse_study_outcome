package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v3 f159241a = null;

    static {
        f159241a = new v3();
    }

    public v3() {
        Boolean r100 = Boolean.FALSE;
        super("enable_smooth_switch", "启用进房清晰度平滑切档", r100, r100);
    }
}
