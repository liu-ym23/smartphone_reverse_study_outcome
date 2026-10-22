package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yb f121672a = null;

    static {
        f121672a = new yb();
    }

    public yb() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_more_dialog_height_opt", "主播更多面板高度优化为固定484dp,与ios对齐，端上兜底开关", r100, r100);
    }
}
