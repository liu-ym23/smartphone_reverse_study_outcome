package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jz0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jz0 f120563a = null;

    static {
        f120563a = new jz0();
    }

    public jz0() {
        Boolean r100 = Boolean.FALSE;
        super("live_ws_private_protocol_enable", "直播长连私有协议开关", r100, r100);
    }
}
