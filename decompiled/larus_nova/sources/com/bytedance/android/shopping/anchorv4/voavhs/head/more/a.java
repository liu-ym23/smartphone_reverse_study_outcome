package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f168800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f168801b;

    public a(b r100, Bitmap r101) {
        this.f168800a = r100;
        this.f168801b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f168800a.f168803b.setBackground(new BitmapDrawable(this.f168800a.f168802a.getContext().getResources(), this.f168801b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
