package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f104409a = null;

    static {
        f104409a = new c0();
    }

    public c0() {
        Boolean r100 = Boolean.FALSE;
        super("live_clear_slide_to_next_room_flag", "pk直播间跳转二级直播回来无画面修复开关", r100, r100);
    }
}
