package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wb0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wb0 f121512a = null;

    static {
        f121512a = new wb0();
    }

    public wb0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_send_guest_list_opt", "非空麦位列表时才发guest_list事件", r100, r100);
    }
}
