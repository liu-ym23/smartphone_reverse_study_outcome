package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class h71 extends SettingKey<List<? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h71 f120346a = null;

    static {
        f120346a = new h71();
    }

    public h71() {
        super("live_preview_toolbar_data_filters", "预览流组件过滤兜底", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
