package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class x70 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x70 f121581a = null;

    static {
        f121581a = new x70();
    }

    public x70() {
        Boolean r100 = Boolean.FALSE;
        super("live_matrix_support_cur_app", "当前宿主是否支持关联矩阵", r100, r100);
    }
}
