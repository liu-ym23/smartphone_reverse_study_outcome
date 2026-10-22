package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class i9 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i9 f120431a = null;

    static {
        f120431a = new i9();
    }

    public i9() {
        Boolean r100 = Boolean.TRUE;
        super("link_interact_stream_background_opt_enable", "连麦触发停止和恢复拉流逻辑是否不区分前后台", r100, r100);
    }
}
