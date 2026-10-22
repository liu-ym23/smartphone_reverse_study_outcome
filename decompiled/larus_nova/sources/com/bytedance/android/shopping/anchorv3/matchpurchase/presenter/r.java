package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f165166a;

    public r(s r100) {
        this.f165166a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MatchPurchaseGroupViewModel r101 = this.f165166a.f165167f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.closeMatchPurchasePage();
    }
}
