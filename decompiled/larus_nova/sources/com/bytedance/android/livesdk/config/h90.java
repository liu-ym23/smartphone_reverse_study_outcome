package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h90 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h90 f120354a = null;

    static {
        f120354a = new h90();
    }

    public h90() {
        Boolean r100 = Boolean.TRUE;
        super("live_miniapp_talent_mount_module_show", "小程序直播达人挂载功能-任务推广模块", r100, r100, new String[]{"true:展示", "false:隐藏"});
    }
}
