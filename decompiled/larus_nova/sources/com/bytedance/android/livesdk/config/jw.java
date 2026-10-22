package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jw f120556a = null;

    static {
        f120556a = new jw();
    }

    public jw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_end_once_error", "修复endOnce状态错误问题", r100, r100, true);
    }
}
