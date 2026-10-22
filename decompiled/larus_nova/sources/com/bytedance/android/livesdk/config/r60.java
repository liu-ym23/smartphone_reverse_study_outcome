package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class r60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r60 f121105a = null;

    static {
        f121105a = new r60();
    }

    public r60() {
        Boolean r100 = Boolean.FALSE;
        super("live_link_multi_enlarge_relist_enable", "主咖模式下端上是否需要进行重排序", r100, r100);
    }
}
