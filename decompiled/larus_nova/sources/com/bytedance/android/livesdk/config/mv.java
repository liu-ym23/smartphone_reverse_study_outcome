package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mv extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mv f120785a = null;

    static {
        f120785a = new mv();
    }

    public mv() {
        Boolean r100 = Boolean.FALSE;
        super("live_feedback_enable_room_control", "是否展示直播进房room里的反馈问卷", r100, r100);
    }
}
