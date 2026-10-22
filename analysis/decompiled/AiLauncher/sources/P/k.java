package P;

import D.C0761b0;
import K.InterfaceC0898v;
import M.a;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0898v f5344a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5345b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5346c;

    /* renamed from: d, reason: collision with root package name */
    public final Rational f5347d;

    /* renamed from: e, reason: collision with root package name */
    public final l f5348e;

    public k(InterfaceC0898v interfaceC0898v, Size size) {
        this.f5344a = interfaceC0898v;
        this.f5345b = interfaceC0898v.e();
        this.f5346c = interfaceC0898v.k();
        Rational rationalH = size != null ? h(size) : i(interfaceC0898v);
        this.f5347d = rationalH;
        this.f5348e = new l(interfaceC0898v, rationalH);
    }

    public static LinkedHashMap<Rational, List<Size>> a(List<Size> list, X.a aVar, Rational rational) {
        return b(o(list), aVar, rational);
    }

    public static LinkedHashMap<Rational, List<Size>> b(Map<Rational, List<Size>> map, X.a aVar, Rational rational) {
        boolean z10 = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z10 = false;
        }
        Rational rationalN = n(aVar.b(), z10);
        if (aVar.a() == 0) {
            Rational rationalN2 = n(aVar.b(), z10);
            Iterator it = new ArrayList(map.keySet()).iterator();
            while (it.hasNext()) {
                Rational rational2 = (Rational) it.next();
                if (!rational2.equals(rationalN2)) {
                    map.remove(rational2);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList, new a.C0078a(rationalN, rational));
        LinkedHashMap<Rational, List<Size>> linkedHashMap = new LinkedHashMap<>();
        for (Rational rational3 : arrayList) {
            linkedHashMap.put(rational3, map.get(rational3));
        }
        return linkedHashMap;
    }

    public static void d(LinkedHashMap<Rational, List<Size>> linkedHashMap, Size size) {
        int iB = T.c.b(size);
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            List<Size> list = linkedHashMap.get(it.next());
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (T.c.b(size2) <= iB) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    public static List<Size> e(List<Size> list, X.b bVar, int i10, int i11, int i12) {
        if (bVar == null) {
            return list;
        }
        List<Size> listA = bVar.a(new ArrayList(list), M.c.a(M.c.b(i10), i11, i12 == 1));
        if (list.containsAll(listA)) {
            return listA;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    public static void f(LinkedHashMap<Rational, List<Size>> linkedHashMap, X.d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            g(linkedHashMap.get(it.next()), dVar);
        }
    }

    public static void g(List<Size> list, X.d dVar) {
        if (list.isEmpty()) {
            return;
        }
        int iB = dVar.b();
        if (dVar.equals(X.d.f6816c)) {
            return;
        }
        Size sizeA = dVar.a();
        if (iB == 0) {
            s(list, sizeA);
            return;
        }
        if (iB == 1) {
            q(list, sizeA, true);
            return;
        }
        if (iB == 2) {
            q(list, sizeA, false);
        } else if (iB == 3) {
            r(list, sizeA, true);
        } else {
            if (iB != 4) {
                return;
            }
            r(list, sizeA, false);
        }
    }

    public static List<Rational> k(List<Size> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(M.a.f4454a);
        arrayList.add(M.a.f4456c);
        for (Size size : list) {
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        arrayList.add(rational);
                        break;
                    }
                    if (M.a.a(size, (Rational) it.next())) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public static Rational n(int i10, boolean z10) {
        if (i10 == -1 || i10 == 0) {
            return z10 ? M.a.f4454a : M.a.f4455b;
        }
        if (i10 == 1) {
            return z10 ? M.a.f4456c : M.a.f4457d;
        }
        C0761b0.c("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i10);
        return null;
    }

    public static Map<Rational, List<Size>> o(List<Size> list) {
        HashMap map = new HashMap();
        Iterator<Rational> it = k(list).iterator();
        while (it.hasNext()) {
            map.put(it.next(), new ArrayList());
        }
        for (Size size : list) {
            for (Rational rational : map.keySet()) {
                if (M.a.a(size, rational)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }

    public static List<Size> p(X.c cVar, List<Size> list, Size size, int i10, Rational rational, int i11, int i12) {
        LinkedHashMap<Rational, List<Size>> linkedHashMapA = a(list, cVar.b(), rational);
        if (size != null) {
            d(linkedHashMapA, size);
        }
        f(linkedHashMapA, cVar.d());
        ArrayList arrayList = new ArrayList();
        Iterator<List<Size>> it = linkedHashMapA.values().iterator();
        while (it.hasNext()) {
            for (Size size2 : it.next()) {
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
        }
        return e(arrayList, cVar.c(), i10, i11, i12);
    }

    public static void q(List<Size> list, Size size, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z10) {
            list.addAll(arrayList);
        }
    }

    public static void r(List<Size> list, Size size, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Size size2 = list.get(i10);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z10) {
            list.addAll(arrayList);
        }
    }

    public static void s(List<Size> list, Size size) {
        boolean zContains = list.contains(size);
        list.clear();
        if (zContains) {
            list.add(size);
        }
    }

    public final List<Size> c(List<Size> list, X.c cVar, int i10) {
        if (cVar.a() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.f5344a.o(i10));
        Collections.sort(arrayList, new M.d(true));
        return arrayList;
    }

    public final Rational h(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    public final Rational i(InterfaceC0898v interfaceC0898v) {
        List<Size> listT = interfaceC0898v.t(256);
        if (listT.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(listT, new M.d());
        return new Rational(size.getWidth(), size.getHeight());
    }

    public final List<Size> j(List<Pair<Integer, Size[]>> list, int i10) {
        List<Size> listL = l(list, i10);
        if (listL == null) {
            listL = this.f5344a.t(i10);
        }
        ArrayList arrayList = new ArrayList(listL);
        Collections.sort(arrayList, new M.d(true));
        if (arrayList.isEmpty()) {
            C0761b0.o("SupportedOutputSizesCollector", "The retrieved supported resolutions from camera info internal is empty. Format is " + i10 + ".");
        }
        return arrayList;
    }

    public final List<Size> l(List<Pair<Integer, Size[]>> list, int i10) {
        Size[] sizeArr;
        if (list != null) {
            for (Pair<Integer, Size[]> pair : list) {
                if (((Integer) pair.first).intValue() == i10) {
                    sizeArr = (Size[]) pair.second;
                    break;
                }
            }
            sizeArr = null;
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    public List<Size> m(z<?> zVar) {
        s sVar = (s) zVar;
        List<Size> listL = sVar.L(null);
        if (listL != null) {
            return listL;
        }
        X.c cVarR = sVar.R(null);
        List<Size> listJ = j(sVar.l(null), zVar.o());
        if (cVarR == null) {
            return this.f5348e.f(listJ, zVar);
        }
        Size sizeJ = ((s) zVar).j(null);
        int I10 = sVar.I(0);
        if (!zVar.c0(false)) {
            listJ = c(listJ, cVarR, zVar.o());
        }
        List<Size> list = listJ;
        C0761b0.a("SupportedOutputSizesCollector", "useCaseConfig = " + zVar + ", candidateSizes = " + list);
        return p(sVar.m(), list, sizeJ, I10, this.f5347d, this.f5345b, this.f5346c);
    }
}
