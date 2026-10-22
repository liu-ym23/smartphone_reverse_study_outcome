package com.bytedance.android.anniex.lite.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f40951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f40952b = null;

    public AnnieXSettings() {
    }

    static {
        f40951a = LazyKt.lazy(AnnieXSettings$optimizeBulletInit$2.INSTANCE);
        f40952b = LazyKt.lazy(AnnieXSettings$optimizeWebcastInit$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) f40951a.getValue()).booleanValue();
    }
}
