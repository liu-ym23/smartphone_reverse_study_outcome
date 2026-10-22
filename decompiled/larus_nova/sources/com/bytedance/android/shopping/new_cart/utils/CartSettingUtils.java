package com.bytedance.android.shopping.new_cart.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class CartSettingUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f179349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f179350b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f179351c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f179352d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f179353e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f179354f = null;

    public static boolean a() {
        return ((Boolean) f179354f.getValue()).booleanValue();
    }

    public static boolean b() {
        return ((Boolean) f179353e.getValue()).booleanValue();
    }

    static {
        f179349a = LazyKt.lazy(CartSettingUtils$sliceElementReuse$2.INSTANCE);
        f179350b = LazyKt.lazy(CartSettingUtils$textPoolSize$2.INSTANCE);
        f179351c = LazyKt.lazy(CartSettingUtils$imagePoolSize$2.INSTANCE);
        f179352d = LazyKt.lazy(CartSettingUtils$viewPoolSize$2.INSTANCE);
        f179353e = LazyKt.lazy(CartSettingUtils$enableLargeTextMode$2.INSTANCE);
        f179354f = LazyKt.lazy(CartSettingUtils$enableFooterRoundCorner$2.INSTANCE);
    }
}
