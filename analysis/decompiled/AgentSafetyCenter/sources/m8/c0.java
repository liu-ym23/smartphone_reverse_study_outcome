package m8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import s8.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k0 f8320c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LocalDate f8321f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f8322g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f8323h;
    public final /* synthetic */ f i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(k0 k0Var, LocalDate localDate, long j10, String str, f fVar, nb.c cVar) {
        super(2, cVar);
        this.f8320c = k0Var;
        this.f8321f = localDate;
        this.f8322g = j10;
        this.f8323h = str;
        this.i = fVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new c0(this.f8320c, this.f8321f, this.f8322g, this.f8323h, this.i, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        String str;
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        LocalDate localDate = this.f8321f;
        localDate.getClass();
        f fVar = this.i;
        LinkedHashMap linkedHashMap = fVar.f8343a;
        LinkedHashMap linkedHashMap2 = fVar.f8344b;
        LinkedHashMap linkedHashMap3 = fVar.f8345c;
        k0 k0Var = this.f8320c;
        k0Var.getClass();
        long j10 = this.f8322g;
        ec.g gVarO = p5.f.O(0, (int) j10);
        ArrayList arrayList = new ArrayList(kb.m.m0(gVarO, 10));
        ec.a it = gVarO.iterator();
        while (it.f3752h) {
            LocalDate localDateMinusDays = localDate.minusDays((j10 - 1) - it.nextInt());
            q8.t tVarU = k0Var.u();
            localDateMinusDays.getClass();
            long j11 = tVarU.j(localDateMinusDays);
            Long lValueOf = Long.valueOf(j11);
            k0 k0Var2 = k0Var;
            Integer num = (Integer) linkedHashMap.get(Long.valueOf(j11));
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 0);
            LinkedHashMap linkedHashMap4 = linkedHashMap;
            Integer num2 = (Integer) linkedHashMap2.get(Long.valueOf(j11));
            Integer numValueOf2 = Integer.valueOf(num2 != null ? num2.intValue() : 0);
            Integer num3 = (Integer) linkedHashMap3.get(Long.valueOf(j11));
            arrayList.add(new jb.l(localDateMinusDays, lValueOf, new jb.l(numValueOf, numValueOf2, Integer.valueOf(num3 != null ? num3.intValue() : 0))));
            k0Var = k0Var2;
            linkedHashMap = linkedHashMap4;
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            g5.f.k();
            return null;
        }
        int iIntValue = ((Number) ((jb.l) ((jb.l) it2.next()).f6771g).f6769c).intValue();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) ((jb.l) ((jb.l) it2.next()).f6771g).f6769c).intValue();
            if (iIntValue < iIntValue2) {
                iIntValue = iIntValue2;
            }
        }
        if (iIntValue < 1) {
            iIntValue = 1;
        }
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            jb.l lVar = (jb.l) obj2;
            LocalDate localDate2 = (LocalDate) lVar.f6769c;
            long jLongValue = ((Number) lVar.f6770f).longValue();
            jb.l lVar2 = (jb.l) lVar.f6771g;
            int iIntValue3 = ((Number) lVar2.f6769c).intValue();
            int iIntValue4 = ((Number) lVar2.f6770f).intValue();
            int iIntValue5 = ((Number) lVar2.f6771g).intValue();
            float fP = iIntValue3 > 0 ? p5.f.p(iIntValue3 / iIntValue, 0.0f, 1.0f) : 0.0f;
            boolean zEquals = localDate2.equals(localDate);
            if (zEquals) {
                str = this.f8323h;
            } else {
                str = localDate2.getMonthValue() + "/" + localDate2.getDayOfMonth();
            }
            arrayList2.add(new m1(str, fP, zEquals, jLongValue, iIntValue3, iIntValue4, iIntValue5, jLongValue, (String) null));
        }
        return arrayList2;
    }
}
