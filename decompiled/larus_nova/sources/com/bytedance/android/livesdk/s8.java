package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class s8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s8 f157862a = null;

    static {
        f157862a = new s8();
    }

    public s8() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_first_show_pagesource_report", "修复pageSourceFilter没上报进房参数bug", r100, r100);
    }
}
