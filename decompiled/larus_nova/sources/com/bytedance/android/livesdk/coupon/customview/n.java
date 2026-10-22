package com.bytedance.android.livesdk.coupon.customview;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f121857a;

    public n(h r100) {
        this.f121857a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f121857a.f121849d.onClose();
        h r101 = this.f121857a;
        Disposable r102 = r101.f121847b;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        r101.f121847b = null;
    }
}
