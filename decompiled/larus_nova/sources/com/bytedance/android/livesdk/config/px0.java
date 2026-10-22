package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class px0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final px0 f121014a = null;

    static {
        f121014a = new px0();
    }

    public px0() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_substream_default_resolution", "VR副机位是否使用副流的启播清晰度", r100, r100);
    }
}
