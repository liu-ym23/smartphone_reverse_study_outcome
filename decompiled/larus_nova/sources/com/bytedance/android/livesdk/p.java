package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f154187a = null;

    static {
        f154187a = new p();
    }

    public p() {
        super("live_anniex_flow_close_engine_preload_white_list", "直播路由并发加载全页关闭engine预加载白名单", new ArrayList(), new ArrayList());
    }
}
