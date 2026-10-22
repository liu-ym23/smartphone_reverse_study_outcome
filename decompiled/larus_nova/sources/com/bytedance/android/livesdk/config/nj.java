package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nj f120837a = null;

    static {
        f120837a = new nj();
    }

    public nj() {
        Boolean r100 = Boolean.TRUE;
        super("live_sdk_cast_screen_phone_adapter_type_setting", "直播间投屏弹窗部分机型跳动问题（黑名单开关）", r100, r100, true);
    }
}
