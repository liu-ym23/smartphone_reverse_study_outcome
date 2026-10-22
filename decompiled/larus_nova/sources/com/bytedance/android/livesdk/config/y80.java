package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class y80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y80 f121665a = null;

    static {
        f121665a = new y80();
    }

    public y80() {
        Boolean r100 = Boolean.TRUE;
        super("live_mg_component_preload", "直播间多实例toolbar预加载小游戏", r100, r100);
    }
}
