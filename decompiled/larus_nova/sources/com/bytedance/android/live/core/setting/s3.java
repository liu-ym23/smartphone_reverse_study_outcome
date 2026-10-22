package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class s3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f65407a = null;

    static {
        f65407a = new s3();
    }

    public s3() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_crop_data_fix", "修复PC竖屏开播 PK退出后画面异常", r100, r100);
    }
}
