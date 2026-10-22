package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class fj extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fj f120207a = null;

    static {
        f120207a = new fj();
    }

    public fj() {
        Boolean r100 = Boolean.FALSE;
        super("live_camera_switch_log_enable", "直播相机切换日志", r100, r100, true);
    }
}
