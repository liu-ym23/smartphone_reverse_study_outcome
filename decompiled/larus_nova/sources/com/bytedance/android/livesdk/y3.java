package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y3 f162547a = null;

    static {
        f162547a = new y3();
    }

    public y3() {
        Boolean r100 = Boolean.FALSE;
        super("fetch_in_room_action_enable", "是否加载FetchAction", r100, r100);
    }
}
