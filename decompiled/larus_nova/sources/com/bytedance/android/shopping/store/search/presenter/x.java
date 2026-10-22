package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f186112a;

    public x(z r100) {
        this.f186112a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ShopSearchFragmentProductViewModel r101 = this.f186112a.f186117f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.refresh();
    }
}
