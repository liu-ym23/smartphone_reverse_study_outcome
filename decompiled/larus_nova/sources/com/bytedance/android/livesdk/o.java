package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f154122a = null;

    static {
        f154122a = new o();
    }

    public o() {
        super("live_anniex_flow_black_list", "直播路由并发加载全页黑名单", new ArrayList(), new ArrayList());
    }
}
