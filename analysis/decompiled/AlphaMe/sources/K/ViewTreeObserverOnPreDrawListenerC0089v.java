package K;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: K.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0089v implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f1008a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f1009b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f1010c;

    public ViewTreeObserverOnPreDrawListenerC0089v(View view, Runnable runnable) {
        this.f1008a = view;
        this.f1009b = view.getViewTreeObserver();
        this.f1010c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC0089v viewTreeObserverOnPreDrawListenerC0089v = new ViewTreeObserverOnPreDrawListenerC0089v(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0089v);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0089v);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f1009b.isAlive();
        View view = this.f1008a;
        if (zIsAlive) {
            this.f1009b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f1010c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f1009b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f1009b.isAlive();
        View view2 = this.f1008a;
        if (zIsAlive) {
            this.f1009b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
