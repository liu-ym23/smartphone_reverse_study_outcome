package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f120331a = null;

    static {
        f120331a = new h2();
    }

    public h2() {
        super("dns_opt_free_flow_enable", Boolean.FALSE, "免流用户是否开启节点优选");
    }
}
