package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f65396a = null;

    static {
        f65396a = new r0();
    }

    public r0() {
        Boolean r100 = Boolean.FALSE;
        super("live_dynamic_remove_jsb_opt", "动态化架构优化-清理jsb注册", r100, r100);
    }
}
