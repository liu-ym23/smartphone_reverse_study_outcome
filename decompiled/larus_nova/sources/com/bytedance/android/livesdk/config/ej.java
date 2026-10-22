package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ej extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ej f120131a = null;

    static {
        f120131a = new ej();
    }

    public ej() {
        Boolean r100 = Boolean.TRUE;
        super("live_camera_permission_fix", "相机权限问题处理", r100, r100);
    }
}
