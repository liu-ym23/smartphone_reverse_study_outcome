package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class q extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f156872a = null;

    static {
        f156872a = new q();
    }

    public q() {
        super("live_anniex_flow_white_list", "直播路由并发加载全页白名单", new ArrayList(), new ArrayList());
    }
}
