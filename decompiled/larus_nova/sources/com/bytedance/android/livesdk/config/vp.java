package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class vp extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vp f121468a = null;

    static {
        f121468a = new vp();
    }

    public vp() {
        Boolean r100 = Boolean.TRUE;
        super("live_dynamic_item_behavior_fix_red_dot", "主播关闭送礼功能后拦截玩法入口点击", r100, r100);
    }
}
