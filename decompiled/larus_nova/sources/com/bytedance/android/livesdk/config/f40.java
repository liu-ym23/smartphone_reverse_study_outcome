package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class f40 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f40 f120175a = null;

    static {
        f120175a = new f40();
    }

    public f40() {
        Boolean r100 = Boolean.TRUE;
        super("live_ktv_chorus_entry_enable", "控制特定 app 是否支持显示加入合唱入口", r100, r100);
    }
}
