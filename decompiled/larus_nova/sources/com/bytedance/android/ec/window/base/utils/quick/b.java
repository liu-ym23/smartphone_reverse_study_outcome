package com.bytedance.android.ec.window.base.utils.quick;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T extends QModel> implements QIPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a<T, ? extends QModel>> f49764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f49765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49766c;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void unbind() {
        if (this.f49766c == false) goto L11;
        Iterator<a<T, ? extends QModel>> r100 = this.f49764a.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        r100.next().f49762a.unbind();
        goto L6
    L8:
        this.f49766c = false;
        return;
    }

    public b() {
        this.f49764a = new ArrayList();
        this.f49765b = new ArrayList();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final boolean H() {
        return this.f49766c;
    }

    public final void a(QIPresenter r100) {
        Intrinsics.checkNotNullParameter(r100, "presenter");
        c(r100, ECWindowGroupPresenter$add$1.INSTANCE);
    }

    public final void b(QIPresenter r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "presenter");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        c(r100, r101);
    }

    public final void c(QIPresenter r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "presenter");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        this.f49764a.add(new a(r100, r101));
        this.f49765b.add(0);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void J(QModel r100, View r101, QUIManager r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        int r103 = this.f49764a.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L19;
        a r105 = (a) ListProtector.get(this.f49764a, r104);
        Integer r106 = (Integer) ListProtector.get(this.f49765b, r104);
        if (r106 != null) goto L8;
    L10:
        View r107 = r101.findViewById(((Number) ListProtector.get(this.f49765b, r104)).intValue());
        if (r107 == null) goto L18;
    L12:
        QIPresenter r108 = r105.f49762a;
        Function1<S, T> r109 = r105.f49763b;
        if ((r100 instanceof QModel) == true) goto L15;
        QModel r110 = null;
    L16:
        r108.J(r109.invoke((S) r110), r107, r102);
        r104 = r104 + 1;
        goto L3
    L15:
        r110 = r100;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L8:
        if (r106.intValue() != 0) goto L10;
        r107 = r101;
        goto L12
    L19:
        this.f49766c = true;
    }
}
