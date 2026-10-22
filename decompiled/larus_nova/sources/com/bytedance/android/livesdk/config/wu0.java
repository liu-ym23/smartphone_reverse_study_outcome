package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class wu0 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wu0 f121554a = null;

    static {
        f121554a = new wu0();
    }

    public wu0() {
        super("live_toolbar_chache_black_list", "Toolbarwidget view cache blacklist", new ArrayList(), new ArrayList());
    }
}
