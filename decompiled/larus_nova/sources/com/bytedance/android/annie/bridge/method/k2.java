package com.bytedance.android.annie.bridge.method;

import android.content.DialogInterface;
import com.bytedance.android.annie.bridge.ShowModalResultModel;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;

/* JADX INFO: loaded from: classes43.dex */
public final class k2 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m2 f38718a;

    public k2(m2 r100) {
        this.f38718a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        ShowModalResultModel r101 = new ShowModalResultModel();
        r101.b(ShowModalResultModel.Code.Success);
        r101.a(BuyNowCloseMethod.MASK);
        this.f38718a.finishWithResult(r101);
    }
}
