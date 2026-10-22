package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lp0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lp0 f120699a = null;

    static {
        lp0 r100 = new lp0();
        f120699a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public lp0() {
        super("live_rts_preload_setting", "RTS信令预加载", Boolean.FALSE, Boolean.TRUE, new String[]{"true:使用预加载", "false:不使用预加载"});
    }
}
