package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/capabilitykit/common/ClockUtils;", "", "()V", "convertDaysOfWeekToDesc", "", "daysOfWeek", "", "", "convertTimeToDesc", "hour", "minutes", "genClockTimeDesc", BatteryTypeInf.BATTERY_ALARM, "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "getTodayOrTomorrow", "date", "minute", "isSameDay", "", "cal1", "Ljava/util/Calendar;", "cal2", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockUtils {

    @NotNull
    public static final ClockUtils INSTANCE = null;

    static {
        INSTANCE = new ClockUtils();
    }

    private ClockUtils() {
    }

    private final String convertDaysOfWeekToDesc(List<Integer> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<Integer> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        switch(r12.next().intValue()) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L8;
            default: goto L4;
        };
    L8:
        String r13 = "周日";
    L9:
        r11.add(r13);
        goto L4
    L10:
        r13 = "周六";
        goto L9
    L11:
        r13 = "周五";
        goto L9
    L12:
        r13 = "周四";
        goto L9
    L13:
        r13 = "周三";
        goto L9
    L14:
        r13 = "周二";
        goto L9
    L15:
        r13 = "周一";
        goto L9
    L17:
        if (r11.size() != 7) goto L20;
        return "每天";
    L20:
        return 27599 + kotlin.collections.b0.h0(r11, "、", null, null, 0, null, null, 62, null);
    }

    private final String convertTimeToDesc(int r10, int r11) {
        if (r10 < 0) goto L6;
        if (r10 >= 5) goto L6;
        String r12 = "凌晨";
    L19:
        if (r10 <= 12) goto L22;
        r10 = r10 - 12;
    L22:
        if (r11 != 0) goto L25;
        return r12 + r10 + 28857;
    L25:
        return r12 + r10 + 28857 + r11 + 20998;
    L6:
        if (5 > r10) goto L9;
        if (r10 >= 12) goto L9;
        r12 = "上午";
    L9:
        if (r10 != 12) goto L12;
        r12 = "中午";
        goto L19
    L12:
        if (13 > r10) goto L15;
        if (r10 >= 20) goto L15;
        r12 = "下午";
    L15:
        if (20 > r10) goto L27;
        if (r10 >= 24) goto L27;
        r12 = "晚上";
    L27:
        throw new IllegalArgumentException("小时必须在0到23之间");
    }

    private final String getTodayOrTomorrow(String r10, int r11, int r12) {
        Date r13 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(r10 + TokenParser.SP + r11 + ':' + r12);
        Calendar r14 = Calendar.getInstance();
        r14.setTime(r13);
        Calendar r15 = Calendar.getInstance();
        Calendar r16 = Calendar.getInstance();
        r16.add(6, 1);
        Calendar r17 = Calendar.getInstance();
        r17.add(6, 2);
        kotlin.jvm.internal.q.f(r14, "calendar");
        kotlin.jvm.internal.q.f(r15, "todayCalendar");
        if (isSameDay(r14, r15) == false) goto L5;
        return "今天";
    L5:
        kotlin.jvm.internal.q.f(r16, "tomorrowCalendar");
        if (isSameDay(r14, r16) == false) goto L8;
        return "明天";
    L8:
        kotlin.jvm.internal.q.f(r17, "dayAfterTomorrowCalendar");
        if (isSameDay(r14, r17) == false) goto L11;
        return "后天";
    L11:
        StringBuilder r18 = new StringBuilder();
        r18.append(r14.get(2) + 1);
        r18.append(26376);
        r18.append(r14.get(5));
        r18.append(26085);
        return r18.toString();
    }

    private final boolean isSameDay(Calendar r10, Calendar r11) {
        if (r10.get(1) == r11.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r10.get(6) != r11.get(6)) goto L7;
        return true;
    }

    @NotNull
    public final String genClockTimeDesc(@NotNull AlarmEntity r10) {
        kotlin.jvm.internal.q.g(r10, BatteryTypeInf.BATTERY_ALARM);
        int r11 = Integer.parseInt(StringsKt__StringsKt.y0(r10.getStartTime(), ":", null, 2, null));
        int r12 = Integer.parseInt(StringsKt__StringsKt.u0(r10.getStartTime(), ":", null, 2, null));
        StringBuilder r13 = new StringBuilder();
        List<Integer> r14 = r10.getRepeatDayOfWeek();
        if (r14 != null) goto L5;
    L9:
        String r15 = r10.getDate();
        kotlin.jvm.internal.q.d(r15);
        String r16 = getTodayOrTomorrow(r15, r11, r12);
    L8:
        r13.append(r16);
        r13.append(convertTimeToDesc(r11, r12));
        String r17 = r13.toString();
        kotlin.jvm.internal.q.f(r17, "sb.toString()");
        return r17;
    L5:
        if (r14.isEmpty() == true) goto L9;
        List<Integer> r18 = r10.getRepeatDayOfWeek();
        kotlin.jvm.internal.q.d(r18);
        r16 = convertDaysOfWeekToDesc(r18);
        goto L8
    }
}
