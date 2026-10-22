package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class u30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u30 f121343a = null;

    static {
        f121343a = new u30();
    }

    public u30() {
        Boolean r100 = Boolean.TRUE;
        super("live_jsb_follow_failure_callback_fix", "关注主播jsb请求失败走finishWithFailure", r100, r100);
    }
}
