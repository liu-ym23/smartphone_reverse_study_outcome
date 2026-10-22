package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jf1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jf1 f120522a = null;

    static {
        f120522a = new jf1();
    }

    public jf1() {
        Boolean r100 = Boolean.FALSE;
        super("room_stop_opt_not_limit_scene", "直播兜底退房逻辑不限制场景", r100, r100, true);
    }
}
