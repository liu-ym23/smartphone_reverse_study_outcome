package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class d60 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d60 f120002a = null;

    static {
        f120002a = new d60();
    }

    public d60() {
        Boolean r100 = Boolean.TRUE;
        super("live_linkmic_leave_page_v3_enable", "多人连线结束页-连线复盘页", r100, r100);
    }
}
