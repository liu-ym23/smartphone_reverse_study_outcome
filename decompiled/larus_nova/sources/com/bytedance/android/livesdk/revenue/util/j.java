package com.bytedance.android.livesdk.revenue.util;

import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j<T, U> extends k<T, U> implements n<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<T> f157542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, U> f157543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<U, T> f157544d;

    @Override // com.bytedance.live.datacontext.n, com.bytedance.live.datacontext.l
    public final Observable a() {
        return this.f157542b.a().map(new i(this));
    }

    @Override // com.bytedance.live.datacontext.l
    public final U getValue() {
        T r100 = this.f157542b.getValue();
        if (r100 == null) goto L6;
        U r101 = f(r100, this.f157543c);
        if (r101 == null) goto L6;
        return r101;
    L6:
        this.f157545a = null;
        return null;
    }

    @Override // com.bytedance.live.datacontext.l
    public final void setValue(U r100) {
        T r101 = null;
        this.f157545a = null;
        n<T> r102 = this.f157542b;
        if (r100 == null) goto L5;
        r101 = this.f157544d.invoke(r100);
    L5:
        r102.setValue(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(n<T> r100, Function1<? super T, ? extends U> r101, Function1<? super U, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        Intrinsics.checkNotNullParameter(r102, "inverseTransformer");
        this.f157542b = r100;
        this.f157543c = r101;
        this.f157544d = r102;
    }
}
