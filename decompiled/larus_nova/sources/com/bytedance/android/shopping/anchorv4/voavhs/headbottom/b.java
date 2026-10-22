package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadBottomAdapter.HeadBottomHolder f168987a;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = this.f168987a.f168984a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setImageBitmap(null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(HeadBottomAdapter.HeadBottomHolder r100) {
        this.f168987a = r100;
    }
}
