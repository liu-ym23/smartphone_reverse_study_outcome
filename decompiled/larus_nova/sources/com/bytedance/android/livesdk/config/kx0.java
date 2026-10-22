package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kx0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kx0 f120636a = null;

    static {
        f120636a = new kx0();
    }

    public kx0() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_camera_replace", "VR直播间副机位是否直接替换ContentType", r100, r100);
    }
}
