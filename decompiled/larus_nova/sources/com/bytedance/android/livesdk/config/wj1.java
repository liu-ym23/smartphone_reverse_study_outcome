package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wj1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wj1 f121532a = null;

    static {
        f121532a = new wj1();
    }

    public wj1() {
        super("web_offline_enabled", Boolean.TRUE, "web 离线化开关", new String[]{"false:不开启", "true:开启"});
    }
}
