package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4ActivityLayout.a f167950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f167951b;

    public b(AnchorV4ActivityLayout.a r100, Bitmap r101) {
        this.f167950a = r100;
        this.f167951b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((ConstraintLayout) this.f167950a.f167902a.a(R.id.activity_root)).setBackground(new BitmapDrawable(this.f167950a.f167902a.getContext().getResources(), this.f167951b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
