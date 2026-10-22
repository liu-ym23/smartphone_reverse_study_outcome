package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class dv0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dv0 f120067a = null;

    static {
        f120067a = new dv0();
    }

    public dv0() {
        Boolean r100 = Boolean.TRUE;
        super("live_toolbar_memory_leak_fix", "toolbarManager 内存泄露修复", r100, r100);
    }
}
