package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nr f120854a = null;

    static {
        f120854a = new nr();
    }

    public nr() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_enterunsuccess_eventtrack", "进入房间失败或者首帧读取失败时是否停止发送duration埋点信息", r100, r100);
    }
}
