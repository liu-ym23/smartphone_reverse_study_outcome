package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class p1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p1 f154189a = null;

    static {
        f154189a = new p1();
    }

    public p1() {
        Boolean r100 = Boolean.TRUE;
        super("live_open_scheme_context_fix", "修复Lynx JSB弹窗取不到context的问题", r100, r100);
    }
}
