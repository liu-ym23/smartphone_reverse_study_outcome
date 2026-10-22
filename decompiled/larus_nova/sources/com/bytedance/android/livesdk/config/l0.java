package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveBackToPreRoomSetting;

/* JADX INFO: loaded from: classes8.dex */
public final class l0 extends SSettingKey<LiveBackToPreRoomSetting> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f120642a = null;

    static {
        f120642a = new l0();
    }

    public l0() {
        super("return_back_settings", "返回上一个直播间", new LiveBackToPreRoomSetting(), new LiveBackToPreRoomSetting());
    }
}
