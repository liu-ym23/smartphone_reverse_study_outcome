package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class rr0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rr0 f121153a = null;

    static {
        f121153a = new rr0();
    }

    public rr0() {
        Boolean r100 = Boolean.FALSE;
        super("live_setting_update_json_opt", "Setting更新时json转化优化", r100, r100);
    }
}
