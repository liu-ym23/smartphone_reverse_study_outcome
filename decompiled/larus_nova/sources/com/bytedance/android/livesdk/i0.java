package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f132634a = null;

    static {
        f132634a = new i0();
    }

    public i0() {
        Boolean r100 = Boolean.TRUE;
        super("use_new_container", "是否开启Annie新Hybrid容器", r100, r100);
    }
}
