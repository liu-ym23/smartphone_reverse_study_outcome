package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class md extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final md f120745a = null;

    static {
        f120745a = new md();
    }

    public md() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_virtual_live_pk_enable", "虚拟直播开启pk", r100, r100);
    }
}
