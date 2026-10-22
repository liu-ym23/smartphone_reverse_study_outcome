package com.bytedance.android.livesdk.revenue.util;

import io.reactivex.Maybe;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ConstantNullableTransformer<T, U> extends k<T, U> implements com.bytedance.live.datacontext.j<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.live.datacontext.j<T> f157526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, U> f157527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<U, T> f157528d;

    @Override // com.bytedance.live.datacontext.j
    public final Maybe b() {
        return this.f157526b.b().map(new e(this));
    }

    @Override // com.bytedance.live.datacontext.h
    public final U getValue() {
        T r100 = this.f157526b.getValue();
        if (r100 == null) goto L6;
        U r101 = f(r100, this.f157527c);
        if (r101 == null) goto L6;
        return r101;
    L6:
        this.f157545a = null;
        return null;
    }

    @Override // com.bytedance.live.datacontext.h
    public final boolean hasValue() {
        return this.f157526b.hasValue();
    }

    @Override // com.bytedance.live.datacontext.j
    public final void c(final Function1<? super U, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f157526b.c((Function1<? super T, Unit>) new ConstantNullableTransformer$use$1(this, r100));
    }

    @Override // com.bytedance.live.datacontext.h
    public final boolean d(U r100) {
        com.bytedance.live.datacontext.j<T> r101 = this.f157526b;
        if (r100 == null) goto L5;
        T r102 = this.f157528d.invoke(r100);
    L6:
        boolean r103 = r101.d(r102);
        if (r103 == false) goto L9;
        this.f157545a = null;
    L9:
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.live.datacontext.h
    public final boolean e(final Function0<? extends U> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        boolean r101 = this.f157526b.e((Function0<? extends T>) new ConstantNullableTransformer$setOnce$2(this, r100));
        if (r101 == false) goto L5;
        this.f157545a = null;
    L5:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConstantNullableTransformer(com.bytedance.live.datacontext.j<T> r100, Function1<? super T, ? extends U> r101, Function1<? super U, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        Intrinsics.checkNotNullParameter(r102, "inverseTransformer");
        this.f157526b = r100;
        this.f157527c = r101;
        this.f157528d = r102;
    }
}
