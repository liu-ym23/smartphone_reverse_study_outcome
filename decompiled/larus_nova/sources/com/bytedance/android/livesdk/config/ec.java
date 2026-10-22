package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ec extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ec f120114a = null;

    static {
        f120114a = new ec();
    }

    public ec() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_more_dialog_fix_scroll_click_error", "主播更多面板滑动后第一次点击失效修复", r100, r100);
    }
}
