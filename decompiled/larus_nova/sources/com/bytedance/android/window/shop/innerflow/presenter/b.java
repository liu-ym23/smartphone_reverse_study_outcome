package com.bytedance.android.window.shop.innerflow.presenter;

import android.view.View;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowInnerFlowListPresenter f189180a;

    public b(ECWindowInnerFlowListPresenter r100) {
        this.f189180a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECWindowInnerFlowListPresenter r101 = this.f189180a;
        WindowStatusView r102 = r101.f189165h;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L5:
        r102.setVisibility(0);
        r102.setECStatus(0);
        r101.D().z2(FooterStatus.LOADING);
        r101.F();
    }
}
