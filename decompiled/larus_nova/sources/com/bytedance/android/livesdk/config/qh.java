package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qh f121055a = null;

    static {
        f121055a = new qh();
    }

    public qh() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_pause_enable", "主播主动暂停功能开关", r100, r100);
    }
}
