package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class r5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r5 f156935a = null;

    static {
        f156935a = new r5();
    }

    public r5() {
        Boolean r100 = Boolean.TRUE;
        super("live_gcp_preload_toolabr_remove_config", "游戏小手柄预览流预加载bugfix", r100, r100);
    }
}
