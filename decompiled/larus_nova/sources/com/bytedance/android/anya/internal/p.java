package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.m0;
import com.bytedance.android.anya.n0;
import com.bytedance.android.anya.u0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MVIState<?> f41701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f41702b;

    public static final class a<E extends MVIState<?>> implements m0<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<E> f41703a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends E> r100) {
            this.f41703a = r100;
        }
    }

    public static final class b<T extends com.bytedance.android.anya.v<?, E>, E> implements n0<T, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<T> f41704a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<? extends T> r100) {
            this.f41704a = r100;
        }
    }

    public final a c(Class r100) {
        p r101 = this.f41702b;
    L3:
        if (r101 == null) goto L10;
        final MVIState<?> r102 = r101.f41701a;
        if (Intrinsics.areEqual(r102.getClass(), r100) == true) goto L7;
        r101 = r101.f41702b;
        goto L3
    L7:
        return new a(new ReduceContextImpl$parentStateOfType$1(r102));
    L10:
        return new a(ReduceContextImpl$parentStateOfType$2.INSTANCE);
    }

    public final b d(final u0 r100) {
        return new b(new ReduceContextImpl$toNode$1(r100));
    }

    public p(MVIState<?> r100, p r101) {
        this.f41701a = r100;
        this.f41702b = r101;
    }

    public final b a(final n0 r100, final Function1 r101) {
        b r102 = (b) r100;
        return new b(new ReduceContextImpl$get$1(r100, r101));
    }

    public final b b(final a r100, final Function1 r101) {
        return new b(new ReduceContextImpl$get$3(r100, r101));
    }
}
