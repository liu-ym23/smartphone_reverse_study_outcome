package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rb0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rb0 f121119a = null;

    static {
        f121119a = new rb0();
    }

    public rb0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_receive_finish_ignore_backend", "多人场景关播后屏蔽backend", r100, r100);
    }
}
