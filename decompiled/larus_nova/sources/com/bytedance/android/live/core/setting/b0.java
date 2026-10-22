package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f65215a = null;

    static {
        f65215a = new b0();
    }

    public b0() {
        Boolean r100 = Boolean.TRUE;
        super("live_clear_resolution_memory_when_set", "用户选中清晰度时，清除旧版本清晰度的本地记忆", r100, r100);
    }
}
