package k3;

import a6.w;
import android.util.Log;
import c5.m;
import c5.o;
import c5.t;
import com.stepos.cpuset.internal.CpuSetNative;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeMap;
import k4.v;
import kotlin.jvm.internal.p;
import m5.l;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3584a = null;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.util.List] */
    static {
        Map map;
        List listN0;
        String str;
        long j4;
        long j8;
        ?? arrayList = new ArrayList();
        File file = new File("/sys/devices/system/cpu/online");
        int i8 = 0;
        if (file.exists()) {
            try {
                for (String str2 : n.G1(n.T1(l.E0(file, x5.a.f6276a)).toString(), new String[]{","}, 0, 6)) {
                    if (n.g1(str2, "-", false)) {
                        List listG1 = n.G1(str2, new String[]{"-"}, 0, 6);
                        int i9 = Integer.parseInt((String) listG1.get(0));
                        int i10 = Integer.parseInt((String) listG1.get(1));
                        if (i9 <= i10) {
                            while (true) {
                                arrayList.add(Integer.valueOf(i9));
                                if (i9 != i10) {
                                    i9++;
                                }
                            }
                        }
                    } else {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                }
            } catch (Exception e9) {
                e9.printStackTrace();
                arrayList = m.N0(v.r0(0, Runtime.getRuntime().availableProcessors()));
            }
        } else {
            arrayList = m.N0(v.r0(0, Runtime.getRuntime().availableProcessors()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            try {
                j4 = Long.parseLong(n.T1(l.E0(new File(a8.b.k(iIntValue, "/sys/devices/system/cpu/cpu", "/cpufreq/cpuinfo_max_freq")), x5.a.f6276a)).toString());
            } catch (Exception unused) {
                j4 = 0;
            }
            try {
                j8 = Long.parseLong(n.T1(l.E0(new File(a8.b.k(iIntValue, "/sys/devices/system/cpu/cpu", "/cpufreq/cpuinfo_min_freq")), x5.a.f6276a)).toString());
            } catch (Exception unused2) {
                j8 = 0;
            }
            if (j4 > 0) {
                arrayList2.add(new b(iIntValue, j4, j8, a.d));
            }
        }
        if (arrayList2.isEmpty()) {
            map = t.f1093a;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                Long lValueOf = Long.valueOf(((b) obj).f3582b);
                Object arrayList3 = linkedHashMap.get(lValueOf);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap.put(lValueOf, arrayList3);
                }
                ((List) arrayList3).add(obj);
            }
            TreeMap treeMap = new TreeMap(e5.a.f2367c);
            treeMap.putAll(linkedHashMap);
            Set setKeySet = treeMap.keySet();
            p.d(setKeySet, "<get-keys>(...)");
            List listN02 = m.N0(setKeySet);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            int size2 = listN02.size();
            if (size2 == 1) {
                int size3 = arrayList2.size();
                if (size3 >= 8) {
                    a aVar = a.d;
                    List listK0 = m.K0(2, arrayList2);
                    ArrayList arrayList4 = new ArrayList(o.n0(listK0, 10));
                    Iterator it2 = listK0.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(b.a((b) it2.next(), a.d));
                    }
                    linkedHashMap2.put(aVar, m.O0(arrayList4));
                    a aVar2 = a.f3579c;
                    List listSubList = arrayList2.subList(2, 6);
                    ArrayList arrayList5 = new ArrayList(o.n0(listSubList, 10));
                    Iterator it3 = listSubList.iterator();
                    while (it3.hasNext()) {
                        arrayList5.add(b.a((b) it3.next(), a.f3579c));
                    }
                    linkedHashMap2.put(aVar2, m.O0(arrayList5));
                    a aVar3 = a.f3578b;
                    List listSubList2 = arrayList2.subList(6, size3 - 1);
                    ArrayList arrayList6 = new ArrayList(o.n0(listSubList2, 10));
                    Iterator it4 = listSubList2.iterator();
                    while (it4.hasNext()) {
                        arrayList6.add(b.a((b) it4.next(), a.f3578b));
                    }
                    linkedHashMap2.put(aVar3, m.O0(arrayList6));
                    a aVar4 = a.f3577a;
                    List listS = a.a.S(m.B0(arrayList2));
                    ArrayList arrayList7 = new ArrayList(o.n0(listS, 10));
                    Iterator it5 = listS.iterator();
                    while (it5.hasNext()) {
                        arrayList7.add(b.a((b) it5.next(), a.f3577a));
                    }
                    linkedHashMap2.put(aVar4, m.O0(arrayList7));
                } else {
                    a aVar5 = a.f3579c;
                    ArrayList arrayList8 = new ArrayList(o.n0(arrayList2, 10));
                    int size4 = arrayList2.size();
                    while (i8 < size4) {
                        Object obj2 = arrayList2.get(i8);
                        i8++;
                        arrayList8.add(b.a((b) obj2, a.f3579c));
                    }
                    linkedHashMap2.put(aVar5, m.O0(arrayList8));
                }
            } else if (size2 == 2) {
                Long l3 = (Long) listN02.get(0);
                Long l6 = (Long) listN02.get(1);
                Object obj3 = treeMap.get(l3);
                p.b(obj3);
                List list = (List) obj3;
                Object obj4 = treeMap.get(l6);
                p.b(obj4);
                List list2 = (List) obj4;
                int size5 = list.size() / 2;
                a aVar6 = a.f3578b;
                List listK02 = m.K0(size5, list);
                ArrayList arrayList9 = new ArrayList(o.n0(listK02, 10));
                Iterator it6 = listK02.iterator();
                while (it6.hasNext()) {
                    arrayList9.add(b.a((b) it6.next(), a.f3578b));
                }
                linkedHashMap2.put(aVar6, m.O0(arrayList9));
                a aVar7 = a.f3577a;
                List listR0 = m.r0(list, size5);
                ArrayList arrayList10 = new ArrayList(o.n0(listR0, 10));
                Iterator it7 = listR0.iterator();
                while (it7.hasNext()) {
                    arrayList10.add(b.a((b) it7.next(), a.f3577a));
                }
                linkedHashMap2.put(aVar7, m.O0(arrayList10));
                int size6 = list2.size() / 2;
                a aVar8 = a.f3579c;
                List listK03 = m.K0(size6, list2);
                ArrayList arrayList11 = new ArrayList(o.n0(listK03, 10));
                Iterator it8 = listK03.iterator();
                while (it8.hasNext()) {
                    arrayList11.add(b.a((b) it8.next(), a.f3579c));
                }
                linkedHashMap2.put(aVar8, m.O0(arrayList11));
                a aVar9 = a.d;
                List listR02 = m.r0(list2, size6);
                ArrayList arrayList12 = new ArrayList(o.n0(listR02, 10));
                Iterator it9 = listR02.iterator();
                while (it9.hasNext()) {
                    arrayList12.add(b.a((b) it9.next(), a.d));
                }
                linkedHashMap2.put(aVar9, m.O0(arrayList12));
            } else if (size2 != 3) {
                Set setEntrySet = treeMap.entrySet();
                p.d(setEntrySet, "<get-entries>(...)");
                List listN03 = m.N0(setEntrySet);
                a aVar10 = a.f3577a;
                Object value = ((Map.Entry) listN03.get(0)).getValue();
                p.d(value, "<get-value>(...)");
                Iterable iterable = (Iterable) value;
                ArrayList arrayList13 = new ArrayList(o.n0(iterable, 10));
                Iterator it10 = iterable.iterator();
                while (it10.hasNext()) {
                    arrayList13.add(b.a((b) it10.next(), a.f3577a));
                }
                linkedHashMap2.put(aVar10, m.O0(arrayList13));
                a aVar11 = a.f3578b;
                Object value2 = ((Map.Entry) listN03.get(1)).getValue();
                p.d(value2, "<get-value>(...)");
                Iterable iterable2 = (Iterable) value2;
                ArrayList arrayList14 = new ArrayList(o.n0(iterable2, 10));
                Iterator it11 = iterable2.iterator();
                while (it11.hasNext()) {
                    arrayList14.add(b.a((b) it11.next(), a.f3578b));
                }
                linkedHashMap2.put(aVar11, m.O0(arrayList14));
                a aVar12 = a.d;
                Object value3 = ((Map.Entry) m.B0(listN03)).getValue();
                p.d(value3, "<get-value>(...)");
                Iterable iterable3 = (Iterable) value3;
                ArrayList arrayList15 = new ArrayList(o.n0(iterable3, 10));
                Iterator it12 = iterable3.iterator();
                while (it12.hasNext()) {
                    arrayList15.add(b.a((b) it12.next(), a.d));
                }
                linkedHashMap2.put(aVar12, m.O0(arrayList15));
                if (listN03.size() > 3) {
                    ArrayList arrayList16 = new ArrayList();
                    int size7 = listN03.size() - 1;
                    for (int i12 = 2; i12 < size7; i12++) {
                        Object value4 = ((Map.Entry) listN03.get(i12)).getValue();
                        p.d(value4, "<get-value>(...)");
                        Iterable iterable4 = (Iterable) value4;
                        ArrayList arrayList17 = new ArrayList(o.n0(iterable4, 10));
                        Iterator it13 = iterable4.iterator();
                        while (it13.hasNext()) {
                            arrayList17.add(b.a((b) it13.next(), a.f3579c));
                        }
                        arrayList16.addAll(arrayList17);
                    }
                    if (!arrayList16.isEmpty()) {
                        linkedHashMap2.put(a.f3579c, arrayList16);
                    }
                } else {
                    a aVar13 = a.f3579c;
                    Object value5 = ((Map.Entry) listN03.get(2)).getValue();
                    p.d(value5, "<get-value>(...)");
                    Iterable iterable5 = (Iterable) value5;
                    ArrayList arrayList18 = new ArrayList(o.n0(iterable5, 10));
                    Iterator it14 = iterable5.iterator();
                    while (it14.hasNext()) {
                        arrayList18.add(b.a((b) it14.next(), a.f3579c));
                    }
                    linkedHashMap2.put(aVar13, m.O0(arrayList18));
                }
            } else {
                Long l8 = (Long) listN02.get(0);
                Long l9 = (Long) listN02.get(1);
                Long l10 = (Long) listN02.get(2);
                a aVar14 = a.f3577a;
                Object obj5 = treeMap.get(l8);
                p.b(obj5);
                Iterable iterable6 = (Iterable) obj5;
                ArrayList arrayList19 = new ArrayList(o.n0(iterable6, 10));
                Iterator it15 = iterable6.iterator();
                while (it15.hasNext()) {
                    arrayList19.add(b.a((b) it15.next(), a.f3577a));
                }
                linkedHashMap2.put(aVar14, m.O0(arrayList19));
                a aVar15 = a.f3578b;
                Object obj6 = treeMap.get(l9);
                p.b(obj6);
                Iterable iterable7 = (Iterable) obj6;
                ArrayList arrayList20 = new ArrayList(o.n0(iterable7, 10));
                Iterator it16 = iterable7.iterator();
                while (it16.hasNext()) {
                    arrayList20.add(b.a((b) it16.next(), a.f3578b));
                }
                linkedHashMap2.put(aVar15, m.O0(arrayList20));
                Object obj7 = treeMap.get(l10);
                p.b(obj7);
                List list3 = (List) obj7;
                if (list3.size() > 2) {
                    a aVar16 = a.f3579c;
                    int size8 = list3.size();
                    if (2 >= size8) {
                        listN0 = m.N0(list3);
                    } else {
                        ArrayList arrayList21 = new ArrayList(2);
                        if (list3 instanceof RandomAccess) {
                            for (int i13 = size8 - 2; i13 < size8; i13++) {
                                arrayList21.add(list3.get(i13));
                            }
                        } else {
                            ListIterator listIterator = list3.listIterator(size8 - 2);
                            while (listIterator.hasNext()) {
                                arrayList21.add(listIterator.next());
                            }
                        }
                        listN0 = arrayList21;
                    }
                    ArrayList arrayList22 = new ArrayList(o.n0(listN0, 10));
                    Iterator it17 = listN0.iterator();
                    while (it17.hasNext()) {
                        arrayList22.add(b.a((b) it17.next(), a.f3579c));
                    }
                    linkedHashMap2.put(aVar16, m.O0(arrayList22));
                    a aVar17 = a.d;
                    List listS0 = m.s0(2, list3);
                    ArrayList arrayList23 = new ArrayList(o.n0(listS0, 10));
                    Iterator it18 = listS0.iterator();
                    while (it18.hasNext()) {
                        arrayList23.add(b.a((b) it18.next(), a.d));
                    }
                    linkedHashMap2.put(aVar17, m.O0(arrayList23));
                } else {
                    a aVar18 = a.d;
                    ArrayList arrayList24 = new ArrayList(o.n0(list3, 10));
                    Iterator it19 = list3.iterator();
                    while (it19.hasNext()) {
                        arrayList24.add(b.a((b) it19.next(), a.d));
                    }
                    linkedHashMap2.put(aVar18, m.O0(arrayList24));
                }
            }
            map = linkedHashMap2;
        }
        Log.i("CpuSetManager", "=== CPU 核心信息 ===");
        for (Map.Entry entry : map.entrySet()) {
            a aVar19 = (a) entry.getKey();
            List list4 = (List) entry.getValue();
            int iOrdinal = aVar19.ordinal();
            if (iOrdinal == 0) {
                str = "超大核";
            } else if (iOrdinal == 1) {
                str = "大核";
            } else if (iOrdinal == 2) {
                str = "中核";
            } else {
                if (iOrdinal != 3) {
                    throw new w();
                }
                str = "小核";
            }
            ArrayList arrayList25 = new ArrayList(o.n0(list4, 10));
            Iterator it20 = list4.iterator();
            while (it20.hasNext()) {
                arrayList25.add(Integer.valueOf(((b) it20.next()).f3581a));
            }
            Log.i("CpuSetManager", str + ": " + arrayList25);
        }
        boolean z = CpuSetNative.f1546a;
        Log.i("CpuSetManager", "Native 库加载状态: " + CpuSetNative.f1546a);
    }

    public static void a(List list) {
        boolean z = CpuSetNative.f1546a;
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            iArr[i8] = ((Number) it.next()).intValue();
            i8++;
        }
        CpuSetNative.a(iArr);
    }
}
