package h9;

import f8.l0;
import f8.t;
import java.util.Comparator;
import t9.s;

/* loaded from: classes.dex */
public final class i implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final i f4237b = new i(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4238a;

    public /* synthetic */ i(int i2) {
        this.f4238a = i2;
    }

    public static int a(f8.j jVar) {
        if (f.m(jVar)) {
            return 8;
        }
        if (jVar instanceof f8.i) {
            return 7;
        }
        if (jVar instanceof l0) {
            return ((l0) jVar).I() == null ? 6 : 5;
        }
        if (jVar instanceof t) {
            return ((t) jVar).I() == null ? 4 : 3;
        }
        if (jVar instanceof f8.e) {
            return 2;
        }
        return jVar instanceof s ? 1 : 0;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Integer numValueOf;
        switch (this.f4238a) {
            case 0:
                f8.j jVar = (f8.j) obj;
                f8.j jVar2 = (f8.j) obj2;
                int iA = a(jVar2) - a(jVar);
                if (iA != 0) {
                    numValueOf = Integer.valueOf(iA);
                } else if (f.n(jVar, 4) && f.n(jVar2, 4)) {
                    numValueOf = 0;
                } else {
                    int iCompareTo = jVar.getName().f3197f.compareTo(jVar2.getName().f3197f);
                    numValueOf = iCompareTo != 0 ? Integer.valueOf(iCompareTo) : null;
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return 0;
            default:
                return ib.k.q(l9.d.g((f8.e) obj).b(), l9.d.g((f8.e) obj2).b());
        }
    }
}
