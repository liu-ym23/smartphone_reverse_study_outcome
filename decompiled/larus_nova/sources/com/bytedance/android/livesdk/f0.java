package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f123398a = null;

    static {
        f123398a = new f0();
    }

    public f0() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container", "是否下线直播老容器", r100, r100);
    }
}
