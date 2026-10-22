package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class n4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n4 f153996a = null;

    static {
        f153996a = new n4();
    }

    public n4() {
        Boolean r100 = Boolean.FALSE;
        super("live_audio_function_load_sync", "语音功能同步加载开关", r100, r100);
    }
}
