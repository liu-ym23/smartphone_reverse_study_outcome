package com.bytedance.android.ec.store.sortbar;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.t;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HorizonFilterItemPresenter f48618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f48619b;

    public b(HorizonFilterItemPresenter r100, t r101) {
        this.f48618a = r100;
        this.f48619b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<QModel, Unit> r101 = this.f48618a.f48597j;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(this.f48619b);
        return;
    }
}
