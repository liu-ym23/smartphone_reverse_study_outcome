package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import d2.C0661i;
import f2.C0702g;
import java.util.HashMap;

/* loaded from: classes.dex */
public class q {
    private static void b(String str, String str2, C0661i c0661i, int i5) throws NumberFormatException {
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
                return;
            }
            String str4 = strArrSplit[1];
            if (str4.startsWith("(") && strTrim2.endsWith(")")) {
                String strSubstring = str4.substring(1, str4.length());
                String strSubstring2 = strTrim2.substring(0, strTrim2.length() - 1);
                int i6 = Integer.parseInt(strSubstring);
                long j5 = Long.parseLong(strSubstring2);
                HashMap<String, int[]> mapH = c0661i.h();
                int[] iArr = mapH.get(str3);
                if (iArr == null) {
                    iArr = new int[24];
                    mapH.put(str3, iArr);
                }
                iArr[i5] = i6;
                HashMap<String, Integer> mapC = c0661i.c();
                int iIntValue = i6 + (mapC.containsKey(str3) ? mapC.get(str3).intValue() : 0);
                if (iIntValue > 0) {
                    mapC.put(str3, Integer.valueOf(iIntValue));
                }
                HashMap<String, long[]> mapG = c0661i.g();
                long[] jArr = mapG.get(str3);
                if (jArr == null) {
                    jArr = new long[24];
                    mapG.put(str3, jArr);
                }
                jArr[i5] = j5;
                HashMap<String, Long> mapA = c0661i.a();
                long jLongValue = j5 + (mapA.containsKey(str3) ? mapA.get(str3).longValue() : 0L);
                if (jLongValue > 0) {
                    mapA.put(str3, Long.valueOf(jLongValue));
                }
            }
        }
    }

    private static void c(String str, C0661i c0661i, int i5) throws NumberFormatException {
        Log.d("TodayDetailParser", "parseHourString index = " + i5 + " hourString = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split(",");
            long j5 = Long.parseLong(strArrSplit[0]);
            int i6 = Integer.parseInt(strArrSplit[1]);
            int i7 = Integer.parseInt(strArrSplit[2]);
            c0661i.b()[i5] = j5;
            c0661i.d()[i5] = i6;
            c0661i.e()[i5] = i7;
            int length = strArrSplit.length;
            for (int i8 = 3; i8 < length - 1; i8 += 2) {
                b(strArrSplit[i8], strArrSplit[i8 + 1], c0661i, i5);
            }
        } catch (Exception unused) {
        }
    }

    private static void d(String str, C0661i c0661i) throws NumberFormatException {
        String[] strArrE = e(str);
        if (strArrE == null) {
            C0702g.p("TodayDetailParser", "parseHoursDetailString hoursStringArray = null return");
            return;
        }
        int length = strArrE.length;
        if (length != 24) {
            C0702g.p("TodayDetailParser", "parseHoursDetailString hoursStringArray size != 24 return");
            return;
        }
        for (int i5 = 0; i5 < length; i5++) {
            c(strArrE[i5], c0661i, i5);
        }
    }

    private static String[] e(String str) {
        try {
            return str.split("\\|");
        } catch (Exception unused) {
            C0702g.p("TodayDetailParser", "parseHoursDetailString raw string cant split");
            return null;
        }
    }

    public C0661i a(Cursor cursor) throws NumberFormatException {
        if (cursor == null) {
            C0702g.p("TodayDetailParser", "parse cursor = null return null");
            return null;
        }
        if (cursor.getCount() == 0) {
            cursor.close();
            C0702g.p("TodayDetailParser", "parse cursor is empty return null");
            return null;
        }
        try {
            cursor.moveToFirst();
            long j5 = cursor.getLong(cursor.getColumnIndexOrThrow("top_used_time"));
            long j6 = cursor.getLong(cursor.getColumnIndexOrThrow("total_used_time"));
            int i5 = cursor.getInt(cursor.getColumnIndexOrThrow("screen_on_times"));
            int i6 = cursor.getInt(cursor.getColumnIndexOrThrow("notifications"));
            String string = cursor.getString(cursor.getColumnIndexOrThrow("app_details"));
            cursor.close();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            C0661i c0661i = new C0661i(j5, j6, i5, i6, System.currentTimeMillis());
            c0661i.i(j5);
            Log.d("TodayDetailParser", "parse longest = " + j5 + " totalUsedTime = " + j6 + " totalTakeupTimes = " + i5 + " totalNotificationTimes = " + i6);
            StringBuilder sb = new StringBuilder();
            sb.append("parse hoursDetailString = ");
            sb.append(string);
            Log.d("TodayDetailParser", sb.toString());
            d(string, c0661i);
            return c0661i;
        } catch (Exception unused) {
            cursor.close();
            return null;
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
    }
}
