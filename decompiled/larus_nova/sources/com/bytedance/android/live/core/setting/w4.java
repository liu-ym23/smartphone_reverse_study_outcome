package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4 f65447a = null;

    static {
        f65447a = new w4();
    }

    public w4() {
        Boolean r100 = Boolean.FALSE;
        super("live_search_no_view_found_fix_multi", "fix no view found", r100, r100, true);
    }
}
