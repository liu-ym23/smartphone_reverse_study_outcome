package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class r2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r2 f156923a = null;

    static {
        f156923a = new r2();
    }

    public r2() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_water_mask_debug_enable", "直播间暗水印位置测试开关", r100, r100);
    }
}
