package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e5 f123288a = null;

    static {
        f123288a = new e5();
    }

    public e5() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_xseconds_log", "直播间观看x秒上报埋点开关", r100, r100, true);
    }
}
