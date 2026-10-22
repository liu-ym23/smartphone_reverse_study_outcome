package G0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class s implements c, H0.a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f579a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final int f580b;

    /* renamed from: c, reason: collision with root package name */
    public final H0.c f581c;

    /* renamed from: d, reason: collision with root package name */
    public final H0.c f582d;

    /* renamed from: e, reason: collision with root package name */
    public final H0.c f583e;

    public s(M0.b bVar, L0.p pVar) {
        pVar.getClass();
        this.f580b = pVar.f1212a;
        H0.b bVarC = pVar.f1213b.c();
        this.f581c = (H0.c) bVarC;
        H0.b bVarC2 = pVar.f1214c.c();
        this.f582d = (H0.c) bVarC2;
        H0.b bVarC3 = pVar.f1215d.c();
        this.f583e = (H0.c) bVarC3;
        bVar.c(bVarC);
        bVar.c(bVarC2);
        bVar.c(bVarC3);
        bVarC.a(this);
        bVarC2.a(this);
        bVarC3.a(this);
    }

    @Override // H0.a
    public final void a() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f579a;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((H0.a) arrayList.get(i4)).a();
            i4++;
        }
    }

    @Override // G0.c
    public final void b(List list, List list2) {
    }

    public final void c(H0.a aVar) {
        this.f579a.add(aVar);
    }
}
