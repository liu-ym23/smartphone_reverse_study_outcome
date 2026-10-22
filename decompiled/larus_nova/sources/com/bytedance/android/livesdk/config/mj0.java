package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class mj0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mj0 f120761a = null;

    static {
        f120761a = new mj0();
    }

    public mj0() {
        Boolean r100 = Boolean.TRUE;
        super("live_preview_daily_opt_enable", "开播页新增日常模式的端上兜底开关", r100, r100);
    }
}
