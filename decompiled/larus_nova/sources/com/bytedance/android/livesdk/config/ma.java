package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ma extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ma f120738a = null;

    static {
        f120738a = new ma();
    }

    public ma() {
        Boolean r100 = Boolean.FALSE;
        super("live_allow_download_gecko_resource_v2", "是否主动触发gecko资源下载", r100, r100);
    }
}
