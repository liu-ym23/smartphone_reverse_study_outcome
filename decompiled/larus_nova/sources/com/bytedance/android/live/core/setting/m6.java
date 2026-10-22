package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class m6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m6 f65361a = null;

    static {
        f65361a = new m6();
    }

    public m6() {
        Boolean r100 = Boolean.TRUE;
        super("multi_anchor_sei_fix", "多人主播连线 sei首帧修复", r100, r100);
    }
}
