package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dm0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dm0 f120049a = null;

    static {
        f120049a = new dm0();
    }

    public dm0() {
        Boolean r100 = Boolean.TRUE;
        super("live_real_time_chorus_push_stream_fix", "实时合唱推流时序问题调整", r100, r100);
    }
}
