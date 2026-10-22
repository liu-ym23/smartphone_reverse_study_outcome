package w;

import w.f;

/* loaded from: classes.dex */
class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f23437m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f23420e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f23420e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // w.f
    public void d(int i5) {
        if (this.f23425j) {
            return;
        }
        this.f23425j = true;
        this.f23422g = i5;
        for (InterfaceC1198d interfaceC1198d : this.f23426k) {
            interfaceC1198d.a(interfaceC1198d);
        }
    }
}
