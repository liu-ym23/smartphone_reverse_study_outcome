package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class m1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f65356a = null;

    static {
        f65356a = new m1();
    }

    public m1() {
        Boolean r100 = Boolean.FALSE;
        super("live_fast_open_video_talk_pk_icon_opt", "开播页一键开启聊天室PK按钮可见性bugfix", r100, r100);
    }
}
