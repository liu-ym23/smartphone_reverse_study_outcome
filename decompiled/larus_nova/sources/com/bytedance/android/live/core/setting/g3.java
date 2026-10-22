package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f65305a = null;

    static {
        f65305a = new g3();
    }

    public g3() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_voice_chat_pk_interaction_behavior_bugfix", "语音电台开启PK连线Icon跳变问题", r100, r100);
    }
}
