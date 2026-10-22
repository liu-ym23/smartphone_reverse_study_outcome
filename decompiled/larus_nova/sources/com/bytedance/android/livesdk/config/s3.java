package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class s3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f121179a = null;

    static {
        f121179a = new s3();
    }

    public s3() {
        Boolean r100 = Boolean.TRUE;
        super("enable_live_vr_gesture_drag_view_new", "是否使用新的VR直播间手势拖动视角版本", r100, r100);
    }
}
