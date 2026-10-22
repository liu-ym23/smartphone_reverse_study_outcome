package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fd1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fd1 f120194a = null;

    static {
        f120194a = new fd1();
    }

    public fd1() {
        Boolean r100 = Boolean.TRUE;
        super("paidlive_enable_ticket_creation_in_room", "是否支持直播间内创建预售门票", r100, r100);
    }
}
