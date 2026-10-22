package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class np0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final np0 f120851a = null;

    static {
        f120851a = new np0();
    }

    public np0() {
        Boolean r100 = Boolean.FALSE;
        super("live_saas_full_fuse_request_enable", "直播 saas 完全同构适配", r100, r100);
    }
}
