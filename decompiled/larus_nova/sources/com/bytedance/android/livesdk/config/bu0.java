package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bu0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bu0 f119900a = null;

    static {
        f119900a = new bu0();
    }

    public bu0() {
        Boolean r100 = Boolean.FALSE;
        super("live_switch_mark_unread_to_remote", "切换不使用消重回收的判断方式", r100, r100);
    }
}
