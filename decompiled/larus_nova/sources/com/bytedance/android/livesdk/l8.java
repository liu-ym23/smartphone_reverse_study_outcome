package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class l8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l8 f146992a = null;

    static {
        f146992a = new l8();
    }

    public l8() {
        Boolean r100 = Boolean.FALSE;
        super("live_vs_use_stream_orientation", "节目横竖版使用stream_orientation", r100, r100);
    }
}
