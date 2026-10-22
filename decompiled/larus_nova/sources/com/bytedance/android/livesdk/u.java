package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class u extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f158609a = null;

    public u() {
        super("live_annie_init_gc_inhibition", "annie容器启动时GC抑制策略", 0, 0);
    }

    static {
        f158609a = new u();
    }
}
