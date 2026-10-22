package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nf0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nf0 f120828a = null;

    static {
        f120828a = new nf0();
    }

    public nf0() {
        Boolean r100 = Boolean.TRUE;
        super("live_parse_panel_type_on_click", "是否在onclick时获取分享面板类型", r100, r100);
    }
}
