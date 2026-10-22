package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;
import com.bytedance.commerce.base.richtext.SpanUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f43579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f43580b;

    public v(w r100, Bitmap r101) {
        this.f43579a = r100;
        this.f43580b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpanUtils r100 = new SpanUtils(this.f43579a.f43581a.f43452h);     // Catch: Throwable -> L4
        Bitmap r101 = this.f43580b;     // Catch: Throwable -> L4
        r100.b();     // Catch: Throwable -> L4
        r100.f202892v = 1;     // Catch: Throwable -> L4
        r100.f202886p = r101;     // Catch: Throwable -> L4
        r100.f202888r = 2;     // Catch: Throwable -> L4
        r100.a(" ");     // Catch: Throwable -> L4
        r100.a(this.f43579a.f43582b.f43571d);     // Catch: Throwable -> L4
        r100.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
