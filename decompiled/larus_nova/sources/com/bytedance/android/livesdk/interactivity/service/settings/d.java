package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f140992a = null;

    static {
        f140992a = new d();
    }

    public d() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_area_badge_dsl_enable", "开启公屏Badge DSL", r100, r100);
    }
}
