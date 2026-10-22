package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i5 f132642a = null;

    static {
        f132642a = new i5();
    }

    public i5() {
        Boolean r100 = Boolean.TRUE;
        super("live_float_window_lifecycle_bugfix", "悬浮窗消息生命周期bugfix", r100, r100);
    }
}
