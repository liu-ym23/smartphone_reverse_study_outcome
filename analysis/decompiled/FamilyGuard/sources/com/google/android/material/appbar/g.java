package com.google.android.material.appbar;

import a1.C0409b;
import a1.C0414g;
import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.o;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f12191a = {R.attr.stateListAnimator};

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(View view, float f5) throws Resources.NotFoundException {
        int integer = view.getResources().getInteger(C0414g.f6864a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j5 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, C0409b.f6709S, -C0409b.f6710T}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j5));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f5).setDuration(j5));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(View view, AttributeSet attributeSet, int i5, int i6) {
        Context context = view.getContext();
        TypedArray typedArrayI = o.i(context, attributeSet, f12191a, i5, i6, new int[0]);
        try {
            if (typedArrayI.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayI.getResourceId(0, 0)));
            }
            typedArrayI.recycle();
        } catch (Throwable th) {
            typedArrayI.recycle();
            throw th;
        }
    }
}
