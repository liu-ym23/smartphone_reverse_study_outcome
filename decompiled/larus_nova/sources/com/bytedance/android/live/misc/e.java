package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f83227a = null;

    static {
        f83227a = new e();
    }

    public e() {
        Boolean r100 = Boolean.TRUE;
        super("live_decouple_digg_and_userinfo", "DiggWidget和主播头像组件解耦", r100, r100, true);
    }
}
