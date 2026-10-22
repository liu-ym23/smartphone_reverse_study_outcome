package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ja1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ja1 f120510a = null;

    static {
        f120510a = new ja1();
    }

    public ja1() {
        Boolean r100 = Boolean.TRUE;
        super("multi_anchor_leave_msg_opt_enable", "多人主播连线消费leave消息不请求list", r100, r100);
    }
}
