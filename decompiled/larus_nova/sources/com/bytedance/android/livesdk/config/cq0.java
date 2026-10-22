package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class cq0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cq0 f119972a = null;

    static {
        f119972a = new cq0();
    }

    public cq0() {
        Boolean r100 = Boolean.FALSE;
        super("live_screencast_close_activity_enable", "录屏开播关闭无用activity", r100, r100);
    }
}
