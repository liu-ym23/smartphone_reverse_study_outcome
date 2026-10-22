package w5;

import c5.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.v;
import kotlin.jvm.internal.p;

/* loaded from: classes.dex */
public abstract class k extends v {
    public static i w0(Iterator it) {
        p.e(it, "<this>");
        return new a(new c5.k(4, it));
    }

    public static List x0(i iVar) {
        Iterator it = iVar.iterator();
        if (!it.hasNext()) {
            return s.f1092a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a.a.S(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
