package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class c80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c80 f119928a = null;

    static {
        f119928a = new c80();
    }

    public c80() {
        Boolean r100 = Boolean.TRUE;
        super("live_media_anchor_enable_digg", "媒体主播侧是否支持点赞", r100, r100);
    }
}
