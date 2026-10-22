package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class v30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v30 f121417a = null;

    static {
        f121417a = new v30();
    }

    public v30() {
        Boolean r100 = Boolean.FALSE;
        super("live_jsb_gson_adapter_switch", "直播jsb中独立gson解析器配置", r100, r100);
    }
}
