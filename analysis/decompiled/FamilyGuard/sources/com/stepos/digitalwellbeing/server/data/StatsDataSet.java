package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import f2.C0711p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import k3.C0813a;
import m0.InterfaceC0854b;

/* loaded from: classes.dex */
public class StatsDataSet implements Parcelable, i {
    public static final Parcelable.Creator<StatsDataSet> CREATOR = new a();
    private static final String TAG = "StatsDataSet";

    @InterfaceC0854b
    private Map<String, Long> mCategoryUsingTimeMap;

    @InterfaceC0854b
    private StatsDataSet[] mChildren;

    @InterfaceC0854b
    private int mInterval;

    @InterfaceC0854b
    private long mLongestUseTime;

    @InterfaceC0854b
    private int mNotifyTimes;

    @InterfaceC0854b
    private Map<String, Integer> mPackageNotifyTimesMap;

    @InterfaceC0854b
    private Map<String, Long> mPackageUsingTimeMap;

    @InterfaceC0854b
    private int mPickupTimes;

    @InterfaceC0854b
    private int mSize;

    @InterfaceC0854b
    private long mStartTime;

    @InterfaceC0854b
    private long mUpdateTime;

    @InterfaceC0854b
    private long mUsingTime;

    class a implements Parcelable.Creator<StatsDataSet> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StatsDataSet createFromParcel(Parcel parcel) {
            return new StatsDataSet(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StatsDataSet[] newArray(int i5) {
            return new StatsDataSet[i5];
        }
    }

    public StatsDataSet() {
        this.mLongestUseTime = -1L;
        this.mPackageUsingTimeMap = new HashMap();
        this.mPackageNotifyTimesMap = new HashMap();
        this.mCategoryUsingTimeMap = new HashMap();
    }

    public static StatsDataSet createEmptyStatsDataSet(long j5, long j6, int i5) {
        if (i5 == com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal()) {
            return new StatsDataSet(i5, 0, j6, j5, null);
        }
        if (i5 != com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            return null;
        }
        StatsDataSet[] statsDataSetArrCreateEmptyStatsDataSetArray = createEmptyStatsDataSetArray(j5, j6, i5);
        return new StatsDataSet(i5, statsDataSetArrCreateEmptyStatsDataSetArray.length, j6, j5, statsDataSetArrCreateEmptyStatsDataSetArray);
    }

    public static StatsDataSet[] createEmptyStatsDataSetArray(long j5, long j6, int i5) {
        int i6 = 0;
        if (i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            StatsDataSet[] statsDataSetArr = new StatsDataSet[24];
            while (i6 < 24) {
                statsDataSetArr[i6] = createEmptyStatsDataSet((i6 * 3600000) + j5, j6, com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal());
                i6++;
            }
            return statsDataSetArr;
        }
        if (i5 != com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
            return null;
        }
        StatsDataSet[] statsDataSetArr2 = new StatsDataSet[7];
        while (i6 < 7) {
            statsDataSetArr2[i6] = createEmptyStatsDataSet((i6 * 86400000) + j5, j6, com.stepos.digitalwellbeing.server.data.a.DAY.ordinal());
            i6++;
        }
        return statsDataSetArr2;
    }

    private String formatChildren() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tmChildren=[\n");
        if (this.mChildren != null) {
            for (int i5 = 0; i5 < this.mChildren.length; i5++) {
                sb.append("\t\t");
                StatsDataSet statsDataSet = this.mChildren[i5];
                if (statsDataSet != null) {
                    sb.append(statsDataSet.toString().replaceAll("\n", "\n        "));
                } else {
                    sb.append("null");
                }
                sb.append(",\n");
            }
        }
        sb.append("\t]\n");
        return sb.toString();
    }

