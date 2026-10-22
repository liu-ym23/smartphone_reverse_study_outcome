package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v5 f159243a = null;

    static {
        f159243a = new v5();
    }

    public v5() {
        Boolean r100 = Boolean.TRUE;
        super("live_hybrid_add_live_scene_param", "hybrid增加roomScene参数", r100, r100);
    }
}
