package com.airbnb.lottie;

/* loaded from: classes.dex */
public final class n implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4555a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4556b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f4557c;

    public /* synthetic */ n(v vVar, int i4, int i5) {
        this.f4555a = i5;
        this.f4557c = vVar;
        this.f4556b = i4;
    }

    @Override // com.airbnb.lottie.u
    public final void run() {
        int i4 = this.f4555a;
        int i5 = this.f4556b;
        v vVar = this.f4557c;
        switch (i4) {
            case 0:
                vVar.g(i5);
                break;
            case 1:
                vVar.l(i5);
                break;
            default:
                vVar.h(i5);
                break;
        }
    }
}
