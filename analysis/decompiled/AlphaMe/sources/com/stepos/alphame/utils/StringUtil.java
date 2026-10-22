package com.stepos.alphame.utils;

import B0.g;
import android.text.TextUtils;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class StringUtil {
    private static final long HOUR = 3600000;
    private static final long MINUTE = 60000;
    private static final long SECOND = 1000;
    public static final String SPLITTER = ",";
    private static final ThreadLocal<SimpleDateFormat> SDF_FULL = new ThreadLocal<SimpleDateFormat>() { // from class: com.stepos.alphame.utils.StringUtil.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> SDF_YMD = new ThreadLocal<SimpleDateFormat>() { // from class: com.stepos.alphame.utils.StringUtil.2
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> SDF_HMS = new ThreadLocal<SimpleDateFormat>() { // from class: com.stepos.alphame.utils.StringUtil.3
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> SDF_HM = new ThreadLocal<SimpleDateFormat>() { // from class: com.stepos.alphame.utils.StringUtil.4
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> SDF_WEEK = new ThreadLocal<SimpleDateFormat>() { // from class: com.stepos.alphame.utils.StringUtil.5
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss EEE", Locale.US);
        }
    };

    public static String arrayToString(List<Integer> list) {
        String string = null;
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (i4 == 0) {
                    string = String.valueOf(list.get(i4));
                } else {
                    StringBuilder sbV = g.v(string, ",");
                    sbV.append(String.valueOf(list.get(i4)));
                    string = sbV.toString();
                }
            }
        }
        return string;
    }

    public static String formatDateFull(long j4) {
        if (j4 == 0) {
            return null;
        }
        return SDF_FULL.get().format(new Date(j4));
    }

    public static String formatDateHM(long j4) {
        return j4 <= 0 ? "null" : SDF_HM.get().format(new Date(j4));
    }

    public static String formatDateHMS(long j4) {
        return SDF_HMS.get().format(new Date(j4));
    }

    public static String formatDateWeek(long j4) {
        return SDF_WEEK.get().format(new Date(j4));
    }

    public static String formatDateYMD(long j4) {
        return SDF_YMD.get().format(new Date(j4));
    }

    public static String formatTimeMill(long j4) {
        if (j4 <= 0) {
            return "0h0m0s";
        }
        return (j4 / 3600000) + "h" + ((j4 % 3600000) / 60000) + ANSIConstants.ESC_END + ((j4 % 60000) / 1000) + "s";
    }

    public static boolean hasSplitter(String str) {
        return !TextUtils.isEmpty(str) && str.contains(",");
    }

    public static <T> String toString(T[] tArr, String str, String str2, String str3) {
        if (tArr == null || tArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(tArr.length * 30);
        for (T t4 : tArr) {
            if (sb.length() > 0 && str3 != null) {
                sb.append(str3);
            }
            if (str != null) {
                sb.append(str);
            }
            sb.append(t4);
            if (str2 != null) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
