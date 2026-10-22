package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hu0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hu0 f120405a = null;

    static {
        f120405a = new hu0();
    }

    public hu0() {
        Boolean r100 = Boolean.TRUE;
        super("live_tab_sync_data_change_fix_config", "直播tab内外不同流change回调fix", r100, r100, true);
    }
}
