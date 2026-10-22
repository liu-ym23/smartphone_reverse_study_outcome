package com.bytedance.android.shopping.buynow.opt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f171037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f171038c;

    public f(Class r100, final Class... r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter("getThemeResId", "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f171037b = r100;
        this.f171038c = "getThemeResId";
        this.f171036a = LazyKt.lazy(new Method$method$2(this, r101));
    }
}
