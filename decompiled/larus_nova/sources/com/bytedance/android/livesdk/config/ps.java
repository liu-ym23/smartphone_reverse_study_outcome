package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ps extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ps f121003a = null;

    static {
        f121003a = new ps();
    }

    public ps() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_pause_live_when_nocapture_error_end", "主播视频连线使用Avatar异常断开暂停直播兜底提示", r100, r100);
    }
}
