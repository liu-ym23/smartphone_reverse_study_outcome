package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jc extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jc f120513a = null;

    static {
        f120513a = new jc();
    }

    public jc() {
        super("enable_live_anchor_setting", "抖音直播是否展示主播通知设置入口", Boolean.FALSE, Boolean.TRUE);
    }
}
