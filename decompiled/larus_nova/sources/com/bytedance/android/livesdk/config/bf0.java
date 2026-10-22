package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bf0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bf0 f119863a = null;

    static {
        f119863a = new bf0();
    }

    public bf0() {
        Boolean r100 = Boolean.TRUE;
        super("live_page_restore_preview", "非开播状态下的直播页面重建", r100, r100);
    }
}
