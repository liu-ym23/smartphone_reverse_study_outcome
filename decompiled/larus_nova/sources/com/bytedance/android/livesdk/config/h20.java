package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h20 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h20 f120332a = null;

    static {
        f120332a = new h20();
    }

    public h20() {
        Boolean r100 = Boolean.FALSE;
        super("live_interaction_fragment_hide_event_bind_fix", "解决直播退房时，因为声明周期问题，交互层隐藏不执行问题", r100, r100, true);
    }
}
