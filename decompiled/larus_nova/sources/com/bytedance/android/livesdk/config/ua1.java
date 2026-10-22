package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ua1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ua1 f121357a = null;

    static {
        f121357a = new ua1();
    }

    public ua1() {
        Boolean r100 = Boolean.FALSE;
        super("multi_link_room_cache_enable", "多人场景是否启用roomCache机制", r100, r100);
    }
}
