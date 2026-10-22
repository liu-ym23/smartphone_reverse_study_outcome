package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class w3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w3 f160652a = null;

    static {
        f160652a = new w3();
    }

    public w3() {
        Boolean r100 = Boolean.FALSE;
        super("enable_switch_default_resolution", "启用进房清晰度切档", r100, r100);
    }
}
