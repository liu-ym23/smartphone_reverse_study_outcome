package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nv extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nv f120862a = null;

    static {
        f120862a = new nv();
    }

    public nv() {
        Boolean r100 = Boolean.FALSE;
        super("live_feedback_payment_behavior", "直播间付费引导问卷强插内流和预览流的开关", r100, r100);
    }
}
