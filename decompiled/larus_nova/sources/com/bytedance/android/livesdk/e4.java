package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e4 f123287a = null;

    static {
        f123287a = new e4();
    }

    public e4() {
        Boolean r100 = Boolean.TRUE;
        super("live_ai_clone_trace_enable", "AI分身进公屏trace开关", r100, r100);
    }
}
