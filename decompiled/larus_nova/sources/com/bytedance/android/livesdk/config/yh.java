package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yh f121688a = null;

    static {
        f121688a = new yh();
    }

    public yh() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_shared_for_audience_from_impl", "主看播解耦代码抽离", r100, r100, true);
    }
}
