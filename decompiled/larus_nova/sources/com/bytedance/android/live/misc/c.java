package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f83225a = null;

    static {
        f83225a = new c();
    }

    public c() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_biz_panel_enable", "主播经营数据面板", r100, r100);
    }
}
