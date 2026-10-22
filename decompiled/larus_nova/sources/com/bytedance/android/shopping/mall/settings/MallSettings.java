package com.bytedance.android.shopping.mall.settings;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class MallSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f178584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f178585b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f178586c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f178587d = null;

    public static boolean a() {
        return ((Boolean) f178584a.getValue()).booleanValue();
    }

    static {
        f178584a = LazyKt.lazy(MallSettings$mallMemoryOptEnable$2.INSTANCE);
        f178585b = LazyKt.lazy(MallSettings$fixChunkMemoryLeak$2.INSTANCE);
        f178586c = LazyKt.lazy(MallSettings$mallFeedSupportSplitScreen$2.INSTANCE);
        f178587d = LazyKt.lazy(MallSettings$mallFeedComponentV3Enable$2.INSTANCE);
    }
}
