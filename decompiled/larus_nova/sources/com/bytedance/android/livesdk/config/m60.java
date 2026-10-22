package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class m60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m60 f120733a = null;

    static {
        f120733a = new m60();
    }

    public m60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_dynamic_audience_show_pk", "开启浮动小窗左下角展示PK按钮优化", r100, r100);
    }
}
