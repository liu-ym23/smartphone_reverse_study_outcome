package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class bj0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bj0 f119873a = null;

    static {
        f119873a = new bj0();
    }

    public bj0() {
        Boolean r100 = Boolean.FALSE;
        super("live_popup_support_sticky", "面板降级支持sticky", r100, r100);
    }
}
