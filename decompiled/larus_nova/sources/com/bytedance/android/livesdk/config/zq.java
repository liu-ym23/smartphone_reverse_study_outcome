package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zq f121784a = null;

    static {
        f121784a = new zq();
    }

    public zq() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_auto_page_change", "进房失败后是否自动切换到下一页", r100, r100);
    }
}
