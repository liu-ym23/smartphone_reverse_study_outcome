package com.bytedance.android.live.messagewindow.business.presenter;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsCommonCardPresenter f82967a;

    public a(AbsCommonCardPresenter r100) {
        this.f82967a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        AbsCommonCardPresenter.a r101 = (AbsCommonCardPresenter.a) this.f82967a.f531633a;
        if (r101 == null) goto L6;
        r101.CA();
        return;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        super.onInnerFallback(r100, r101);
        AbsCommonCardPresenter.a r102 = (AbsCommonCardPresenter.a) this.f82967a.f531633a;
        if (r102 == null) goto L6;
        r102.IG(r100, r101);
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        super.onLoadStart(r100, r101);
        AbsCommonCardPresenter.a r102 = (AbsCommonCardPresenter.a) this.f82967a.f531633a;
        if (r102 == null) goto L6;
        r102.yA();
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        AbsCommonCardPresenter.a r103 = (AbsCommonCardPresenter.a) this.f82967a.f531633a;
        if (r103 == null) goto L6;
        r103.bi(r102);
        return;
    }
}
