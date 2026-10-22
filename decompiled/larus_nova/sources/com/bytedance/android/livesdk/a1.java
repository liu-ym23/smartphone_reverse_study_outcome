package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f102992a = null;

    static {
        f102992a = new a1();
    }

    public a1() {
        super("live_latch_pre_start", "latch 提前执行", Boolean.FALSE, Boolean.TRUE);
    }
}
