package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nu extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nu f120860a = null;

    static {
        nu r100 = new nu();
        f120860a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public nu() {
        Boolean r100 = Boolean.FALSE;
        super("live_enter_room_request_retrofit_opt", "room/enter接口retrofit优化", r100, r100, true);
    }
}
