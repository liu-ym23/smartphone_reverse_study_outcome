package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f83230a = null;

    static {
        f83230a = new h();
    }

    public h() {
        Boolean r100 = Boolean.TRUE;
        super("live_template_mic_anchor_fix", "模板化麦序房主播组件修复", r100, r100);
    }
}
