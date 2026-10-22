package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sg extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sg f121225a = null;

    static {
        f121225a = new sg();
    }

    public sg() {
        Boolean r100 = Boolean.TRUE;
        super("live_bottom_card_skip_visible_check", "底部卡片是否跳过可见性检查", r100, r100);
    }
}
