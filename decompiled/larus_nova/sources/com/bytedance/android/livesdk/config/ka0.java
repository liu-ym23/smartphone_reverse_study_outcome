package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ka0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ka0 f120585a = null;

    static {
        f120585a = new ka0();
    }

    public ka0() {
        Boolean r100 = Boolean.TRUE;
        super("live_more_panel_remove_fragment_sync_enable", "更多面板移除fragment使用异步", r100, r100);
    }
}
