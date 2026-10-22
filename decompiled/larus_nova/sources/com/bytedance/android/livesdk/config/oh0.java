package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class oh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oh0 f120905a = null;

    static {
        f120905a = new oh0();
    }

    public oh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_single_view_overlap_check", "PK单View重叠区域检查", r100, r100);
    }
}
