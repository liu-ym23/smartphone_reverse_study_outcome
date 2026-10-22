package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cd extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cd f119938a = null;

    static {
        f119938a = new cd();
    }

    public cd() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_support_broadcast_scope_in_interaction", "主播侧scope在交互层使用", r100, r100);
    }
}
