package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class D implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f13096a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f13097b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f13098c;

    public D(View view, Runnable runnable) {
        this.f13096a = view;
        this.f13097b = view.getViewTreeObserver();
        this.f13098c = runnable;
    }

    public static D a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        D d10 = new D(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(d10);
        view.addOnAttachStateChangeListener(d10);
        return d10;
    }

    public void b() {
        if (this.f13097b.isAlive()) {
            this.f13097b.removeOnPreDrawListener(this);
        } else {
            this.f13096a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f13096a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f13098c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f13097b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
