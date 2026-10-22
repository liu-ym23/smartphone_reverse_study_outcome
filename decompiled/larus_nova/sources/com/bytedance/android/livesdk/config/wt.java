package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class wt extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wt f121551a = null;

    static {
        f121551a = new wt();
    }

    public wt() {
        Boolean r100 = Boolean.FALSE;
        super("live_end_page_rts", "直播结束页使用RTS版本", r100, r100);
    }
}
