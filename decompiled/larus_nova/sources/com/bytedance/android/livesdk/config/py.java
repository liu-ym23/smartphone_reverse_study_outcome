package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class py extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final py f121015a = null;

    static {
        f121015a = new py();
    }

    public py() {
        Boolean r100 = Boolean.TRUE;
        super("live_gecko_enable", "是否开启直播gecko功能", r100, r100);
    }
}
