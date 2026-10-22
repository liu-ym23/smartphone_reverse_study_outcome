package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uv extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uv f121403a = null;

    static {
        f121403a = new uv();
    }

    public uv() {
        Boolean r100 = Boolean.TRUE;
        super("enable_live_filter_tandem_repeated", "过滤连续重复的直播间", r100, r100);
    }
}
