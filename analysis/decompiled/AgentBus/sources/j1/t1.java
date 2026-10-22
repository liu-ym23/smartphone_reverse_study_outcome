package j1;

import java.util.List;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public final p1.i f5334a;

    /* renamed from: b, reason: collision with root package name */
    public final k.u f5335b;

    public t1(p1.n nVar, k.j jVar) {
        this.f5334a = nVar.f8315d;
        this.f5335b = new k.u(nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0).size());
        List listI = nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0);
        int size = listI.size();
        for (int i2 = 0; i2 < size; i2++) {
            p1.n nVar2 = (p1.n) listI.get(i2);
            if (jVar.a(nVar2.f8318g)) {
                this.f5335b.a(nVar2.f8318g);
            }
        }
    }
}
