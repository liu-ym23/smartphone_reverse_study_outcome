package com.stepos.common.animator;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import com.stepos.alphame.suggest.AppSuggestStorable;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11274a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11275b;

    public /* synthetic */ b(d dVar, int i4) {
        this.f11274a = i4;
        this.f11275b = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f11274a;
        d dVar = this.f11275b;
        switch (i4) {
            case 0:
                androidx.core.app.f fVar = dVar.f11288e.f11282g;
                if (fVar != null) {
                    fVar.c();
                    break;
                }
                break;
            default:
                dVar.f11284a.setFloatUniform(AppSuggestStorable.COLUMN_TIME, (SystemClock.uptimeMillis() - dVar.f11285b) / 1000.0f);
                androidx.core.app.f fVar2 = dVar.f11288e.f11282g;
                if (fVar2 != null) {
                    fVar2.c();
                    break;
                }
                break;
        }
    }
}
