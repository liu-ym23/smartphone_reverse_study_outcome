package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l0<STATE extends MVIState<?>> extends h<STATE, l0<STATE>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public STATE f41741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0<STATE, ?> f41742b;

    @AnyaDSL
    public static final class a<T extends MVIState<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f41743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0<T> f41744b;

        public a(T r100, l0<T> r101) {
            this.f41743a = r100;
            this.f41744b = r101;
        }
    }

    public l0() {
        this(0);
    }

    public final STATE f() {
        STATE r100 = this.f41741a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L5:
        return r100;
    }

    public /* synthetic */ l0(int r100) {
        this(new k0.a());
    }

    public static void d(t0 r100) {
        ((e0) ((com.bytedance.android.anya.internal.u) r100).c()).clear();
    }

    public final <T extends MVIState<?>> r i(T r100) {
        k0<STATE, ?> r101 = this.f41742b;
        if (r101 == null) goto L7;
        return r100.toBusinessState(r101);
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.ReadOnlyStateContext<STATE, *>");
    }

    public l0(k0<STATE, ?> r100) {
        this.f41742b = r100;
    }

    public static void c(t0 r100, Collection r101) {
        ((e0) ((com.bytedance.android.anya.internal.u) r100).c()).addAll(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(t0 r100, int r101) {
        return new a((MVIState) ((com.bytedance.android.anya.internal.u) r100).c().get(r101), new l0(0));
    }

    public static void g(t0 r100, List r101) {
        ((e0) ((com.bytedance.android.anya.internal.u) r100).c()).q(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(r0 r100, Object r101) {
        ((com.bytedance.android.anya.internal.c) r100).a(r101);
    }
}
