package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ss extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ss f121249a = null;

    static {
        f121249a = new ss();
    }

    public ss() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_record_jsb", "录屏能力的jsb开关", r100, r100);
    }
}
