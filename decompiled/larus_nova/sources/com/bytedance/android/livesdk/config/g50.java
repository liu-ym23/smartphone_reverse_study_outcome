package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class g50 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g50 f120256a = null;

    static {
        f120256a = new g50();
    }

    public g50() {
        Boolean r100 = Boolean.FALSE;
        super("live_landscape_background_replace_optimize", "横屏直播间背景替换黑色", r100, r100);
    }
}
