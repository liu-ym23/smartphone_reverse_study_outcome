package com.bytedance.android.livesdk.utils;

import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f158814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PorterDuffColorFilter f158815b;

    public a1(View r100, PorterDuffColorFilter r101) {
        this.f158814a = r100;
        this.f158815b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f158814a;     // Catch: Throwable -> L11
        if ((r100 instanceof ImageView) == false) goto L7;
        Drawable r101 = ((ImageView) r100).getDrawable();     // Catch: Throwable -> L11
        if (r101 == null) goto L16;
        r101.setColorFilter(this.f158815b);     // Catch: Throwable -> L11
    L16:
        return;
    L7:
        Drawable r102 = r100.getBackground();     // Catch: Throwable -> L11
        if (r102 == null) goto L16;
        r102.setColorFilter(this.f158815b);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
