package com.stepos.alphame.data.model.dailyusage;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.common.utils.EventUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u001a&\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00140\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a\u001c\u0010\u0015\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0016\u001a\u00020\u0006\u001a\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a,\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u001a \u0010 \u001a\u00020\u00062\u0018\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00140\u000e\u001a0\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00140\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u001a*\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a\u0018\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a\u0018\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a\u0014\u0010,\u001a\u00020-*\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"TAG", "", "addNewTimeUsageEntity", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "startTime", "", "endTime", "type", "", "timeUsageEntities", "", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "getAppUsage", "", "Lcom/stepos/alphame/data/model/dailyusage/AppUsage;", "timeUsages", "notificationUsages", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsageEntity;", "getAudioPairList", "Lkotlin/Pair;", "getDailyUsageTime", "maximumUsageTime", "getHourlyUsageSummary", "Lcom/stepos/alphame/data/model/dailyusage/HourlyUsageSummary;", "dailyUsageEntity", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "getHourlyUsedTime", "getMaximumUsageTime", "screenUsages", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsageEntity;", "currentTime", "getMaximumUsageTimeInner", "pairList", "getScreenPairList", "getTimeUsageListOfHourIntervals", "appUsages", "isPairScreenOff", "", "firstPackageName", "secondPackageName", "isPairScreenOn", "isScreenOffThenOn", "mergeOverlappingIntervals", "asDailyUsageSummary", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDailyUsageSummary.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyUsageSummary.kt\ncom/stepos/alphame/data/model/dailyusage/DailyUsageSummaryKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,455:1\n1603#2,9:456\n1855#2:465\n1856#2:467\n1612#2:468\n766#2:469\n857#2,2:470\n766#2:472\n857#2,2:473\n766#2:475\n857#2,2:476\n1045#2:478\n766#2:479\n857#2,2:480\n1045#2:482\n1477#2:483\n1502#2,3:484\n1505#2,3:494\n1238#2,2:499\n1045#2:501\n1241#2:502\n1477#2:503\n1502#2,3:504\n1505#2,3:514\n766#2:518\n857#2,2:519\n766#2:521\n857#2,2:522\n766#2:524\n857#2,2:525\n1045#2:527\n1#3:466\n1#3:517\n372#4,7:487\n453#4:497\n403#4:498\n372#4,7:507\n*S KotlinDebug\n*F\n+ 1 DailyUsageSummary.kt\ncom/stepos/alphame/data/model/dailyusage/DailyUsageSummaryKt\n*L\n121#1:456,9\n121#1:465\n121#1:467\n121#1:468\n130#1:469\n130#1:470,2\n131#1:472\n131#1:473,2\n134#1:475\n134#1:476,2\n164#1:478\n189#1:479\n189#1:480,2\n203#1:482\n299#1:483\n299#1:484,3\n299#1:494,3\n300#1:499,2\n300#1:501\n300#1:502\n301#1:503\n301#1:504,3\n301#1:514,3\n363#1:518\n363#1:519,2\n364#1:521\n364#1:522,2\n367#1:524\n367#1:525,2\n444#1:527\n121#1:466\n299#1:487,7\n300#1:497\n300#1:498\n301#1:507,7\n*E\n"})
/* loaded from: classes.dex */
public final class DailyUsageSummaryKt {

    @NotNull
    public static final String TAG = "AppUsage";

