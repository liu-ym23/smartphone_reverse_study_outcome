package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xc0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xc0 f121593a = null;

    static {
        f121593a = new xc0();
    }

    public xc0() {
        Boolean r100 = Boolean.TRUE;
        super("live_new_live_stream_not_transparent_before_android_9", "新版音画链路复用透明不在9及更老版本生效", r100, r100, true);
    }
}
