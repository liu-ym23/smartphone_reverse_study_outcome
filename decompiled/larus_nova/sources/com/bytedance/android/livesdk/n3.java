package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class n3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n3 f153995a = null;

    static {
        f153995a = new n3();
    }

    public n3() {
        Boolean r100 = Boolean.FALSE;
        super("live_vqscore_log_intercept", "拦截vqscore打分日志上报", r100, r100);
    }
}
