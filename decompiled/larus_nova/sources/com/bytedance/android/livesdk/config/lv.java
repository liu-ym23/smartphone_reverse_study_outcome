package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lv extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lv f120710a = null;

    static {
        f120710a = new lv();
    }

    public lv() {
        Boolean r100 = Boolean.TRUE;
        super("live_feedback_enable_msg_fix", "通过消息触发拉取问卷能力在主看播都生效", r100, r100);
    }
}
