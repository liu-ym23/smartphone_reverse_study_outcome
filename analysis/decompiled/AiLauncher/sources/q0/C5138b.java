package q0;

import androidx.constraintlayout.motion.widget.o;
import m0.k;
import m0.m;
import m0.n;

/* renamed from: q0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5138b extends o {

    /* renamed from: a, reason: collision with root package name */
    public n f38473a;

    /* renamed from: b, reason: collision with root package name */
    public k f38474b;

    /* renamed from: c, reason: collision with root package name */
    public m f38475c;

    public C5138b() {
        n nVar = new n();
        this.f38473a = nVar;
        this.f38475c = nVar;
    }

    @Override // androidx.constraintlayout.motion.widget.o
    public float a() {
        return this.f38475c.a();
    }

    public void b(float f10, float f11, float f12, float f13, float f14, float f15) {
        n nVar = this.f38473a;
        this.f38475c = nVar;
        nVar.d(f10, f11, f12, f13, f14, f15);
    }

    public boolean c() {
        return this.f38475c.b();
    }

    public void d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        if (this.f38474b == null) {
            this.f38474b = new k();
        }
        k kVar = this.f38474b;
        this.f38475c = kVar;
        kVar.d(f10, f11, f12, f13, f14, f15, f16, i10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return this.f38475c.getInterpolation(f10);
    }
}
