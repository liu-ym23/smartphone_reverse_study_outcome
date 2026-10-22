package com.bytedance.android.shopping.buynow.opt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f171034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f171035c;

    public e(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter("assetsSeq", "name");
        this.f171034b = r100;
        this.f171035c = "assetsSeq";
        this.f171033a = LazyKt.lazy(new Field$field$2(this));
    }
}
