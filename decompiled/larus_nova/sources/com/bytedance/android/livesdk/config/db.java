package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class db extends SSettingKey<LiveAnchorResolution> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final db f120018a = null;

    static {
        f120018a = new db();
    }

    public db() {
        super("live_anchor_clarity_dic", "主播卡顿引导展示前连续卡顿阈值", new LiveAnchorResolution(false, false, 0, 0, false, 31, null), new LiveAnchorResolution(false, false, 0, 0, false, 31, null));
    }
}
