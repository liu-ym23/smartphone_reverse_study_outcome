package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class f4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f4 f65297a = null;

    static {
        f65297a = new f4();
    }

    public f4() {
        Boolean r100 = Boolean.TRUE;
        super("live_request_song_anim_task_executor_opt", "你点我唱动画任务内存泄漏优化", r100, r100);
    }
}
