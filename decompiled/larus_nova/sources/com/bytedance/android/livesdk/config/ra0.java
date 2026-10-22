package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ra0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ra0 f121116a = null;

    static {
        f121116a = new ra0();
    }

    public ra0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_anchor_sei_load_backup_enable", "多人主播连线场景sei兜底加载", r100, r100);
    }
}
