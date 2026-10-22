package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class wm extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wm f121537a = null;

    static {
        f121537a = new wm();
    }

    public wm() {
        Boolean r100 = Boolean.FALSE;
        super("live_decoration_show_bug_fix", "修复直播间贴纸重复上屏", r100, r100);
    }
}
