package xc;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final vc.e[] f15604a = new vc.e[0];

    /* renamed from: b, reason: collision with root package name */
    public static final tc.a[] f15605b = new tc.a[0];

    public static final o a(String str, tc.a aVar) {
        p pVar = new p();
        pVar.f15653a = aVar;
        VarHandle.storeStoreFence();
        o oVar = new o(str, pVar, 1);
        oVar.f15651l = true;
        VarHandle.storeStoreFence();
        return oVar;
    }

    public static final Set b(vc.e eVar) {
        eVar.getClass();
        if (eVar instanceof f) {
            return ((f) eVar).b();
        }
        HashSet hashSet = new HashSet(eVar.d());
        int iD = eVar.d();
        for (int i = 0; i < iD; i++) {
            hashSet.add(eVar.e(i));
        }
        return hashSet;
    }

    public static final vc.e[] c(List list) {
        vc.e[] eVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (vc.e[]) list.toArray(new vc.e[0])) == null) ? f15604a : eVarArr;
    }

    public static final int d(vc.e eVar, vc.e[] eVarArr) {
        eVarArr.getClass();
        int iHashCode = (eVar.a().hashCode() * 31) + Arrays.hashCode(eVarArr);
        int iD = eVar.d();
        int i = 1;
        while (true) {
            int iHashCode2 = 0;
            if (!(iD > 0)) {
                break;
            }
            int i3 = iD - 1;
            int i10 = i * 31;
            String strA = eVar.f(eVar.d() - iD).a();
            if (strA != null) {
                iHashCode2 = strA.hashCode();
            }
            i = i10 + iHashCode2;
            iD = i3;
        }
        int iD2 = eVar.d();
        int iHashCode3 = 1;
        while (true) {
            if (!(iD2 > 0)) {
                return (((iHashCode * 31) + i) * 31) + iHashCode3;
            }
            int i11 = iD2 - 1;
            int i12 = iHashCode3 * 31;
            t.o kind = eVar.f(eVar.d() - iD2).getKind();
            iHashCode3 = i12 + (kind != null ? kind.hashCode() : 0);
            iD2 = i11;
        }
    }
}
