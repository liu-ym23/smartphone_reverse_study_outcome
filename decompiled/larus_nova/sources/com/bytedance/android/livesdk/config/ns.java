package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ns extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ns f120856a = null;

    static {
        f120856a = new ns();
    }

    public ns() {
        Boolean r100 = Boolean.TRUE;
        super("enable_open_platform_network", "开放平台网络能力风险开关(后续要删除)", r100, r100);
    }
}
