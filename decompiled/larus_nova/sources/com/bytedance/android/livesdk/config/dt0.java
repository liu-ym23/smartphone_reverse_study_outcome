package com.bytedance.android.livesdk.config;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class dt0 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dt0 f120063a = null;

    static {
        f120063a = new dt0();
    }

    public dt0() {
        List<String> r100 = d81.f120007b;
        super("live_start_float_window_access_list", "小窗调用方", r100, r100);
    }
}
