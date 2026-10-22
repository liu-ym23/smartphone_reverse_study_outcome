package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class ad0 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ad0 f119780a = null;

    static {
        f119780a = new ad0();
    }

    public ad0() {
        super("live_new_panel_allow_list", new ArrayList(), "直播新面板h5白名单");
    }
}
