package com.stepos.familyguard.ui.usage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.ui.usage.U;
import com.stepos.familyguard.ui.usage.x;
import f2.C0702g;
import f2.C0711p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class U extends x {

    /* renamed from: g, reason: collision with root package name */
    private final StatsDataSet[] f14929g;

    public static class a extends x.a {
        public static final Parcelable.Creator<a> CREATOR = new C0182a();

        /* renamed from: e, reason: collision with root package name */
        public long f14930e;

        /* renamed from: com.stepos.familyguard.ui.usage.U$a$a, reason: collision with other inner class name */
        class C0182a implements Parcelable.Creator<a> {
            C0182a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i5) {
                return new a[i5];
            }
        }

        public a() {
        }

        @Override // com.stepos.familyguard.ui.usage.x.a, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.stepos.familyguard.ui.usage.x.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeLong(this.f14930e);
        }

        protected a(Parcel parcel) {
            super(parcel);
            this.f14930e = parcel.readLong();
        }
    }

    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f14931a;

        /* renamed from: b, reason: collision with root package name */
        public String f14932b;

        /* renamed from: c, reason: collision with root package name */
        public int f14933c;

        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        public b() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.f14931a);
            parcel.writeString(this.f14932b);
            parcel.writeInt(this.f14933c);
        }

        protected b(Parcel parcel) {
            this.f14931a = parcel.readString();
            this.f14932b = parcel.readString();
            this.f14933c = parcel.readInt();
        }
    }

    public static class c extends x.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public long f14934d;

        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i5) {
                return new c[i5];
            }
        }

        public c() {
        }

        @Override // com.stepos.familyguard.ui.usage.x.b, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.stepos.familyguard.ui.usage.x.b, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeLong(this.f14934d);
        }

        protected c(Parcel parcel) {
            super(parcel);
            this.f14934d = parcel.readLong();
        }
    }

    public U(StatsDataSet[] statsDataSetArr, PackageLimitInfo[] packageLimitInfoArr, CategoryLimitInfo[] categoryLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr, PeriodLimitInfo[] periodLimitInfoArr2, List<PackageUtils.AppInfo> list, List<WhitelistAppInfo> list2) {
        super(packageLimitInfoArr, categoryLimitInfoArr, periodLimitInfoArr, periodLimitInfoArr2, list, list2);
        this.f14929g = statsDataSetArr;
    }

    public static /* synthetic */ int i(c cVar, c cVar2) {
        long j5 = cVar.f14934d;
        long j6 = cVar2.f14934d;
        if (j5 != j6) {
            return (int) (j6 - j5);
        }
        boolean z5 = cVar2.f15167c;
        if (!z5 || cVar.f15167c) {
            return (z5 || !cVar.f15167c) ? 0 : -1;
        }
        return 1;
    }

    public static /* synthetic */ int j(a aVar, a aVar2) {
        long j5 = aVar.f14930e;
        long j6 = aVar2.f14930e;
        if (j5 != j6) {
            return (int) (j6 - j5);
        }
        boolean z5 = aVar2.f15164d;
        if (!z5 || aVar.f15164d) {
            return (z5 || !aVar.f15164d) ? 0 : -1;
        }
        return 1;
    }

    public static /* synthetic */ int k(b bVar, b bVar2) {
        return bVar2.f14933c - bVar.f14933c;
    }

    private void l(StatsDataSet statsDataSet, Map<String, c> map) {
        PackageUtils.AppInfo appInfoI;
        if (statsDataSet == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return;
        }
        PackageUtils packageUtilsH = PackageUtils.h(P1.a.a());
        for (Map.Entry<String, Long> entry : statsDataSet.getPackageUsingTimeMap().entrySet()) {
            String key = entry.getKey();
            long jLongValue = entry.getValue() == null ? 0L : entry.getValue().longValue();
            if (jLongValue > 0 && !map.containsKey(key) && !TextUtils.equals(key, "android") && !PackageUtils.q(key) && !PackageUtils.u(key) && !packageUtilsH.B(key) && (appInfoI = packageUtilsH.i(key)) != null && !TextUtils.isEmpty(appInfoI.label)) {
                c cVar = new c();
                cVar.f15165a = appInfoI.packageName;
                cVar.f15166b = appInfoI.label;
                cVar.f14934d = jLongValue;
                map.put(key, cVar);
            }
        }
    }

    private StatsDataSet p(int i5, int i6) {
        StatsDataSet statsDataSet;
        StatsDataSet[] children;
        if (i6 < 0) {
            throw new IllegalArgumentException("error interval = " + i5 + " and index = " + i6);
        }
        if (this.f14929g == null) {
            return null;
        }
        if (i5 == com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
            StatsDataSet[] statsDataSetArr = this.f14929g;
            if (i6 < statsDataSetArr.length) {
                return statsDataSetArr[i6];
            }
            return null;
        }
        if (i5 != com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() || i6 >= 14) {
            throw new IllegalArgumentException("error interval = " + i5 + " and index = " + i6);
        }
        int i7 = i6 / 7;
        int i8 = i6 % 7;
        StatsDataSet[] statsDataSetArr2 = this.f14929g;
        if (i7 >= statsDataSetArr2.length || (statsDataSet = statsDataSetArr2[i7]) == null || (children = statsDataSet.getChildren()) == null || i8 >= children.length) {
            return null;
        }
        return children[i8];
    }

    private static long r(Map<String, Long> map, String str) {
        Long l5 = map.get(str);
        if (l5 == null) {
            return 0L;
        }
        return l5.longValue();
    }

    private void v(int i5, int i6, StatsDataSet statsDataSet, Map<Integer, a> map) {
        int i7;
        if (statsDataSet == null) {
            return;
        }
        Map<String, Long> categoryUsingTimeMap = statsDataSet.getCategoryUsingTimeMap();
        long j5 = 0;
        long jR = categoryUsingTimeMap == null ? 0L : r(categoryUsingTimeMap, W1.a.b(10));
        if (categoryUsingTimeMap != null) {
            i7 = 0;
            long j6 = 0;
            for (Map.Entry<String, Long> entry : categoryUsingTimeMap.entrySet()) {
                long jLongValue = entry.getValue() == null ? 0L : entry.getValue().longValue();
                if (jLongValue > 0) {
                    i7++;
                    j6 += jLongValue;
                }
            }
            j5 = j6;
        } else {
            i7 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("USAGE_DEBUG category_summary interval=");
        sb.append(i5);
        sb.append(" index=");
        sb.append(i6);
        sb.append(" date=");
        sb.append(C0711p.j(statsDataSet.getStartTime()));
        sb.append(" total=");
        sb.append(C0711p.t(statsDataSet.getUsingTime()));
        sb.append(" categorySum=");
        sb.append(C0711p.t(j5));
        sb.append(" otherCategory=");
        sb.append(C0711p.t(jR));
        sb.append(" usedCategoryCount=");
        sb.append(i7);
        sb.append(" categoryItemCount=");
        sb.append(map != null ? map.size() : 0);
        sb.append(" categoryMap=");
        sb.append(categoryUsingTimeMap);
        C0702g.O("UsageLimitDataSet", sb.toString());
    }

    private void w(int i5, int i6, StatsDataSet statsDataSet, Map<String, c> map) {
        HashSet hashSet;
        Iterator<Map.Entry<String, Long>> it;
        if (statsDataSet == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        Map<String, Long> categoryUsingTimeMap = statsDataSet.getCategoryUsingTimeMap();
        long jR = categoryUsingTimeMap == null ? 0L : r(categoryUsingTimeMap, W1.a.b(10));
        HashSet hashSet2 = new HashSet(map.keySet());
        Iterator<Map.Entry<String, Long>> it2 = packageUsingTimeMap.entrySet().iterator();
        int i7 = 0;
        int i8 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        while (true) {
            long j8 = jR;
            if (!it2.hasNext()) {
                C0702g.O("UsageLimitDataSet", "USAGE_DEBUG summary interval=" + i5 + " index=" + i6 + " date=" + C0711p.j(statsDataSet.getStartTime()) + " total=" + C0711p.t(statsDataSet.getUsingTime()) + " packageSum=" + C0711p.t(j5) + " visiblePackageSum=" + C0711p.t(j6) + " missingPackageSum=" + C0711p.t(j7) + " otherCategory=" + C0711p.t(j8) + " usedPackageCount=" + i7 + " visibleAppInfoCount=" + hashSet2.size() + " missingUsedPackageCount=" + i8 + " packageMap=" + packageUsingTimeMap + " categoryMap=" + categoryUsingTimeMap);
                return;
            }
            Map.Entry<String, Long> next = it2.next();
            String key = next.getKey();
            long jLongValue = next.getValue() == null ? 0L : next.getValue().longValue();
            if (jLongValue > 0) {
                i7++;
                j5 += jLongValue;
                if (hashSet2.contains(key)) {
                    j6 += jLongValue;
                    hashSet = hashSet2;
                    it = it2;
                } else {
                    i8++;
                    j7 += jLongValue;
                    hashSet = hashSet2;
                    StringBuilder sb = new StringBuilder();
                    it = it2;
                    sb.append("USAGE_DEBUG missing_app_detail interval=");
                    sb.append(i5);
                    sb.append(" index=");
                    sb.append(i6);
                    sb.append(" date=");
                    sb.append(C0711p.j(statsDataSet.getStartTime()));
                    sb.append(" package=");
                    sb.append(key);
                    sb.append(" usage=");
                    sb.append(C0711p.t(jLongValue));
                    C0702g.O("UsageLimitDataSet", sb.toString());
                }
                hashSet2 = hashSet;
                it2 = it;
            }
            jR = j8;
        }
    }

    public List<b> m(int i5, int i6) {
        ArrayList<b> arrayListS = s(i5, i6);
        ArrayList arrayList = new ArrayList();
        int size = arrayListS.size();
        for (int i7 = 0; i7 < size && arrayListS.get(i7).f14933c > 0; i7++) {
            arrayList.add(arrayListS.get(i7));
        }
        return arrayList;
    }

    public List<a> n(int i5, int i6) {
        ArrayList<a> arrayListQ = q(i5, i6);
        ArrayList arrayList = new ArrayList();
        int size = arrayListQ.size();
        for (int i7 = 0; i7 < size && arrayListQ.get(i7).f14930e > 0; i7++) {
            arrayList.add(arrayListQ.get(i7));
        }
        return arrayList;
    }

    public List<c> o(int i5, int i6) {
        ArrayList<c> arrayListT = t(i5, i6);
        ArrayList arrayList = new ArrayList();
        int size = arrayListT.size();
        PackageUtils packageUtilsH = PackageUtils.h(P1.a.a());
        for (int i7 = 0; i7 < size && arrayListT.get(i7).f14934d > 0; i7++) {
            if (!packageUtilsH.B(arrayListT.get(i7).f15165a)) {
                arrayList.add(arrayListT.get(i7));
            }
        }
        return arrayList;
    }

    public ArrayList<a> q(int i5, int i6) {
        a aVar;
        StatsDataSet statsDataSetP = p(i5, i6);
        HashMap map = new HashMap();
        for (int i7 : W1.a.d()) {
            a aVar2 = new a();
            aVar2.f15161a = i7;
            aVar2.f15162b = P1.a.a().getString(W1.c.m(i7));
            aVar2.f15163c = W1.c.l(i7);
            Map<String, Long> categoryUsingTimeMap = statsDataSetP == null ? null : statsDataSetP.getCategoryUsingTimeMap();
            aVar2.f14930e = (categoryUsingTimeMap == null || !categoryUsingTimeMap.containsKey(W1.a.b(aVar2.f15161a))) ? 0L : categoryUsingTimeMap.get(W1.a.b(aVar2.f15161a)).longValue();
            map.put(Integer.valueOf(i7), aVar2);
        }
        v(i5, i6, statsDataSetP, map);
        for (CategoryLimitInfo categoryLimitInfo : c()) {
            int categoryId = categoryLimitInfo.getCategoryId();
            a aVar3 = map.get(Integer.valueOf(categoryId));
            if (categoryLimitInfo.isLimitable() && categoryLimitInfo.isEnable() && map.containsKey(Integer.valueOf(categoryId)) && aVar3 != null) {
                aVar3.f15164d = true;
            }
        }
        for (PeriodLimitInfo periodLimitInfo : d()) {
            if (periodLimitInfo.isEnable() && periodLimitInfo.getType() == 1 && (aVar = map.get(Integer.valueOf((int) periodLimitInfo.getCategoryId()))) != null) {
                aVar.f15164d = true;
            }
        }
        ArrayList<a> arrayList = new ArrayList<>(map.values());
        Collections.sort(arrayList, new Comparator() { // from class: w2.R0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return com.stepos.familyguard.ui.usage.U.j((U.a) obj, (U.a) obj2);
            }
        });
        return arrayList;
    }

    public ArrayList<b> s(int i5, int i6) {
        StatsDataSet statsDataSet;
        StatsDataSet[] statsDataSetArr = this.f14929g;
        if (statsDataSetArr == null || statsDataSetArr.length == 0) {
            return new ArrayList<>();
        }
        if (i5 == com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
            statsDataSet = this.f14929g[i6];
        } else if (i5 != com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            statsDataSet = null;
        } else if (i6 < 7) {
            statsDataSet = this.f14929g[0].getChildren()[i6];
        } else {
            if (i6 >= 14) {
                throw new IllegalArgumentException("error interval = " + i5 + " and index = " + i6);
            }
            statsDataSet = this.f14929g[1].getChildren()[i6 - 7];
        }
        ArrayList<b> arrayList = new ArrayList<>();
        for (PackageUtils.AppInfo appInfo : a()) {
            b bVar = new b();
            bVar.f14931a = appInfo.packageName;
            bVar.f14932b = appInfo.label;
            if (statsDataSet != null) {
                Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
                bVar.f14933c = (packageNotifyTimesMap == null || !packageNotifyTimesMap.containsKey(bVar.f14931a)) ? 0 : packageNotifyTimesMap.get(bVar.f14931a).intValue();
            }
            arrayList.add(bVar);
        }
        Collections.sort(arrayList, new Comparator() { // from class: w2.T0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return com.stepos.familyguard.ui.usage.U.k((U.b) obj, (U.b) obj2);
            }
        });
        return arrayList;
    }

    public ArrayList<c> t(int i5, int i6) {
        c cVar;
        StatsDataSet statsDataSetP = p(i5, i6);
        HashMap map = new HashMap();
        for (PackageUtils.AppInfo appInfo : a()) {
            c cVar2 = new c();
            cVar2.f15165a = appInfo.packageName;
            cVar2.f15166b = appInfo.label;
            if (statsDataSetP != null) {
                Map<String, Long> packageUsingTimeMap = statsDataSetP.getPackageUsingTimeMap();
                cVar2.f14934d = (packageUsingTimeMap == null || !packageUsingTimeMap.containsKey(cVar2.f15165a)) ? 0L : packageUsingTimeMap.get(cVar2.f15165a).longValue();
            }
            map.put(cVar2.f15165a, cVar2);
        }
        l(statsDataSetP, map);
        w(i5, i6, statsDataSetP, map);
        for (PackageLimitInfo packageLimitInfo : f()) {
            String packageName = packageLimitInfo.getPackageName();
            c cVar3 = map.get(packageName);
            if (packageLimitInfo.isLimitable() && packageLimitInfo.isEnable() && map.containsKey(packageName) && cVar3 != null) {
                cVar3.f15167c = true;
            }
        }
        for (PeriodLimitInfo periodLimitInfo : g()) {
            if (periodLimitInfo.isEnable() && periodLimitInfo.getType() == 0 && (cVar = map.get(periodLimitInfo.getPackageName())) != null) {
                cVar.f15167c = true;
            }
        }
        ArrayList<c> arrayList = new ArrayList<>(map.values());
        Collections.sort(arrayList, new Comparator() { // from class: w2.S0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return com.stepos.familyguard.ui.usage.U.i((U.c) obj, (U.c) obj2);
            }
        });
        return arrayList;
    }

    public StatsDataSet[] u() {
        return this.f14929g;
    }
}
