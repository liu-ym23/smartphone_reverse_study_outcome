package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class iw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iw f120483a = null;

    static {
        f120483a = new iw();
    }

    public iw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_detail_info_npe", "修复直播间内部crash", r100, r100);
    }
}
