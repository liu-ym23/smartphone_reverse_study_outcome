package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class z4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z4 f121735a = null;

    static {
        f121735a = new z4();
    }

    public z4() {
        Boolean r100 = Boolean.FALSE;
        super("fix_dumplication_room_stop_opt", "优化直播兜底退房逻辑", r100, r100, true);
    }
}
