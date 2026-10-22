package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class s5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s5 f157859a = null;

    static {
        f157859a = new s5();
    }

    public s5() {
        Boolean r100 = Boolean.TRUE;
        super("live_gcp_start_auto_card_config", "端智能讲解预测开启时机调整", r100, r100);
    }
}
