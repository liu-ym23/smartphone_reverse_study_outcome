package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vr f121472a = null;

    static {
        f121472a = new vr();
    }

    public vr() {
        Boolean r100 = Boolean.FALSE;
        super("live_gradient_adaptive_enable", "直播间蒙层透明度自适应", r100, r100);
    }
}
