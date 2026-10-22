package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class p60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p60 f120956a = null;

    static {
        f120956a = new p60();
    }

    public p60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_media_info_change_callback_enable", "是否支持分辨率切换时上报状态", r100, r100);
    }
}
