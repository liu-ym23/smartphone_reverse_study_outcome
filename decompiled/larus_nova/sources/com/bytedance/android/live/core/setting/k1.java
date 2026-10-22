package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class k1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f65337a = null;

    static {
        f65337a = new k1();
    }

    public k1() {
        Boolean r100 = Boolean.FALSE;
        super("live_external_stop_when_new_room_create", "外部直播在新房间创建时停止", r100, r100, true);
    }
}
