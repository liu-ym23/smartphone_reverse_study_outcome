package com.bytedance.android.live.revenue.common.reactive;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T, R> implements e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f90976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f90977b;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.common.reactive.a$a, reason: collision with other inner class name */
    public static final class C1398a<T, R> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<R> f90978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<T, R> f90979b;

        @Override // com.bytedance.android.live.revenue.common.reactive.f
        public final void a(T r100) {
            this.f90978a.a(this.f90979b.invoke(r100));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C1398a(f<R> r100, Function1<? super T, ? extends R> r101) {
            Intrinsics.checkNotNullParameter(r100, "original");
            Intrinsics.checkNotNullParameter(r101, "mapper");
            this.f90978a = r100;
            this.f90979b = r101;
        }
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final R getValue() {
        return (R) this.f90977b.invoke(this.f90976a.getValue());
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final Disposable a(f<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return this.f90976a.a(new C1398a(r100, this.f90977b));
    }

    public a(c r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "mapper");
        this.f90976a = r100;
        this.f90977b = r101;
    }
}
