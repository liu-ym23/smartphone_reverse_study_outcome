package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a4 f65206a = null;

    static {
        f65206a = new a4();
    }

    public a4() {
        Boolean r100 = Boolean.FALSE;
        super("live_sdk_preview_sr_support", "预览流是否支持超分", r100, r100);
    }
}
