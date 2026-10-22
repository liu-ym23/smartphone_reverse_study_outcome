package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dt f120062a = null;

    static {
        f120062a = new dt();
    }

    public dt() {
        super("live_enable_show_unused_effect_label", Boolean.FALSE, "主播是否上报无美颜字段(用于观众端展示无美颜)");
    }
}
