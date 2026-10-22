package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f140990a = null;

    static {
        f140990a = new b();
    }

    public b() {
        Boolean r100 = Boolean.TRUE;
        super("live_interactivity_degrade_by_audience_exp", "互动降级触发源为竖屏看播体验优化", r100, r100);
    }
}
