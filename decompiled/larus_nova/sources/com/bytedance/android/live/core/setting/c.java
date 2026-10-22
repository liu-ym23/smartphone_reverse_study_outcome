package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f65267a = null;

    static {
        f65267a = new c();
    }

    public c() {
        Boolean r100 = Boolean.FALSE;
        super("preload_lucky_ug_setting_ab", "不预初始化UGSettings", r100, r100);
    }
}
