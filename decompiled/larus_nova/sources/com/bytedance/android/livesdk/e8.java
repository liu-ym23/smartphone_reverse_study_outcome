package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e8 f123291a = null;

    static {
        f123291a = new e8();
    }

    public e8() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_single_default_parse_config", "default ParseConfig 使用单例类", r100, r100);
    }
}
