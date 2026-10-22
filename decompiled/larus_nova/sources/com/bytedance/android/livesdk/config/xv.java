package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xv extends SSettingKey<z21> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xv f121634a = null;

    static {
        xv r100 = new xv();
        f121634a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public xv() {
        super("live_finished_auto_page_config", "关播页自动切换", new z21(), new z21());
    }
}
