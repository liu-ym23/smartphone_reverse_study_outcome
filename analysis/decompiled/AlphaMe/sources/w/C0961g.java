package w;

import java.util.Iterator;

/* renamed from: w.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0961g extends C0960f {

    /* renamed from: m, reason: collision with root package name */
    public int f15764m;

    public C0961g(p pVar) {
        super(pVar);
        if (pVar instanceof C0965k) {
            this.f15756e = 2;
        } else {
            this.f15756e = 3;
        }
    }

    @Override // w.C0960f
    public final void d(int i4) {
        if (this.f15761j) {
            return;
        }
        this.f15761j = true;
        this.f15758g = i4;
        Iterator it = this.f15762k.iterator();
        while (it.hasNext()) {
            InterfaceC0958d interfaceC0958d = (InterfaceC0958d) it.next();
            interfaceC0958d.a(interfaceC0958d);
        }
    }
}
