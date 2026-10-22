package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ea0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ea0 f120110a = null;

    static {
        f120110a = new ea0();
    }

    public ea0() {
        Boolean r100 = Boolean.TRUE;
        super("live_more_panel_corner_mark_enable", "观众端更多面板是否使用新样式+角标触达", r100, r100);
    }
}
