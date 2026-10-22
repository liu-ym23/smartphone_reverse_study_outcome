package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class eo0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eo0 f120143a = null;

    static {
        f120143a = new eo0();
    }

    public eo0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_enable_intercept_close_room", "是否允许拦截退房按钮点击", r100, r100);
    }
}
