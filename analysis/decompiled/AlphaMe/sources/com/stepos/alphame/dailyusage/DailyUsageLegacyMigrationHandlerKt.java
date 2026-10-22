package com.stepos.alphame.dailyusage;

import F1.n;
import android.database.Cursor;
import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.common.utils.TimeUtils;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.data.model.dailyusage.AppUsage;
import com.stepos.alphame.data.model.dailyusage.DailyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.HourlyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.MultiDailyUsageSummary;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.userbehavior.UserBehaviorStorable;
import com.stepos.alphame.utils.Consts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0001\u001a\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\n\u001a\u00020\u0001\u001a\u0006\u0010\r\u001a\u00020\u000e\u001a\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0006\u0010\u0015\u001a\u00020\u0010\u001a(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a\u001a\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000e\u001a\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002\u001a*\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"KEY_FIRST_UPGRADE", "", "KEY_USER_BEHAVIOR_DATA_IN_UPGRADE_DATE", "SELECTION", "SELECTION_WHEN_UPGRADE", "SORT_ORDER", "TAG", "extractAppDetails", "", "Lcom/stepos/alphame/data/model/dailyusage/AppUsage;", "input", "extractHourlyDetails", "Lcom/stepos/alphame/data/model/dailyusage/HourlyUsageSummary;", "getFirstUpgradeTime", "", "getMultiDailySummaryFromUserBehavior", "Lcom/stepos/alphame/data/model/dailyusage/MultiDailyUsageSummary;", "startTime", "endTime", "isUpgradeDate", "", "getUserBehaviorDataInUpgradeDate", "mergeAppUsageDetails", "oldAppUsages", "newAppUsages", "mergeDailyUsageSummaryInUpgradeDate", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "oldSummary", "newSummary", "mergeHourlyUsageSummary", "migrateUserBehaviorDataWhenUpgrade", "", "triggerTime", "parseAppUsages", "raw", "parseNumbers", "Lkotlin/Triple;", "", "parts", "saveUpgradeTimeWhenFirstUpgrade", "eventTime", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDailyUsageLegacyMigrationHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyUsageLegacyMigrationHandler.kt\ncom/stepos/alphame/dailyusage/DailyUsageLegacyMigrationHandlerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,234:1\n1477#2:235\n1502#2,3:236\n1505#2,3:246\n1549#2:254\n1620#2,3:255\n1603#2,9:258\n1855#2:267\n1856#2:269\n1612#2:270\n1549#2:271\n1620#2,3:272\n766#2:275\n857#2,2:276\n1603#2,9:278\n1855#2:287\n1549#2:288\n1620#2,3:289\n1856#2:293\n1612#2:294\n372#3,7:239\n125#4:249\n152#4,2:250\n154#4:253\n1#5:252\n1#5:268\n1#5:292\n*S KotlinDebug\n*F\n+ 1 DailyUsageLegacyMigrationHandler.kt\ncom/stepos/alphame/dailyusage/DailyUsageLegacyMigrationHandlerKt\n*L\n83#1:235\n83#1:236,3\n83#1:246,3\n169#1:254\n169#1:255,3\n170#1:258,9\n170#1:267\n170#1:269\n170#1:270\n180#1:271\n180#1:272,3\n181#1:275\n181#1:276,2\n182#1:278,9\n182#1:287\n184#1:288\n184#1:289,3\n182#1:293\n182#1:294\n83#1:239,7\n84#1:249\n84#1:250,2\n84#1:253\n170#1:268\n182#1:292\n*E\n"})
/* loaded from: classes.dex */
public final class DailyUsageLegacyMigrationHandlerKt {

    @NotNull
    public static final String KEY_FIRST_UPGRADE = "first_upgrade";

    @NotNull
    public static final String KEY_USER_BEHAVIOR_DATA_IN_UPGRADE_DATE = "user_behavior_data_in_upgrade_date";

    @NotNull
    public static final String SELECTION = "date >= ? AND date < ?";

    @NotNull
    public static final String SELECTION_WHEN_UPGRADE = "date = ?";

    @NotNull
    public static final String SORT_ORDER = "date ASC";

    @NotNull
    public static final String TAG = "dailyUsageLegacyMigration";

    @NotNull
    public static final List<AppUsage> extractAppDetails(@NotNull String input) {
        MatchResult.Destructured destructured;
        Intrinsics.checkNotNullParameter(input, "input");
        Regex regex = new Regex("([^=]+)=\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\)");
        List listSplit$default = StringsKt__StringsKt.split$default(input, new String[]{Consts.SPLITTER_DETAIL}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.e(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MatchResult matchResultMatchEntire = regex.matchEntire((String) it2.next());
            AppUsage appUsage = (matchResultMatchEntire == null || (destructured = matchResultMatchEntire.getDestructured()) == null) ? null : new AppUsage(destructured.getMatch().getGroupValues().get(1), Integer.parseInt(destructured.getMatch().getGroupValues().get(2)), Long.parseLong(destructured.getMatch().getGroupValues().get(3)));
            if (appUsage != null) {
                arrayList2.add(appUsage);
            }
        }
        return arrayList2;
    }

    @NotNull
    public static final List<HourlyUsageSummary> extractHourlyDetails(@NotNull String input) {
        Triple<Long, Integer, Integer> numbers;
        Intrinsics.checkNotNullParameter(input, "input");
        List listSplit$default = StringsKt__StringsKt.split$default(input, new String[]{Consts.SPLITTER_DETAIL}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.e(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (!StringsKt.isBlank((String) next)) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            List listSplit$default2 = StringsKt__StringsKt.split$default((String) it3.next(), new char[]{','}, false, 4, 2, (Object) null);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.e(listSplit$default2));
            Iterator it4 = listSplit$default2.iterator();
            while (it4.hasNext()) {
                arrayList4.add(StringsKt.trim((CharSequence) it4.next()).toString());
            }
            HourlyUsageSummary hourlyUsageSummary = null;
            hourlyUsageSummary = null;
            if (arrayList4.size() >= 4 && (numbers = parseNumbers(arrayList4)) != null) {
                hourlyUsageSummary = new HourlyUsageSummary(numbers.component1().longValue(), numbers.component2().intValue(), numbers.component3().intValue(), parseAppUsages(Intrinsics.areEqual(arrayList4.get(3), "null") ? null : (String) arrayList4.get(3)));
            }
            if (hourlyUsageSummary != null) {
                arrayList3.add(hourlyUsageSummary);
            }
        }
        return arrayList3;
    }

    public static final long getFirstUpgradeTime() {
        return ((Number) DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).getData(KEY_FIRST_UPGRADE, 0L)).longValue();
    }

    @NotNull
    public static final MultiDailyUsageSummary getMultiDailySummaryFromUserBehavior(long j4, long j5, boolean z4) {
        long baseTimeMill = TimeUtils.getBaseTimeMill(j4);
        long baseTimeMill2 = TimeUtils.getBaseTimeMill(j5);
        Log.d(DataContractKt.TAG, "from user behavior, get data from " + TimeUtilsKt.formatDateYear(baseTimeMill) + " to " + TimeUtilsKt.formatDateYear(baseTimeMill2) + "}");
        String str = z4 ? SELECTION_WHEN_UPGRADE : SELECTION;
        String strValueOf = String.valueOf(baseTimeMill);
        String[] strArr = z4 ? new String[]{strValueOf} : new String[]{strValueOf, String.valueOf(baseTimeMill2)};
        MultiDailyUsageSummary multiDailyUsageSummary = new MultiDailyUsageSummary(new ArrayList(), System.currentTimeMillis());
        SQLiteDatabase db = Database.getInstance().getDb();
        if (db == null) {
            return multiDailyUsageSummary;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = db.query(UserBehaviorStorable.TABLE_NAME, null, str, strArr, null, null, SORT_ORDER);
                if (cursorQuery == null) {
                    try {
                        Log.d(DataContractKt.TAG, "cursor is null");
                    } catch (Exception e4) {
                        e = e4;
                        cursor = cursorQuery;
                        e.printStackTrace();
                        Log.e(DataContractKt.TAG, "get user behavior failed");
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return multiDailyUsageSummary;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        Cursor cursor3 = cursor;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    Cursor cursor4 = cursorQuery;
                    try {
                        Cursor cursor5 = cursor4;
                        if (cursor5.moveToFirst()) {
                            do {
                                long j6 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date"));
                                Log.e(DataContractKt.TAG, "date " + TimeUtilsKt.formatDateDay(j6) + " -------------------------------");
                                long j7 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(UserBehaviorStorable.COLUMN_TOTAL_USED_TIME));
                                Log.d(DataContractKt.TAG, "totalUsageTime " + TimeUtilsKt.formatDuration(j7));
                                long j8 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(UserBehaviorStorable.COLUMN_TOP_USED_TIME));
                                Log.d(DataContractKt.TAG, "topUsageTime " + TimeUtilsKt.formatDuration(j8));
                                int i4 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(UserBehaviorStorable.COLUMN_SCREEN_ON_TIMES));
                                int i5 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(UserBehaviorStorable.COLUMN_NOTIFICATIONS));
                                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(UserBehaviorStorable.COLUMN_APP_DETAILS));
                                Intrinsics.checkNotNull(string);
                                List<AppUsage> listExtractAppDetails = extractAppDetails(string);
                                Log.d(DataContractKt.TAG, "appDetails " + string + AwarenessDataItem.PERMISSION_SPLITTER + listExtractAppDetails);
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(UserBehaviorStorable.COLUMN_HOURS_DETAILS));
                                Intrinsics.checkNotNull(string2);
                                List<HourlyUsageSummary> listExtractHourlyDetails = extractHourlyDetails(string2);
                                Log.d(DataContractKt.TAG, "hourDetails " + string2 + AwarenessDataItem.PERMISSION_SPLITTER + listExtractHourlyDetails);
                                multiDailyUsageSummary.getDailyUsageSummaries().add(new DailyUsageSummary(j6, 0, -1L, j7, j8, i5, i4, listExtractAppDetails, listExtractHourlyDetails));
                            } while (cursor5.moveToNext());
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursor4, null);
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e5) {
                e = e5;
            }
            return multiDailyUsageSummary;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @NotNull
    public static final MultiDailyUsageSummary getUserBehaviorDataInUpgradeDate() {
        Object objB = new n().b(MultiDailyUsageSummary.class, (String) DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).getData(KEY_USER_BEHAVIOR_DATA_IN_UPGRADE_DATE, ""));
        Intrinsics.checkNotNullExpressionValue(objB, "fromJson(...)");
        return (MultiDailyUsageSummary) objB;
    }

    @NotNull
    public static final List<AppUsage> mergeAppUsageDetails(@NotNull List<AppUsage> oldAppUsages, @NotNull List<AppUsage> newAppUsages) {
        Intrinsics.checkNotNullParameter(oldAppUsages, "oldAppUsages");
        Intrinsics.checkNotNullParameter(newAppUsages, "newAppUsages");
        List listPlus = CollectionsKt.plus((Collection) oldAppUsages, (Iterable) newAppUsages);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listPlus) {
            String packageName = ((AppUsage) obj).getPackageName();
            Object arrayList = linkedHashMap.get(packageName);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(packageName, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            Iterator it = list.iterator();
            int notificationNumber = 0;
            while (it.hasNext()) {
                notificationNumber += ((AppUsage) it.next()).getNotificationNumber();
            }
            Iterator it2 = list.iterator();
            long usedTime = 0;
            while (it2.hasNext()) {
                usedTime += ((AppUsage) it2.next()).getUsedTime();
            }
            arrayList2.add(new AppUsage(str, notificationNumber, usedTime));
        }
        return arrayList2;
    }

    @NotNull
    public static final DailyUsageSummary mergeDailyUsageSummaryInUpgradeDate(@NotNull DailyUsageSummary oldSummary, @NotNull DailyUsageSummary newSummary) {
        Intrinsics.checkNotNullParameter(oldSummary, "oldSummary");
        Intrinsics.checkNotNullParameter(newSummary, "newSummary");
        return new DailyUsageSummary(oldSummary.getDate(), oldSummary.getMode(), oldSummary.getUseId(), newSummary.getDailyUsedTime() + oldSummary.getDailyUsedTime(), oldSummary.getMaximumUsageTime() >= newSummary.getMaximumUsageTime() ? oldSummary.getMaximumUsageTime() : newSummary.getMaximumUsageTime(), newSummary.getNotificationNumbers() + oldSummary.getNotificationNumbers(), newSummary.getScreenOnTimes() + oldSummary.getScreenOnTimes(), mergeAppUsageDetails(oldSummary.getAppDailyUsages(), newSummary.getAppDailyUsages()), mergeHourlyUsageSummary(oldSummary, newSummary));
    }

    @NotNull
    public static final List<HourlyUsageSummary> mergeHourlyUsageSummary(@NotNull DailyUsageSummary oldSummary, @NotNull DailyUsageSummary newSummary) {
        Intrinsics.checkNotNullParameter(oldSummary, "oldSummary");
        Intrinsics.checkNotNullParameter(newSummary, "newSummary");
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < 24; i4++) {
            HourlyUsageSummary hourlyUsageSummary = oldSummary.getHourlyUsageSummaries().get(i4);
            HourlyUsageSummary hourlyUsageSummary2 = newSummary.getHourlyUsageSummaries().get(i4);
            arrayList.add(new HourlyUsageSummary(hourlyUsageSummary2.getHourlyUsageTime() + hourlyUsageSummary.getHourlyUsageTime(), hourlyUsageSummary2.getScreenOnTimes() + hourlyUsageSummary.getScreenOnTimes(), hourlyUsageSummary2.getNotificationNumber() + hourlyUsageSummary.getNotificationNumber(), mergeAppUsageDetails(hourlyUsageSummary.getAppUsages(), hourlyUsageSummary2.getAppUsages())));
        }
        return arrayList;
    }

    public static final void migrateUserBehaviorDataWhenUpgrade(long j4) {
        long baseTimeMill = TimeUtils.getBaseTimeMill(j4);
        Log.d(DataContractKt.TAG, "upgrade， date " + TimeUtilsKt.formatDateDay(baseTimeMill) + " ----------------");
        MultiDailyUsageSummary multiDailySummaryFromUserBehavior = getMultiDailySummaryFromUserBehavior(baseTimeMill, baseTimeMill, true);
        Log.d(DataContractKt.TAG, "merge upgrade date' data， summary " + multiDailySummaryFromUserBehavior + "} ----------------");
        DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).putData(KEY_USER_BEHAVIOR_DATA_IN_UPGRADE_DATE, new n().g(multiDailySummaryFromUserBehavior));
    }

    private static final List<AppUsage> parseAppUsages(String str) {
        return (str == null || StringsKt.isBlank(str)) ? CollectionsKt.emptyList() : SequencesKt.toList(SequencesKt.mapNotNull(Regex.findAll$default(new Regex("([^=]+?)\\s*=\\s*\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\)"), str, 0, 2, null), new Function1<MatchResult, AppUsage>() { // from class: com.stepos.alphame.dailyusage.DailyUsageLegacyMigrationHandlerKt.parseAppUsages.1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final AppUsage invoke(@NotNull MatchResult match) {
                Intrinsics.checkNotNullParameter(match, "match");
                MatchResult.Destructured destructured = match.getDestructured();
                String str2 = destructured.getMatch().getGroupValues().get(1);
                String str3 = destructured.getMatch().getGroupValues().get(2);
                String str4 = destructured.getMatch().getGroupValues().get(3);
                Integer intOrNull = StringsKt.toIntOrNull(str3);
                if (intOrNull != null) {
                    int iIntValue = intOrNull.intValue();
                    Long longOrNull = StringsKt.toLongOrNull(str4);
                    if (longOrNull != null) {
                        return new AppUsage(str2, iIntValue, longOrNull.longValue());
                    }
                }
                return null;
            }
        }));
    }

    private static final Triple<Long, Integer, Integer> parseNumbers(List<String> list) {
        try {
            return new Triple<>(Long.valueOf(Long.parseLong(list.get(0))), Integer.valueOf(Integer.parseInt(list.get(1))), Integer.valueOf(Integer.parseInt(list.get(2))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final void saveUpgradeTimeWhenFirstUpgrade(long j4) {
        DataStorePreferences dataStore = DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME);
        if (((Number) dataStore.getData(KEY_FIRST_UPGRADE, 0L)).longValue() == 0) {
            Log.i(DataContractKt.TAG, "save time when first upgrade.");
            dataStore.putData(KEY_FIRST_UPGRADE, Long.valueOf(j4));
        }
    }
}
