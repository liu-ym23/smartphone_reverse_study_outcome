package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vd0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vd0 f121440a = null;

    static {
        f121440a = new vd0();
    }

    public vd0() {
        Boolean r100 = Boolean.TRUE;
        super("live_open_game_scope_switch", "是否打开客户单 scope 校验", r100, r100);
    }
}
