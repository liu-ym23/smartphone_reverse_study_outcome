package androidx.dynamicanimation.animation;

import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.e;

/* loaded from: classes.dex */
public final class i extends e<i> {

    /* renamed from: B, reason: collision with root package name */
    public j f13722B;

    /* renamed from: C, reason: collision with root package name */
    public float f13723C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f13724D;

    public i(g gVar) {
        super(gVar);
        this.f13722B = null;
        this.f13723C = Float.MAX_VALUE;
        this.f13724D = false;
    }

    public final void A() {
        j jVar = this.f13722B;
        if (jVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dB = jVar.b();
        if (dB > this.f13709g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dB < this.f13710h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public i B(j jVar) {
        this.f13722B = jVar;
        return this;
    }

    public void C() {
        if (!x()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (!f().j()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f13708f) {
            this.f13724D = true;
        }
    }

    @Override // androidx.dynamicanimation.animation.e
    public void d() {
        super.d();
        float f10 = this.f13723C;
        if (f10 != Float.MAX_VALUE) {
            j jVar = this.f13722B;
            if (jVar == null) {
                this.f13722B = new j(f10);
            } else {
                jVar.g(f10);
            }
            this.f13723C = Float.MAX_VALUE;
        }
    }

    @Override // androidx.dynamicanimation.animation.e
    public void s(float f10) {
    }

    @Override // androidx.dynamicanimation.animation.e
    public void t() {
        A();
        this.f13722B.i(h());
        super.t();
    }

    @Override // androidx.dynamicanimation.animation.e
    public boolean v(long j10) {
        if (this.f13724D) {
            float f10 = this.f13723C;
            if (f10 != Float.MAX_VALUE) {
                this.f13722B.g(f10);
                this.f13723C = Float.MAX_VALUE;
            }
            this.f13704b = this.f13722B.b();
            this.f13703a = 0.0f;
            this.f13724D = false;
            return true;
        }
        if (this.f13723C != Float.MAX_VALUE) {
            long j11 = j10 / 2;
            e.p pVarJ = this.f13722B.j(this.f13704b, this.f13703a, j11);
            this.f13722B.g(this.f13723C);
            this.f13723C = Float.MAX_VALUE;
            e.p pVarJ2 = this.f13722B.j(pVarJ.f13718a, pVarJ.f13719b, j11);
            this.f13704b = pVarJ2.f13718a;
            this.f13703a = pVarJ2.f13719b;
        } else {
            e.p pVarJ3 = this.f13722B.j(this.f13704b, this.f13703a, j10);
            this.f13704b = pVarJ3.f13718a;
            this.f13703a = pVarJ3.f13719b;
        }
        float fMax = Math.max(this.f13704b, this.f13710h);
        this.f13704b = fMax;
        float fMin = Math.min(fMax, this.f13709g);
        this.f13704b = fMin;
        if (!z(fMin, this.f13703a)) {
            return false;
        }
        this.f13704b = this.f13722B.b();
        this.f13703a = 0.0f;
        return true;
    }

    public void w(float f10) {
        if (i()) {
            this.f13723C = f10;
            return;
        }
        if (this.f13722B == null) {
            this.f13722B = new j(f10);
        }
        this.f13722B.g(f10);
        t();
    }

    public boolean x() {
        return this.f13722B.f13726b > 0.0d;
    }

    public j y() {
        return this.f13722B;
    }

    public boolean z(float f10, float f11) {
        return this.f13722B.e(f10, f11);
    }

    public <K> i(K k10, f<K> fVar) {
        super(k10, fVar);
        this.f13722B = null;
        this.f13723C = Float.MAX_VALUE;
        this.f13724D = false;
    }

    public <K> i(K k10, f<K> fVar, float f10) {
        super(k10, fVar);
        this.f13722B = null;
        this.f13723C = Float.MAX_VALUE;
        this.f13724D = false;
        this.f13722B = new j(f10);
    }
}
