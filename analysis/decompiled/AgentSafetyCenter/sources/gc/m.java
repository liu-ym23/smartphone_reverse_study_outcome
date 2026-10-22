package gc;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kb.s;

/* loaded from: classes.dex */
public abstract class m extends o {
    public static k R(Iterator it) {
        it.getClass();
        n nVar = new n(1);
        nVar.f4705b = it;
        VarHandle.storeStoreFence();
        a aVar = new a();
        aVar.f4677a = new AtomicReference(nVar);
        VarHandle.storeStoreFence();
        return aVar;
    }

    public static k S(Object obj, xb.l lVar) {
        if (obj == null) {
            return f.f4685a;
        }
        ab.e eVar = new ab.e(3);
        eVar.f393f = obj;
        VarHandle.storeStoreFence();
        i iVar = new i(1);
        iVar.f4694b = eVar;
        iVar.f4695c = lVar;
        VarHandle.storeStoreFence();
        return iVar;
    }

    public static String T(k kVar, String str) {
        kVar.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i = 0;
        for (Object obj : kVar) {
            i++;
            if (i > 1) {
                sb2.append((CharSequence) str);
            }
            id.c.e(sb2, obj, null);
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public static List U(k kVar) {
        Iterator it = kVar.iterator();
        if (!it.hasNext()) {
            return s.f7404c;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ac.a.E(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