    private String formatMap(String str, Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(str);
        sb.append("={\n");
        if (map != null) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                sb.append("\t\t");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(",\n");
            }
        }
        sb.append("\t},\n");
        return sb.toString();
    }

    private static long[] mergeArray(long[] jArr, long[] jArr2) {
        if (jArr == null || jArr2 == null || jArr.length != jArr2.length) {
            return null;
        }
        long[] jArr3 = new long[jArr.length];
        for (int i5 = 0; i5 < jArr.length; i5++) {
            jArr3[i5] = jArr[i5] + jArr2[i5];
        }
        return jArr3;
    }

    private static long normalizeLongestUseTime(long j5, long j6) {
        if (j5 <= 0) {
            return 0L;
        }
        return (j6 <= 0 || j5 <= j6) ? j5 : j6;
    }

    private void onChildrenChanged() {
        StatsDataSet[] statsDataSetArr = this.mChildren;
        if (statsDataSetArr == null) {
            return;
        }
        int length = statsDataSetArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            StatsDataSet statsDataSet = this.mChildren[i5];
            if (statsDataSet != null) {
                this.mPickupTimes += statsDataSet.mPickupTimes;
                this.mNotifyTimes += statsDataSet.mNotifyTimes;
                this.mUsingTime += statsDataSet.mUsingTime;
                this.mPackageUsingTimeMap = C0813a.b(this.mPackageUsingTimeMap, statsDataSet.mPackageUsingTimeMap, new C0813a.InterfaceC0222a() { // from class: com.stepos.digitalwellbeing.server.data.d
                    @Override // k3.C0813a.InterfaceC0222a
                    public final Object a(Object obj, Object obj2) {
                        return Long.valueOf(((Long) obj).longValue() + ((Long) obj2).longValue());
                    }
                });
                this.mPackageNotifyTimesMap = C0813a.b(this.mPackageNotifyTimesMap, this.mChildren[i5].mPackageNotifyTimesMap, new C0813a.InterfaceC0222a() { // from class: com.stepos.digitalwellbeing.server.data.e
                    @Override // k3.C0813a.InterfaceC0222a
                    public final Object a(Object obj, Object obj2) {
                        return Integer.valueOf(((Integer) obj).intValue() + ((Integer) obj2).intValue());
                    }
                });
                this.mCategoryUsingTimeMap = C0813a.b(this.mCategoryUsingTimeMap, this.mChildren[i5].mCategoryUsingTimeMap, new C0813a.InterfaceC0222a() { // from class: com.stepos.digitalwellbeing.server.data.f
                    @Override // k3.C0813a.InterfaceC0222a
                    public final Object a(Object obj, Object obj2) {
                        return Long.valueOf(((Long) obj).longValue() + ((Long) obj2).longValue());
                    }
                });
            }
        }
    }

    public void addChildren(StatsDataSet[] statsDataSetArr) {
        this.mChildren = statsDataSetArr;
        onChildrenChanged();
    }

    public boolean clampUsingTimeToAtMostPackageSum() {
        Map<String, Long> map = this.mPackageUsingTimeMap;
        long jLongValue = 0;
        if (map != null) {
            for (Long l5 : map.values()) {
                if (l5 != null) {
                    jLongValue += l5.longValue();
                }
            }
        }
        Map<String, Long> map2 = this.mPackageUsingTimeMap;
        if (map2 == null || map2.isEmpty() || this.mUsingTime <= jLongValue) {
            return false;
        }
        this.mUsingTime = jLongValue;
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int[] findTopCategories() {
        return findTopCategories(3);
    }

    public Map<String, Long> getCategoryUsingTimeMap() {
        return this.mCategoryUsingTimeMap;
    }

    public StatsDataSet[] getChildren() {
        return this.mChildren;
    }

    public int getInterval() {
        return this.mInterval;
    }

    public long getLongestUseTime() {
        return normalizeLongestUseTime(this.mLongestUseTime, this.mUsingTime);
    }

    public int getNotifyTimes() {
        return this.mNotifyTimes;
    }

    public Map<String, Integer> getPackageNotifyTimesMap() {
        return this.mPackageNotifyTimesMap;
    }

    public Map<String, Long> getPackageUsingTimeMap() {
        return this.mPackageUsingTimeMap;
    }

    public int getPickupTimes() {
        return this.mPickupTimes;
    }

    public int getSize() {
        return this.mSize;
    }

    @InterfaceC0854b(serialize = false)
    public String[] getSortNotifiedPackages() {
        ArrayList arrayList = new ArrayList(this.mPackageNotifyTimesMap.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.stepos.digitalwellbeing.server.data.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Integer) ((Map.Entry) obj2).getValue()).compareTo((Integer) ((Map.Entry) obj).getValue());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        while (((Integer) ((Map.Entry) arrayList.get(0)).getValue()).intValue() > 0) {
            arrayList2.add((String) ((Map.Entry) arrayList.get(0)).getKey());
        }
        return (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    @InterfaceC0854b(serialize = false)
    public String[] getSortUsedCategories() {
        int i5;
        ArrayList arrayList = new ArrayList(this.mCategoryUsingTimeMap.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.stepos.digitalwellbeing.server.data.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Long) ((Map.Entry) obj2).getValue()).compareTo((Long) ((Map.Entry) obj).getValue());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            if (((Long) ((Map.Entry) arrayList.get(0)).getValue()).longValue() <= 0) {
                break;
            }
            arrayList2.add((String) ((Map.Entry) arrayList.get(0)).getKey());
        }
        int size = arrayList2.size();
        String[] strArr = new String[size];
        for (i5 = 0; i5 < size; i5++) {
            strArr[i5] = (String) arrayList2.get(i5);
        }
        return strArr;
    }

    @InterfaceC0854b(serialize = false)
    public String[] getSortUsedPackages() {
        ArrayList arrayList = new ArrayList(this.mPackageUsingTimeMap.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.stepos.digitalwellbeing.server.data.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Long) ((Map.Entry) obj2).getValue()).compareTo((Long) ((Map.Entry) obj).getValue());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        while (((Long) ((Map.Entry) arrayList.get(0)).getValue()).longValue() > 0) {
            arrayList2.add((String) ((Map.Entry) arrayList.get(0)).getKey());
        }
        return (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    @Override // com.stepos.digitalwellbeing.server.data.i
    public long getTime() {
        return getStartTime();
    }

    @InterfaceC0854b(serialize = false)
    public long[] getTopCategoriesUsage() {
        int[] iArrFindTopCategories = findTopCategories();
        int length = iArrFindTopCategories.length;
        Map<String, Long> categoryUsingTimeMap = getCategoryUsingTimeMap();
        long[] jArr = new long[length];
        if (categoryUsingTimeMap != null) {
            for (int i5 = 0; i5 < length; i5++) {
                if (categoryUsingTimeMap.containsKey(W1.a.b(iArrFindTopCategories[i5]))) {
                    Long l5 = categoryUsingTimeMap.get(W1.a.b(iArrFindTopCategories[i5]));
                    if (l5 != null) {
                        jArr[i5] = l5.longValue();
                    } else {
                        jArr[i5] = 0;
                    }
                } else {
                    jArr[i5] = 0;
                }
            }
        }
        return jArr;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public long getUsingTime() {
        return this.mUsingTime;
    }

    public boolean liftUsingTimeToAtLeastPackageSum() {
        Map<String, Long> map = this.mPackageUsingTimeMap;
        long jLongValue = 0;
        if (map != null) {
            for (Long l5 : map.values()) {
                if (l5 != null) {
                    jLongValue += l5.longValue();
                }
            }
        }
        if (jLongValue <= this.mUsingTime) {
            return false;
        }
        this.mUsingTime = jLongValue;
        return true;
    }

    public void setCategoryUsingTimeMap(Map<String, Long> map) {
        this.mCategoryUsingTimeMap.clear();
        if (map != null) {
            this.mCategoryUsingTimeMap.putAll(map);
        }
    }

    public void setChildren(StatsDataSet[] statsDataSetArr) {
        this.mChildren = statsDataSetArr;
    }

    public void setInterval(int i5) {
        this.mInterval = i5;
    }

    public void setLongestUseTime(long j5) {
        this.mLongestUseTime = normalizeLongestUseTime(j5, this.mUsingTime);
    }

    public void setNotifyTimes(int i5) {
        this.mNotifyTimes = i5;
    }

    public void setPackageNotifyTimesMap(Map<String, Integer> map) {
        this.mPackageNotifyTimesMap.clear();
        if (map != null) {
            this.mPackageNotifyTimesMap.putAll(map);
        }
    }

    public void setPackageUsingTimeMap(Map<String, Long> map) {
        this.mPackageUsingTimeMap.clear();
        if (map != null) {
            this.mPackageUsingTimeMap.putAll(map);
        }
    }

    public void setPickupTimes(int i5) {
        this.mPickupTimes = i5;
    }

    public void setSize(int i5) {
        this.mSize = i5;
    }

    public void setStartTime(long j5) {
        this.mStartTime = j5;
    }

    public void setUpdateTime(long j5) {
        this.mUpdateTime = j5;
    }

    public void setUsingTime(long j5) {
        this.mUsingTime = j5;
    }

    public String toString() {
        return "StatsDataSet{\n\tmInterval=" + this.mInterval + ",\n\tmStartTime=" + C0711p.j(this.mStartTime) + ",\n\tmUsingTime=" + C0711p.t(this.mUsingTime) + ",\n\tmLongestUseTime=" + C0711p.t(this.mLongestUseTime) + ",\n\tmUpdateTime=" + C0711p.j(this.mUpdateTime) + ",\n\tmPickupTimes=" + this.mPickupTimes + ",\n\tmNotifyTimes=" + this.mNotifyTimes + ",\n\tmSize=" + this.mSize + ",\n" + formatMap("mPackageUsingTimeMap", this.mPackageUsingTimeMap) + formatMap("mPackageNotifyTimesMap", this.mPackageNotifyTimesMap) + formatMap("mCategoryUsingTimeMap", this.mCategoryUsingTimeMap) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.mInterval);
        parcel.writeInt(this.mSize);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mUsingTime);
        parcel.writeLong(this.mLongestUseTime);
        parcel.writeInt(this.mPickupTimes);
        parcel.writeInt(this.mNotifyTimes);
        parcel.writeTypedArray(this.mChildren, i5);
        parcel.writeMap(this.mPackageUsingTimeMap);
        parcel.writeMap(this.mPackageNotifyTimesMap);
        parcel.writeMap(this.mCategoryUsingTimeMap);
    }

    public int[] findTopCategories(int i5) {
        int length = W1.a.d().length;
        if (i5 > length) {
            new IllegalArgumentException("error !! size must < categorySize : " + length).printStackTrace();
        }
        HashMap map = new HashMap(this.mCategoryUsingTimeMap);
        for (String str : W1.a.c()) {
            if (!map.containsKey(str)) {
                map.put(str, 0L);
            }
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.stepos.digitalwellbeing.server.data.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Long) ((Map.Entry) obj2).getValue()).compareTo((Long) ((Map.Entry) obj).getValue());
            }
        });
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = W1.a.a((String) ((Map.Entry) arrayList.get(i6)).getKey());
        }
        return iArr;
    }

    public StatsDataSet(int i5, int i6, long j5, long j6, StatsDataSet[] statsDataSetArr) {
        this.mLongestUseTime = -1L;
        this.mPackageUsingTimeMap = new HashMap();
        this.mPackageNotifyTimesMap = new HashMap();
        this.mCategoryUsingTimeMap = new HashMap();
        this.mInterval = i5;
        this.mSize = i6;
        this.mUpdateTime = j5;
        this.mStartTime = j6;
        this.mChildren = statsDataSetArr;
        onChildrenChanged();
    }

    @InterfaceC0854b(serialize = false)
    public long[] getTopCategoriesUsage(int i5) {
        int[] iArrFindTopCategories = findTopCategories(i5);
        int length = iArrFindTopCategories.length;
        Map<String, Long> categoryUsingTimeMap = getCategoryUsingTimeMap();
        long[] jArr = new long[length];
        if (categoryUsingTimeMap != null) {
            for (int i6 = 0; i6 < i5; i6++) {
                if (categoryUsingTimeMap.containsKey(W1.a.b(iArrFindTopCategories[i6]))) {
                    Long l5 = categoryUsingTimeMap.get(W1.a.b(iArrFindTopCategories[i6]));
                    if (l5 != null) {
                        jArr[i6] = l5.longValue();
                    } else {
                        jArr[i6] = 0;
                    }
                } else {
                    jArr[i6] = 0;
                }
            }
        }
        return jArr;
    }

    protected StatsDataSet(Parcel parcel) {
        this.mLongestUseTime = -1L;
        this.mPackageUsingTimeMap = new HashMap();
        this.mPackageNotifyTimesMap = new HashMap();
        this.mCategoryUsingTimeMap = new HashMap();
        this.mInterval = parcel.readInt();
        this.mSize = parcel.readInt();
        this.mUpdateTime = parcel.readLong();
        this.mStartTime = parcel.readLong();
        this.mUsingTime = parcel.readLong();
        this.mLongestUseTime = parcel.readLong();
        this.mPickupTimes = parcel.readInt();
        this.mNotifyTimes = parcel.readInt();
        this.mChildren = (StatsDataSet[]) parcel.createTypedArray(CREATOR);
        this.mPackageUsingTimeMap = parcel.readHashMap(getClass().getClassLoader(), String.class, Long.class);
        this.mPackageNotifyTimesMap = parcel.readHashMap(getClass().getClassLoader(), String.class, Integer.class);
        this.mCategoryUsingTimeMap = parcel.readHashMap(getClass().getClassLoader(), String.class, Long.class);
    }
}
