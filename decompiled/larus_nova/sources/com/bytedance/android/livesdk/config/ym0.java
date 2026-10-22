package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ym0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ym0 f121701a = null;

    static {
        f121701a = new ym0();
    }

    public ym0() {
        Boolean r100 = Boolean.FALSE;
        super("live_request_gson_adapter_switch", "直播中请求独立gson解析器配置", r100, r100);
    }
}
