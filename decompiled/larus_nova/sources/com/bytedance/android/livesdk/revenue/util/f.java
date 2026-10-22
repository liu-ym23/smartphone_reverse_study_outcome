package com.bytedance.android.livesdk.revenue.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class f<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f157536a;

    @Override // com.bytedance.android.livesdk.revenue.util.a
    public T k() {
        return this.f157536a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "getInstance");
        this.f157536a = r100;
    }
}
