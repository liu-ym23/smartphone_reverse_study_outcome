package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class s6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s6 f157860a = null;

    static {
        s6 r100 = new s6();
        f157860a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public s6() {
        Boolean r100 = Boolean.FALSE;
        super("live_perftool_setting", "PerfTooldebug工具开关", r100, r100);
    }
}
