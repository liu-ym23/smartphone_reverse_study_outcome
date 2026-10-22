package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ez extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ez f120164a = null;

    static {
        f120164a = new ez();
    }

    public ez() {
        Boolean r100 = Boolean.TRUE;
        super("live_audience_receive_gift_enable", "给观众送礼开关", r100, r100);
    }
}
