package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zf f121758a = null;

    static {
        f121758a = new zf();
    }

    public zf() {
        Boolean r100 = Boolean.TRUE;
        super("live_background_network_change_cut", "内流直播间后台状态网络切换为移动数据时断流", r100, r100);
    }
}
