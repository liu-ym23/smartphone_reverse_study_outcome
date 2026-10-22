package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gc0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gc0 f120268a = null;

    static {
        f120268a = new gc0();
    }

    public gc0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_room_bugfix", "预加载直播间bugfix", r100, r100, true);
    }
}
