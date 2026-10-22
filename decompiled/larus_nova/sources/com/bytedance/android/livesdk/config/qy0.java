package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qy0 extends SSettingKey<ck1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qy0 f121092a = null;

    static {
        qy0 r100 = new qy0();
        f121092a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public qy0() {
        super("live_welfare_opt_config", "公益组件配置", new ck1(), new ck1());
    }
}
