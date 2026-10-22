package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ax extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ax f119825a = null;

    static {
        f119825a = new ax();
    }

    public ax() {
        Boolean r100 = Boolean.TRUE;
        super("live_float_window_exit_resume_normal", "小窗OnClose时是否调用resumeNormal (解决节目直播房间内小窗关闭后不恢复拉流)", r100, r100);
    }
}
