package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f159240a = null;

    static {
        f159240a = new v2();
    }

    public v2() {
        Boolean r100 = Boolean.TRUE;
        super("live_share_in_more_panel_ban_im_title", "更多面板不展示im标题", r100, r100);
    }
}
