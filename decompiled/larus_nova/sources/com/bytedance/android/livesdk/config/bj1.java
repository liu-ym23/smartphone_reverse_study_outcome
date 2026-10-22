package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class bj1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bj1 f119874a = null;

    static {
        f119874a = new bj1();
    }

    public bj1() {
        Boolean r100 = Boolean.TRUE;
        super("big_party_remember_camera", "是否记住开启摄像头状态", r100, r100);
    }
}
