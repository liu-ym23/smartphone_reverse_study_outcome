package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes11.dex */
public final class v2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f159189a = null;

    static {
        f159189a = new v2();
    }

    public v2() {
        Boolean r100 = Boolean.FALSE;
        super("live_toast_observe_enable", "是否开启Toast上报", r100, r100);
    }
}
