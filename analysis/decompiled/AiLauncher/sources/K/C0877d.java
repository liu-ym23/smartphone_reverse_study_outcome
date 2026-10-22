package K;

import android.view.AbstractC1404w;

/* renamed from: K.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0877d extends Y {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0898v f3949b;

    /* renamed from: c, reason: collision with root package name */
    public final z0 f3950c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3951d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3952e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.camera.core.impl.g f3953f;

    /* renamed from: g, reason: collision with root package name */
    public AbstractC1404w<D.F0> f3954g;

    public C0877d(InterfaceC0898v interfaceC0898v, androidx.camera.core.impl.g gVar) {
        super(interfaceC0898v);
        this.f3951d = false;
        this.f3952e = false;
        this.f3954g = null;
        this.f3949b = interfaceC0898v;
        this.f3953f = gVar;
        this.f3950c = gVar.T(null);
        f(gVar.i());
        d(gVar.b0());
    }

    @Override // K.Y, K.InterfaceC0898v
    public boolean B() {
        int[] iArrG;
        z0 z0Var = this.f3950c;
        if (z0Var == null || (iArrG = z0Var.g()) == null) {
            return super.B();
        }
        for (int i10 : iArrG) {
            if (i10 == 2) {
                return true;
            }
        }
        return false;
    }

    public androidx.camera.core.impl.g b() {
        return this.f3953f;
    }

    public void d(boolean z10) {
        this.f3952e = z10;
    }

    public void f(boolean z10) {
        this.f3951d = z10;
    }

    @Override // K.Y, K.InterfaceC0898v
    public InterfaceC0898v getImplementation() {
        return this.f3949b;
    }

    @Override // K.Y, K.InterfaceC0898v
    public boolean v() {
        int[] iArrG;
        z0 z0Var = this.f3950c;
        if (z0Var == null || (iArrG = z0Var.g()) == null) {
            return super.v();
        }
        for (int i10 : iArrG) {
            if (i10 == 1) {
                return true;
            }
        }
        return false;
    }
}
