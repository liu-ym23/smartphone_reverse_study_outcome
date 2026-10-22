package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wn0 f121540a = null;

    static {
        f121540a = new wn0();
    }

    public wn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_bcm_params_enable", "直播间内是否增加bcm页面参数", r100, r100);
    }
}
