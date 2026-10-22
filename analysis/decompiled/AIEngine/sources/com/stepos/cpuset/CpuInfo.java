package com.stepos.cpuset;

import androidx.datastore.preferences.protobuf.b1;
import dc.h;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import ob.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuInfo {
    public static final CpuInfo INSTANCE = new CpuInfo();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoreTier.values().length];
            try {
                iArr[CoreTier.ULTRA_BIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoreTier.BIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoreTier.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoreTier.SMALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CpuInfo() {
    }

    private final String getTierName(CoreTier coreTier) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[coreTier.ordinal()];
        if (i10 == 1) {
            return "超大核";
        }
        if (i10 == 2) {
            return "大核";
        }
        if (i10 == 3) {
            return "中核";
        }
        if (i10 == 4) {
            return "小核";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Map<CoreTier, List<CpuCore>> classifyCores() throws NumberFormatException {
        List<CpuCore> allCoreInfo = getAllCoreInfo();
        if (allCoreInfo.isEmpty()) {
            return kotlin.collections.b.d0();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : allCoreInfo) {
            Long lValueOf = Long.valueOf(((CpuCore) obj).getMaxFrequency());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        TreeMap treeMap = new TreeMap(d.f10853a);
        treeMap.putAll(linkedHashMap);
        Set setKeySet = treeMap.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        List listO0 = kotlin.collections.a.O0(setKeySet);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int size = listO0.size();
        if (size == 1) {
            int size2 = allCoreInfo.size();
            if (size2 >= 8) {
                CoreTier coreTier = CoreTier.SMALL;
                List listJ0 = kotlin.collections.a.J0(2, allCoreInfo);
                ArrayList arrayList2 = new ArrayList(m.Z(listJ0, 10));
                Iterator it = listJ0.iterator();
                while (it.hasNext()) {
                    arrayList2.add(CpuCore.copy$default((CpuCore) it.next(), 0, 0L, 0L, CoreTier.SMALL, 7, null));
                }
                linkedHashMap2.put(coreTier, kotlin.collections.a.P0(arrayList2));
                CoreTier coreTier2 = CoreTier.MEDIUM;
                List<CpuCore> listSubList = allCoreInfo.subList(2, 6);
                ArrayList arrayList3 = new ArrayList(m.Z(listSubList, 10));
                Iterator<T> it2 = listSubList.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(CpuCore.copy$default((CpuCore) it2.next(), 0, 0L, 0L, CoreTier.MEDIUM, 7, null));
                }
                linkedHashMap2.put(coreTier2, kotlin.collections.a.P0(arrayList3));
                CoreTier coreTier3 = CoreTier.BIG;
                List<CpuCore> listSubList2 = allCoreInfo.subList(6, size2 - 1);
                ArrayList arrayList4 = new ArrayList(m.Z(listSubList2, 10));
                Iterator<T> it3 = listSubList2.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(CpuCore.copy$default((CpuCore) it3.next(), 0, 0L, 0L, CoreTier.BIG, 7, null));
                }
                linkedHashMap2.put(coreTier3, kotlin.collections.a.P0(arrayList4));
                CoreTier coreTier4 = CoreTier.ULTRA_BIG;
                List listP = b1.P(kotlin.collections.a.A0(allCoreInfo));
                ArrayList arrayList5 = new ArrayList(m.Z(listP, 10));
                Iterator it4 = listP.iterator();
                while (it4.hasNext()) {
                    arrayList5.add(CpuCore.copy$default((CpuCore) it4.next(), 0, 0L, 0L, CoreTier.ULTRA_BIG, 7, null));
                }
                linkedHashMap2.put(coreTier4, kotlin.collections.a.P0(arrayList5));
            } else {
                CoreTier coreTier5 = CoreTier.MEDIUM;
                ArrayList arrayList6 = new ArrayList(m.Z(allCoreInfo, 10));
                Iterator<T> it5 = allCoreInfo.iterator();
                while (it5.hasNext()) {
                    arrayList6.add(CpuCore.copy$default((CpuCore) it5.next(), 0, 0L, 0L, CoreTier.MEDIUM, 7, null));
                }
                linkedHashMap2.put(coreTier5, kotlin.collections.a.P0(arrayList6));
            }
            n nVar = n.f10413a;
            return linkedHashMap2;
        }
        if (size == 2) {
            Long l10 = (Long) listO0.get(0);
            Long l11 = (Long) listO0.get(1);
            Object obj2 = treeMap.get(l10);
            g.c(obj2);
            List list = (List) obj2;
            Object obj3 = treeMap.get(l11);
            g.c(obj3);
            List list2 = (List) obj3;
            int size3 = list.size() / 2;
            CoreTier coreTier6 = CoreTier.BIG;
            List listJ02 = kotlin.collections.a.J0(size3, list);
            ArrayList arrayList7 = new ArrayList(m.Z(listJ02, 10));
            Iterator it6 = listJ02.iterator();
            while (it6.hasNext()) {
                arrayList7.add(CpuCore.copy$default((CpuCore) it6.next(), 0, 0L, 0L, CoreTier.BIG, 7, null));
            }
            linkedHashMap2.put(coreTier6, kotlin.collections.a.P0(arrayList7));
            CoreTier coreTier7 = CoreTier.ULTRA_BIG;
            List listP0 = kotlin.collections.a.p0(size3, list);
            ArrayList arrayList8 = new ArrayList(m.Z(listP0, 10));
            Iterator it7 = listP0.iterator();
            while (it7.hasNext()) {
                arrayList8.add(CpuCore.copy$default((CpuCore) it7.next(), 0, 0L, 0L, CoreTier.ULTRA_BIG, 7, null));
            }
            linkedHashMap2.put(coreTier7, kotlin.collections.a.P0(arrayList8));
            int size4 = list2.size() / 2;
            CoreTier coreTier8 = CoreTier.MEDIUM;
            List listJ03 = kotlin.collections.a.J0(size4, list2);
            ArrayList arrayList9 = new ArrayList(m.Z(listJ03, 10));
            Iterator it8 = listJ03.iterator();
            while (it8.hasNext()) {
                arrayList9.add(CpuCore.copy$default((CpuCore) it8.next(), 0, 0L, 0L, CoreTier.MEDIUM, 7, null));
            }
            linkedHashMap2.put(coreTier8, kotlin.collections.a.P0(arrayList9));
            CoreTier coreTier9 = CoreTier.SMALL;
            List listP02 = kotlin.collections.a.p0(size4, list2);
            ArrayList arrayList10 = new ArrayList(m.Z(listP02, 10));
            Iterator it9 = listP02.iterator();
            while (it9.hasNext()) {
                arrayList10.add(CpuCore.copy$default((CpuCore) it9.next(), 0, 0L, 0L, CoreTier.SMALL, 7, null));
            }
            linkedHashMap2.put(coreTier9, kotlin.collections.a.P0(arrayList10));
            n nVar2 = n.f10413a;
            return linkedHashMap2;
        }
        if (size == 3) {
            Long l12 = (Long) listO0.get(0);
            Long l13 = (Long) listO0.get(1);
            Long l14 = (Long) listO0.get(2);
            CoreTier coreTier10 = CoreTier.ULTRA_BIG;
            Object obj4 = treeMap.get(l12);
            g.c(obj4);
            Iterable iterable = (Iterable) obj4;
            ArrayList arrayList11 = new ArrayList(m.Z(iterable, 10));
            Iterator it10 = iterable.iterator();
            while (it10.hasNext()) {
                arrayList11.add(CpuCore.copy$default((CpuCore) it10.next(), 0, 0L, 0L, CoreTier.ULTRA_BIG, 7, null));
            }
            linkedHashMap2.put(coreTier10, kotlin.collections.a.P0(arrayList11));
            CoreTier coreTier11 = CoreTier.BIG;
            Object obj5 = treeMap.get(l13);
            g.c(obj5);
            Iterable iterable2 = (Iterable) obj5;
            ArrayList arrayList12 = new ArrayList(m.Z(iterable2, 10));
            Iterator it11 = iterable2.iterator();
            while (it11.hasNext()) {
                arrayList12.add(CpuCore.copy$default((CpuCore) it11.next(), 0, 0L, 0L, CoreTier.BIG, 7, null));
            }
            linkedHashMap2.put(coreTier11, kotlin.collections.a.P0(arrayList12));
            Object obj6 = treeMap.get(l14);
            g.c(obj6);
            List list3 = (List) obj6;
            if (list3.size() > 2) {
                CoreTier coreTier12 = CoreTier.MEDIUM;
                List listK0 = kotlin.collections.a.K0(2, list3);
                ArrayList arrayList13 = new ArrayList(m.Z(listK0, 10));
                Iterator it12 = listK0.iterator();
                while (it12.hasNext()) {
                    arrayList13.add(CpuCore.copy$default((CpuCore) it12.next(), 0, 0L, 0L, CoreTier.MEDIUM, 7, null));
                }
                linkedHashMap2.put(coreTier12, kotlin.collections.a.P0(arrayList13));
                CoreTier coreTier13 = CoreTier.SMALL;
                List listQ0 = kotlin.collections.a.q0(2, list3);
                ArrayList arrayList14 = new ArrayList(m.Z(listQ0, 10));
                Iterator it13 = listQ0.iterator();
                while (it13.hasNext()) {
                    arrayList14.add(CpuCore.copy$default((CpuCore) it13.next(), 0, 0L, 0L, CoreTier.SMALL, 7, null));
                }
                linkedHashMap2.put(coreTier13, kotlin.collections.a.P0(arrayList14));
            } else {
                CoreTier coreTier14 = CoreTier.SMALL;
                ArrayList arrayList15 = new ArrayList(m.Z(list3, 10));
                Iterator it14 = list3.iterator();
                while (it14.hasNext()) {
                    arrayList15.add(CpuCore.copy$default((CpuCore) it14.next(), 0, 0L, 0L, CoreTier.SMALL, 7, null));
                }
                linkedHashMap2.put(coreTier14, kotlin.collections.a.P0(arrayList15));
            }
            n nVar3 = n.f10413a;
            return linkedHashMap2;
        }
        Set setEntrySet = treeMap.entrySet();
        g.e(setEntrySet, "<get-entries>(...)");
        List listO02 = kotlin.collections.a.O0(setEntrySet);
        CoreTier coreTier15 = CoreTier.ULTRA_BIG;
        Object value = ((Map.Entry) listO02.get(0)).getValue();
        g.e(value, "<get-value>(...)");
        Iterable iterable3 = (Iterable) value;
        ArrayList arrayList16 = new ArrayList(m.Z(iterable3, 10));
        Iterator it15 = iterable3.iterator();
        while (it15.hasNext()) {
            arrayList16.add(CpuCore.copy$default((CpuCore) it15.next(), 0, 0L, 0L, CoreTier.ULTRA_BIG, 7, null));
        }
        linkedHashMap2.put(coreTier15, kotlin.collections.a.P0(arrayList16));
        CoreTier coreTier16 = CoreTier.BIG;
        Object value2 = ((Map.Entry) listO02.get(1)).getValue();
        g.e(value2, "<get-value>(...)");
        Iterable iterable4 = (Iterable) value2;
        ArrayList arrayList17 = new ArrayList(m.Z(iterable4, 10));
        Iterator it16 = iterable4.iterator();
        while (it16.hasNext()) {
            arrayList17.add(CpuCore.copy$default((CpuCore) it16.next(), 0, 0L, 0L, CoreTier.BIG, 7, null));
        }
        linkedHashMap2.put(coreTier16, kotlin.collections.a.P0(arrayList17));
        CoreTier coreTier17 = CoreTier.SMALL;
        Object value3 = ((Map.Entry) kotlin.collections.a.A0(listO02)).getValue();
        g.e(value3, "<get-value>(...)");
        Iterable iterable5 = (Iterable) value3;
        ArrayList arrayList18 = new ArrayList(m.Z(iterable5, 10));
        Iterator it17 = iterable5.iterator();
        while (it17.hasNext()) {
            arrayList18.add(CpuCore.copy$default((CpuCore) it17.next(), 0, 0L, 0L, CoreTier.SMALL, 7, null));
        }
        linkedHashMap2.put(coreTier17, kotlin.collections.a.P0(arrayList18));
        if (listO02.size() > 3) {
            ArrayList arrayList19 = new ArrayList();
            int size5 = listO02.size() - 1;
            for (int i10 = 2; i10 < size5; i10++) {
                Object value4 = ((Map.Entry) listO02.get(i10)).getValue();
                g.e(value4, "<get-value>(...)");
                Iterable iterable6 = (Iterable) value4;
                ArrayList arrayList20 = new ArrayList(m.Z(iterable6, 10));
                Iterator it18 = iterable6.iterator();
                while (it18.hasNext()) {
                    arrayList20.add(CpuCore.copy$default((CpuCore) it18.next(), 0, 0L, 0L, CoreTier.MEDIUM, 7, null));
                }
                arrayList19.addAll(arrayList20);
            }
            if (!arrayList19.isEmpty()) {
                linkedHashMap2.put(CoreTier.MEDIUM, arrayList19);
            }
        } else {
            CoreTier coreTier18 = CoreTier.MEDIUM;
            Object value5 = ((Map.Entry) listO02.get(2)).getValue();
            g.e(value5, "<get-value>(...)");
            Iterable iterable7 = (Iterable) value5;
            ArrayList arrayList21 = new ArrayList(m.Z(iterable7, 10));
            Iterator it19 = iterable7.iterator();
            while (it19.hasNext()) {
                arrayList21.add(CpuCore.copy$default((CpuCore) it19.next(), 0, 0L, 0L, CoreTier.MEDIUM, 7, null));
            }
            linkedHashMap2.put(coreTier18, kotlin.collections.a.P0(arrayList21));
        }
        n nVar4 = n.f10413a;
        return linkedHashMap2;
    }

    public final List<CpuCore> getAllCoreInfo() throws NumberFormatException {
        List<Integer> onlineCores = getOnlineCores();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = onlineCores.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            long coreMaxFrequency = getCoreMaxFrequency(iIntValue);
            long coreMinFrequency = getCoreMinFrequency(iIntValue);
            if (coreMaxFrequency > 0) {
                arrayList.add(new CpuCore(iIntValue, coreMaxFrequency, coreMinFrequency, CoreTier.SMALL));
            }
        }
        return arrayList;
    }

    public final int getAvailableCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public final long getCoreCurrentFrequency(int i10) {
        try {
            return Long.parseLong(q.L0(wb.d.Z(new File(ai.onnxruntime.a.g(i10, "/sys/devices/system/cpu/cpu", "/cpufreq/scaling_cur_freq")), gc.a.f9106b)).toString());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long getCoreMaxFrequency(int i10) {
        try {
            return Long.parseLong(q.L0(wb.d.Z(new File(ai.onnxruntime.a.g(i10, "/sys/devices/system/cpu/cpu", "/cpufreq/cpuinfo_max_freq")), gc.a.f9106b)).toString());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long getCoreMinFrequency(int i10) {
        try {
            return Long.parseLong(q.L0(wb.d.Z(new File(ai.onnxruntime.a.g(i10, "/sys/devices/system/cpu/cpu", "/cpufreq/cpuinfo_min_freq")), gc.a.f9106b)).toString());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final String getCpuInfoString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CPU 核心总数: " + getAvailableCores() + "\n");
        sb2.append("在线核心数: " + getOnlineCores().size() + "\n\n");
        for (Map.Entry<CoreTier, List<CpuCore>> entry : classifyCores().entrySet()) {
            CoreTier key = entry.getKey();
            List<CpuCore> value = entry.getValue();
            sb2.append(INSTANCE.getTierName(key) + " (" + value.size() + "个):\n");
            for (CpuCore cpuCore : value) {
                int coreId = cpuCore.getCoreId();
                long j10 = 1000;
                long maxFrequency = cpuCore.getMaxFrequency() / j10;
                long minFrequency = cpuCore.getMinFrequency() / j10;
                long maxFrequency2 = cpuCore.getMaxFrequency() / j10;
                StringBuilder sb3 = new StringBuilder("  CPU");
                sb3.append(coreId);
                sb3.append(": ");
                sb3.append(maxFrequency);
                a0.a.s(minFrequency, " MHz (", " - ", sb3);
                sb3.append(maxFrequency2);
                sb3.append(" MHz)\n");
                sb2.append(sb3.toString());
            }
            sb2.append("\n");
        }
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final List<Integer> getOnlineCores() throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        File file = new File("/sys/devices/system/cpu/online");
        if (!file.exists()) {
            return kotlin.collections.a.O0(h.e0(0, getAvailableCores()));
        }
        try {
            for (String str : q.D0(q.L0(wb.d.Z(file, gc.a.f9106b)).toString(), new String[]{","}, 6)) {
                if (q.l0(str, "-", false)) {
                    List listD0 = q.D0(str, new String[]{"-"}, 6);
                    int i10 = Integer.parseInt((String) listD0.get(0));
                    int i11 = Integer.parseInt((String) listD0.get(1));
                    if (i10 <= i11) {
                        while (true) {
                            arrayList.add(Integer.valueOf(i10));
                            if (i10 != i11) {
                                i10++;
                            }
                        }
                    }
                } else {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return kotlin.collections.a.O0(h.e0(0, getAvailableCores()));
        }
    }
}
