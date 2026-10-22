package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class c40 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c40 f119921a = null;

    static {
        f119921a = new c40();
    }

    public c40() {
        Boolean r100 = Boolean.FALSE;
        super("live_ksong_public_screen_adjust", "ksong 公屏调整逻辑短路", r100, r100);
    }
}
