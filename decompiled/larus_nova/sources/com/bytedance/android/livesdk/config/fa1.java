package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fa1 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fa1 f120186a = null;

    static {
        f120186a = new fa1();
    }

    public fa1() {
        super("multiple_room_info_api_size_limit", "房间信息接口单次请求的个数", 25, 25);
    }
}
