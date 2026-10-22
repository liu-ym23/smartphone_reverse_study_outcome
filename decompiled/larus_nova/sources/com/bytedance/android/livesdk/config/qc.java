package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qc extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qc f121043a = null;

    static {
        f121043a = new qc();
    }

    public qc() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_room_dynamic_strategy_post_enable", "主播侧进房稳定模式setOnce是否post", r100, r100);
    }
}
