package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cf1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cf1 f119944a = null;

    static {
        f119944a = new cf1();
    }

    public cf1() {
        Boolean r100 = Boolean.TRUE;
        super("report_opt_config", "举报优化开关（跳过不喜欢直播间）", r100, r100);
    }
}
