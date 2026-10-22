package f9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class l extends o {

    /* renamed from: f, reason: collision with root package name */
    public final i f3568f;

    public l() {
        this.f3568f = new i();
    }

    public final boolean g() {
        a0 a0Var = this.f3568f.f3563a;
        int i2 = 0;
        while (true) {
            if (i2 >= a0Var.f3526g.size()) {
                Iterator it = a0Var.c().iterator();
                while (it.hasNext()) {
                    if (!i.e((Map.Entry) it.next())) {
                    }
                }
                return true;
            }
            if (!i.e((Map.Entry) a0Var.f3526g.get(i2))) {
                break;
            }
            i2++;
        }
        return false;
    }

    public final int h() {
        a0 a0Var = this.f3568f.f3563a;
        int iD = 0;
        for (int i2 = 0; i2 < a0Var.f3526g.size(); i2++) {
            Map.Entry entry = (Map.Entry) a0Var.f3526g.get(i2);
            iD += i.d((m) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : a0Var.c()) {
            iD += i.d((m) entry2.getKey(), entry2.getValue());
        }
        return iD;
    }

    public final Object i(n nVar) {
        m(nVar);
        m mVar = nVar.f3583d;
        Object obj = this.f3568f.f3563a.get(mVar);
        if (obj == null) {
            return nVar.f3581b;
        }
        if (!mVar.f3571h) {
            return nVar.a(obj);
        }
        if (mVar.f3570g.f3578f != n0.f3592n) {
            return obj;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(nVar.a(it.next()));
        }
        return arrayList;
    }

    public final boolean j(n nVar) {
        m(nVar);
        m mVar = nVar.f3583d;
        i iVar = this.f3568f;
        iVar.getClass();
        if (mVar.f3571h) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return iVar.f3563a.get(mVar) != null;
    }

    public final void k() {
        this.f3568f.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(f9.e r9, f9.f r10, f9.h r11, int r12) throws f9.r {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.l.l(f9.e, f9.f, f9.h, int):boolean");
    }

    public final void m(n nVar) {
        if (nVar.f3580a != getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public l(k kVar) {
        kVar.f3566g.f();
        kVar.f3567h = false;
        this.f3568f = kVar.f3566g;
    }
}
