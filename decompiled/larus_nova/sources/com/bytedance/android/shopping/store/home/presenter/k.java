package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a f184216a;

    public k(ECShopBackgroundPresenterBrand.a r100) {
        this.f184216a = r100;
    }

    public final void a() {
        ECShopBackgroundPresenterBrand r100 = this.f184216a.f183894a;
        int r101 = ECShopBackgroundPresenterBrand.G;
        View r102 = (View) r100.f183893z.getValue();
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getMeasuredHeight();
    L6:
        r100.D = r104;
        ECShopBackgroundPresenterBrand r105 = this.f184216a.f183894a;
        ViewGroup r106 = r105.v0();
        if (r106 == null) goto L9;
        int r107 = r106.getMeasuredHeight();
    L10:
        r105.E = r107;
        ECShopBackgroundPresenterBrand r108 = this.f184216a.f183894a;
        ViewGroup r109 = r108.v0();
        if (r109 == null) goto L13;
        r103 = r109.getMeasuredWidth();
    L13:
        r108.F = r103;
        ECShopBackgroundPresenterBrand.q0(this.f184216a.f183894a);
        return;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
