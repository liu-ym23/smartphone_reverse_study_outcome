package x4;

import s4.G0;

/* loaded from: classes.dex */
final class N {

    /* renamed from: a, reason: collision with root package name */
    public final Z3.i f23844a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f23845b;

    /* renamed from: c, reason: collision with root package name */
    private final G0<Object>[] f23846c;

    /* renamed from: d, reason: collision with root package name */
    private int f23847d;

    public N(Z3.i iVar, int i5) {
        this.f23844a = iVar;
        this.f23845b = new Object[i5];
        this.f23846c = new G0[i5];
    }

    public final void a(G0<?> g02, Object obj) {
        Object[] objArr = this.f23845b;
        int i5 = this.f23847d;
        objArr[i5] = obj;
        G0<Object>[] g0Arr = this.f23846c;
        this.f23847d = i5 + 1;
        j4.k.e(g02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        g0Arr[i5] = g02;
    }

    public final void b(Z3.i iVar) {
        int length = this.f23846c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i5 = length - 1;
            G0<Object> g02 = this.f23846c[length];
            j4.k.d(g02);
            g02.V(iVar, this.f23845b[length]);
            if (i5 < 0) {
                return;
            } else {
                length = i5;
            }
        }
    }
}
