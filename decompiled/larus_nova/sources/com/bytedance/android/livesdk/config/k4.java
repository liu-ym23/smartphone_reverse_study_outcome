package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class k4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k4 f120574a = null;

    static {
        f120574a = new k4();
    }

    public k4() {
        Boolean r100 = Boolean.TRUE;
        super("enable_upload_jsb_video_compress", "上传JSB是否开启视频压缩能力", r100, r100, true);
    }
}
