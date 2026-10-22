package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class w10 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w10 f121491a = null;

    static {
        f121491a = new w10();
    }

    public w10() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_feed_rerank_old_logic_opt", "内流重排重复触发问题", r100, r100, true);
    }
}
