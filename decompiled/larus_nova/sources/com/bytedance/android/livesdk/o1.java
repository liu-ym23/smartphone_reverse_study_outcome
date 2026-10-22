package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class o1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f154124a = null;

    static {
        f154124a = new o1();
    }

    public o1() {
        Boolean r100 = Boolean.TRUE;
        super("live_open_profile_method_parse_report_source", "openProfile 解析reportSource", r100, r100);
    }
}
