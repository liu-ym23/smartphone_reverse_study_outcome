package Y;

import D.C0761b0;
import K.InterfaceC0898v;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    public static final double f6924h = Math.sqrt(2.3703703703703702d);

    /* renamed from: a, reason: collision with root package name */
    public final Size f6925a;

    /* renamed from: b, reason: collision with root package name */
    public final Rational f6926b;

    /* renamed from: c, reason: collision with root package name */
    public final Rational f6927c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<z<?>> f6928d;

    /* renamed from: e, reason: collision with root package name */
    public final P.k f6929e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0898v f6930f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<z<?>, List<Size>> f6931g;

    public static class a implements Comparator<Rational> {

        /* renamed from: a, reason: collision with root package name */
        public final Rational f6932a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6933b;

        public a(Rational rational, boolean z10) {
            this.f6932a = rational;
            this.f6933b = z10;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Rational rational, Rational rational2) {
            float fC = c.c(rational, this.f6932a);
            float fC2 = c.c(rational2, this.f6932a);
            return this.f6933b ? Float.compare(fC2, fC) : Float.compare(fC, fC2);
        }
    }

    public c(CameraInternal cameraInternal, Set<z<?>> set) {
        this(M.o.l(cameraInternal.i().j()), cameraInternal.i(), set);
    }

    public static boolean A(Collection<Size> collection, Size size) {
        Iterator<Size> it = collection.iterator();
        while (it.hasNext()) {
            if (!y(it.next(), size)) {
                return true;
            }
        }
        return false;
    }

    public static List<Size> E(List<Size> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static Rect F(Rect rect) {
        return new Rect(rect.top, rect.left, rect.bottom, rect.right);
    }

    public static void M(List<Size> list) {
        Collections.sort(list, new M.d(true));
    }

    public static Rational N(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    public static Rational O(Size size) {
        Rational rational = M.a.f4454a;
        if (M.a.a(size, rational)) {
            return rational;
        }
        Rational rational2 = M.a.f4456c;
        return M.a.a(size, rational2) ? rational2 : N(size);
    }

    public static float c(Rational rational, Rational rational2) {
        float fFloatValue = rational.floatValue();
        float fFloatValue2 = rational2.floatValue();
        return fFloatValue > fFloatValue2 ? fFloatValue2 / fFloatValue : fFloatValue / fFloatValue2;
    }

    public static List<Size> e(List<Size> list) {
        Rational rationalN;
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Size size : list) {
            Iterator it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    rationalN = null;
                    break;
                }
                rationalN = (Rational) it.next();
                if (M.a.a(size, rationalN)) {
                    break;
                }
            }
            if (rationalN != null) {
                Size size2 = (Size) map.get(rationalN);
                Objects.requireNonNull(size2);
                if (size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth() || (size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight())) {
                }
            } else {
                rationalN = N(size);
            }
            arrayList.add(size);
            map.put(rationalN, size);
        }
        return arrayList;
    }

    public static List<Size> f(Collection<Size> collection, List<Size> list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : list) {
            if (A(collection, size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    public static List<Size> g(Rational rational, List<Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Size size : list) {
            if (M.a.a(size, rational)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    public static Rational h(Size size) {
        return ((double) size.getWidth()) / ((double) size.getHeight()) > f6924h ? M.a.f4456c : M.a.f4454a;
    }

    public static Rect k(Rational rational, Size size) {
        RectF rectF;
        RectF rectF2;
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rationalN = N(size);
        if (rational.floatValue() == rationalN.floatValue()) {
            rectF2 = new RectF(0.0f, 0.0f, width, height);
        } else {
            if (rational.floatValue() > rationalN.floatValue()) {
                float f10 = width;
                float fFloatValue = f10 / rational.floatValue();
                float f11 = (height - fFloatValue) / 2.0f;
                rectF = new RectF(0.0f, f11, f10, fFloatValue + f11);
            } else {
                float f12 = height;
                float fFloatValue2 = rational.floatValue() * f12;
                float f13 = (width - fFloatValue2) / 2.0f;
                rectF = new RectF(f13, 0.0f, fFloatValue2 + f13, f12);
            }
            rectF2 = rectF;
        }
        Rect rect = new Rect();
        rectF2.round(rect);
        return rect;
    }

    public static Rect m(Size size, Size size2) {
        return k(N(size2), size);
    }

    public static Rational n(Rational rational) {
        Rational rational2 = M.a.f4454a;
        if (rational.equals(rational2)) {
            return M.a.f4456c;
        }
        if (rational.equals(M.a.f4456c)) {
            return rational2;
        }
        throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + rational);
    }

    public static List<Size> p(Collection<Size> collection, List<Size> list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        List<Size> listE = E(list);
        ArrayList arrayList = new ArrayList();
        for (Size size : listE) {
            if (z(collection, size)) {
                arrayList.add(size);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public static Rational u(Size size) {
        Rational rationalH = h(size);
        C0761b0.a("ResolutionsMerger", "The closer aspect ratio to the sensor size (" + size + ") is " + rationalH + ".");
        return rationalH;
    }

    public static List<Size> w(List<Pair<Integer, Size[]>> list) {
        for (Pair<Integer, Size[]> pair : list) {
            if (((Integer) pair.first).equals(34)) {
                return Arrays.asList((Size[]) pair.second);
            }
        }
        return new ArrayList();
    }

    public static boolean y(Size size, Size size2) {
        return size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth();
    }

    public static boolean z(Collection<Size> collection, Size size) {
        Iterator<Size> it = collection.iterator();
        while (it.hasNext()) {
            if (y(it.next(), size)) {
                return false;
            }
        }
        return true;
    }

    public final boolean B(Rational rational, Size size) {
        if (this.f6926b.equals(rational) || M.a.a(size, rational)) {
            return false;
        }
        return b(this.f6926b.floatValue(), rational.floatValue(), O(size).floatValue());
    }

    public final boolean C(Size size, Size size2) {
        return B(O(size), size2);
    }

    public final boolean D() {
        Iterator<Size> it = l().iterator();
        while (it.hasNext()) {
            if (!M.a.a(it.next(), this.f6927c)) {
                return true;
            }
        }
        return false;
    }

    public final List<Size> G(List<Size> list, boolean z10) {
        Map<Rational, List<Size>> mapX = x(list);
        ArrayList arrayList = new ArrayList(mapX.keySet());
        L(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Rational rational : arrayList) {
            if (!rational.equals(M.a.f4456c) && !rational.equals(M.a.f4454a)) {
                List<Size> list2 = mapX.get(rational);
                Objects.requireNonNull(list2);
                arrayList2.addAll(I(rational, list2, z10));
            }
        }
        return arrayList2;
    }

    public final List<Size> H(List<Size> list) {
        ArrayList arrayList = new ArrayList();
        if (D()) {
            arrayList.addAll(I(this.f6926b, list, false));
        }
        int size = arrayList.size();
        if (K()) {
            size = 0;
        }
        arrayList.addAll(size, I(this.f6927c, list, false));
        arrayList.addAll(G(list, false));
        if (arrayList.isEmpty()) {
            C0761b0.o("ResolutionsMerger", "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
            arrayList.addAll(G(list, true));
        }
        C0761b0.a("ResolutionsMerger", "Parent resolutions: " + arrayList);
        return arrayList;
    }

    public final List<Size> I(Rational rational, List<Size> list, boolean z10) {
        List<Size> listG = g(rational, list);
        M(listG);
        HashSet hashSet = new HashSet(listG);
        Iterator<z<?>> it = this.f6928d.iterator();
        while (it.hasNext()) {
            List<Size> listV = v(it.next());
            if (!z10) {
                listV = d(rational, listV);
            }
            if (listV.isEmpty()) {
                return new ArrayList();
            }
            listG = f(listV, listG);
            hashSet.retainAll(p(listV, listG));
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : listG) {
            if (!hashSet.contains(size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    public final boolean J() {
        boolean z10;
        X.c cVarR;
        Iterator<z<?>> it = this.f6928d.iterator();
        while (true) {
            z10 = false;
            if (!it.hasNext()) {
                break;
            }
            z<?> next = it.next();
            if (!next.c0(false) && (next instanceof s) && (cVarR = ((s) next).R(null)) != null) {
                z10 = true;
                if (cVarR.a() == 1) {
                    break;
                }
            }
        }
        return z10;
    }

    public final boolean K() {
        if (this.f6928d.isEmpty()) {
            return false;
        }
        Iterator<z<?>> it = this.f6928d.iterator();
        while (it.hasNext()) {
            Iterator<Size> it2 = v(it.next()).iterator();
            boolean z10 = false;
            boolean z11 = false;
            while (it2.hasNext()) {
                boolean zA = M.a.a(it2.next(), this.f6927c);
                if (zA) {
                    z10 = true;
                }
                if (z11 && zA) {
                    return false;
                }
                if (!zA) {
                    z11 = true;
                }
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public final void L(List<Rational> list) {
        Collections.sort(list, new a(N(this.f6925a), true));
    }

    public final boolean b(float f10, float f11, float f12) {
        if (f10 != f11 && f11 != f12) {
            if (f10 > f11) {
                return f11 < f12;
            }
            if (f11 > f12) {
                return true;
            }
        }
        return false;
    }

    public final List<Size> d(Rational rational, List<Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Size size : list) {
            if (!B(rational, size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    public final List<Size> i() {
        return this.f6930f.o(34);
    }

    public final List<Size> j() {
        return this.f6930f.t(34);
    }

    public final Set<Size> l() {
        HashSet hashSet = new HashSet();
        Iterator<z<?>> it = this.f6928d.iterator();
        while (it.hasNext()) {
            hashSet.addAll(v(it.next()));
        }
        return hashSet;
    }

    public List<Size> o(t tVar) {
        List<Size> listJ = j();
        if (J()) {
            ArrayList arrayList = new ArrayList(listJ);
            arrayList.addAll(i());
            listJ = arrayList;
        }
        List list = (List) tVar.g(s.f11493x, null);
        if (list != null) {
            listJ = w(list);
        }
        return H(listJ);
    }

    public PreferredChildSize q(z<?> zVar, Rect rect, int i10, boolean z10) {
        boolean z11;
        if (M.o.h(i10)) {
            rect = F(rect);
            z11 = true;
        } else {
            z11 = false;
        }
        PreferredChildSize preferredChildSizeT = t(rect, zVar, z10);
        return z11 ? new PreferredChildSize(F(preferredChildSizeT.getCropRectBeforeScaling()), M.o.m(preferredChildSizeT.getChildSizeToScale()), preferredChildSizeT.getOriginalSelectedChildSize()) : preferredChildSizeT;
    }

    public Size r(Size size, z<?> zVar) {
        List<Size> listV = v(zVar);
        for (Size size2 : listV) {
            if (!C(size, size2) && !y(size2, size)) {
                return size2;
            }
        }
        for (Size size3 : listV) {
            if (!y(size3, size)) {
                return size3;
            }
        }
        return size;
    }

    public Pair<Size, Size> s(Size size, z<?> zVar) {
        for (Size size2 : v(zVar)) {
            Size sizeL = M.o.l(m(size2, size));
            if (!y(sizeL, size)) {
                return Pair.create(size2, sizeL);
            }
        }
        return Pair.create(size, size);
    }

    public final PreferredChildSize t(Rect rect, z<?> zVar, boolean z10) {
        Size sizeR;
        Size size;
        if (z10) {
            Pair<Size, Size> pairS = s(M.o.l(rect), zVar);
            sizeR = (Size) pairS.first;
            size = (Size) pairS.second;
        } else {
            Size sizeL = M.o.l(rect);
            sizeR = r(sizeL, zVar);
            rect = m(sizeL, sizeR);
            size = sizeR;
        }
        return new PreferredChildSize(rect, size, sizeR);
    }

    public final List<Size> v(z<?> zVar) {
        if (!this.f6928d.contains(zVar)) {
            throw new IllegalArgumentException("Invalid child config: " + zVar);
        }
        if (this.f6931g.containsKey(zVar)) {
            List<Size> list = this.f6931g.get(zVar);
            Objects.requireNonNull(list);
            return list;
        }
        List<Size> listE = e(this.f6929e.m(zVar));
        this.f6931g.put(zVar, listE);
        return listE;
    }

    public final Map<Rational, List<Size>> x(List<Size> list) {
        List arrayList;
        HashMap map = new HashMap();
        Rational rational = M.a.f4454a;
        map.put(rational, new ArrayList());
        Rational rational2 = M.a.f4456c;
        map.put(rational2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(rational);
        arrayList2.add(rational2);
        for (Size size : list) {
            if (size.getHeight() > 0) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        arrayList = null;
                        break;
                    }
                    Rational rational3 = (Rational) it.next();
                    if (M.a.a(size, rational3)) {
                        arrayList = (List) map.get(rational3);
                        break;
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    Rational rationalN = N(size);
                    arrayList2.add(rationalN);
                    map.put(rationalN, arrayList);
                }
                arrayList.add(size);
            }
        }
        return map;
    }

    public c(Size size, InterfaceC0898v interfaceC0898v, Set<z<?>> set) {
        this(size, interfaceC0898v, set, new P.k(interfaceC0898v, size));
    }

    public c(Size size, InterfaceC0898v interfaceC0898v, Set<z<?>> set, P.k kVar) {
        this.f6931g = new HashMap();
        this.f6925a = size;
        Rational rationalU = u(size);
        this.f6926b = rationalU;
        this.f6927c = n(rationalU);
        this.f6930f = interfaceC0898v;
        this.f6928d = set;
        this.f6929e = kVar;
    }
}
