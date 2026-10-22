package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wp extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wp f121543a = null;

    static {
        f121543a = new wp();
    }

    public wp() {
        Boolean r100 = Boolean.TRUE;
        super("live_dynamic_not_send_seat_list", "命中Lynx麦位时屏蔽向动态化发送seat_list", r100, r100);
    }
}
