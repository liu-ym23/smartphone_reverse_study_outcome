package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qc0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qc0 f121044a = null;

    static {
        f121044a = new qc0();
    }

    public qc0() {
        Boolean r100 = Boolean.TRUE;
        super("live_network_skip_url_end_check", "网络APM开关配置", r100, r100);
    }
}
