package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends QPresenter {
    public a() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if ((r100 instanceof ni2.a) == true) goto L5;
        r100 = null;
    L5:
        ni2.a r101 = (ni2.a) r100;
        if (r101 != null) goto L8;
    L12:
        ViewGroup.LayoutParams r102 = w().f().getLayoutParams();
        if (r102 == null) goto L18;
        r102.width = -2;
        return;
    L18:
        return;
    L8:
        if (r101.f519240m != true) goto L12;
        ViewGroup.LayoutParams r103 = w().f().getLayoutParams();
        if (r103 == null) goto L16;
        r103.width = 0;
        return;
    }
}
