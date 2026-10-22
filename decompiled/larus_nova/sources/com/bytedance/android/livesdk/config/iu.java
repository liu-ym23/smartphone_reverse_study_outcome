package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class iu extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iu f120479a = null;

    static {
        f120479a = new iu();
    }

    public iu() {
        Boolean r100 = Boolean.TRUE;
        super("live_enter_room_comtroller_mem_fix", "进房controller内存泄露修复", r100, r100);
    }
}
