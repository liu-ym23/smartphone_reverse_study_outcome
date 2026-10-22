package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hu extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hu f120404a = null;

    static {
        f120404a = new hu();
    }

    public hu() {
        Boolean r100 = Boolean.FALSE;
        super("live_enter_room_container_opt", "是否使用新的进房架构", r100, r100, true);
    }
}
