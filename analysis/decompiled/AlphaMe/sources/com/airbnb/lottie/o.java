package com.airbnb.lottie;

/* loaded from: classes.dex */
public final class o implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4558a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f4559b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f4560c;

    public /* synthetic */ o(v vVar, float f4, int i4) {
        this.f4558a = i4;
        this.f4560c = vVar;
        this.f4559b = f4;
    }

    @Override // com.airbnb.lottie.u
    public final void run() {
        int i4 = this.f4558a;
        float f4 = this.f4559b;
        v vVar = this.f4560c;
        switch (i4) {
            case 0:
                vVar.n(f4);
                break;
            case 1:
                vVar.m(f4);
                break;
            default:
                vVar.i(f4);
                break;
        }
    }
}
