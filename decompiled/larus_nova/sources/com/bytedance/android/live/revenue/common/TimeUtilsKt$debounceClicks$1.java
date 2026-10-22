package com.bytedance.android.live.revenue.common;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class TimeUtilsKt$debounceClicks$1 extends MutablePropertyReference0Impl {
    public static final KMutableProperty0 INSTANCE = null;

    static {
        INSTANCE = new TimeUtilsKt$debounceClicks$1();
    }

    public TimeUtilsKt$debounceClicks$1() {
        super(t0.class, "globalLastClickTime", "getGlobalLastClickTime()Lcom/bytedance/android/live/revenue/common/TimeVal;", 1);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return t0.f90994a;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        t0.f90994a = (u0) r100;
    }
}
