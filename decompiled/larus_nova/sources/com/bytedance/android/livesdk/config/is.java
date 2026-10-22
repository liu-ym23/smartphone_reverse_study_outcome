package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class is extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final is f120476a = null;

    static {
        f120476a = new is();
    }

    public is() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_multi_link_join_room_in_advance", "多人场景建联提前建联优化", r100, r100);
    }
}
