package com.bytedance.android.live.profit.dress.config;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class x extends DressResource {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f87100i = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f87101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f87102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f87103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f87104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f87105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.profit.dress.v f87106h;

    static {
        f87100i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "parallaxAsset", "getParallaxAsset()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "panelExitWebp", "getPanelExitWebp()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "borderEnterWebp", "getBorderEnterWebp()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "borderLoopWebp", "getBorderLoopWebp()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "flashCardAsset", "getFlashCardAsset()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0))};
    }

    public final void d(DressResource.a<? extends py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f87103e.put(f87100i[2].getName(), r100);
    }

    public final void e(DressResource.a<? extends py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f87104f.put(f87100i[3].getName(), r100);
    }

    public final void f(DressResource.a<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f87105g.put(f87100i[4].getName(), r100);
    }

    public final void g(DressResource.a<? extends py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f87102d.put(f87100i[1].getName(), r100);
    }

    public final void h(DressResource.a<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f87101c.put(f87100i[0].getName(), r100);
    }

    public x(com.bytedance.android.live.profit.dress.v r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f87106h = r100;
        Map<String, DressResource.a<?>> r101 = this.f87083a;
        this.f87101c = r101;
        this.f87102d = r101;
        this.f87103e = r101;
        this.f87104f = r101;
        this.f87105g = r101;
    }
}
