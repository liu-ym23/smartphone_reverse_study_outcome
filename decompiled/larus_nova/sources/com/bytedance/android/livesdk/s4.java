package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class s4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s4 f157858a = null;

    static {
        f157858a = new s4();
    }

    public s4() {
        Boolean r100 = Boolean.TRUE;
        super("live_comment_jsb_log_enable", "comment jsb 是否允许发送统计埋点", r100, r100);
    }
}
