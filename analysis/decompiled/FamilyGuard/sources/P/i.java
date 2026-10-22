package P;

import P.e;
import android.util.AndroidRuntimeException;

/* loaded from: classes.dex */
public final class i extends e<i> {

    /* renamed from: B, reason: collision with root package name */
    private j f4520B;

    /* renamed from: C, reason: collision with root package name */
    private float f4521C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f4522D;

    public i(g gVar) {
        super(gVar);
        this.f4520B = null;
        this.f4521C = Float.MAX_VALUE;
        this.f4522D = false;
    }

    private void w() {
        j jVar = this.f4520B;
        if (jVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dB = jVar.b();
        if (dB > this.f4507g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dB < this.f4508h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // P.e
    public void d() {
        super.d();
        float f5 = this.f4521C;
        if (f5 != Float.MAX_VALUE) {
            j jVar = this.f4520B;
            if (jVar == null) {
                this.f4520B = new j(f5);
            } else {
                jVar.g(f5);
            }
            this.f4521C = Float.MAX_VALUE;
        }
    }

    @Override // P.e
    void o(float f5) {
    }

    @Override // P.e
    public void p() {
        w();
        this.f4520B.i(h());
        super.p();
    }

    @Override // P.e
    boolean r(long j5) {
        if (this.f4522D) {
            float f5 = this.f4521C;
            if (f5 != Float.MAX_VALUE) {
                this.f4520B.g(f5);
                this.f4521C = Float.MAX_VALUE;
            }
            this.f4502b = this.f4520B.b();
            this.f4501a = 0.0f;
            this.f4522D = false;
            return true;
        }
        if (this.f4521C != Float.MAX_VALUE) {
            long j6 = j5 / 2;
            e.p pVarJ = this.f4520B.j(this.f4502b, this.f4501a, j6);
            this.f4520B.g(this.f4521C);
            this.f4521C = Float.MAX_VALUE;
            e.p pVarJ2 = this.f4520B.j(pVarJ.f4516a, pVarJ.f4517b, j6);
            this.f4502b = pVarJ2.f4516a;
            this.f4501a = pVarJ2.f4517b;
        } else {
            e.p pVarJ3 = this.f4520B.j(this.f4502b, this.f4501a, j5);
            this.f4502b = pVarJ3.f4516a;
            this.f4501a = pVarJ3.f4517b;
        }
        float fMax = Math.max(this.f4502b, this.f4508h);
        this.f4502b = fMax;
        float fMin = Math.min(fMax, this.f4507g);
        this.f4502b = fMin;
        if (!v(fMin, this.f4501a)) {
            return false;
        }
        this.f4502b = this.f4520B.b();
        this.f4501a = 0.0f;
        return true;
    }

    public void s(float f5) {
        if (i()) {
            this.f4521C = f5;
            return;
        }
        if (this.f4520B == null) {
            this.f4520B = new j(f5);
        }
        this.f4520B.g(f5);
        p();
    }

    public boolean t() {
        return this.f4520B.f4524b > 0.0d;
    }

    public j u() {
        return this.f4520B;
    }

    boolean v(float f5, float f6) {
        return this.f4520B.e(f5, f6);
    }

    public i x(j jVar) {
        this.f4520B = jVar;
        return this;
    }

    public void y() {
        if (!t()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (!f().j()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f4506f) {
            this.f4522D = true;
        }
    }

    public <K> i(K k5, f<K> fVar) {
        super(k5, fVar);
        this.f4520B = null;
        this.f4521C = Float.MAX_VALUE;
        this.f4522D = false;
    }
}
