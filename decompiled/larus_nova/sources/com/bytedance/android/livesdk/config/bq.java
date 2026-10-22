package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bq f119891a = null;

    static {
        bq r100 = new bq();
        f119891a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public bq() {
        super("live_dynamic_toolbar_modify_theme", Boolean.FALSE, "toolbar标准化换肤能力");
    }
}
