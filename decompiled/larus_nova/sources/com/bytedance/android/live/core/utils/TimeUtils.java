package com.bytedance.android.live.core.utils;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes45.dex */
public class TimeUtils {
    private static final SimpleDateFormat CUR_TIME_FORMAT = null;
    private static final SimpleDateFormat H_M_S_TIME_FORMAT = null;
    private static final SimpleDateFormat LIVE_ROOM_OP_TIME_FORMAT = null;
    private static final SimpleDateFormat M_D_TIME_FORMAT = null;

    static {
        CUR_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        LIVE_ROOM_OP_TIME_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        M_D_TIME_FORMAT = new SimpleDateFormat("MM月dd日");
        H_M_S_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    }

    public static long currentTimeMillis() {
        return System.nanoTime() / 1000000;
    }

    private TimeUtils() {
    }

    public static String formatChineseDurationString(long r100) {
        if (r100 >= 0) goto L6;
        return "";
    L6:
        int r101 = (int) (r100 / 86400000);
        long r102 = r100 % 86400000;
        int r103 = (int) (r102 / 3600000);
        long r104 = r102 % 3600000;
        int r105 = (int) (r104 / 60000);
        int r106 = (int) ((r104 % 60000) / 1000);
        StringBuilder r107 = new StringBuilder();
        if (r101 <= 0) goto L10;
        r107.append(r101);
        r107.append(s1.p(R.plurals.ttlive_core_time_day, r101));
    L10:
        if (r101 > 0) goto L12;
        if (r103 > 0) goto L12;
    L13:
        Locale r108 = Locale.ROOT;
        r107.append(String.format(r108, "%02d", new Object[]{Integer.valueOf(r105)}));
        r107.append(s1.p(R.plurals.ttlive_core_time_minute, r105));
        r107.append(String.format(r108, "%02d", new Object[]{Integer.valueOf(r106)}));
        r107.append(s1.p(R.plurals.ttlive_core_time_second, r106));
        return r107.toString();
    L12:
        r107.append(String.format(Locale.ROOT, "%02d", new Object[]{Integer.valueOf(r103)}));
        r107.append(s1.p(R.plurals.ttlive_core_time_hour, r103));
        goto L13
    }

    public static String formatLiveDuration(int r100) {
        int r101 = r100 / BaseConstants.Time.HOUR;
        int r102 = (r100 % BaseConstants.Time.HOUR) / 60000;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[]{Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf((r100 % 60000) / 1000)});
    }

    public static String formatLiveRoomOpTime(long r100) {
        return LIVE_ROOM_OP_TIME_FORMAT.format(new Date(r100));
    }

    public static String formatVideoDuration(int r100) {
        int r101 = r100 / BaseConstants.Time.HOUR;
        int r102 = (r100 % BaseConstants.Time.HOUR) / 60000;
        int r103 = (r100 % 60000) / 1000;
        if (r101 != 0) goto L6;
        return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(r102), Integer.valueOf(r103)});
    L6:
        return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[]{Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)});
    }

    public static boolean isToday(long r100) {
        SimpleDateFormat r101 = CUR_TIME_FORMAT;
        return r101.format(new Date(r100)).equals(r101.format(new Date()));
    }

    public static String getTimeDescription(Context r100, long r110) {
        long r101 = System.currentTimeMillis() - r110;
        if (r101 > 60000) goto L7;
        return r100.getString(R.string.ttlive_core_just_now);
    L7:
        if (r101 > 3600000) goto L11;
        int r111 = (int) (r101 / 60000);
        return r100.getResources().getQuantityString(R.plurals.ttlive_core_minutes_ago, r111, new Object[]{Integer.valueOf(r111)});
    L11:
        if (r101 > 86400000) goto L15;
        int r112 = (int) (r101 / 3600000);
        return r100.getResources().getQuantityString(R.plurals.ttlive_core_hours_ago, r112, new Object[]{Integer.valueOf(r112)});
    L15:
        return CUR_TIME_FORMAT.format(new Date(r110));
    }

    public static boolean isToday(long r100, long r101) {
        SimpleDateFormat r102 = CUR_TIME_FORMAT;
        return r102.format(new Date(r100)).equals(r102.format(new Date(r101)));
    }

    public static String getTimeDescription(Context r100, long r101, long r110) {
        long r111 = r110 - r101;
        if (r111 > 60000) goto L7;
        return r100.getString(R.string.ttlive_core_just_now);
    L7:
        if (r111 > 3600000) goto L11;
        int r102 = (int) (r111 / 60000);
        return r100.getResources().getQuantityString(R.plurals.ttlive_core_minutes_ago, r102, new Object[]{Integer.valueOf(r102)});
    L11:
        if (r111 > 86400000) goto L15;
        int r103 = (int) (r111 / 3600000);
        return r100.getResources().getQuantityString(R.plurals.ttlive_core_hours_ago, r103, new Object[]{Integer.valueOf(r103)});
    L15:
        return CUR_TIME_FORMAT.format(new Date(r101));
    }
}
