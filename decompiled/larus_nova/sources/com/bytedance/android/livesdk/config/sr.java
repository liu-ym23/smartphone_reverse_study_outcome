package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sr f121247a = null;

    static {
        f121247a = new sr();
    }

    public sr() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_follow_status_use_local_db", "关注状态发生错误时是否使用兜底IM数据库", r100, r100);
    }
}
