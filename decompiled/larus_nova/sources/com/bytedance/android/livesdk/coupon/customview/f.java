package com.bytedance.android.livesdk.coupon.customview;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgCouponGoodsNewDialog f121844a;

    public f(UgCouponGoodsNewDialog r100) {
        this.f121844a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        UgCouponGoodsNewDialog r101 = this.f121844a;
        Disposable r102 = r101.f121834b;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        r101.f121834b = null;
    }
}
