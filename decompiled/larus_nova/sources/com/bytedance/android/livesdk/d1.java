package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f121929a = null;

    static {
        f121929a = new d1();
    }

    public d1() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_sei_harmony_fix", "SEI解析漏掉鸿蒙平台判断", r100, r100);
    }
}
