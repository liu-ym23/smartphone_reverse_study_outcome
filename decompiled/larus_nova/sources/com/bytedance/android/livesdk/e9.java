package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e9 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e9 f123292a = null;

    static {
        f123292a = new e9();
    }

    public e9() {
        Boolean r100 = Boolean.FALSE;
        super("strategy_room_feature_enable", "策略平台直播间实时特征开关", r100, r100);
    }
}
