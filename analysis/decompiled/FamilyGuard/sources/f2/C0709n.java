package f2;

import android.util.ArrayMap;
import com.stepos.digitalwellbeing.server.limit.data.room.PeriodLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.RawPeriod;
import com.stepos.digitalwellbeing.server.limit.data.room.RipePeriod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: f2.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0709n {
    public static /* synthetic */ int a(Z1.a aVar, Z1.a aVar2) {
        return (int) (aVar.f6629a - aVar2.f6629a);
    }

    public static /* synthetic */ int b(Z1.a aVar, Z1.a aVar2) {
        return (int) (aVar.f6629a - aVar2.f6629a);
    }

    public static /* synthetic */ int c(Z1.a aVar, Z1.a aVar2) {
        return (int) (aVar.f6629a - aVar2.f6629a);
    }

    public static /* synthetic */ int d(Z1.a aVar, Z1.a aVar2) {
        return (int) (aVar.f6629a - aVar2.f6629a);
    }

    public static /* synthetic */ int e(Z1.a aVar, Z1.a aVar2) {
        return (int) (aVar.f6629a - aVar2.f6629a);
    }

    private static List<RawPeriod> f(List<RawPeriod> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<RawPeriod> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((RawPeriod) it.next().clone());
            }
        }
        return arrayList;
    }

    private static List<Z1.a> g(List<Z1.a> list, int i5) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<Z1.a> it = list.iterator();
            while (it.hasNext()) {
                Z1.a aVar = (Z1.a) it.next().clone();
                if (i5 >= -1) {
                    aVar.f6631c = i5;
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static List<Z1.a> h(List<RawPeriod> list, int i5) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<RawPeriod> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toPeriod(i5));
        }
        return arrayList;
    }

    public static RipePeriod i(PeriodLimit periodLimit, Z1.a aVar, int i5, long j5) {
        if (periodLimit == null) {
            R1.a.b("PeriodMergeUtils", "generate periodLimit = null");
            return null;
        }
        if (aVar == null) {
            R1.a.b("PeriodMergeUtils", "generate period = null");
            return null;
        }
        if (i5 < 0 || i5 > 3) {
            R1.a.b("PeriodMergeUtils", "generate  illegal type = " + i5);
            return null;
        }
        RipePeriod ripePeriod = new RipePeriod(i5 != 1 ? i5 != 2 ? aVar.f6629a : aVar.f6629a - 60000 : aVar.f6630b, periodLimit.getId(), periodLimit.getType(), periodLimit.getAdminId(), periodLimit.getPackageName(), periodLimit.getCategoryId(), j5 + 1, i5, aVar.f6631c);
        R1.a.a("PeriodMergeUtils", "generate periodLimit = " + periodLimit + " period = " + aVar + " type = " + i5 + " result = " + ripePeriod);
        return ripePeriod;
    }

    public static Z1.a j(Z1.a aVar, Z1.a aVar2, int i5) {
        long j5;
        long j6;
        Z1.a aVar3 = aVar == null ? null : (Z1.a) aVar.clone();
        if (aVar3 != null) {
            aVar3.f6631c = i5;
        }
        Z1.a aVar4 = aVar2 == null ? null : (Z1.a) aVar2.clone();
        if (aVar4 != null) {
            aVar4.f6631c = i5;
        }
        if (aVar3 == null) {
            return aVar4;
        }
        if (aVar4 != null && !aVar3.g()) {
            if (!aVar4.g()) {
                if (!aVar3.d() && !aVar4.d()) {
                    long j7 = aVar3.f6629a;
                    long j8 = aVar4.f6629a;
                    if (j7 > j8 || aVar3.f6630b < aVar4.f6630b) {
                        if (j8 > j7 || aVar4.f6630b < aVar3.f6630b) {
                            long j9 = aVar3.f6630b;
                            if (j9 < j8 && j7 > aVar4.f6630b) {
                                return null;
                            }
                            if (j9 >= j8) {
                                j6 = j9;
                                long j10 = aVar4.f6630b;
                                if (j6 < j10) {
                                    return new Z1.a(j7, j10, i5);
                                }
                            } else {
                                j6 = j9;
                            }
                            long j11 = aVar4.f6630b;
                            if (j11 >= j7 && j11 < j6) {
                                return new Z1.a(j8, j6, i5);
                            }
                            R1.a.b("PeriodMergeUtils", "unknown merge status cloneP1 = " + aVar3 + " cloneP2 = " + aVar4);
                            return null;
                        }
                    }
                } else {
                    if (!aVar3.d() || !aVar4.d()) {
                        if (aVar3.d() && !aVar4.d()) {
                            return n(aVar4, aVar3, i5);
                        }
                        if (!aVar4.d() || aVar3.d()) {
                            return null;
                        }
                        return n(aVar3, aVar4, i5);
                    }
                    long j12 = aVar3.f6629a;
                    long j13 = aVar4.f6629a;
                    if (j12 > j13 || aVar3.f6630b < aVar4.f6630b) {
                        if (j13 > j12 || aVar4.f6630b < aVar3.f6630b) {
                            if (j12 < j13) {
                                long j14 = aVar3.f6630b;
                                j5 = j12;
                                long j15 = aVar4.f6630b;
                                if (j14 < j15) {
                                    return new Z1.a(j5, j15, i5);
                                }
                            } else {
                                j5 = j12;
                            }
                            if (j13 < j5) {
                                long j16 = aVar4.f6630b;
                                long j17 = aVar3.f6630b;
                                if (j16 < j17) {
                                    return new Z1.a(j13, j17, i5);
                                }
                            }
                            R1.a.b("PeriodMergeUtils", "unknown merge status cloneP1 = " + aVar3 + " cloneP2 = " + aVar4);
                            return null;
                        }
                    }
                }
            }
            return aVar4;
        }
        return aVar3;
    }

    public static List<Z1.a> k(List<Z1.a> list, int i5) {
        Collections.sort(list, new Comparator() { // from class: f2.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0709n.c((Z1.a) obj, (Z1.a) obj2);
            }
        });
        return m(list, new ArrayList(list), i5);
    }

    public static List<Z1.a> l(List<Z1.a> list, Z1.a aVar, int i5) {
        List<Z1.a> listG = g(list, i5);
        Z1.a aVar2 = aVar == null ? null : (Z1.a) aVar.clone();
        if (aVar2 != null) {
            aVar2.f6631c = i5;
        }
        if (listG == null) {
            if (aVar2 == null) {
                R1.a.l("PeriodMergeUtils", "merge list = null , limit = null");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar2);
            return arrayList;
        }
        int size = listG.size();
        Collections.sort(listG, new Comparator() { // from class: f2.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0709n.a((Z1.a) obj, (Z1.a) obj2);
            }
        });
        ArrayMap arrayMap = new ArrayMap();
        int i6 = 0;
        Z1.a aVar3 = null;
        int i7 = 0;
        while (i7 < size) {
            Z1.a aVarJ = aVar3 != null ? j(listG.get(i7), aVar3, i5) : j(listG.get(i7), aVar2, i5);
            if (aVarJ != null) {
                arrayMap.put(Integer.valueOf(i7), aVarJ);
            } else if (aVar3 != null) {
                break;
            }
            i7++;
            aVar3 = aVarJ;
        }
        ArrayList arrayList2 = new ArrayList(arrayMap.keySet());
        Collections.sort(arrayList2);
        int size2 = arrayList2.size();
        int i8 = 0;
        while (i8 < size2) {
            Object obj = arrayList2.get(i8);
            i8++;
            listG.remove(((Integer) obj).intValue() - i6);
            i6++;
        }
        Z1.a aVar4 = arrayMap.isEmpty() ? null : (Z1.a) arrayMap.values().toArray()[arrayMap.values().size() - 1];
        if (aVar4 != null) {
            listG.add(aVar4);
        } else {
            listG.add(aVar2);
        }
        Collections.sort(listG, new Comparator() { // from class: f2.m
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return C0709n.b((Z1.a) obj2, (Z1.a) obj3);
            }
        });
        return listG;
    }

    public static List<Z1.a> m(List<Z1.a> list, List<Z1.a> list2, int i5) {
        Collections.sort(list2, new Comparator() { // from class: f2.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0709n.d((Z1.a) obj, (Z1.a) obj2);
            }
        });
        Iterator<Z1.a> it = list2.iterator();
        while (it.hasNext()) {
            list = l(list, it.next(), i5);
        }
        return list;
    }

    private static Z1.a n(Z1.a aVar, Z1.a aVar2, int i5) {
        Z1.a aVar3;
        long j5;
        long j6;
        Z1.a aVar4 = aVar == null ? null : (Z1.a) aVar.clone();
        if (aVar4 != null) {
            aVar4.f6631c = i5;
        }
        Z1.a aVar5 = aVar2 == null ? null : (Z1.a) aVar2.clone();
        if (aVar5 != null) {
            aVar5.f6631c = i5;
        }
        if (aVar4 == null) {
            return aVar5;
        }
        if (aVar5 == null) {
            return aVar4;
        }
        if (!aVar5.d()) {
            R1.a.b("PeriodMergeUtils", "Illegal param overDay = " + aVar5);
            return null;
        }
        if (aVar4.d()) {
            R1.a.b("PeriodMergeUtils", "Illegal param inDay = " + aVar4);
            return null;
        }
        long j7 = aVar4.f6629a;
        long j8 = j7 + 86400000;
        long j9 = aVar4.f6630b;
        long j10 = j9 + 86400000;
        long j11 = aVar5.f6629a;
        long j12 = j11 + 86400000;
        if (j7 < j11) {
            aVar3 = null;
            j5 = 86400000;
            if (j10 <= aVar5.f6630b) {
            }
            j6 = aVar5.f6630b;
            if (j6 >= j8 && j12 > j10) {
                return aVar3;
            }
            if (j6 < j8 && j12 > j10) {
                return new Z1.a(j11, j10, i5);
            }
            if (j6 >= j8 && j12 <= j10) {
                return new Z1.a(j7, j6, i5);
            }
            if (j6 < j8 && j12 <= j10) {
                return new Z1.a(j7, j7 + j5, i5);
            }
            R1.a.b("PeriodMergeUtils", "unknown status inDay = " + aVar + " overDay = " + aVar2);
            return aVar3;
        }
        aVar3 = null;
        j5 = 86400000;
        if (j7 <= j9) {
            return aVar5;
        }
        j6 = aVar5.f6630b;
        if (j6 >= j8) {
        }
        if (j6 < j8) {
        }
        if (j6 >= j8) {
        }
        if (j6 < j8) {
        }
        R1.a.b("PeriodMergeUtils", "unknown status inDay = " + aVar + " overDay = " + aVar2);
        return aVar3;
    }

    public static List<Z1.a> o(List<RawPeriod> list, int i5) {
        return k(h(list, i5), i5);
    }

    public static List<Z1.a> p(List<RawPeriod> list, List<RawPeriod> list2, int i5) {
        List<Z1.a> listH = h(list, i5);
        List<Z1.a> listH2 = h(list2, i5);
        List<Z1.a> listK = k(listH, i5);
        Collections.sort(listH2, new Comparator() { // from class: f2.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0709n.e((Z1.a) obj, (Z1.a) obj2);
            }
        });
        Iterator<Z1.a> it = listH2.iterator();
        while (it.hasNext()) {
            listK = l(listK, it.next(), i5);
        }
        return listK;
    }

    public static List<Z1.a> q(List<RawPeriod> list, List<RawPeriod> list2, int i5) {
        List<RawPeriod> listF = f(list);
        List<RawPeriod> listF2 = f(list2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (listF2 != null) {
            for (RawPeriod rawPeriod : listF2) {
                if (rawPeriod.overDay()) {
                    arrayList2.add(rawPeriod);
                }
            }
        }
        if (listF != null) {
            for (RawPeriod rawPeriod2 : listF) {
                if (rawPeriod2.overDay()) {
                    arrayList.add(rawPeriod2);
                }
            }
        }
        if (listF == null || listF.isEmpty()) {
            if (listF2 == null || listF2.isEmpty()) {
                return null;
            }
            return o(arrayList2, i5);
        }
        if (listF2 != null && !listF2.isEmpty()) {
            listF.removeAll(arrayList);
            return p(listF, arrayList2, i5);
        }
        if (listF.isEmpty()) {
            return null;
        }
        listF.removeAll(arrayList);
        return o(listF, i5);
    }
}
