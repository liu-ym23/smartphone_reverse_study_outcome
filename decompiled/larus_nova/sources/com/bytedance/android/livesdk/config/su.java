package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class su extends SSettingKey<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su f121253a = null;

    static {
        f121253a = new su();
    }

    public su() {
        super("live_enter_split_entrance", "进房接口拆分的生效入口", CollectionsKt.mutableListOf(new String[]{"homepage_hot-live_cell", "homepage_hot-video_head", "recommend-video_head", "recommend-live_cell"}), CollectionsKt.mutableListOf(new String[]{"homepage_hot-live_cell", "homepage_hot-video_head", "recommend-video_head", "recommend-live_cell"}));
    }
}
