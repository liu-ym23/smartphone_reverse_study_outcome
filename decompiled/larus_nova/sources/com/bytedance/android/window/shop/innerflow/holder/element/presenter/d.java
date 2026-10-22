package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class d<T> extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public fo.b f189144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yp3.e<T> f189145f;

    public abstract void D(T r100);

    public abstract void E();

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        E();
        fo.b r100 = this.f189144e;
        if (r100 == null) goto L5;
        r100.f478066b.clear();
        r100.f478065a.clear();
    L5:
        this.f189144e = null;
    }

    public d(yp3.e<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        this.f189145f = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (r100 == null) goto L6;
        vp3.b r101 = (vp3.b) r100;
        Object r102 = r101.b(this.f189145f);
        this.f189144e = r101.f556618a;
        D(r102);
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.entity.vo.ECWindowInnerFlowItemVO");
    }
}
