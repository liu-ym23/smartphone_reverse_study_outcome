package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y2 f162546a = null;

    static {
        f162546a = new y2();
    }

    public y2() {
        Boolean r100 = Boolean.FALSE;
        super("live_skip_measure", "滑动onMeasure跳帧", r100, r100);
    }
}
