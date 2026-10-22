package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class A implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f9713a;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f9714b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f9715c;

    private A(View view, Runnable runnable) {
        this.f9713a = view;
        this.f9714b = view.getViewTreeObserver();
        this.f9715c = runnable;
    }

    public static A a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        A a6 = new A(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(a6);
        view.addOnAttachStateChangeListener(a6);
        return a6;
    }

    public void b() {
        if (this.f9714b.isAlive()) {
            this.f9714b.removeOnPreDrawListener(this);
        } else {
            this.f9713a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f9713a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f9715c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f9714b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
