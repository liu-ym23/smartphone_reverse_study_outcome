package com.stepos.common.animator;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import com.stepos.common.drawble.SurroundShaderDrawable;

/* loaded from: classes3.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3560a;
    public final /* synthetic */ d b;

    public /* synthetic */ b(d dVar, int i) {
        this.f3560a = i;
        this.b = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3560a) {
            case 0:
                B5.a aVar = this.b.e.g;
                if (aVar != null) {
                    ((SurroundShaderDrawable) aVar.b).invalidateSelf();
                    break;
                }
                break;
            default:
                long jUptimeMillis = SystemClock.uptimeMillis();
                d dVar = this.b;
                dVar.f3562a.setFloatUniform("time", (jUptimeMillis - dVar.b) / 1000.0f);
                B5.a aVar2 = dVar.e.g;
                if (aVar2 != null) {
                    ((SurroundShaderDrawable) aVar2.b).invalidateSelf();
                    break;
                }
                break;
        }
    }
}
