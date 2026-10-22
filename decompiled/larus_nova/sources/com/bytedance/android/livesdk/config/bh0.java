package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bh0 f119869a = null;

    static {
        f119869a = new bh0();
    }

    public bh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_guest_message_late_fix", "fix:pk中嘉宾上麦消息晚于首帧到达，导致主播侧看不到嘉宾", r100, r100);
    }
}
