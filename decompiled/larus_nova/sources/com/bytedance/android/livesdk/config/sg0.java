package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sg0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sg0 f121226a = null;

    static {
        f121226a = new sg0();
    }

    public sg0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pinch_zoom_pk_fix", "放大模式下，PK判断fix", r100, r100);
    }
}
