package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import f2.C0711p;
import java.util.Map;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final W1.c f14674a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f14675b;

    public i(Context context, W1.c cVar) {
        this.f14674a = cVar;
        this.f14675b = context == null ? null : context.getApplicationContext();
    }

    private static int a(long j5, long j6) {
        return (int) ((j6 - j5) / 86400000);
    }

    private void c(String str, String str2, int i5, StatsDataSet statsDataSet) throws Throwable {
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
                    C0702g.b("DaysDetailParser", "        packageName = " + str3 + " notifyTimes = " + i6 + " notifyTimesSum = " + j5);
                }
                if (packageUsingTimeMap != null) {
                    if (packageUsingTimeMap.containsKey(str3)) {
                        jLongValue = packageUsingTimeMap.get(str3).longValue() + j7;
                        packageUsingTimeMap.put(str3, Long.valueOf(jLongValue));
                    } else {
                        packageUsingTimeMap.put(str3, Long.valueOf(j7));
                        jLongValue = j7;
                    }
                    C0702g.b("DaysDetailParser", "        packageName = " + str3 + " usingTime = " + C0711p.t(j7) + " usingTimeSum = " + C0711p.t(jLongValue) + "\n ");
                }
                if (categoryUsingTimeMap != null) {
                    Category categoryI = this.f14674a.i(str3);
                    int id = categoryI != null ? categoryI.getId() : 10;
                    if ((categoryI == null || id == 10) && j7 > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("USAGE_DEBUG other_category_package source=legacy_days_detail reason=");
                        sb.append(categoryI == null ? "null_category" : "category_other");
                        sb.append(" package=");
                        sb.append(str3);
                        sb.append(" usage=");
                        sb.append(C0711p.t(j7));
                        C0702g.O("DaysDetailParser", sb.toString());
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

    private StatsDataSet d(String str, int i5, long j5, long j6) throws Throwable {
        try {
            String[] strArrSplit = str.split(",");
            long j7 = Long.parseLong(strArrSplit[0]);
            int i6 = Integer.parseInt(strArrSplit[1]);
            int i7 = Integer.parseInt(strArrSplit[2]);
            StatsDataSet statsDataSet = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal(), 0, j6, j5 + (i5 * 3600000), null);
            statsDataSet.setUsingTime(j7);
            statsDataSet.setPickupTimes(i6);
            statsDataSet.setNotifyTimes(i7);
            C0702g.b("DaysDetailParser", "   hour = " + i5 + " usageTime = " + C0711p.t(j7) + " pickUpTimes = " + i6 + " notificationTimes = " + i7);
            int length = strArrSplit.length;
            for (int i8 = 3; i8 < length - 1; i8 += 2) {
                c(strArrSplit[i8], strArrSplit[i8 + 1], i5, statsDataSet);
            }
            long usingTime = statsDataSet.getUsingTime();
            if (statsDataSet.liftUsingTimeToAtLeastPackageSum()) {
                C0702g.O("DaysDetailParser", "lift hourly usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
            }
            return statsDataSet;
        } catch (Exception e6) {
            C0702g.p("DaysDetailParser", Log.getStackTraceString(e6));
            return null;
        }
    }

    private StatsDataSet[] e(long j5, String str, long j6) {
        try {
            String[] strArrG = g(str);
            if (strArrG == null) {
                return null;
            }
            int length = strArrG.length;
            StatsDataSet[] statsDataSetArr = new StatsDataSet[length];
            for (int i5 = 0; i5 < length; i5++) {
                statsDataSetArr[i5] = d(strArrG[i5], i5, j5, j6);
            }
            return statsDataSetArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private void f(Context context, StatsDataSet[] statsDataSetArr) {
        if (statsDataSetArr == null) {
            return;
        }
        for (StatsDataSet statsDataSet : statsDataSetArr) {
            j.k(context, this.f14674a, statsDataSet);
        }
    }

    private static String[] g(String str) {
        try {
            return str.split("\\|");
        } catch (Exception e6) {
            C0702g.p("DaysDetailParser", Log.getStackTraceString(e6));
            C0702g.p("DaysDetailParser", "parseHoursDetailString raw string cant split rawString = " + str);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e8 A[Catch: all -> 0x03de, Exception -> 0x03e1, TryCatch #10 {all -> 0x03de, blocks: (B:110:0x03e3, B:115:0x03ee, B:117:0x0402, B:116:0x03f8, B:113:0x03e8, B:120:0x0437, B:101:0x039f, B:105:0x03d9), top: B:137:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03ee A[Catch: all -> 0x03de, Exception -> 0x03e1, TryCatch #10 {all -> 0x03de, blocks: (B:110:0x03e3, B:115:0x03ee, B:117:0x0402, B:116:0x03f8, B:113:0x03e8, B:120:0x0437, B:101:0x039f, B:105:0x03d9), top: B:137:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03f8 A[Catch: all -> 0x03de, Exception -> 0x03e1, TryCatch #10 {all -> 0x03de, blocks: (B:110:0x03e3, B:115:0x03ee, B:117:0x0402, B:116:0x03f8, B:113:0x03e8, B:120:0x0437, B:101:0x039f, B:105:0x03d9), top: B:137:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x045a  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.digitalwellbeing.server.data.StatsDataSet[] b(android.database.Cursor[] r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.i.b(android.database.Cursor[]):com.stepos.digitalwellbeing.server.data.StatsDataSet[]");
    }
}
