package com.bytedance.android.livesdk.revenue.util;

import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h<T, U> extends k<T, U> implements m<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<T> f157538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, U> f157539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<U, T> f157540d;

    @Override // com.bytedance.live.datacontext.m, com.bytedance.live.datacontext.l
    public final Observable a() {
        return this.f157538b.a().map(new g(this));
    }

    @Override // com.bytedance.live.datacontext.l
    public final U getValue() {
        return f(this.f157538b.getValue(), this.f157539c);
    }

    @Override // com.bytedance.live.datacontext.l
    public final void setValue(U r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f157545a = null;
        this.f157538b.setValue(this.f157540d.invoke(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(m<T> r100, Function1<? super T, ? extends U> r101, Function1<? super U, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        Intrinsics.checkNotNullParameter(r102, "inverseTransformer");
        this.f157538b = r100;
        this.f157539c = r101;
        this.f157540d = r102;
    }
}
