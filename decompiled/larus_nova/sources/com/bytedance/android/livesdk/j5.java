package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j5 f142018a = null;

    static {
        f142018a = new j5();
    }

    public j5() {
        Boolean r100 = Boolean.TRUE;
        super("live_focus_widget_opt", "直播中焦点组件优化", r100, r100);
    }
}
