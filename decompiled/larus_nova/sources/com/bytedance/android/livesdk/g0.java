package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class g0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f125377a = null;

    static {
        f125377a = new g0();
    }

    public g0() {
        super("live_draw_user_behaviro_monitor", "直播内流用户行为采集", Boolean.FALSE, Boolean.TRUE);
    }
}
