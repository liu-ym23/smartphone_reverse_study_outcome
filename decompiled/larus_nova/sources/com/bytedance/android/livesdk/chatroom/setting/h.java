package com.bytedance.android.livesdk.chatroom.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f111526a = null;

    static {
        f111526a = new h();
    }

    public h() {
        Boolean r100 = Boolean.FALSE;
        super("live_vr_use_new_style", "vr是否开启新UI&&新交互", r100, r100);
    }
}
