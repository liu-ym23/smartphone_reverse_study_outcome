package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b4 f65219a = null;

    static {
        f65219a = new b4();
    }

    public b4() {
        Boolean r100 = Boolean.FALSE;
        super("live_previre_qualitylist_enable", "预览流检查qualitylist", r100, r100);
    }
}
