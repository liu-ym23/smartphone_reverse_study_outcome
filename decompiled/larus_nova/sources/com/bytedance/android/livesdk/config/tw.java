package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tw f121330a = null;

    static {
        f121330a = new tw();
    }

    public tw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_room_id_inner_quick_switch", "修复搜索内流上下划，roomID错误导致直播间信息错误", r100, r100);
    }
}
