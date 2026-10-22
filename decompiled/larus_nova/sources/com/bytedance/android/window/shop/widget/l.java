package com.bytedance.android.window.shop.widget;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SortBarView f190055a;

    public l(SortBarView r100) {
        this.f190055a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = rp.a.f538829a;
        if (rp.a.a(this.f190055a.getId()) == false) goto L5;
        return;
    L5:
        int r102 = this.f190055a.getChildCount();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L16;
        View r104 = this.f190055a.getChildAt(r103);
        if (r104 == null) goto L15;
        SortBarView.b r105 = (SortBarView.b) r104;
        if ((!Intrinsics.areEqual(r105, r100)) == false) goto L13;
        int r106 = SortBarView.b.f189868g;
        r105.a(false, true);
    L13:
        r103 = r103 + 1;
        goto L7
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.SortBarView.SortItem");
    L16:
        if (r100 == null) goto L20;
        int r107 = SortBarView.b.f189868g;
        ((SortBarView.b) r100).a(true, true);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.SortBarView.SortItem");
    }
}
