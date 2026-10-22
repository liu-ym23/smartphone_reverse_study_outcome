package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public abstract class g<SUPER_STATE extends MVIState<SUPER_STATE>, STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIComposableViewModel<STATE, ACTION> implements b0<SUPER_STATE, STATE, ACTION> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.anya.internal.b f41612v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public lb.a f41613w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1<? super lb.e, Unit> f41614x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f41615y;

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final com.bytedance.android.anya.internal.b K() {
        com.bytedance.android.anya.internal.b r100 = this.f41612v;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return super.K();
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final lb.a S() {
        lb.a r100 = this.f41613w;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return super.S();
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableViewModel, com.bytedance.android.anya.BaseMVIViewModel
    public final void p0() {
        if (this.f41615y == false) goto L7;
        super.p0();
        return;
    L7:
        throw new IllegalStateException(("child node is not bound to parent: " + this).toString());
    }

    public g(Collection<? extends b0<STATE, ?, ?>> r100) {
        super(r100);
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void N0(lb.e r100) {
        Function1<? super lb.e, Unit> r101 = this.f41614x;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        super.N0(r100);
    }
}
