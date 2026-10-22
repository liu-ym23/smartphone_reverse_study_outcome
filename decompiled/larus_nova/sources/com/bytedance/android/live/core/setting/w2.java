package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w2 f65445a = null;

    static {
        f65445a = new w2();
    }

    public w2() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_full_screen_dialog_av_permission_bugfix", "多人场景全屏Dialog释放音视频权限修复", r100, r100);
    }
}
