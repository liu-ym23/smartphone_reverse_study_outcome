package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class rp extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rp f121148a = null;

    static {
        f121148a = new rp();
    }

    public rp() {
        Boolean r100 = Boolean.FALSE;
        super("live_dylite_linkmic_open", "抖音极速版连线能力开关", r100, r100);
    }
}
