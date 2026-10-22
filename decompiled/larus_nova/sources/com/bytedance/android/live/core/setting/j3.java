package com.bytedance.android.live.core.setting;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class j3 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f65331a = null;

    static {
        f65331a = new j3();
    }

    public j3() {
        super("live_offline_patterns", "离线拦截列表", new ArrayList(), new ArrayList());
    }
}
