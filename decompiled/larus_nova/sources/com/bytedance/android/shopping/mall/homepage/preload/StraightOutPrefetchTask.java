package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
public final class StraightOutPrefetchTask extends com.bytedance.android.shopping.mall.homepage.preload.a<Pair<? extends HomePageDTO, ? extends com.bytedance.android.ec.hybrid.list.entity.k>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f178381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f178382b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f178383c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f178384d = null;

    public static final class a {
    }

    static {
        new LinkedHashMap();
        new LinkedHashMap();
        f178381a = LazyKt.lazy(StraightOutPrefetchTask$Companion$imagePrefetchOpt$2.INSTANCE);
        f178382b = LazyKt.lazy(StraightOutPrefetchTask$Companion$imagePrefetchStrategy$2.INSTANCE);
        f178383c = LazyKt.lazy(StraightOutPrefetchTask$Companion$domainConnectOptEnable$2.INSTANCE);
        f178384d = LazyKt.lazy(StraightOutPrefetchTask$Companion$preloadCacheDataStrategy$2.INSTANCE);
    }
}
