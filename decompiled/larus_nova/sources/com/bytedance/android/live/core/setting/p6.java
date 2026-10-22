package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class p6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p6 f65385a = null;

    static {
        f65385a = new p6();
    }

    public p6() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_clip_image_view_opt_enable", "多人场景ClipImageView优化开关", r100, r100);
    }
}
