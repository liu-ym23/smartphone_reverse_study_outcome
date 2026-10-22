package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gt f120312a = null;

    static {
        f120312a = new gt();
    }

    public gt() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_sticker_cancel_by_audience_in_limit_time", "直播贴纸优化实验，当该值为true时，贴纸展示初始时会主动展示关闭按钮", r100, r100);
    }
}
