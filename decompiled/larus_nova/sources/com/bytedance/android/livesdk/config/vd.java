package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vd extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vd f121439a = null;

    static {
        f121439a = new vd();
    }

    public vd() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_broadcast_announcement", "是否开启主播公告功能", r100, r100);
    }
}
