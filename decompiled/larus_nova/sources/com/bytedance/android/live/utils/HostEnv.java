package com.bytedance.android.live.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class HostEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f102533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f102534b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f102535c = null;

    public static boolean a() {
        return ((Boolean) f102534b.getValue()).booleanValue();
    }

    public static boolean b() {
        return ((Boolean) f102533a.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) f102535c.getValue()).booleanValue();
    }

    static {
        f102533a = LazyKt.lazy(HostEnv$isDouYin$2.INSTANCE);
        f102534b = LazyKt.lazy(HostEnv$isDouLite$2.INSTANCE);
        f102535c = LazyKt.lazy(HostEnv$isHotSoon$2.INSTANCE);
    }
}
