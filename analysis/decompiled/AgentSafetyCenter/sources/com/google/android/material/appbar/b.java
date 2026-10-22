package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ g f2329a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ f7.i f2330b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        g gVar = this.f2329a;
        f7.i iVar = this.f2330b;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        iVar.i(fFloatValue);
        Drawable drawable = gVar.B;
        if (drawable instanceof f7.i) {
            ((f7.i) drawable).i(fFloatValue);
        }
        Iterator it = gVar.f2361v.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        Iterator it2 = gVar.f2362w.iterator();
        if (it2.hasNext()) {
            throw androidx.activity.b.g(it2);
        }
    }
}
