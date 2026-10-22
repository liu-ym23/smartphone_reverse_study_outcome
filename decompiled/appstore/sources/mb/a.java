package mb;

import com.obric.common.oea.foundation.animation.token.Easing;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f22257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f22258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f22260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f22261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f22262f;

    public a(float r10, float r11, float r12, float r13) {
        this.f22259c = r10;
        this.f22260d = r11;
        this.f22261e = r12;
        this.f22262f = r13;
        nb.a r14 = b.b(0.0f, r11, r13, 1.0f, new float[5], 0);
        this.f22257a = Float.intBitsToFloat((int) (r14.f22436a >> 32));
        this.f22258b = Float.intBitsToFloat((int) (r14.f22436a & 4294967295L));
    }

    public final void a(float r10) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f22259c + ", " + this.f22260d + ", " + this.f22261e + ", " + this.f22262f + ") has no solution at " + r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof a) == false) goto L13;
        a r11 = (a) r10;
        if (this.f22259c != r11.f22259c) goto L13;
        if (this.f22260d != r11.f22260d) goto L13;
        if (this.f22261e != r11.f22261e) goto L13;
        if (this.f22262f != r11.f22262f) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f22259c) * 31) + Float.hashCode(this.f22260d)) * 31) + Float.hashCode(this.f22261e)) * 31) + Float.hashCode(this.f22262f);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f22259c + ", b=" + this.f22260d + ", c=" + this.f22261e + ", d=" + this.f22262f + ')';
    }

    @Override // com.obric.common.oea.foundation.animation.token.Easing
    public float transform(float r10) {
        if (r10 > 0.0f) goto L5;
        return r10;
    L5:
        if (r10 >= 1.0f) goto L17;
        float r11 = b.f(0.0f - r10, this.f22259c - r10, this.f22261e - r10, 1.0f - r10);
        if (Float.isNaN(r11) == false) goto L9;
        a(r10);
    L9:
        float r12 = b.c(this.f22260d, this.f22262f, r11);
        float r13 = this.f22257a;
        float r14 = this.f22258b;
        if (r12 >= r13) goto L13;
        r12 = r13;
    L13:
        if (r12 > r14) goto L15;
        return r12;
    L15:
        return r14;
    L17:
        return r10;
    }
}
