package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h8 f132630a = null;

    static {
        f132630a = new h8();
    }

    public h8() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_6dof_on_room_enter_enable_switch_stream", "VR6dof主播开关抠图进房时允许动态切流", r100, r100);
    }
}
