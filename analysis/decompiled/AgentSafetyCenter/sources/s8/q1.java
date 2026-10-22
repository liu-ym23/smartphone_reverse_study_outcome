package s8;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q1 {
    public static List a(LocalDate localDate, ZoneId zoneId, List list, String str, String str2, boolean z10, int i, Map map, Map map2, Map map3) {
        boolean z11;
        int i3;
        int i10;
        int i11;
        String str3;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        zoneId.getClass();
        list.getClass();
        str.getClass();
        str2.getClass();
        int iL = kb.x.L(kb.m.m0(list, 10));
        if (iL < 16) {
            iL = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((q8.i) obj).f10121a), obj);
        }
        LocalDate localDateNow = LocalDate.now(zoneId);
        long epochMilli = localDateNow.atStartOfDay(zoneId).toInstant().toEpochMilli();
        ec.g gVar = new ec.g(0, 6, 1);
        ArrayList arrayList = new ArrayList();
        ec.a it = gVar.iterator();
        while (it.f3752h) {
            long j10 = epochMilli;
            LocalDate localDateMinusDays = localDate.minusDays(6 - it.nextInt());
            long epochMilli2 = localDateMinusDays.atStartOfDay(zoneId).toInstant().toEpochMilli();
            q8.i iVar = (q8.i) linkedHashMap.get(Long.valueOf(epochMilli2));
            jb.l lVar = iVar == null ? null : new jb.l(localDateMinusDays, Long.valueOf(epochMilli2), iVar);
            if (lVar != null) {
                arrayList.add(lVar);
            }
            epochMilli = j10;
        }
        long j11 = epochMilli;
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            z11 = false;
        } else {
            int size = arrayList2.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj2 = arrayList2.get(i12);
                i12++;
                if (((Number) ((jb.l) obj2).f6770f).longValue() == j11) {
                    z11 = true;
                    break;
                }
            }
            z11 = false;
        }
        if (!z10 || z11) {
            i3 = 1;
            i10 = 0;
        } else {
            i3 = 1;
            i10 = 0;
            arrayList2.add(new jb.l(localDateNow, Long.valueOf(j11), new q8.i(j11, "{}", i < 0 ? 0 : i, 0, 0L)));
        }
        if (arrayList2.isEmpty()) {
            return kb.s.f7404c;
        }
        if (arrayList2.size() > i3) {
            kb.p.o0(new r(6), arrayList2);
        }
        Iterator it2 = arrayList2.iterator();
        if (!it2.hasNext()) {
            g5.f.k();
            return null;
        }
        jb.l lVar2 = (jb.l) it2.next();
        int iIntValue = (map == null || (num5 = (Integer) map.get(Long.valueOf(((Number) lVar2.f6770f).longValue()))) == null) ? ((q8.i) lVar2.f6771g).f10123c : num5.intValue();
        loop2: while (true) {
            i11 = iIntValue;
            while (it2.hasNext()) {
                jb.l lVar3 = (jb.l) it2.next();
                iIntValue = (map == null || (num4 = (Integer) map.get(Long.valueOf(((Number) lVar3.f6770f).longValue()))) == null) ? ((q8.i) lVar3.f6771g).f10123c : num4.intValue();
                if (i11 < iIntValue) {
                    break;
                }
            }
        }
        if (i11 < i3) {
            i11 = i3;
        }
        ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList2, 10));
        int size2 = arrayList2.size();
        int i13 = i10;
        while (i13 < size2) {
            Object obj3 = arrayList2.get(i13);
            i13++;
            jb.l lVar4 = (jb.l) obj3;
            LocalDate localDate2 = (LocalDate) lVar4.f6769c;
            long jLongValue = ((Number) lVar4.f6770f).longValue();
            q8.i iVar2 = (q8.i) lVar4.f6771g;
            int iIntValue2 = (map == null || (num3 = (Integer) map.get(Long.valueOf(jLongValue))) == null) ? iVar2.f10123c : num3.intValue();
            int iIntValue3 = (map2 == null || (num2 = (Integer) map2.get(Long.valueOf(jLongValue))) == null) ? iVar2.f10124d : num2.intValue();
            int iIntValue4 = (map3 == null || (num = (Integer) map3.get(Long.valueOf(jLongValue))) == null) ? i10 : num.intValue();
            float fP = iIntValue2 > 0 ? p5.f.p(iIntValue2 / i11, 0.0f, 1.0f) : 0.0f;
            if (localDate2.equals(localDateNow) && !hc.h.g0(str)) {
                str3 = str;
            } else if (!localDate2.equals(localDateNow.minusDays(1L)) || hc.h.g0(str2)) {
                str3 = localDate2.getMonthValue() + "/" + localDate2.getDayOfMonth();
            } else {
                str3 = str2;
            }
            arrayList3.add(new m1(str3, fP, localDate2.equals(localDate), jLongValue, iIntValue2, iIntValue3, iIntValue4, (String) null, 384));
        }
        return arrayList3;
    }
}
