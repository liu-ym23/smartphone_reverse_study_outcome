package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import d2.C0663k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class w {
    private static void b(String str, C0663k c0663k, int i5) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("=");
            String str2 = strArrSplit[0];
            if (PackageUtils.u(str2)) {
                return;
            }
            String str3 = strArrSplit[1];
            if (!TextUtils.isEmpty(str3) && str3.startsWith("(") && str3.endsWith(")")) {
                String[] strArrSplit2 = str3.substring(1, str3.length() - 1).split(",");
                String strTrim = strArrSplit2[0].trim();
                String strTrim2 = strArrSplit2[1].trim();
                try {
                    int i6 = Integer.parseInt(strTrim);
                    long j5 = Long.parseLong(strTrim2);
                    if (c0663k != null) {
                        long[] jArr = c0663k.g().get(str2);
                        int[] iArr = c0663k.h().get(str2);
                        if (jArr == null) {
                            jArr = new long[7];
                            c0663k.g().put(str2, jArr);
                        }
                        if (iArr == null) {
                            iArr = new int[7];
                            c0663k.h().put(str2, iArr);
                        }
                        if (j5 > 0) {
                            c0663k.a().put(str2, Long.valueOf((c0663k.a().containsKey(str2) ? c0663k.a().get(str2).longValue() : 0L) + j5));
                        }
                        jArr[i5] = j5;
                        if (i6 > 0) {
                            c0663k.c().put(str2, Integer.valueOf((c0663k.c().containsKey(str2) ? c0663k.c().get(str2).intValue() : 0) + i6));
                        }
                        iArr[i5] = i6;
                    }
                } catch (Exception e6) {
                    Log.w("WeekDetailParser", BuildConfig.FLAVOR + e6);
                }
            }
        } catch (Exception e7) {
            Log.w("WeekDetailParser", BuildConfig.FLAVOR + e7);
        }
    }

    private static void c(String str, C0663k c0663k, int i5) throws NumberFormatException {
        String[] strArrD = d(str);
        if (strArrD == null) {
            return;
        }
        for (String str2 : strArrD) {
            b(str2, c0663k, i5);
        }
    }

    private static String[] d(String str) {
        try {
            String[] strArrSplit = str.split("\\|");
            if (strArrSplit.length == 0) {
                return null;
            }
            return strArrSplit;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0299 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d2.C0663k a(android.database.Cursor[] r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.w.a(android.database.Cursor[]):d2.k");
    }
}
