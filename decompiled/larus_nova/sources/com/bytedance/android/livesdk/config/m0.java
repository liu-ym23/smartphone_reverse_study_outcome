package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveBackToPreRoomSettingV2;

/* JADX INFO: loaded from: classes8.dex */
public final class m0 extends SSettingKey<LiveBackToPreRoomSettingV2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f120721a = null;

    static {
        f120721a = new m0();
    }

    public m0() {
        super("return_back_settings_v2", "返回上一个直播间新样式", new LiveBackToPreRoomSettingV2(), new LiveBackToPreRoomSettingV2(), true);
    }
}
