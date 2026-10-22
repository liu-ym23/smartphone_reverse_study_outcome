package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qm0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qm0 f121068a = null;

    static {
        f121068a = new qm0();
    }

    public qm0() {
        super("live_record_max_duration", "录屏最大时长", 60, 60);
    }
}
