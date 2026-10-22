package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class f5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5 f123403a = null;

    static {
        f123403a = new f5();
    }

    public f5() {
        Boolean r100 = Boolean.TRUE;
        super("live_enter_room_params_check", "直播进房的enter_from_merge和enter_method参数强校验", r100, r100);
    }
}
