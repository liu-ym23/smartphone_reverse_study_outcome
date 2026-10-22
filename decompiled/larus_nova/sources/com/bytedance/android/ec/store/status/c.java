package com.bytedance.android.ec.store.status;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f48654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Unit> f48655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, Unit> f48656c;

    public c() {
        throw null;
    }

    public c(Function0 r100, Function1 r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f48654a = r100;
        this.f48655b = r101;
        this.f48656c = null;
    }
}
