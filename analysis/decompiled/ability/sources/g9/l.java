package g9;

import D7.v;
import H4.o;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import w0.C2086g;

/* loaded from: classes4.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final j f4509a = new j();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static final void b(AbstractCollection abstractCollection, Object obj) {
        if (obj != null) {
            abstractCollection.add(obj);
        }
    }

    public static final List e(ArrayList arrayList) {
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return EmptyList.f4893a;
        }
        if (size == 1) {
            return o.M(v.A0(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static i f() {
        return new i(0);
    }

    public static Object g(Collection collection, InterfaceC1474a interfaceC1474a, l lVar) {
        HashSet hashSet = new HashSet();
        C2086g c2086g = new C2086g();
        c2086g.f6811a = hashSet;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            h(it.next(), interfaceC1474a, c2086g, lVar);
        }
        return lVar.k();
    }

    public static void h(Object obj, InterfaceC1474a interfaceC1474a, C2086g c2086g, l lVar) {
        if (obj == null) {
            a(22);
            throw null;
        }
        if (((HashSet) c2086g.f6811a).add(obj) && lVar.d(obj)) {
            Iterator it = interfaceC1474a.c(obj).iterator();
            while (it.hasNext()) {
                h(it.next(), interfaceC1474a, c2086g, lVar);
            }
            lVar.c(obj);
        }
    }

    public static Boolean i(Collection collection, InterfaceC1474a interfaceC1474a, S7.k kVar) {
        if (kVar != null) {
            return (Boolean) g(collection, interfaceC1474a, new N8.c(kVar, new boolean[1]));
        }
        a(9);
        throw null;
    }

    public static final boolean j(Throwable th) {
        Class<?> superclass = th.getClass();
        while (!kotlin.jvm.internal.k.b(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static void l(Object obj) throws Throwable {
        if (obj instanceof k) {
            throw ((k) obj).f4508a;
        }
    }

    public void c(Object obj) {
    }

    public abstract boolean d(Object obj);

    public abstract Object k();
}
