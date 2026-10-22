package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseMVIComposableView<STATE extends MVIState<?>, ACTION extends p> extends BaseMVIView<STATE, ACTION> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f41520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<k<STATE>, Unit> f41521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<a0, Boolean> f41522j;

    public abstract Collection<z<STATE, ?, ?>> p();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void e() {
        Iterator r100 = ((ArrayList) ((com.bytedance.android.anya.dsl.f) this.f41520h.getValue()).f41595a).iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        com.bytedance.android.anya.dsl.j r101 = (com.bytedance.android.anya.dsl.j) r100.next();
        z<SUPER_STATE, STATE, ?> r102 = r101.f41600a;
        if (r102 == 0) goto L17;
        BaseMVIView r103 = (BaseMVIView) r102;
        Function2<i0<SUPER_STATE>, SUPER_STATE, u0<SUPER_STATE, STATE>> r104 = r101.f41601b;
        i0<STATE> r105 = this.f41539d;
        Object r106 = r104.invoke((i0<SUPER_STATE>) r105, (SUPER_STATE) n());
        if (r106 == null) goto L15;
        MVIState r107 = (MVIState) ((SubStatePropertyImpl) r106).c();
        com.bytedance.android.anya.internal.m<?, ACTION> r108 = this.f41537b;
        if (r108 == null) goto L13;
        r103.h(r107, r108);
        goto L4
    L13:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIBindingExt<com.bytedance.android.anya.MVIState<*>, com.bytedance.android.anya.MVIAction>");
    L15:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.SubStatePropertyImpl<*, *>");
    L17:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIView<com.bytedance.android.anya.MVIState<*>, com.bytedance.android.anya.MVIAction>");
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void f() {
        Iterator r100 = ((ArrayList) ((com.bytedance.android.anya.dsl.f) this.f41520h.getValue()).f41595a).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Object r101 = ((com.bytedance.android.anya.dsl.j) r100.next()).f41600a;
        if (r101 == null) goto L9;
        ((BaseMVIView) r101).j();
        goto L4
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIView<*, *>");
    }

    public BaseMVIComposableView() {
        this.f41520h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BaseMVIComposableView$registry$2(this));
        this.f41521i = (Function1<k<STATE>, Unit>) new BaseMVIComposableView$dispatchDiff$1(this);
        this.f41522j = new BaseMVIComposableView$dispatchEffect$1(this);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(a0 r100) {
        return r(r100, this.f41522j);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(k<STATE> r100, STATE r101) {
        q(r100, r101, this.f41521i);
    }

    public boolean r(a0 r100, Function1<? super a0, Boolean> r101) {
        return r101.invoke(r100).booleanValue();
    }

    public void q(k<STATE> r100, STATE r101, Function1<? super k<STATE>, Unit> r102) {
        r102.invoke(r100);
    }
}
