package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes17.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    public void removeListener() {
        if (this.mViewTreeObserver.isAlive() == false) goto L5;
        this.mViewTreeObserver.removeOnPreDrawListener(this);
    L6:
        this.mView.removeOnAttachStateChangeListener(this);
        return;
    L5:
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        goto L6
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
        this.mViewTreeObserver = r100.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        removeListener();
    }

    private OneShotPreDrawListener(View r100, Runnable r101) {
        this.mView = r100;
        this.mViewTreeObserver = r100.getViewTreeObserver();
        this.mRunnable = r101;
    }

    public static OneShotPreDrawListener add(View r100, Runnable r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L7;
        OneShotPreDrawListener r102 = new OneShotPreDrawListener(r100, r101);
        r100.getViewTreeObserver().addOnPreDrawListener(r102);
        r100.addOnAttachStateChangeListener(r102);
        return r102;
    L7:
        throw new NullPointerException("runnable == null");
    L9:
        throw new NullPointerException("view == null");
    }
}
