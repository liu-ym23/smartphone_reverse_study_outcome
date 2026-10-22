package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f65201a = null;

    static {
        f65201a = new a();
    }

    public a() {
        Boolean r100 = Boolean.FALSE;
        super("enable_live_banner_resue", "banner复用开关", r100, r100, true);
    }
}
