package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class qn0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qn0 f121070a = null;

    static {
        f121070a = new qn0();
    }

    public qn0() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_background_optimization", "直播间背景降噪", r100, r100);
    }
}
