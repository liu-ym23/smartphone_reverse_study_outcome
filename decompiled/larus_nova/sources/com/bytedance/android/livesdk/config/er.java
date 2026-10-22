package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class er extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final er f120148a = null;

    static {
        f120148a = new er();
    }

    public er() {
        Boolean r100 = Boolean.TRUE;
        super("live_cast_proxy_enable", "是否使用bytecast投屏代理", r100, r100);
    }
}
