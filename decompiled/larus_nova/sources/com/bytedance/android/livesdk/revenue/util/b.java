package com.bytedance.android.livesdk.revenue.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f157529a;

    @Override // com.bytedance.android.livesdk.revenue.util.a
    public final T k() {
        return this.f157529a;
    }

    public b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "realInstance");
        this.f157529a = r100;
    }
}
