package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class s0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f157854a = null;

    static {
        f157854a = new s0();
    }

    public s0() {
        Boolean r100 = Boolean.TRUE;
        super("live_gc_total_switch", "直播GC抑制总开关, 默认打开", r100, r100);
    }
}
