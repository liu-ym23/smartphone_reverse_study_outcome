package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class up0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final up0 f121392a = null;

    static {
        f121392a = new up0();
    }

    public up0() {
        Boolean r100 = Boolean.TRUE;
        super("live_scale_xy_ratio_on_mobile", "直播ViewCropper在移动端仅使用scaleXY进行等比例缩放", r100, r100);
    }
}
