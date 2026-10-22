package com.bytedance.android.ec.common.impl.sku.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f43374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f43375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f43376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f43377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f43378e;

    public s(View r100, int r101, int r102) {
        this.f43374a = r100;
        this.f43375b = r101;
        this.f43376c = r102;
        this.f43377d = 0;
        this.f43378e = 0;
    }

    public final void a() {
        Rect r100 = new Rect();
        this.f43374a.getHitRect(r100);
        r100.top -= this.f43375b;
        r100.bottom += this.f43376c;
        r100.left -= this.f43377d;
        r100.right += this.f43378e;
        TouchDelegate r101 = new TouchDelegate(r100, this.f43374a);
        if (View.class.isInstance(this.f43374a.getParent()) == false) goto L9;
        Object r102 = this.f43374a.getParent();
        if (r102 == null) goto L8;
        ((View) r102).setTouchDelegate(r101);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
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
