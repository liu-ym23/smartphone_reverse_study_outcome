package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f168985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HeadBottomAdapter.HeadBottomHolder f168986b;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = this.f168986b.f168984a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setImageBitmap(this.f168985a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a(Bitmap r100, HeadBottomAdapter.HeadBottomHolder r101) {
        this.f168985a = r100;
        this.f168986b = r101;
    }
}
