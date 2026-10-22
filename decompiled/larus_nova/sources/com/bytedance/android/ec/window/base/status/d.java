package com.bytedance.android.ec.window.base.status;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f49707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Unit> f49708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, Unit> f49709c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<? extends T> r100, Function1<? super T, Unit> r101, Function1<? super T, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f49707a = r100;
        this.f49708b = r101;
        this.f49709c = r102;
    }
}
