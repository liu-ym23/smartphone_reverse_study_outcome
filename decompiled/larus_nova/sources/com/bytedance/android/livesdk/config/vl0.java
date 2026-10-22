package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vl0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vl0 f121461a = null;

    static {
        f121461a = new vl0();
    }

    public vl0() {
        super("live_radio_interact_enable", Boolean.TRUE, "语音直播间是否显示连麦开关", new String[]{"true:显示", "false:不显示"});
    }
}
