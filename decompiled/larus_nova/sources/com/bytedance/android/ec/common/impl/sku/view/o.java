package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f43549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f43550b;

    public o(p r100, Bitmap r101) {
        this.f43549a = r100;
        this.f43550b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView r100 = this.f43549a.f43552b;     // Catch: Throwable -> L4
        r100.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(r100.getContext().getResources(), this.f43550b), null, null, null);     // Catch: Throwable -> L4
        r100.setCompoundDrawablePadding(vf4.a.b(4));     // Catch: Throwable -> L4
        this.f43549a.f43551a.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
