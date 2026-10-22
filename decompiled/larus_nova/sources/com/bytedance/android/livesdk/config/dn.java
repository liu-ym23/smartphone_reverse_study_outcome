package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dn extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dn f120050a = null;

    static {
        f120050a = new dn();
    }

    public dn() {
        Boolean r100 = Boolean.FALSE;
        super("live_detail_pre_enter_room", "混滑场景预请求", r100, r100, new String[]{"true:使用预请求", "false:不使用预请求"});
    }
}
