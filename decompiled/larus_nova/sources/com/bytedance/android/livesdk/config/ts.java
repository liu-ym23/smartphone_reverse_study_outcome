package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ts extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ts f121322a = null;

    static {
        f121322a = new ts();
    }

    public ts() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_room_feedback_position_adjust", "是否支持房间内问卷position参数更改", r100, r100);
    }
}
