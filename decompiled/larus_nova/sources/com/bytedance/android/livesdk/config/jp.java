package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class jp extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jp f120542a = null;

    static {
        f120542a = new jp();
    }

    public jp() {
        super("live_drawer_need_replace_feed", "是否用外部接口替换推荐", new ArrayList(), CollectionsKt.mutableListOf(new String[]{"homepage_fresh*", "homepage_hot_video_head", "homepage_hot_live_cell"}));
    }
}
