package com.bytedance.common.utility.date;

import android.content.Context;
import com.bytedance.common.utility.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public final class DateUtils implements DateDef {
    private static final SimpleDateFormat DAY_FORMAT = null;
    private static final SimpleDateFormat YEAR_FORMAT = null;

    static {
        YEAR_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        DAY_FORMAT = new SimpleDateFormat("MM-dd HH:mm");
    }

    private DateUtils() {
    }

    public static String getDateString(Context r5, long r6) {
        if (isCurrentYear(r6) == true) goto L7;
        return YEAR_FORMAT.format(Long.valueOf(r6));
    L7:
        if (android.text.format.DateUtils.isToday(r6) == false) goto L9;
        long r0 = System.currentTimeMillis() - r6;
        if (r0 < DateDef.HOUR) goto L15;
        return r5.getString(R.string.hours_ago, new Object[]{Long.valueOf(r0 / DateDef.HOUR)});
    L15:
        if (r0 < 60000) goto L19;
        return r5.getString(R.string.minutes_ago, new Object[]{Long.valueOf(r0 / 60000)});
    L19:
        return r5.getString(R.string.just_now);
    L9:
        return DAY_FORMAT.format(Long.valueOf(r6));
    }

    public static boolean isCurrentYear(long r3) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r3);
        int r4 = r0.get(1);
        r0.setTimeInMillis(System.currentTimeMillis());
        if (r4 == r0.get(1)) goto L7;
        return false;
    L7:
        return true;
    }
}
