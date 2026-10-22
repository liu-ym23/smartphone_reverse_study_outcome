package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseActivityModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f165138a;

    public a0(b0 r100) {
        this.f165138a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MatchPurchaseActivityModel r101 = this.f165138a.f165141e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.getPageClosed().g(Boolean.TRUE);
    }
}
