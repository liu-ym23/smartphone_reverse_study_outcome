package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements vi3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopLivePreviewPresenter f184351a;

    public h(ECShopLivePreviewPresenter r100) {
        this.f184351a = r100;
    }

    @Override // vi3.a
    public final void a(ShopContainerType r100, vi3.c r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "newConfig");
        int r102 = r101.a() + com.bytedance.android.shopping.extensions.b.b(16);
        View r103 = this.f184351a.f184298r;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L6:
        if ((r103.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        if (((ViewGroup.MarginLayoutParams) r104).topMargin == r102) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L24;
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();
        if (r106 == null) goto L23;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = r102;
        r103.requestLayout();
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L24:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L14:
        r105 = false;
        goto L15
    }
}
