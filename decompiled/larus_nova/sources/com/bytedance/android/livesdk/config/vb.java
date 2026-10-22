package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vb f121434a = null;

    static {
        f121434a = new vb();
    }

    public vb() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_fix_time_setting_loading", "修复预告时间选择弹窗loading不消失", r100, r100);
    }
}
