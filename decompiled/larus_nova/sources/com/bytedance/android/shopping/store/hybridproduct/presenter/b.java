package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.widget.TextView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qj3.b f185354e;

    public b(qj3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "dividerView");
        this.f185354e = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        String r101 = null;
        if ((r100 instanceof ej3.c) == true) goto L5;
        r100 = null;
    L5:
        ej3.c r102 = (ej3.c) r100;
        TextView r103 = this.f185354e.getTextView();
        if (r102 == null) goto L8;
        r101 = r102.f472843a;
    L8:
        r103.setText(r101);
    }
}
