package P;

import K.InterfaceC0898v;
import M.a;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f5349a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5350b;

    /* renamed from: c, reason: collision with root package name */
    public final Rational f5351c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5352d;

    public l(InterfaceC0898v interfaceC0898v, Rational rational) {
        this.f5349a = interfaceC0898v.e();
        this.f5350b = interfaceC0898v.k();
        this.f5351c = rational;
        boolean z10 = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z10 = false;
        }
        this.f5352d = z10;
    }

    public static Size a(Size size, int i10, int i11, int i12) {
        return (size == null || !e(i10, i11, i12)) ? size : new Size(size.getHeight(), size.getWidth());
    }

    public static Rational b(Size size, List<Size> list) {
        if (size == null) {
            return null;
        }
        for (Rational rational : k.k(list)) {
            if (M.a.a(size, rational)) {
                return rational;
            }
        }
        return new Rational(size.getWidth(), size.getHeight());
    }

    public static boolean e(int i10, int i11, int i12) {
        int iA = M.c.a(M.c.b(i10), i12, 1 == i11);
        return iA == 90 || iA == 270;
    }

    public final Rational c(s sVar, List<Size> list) {
        if (sVar.B()) {
            return k.n(sVar.E(), this.f5352d);
        }
        Size sizeD = d(sVar);
        if (sizeD != null) {
            return b(sizeD, list);
        }
        return null;
    }

    public final Size d(s sVar) {
        return a(sVar.S(null), sVar.I(0), this.f5350b, this.f5349a);
    }

    public List<Size> f(List<Size> list, z<?> zVar) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<Size> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new M.d(true));
        ArrayList arrayList2 = new ArrayList();
        s sVar = (s) zVar;
        Size sizeJ = sVar.j(null);
        Size size = (Size) arrayList.get(0);
        if (sizeJ == null || T.c.b(size) < T.c.b(sizeJ)) {
            sizeJ = size;
        }
        Size sizeD = d(sVar);
        Size size2 = T.c.f5825c;
        int iB = T.c.b(size2);
        if (T.c.b(sizeJ) < iB) {
            size2 = T.c.f5823a;
        } else if (sizeD != null && T.c.b(sizeD) < iB) {
            size2 = sizeD;
        }
        for (Size size3 : arrayList) {
            if (T.c.b(size3) <= T.c.b(sizeJ) && T.c.b(size3) >= T.c.b(size2) && !arrayList2.contains(size3)) {
                arrayList2.add(size3);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size2 + "\nmaxSize = " + sizeJ + "\ninitial size list: " + arrayList);
        }
        Rational rationalC = c(sVar, arrayList2);
        if (sizeD == null) {
            sizeD = sVar.O(null);
        }
        ArrayList arrayList3 = new ArrayList();
        new HashMap();
        if (rationalC == null) {
            arrayList3.addAll(arrayList2);
            if (sizeD != null) {
                k.q(arrayList3, sizeD, true);
                return arrayList3;
            }
        } else {
            Map<Rational, List<Size>> mapO = k.o(arrayList2);
            if (sizeD != null) {
                Iterator<Rational> it = mapO.keySet().iterator();
                while (it.hasNext()) {
                    k.q(mapO.get(it.next()), sizeD, true);
                }
            }
            ArrayList arrayList4 = new ArrayList(mapO.keySet());
            Collections.sort(arrayList4, new a.C0078a(rationalC, this.f5351c));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                for (Size size4 : mapO.get((Rational) it2.next())) {
                    if (!arrayList3.contains(size4)) {
                        arrayList3.add(size4);
                    }
                }
            }
        }
        return arrayList3;
    }
}
