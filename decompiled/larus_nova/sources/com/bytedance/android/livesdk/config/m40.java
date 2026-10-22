package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class m40 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m40 f120731a = null;

    static {
        f120731a = new m40();
    }

    public m40() {
        Boolean r100 = Boolean.TRUE;
        super("live_ktv_live_widget_remove", "ktv场景下，不检查renderView", r100, r100);
    }
}
