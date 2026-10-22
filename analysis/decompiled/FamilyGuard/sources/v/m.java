package v;

import java.util.ArrayList;
import s.C1045c;

/* loaded from: classes.dex */
public class m extends e {

    /* renamed from: L0, reason: collision with root package name */
    public ArrayList<e> f23213L0 = new ArrayList<>();

    public void b(e eVar) {
        this.f23213L0.add(eVar);
        if (eVar.K() != null) {
            ((m) eVar.K()).t1(eVar);
        }
        eVar.c1(this);
    }

    public ArrayList<e> r1() {
        return this.f23213L0;
    }

    public void s1() {
        ArrayList<e> arrayList = this.f23213L0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = this.f23213L0.get(i5);
            if (eVar instanceof m) {
                ((m) eVar).s1();
            }
        }
    }

    @Override // v.e
    public void t0() {
        this.f23213L0.clear();
        super.t0();
    }

    public void t1(e eVar) {
        this.f23213L0.remove(eVar);
        eVar.t0();
    }

    public void u1() {
        this.f23213L0.clear();
    }

    @Override // v.e
    public void w0(C1045c c1045c) {
        super.w0(c1045c);
        int size = this.f23213L0.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f23213L0.get(i5).w0(c1045c);
        }
    }
}
