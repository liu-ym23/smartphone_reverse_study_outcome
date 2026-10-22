package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class cr extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cr f119973a = null;

    static {
        f119973a = new cr();
    }

    public cr() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_block_user_optimize", "看播拉黑校验", r100, r100);
    }
}
