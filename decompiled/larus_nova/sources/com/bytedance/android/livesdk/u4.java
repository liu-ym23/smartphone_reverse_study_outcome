package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class u4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u4 f158614a = null;

    static {
        f158614a = new u4();
    }

    public u4() {
        Boolean r100 = Boolean.TRUE;
        super("live_comment_tip_low_pcu_guide_switch", "评论提示是否开启低pcu引导", r100, r100);
    }
}
