package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ow extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ow f120936a = null;

    static {
        f120936a = new ow();
    }

    public ow() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_in_live_room_condition", "修改直播间内场景判断", r100, r100, true);
    }
}
