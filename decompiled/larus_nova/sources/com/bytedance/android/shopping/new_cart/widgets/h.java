package com.bytedance.android.shopping.new_cart.widgets;

import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECCartLoadingView f179488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f179489b;

    public h(ECCartLoadingView r100, String r101) {
        this.f179488a = r100;
        this.f179489b = r101;
    }

    public final void a() {
        dm.a.a("ECCartLoadingView").i("stopLoading scene:" + this.f179489b + ", stopped loading");
        ECCartLoadingView r100 = this.f179488a;
        int r101 = ECCartLoadingView.f179449l;
        r100.U5();
        ECCartLoadingView.R5(this.f179488a).stopAnimate();
        ExtensionsKt.gone(ECCartLoadingView.R5(this.f179488a));
        ExtensionsKt.gone(ECCartLoadingView.S5(this.f179488a));
        ExtensionsKt.gone(ECCartLoadingView.T5(this.f179488a));
        this.f179488a.setVisibility(8);
        View r102 = this.f179488a.f179460k;
        if (r102 == null) goto L5;
        r102.setTranslationX(0.0f);
    L5:
        this.f179488a.f179460k = null;
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
