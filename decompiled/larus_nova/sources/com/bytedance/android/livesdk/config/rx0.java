package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rx0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rx0 f121165a = null;

    static {
        f121165a = new rx0();
    }

    public rx0() {
        Boolean r100 = Boolean.FALSE;
        super("live_vr_use_new_gesture", "VR直播间是否开启清屏模式支持手势拖拽 && 非清屏模式（VR模式除外）关闭手势拖拽", r100, r100);
    }
}
