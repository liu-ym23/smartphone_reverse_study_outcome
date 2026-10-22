package com.bytedance.android.ecom.arch.slice.render.util;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f50739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f50740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f50741c;

    public final void a() {
        ViewTreeObserver r100 = this.f50740b;
        if (r100 != null) goto L5;
    L7:
        this.f50739a.getViewTreeObserver().removeOnPreDrawListener(this);
    L8:
        this.f50739a.removeOnAttachStateChangeListener(this);
        return;
    L5:
        if (r100.isAlive() == false) goto L7;
        this.f50740b.removeOnPreDrawListener(this);
        goto L8
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        a();
        this.f50741c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f50740b = r100.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        a();
    }

    public f(View r100, com.bytedance.android.ecom.arch.slice.render.elements.d r101) {
        this.f50739a = r100;
        this.f50740b = r100.getViewTreeObserver();
        this.f50741c = r101;
    }
}
