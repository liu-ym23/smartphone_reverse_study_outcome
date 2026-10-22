package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class jq0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jq0 f120545a = null;

    static {
        f120545a = new jq0();
    }

    public jq0() {
        Boolean r100 = Boolean.TRUE;
        super("live_screencast_stop_live_opt", "录屏关播授权优化", r100, r100);
    }
}
