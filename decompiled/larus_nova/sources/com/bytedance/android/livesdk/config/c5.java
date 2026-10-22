package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class c5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c5 f119923a = null;

    static {
        f119923a = new c5();
    }

    public c5() {
        Boolean r100 = Boolean.TRUE;
        super("fix_live_room_fragment_destroy", "修复混排场景LiveRoomFragment泄漏", r100, r100);
    }
}
