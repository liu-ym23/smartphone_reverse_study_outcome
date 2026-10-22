package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FeaturedCommentView f168936a;

    public d(AnchorV4FeaturedCommentView r100) {
        this.f168936a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = new ImageView(this.f168936a.getContext());     // Catch: Throwable -> L6
        this.f168936a.addView(r100, -1, -1);     // Catch: Throwable -> L6
        this.f168936a.buildDrawingCache();     // Catch: Throwable -> L6
        Bitmap r101 = this.f168936a.getDrawingCache();     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r100.setImageBitmap(Bitmap.createBitmap(r101));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
