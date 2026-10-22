package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f162544a = null;

    static {
        f162544a = new y0();
    }

    public y0() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_preview_enable", "直播内流下滑接预览流", r100, r100);
    }
}
