package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y7 f162551a = null;

    static {
        f162551a = new y7();
    }

    public y7() {
        Boolean r100 = Boolean.FALSE;
        super("live_toolbar_check_remove_same_slot_open", "toolbar检查时移除同槽位delay操作", r100, r100);
    }
}
