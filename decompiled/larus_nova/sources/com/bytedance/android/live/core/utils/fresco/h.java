package com.bytedance.android.live.core.utils.fresco;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f66147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f66148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f66149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f66150d;

    private void update() {
        if (this.f66149c == false) goto L11;
        View r100 = this.f66147a;
    L5:
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == false) goto L8;
        r100 = (View) r101;
        goto L5
    L8:
        if (r100 != this.f66147a.getRootView()) goto L11;
        boolean r102 = true;
    L13:
        if (this.f66150d == r102) goto L20;
        this.f66150d = r102;
        if (r102 == false) goto L17;
        this.f66148b.onViewAttachedToWindow(this.f66147a);
        return;
    L17:
        this.f66148b.onViewDetachedFromWindow(this.f66147a);
        return;
    L20:
        return;
    L11:
        r102 = false;
        goto L13
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        update();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        if (this.f66149c == false) goto L5;
        return;
    L5:
        this.f66149c = true;
        this.f66147a.getViewTreeObserver().addOnPreDrawListener(this);
        update();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        if (this.f66149c == true) goto L5;
        return;
    L5:
        this.f66149c = false;
        this.f66147a.getViewTreeObserver().removeOnPreDrawListener(this);
        update();
    }

    public h(View r100, FrescoLoader.b r101) {
        this.f66147a = r100;
        this.f66148b = r101;
        boolean r102 = r100.isAttachedToWindow();
        this.f66149c = r102;
        this.f66150d = false;
        if (r102 == false) goto L5;
        r100.getViewTreeObserver().addOnPreDrawListener(this);
    L5:
        r100.addOnAttachStateChangeListener(this);
        update();
    }
}
