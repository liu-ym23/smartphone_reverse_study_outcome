package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class n6 extends SSettingKey<Integer[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n6 f65369a = null;

    public n6() {
        super("multi_anchor_sei_fix_support_version", "多人主播连线 sei首帧修复 支持的seiversion", new Integer[]{2, 6}, new Integer[]{2, 6});
    }

    static {
        f65369a = new n6();
    }
}
