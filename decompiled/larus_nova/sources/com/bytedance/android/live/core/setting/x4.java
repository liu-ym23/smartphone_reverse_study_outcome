package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x4 f65455a = null;

    static {
        f65455a = new x4();
    }

    public x4() {
        Boolean r100 = Boolean.FALSE;
        super("live_search_no_view_found_fix_single", "fix no view found", r100, r100, true);
    }
}
