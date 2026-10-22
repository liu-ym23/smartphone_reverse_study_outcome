package com.bytedance.android.shopping.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class LargeFontModeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f187028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f187029b = null;

    static {
        f187028a = LazyKt.lazy(LargeFontModeUtil$enlargeScale$2.INSTANCE);
        f187029b = LazyKt.lazy(LargeFontModeUtil$expSwitch$2.INSTANCE);
    }

    public static float a() {
        if (((Number) f187029b.getValue()).intValue() == 1) goto L7;
        return 1.0f;
    L7:
        return ((Number) f187028a.getValue()).floatValue();
    }
}
