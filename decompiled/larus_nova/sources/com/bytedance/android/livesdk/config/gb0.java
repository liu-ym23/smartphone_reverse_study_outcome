package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class gb0 extends SSettingKey<List<? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gb0 f120266a = null;

    public gb0() {
        super("live_multi_link_gone_theme_background_layout", "多人场景需要影响主题背景uiLayout", CollectionsKt.arrayListOf(new Integer[]{66}), CollectionsKt.arrayListOf(new Integer[]{66}));
    }

    static {
        f120266a = new gb0();
    }
}
