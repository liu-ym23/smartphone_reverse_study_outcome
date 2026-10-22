package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f159237a = null;

    static {
        f159237a = new v();
    }

    public v() {
        super("live_annie_init_start_vboost", "annie容器启动时开启vboost加速", Boolean.FALSE, Boolean.TRUE);
    }
}
