package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ml0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ml0 f120766a = null;

    static {
        f120766a = new ml0();
    }

    public ml0() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_relax_feedback_public_screen", "满意度公屏Relax启用", r100, r100);
    }
}
