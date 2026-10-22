package com.bytedance.android.livesdk.coupon.customview;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgCouponGoodsNewDialog f121843a;

    public e(UgCouponGoodsNewDialog r100) {
        this.f121843a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f121843a.f121836d.onClose();
        UgCouponGoodsNewDialog r101 = this.f121843a;
        Disposable r102 = r101.f121834b;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        r101.f121834b = null;
    }
}
