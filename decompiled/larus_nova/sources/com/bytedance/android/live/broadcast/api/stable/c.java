package com.bytedance.android.live.broadcast.api.stable;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> extends AbsAnchorFactor<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<T> f59086c;

    @Override // com.bytedance.android.live.broadcast.api.stable.AbsAnchorFactor
    public final T b() {
        return this.f59086c.invoke();
    }

    @Override // com.bytedance.android.live.broadcast.api.stable.AbsAnchorFactor
    public final String a() {
        return this.f59085b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueGetter");
        this.f59085b = r100;
        this.f59086c = r101;
    }
}
