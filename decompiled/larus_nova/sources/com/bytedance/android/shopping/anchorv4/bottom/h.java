package com.bytedance.android.shopping.anchorv4.bottom;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f165819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f165820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f165821c;

    public h(View r100, int r101, View r102) {
        this.f165819a = r100;
        this.f165820b = r101;
        this.f165821c = r102;
    }

    public final void a() {
        Rect r100 = new Rect();
        this.f165819a.getHitRect(r100);
        int r101 = r100.top;
        int r102 = this.f165820b;
        r100.top = r101 - r102;
        r100.bottom += r102;
        this.f165821c.setTouchDelegate(new TouchDelegate(r100, this.f165819a));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
