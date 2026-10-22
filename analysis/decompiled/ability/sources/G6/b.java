package G6;

import android.animation.ValueAnimator;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import g1.AbstractC1451a;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {
    public int d;
    public final FloatValueHolder f;
    public final SpringAnimation g;

    /* renamed from: a, reason: collision with root package name */
    public float f678a = 1.0f;
    public int b = 1;
    public int c = 1;
    public int e = 1;

    public b() {
        FloatValueHolder floatValueHolder = new FloatValueHolder(1.0f);
        this.f = floatValueHolder;
        SpringAnimation springAnimation = new SpringAnimation(floatValueHolder);
        springAnimation.setSpring(new SpringForce().setDampingRatio(1.0f).setStiffness(1500.0f));
        springAnimation.setMinimumVisibleChange(0.001f);
        springAnimation.addUpdateListener(new E6.b(this, 1));
        springAnimation.addEndListener(new a(this, 0));
        this.g = springAnimation;
    }

    public final void a() {
        if (this.d == 1) {
            return;
        }
        this.g.cancel();
        this.e = this.f678a < 0.5f ? 0 : 1;
        if (this.d == 1) {
            return;
        }
        this.d = 1;
    }

    public final float b(float f, d geometry, boolean z10) {
        float f7;
        k.f(geometry, "geometry");
        a();
        float fA = geometry.a(this.f678a);
        float f9 = (this.e == 0 || !z10) ? 1.0f : 2.0f;
        float f10 = f + fA;
        float f11 = geometry.f;
        float f12 = geometry.f680a;
        float f13 = geometry.e;
        if (f10 <= f13) {
            float f14 = f13 - f12;
            f7 = (f10 - f12) / (f14 >= 1.0f ? f14 : 1.0f);
        } else {
            float f15 = f10 - f13;
            float f16 = f11 - f13;
            if (f16 < 1.0f) {
                f16 = 1.0f;
            }
            f7 = (f15 / f16) + 1.0f;
        }
        float fT = AbstractC1451a.t(f7, 0.0f, f9);
        this.f678a = fT;
        this.f.setValue(fT);
        return geometry.a(this.f678a) - fA;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(float r5, float r6, boolean r7) {
        /*
            r4 = this;
            int r0 = r4.d
            r1 = 1
            if (r0 == r1) goto L6
            return
        L6:
            int r0 = r4.e
            float r2 = r4.f678a
            r3 = 0
            if (r0 != 0) goto L20
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 > 0) goto L40
            r7 = 1045220557(0x3e4ccccd, float:0.2)
            int r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r7 <= 0) goto L1e
            float r6 = -r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L1e
            goto L40
        L1e:
            r1 = r3
            goto L40
        L20:
            float r0 = -r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 >= 0) goto L26
            goto L1e
        L26:
            r0 = 1061997773(0x3f4ccccd, float:0.8)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L32
            int r0 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r0 > 0) goto L32
            goto L1e
        L32:
            if (r7 == 0) goto L40
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L3f
            r5 = 1067030938(0x3f99999a, float:1.2)
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L40
        L3f:
            r1 = 2
        L40:
            r4.d(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G6.b.c(float, float, boolean):void");
    }

    public final void d(int i) {
        SpringAnimation springAnimation = this.g;
        springAnimation.cancel();
        this.c = i;
        boolean zAreAnimatorsEnabled = ValueAnimator.areAnimatorsEnabled();
        FloatValueHolder floatValueHolder = this.f;
        if (zAreAnimatorsEnabled) {
            float f = i;
            if (Math.abs(this.f678a - f) >= 0.001f) {
                floatValueHolder.setValue(this.f678a);
                if (this.d != 2) {
                    this.d = 2;
                }
                springAnimation.animateToFinalPosition(f);
                return;
            }
        }
        springAnimation.cancel();
        this.b = i;
        this.c = i;
        float f7 = i;
        this.f678a = f7;
        floatValueHolder.setValue(f7);
        if (this.d == 0) {
            return;
        }
        this.d = 0;
    }
}
