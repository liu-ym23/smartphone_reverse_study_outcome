package com.bytedance.android.anniex.base.depend;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f40275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f40276b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f40277c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f40278d = null;

    static {
        f40275a = LazyKt.lazy(AnnieXRuntime$hostDepend$2.INSTANCE);
        f40276b = LazyKt.lazy(AnnieXRuntime$salamanderDepend$2.INSTANCE);
        f40277c = LazyKt.lazy(AnnieXRuntime$applicationDepend$2.INSTANCE);
        f40278d = LazyKt.lazy(AnnieXRuntime$deviceDepend$2.INSTANCE);
    }

    public static ApplicationDepend a() {
        return (ApplicationDepend) f40277c.getValue();
    }

    public static DeviceDepend b() {
        return (DeviceDepend) f40278d.getValue();
    }
}