    public static final void addNewTimeUsageEntity(@NotNull String packageName, long j4, long j5, int i4, @NotNull List<TimeUsageEntity> timeUsageEntities) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(timeUsageEntities, "timeUsageEntities");
        timeUsageEntities.add(new TimeUsageEntity(packageName, j4, j5, i4));
    }

    @NotNull
    public static final DailyUsageSummary asDailyUsageSummary(@NotNull DailyUsageEntity dailyUsageEntity, long j4) {
        Intrinsics.checkNotNullParameter(dailyUsageEntity, "<this>");
        List<TimeUsageEntity> timeUsages = dailyUsageEntity.getTimeUsages();
        ArrayList arrayList = new ArrayList();
        for (TimeUsageEntity timeUsageEntity : timeUsages) {
            if (timeUsageEntity.getStartTime() > j4) {
                timeUsageEntity = null;
            } else if (timeUsageEntity.getEndTime() > j4) {
                timeUsageEntity = new TimeUsageEntity(timeUsageEntity.getPackageName(), timeUsageEntity.getStartTime(), j4, timeUsageEntity.getType());
            }
            if (timeUsageEntity != null) {
                arrayList.add(timeUsageEntity);
            }
        }
        List<ScreenUsageEntity> screenUsages = dailyUsageEntity.getScreenUsages();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : screenUsages) {
            if (((ScreenUsageEntity) obj).getTriggerTime() <= j4) {
                arrayList2.add(obj);
            }
        }
        List<NotificationUsageEntity> notificationUsages = dailyUsageEntity.getNotificationUsages();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : notificationUsages) {
            if (((NotificationUsageEntity) obj2).getTriggerTime() <= j4) {
                arrayList3.add(obj2);
            }
        }
        int size = arrayList3.size();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList2) {
            if (Intrinsics.areEqual(((ScreenUsageEntity) obj3).getPackageName(), EventUtils.SCREEN_ON)) {
                arrayList4.add(obj3);
            }
        }
        int size2 = arrayList4.size();
        long maximumUsageTime = getMaximumUsageTime(arrayList2, arrayList, j4);
        long dailyUsageTime = getDailyUsageTime(arrayList, maximumUsageTime);
        List<AppUsage> appUsage = getAppUsage(arrayList, arrayList3);
        DailyUsageEntity dailyUsageEntity2 = new DailyUsageEntity(dailyUsageEntity.getId(), dailyUsageEntity.getDate(), dailyUsageEntity.getMode(), dailyUsageEntity.getUserId(), null, null, null, 112, null);
        dailyUsageEntity2.setTimeUsages(new ArrayList(arrayList));
        dailyUsageEntity2.setScreenUsages(new ArrayList(arrayList2));
        dailyUsageEntity2.setNotificationUsages(new ArrayList(arrayList3));
        return new DailyUsageSummary(dailyUsageEntity.getDate(), dailyUsageEntity.getMode(), dailyUsageEntity.getUserId(), dailyUsageTime, maximumUsageTime, size, size2, appUsage, getHourlyUsageSummary(dailyUsageEntity2));
    }

    public static /* synthetic */ DailyUsageSummary asDailyUsageSummary$default(DailyUsageEntity dailyUsageEntity, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = System.currentTimeMillis();
        }
        return asDailyUsageSummary(dailyUsageEntity, j4);
    }

    @NotNull
    public static final List<AppUsage> getAppUsage(@NotNull List<TimeUsageEntity> timeUsages, @NotNull List<NotificationUsageEntity> notificationUsages) {
        Intrinsics.checkNotNullParameter(timeUsages, "timeUsages");
        Intrinsics.checkNotNullParameter(notificationUsages, "notificationUsages");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : timeUsages) {
            String packageName = ((TimeUsageEntity) obj).getPackageName();
            Object arrayList = linkedHashMap.get(packageName);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(packageName, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.sortedWith((List) entry.getValue(), new Comparator() { // from class: com.stepos.alphame.data.model.dailyusage.DailyUsageSummaryKt$getAppUsage$lambda$11$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t4, T t5) {
                    return ComparisonsKt.compareValues(Long.valueOf(((TimeUsageEntity) t4).getStartTime()), Long.valueOf(((TimeUsageEntity) t5).getStartTime()));
                }
            }));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj2 : notificationUsages) {
            String packageName2 = ((NotificationUsageEntity) obj2).getPackageName();
            Object arrayList2 = linkedHashMap3.get(packageName2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap3.put(packageName2, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (String str : linkedHashMap2.keySet()) {
            List list = (List) linkedHashMap2.get(str);
            long endTime = 0;
            if (list != null) {
                for (TimeUsageEntity timeUsageEntity : mergeOverlappingIntervals(list)) {
                    endTime += timeUsageEntity.getEndTime() - timeUsageEntity.getStartTime();
                }
            }
            List list2 = (List) linkedHashMap3.get(str);
            arrayList3.add(new AppUsage(str, list2 != null ? list2.size() : 0, endTime));
        }
        return arrayList3;
    }

    @NotNull
    public static final List<Pair<Long, Long>> getAudioPairList(@NotNull List<TimeUsageEntity> timeUsageEntities) {
        Intrinsics.checkNotNullParameter(timeUsageEntities, "timeUsageEntities");
        ArrayList arrayList = new ArrayList();
        for (TimeUsageEntity timeUsageEntity : timeUsageEntities) {
            arrayList.add(new Pair(Long.valueOf(timeUsageEntity.getStartTime()), Long.valueOf(timeUsageEntity.getEndTime())));
        }
        return arrayList;
    }

    public static final long getDailyUsageTime(@NotNull List<TimeUsageEntity> timeUsageEntities, long j4) {
        Intrinsics.checkNotNullParameter(timeUsageEntities, "timeUsageEntities");
        long endTime = 0;
        for (TimeUsageEntity timeUsageEntity : mergeOverlappingIntervals(CollectionsKt.sortedWith(timeUsageEntities, new Comparator() { // from class: com.stepos.alphame.data.model.dailyusage.DailyUsageSummaryKt$getDailyUsageTime$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t4, T t5) {
                return ComparisonsKt.compareValues(Long.valueOf(((TimeUsageEntity) t4).getStartTime()), Long.valueOf(((TimeUsageEntity) t5).getStartTime()));
            }
        }))) {
            endTime += timeUsageEntity.getEndTime() - timeUsageEntity.getStartTime();
        }
        if (endTime > 86400000) {
            return 86400000L;
        }
        return endTime < j4 ? j4 : endTime;
    }

    @NotNull
    public static final List<HourlyUsageSummary> getHourlyUsageSummary(@NotNull DailyUsageEntity dailyUsageEntity) {
        Intrinsics.checkNotNullParameter(dailyUsageEntity, "dailyUsageEntity");
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < 24; i4++) {
            long date = (i4 * 3600000) + dailyUsageEntity.getDate();
            long j4 = 3600000 + date;
            List<ScreenUsageEntity> screenUsages = dailyUsageEntity.getScreenUsages();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : screenUsages) {
                long triggerTime = ((ScreenUsageEntity) obj).getTriggerTime();
                if (date <= triggerTime && triggerTime <= j4) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (Intrinsics.areEqual(((ScreenUsageEntity) obj2).getPackageName(), EventUtils.SCREEN_ON)) {
                    arrayList3.add(obj2);
                }
            }
            int size = arrayList3.size();
            List<NotificationUsageEntity> notificationUsages = dailyUsageEntity.getNotificationUsages();
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : notificationUsages) {
                long triggerTime2 = ((NotificationUsageEntity) obj3).getTriggerTime();
                if (date <= triggerTime2 && triggerTime2 <= j4) {
                    arrayList4.add(obj3);
                }
            }
            int size2 = arrayList4.size();
            List<TimeUsageEntity> timeUsageListOfHourIntervals = getTimeUsageListOfHourIntervals(date, j4, dailyUsageEntity.getTimeUsages());
            arrayList.add(new HourlyUsageSummary(getHourlyUsedTime(timeUsageListOfHourIntervals), size, size2, getAppUsage(timeUsageListOfHourIntervals, arrayList4)));
        }
        return arrayList;
    }

    public static final long getHourlyUsedTime(@NotNull List<TimeUsageEntity> timeUsages) {
        Intrinsics.checkNotNullParameter(timeUsages, "timeUsages");
        long endTime = 0;
        for (TimeUsageEntity timeUsageEntity : mergeOverlappingIntervals(CollectionsKt.sortedWith(timeUsages, new Comparator() { // from class: com.stepos.alphame.data.model.dailyusage.DailyUsageSummaryKt$getHourlyUsedTime$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t4, T t5) {
                return ComparisonsKt.compareValues(Long.valueOf(((TimeUsageEntity) t4).getStartTime()), Long.valueOf(((TimeUsageEntity) t5).getStartTime()));
            }
        }))) {
            endTime += timeUsageEntity.getEndTime() - timeUsageEntity.getStartTime();
        }
        if (endTime > 3600000) {
            return 3600000L;
        }
        return endTime;
    }

    public static final long getMaximumUsageTime(@NotNull List<ScreenUsageEntity> screenUsages, @NotNull List<TimeUsageEntity> timeUsageEntities, long j4) {
        Intrinsics.checkNotNullParameter(screenUsages, "screenUsages");
        Intrinsics.checkNotNullParameter(timeUsageEntities, "timeUsageEntities");
        ArrayList arrayList = new ArrayList();
        for (Object obj : timeUsageEntities) {
            if (((TimeUsageEntity) obj).getType() == TimeUsageType.AUDIO.getType()) {
                arrayList.add(obj);
            }
        }
        List<Pair<Long, Long>> audioPairList = getAudioPairList(arrayList);
        List<Pair<Long, Long>> screenPairList = getScreenPairList(screenUsages, j4);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(audioPairList);
        arrayList2.addAll(screenPairList);
        return getMaximumUsageTimeInner(arrayList2);
    }

    public static /* synthetic */ long getMaximumUsageTime$default(List list, List list2, long j4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            j4 = System.currentTimeMillis();
        }
        return getMaximumUsageTime(list, list2, j4);
    }

    public static final long getMaximumUsageTimeInner(@NotNull List<Pair<Long, Long>> pairList) {
        Intrinsics.checkNotNullParameter(pairList, "pairList");
        List<Pair> listSortedWith = CollectionsKt.sortedWith(pairList, new Comparator() { // from class: com.stepos.alphame.data.model.dailyusage.DailyUsageSummaryKt$getMaximumUsageTimeInner$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t4, T t5) {
                return ComparisonsKt.compareValues((Long) ((Pair) t4).getFirst(), (Long) ((Pair) t5).getFirst());
            }
        });
        ArrayList<Pair> arrayList = new ArrayList();
        for (Pair pair : listSortedWith) {
            if (arrayList.isEmpty()) {
                arrayList.add(pair);
            } else {
                Pair pair2 = (Pair) CollectionsKt.last((List) arrayList);
                if (((Number) pair.getFirst()).longValue() <= ((Number) pair2.getSecond()).longValue()) {
                    arrayList.set(CollectionsKt.getLastIndex(arrayList), TuplesKt.to(pair2.getFirst(), Long.valueOf(Math.max(((Number) pair2.getSecond()).longValue(), ((Number) pair.getSecond()).longValue()))));
                } else {
                    arrayList.add(pair);
                }
            }
        }
        long j4 = 0;
        for (Pair pair3 : arrayList) {
            long jLongValue = ((Number) pair3.getSecond()).longValue() - ((Number) pair3.getFirst()).longValue();
            if (j4 < jLongValue) {
                j4 = jLongValue;
            }
        }
        return j4;
    }

    @NotNull
    public static final List<Pair<Long, Long>> getScreenPairList(@NotNull List<ScreenUsageEntity> screenUsages, long j4) {
        Intrinsics.checkNotNullParameter(screenUsages, "screenUsages");
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            int i6 = 1;
            if (i5 >= screenUsages.size()) {
                break;
            }
            ScreenUsageEntity screenUsageEntity = screenUsages.get(i4);
            ScreenUsageEntity screenUsageEntity2 = screenUsages.get(i5);
            EventUtils eventUtils = EventUtils.INSTANCE;
            if (eventUtils.isScreenOnEvent(screenUsageEntity.getPackageName()) && eventUtils.isScreenOffEvent(screenUsageEntity2.getPackageName()) && screenUsageEntity.getTriggerTime() < screenUsageEntity2.getTriggerTime()) {
                arrayList.add(new Pair(Long.valueOf(screenUsageEntity.getTriggerTime()), Long.valueOf(screenUsageEntity2.getTriggerTime())));
            } else {
                if (isPairScreenOn(screenUsageEntity.getPackageName(), screenUsageEntity2.getPackageName()) || isScreenOffThenOn(screenUsageEntity.getPackageName(), screenUsageEntity2.getPackageName())) {
                }
                i4 += i6;
            }
            i6 = 2;
            i4 += i6;
        }
        if (i4 < screenUsages.size() && i4 == screenUsages.size() - 1 && EventUtils.INSTANCE.isScreenOnEvent(screenUsages.get(i4).getPackageName()) && screenUsages.get(i4).getTriggerTime() < j4) {
            arrayList.add(new Pair(Long.valueOf(screenUsages.get(i4).getTriggerTime()), Long.valueOf(j4)));
        }
        return arrayList;
    }

    public static /* synthetic */ List getScreenPairList$default(List list, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = System.currentTimeMillis();
        }
        return getScreenPairList(list, j4);
    }

    @NotNull
    public static final List<TimeUsageEntity> getTimeUsageListOfHourIntervals(long j4, long j5, @NotNull List<TimeUsageEntity> appUsages) {
        Intrinsics.checkNotNullParameter(appUsages, "appUsages");
        ArrayList arrayList = new ArrayList();
        for (TimeUsageEntity timeUsageEntity : appUsages) {
            long startTime = timeUsageEntity.getStartTime();
            if (j4 <= startTime && startTime <= j5) {
                long endTime = timeUsageEntity.getEndTime();
                if (j4 <= endTime && endTime <= j5) {
                    arrayList.add(timeUsageEntity);
                }
            }
            long startTime2 = timeUsageEntity.getStartTime();
            if (j4 > startTime2 || startTime2 > j5 || timeUsageEntity.getEndTime() <= j5) {
                if (timeUsageEntity.getStartTime() < j4) {
                    long endTime2 = timeUsageEntity.getEndTime();
                    if (j4 <= endTime2 && endTime2 <= j5) {
                        addNewTimeUsageEntity(timeUsageEntity.getPackageName(), j4, timeUsageEntity.getEndTime(), timeUsageEntity.getType(), arrayList);
                    }
                }
                if (timeUsageEntity.getStartTime() < j4 && timeUsageEntity.getEndTime() > j5) {
                    addNewTimeUsageEntity(timeUsageEntity.getPackageName(), j4, j5, timeUsageEntity.getType(), arrayList);
                }
            } else {
                addNewTimeUsageEntity(timeUsageEntity.getPackageName(), timeUsageEntity.getStartTime(), j5, timeUsageEntity.getType(), arrayList);
            }
        }
        return arrayList;
    }

    private static final boolean isPairScreenOff(String str, String str2) {
        EventUtils eventUtils = EventUtils.INSTANCE;
        return eventUtils.isScreenOffEvent(str) && eventUtils.isScreenOffEvent(str2);
    }

    private static final boolean isPairScreenOn(String str, String str2) {
        EventUtils eventUtils = EventUtils.INSTANCE;
        return eventUtils.isScreenOnEvent(str) && eventUtils.isScreenOnEvent(str2);
    }

    private static final boolean isScreenOffThenOn(String str, String str2) {
        EventUtils eventUtils = EventUtils.INSTANCE;
        return eventUtils.isScreenOffEvent(str) && eventUtils.isScreenOnEvent(str2);
    }

    @NotNull
    public static final List<TimeUsageEntity> mergeOverlappingIntervals(@NotNull List<TimeUsageEntity> timeUsageEntities) {
        Intrinsics.checkNotNullParameter(timeUsageEntities, "timeUsageEntities");
        ArrayList arrayList = new ArrayList();
        for (TimeUsageEntity timeUsageEntity : timeUsageEntities) {
            if (arrayList.isEmpty()) {
                arrayList.add(timeUsageEntity);
            } else {
                TimeUsageEntity timeUsageEntity2 = (TimeUsageEntity) CollectionsKt.last((List) arrayList);
                if (timeUsageEntity2.getEndTime() > timeUsageEntity.getStartTime()) {
                    arrayList.set(CollectionsKt.getLastIndex(arrayList), new TimeUsageEntity(timeUsageEntity.getPackageName(), timeUsageEntity2.getStartTime(), Math.max(timeUsageEntity2.getEndTime(), timeUsageEntity.getEndTime()), timeUsageEntity.getType()));
                } else {
                    arrayList.add(timeUsageEntity);
                }
            }
        }
        return arrayList;
    }
}
