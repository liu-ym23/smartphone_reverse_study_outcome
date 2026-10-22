package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.n41;

/* JADX INFO: loaded from: classes7.dex */
public final class x5 extends SettingKey<n41> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x5 f162538a = null;

    static {
        f162538a = new x5();
    }

    public x5() {
        super("live_inner_slide_stutter_opt", "内流场景切换直播间卡顿优化", new n41(), new n41(), true);
    }
}
