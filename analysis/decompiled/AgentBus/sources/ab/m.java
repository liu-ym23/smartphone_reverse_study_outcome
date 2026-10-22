package ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class m implements n.o {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f577f;

    public m(int i2) {
        this.f577f = new ArrayList(i2);
    }

    public void a(Object obj) {
        this.f577f.add(obj);
    }

    public void b(String str, String str2) {
        q7.k.e(str, "name");
        q7.k.e(str2, "value");
        ArrayList arrayList = this.f577f;
        arrayList.add(str);
        arrayList.add(ga.k.N0(str2).toString());
    }

    public void c(Object obj) {
        if (obj == null) {
            return;
        }
        boolean z4 = obj instanceof Object[];
        ArrayList arrayList = this.f577f;
        if (z4) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(arrayList, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            arrayList.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else {
            if (!(obj instanceof Iterator)) {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
    }

    public n d() {
        return new n((String[]) this.f577f.toArray(new String[0]));
    }

    public void e(String str) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f577f;
            if (i2 >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i2))) {
                arrayList.remove(i2);
                arrayList.remove(i2);
                i2 -= 2;
            }
            i2 += 2;
        }
    }

    @Override // n.o
    public n.w get(int i2) {
        return (n.x) this.f577f.get(i2);
    }

    public m() {
        this.f577f = new ArrayList(20);
    }

    public m(float f10, n.n nVar) {
        v7.d dVarN = nb.i.N(0, nVar.b());
        ArrayList arrayList = new ArrayList(d7.t.A0(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (cVar.f10528h) {
                arrayList.add(new n.x(f10, nVar.a(cVar.nextInt())));
            } else {
                this.f577f = arrayList;
                return;
            }
        }
    }
}
