package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dg extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dg f120030a = null;

    static {
        f120030a = new dg();
    }

    public dg() {
        Boolean r100 = Boolean.FALSE;
        super("live_back_same_room_optimize", "返回同一直播间bugfix", r100, r100);
    }
}
