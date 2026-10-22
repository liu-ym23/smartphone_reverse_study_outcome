package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xm f121616a = null;

    static {
        f121616a = new xm();
    }

    public xm() {
        Boolean r100 = Boolean.TRUE;
        super("live_decouple_digg_and_userinfo", "DiggWidget和主播头像组件解耦", r100, r100, true);
    }
}
