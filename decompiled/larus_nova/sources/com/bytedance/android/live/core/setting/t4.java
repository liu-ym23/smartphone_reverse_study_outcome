package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class t4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t4 f65416a = null;

    static {
        f65416a = new t4();
    }

    public t4() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_black_screenbg_fix", "直播间黑屏背景被遮挡修复", r100, r100);
    }
}
