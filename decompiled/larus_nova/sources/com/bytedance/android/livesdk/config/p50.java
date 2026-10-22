package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class p50 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p50 f120955a = null;

    static {
        f120955a = new p50();
    }

    public p50() {
        Boolean r100 = Boolean.FALSE;
        super("live_landscape_refresh_pull_stream", "横屏直播间支持刷新重新拉流", r100, r100);
    }
}
