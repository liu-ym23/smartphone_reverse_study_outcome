package X8;

import java.util.List;

/* loaded from: classes4.dex */
public final class x implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1538a = 1;
    public final K b;
    public final List c;

    public x(Q8.o oVar, H h, K k, List list, boolean z10) {
        this.b = k;
        this.c = list;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Y8.f refiner = (Y8.f) obj;
        switch (this.f1538a) {
            case 0:
                kotlin.jvm.internal.k.f(refiner, "refiner");
                this.b.d();
                break;
            default:
                kotlin.jvm.internal.k.f(refiner, "kotlinTypeRefiner");
                this.b.d();
                break;
        }
        return null;
    }

    public x(H h, K k, List list, boolean z10) {
        this.b = k;
        this.c = list;
    }
}
