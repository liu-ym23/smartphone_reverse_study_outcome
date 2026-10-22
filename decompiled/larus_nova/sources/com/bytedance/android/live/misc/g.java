package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f83229a = null;

    static {
        f83229a = new g();
    }

    public g() {
        Boolean r100 = Boolean.TRUE;
        super("live_poi_update_fix_enable", "poi动态更新fix", r100, r100);
    }
}
