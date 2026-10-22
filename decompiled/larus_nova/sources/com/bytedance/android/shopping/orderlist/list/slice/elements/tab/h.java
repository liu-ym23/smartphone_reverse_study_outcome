package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderListTabItemView f180334a;

    public h(OrderListTabItemView r100) {
        this.f180334a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CornersButton r100 = this.f180334a.f180277c;     // Catch: Throwable -> L4
        r100.setMinWidth(r100.getHeight());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
