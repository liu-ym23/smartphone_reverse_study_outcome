package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rw f121162a = null;

    static {
        f121162a = new rw();
    }

    public rw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_next_prepull_stop", "解决prepull 导致未 stop 的问题", r100, r100);
    }
}
