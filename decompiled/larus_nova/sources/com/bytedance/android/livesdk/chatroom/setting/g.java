package com.bytedance.android.livesdk.chatroom.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f111525a = null;

    static {
        f111525a = new g();
    }

    public g() {
        Boolean r100 = Boolean.FALSE;
        super("live_vr_support_landscape", "VR新样式下，是否支持横屏看播", r100, r100);
    }
}
