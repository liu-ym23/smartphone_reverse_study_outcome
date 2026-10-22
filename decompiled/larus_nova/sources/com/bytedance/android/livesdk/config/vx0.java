package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vx0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vx0 f121485a = null;

    static {
        f121485a = new vx0();
    }

    public vx0() {
        super("live_vs_fix_strategy_load_gift_panel", Boolean.TRUE, "修复节目组件加载顺序调整礼物面板问题");
    }
}
