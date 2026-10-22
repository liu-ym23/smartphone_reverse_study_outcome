package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cj f119956a = null;

    static {
        f119956a = new cj();
    }

    public cj() {
        Boolean r100 = Boolean.TRUE;
        super("bytelink_uplink_api_switch", "直播Bytelink请求代理配置总开关", r100, r100);
    }
}
