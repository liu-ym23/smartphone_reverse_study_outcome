package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class m0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f65355a = null;

    static {
        f65355a = new m0();
    }

    public m0() {
        Boolean r100 = Boolean.FALSE;
        super("live_disable_find_diagnose_service", "是否允许查找C端诊断工具", r100, r100);
    }
}
