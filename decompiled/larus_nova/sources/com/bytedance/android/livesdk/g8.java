package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class g8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8 f125385a = null;

    static {
        f125385a = new g8();
    }

    public g8() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_6dof_effect_disable", "关闭VR6dof直播的效果渲染", r100, r100);
    }
}
