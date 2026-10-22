package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class e2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2 f65287a = null;

    static {
        f65287a = new e2();
    }

    public e2() {
        Boolean r100 = Boolean.TRUE;
        super("live_ktv_audience_ai_lyric_enable", "你点我唱ai歌词展示开关", r100, r100);
    }
}
