package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class f7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f7 f123405a = null;

    static {
        f123405a = new f7();
    }

    public f7() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_disable_scroll_room", "公屏容器区域禁止直播间上下滑", r100, r100);
    }
}
