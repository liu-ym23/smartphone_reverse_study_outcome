package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xh f121603a = null;

    static {
        f121603a = new xh();
    }

    public xh() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_restart_popup_enable", "是否允许popuowindow提醒", r100, r100);
    }
}
