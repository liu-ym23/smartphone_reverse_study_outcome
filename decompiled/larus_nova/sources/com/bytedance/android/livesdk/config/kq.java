package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kq f120621a = null;

    static {
        f120621a = new kq();
    }

    public kq() {
        Boolean r100 = Boolean.FALSE;
        super("enable_live_online_resources", "直播特效拉取线上资源", r100, r100);
    }
}
