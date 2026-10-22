package lb;

import java.lang.invoke.VarHandle;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends b4.c implements Iterator, zb.a {
    public final /* synthetic */ int i;

    public d(f fVar, int i) {
        this.i = i;
        fVar.getClass();
        this.f1900h = fVar;
        this.f1898f = -1;
        this.f1899g = fVar.f7844l;
        e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.i) {
            case 0:
                b();
                int i = this.f1897c;
                f fVar = (f) this.f1900h;
                if (i >= fVar.f7842j) {
                    g5.f.k();
                    break;
                } else {
                    this.f1897c = i + 1;
                    this.f1898f = i;
                    e eVar = new e();
                    eVar.f7834c = fVar;
                    eVar.f7835f = i;
                    eVar.f7836g = fVar.f7844l;
                    VarHandle.storeStoreFence();
                    e();
                    break;
                }
            case 1:
                b();
                int i3 = this.f1897c;
                f fVar2 = (f) this.f1900h;
                if (i3 >= fVar2.f7842j) {
                    g5.f.k();
                    break;
                } else {
                    this.f1897c = i3 + 1;
                    this.f1898f = i3;
                    Object obj = fVar2.f7838c[i3];
                    e();
                    break;
                }
            default:
                b();
                int i10 = this.f1897c;
                f fVar3 = (f) this.f1900h;
                if (i10 >= fVar3.f7842j) {
                    g5.f.k();
                    break;
                } else {
                    this.f1897c = i10 + 1;
                    this.f1898f = i10;
                    Object[] objArr = fVar3.f7839f;
                    objArr.getClass();
                    Object obj2 = objArr[this.f1898f];
                    e();
                    break;
                }
        }
        return null;
    }
}
