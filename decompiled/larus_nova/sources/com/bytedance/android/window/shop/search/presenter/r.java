package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f189755a;

    public r(t r100) {
        this.f189755a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowSearchFragmentProductViewModel r101 = this.f189755a.f189760f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.refresh();
    }
}
