package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cs extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cs f119975a = null;

    static {
        f119975a = new cs();
    }

    public cs() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_live_link_trace", "开启livelink trace", r100, r100);
    }
}
