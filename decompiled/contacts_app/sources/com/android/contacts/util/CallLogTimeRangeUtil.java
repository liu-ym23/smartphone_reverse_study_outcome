package com.android.contacts.util;

import android.content.Context;
import android.text.format.DateFormat;
import com.obric.oui.time.ClockFormat;
import com.obric.oui.time.TimeDateUtil;
import com.obric.oui.time.TimeStyle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogTimeRangeUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/contacts/util/CallLogTimeRangeUtil;", "", "()V", "CALL_DETAIL_IN_ONE_DAY", "", "CALL_DETAIL_OVER_DAY_FORMAT", "CALL_DETAIL_OVER_YEAR_FORMAT", "getCallDetailFormatTime", "timestamp", "", "getCallLogListFormatTime", "context", "Landroid/content/Context;", "getCustomFormatTime", "getFormatTimeByStyle", "timeStyle", "Lcom/obric/oui/time/TimeStyle;", "isSameYear", "", "targetTimestamp", "isToday", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogTimeRangeUtil {
    public static final String CALL_DETAIL_IN_ONE_DAY = "HH:mm";
    public static final String CALL_DETAIL_OVER_DAY_FORMAT = "M月d日 HH:mm";
    public static final String CALL_DETAIL_OVER_YEAR_FORMAT = "yyyy年M月d日 HH:mm";
    public static final CallLogTimeRangeUtil INSTANCE = null;

    /* JADX INFO: compiled from: CallLogTimeRangeUtil.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TimeStyle.values().length];
            r0[TimeStyle.RELATIVE_DETAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TimeStyle.RELATIVE_MIXED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TimeStyle.RELATIVE_FUZZY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new CallLogTimeRangeUtil();
    }

    private CallLogTimeRangeUtil() {
    }

    @JvmStatic
    public static final String getCallLogListFormatTime(long r7) {
        return TimeDateUtil.formatTimeRelative$default(TimeStyle.RELATIVE_MIXED_BRIEF, new Date(r7), new Date(), null, null, 24, null);
    }

    @JvmStatic
    public static final String getCallLogListFormatTime(long r3, Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (DateFormat.is24HourFormat(r5) == false) goto L5;
        ClockFormat r6 = ClockFormat.H24;
    L6:
        TimeStyle r0 = TimeStyle.RELATIVE_MIXED_BRIEF;
        Date r1 = new Date(r3);
        Date r4 = new Date();
        Locale r7 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r7, "getDefault()");
        return TimeDateUtil.formatTimeRelative(r0, r1, r4, r7, r6);
    L5:
        r6 = ClockFormat.H12;
        goto L6
    }

    @JvmStatic
    public static final String getCallDetailFormatTime(long r0) {
        return getCustomFormatTime(r0);
    }

    @JvmStatic
    public static final String getFormatTimeByStyle(long r7, TimeStyle r9) {
        Intrinsics.checkNotNullParameter(r9, "timeStyle");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        return TimeDateUtil.formatTime(r9, new Date(r7), ClockFormat.H24, false);
    L10:
        return TimeDateUtil.formatTimeRelative$default(r9, new Date(r7), new Date(), null, null, 24, null);
    }

    @JvmStatic
    public static final boolean isToday(long r6) {
        Calendar r0 = Calendar.getInstance();
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        long r3 = r0.getTimeInMillis();
        r0.add(6, 1);
        long r1 = r0.getTimeInMillis();
        if (r3 <= r6) goto L5;
        return false;
    L5:
        if (r6 < r1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean isSameYear(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        Calendar r2 = Calendar.getInstance();
        if (r0.get(1) == r2.get(1)) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final String getCustomFormatTime(long r3) {
        if (isToday(r3) == false) goto L6;
        String r4 = new SimpleDateFormat(CALL_DETAIL_IN_ONE_DAY).format(Long.valueOf(r3));
        Intrinsics.checkNotNullExpressionValue(r4, "{\n                // 一天内…(timestamp)\n            }");
        return r4;
    L6:
        if (isSameYear(r3) == false) goto L8;
        String r5 = new SimpleDateFormat(CALL_DETAIL_OVER_DAY_FORMAT).format(Long.valueOf(r3));
        Intrinsics.checkNotNullExpressionValue(r5, "{\n                // 超过一…(timestamp)\n            }");
        return r5;
    L8:
        String r6 = new SimpleDateFormat(CALL_DETAIL_OVER_YEAR_FORMAT).format(Long.valueOf(r3));
        Intrinsics.checkNotNullExpressionValue(r6, "{\n                // 超过一…(timestamp)\n            }");
        return r6;
    }
}
