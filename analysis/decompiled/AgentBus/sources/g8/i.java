package g8;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class i {
    public static c findAnnotation(j jVar, e9.c cVar) {
        Object next;
        q7.k.e(cVar, "fqName");
        Iterator it = jVar.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (q7.k.a(((c) next).a(), cVar)) {
                break;
            }
        }
        return (c) next;
    }

    public static boolean hasAnnotation(j jVar, e9.c cVar) {
        q7.k.e(cVar, "fqName");
        return jVar.b(cVar) != null;
    }
}
