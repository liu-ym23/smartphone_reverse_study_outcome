package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f164904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f164905b;

    public a(b r100, Bitmap r101) {
        this.f164904a = r100;
        this.f164905b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f164904a.f164906a.f164836f.setBackground(new BitmapDrawable(this.f164904a.f164906a.getResources(), this.f164905b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
