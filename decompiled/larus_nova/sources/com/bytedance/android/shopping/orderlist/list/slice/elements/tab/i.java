package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.widget.PopupWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupWindow f180335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OrderListTabLayout f180336b;

    public i(PopupWindow r100, OrderListTabLayout r101) {
        this.f180335a = r100;
        this.f180336b = r101;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        if (Intrinsics.areEqual(this.f180336b.f180288j, this.f180335a) == false) goto L6;
        OrderListTabLayout r100 = this.f180336b;
        r100.f180288j = null;
        r100.f180289k = null;
        r100.f180290l = false;
        return;
    }
}
