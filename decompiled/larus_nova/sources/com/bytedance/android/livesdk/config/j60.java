package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class j60 extends SSettingKey<List<? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j60 f120502a = null;

    static {
        f120502a = new j60();
    }

    public j60() {
        super("live_link_audio_metric_disable_scene_list", "RTC音质打分场景黑名单", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
