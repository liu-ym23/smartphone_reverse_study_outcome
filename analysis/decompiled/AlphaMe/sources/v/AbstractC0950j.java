package v;

import java.util.ArrayList;
import w.o;

/* renamed from: v.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0950j extends C0944d implements InterfaceC0949i {

    /* renamed from: q0, reason: collision with root package name */
    public C0944d[] f15671q0 = new C0944d[4];

    /* renamed from: r0, reason: collision with root package name */
    public int f15672r0 = 0;

    public final void S(int i4, o oVar, ArrayList arrayList) {
        for (int i5 = 0; i5 < this.f15672r0; i5++) {
            C0944d c0944d = this.f15671q0[i5];
            ArrayList arrayList2 = oVar.f15780a;
            if (!arrayList2.contains(c0944d)) {
                arrayList2.add(c0944d);
            }
        }
        for (int i6 = 0; i6 < this.f15672r0; i6++) {
            B0.f.u(this.f15671q0[i6], i4, arrayList, oVar);
        }
    }

    public void a() {
    }
}
