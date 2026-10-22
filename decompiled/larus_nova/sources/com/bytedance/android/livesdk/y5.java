package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y5 f162549a = null;

    static {
        f162549a = new y5();
    }

    public y5() {
        Boolean r100 = Boolean.TRUE;
        super("live_input_emoji_parse_ignore_livespan", "emoji在解析的时候跳过livespan", r100, r100);
    }
}
