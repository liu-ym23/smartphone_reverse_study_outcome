package z2;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class g extends AbstractC1344a {

    /* renamed from: b, reason: collision with root package name */
    protected A2.m[] f24063b;

    /* renamed from: c, reason: collision with root package name */
    protected float f24064c;

    /* renamed from: d, reason: collision with root package name */
    private int f24065d;

    @Override // z2.e
    public y2.g[] e(Context context) {
        int iC = c();
        int iB = b().b();
        this.f24063b = new A2.m[iC];
        int i5 = 0;
        int i6 = iB;
        while (i6 < iB + iC) {
            this.f24063b[i5] = (A2.m) f(context, i6);
            this.f24063b[i5].a(this.f24065d);
            i6++;
            i5++;
        }
        return this.f24063b;
    }

    public float g() {
        return this.f24064c;
    }

    public void h(int i5) {
        this.f24065d = i5;
    }

    public void i(float f5) {
        this.f24064c = f5;
    }
}
