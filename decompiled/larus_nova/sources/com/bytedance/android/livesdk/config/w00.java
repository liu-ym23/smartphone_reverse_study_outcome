package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class w00 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w00 f121490a = null;

    static {
        f121490a = new w00();
    }

    public w00() {
        Boolean r100 = Boolean.TRUE;
        super("live_image_picker_permission_check_enable", "系统图片资源权限申请配置", r100, r100);
    }
}
