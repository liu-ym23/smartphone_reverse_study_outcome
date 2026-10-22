package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hj f120380a = null;

    static {
        f120380a = new hj();
    }

    public hj() {
        Boolean r100 = Boolean.TRUE;
        super("live_castscreen_linking_hide_interaction", "投屏播控连接时，隐藏交互层", r100, r100);
    }
}
