package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class r70 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r70 f121108a = null;

    static {
        f121108a = new r70();
    }

    public r70() {
        super("live_lynx_online_fallback_path_list", "Lynx非离线化时走fallback逻辑", new ArrayList(), new ArrayList());
    }
}
