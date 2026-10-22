package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f65460a = null;

    static {
        f65460a = new y1();
    }

    public y1() {
        Boolean r100 = Boolean.FALSE;
        super("live_hybrid_create_annie_card_opt", "跨端组件加载打散", r100, r100);
    }
}
