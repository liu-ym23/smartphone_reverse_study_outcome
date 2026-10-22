package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class e0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f65285a = null;

    static {
        f65285a = new e0();
    }

    public e0() {
        Boolean r100 = Boolean.FALSE;
        super("live_community_tracking_fix", "社区埋点修复", r100, r100);
    }
}
