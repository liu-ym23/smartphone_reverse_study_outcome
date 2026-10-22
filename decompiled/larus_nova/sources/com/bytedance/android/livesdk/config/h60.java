package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h60 f120343a = null;

    static {
        f120343a = new h60();
    }

    public h60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_audio_metric_anchor_disable", "是否禁止主播RTC打分", r100, r100, false);
    }
}
