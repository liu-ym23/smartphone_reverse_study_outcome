package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gb f120265a = null;

    static {
        f120265a = new gb();
    }

    public gb() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_continue_live__state", "主播续播恢复演唱状态", r100, r100);
    }
}
