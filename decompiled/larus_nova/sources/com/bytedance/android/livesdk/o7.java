package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class o7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o7 f154130a = null;

    static {
        f154130a = new o7();
    }

    public o7() {
        Boolean r100 = Boolean.TRUE;
        super("live_rev_guest_observer_pk_layout", "嘉宾连麦监听PK布局变化", r100, r100);
    }
}
