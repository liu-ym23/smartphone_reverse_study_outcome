package androidx.fragment.app;

import K.ViewTreeObserverOnPreDrawListenerC0089v;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class I extends AnimationSet implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f3619a;

    /* renamed from: b, reason: collision with root package name */
    public final View f3620b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3621c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3622d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3623e;

    public I(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f3623e = true;
        this.f3619a = viewGroup;
        this.f3620b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation) {
        this.f3623e = true;
        if (this.f3621c) {
            return !this.f3622d;
        }
        if (!super.getTransformation(j4, transformation)) {
            this.f3621c = true;
            ViewTreeObserverOnPreDrawListenerC0089v.a(this.f3619a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4 = this.f3621c;
        ViewGroup viewGroup = this.f3619a;
        if (z4 || !this.f3623e) {
            viewGroup.endViewTransition(this.f3620b);
            this.f3622d = true;
        } else {
            this.f3623e = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation, float f4) {
        this.f3623e = true;
        if (this.f3621c) {
            return !this.f3622d;
        }
        if (!super.getTransformation(j4, transformation, f4)) {
            this.f3621c = true;
            ViewTreeObserverOnPreDrawListenerC0089v.a(this.f3619a, this);
        }
        return true;
    }
}
