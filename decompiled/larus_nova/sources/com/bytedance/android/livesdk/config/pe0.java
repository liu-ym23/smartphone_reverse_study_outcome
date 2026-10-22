package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pe0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pe0 f120973a = null;

    static {
        f120973a = new pe0();
    }

    public pe0() {
        Boolean r100 = Boolean.FALSE;
        super("live_option_dialog_show_report", "直播间长按中的举报选项开关", r100, r100, new String[]{"true:开启", "false:关闭"});
    }
}
