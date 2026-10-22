package O8;

import O8.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final c f5266a = c.c();

    public interface a {
        boolean a(h.f fVar);
    }

    public static h.a a(h.a aVar) {
        return f5266a.a(aVar);
    }

    public static h.f b(h.f fVar) {
        return f5266a.b(fVar);
    }

    public static h.a c(h.a aVar, String str, a aVar2, h.f... fVarArr) {
        Map map;
        int length = fVarArr != null ? fVarArr.length : 0;
        if (length == 0) {
            map = Collections.EMPTY_MAP;
        } else {
            HashMap map2 = new HashMap(length);
            for (h.f fVar : fVarArr) {
                map2.put(fVar.name(), fVar);
            }
            map = map2;
        }
        List<h.f> listA = aVar.a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (h.f fVar2 : listA) {
            if (aVar2.a(fVar2)) {
                h.f fVar3 = (h.f) map.get(fVar2.name());
                if (fVar3 != null) {
                    arrayList.add(fVar3);
                } else {
                    arrayList.add(b(fVar2));
                }
            }
        }
        return new d(str, arrayList);
    }

    public static h.a d(h.a aVar, String str, h.f... fVarArr) {
        int length = fVarArr != null ? fVarArr.length : 0;
        if (length == 0) {
            return new d(str, a(aVar).a());
        }
        HashMap map = new HashMap(length);
        for (h.f fVar : fVarArr) {
            map.put(fVar.name(), fVar);
        }
        List<h.f> listA = aVar.a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (h.f fVar2 : listA) {
            h.f fVar3 = (h.f) map.get(fVar2.name());
            if (fVar3 != null) {
                arrayList.add(fVar3);
            } else {
                arrayList.add(b(fVar2));
            }
        }
        return new d(str, arrayList);
    }

    public static h.a e(h.f fVar) {
        for (h.c cVar : fVar.a()) {
            if (cVar.d() != null) {
                return cVar.d();
            }
        }
        return null;
    }

    public static h.f f(h.a aVar, String str) {
        return g(aVar, str.split("/"), 0);
    }

    public static h.f g(h.a aVar, String[] strArr, int i10) {
        String str = strArr[i10];
        boolean z10 = i10 == strArr.length - 1;
        for (h.f fVar : aVar.a()) {
            if (str.equals(fVar.name())) {
                if (z10) {
                    return fVar;
                }
                h.a aVarE = e(fVar);
                if (aVarE != null) {
                    return g(aVarE, strArr, i10 + 1);
                }
                return null;
            }
        }
        return null;
    }

    public static void h(h.a aVar, String str, h.f... fVarArr) {
        if (fVarArr == null || fVarArr.length == 0) {
            return;
        }
        i(aVar, str.split("/"), 0, fVarArr);
    }

    public static void i(h.a aVar, String[] strArr, int i10, h.f[] fVarArr) {
        String str = strArr[i10];
        boolean z10 = i10 == strArr.length - 1;
        List<h.f> listA = aVar.a();
        int size = listA.size();
        for (int i11 = 0; i11 < size; i11++) {
            h.f fVar = listA.get(i11);
            if (str.equals(fVar.name())) {
                if (z10) {
                    j(i11, listA, fVarArr);
                    return;
                }
                h.a aVarE = e(fVar);
                if (aVarE != null) {
                    i(aVarE, strArr, i10 + 1, fVarArr);
                    return;
                }
                return;
            }
        }
    }

    public static void j(int i10, List<h.f> list, h.f[] fVarArr) {
        int length = fVarArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            list.add(i10 + i11, fVarArr[i11]);
        }
    }

    public static h.a k(h hVar, String str) {
        h.a aVarA = hVar.a(str);
        if (aVarA != null) {
            return aVarA;
        }
        throw new IllegalStateException("Unexpected state, requested language is not found: " + str);
    }
}
