package w;

import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import s.AbstractC0831a;
import v.AbstractC0950j;
import v.C0944d;
import v.C0945e;
import v.C0948h;

/* renamed from: w.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0959e {

    /* renamed from: a, reason: collision with root package name */
    public C0945e f15744a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15745b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15746c;

    /* renamed from: d, reason: collision with root package name */
    public C0945e f15747d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f15748e;

    /* renamed from: f, reason: collision with root package name */
    public C0968n f15749f;

    /* renamed from: g, reason: collision with root package name */
    public C0956b f15750g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f15751h;

    public final void a(C0960f c0960f, int i4, ArrayList arrayList, C0966l c0966l) {
        p pVar = c0960f.f15755d;
        if (pVar.f15787c == null) {
            C0945e c0945e = this.f15744a;
            if (pVar == c0945e.f15555d || pVar == c0945e.f15557e) {
                return;
            }
            if (c0966l == null) {
                c0966l = new C0966l();
                c0966l.f15767a = null;
                c0966l.f15768b = new ArrayList();
                c0966l.f15767a = pVar;
                arrayList.add(c0966l);
            }
            pVar.f15787c = c0966l;
            c0966l.f15768b.add(pVar);
            C0960f c0960f2 = pVar.f15792h;
            Iterator it = c0960f2.f15762k.iterator();
            while (it.hasNext()) {
                InterfaceC0958d interfaceC0958d = (InterfaceC0958d) it.next();
                if (interfaceC0958d instanceof C0960f) {
                    a((C0960f) interfaceC0958d, i4, arrayList, c0966l);
                }
            }
            C0960f c0960f3 = pVar.f15793i;
            Iterator it2 = c0960f3.f15762k.iterator();
            while (it2.hasNext()) {
                InterfaceC0958d interfaceC0958d2 = (InterfaceC0958d) it2.next();
                if (interfaceC0958d2 instanceof C0960f) {
                    a((C0960f) interfaceC0958d2, i4, arrayList, c0966l);
                }
            }
            if (i4 == 1 && (pVar instanceof C0967m)) {
                Iterator it3 = ((C0967m) pVar).f15769k.f15762k.iterator();
                while (it3.hasNext()) {
                    InterfaceC0958d interfaceC0958d3 = (InterfaceC0958d) it3.next();
                    if (interfaceC0958d3 instanceof C0960f) {
                        a((C0960f) interfaceC0958d3, i4, arrayList, c0966l);
                    }
                }
            }
            Iterator it4 = c0960f2.f15763l.iterator();
            while (it4.hasNext()) {
                a((C0960f) it4.next(), i4, arrayList, c0966l);
            }
            Iterator it5 = c0960f3.f15763l.iterator();
            while (it5.hasNext()) {
                a((C0960f) it5.next(), i4, arrayList, c0966l);
            }
            if (i4 == 1 && (pVar instanceof C0967m)) {
                Iterator it6 = ((C0967m) pVar).f15769k.f15763l.iterator();
                while (it6.hasNext()) {
                    a((C0960f) it6.next(), i4, arrayList, c0966l);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x025c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(v.C0945e r17) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C0959e.b(v.e):void");
    }

    public final void c() {
        ArrayList arrayList = this.f15748e;
        arrayList.clear();
        C0945e c0945e = this.f15747d;
        c0945e.f15555d.f();
        c0945e.f15557e.f();
        arrayList.add(c0945e.f15555d);
        arrayList.add(c0945e.f15557e);
        Iterator it = c0945e.f15674q0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            C0944d c0944d = (C0944d) it.next();
            if (c0944d instanceof C0948h) {
                C0963i c0963i = new C0963i(c0944d);
                c0944d.f15555d.f();
                c0944d.f15557e.f();
                c0963i.f15790f = ((C0948h) c0944d).f15669u0;
                arrayList.add(c0963i);
            } else {
                if (c0944d.y()) {
                    if (c0944d.f15551b == null) {
                        c0944d.f15551b = new C0957c(0, c0944d);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c0944d.f15551b);
                } else {
                    arrayList.add(c0944d.f15555d);
                }
                if (c0944d.z()) {
                    if (c0944d.f15553c == null) {
                        c0944d.f15553c = new C0957c(1, c0944d);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c0944d.f15553c);
                } else {
                    arrayList.add(c0944d.f15557e);
                }
                if (c0944d instanceof AbstractC0950j) {
                    arrayList.add(new C0964j(c0944d));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((p) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p pVar = (p) it3.next();
            if (pVar.f15786b != c0945e) {
                pVar.d();
            }
        }
        ArrayList arrayList2 = this.f15751h;
        arrayList2.clear();
        C0945e c0945e2 = this.f15744a;
        e(c0945e2.f15555d, 0, arrayList2);
        e(c0945e2.f15557e, 1, arrayList2);
        this.f15745b = false;
    }

    public final int d(C0945e c0945e, int i4) {
        ArrayList arrayList;
        int i5;
        long jMax;
        float f4;
        C0945e c0945e2 = c0945e;
        ArrayList arrayList2 = this.f15751h;
        int size = arrayList2.size();
        long j4 = 0;
        int i6 = 0;
        long jMax2 = 0;
        while (i6 < size) {
            p pVar = ((C0966l) arrayList2.get(i6)).f15767a;
            if (!(pVar instanceof C0957c) ? !(i4 != 0 ? (pVar instanceof C0967m) : (pVar instanceof C0965k)) : ((C0957c) pVar).f15790f != i4) {
                C0960f c0960f = (i4 == 0 ? c0945e2.f15555d : c0945e2.f15557e).f15792h;
                C0960f c0960f2 = (i4 == 0 ? c0945e2.f15555d : c0945e2.f15557e).f15793i;
                boolean zContains = pVar.f15792h.f15763l.contains(c0960f);
                C0960f c0960f3 = pVar.f15793i;
                boolean zContains2 = c0960f3.f15763l.contains(c0960f2);
                long j5 = pVar.j();
                C0960f c0960f4 = pVar.f15792h;
                if (zContains && zContains2) {
                    long jB = C0966l.b(c0960f4, j4);
                    arrayList = arrayList2;
                    long jA = C0966l.a(c0960f3, j4);
                    long j6 = jB - j5;
                    int i7 = c0960f3.f15757f;
                    i5 = i6;
                    if (j6 >= (-i7)) {
                        j6 += i7;
                    }
                    long j7 = c0960f4.f15757f;
                    long j8 = ((-jA) - j5) - j7;
                    if (j8 >= j7) {
                        j8 -= j7;
                    }
                    C0944d c0944d = pVar.f15786b;
                    if (i4 == 0) {
                        f4 = c0944d.f15556d0;
                    } else if (i4 == 1) {
                        f4 = c0944d.f15558e0;
                    } else {
                        c0944d.getClass();
                        f4 = -1.0f;
                    }
                    float f5 = f4 > Property.DEFAULT_FLOAT_VALUE ? (long) ((j6 / (1.0f - f4)) + (j8 / f4)) : 0L;
                    jMax = (c0960f4.f15757f + ((((long) ((f5 * f4) + 0.5f)) + j5) + ((long) AbstractC0831a.c(1.0f, f4, f5, 0.5f)))) - c0960f3.f15757f;
                } else {
                    arrayList = arrayList2;
                    i5 = i6;
                    jMax = zContains ? Math.max(C0966l.b(c0960f4, c0960f4.f15757f), c0960f4.f15757f + j5) : zContains2 ? Math.max(-C0966l.a(c0960f3, c0960f3.f15757f), (-c0960f3.f15757f) + j5) : (pVar.j() + c0960f4.f15757f) - c0960f3.f15757f;
                }
            } else {
                arrayList = arrayList2;
                jMax = j4;
                i5 = i6;
            }
            jMax2 = Math.max(jMax2, jMax);
            i6 = i5 + 1;
            arrayList2 = arrayList;
            c0945e2 = c0945e;
            j4 = 0;
        }
        return (int) jMax2;
    }

    public final void e(p pVar, int i4, ArrayList arrayList) {
        C0960f c0960f;
        Iterator it = pVar.f15792h.f15762k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            c0960f = pVar.f15793i;
            if (!zHasNext) {
                break;
            }
            InterfaceC0958d interfaceC0958d = (InterfaceC0958d) it.next();
            if (interfaceC0958d instanceof C0960f) {
                a((C0960f) interfaceC0958d, i4, arrayList, null);
            } else if (interfaceC0958d instanceof p) {
                a(((p) interfaceC0958d).f15792h, i4, arrayList, null);
            }
        }
        Iterator it2 = c0960f.f15762k.iterator();
        while (it2.hasNext()) {
            InterfaceC0958d interfaceC0958d2 = (InterfaceC0958d) it2.next();
            if (interfaceC0958d2 instanceof C0960f) {
                a((C0960f) interfaceC0958d2, i4, arrayList, null);
            } else if (interfaceC0958d2 instanceof p) {
                a(((p) interfaceC0958d2).f15793i, i4, arrayList, null);
            }
        }
        if (i4 == 1) {
            Iterator it3 = ((C0967m) pVar).f15769k.f15762k.iterator();
            while (it3.hasNext()) {
                InterfaceC0958d interfaceC0958d3 = (InterfaceC0958d) it3.next();
                if (interfaceC0958d3 instanceof C0960f) {
                    a((C0960f) interfaceC0958d3, i4, arrayList, null);
                }
            }
        }
    }

    public final void f(C0944d c0944d, int i4, int i5, int i6, int i7) {
        C0956b c0956b = this.f15750g;
        c0956b.f15732a = i4;
        c0956b.f15733b = i6;
        c0956b.f15734c = i5;
        c0956b.f15735d = i7;
        this.f15749f.b(c0944d, c0956b);
        c0944d.P(c0956b.f15736e);
        c0944d.M(c0956b.f15737f);
        c0944d.f15528E = c0956b.f15739h;
        c0944d.J(c0956b.f15738g);
    }

    public final void g() {
        C0955a c0955a;
        Iterator it = this.f15744a.f15674q0.iterator();
        while (it.hasNext()) {
            C0944d c0944d = (C0944d) it.next();
            if (!c0944d.f15549a) {
                int[] iArr = c0944d.f15580p0;
                boolean z4 = false;
                int i4 = iArr[0];
                int i5 = iArr[1];
                int i6 = c0944d.f15582r;
                int i7 = c0944d.f15583s;
                boolean z5 = i4 == 2 || (i4 == 3 && i6 == 1);
                if (i5 == 2 || (i5 == 3 && i7 == 1)) {
                    z4 = true;
                }
                C0961g c0961g = c0944d.f15555d.f15789e;
                boolean z6 = c0961g.f15761j;
                C0961g c0961g2 = c0944d.f15557e.f15789e;
                boolean z7 = c0961g2.f15761j;
                if (z6 && z7) {
                    f(c0944d, 1, c0961g.f15758g, 1, c0961g2.f15758g);
                    c0944d.f15549a = true;
                } else if (z6 && z4) {
                    f(c0944d, 1, c0961g.f15758g, 2, c0961g2.f15758g);
                    if (i5 == 3) {
                        c0944d.f15557e.f15789e.f15764m = c0944d.l();
                    } else {
                        c0944d.f15557e.f15789e.d(c0944d.l());
                        c0944d.f15549a = true;
                    }
                } else if (z7 && z5) {
                    f(c0944d, 2, c0961g.f15758g, 1, c0961g2.f15758g);
                    if (i4 == 3) {
                        c0944d.f15555d.f15789e.f15764m = c0944d.r();
                    } else {
                        c0944d.f15555d.f15789e.d(c0944d.r());
                        c0944d.f15549a = true;
                    }
                }
                if (c0944d.f15549a && (c0955a = c0944d.f15557e.f15770l) != null) {
                    c0955a.d(c0944d.f15550a0);
                }
            }
        }
    }
}
