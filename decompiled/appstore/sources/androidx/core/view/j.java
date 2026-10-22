package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class j implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f2780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f2781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f2782c;

    public j(View r10, Runnable r11) {
        this.f2780a = r10;
        this.f2781b = r10.getViewTreeObserver();
        this.f2782c = r11;
    }

    public static j a(View r10, Runnable r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L7;
        j r12 = new j(r10, r11);
        r10.getViewTreeObserver().addOnPreDrawListener(r12);
        r10.addOnAttachStateChangeListener(r12);
        return r12;
    L7:
        throw new NullPointerException("runnable == null");
    L9:
        throw new NullPointerException("view == null");
    }

    public void b() {
        if (this.f2781b.isAlive() == false) goto L5;
        this.f2781b.removeOnPreDrawListener(this);
    L6:
        this.f2780a.removeOnAttachStateChangeListener(this);
        return;
    L5:
        this.f2780a.getViewTreeObserver().removeOnPreDrawListener(this);
        goto L6
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f2782c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r10) {
        this.f2781b = r10.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r10) {
        b();
    }
}
