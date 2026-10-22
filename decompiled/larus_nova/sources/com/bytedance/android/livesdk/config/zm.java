package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zm f121776a = null;

    static {
        f121776a = new zm();
    }

    public zm() {
        Boolean r100 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_DEGRADE_STRATEGY_SDK_ENABLE, "降级是否开启策略sdk方案", r100, r100);
    }
}
