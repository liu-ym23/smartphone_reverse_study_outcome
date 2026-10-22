package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebDialogFragmentForAnnie f64417a;

    public r(WebDialogFragmentForAnnie r100) {
        this.f64417a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        gf1.a r101 = this.f64417a.f64367i;
        if (r101 == null) goto L6;
        r101.a(1, 0, "");
        return;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f64417a.getClass();
        return false;
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        super.onLoadStart(r100, r101);
        gf1.a r102 = this.f64417a.f64367i;
        if (r102 == null) goto L6;
        r102.a(0, 0, "");
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        gf1.a r103 = this.f64417a.f64367i;
        if (r103 == null) goto L6;
        r103.a(2, -1, r102);
        return;
    }
}
