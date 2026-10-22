package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class w extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f160648a = null;

    static {
        f160648a = new w();
    }

    public w() {
        Boolean r100 = Boolean.FALSE;
        super("live_announcement_push_chek_new", "直播预约push权限检查新流程", r100, r100);
    }
}
