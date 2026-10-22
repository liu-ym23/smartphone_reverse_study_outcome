package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FeaturedShowView f168938a;

    public f(AnchorV4FeaturedShowView r100) {
        this.f168938a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r100 = new SimpleDraweeView(this.f168938a.getContext());     // Catch: Throwable -> L4
        this.f168938a.addView(r100, -1, -1);     // Catch: Throwable -> L4
        this.f168938a.buildDrawingCache();     // Catch: Throwable -> L4
        r100.setImageBitmap(Bitmap.createBitmap(this.f168938a.getDrawingCache()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
