package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class t2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t2 f65414a = null;

    static {
        f65414a = new t2();
    }

    public t2() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_enlarge_stage_guide_opt", "是否展示舞台放大布局引导面板", r100, r100);
    }
}
