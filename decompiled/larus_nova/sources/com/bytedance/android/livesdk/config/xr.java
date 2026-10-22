package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xr f121626a = null;

    static {
        f121626a = new xr();
    }

    public xr() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_insert_room_business", "是否开启强插直播间能力", r100, r100);
    }
}
