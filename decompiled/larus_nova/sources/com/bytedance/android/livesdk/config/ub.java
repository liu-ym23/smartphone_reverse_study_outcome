package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ub extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ub f121358a = null;

    static {
        f121358a = new ub();
    }

    public ub() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_fix_announcement_input_filter", "修复预告内容输入栏不适配手写输入的问题", r100, r100);
    }
}
