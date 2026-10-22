package ea;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d7.r;
import d7.z;
import e8.n;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final i f3241a = new i();

    public static final void a(AbstractCollection abstractCollection, Object obj) {
        if (obj != null) {
            abstractCollection.add(obj);
        }
    }

    public static final List d(ArrayList arrayList) {
        q7.k.e(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return z.f2978f;
        }
        if (size == 1) {
            return a.a.S(r.N0(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static Object e(List list, a aVar, k kVar) {
        a7.d dVar = new a7.d(6);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f(it.next(), aVar, dVar, kVar);
        }
        return kVar.i();
    }

    public static void f(Object obj, a aVar, a7.d dVar, k kVar) {
        if (obj != null) {
            if (((HashSet) dVar.f411g).add(obj) && kVar.c(obj)) {
                Iterator it = aVar.b(obj).iterator();
                while (it.hasNext()) {
                    f(it.next(), aVar, dVar, kVar);
                }
                kVar.b(obj);
                return;
            }
            return;
        }
        Object[] objArr = new Object[3];
        switch (22) {
            case 1:
            case 5:
            case 8:
            case 11:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
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
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "node";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (22) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[2] = "topologicalOrder";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
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

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean[], java.io.Serializable] */
    public static Boolean g(List list, a aVar, p7.k kVar) {
        return (Boolean) e(list, aVar, new n(kVar, new boolean[1], 1));
    }

    public static final boolean h(Throwable th) {
        Class<?> superclass = th.getClass();
        while (!q7.k.a(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static void j(Object obj) throws Throwable {
        if (obj instanceof j) {
            throw ((j) obj).f3240a;
        }
    }

    public void b(Object obj) {
    }

    public abstract boolean c(Object obj);

    public abstract Object i();
}
