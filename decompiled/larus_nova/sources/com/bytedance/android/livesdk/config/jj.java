package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jj f120530a = null;

    static {
        f120530a = new jj();
    }

    public jj() {
        Boolean r100 = Boolean.TRUE;
        super("live_cast_exit_room_opt", "destroy回调时，投屏逻辑兼容", r100, r100, true);
    }
}
