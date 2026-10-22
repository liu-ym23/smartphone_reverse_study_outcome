package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class l30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l30 f120651a = null;

    static {
        f120651a = new l30();
    }

    public l30() {
        Boolean r100 = Boolean.TRUE;
        super("live_interact_xplay_cancel_gift_resource_download", "弹幕玩法开播时暂停非高优礼物资源下载", r100, r100);
    }
}
