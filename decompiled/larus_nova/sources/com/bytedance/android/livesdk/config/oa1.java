package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class oa1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oa1 f120889a = null;

    static {
        f120889a = new oa1();
    }

    public oa1() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_dynamic_context_fix", "动态化DynamicContext抢占兜底修复", r100, r100);
    }
}
