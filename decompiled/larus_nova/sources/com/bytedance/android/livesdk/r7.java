package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class r7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r7 f156936a = null;

    static {
        f156936a = new r7();
    }

    public r7() {
        Boolean r100 = Boolean.TRUE;
        super("live_single_line_dialog_keyboard_opt", "屏蔽词弹窗优化键盘策略", r100, r100);
    }
}
