package com.bytedance.android.shopping.utils.gallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.k1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f187115a;

    public c(e r100) {
        this.f187115a = r100;
    }

    public final void a() {
        View r100 = this.f187115a.f187117a;
        if (r100 == null) goto L14;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r101 = null;
    L7:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L15;
        Context r103 = this.f187115a.f187125i;
        if (r103 == null) goto L13;
        Rect r104 = new Rect();
        k1.b(((Activity) r103).getWindow()).getWindowVisibleDisplayFrame(r104);
        r102.topMargin = ((r104.height() + this.f187115a.f187124h) / 2) + com.bytedance.android.shopping.extensions.b.b(36);
        r100.setLayoutParams(r102);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L15:
        return;
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
