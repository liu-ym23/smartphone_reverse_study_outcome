package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8 f102998a = null;

    static {
        f102998a = new a8();
    }

    public a8() {
        Boolean r100 = Boolean.TRUE;
        super("live_toolbar_manager_lite_fix_on_hide", "toolbar旧版onhide修复", r100, r100);
    }
}
