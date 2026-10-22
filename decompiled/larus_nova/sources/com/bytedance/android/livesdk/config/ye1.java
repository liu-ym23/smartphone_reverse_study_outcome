package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ye1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ye1 f121680a = null;

    static {
        f121680a = new ye1();
    }

    public ye1() {
        Boolean r100 = Boolean.TRUE;
        super("release_av_permission_when_close_notification_on_background", "手动在后台关闭通知栏权限，释放音视频采集权限", r100, r100);
    }
}
