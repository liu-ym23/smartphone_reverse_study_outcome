package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rz extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rz f121168a = null;

    static {
        f121168a = new rz();
    }

    public rz() {
        Boolean r100 = Boolean.TRUE;
        super("live_h5_share_with_im_extra", "h5分享是否透传imExtra字段", r100, r100);
    }
}
