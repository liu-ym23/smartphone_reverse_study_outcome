package tc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final rc.e[] f13030a = new rc.e[0];

    public static final y a(String str, pc.a aVar) {
        return new y(str, new z(aVar));
    }

    public static final Set b(rc.e eVar) {
        kotlin.jvm.internal.g.f(eVar, "<this>");
        if (eVar instanceof k) {
            return ((k) eVar).a();
        }
        HashSet hashSet = new HashSet(eVar.e());
        int iE = eVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            hashSet.add(eVar.f(i10));
        }
        return hashSet;
    }

    public static final rc.e[] c(List list) {
        rc.e[] eVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (rc.e[]) list.toArray(new rc.e[0])) == null) ? f13030a : eVarArr;
    }

    public static final int d(rc.e eVar, rc.e[] typeParams) {
        kotlin.jvm.internal.g.f(typeParams, "typeParams");
        int iHashCode = (eVar.i().hashCode() * 31) + Arrays.hashCode(typeParams);
        rc.g gVar = new rc.g(eVar);
        int iHashCode2 = 1;
        int i10 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!gVar.hasNext()) {
                break;
            }
            int i11 = i10 * 31;
            String strI = ((rc.e) gVar.next()).i();
            if (strI != null) {
                iHashCode3 = strI.hashCode();
            }
            i10 = i11 + iHashCode3;
        }
        rc.g gVar2 = new rc.g(eVar);
        while (gVar2.hasNext()) {
            int i12 = iHashCode2 * 31;
            rc.i iVarD = ((rc.e) gVar2.next()).d();
            iHashCode2 = i12 + (iVarD != null ? iVarD.hashCode() : 0);
        }
        return (((iHashCode * 31) + i10) * 31) + iHashCode2;
    }
}
