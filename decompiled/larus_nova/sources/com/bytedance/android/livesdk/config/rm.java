package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rm f121142a = null;

    static {
        f121142a = new rm();
    }

    public rm() {
        Boolean r100 = Boolean.FALSE;
        super("live_danmaku_widget_async_enabled", "直播预览弹幕组件异步配置开关", r100, r100);
    }
}
