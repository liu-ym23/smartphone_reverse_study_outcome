package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class g extends WindowInsetsAnimationCompat.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final View f2349a;
    public int b;
    public int c;
    public final int[] d;

    public g(View view) {
        super(0);
        this.d = new int[2];
        this.f2349a = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f2349a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        View view = this.f2349a;
        int[] iArr = this.d;
        view.getLocationOnScreen(iArr);
        this.b = iArr[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((WindowInsetsAnimationCompat) it.next()).getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                this.f2349a.setTranslationY(Q2.a.c(this.c, 0, r0.getInterpolatedFraction()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        View view = this.f2349a;
        int[] iArr = this.d;
        view.getLocationOnScreen(iArr);
        int i = this.b - iArr[1];
        this.c = i;
        view.setTranslationY(i);
        return boundsCompat;
    }
}
