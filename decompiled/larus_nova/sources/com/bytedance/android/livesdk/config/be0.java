package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class be0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final be0 f119861a = null;

    static {
        f119861a = new be0();
    }

    public be0() {
        Boolean r100 = Boolean.TRUE;
        super("live_open_platform_fixed_height_window", "是否固定写死游戏面板的window高度", r100, r100);
    }
}
