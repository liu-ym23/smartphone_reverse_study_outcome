package com.bytedance.android.shopping.card_list.manager;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f171644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Boolean f171645b;

    public b(c r100, Boolean r101) {
        this.f171644a = r100;
        this.f171645b = r101;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        c r100 = this.f171644a;     // Catch: Throwable -> L19
        View r101 = r100.f171647a;     // Catch: Throwable -> L19
        if (r101 == null) goto L23;
        r100.f171649c = r101.getHeight();     // Catch: Throwable -> L19
        View r102 = this.f171644a.f171653g;     // Catch: Throwable -> L19
        if (r102 == null) goto L10;
        List<View> r103 = com.bytedance.commerce.base.view.b.a(r102);     // Catch: Throwable -> L19
        if (r103 == null) goto L10;
        if ((!r103.isEmpty()) != true) goto L10;
        return;
    L10:
        View r104 = this.f171644a.f171652f;     // Catch: Throwable -> L19
        if (r104 == null) goto L17;
        List<View> r105 = com.bytedance.commerce.base.view.b.a(r104);     // Catch: Throwable -> L19
        if (r105 == null) goto L17;
        if ((!r105.isEmpty()) != true) goto L17;
        return;
    L17:
        c.a(this.f171644a, this.f171645b);     // Catch: Throwable -> L19
        return;
    L23:
        return;
    }
}
