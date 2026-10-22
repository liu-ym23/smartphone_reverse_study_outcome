package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jk0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jk0 f120533a = null;

    static {
        f120533a = new jk0();
    }

    public jk0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pre_enter_room_logic_opt", "预进房逻辑优化", r100, r100, new String[]{"true:支持逻辑优化", "false:不支持逻辑优化"});
    }
}
