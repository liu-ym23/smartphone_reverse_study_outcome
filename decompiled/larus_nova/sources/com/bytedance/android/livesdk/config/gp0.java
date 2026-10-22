package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gp0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gp0 f120305a = null;

    static {
        f120305a = new gp0();
    }

    public gp0() {
        super("live_room_tag_request_numbers", "房间三级标签请求数量限制", 20, 20);
    }
}
