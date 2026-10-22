package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class l0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f65346a = null;

    static {
        f65346a = new l0();
    }

    public l0() {
        Boolean r100 = Boolean.FALSE;
        super("live_disable_feed_back_freq", "屏蔽轻交互问卷端上频控逻辑(QA测试时可以打开，默认关的)", r100, r100);
    }
}
