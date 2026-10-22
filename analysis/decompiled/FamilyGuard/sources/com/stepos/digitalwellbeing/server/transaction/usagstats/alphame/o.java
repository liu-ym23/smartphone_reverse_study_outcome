package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import f2.C0711p;
import java.util.Map;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final W1.c f14693a;

    public o(W1.c cVar) {
        this.f14693a = cVar;
    }

    private void b(String str, String str2, int i5, StatsDataSet statsDataSet) throws Throwable {
        long jLongValue;
        long j5;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String strTrim = str.trim();
        String strTrim2 = str2.trim();
        if (strTrim.contains("=")) {
            String[] strArrSplit = strTrim.split("=");
            if (strArrSplit.length != 2) {
                return;
            }
            String str3 = strArrSplit[0];
            if (PackageUtils.u(str3)) {
                if (strArrSplit[1].startsWith("(") && strTrim2.endsWith(")")) {
                    try {
                        long j6 = Long.parseLong(strTrim2.substring(0, strTrim2.length() - 1));
                        if (j6 > 0) {
                            statsDataSet.setUsingTime(Math.max(0L, statsDataSet.getUsingTime() - j6));
                            return;
                        }
                        return;
                    } catch (NumberFormatException unused) {
                        return;
                    }
                }
                return;
            }
            String str4 = strArrSplit[1];
            if (str4.startsWith("(") && strTrim2.endsWith(")")) {
                String strSubstring = str4.substring(1, str4.length());
                String strSubstring2 = strTrim2.substring(0, strTrim2.length() - 1);
                int i6 = Integer.parseInt(strSubstring);
                long j7 = Long.parseLong(strSubstring2);
                Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
                Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
                Map<String, Long> categoryUsingTimeMap = statsDataSet.getCategoryUsingTimeMap();
                if (packageNotifyTimesMap != null) {
                    if (packageNotifyTimesMap.containsKey(str3)) {
                        int iIntValue = packageNotifyTimesMap.get(str3).intValue() + i6;
                        packageNotifyTimesMap.put(str3, Integer.valueOf(iIntValue));
                        j5 = iIntValue;
                    } else {
                        packageNotifyTimesMap.put(str3, Integer.valueOf(i6));
                        j5 = i6;
                    }
                    C0702g.b("TodayDetailParser", "        packageName = " + str3 + " notifyTimes = " + i6 + " notifyTimesSum = " + j5);
                }
                if (packageUsingTimeMap != null) {
                    if (packageUsingTimeMap.containsKey(str3)) {
                        jLongValue = packageUsingTimeMap.get(str3).longValue() + j7;
                        packageUsingTimeMap.put(str3, Long.valueOf(jLongValue));
                    } else {
                        packageUsingTimeMap.put(str3, Long.valueOf(j7));
                        jLongValue = j7;
                    }
                    C0702g.b("TodayDetailParser", "        packageName = " + str3 + " usingTime = " + C0711p.t(j7) + " usingTimeSum = " + C0711p.t(jLongValue) + "\n ");
                }
                if (categoryUsingTimeMap != null) {
                    Category categoryI = this.f14693a.i(str3);
                    int id = categoryI != null ? categoryI.getId() : 10;
                    if ((categoryI == null || id == 10) && j7 > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("USAGE_DEBUG other_category_package source=legacy_today_detail reason=");
                        sb.append(categoryI == null ? "null_category" : "category_other");
                        sb.append(" package=");
                        sb.append(str3);
                        sb.append(" usage=");
                        sb.append(C0711p.t(j7));
                        C0702g.O("TodayDetailParser", sb.toString());
                    }
                    String strB = W1.a.b(id);
                    if (categoryUsingTimeMap.containsKey(strB)) {
                        categoryUsingTimeMap.put(strB, Long.valueOf(categoryUsingTimeMap.get(strB).longValue() + j7));
                    } else if (j7 > 0) {
                        categoryUsingTimeMap.put(strB, Long.valueOf(j7));
                    }
                }
            }
        }
    }

    private StatsDataSet c(String str, int i5, long j5, long j6) throws Throwable {
        try {
            String[] strArrSplit = str.split(",");
            long j7 = Long.parseLong(strArrSplit[0]);
            int i6 = Integer.parseInt(strArrSplit[1]);
            int i7 = Integer.parseInt(strArrSplit[2]);
            StatsDataSet statsDataSet = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal(), 0, j6, j5 + (i5 * 3600000), null);
            statsDataSet.setUsingTime(j7);
            statsDataSet.setPickupTimes(i6);
            statsDataSet.setNotifyTimes(i7);
            C0702g.b("TodayDetailParser", "   hour = " + i5 + " usageTime = " + C0711p.t(j7) + " pickUpTimes = " + i6 + " notificationTimes = " + i7);
            int length = strArrSplit.length;
            for (int i8 = 3; i8 < length - 1; i8 += 2) {
                b(strArrSplit[i8], strArrSplit[i8 + 1], i5, statsDataSet);
            }
            long usingTime = statsDataSet.getUsingTime();
            if (statsDataSet.liftUsingTimeToAtLeastPackageSum()) {
                C0702g.O("TodayDetailParser", "lift hourly usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
            }
            return statsDataSet;
        } catch (Exception e6) {
            C0702g.p("TodayDetailParser", Log.getStackTraceString(e6));
            return null;
        }
    }

    private StatsDataSet[] d(long j5, String str, long j6) {
        try {
            String[] strArrE = e(str);
            if (strArrE == null) {
                return null;
            }
            int length = strArrE.length;
            StatsDataSet[] statsDataSetArr = new StatsDataSet[length];
            for (int i5 = 0; i5 < length; i5++) {
                statsDataSetArr[i5] = c(strArrE[i5], i5, j5, j6);
            }
            return statsDataSetArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String[] e(String str) {
        try {
            return str.split("\\|");
        } catch (Exception e6) {
            C0702g.p("TodayDetailParser", Log.getStackTraceString(e6));
            C0702g.p("TodayDetailParser", "parseHoursDetailString raw string cant split rawString = " + str);
            return null;
        }
    }

    public StatsDataSet a(Cursor cursor) {
        StatsDataSet statsDataSet;
        long j5;
        long j6;
        long j7;
        int i5;
        int i6;
        long j8;
        StatsDataSet[] statsDataSetArrD;
        if (cursor == null) {
            C0702g.p("TodayDetailParser", "parse cursor = null return null");
            return null;
        }
        if (cursor.getCount() == 0) {
            cursor.close();
            C0702g.p("TodayDetailParser", "parse cursor is empty return null");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                cursor.moveToFirst();
                j5 = cursor.getLong(cursor.getColumnIndexOrThrow("date"));
                j6 = cursor.getLong(cursor.getColumnIndexOrThrow("top_used_time"));
                j7 = cursor.getLong(cursor.getColumnIndexOrThrow("total_used_time"));
                i5 = cursor.getInt(cursor.getColumnIndexOrThrow("screen_on_times"));
                i6 = cursor.getInt(cursor.getColumnIndexOrThrow("notifications"));
                String string = cursor.getString(cursor.getColumnIndexOrThrow("app_details"));
                C0702g.b("TodayDetailParser", "date = " + C0711p.j(j5) + " details = " + string);
                if (string == null) {
                    C0702g.p("TodayDetailParser", "hoursDetails == null 创建空数据");
                    statsDataSetArrD = StatsDataSet.createEmptyStatsDataSetArray(j5, jCurrentTimeMillis, com.stepos.digitalwellbeing.server.data.a.DAY.ordinal());
                    j8 = jCurrentTimeMillis;
                } else {
                    j8 = jCurrentTimeMillis;
                    statsDataSetArrD = d(j5, string, j8);
                }
                statsDataSet = null;
            } finally {
                cursor.close();
            }
        } catch (Exception unused) {
            statsDataSet = null;
        }
        try {
            StatsDataSet statsDataSet2 = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), 24, j8, j5, statsDataSetArrD);
            long usingTime = statsDataSet2.getUsingTime();
            int pickupTimes = statsDataSet2.getPickupTimes();
            int notifyTimes = statsDataSet2.getNotifyTimes();
            if (usingTime != j7) {
                C0702g.O("TodayDetailParser", "expect usingTime = " + C0711p.t(j7) + " real usingTime = " + C0711p.t(usingTime));
            }
            if (pickupTimes != i5) {
                C0702g.O("TodayDetailParser", "expect pickup = " + i5 + " real pickup = " + pickupTimes);
            }
            if (notifyTimes != i6) {
                C0702g.O("TodayDetailParser", "expect notify = " + i6 + " real notify = " + notifyTimes);
            }
            statsDataSet2.setLongestUseTime(j6);
            j.j(P1.a.a(), this.f14693a, statsDataSet2);
            cursor.close();
            return statsDataSet2;
        } catch (Exception unused2) {
            return statsDataSet;
        }
    }
}
