package c7c;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.time.format.common.TimezoneUtil;
import com.ss.android.lark.time.format.common.d;
import com.ss.android.lark.time.format.common.e;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22689a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22690a = null;

        static {
            int[] r100 = new int[LengthType.values().length];
            r100[LengthType.MIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LengthType.SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LengthType.LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f22690a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(Context r110, Date r111, c7c.a r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "date");
        c7c.a r113 = d.a(r112);
        int r100 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r101 = com.ss.android.lark.time.format.common.a.a(r110, r113.f22688l);
        TimeZone r102 = d.b(r113.f22677a);
        if (r113.f22678b != DisplayPattern.RELATIVE) goto L6;
        int r114 = d7c.a.f467368a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "date");
        Intrinsics.checkNotNullParameter(r113, "opt");
        Intrinsics.checkNotNullParameter(r102, "timezone");
        GregorianCalendar r103 = new GregorianCalendar(r102);
        r103.setTime(r111);
        return d7c.a.b(r101, r111, r102, r103, new GregorianCalendar(r102), r113.f22686j, r113.f22688l);
    L6:
        return d7c.a.a(r101, r111, r113, r102);
    }

    @JvmStatic
    public static final String c(Context r100, Date r110, c7c.a r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "date");
        c7c.a r112 = d.a(r111);
        int r101 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r102 = com.ss.android.lark.time.format.common.a.a(r100, r112.f22688l);
        r112.a(DatePreciseness.DAY);
        HashMap r103 = new HashMap();
        String r104 = UIUtils.getString(r102, R.string.Calendar_StandardTime_RelativeDateTimeCombineFormat);
        if (r112.f22678b != DisplayPattern.ABSOLUTE) goto L6;
        r103.put("relativeDate", a(r102, r110, r112));
        r103.put("time", i(r102, r110, r112));
        return UIHelper.mustacheFormat(r104, r103);
    L6:
        TimeZone r105 = d.b(r112.f22677a);
        GregorianCalendar r106 = new GregorianCalendar(r105);
        r106.setTime(r110);
        GregorianCalendar r107 = new GregorianCalendar(r105);
        if (e.c(r106, r107) == false) goto L11;
        return d7c.b.e(r102, r106, false, r112);
    L11:
        if (r112.f22679c != LengthType.LONG) goto L13;
        r103.put("relativeDate", a(r102, r110, r112));
        r103.put("time", i(r102, r110, r112));
        String r108 = UIHelper.mustacheFormat(r104, r103);
        Intrinsics.checkNotNull(r108);
        return r108;
    L13:
        int r109 = d7c.a.f467368a;
        return d7c.a.b(r102, r110, r105, r106, r107, r112.f22686j, r112.f22688l);
    }

    @JvmStatic
    public static final String e(Context r210, Date r211, c7c.a r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "date");
        c7c.a r100 = d.a(r212);
        int r101 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r102 = com.ss.android.lark.time.format.common.a.a(r210, r100.f22688l);
        TimeZone r103 = d.b(r100.f22677a);
        if (r100.f22678b != DisplayPattern.RELATIVE) goto L5;
        int r104 = d7c.a.f467368a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "date");
        Intrinsics.checkNotNullParameter(r100, "opt");
        Intrinsics.checkNotNullParameter(r103, "timezone");
        GregorianCalendar r105 = new GregorianCalendar(r103);
        r105.setTime(r211);
        GregorianCalendar r110 = new GregorianCalendar(r103);
        return d7c.a.c(r102, r103, !e.d(r105, r110), r105, r110, r100.f22686j, r100.f22688l);
    L5:
        int r106 = d7c.a.f467368a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "date");
        Intrinsics.checkNotNullParameter(r100, "opt");
        Intrinsics.checkNotNullParameter(r103, "timezone");
        String r107 = d7c.a.a(r102, r211, new c7c.a(r103.getID(), null, r100.f22679c, DatePreciseness.DAY, r100.f22686j, r100.f22688l, 1522), r103);
        String r108 = l(r102, r211, new c7c.a(r103.getID(), null, LengthType.SHORT, null, false, r100.f22688l, 2042));
        HashMap r109 = new HashMap();
        r109.put("date", r107);
        r109.put("relativeDay", r108);
        return UIHelper.mustacheFormat(UIUtils.getString(r102, R.string.Calendar_StandardTime_DateRelativeDayCombineFormat), r109);
    }

    @JvmStatic
    public static final String f(Context r100, Date r101, c7c.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        c7c.a r103 = d.a(r102);
        int r104 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r105 = com.ss.android.lark.time.format.common.a.a(r100, r103.f22688l);
        r103.a(DatePreciseness.DAY);
        HashMap r106 = new HashMap();
        r106.put("relativeDate", e(r105, r101, r103));
        r106.put("time", i(r105, r101, r103));
        String r107 = UIHelper.mustacheFormat(UIUtils.getString(r105, R.string.Calendar_StandardTime_RelativeDateTimeCombineFormat), r106);
        if (r103.f22683g == false) goto L5;
        Intrinsics.checkNotNull(r107);
        return k(r105, r107, r103, r101);
    L5:
        Intrinsics.checkNotNull(r107);
        return r107;
    }

    @JvmStatic
    public static final String g(Context r100, Date r101, c7c.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        c7c.a r103 = d.a(r102);
        int r104 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r105 = com.ss.android.lark.time.format.common.a.a(r100, r103.f22688l);
        int r106 = com.ss.android.lark.time.format.common.b.f441322a;
        return com.ss.android.lark.time.format.common.b.b(r101, d.b(r103.f22677a), UIUtils.getString(r105, R.string.Calendar_StandardTime_MeridiemFormat), r103.f22686j, r103.f22688l);
    }

    @JvmStatic
    public static final String h(Context r100, Date r101, c7c.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        c7c.a r103 = d.a(r102);
        int r104 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r105 = com.ss.android.lark.time.format.common.a.a(r100, r103.f22688l);
        GregorianCalendar r106 = new GregorianCalendar(d.b(r103.f22677a));
        r106.setTime(r101);
        LengthType r107 = r103.f22679c;
        int r108 = a.f22690a[r107.ordinal()];
        if (r108 != 2) goto L5;
        String[] r109 = UIUtils.getStringArray(r105, R.array.month_short);
    L9:
        if (r109 != null) goto L11;
    L15:
        Log.e("TimeFormatUtils", "formatMonth monthArray is illegal!");
        return "";
    L11:
        if (r109.length < 12) goto L15;
        return r109[r106.get(2)];
    L5:
        if (r108 == 3) goto L7;
        Log.e("TimeFormatUtils", "formatMonth lengthType cannot support min");
        r109 = UIUtils.getStringArray(r105, R.array.month_long);
        goto L9
    L7:
        r109 = UIUtils.getStringArray(r105, R.array.month_long);
        goto L9
    }

    @JvmStatic
    public static final String i(Context r100, Date r101, c7c.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        c7c.a r103 = d.a(r102);
        int r104 = com.ss.android.lark.time.format.common.a.f441321a;
        return d7c.b.d(com.ss.android.lark.time.format.common.a.a(r100, r103.f22688l), r101, false, r103);
    }

    @JvmStatic
    public static final String l(Context r100, Date r101, c7c.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        c7c.a r103 = d.a(r102);
        int r104 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r105 = com.ss.android.lark.time.format.common.a.a(r100, r103.f22688l);
        GregorianCalendar r106 = new GregorianCalendar(d.b(r103.f22677a));
        r106.setTime(r101);
        LengthType r107 = r103.f22679c;
        int r108 = a.f22690a[r107.ordinal()];
        if (r108 != 1) goto L5;
        String[] r109 = UIUtils.getStringArray(r105, R.array.week_min);
    L13:
        if (r109 != null) goto L15;
    L19:
        Log.e("TimeFormatUtils", "formatWeekDay weekArray is illegal!");
        return "";
    L15:
        if (r109.length < 7) goto L19;
        return r109[r106.get(7) - 1];
    L5:
        if (r108 != 2) goto L7;
        r109 = UIUtils.getStringArray(r105, R.array.week_short);
        goto L13
    L7:
        if (r108 != 3) goto L10;
        r109 = UIUtils.getStringArray(r105, R.array.week_long);
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final String b(Context r100, Date r101, Date r102, c7c.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276369s);
        Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.f276370t);
        c7c.a r104 = d.a(r103);
        int r105 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r106 = com.ss.android.lark.time.format.common.a.a(r100, r104.f22688l);
        r104.b(DisplayPattern.ABSOLUTE);
        HashMap r107 = new HashMap();
        GregorianCalendar r108 = new GregorianCalendar(d.b(r104.f22677a));
        r108.setTime(r101);
        GregorianCalendar r109 = new GregorianCalendar(d.b(r104.f22677a));
        r109.setTime(r102);
        if (e.c(r108, r109) == false) goto L7;
        return a(r106, r101, r104);
    L7:
        if (r104.f22679c == LengthType.SHORT) goto L9;
    L11:
        r107.put(DyPayConstant.KEY_START_TIME, a(r106, r101, r104));
        r107.put("endTime", a(r106, r102, r104));
        return UIHelper.mustacheFormat(UIUtils.getString(r106, R.string.Calendar_StandardTime_GeneralDateTimeRangeWithoutWrap), r107);
    L9:
        if (e.d(r108, r109) == true) goto L11;
        r104.c(LengthType.LONG);
        goto L11
    }

    @JvmStatic
    public static final String d(Context r210, Date r211, Date r212, c7c.a r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, com.heytap.mcssdk.constant.b.f276369s);
        Intrinsics.checkNotNullParameter(r212, com.heytap.mcssdk.constant.b.f276370t);
        c7c.a r100 = d.a(r213);
        int r101 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r102 = com.ss.android.lark.time.format.common.a.a(r210, r100.f22688l);
        GregorianCalendar r110 = new GregorianCalendar(d.b(r100.f22677a));
        r110.setTime(r211);
        GregorianCalendar r111 = new GregorianCalendar(d.b(r100.f22677a));
        r111.setTime(r212);
        r100.a(DatePreciseness.DAY);
        if (e.c(r110, r111) == false) goto L5;
        Context r103 = com.ss.android.lark.time.format.common.a.a(r102, r100.f22688l);
        HashMap r104 = new HashMap();
        r104.put("relativeDate", e(r103, r211, r100));
        r104.put("time", j(r103, r211, r212, r100));
        return UIHelper.mustacheFormat(UIUtils.getString(r103, R.string.Calendar_StandardTime_RelativeDateTimeCombineFormat), r104);
    L5:
        Context r112 = com.ss.android.lark.time.format.common.a.a(r102, r100.f22688l);
        String r105 = i(r112, r211, r100);
        String r106 = i(r112, r212, r100);
        Object r107 = r105;
        Object r108 = r106;
        if (r100.f22683g == false) goto L9;
        Pair r109 = d7c.b.a(r105, r106, r102, r100, r211, r212);
        Object r113 = r109.getFirst();
        r108 = r109.getSecond();
        r107 = r113;
    L9:
        if (r100.f22678b == DisplayPattern.ABSOLUTE) goto L11;
        TimeZone r114 = d.b(r100.f22677a);
        GregorianCalendar r115 = new GregorianCalendar(r114);
        if (e.d(r110, r115) == true) goto L19;
    L22:
        boolean r116 = true;
    L23:
        int r117 = d7c.a.f467368a;
        Context r118 = r112;
        boolean r119 = r116;
        String r120 = d7c.a.c(r112, r114, r119, r110, r115, r100.f22686j, r100.f22688l);
        boolean r121 = r116;
        String r122 = d7c.a.c(r118, r114, r121, r111, r115, r100.f22686j, r100.f22688l);
        String r123 = r120;
    L24:
        HashMap r124 = new HashMap();
        HashMap r125 = new HashMap();
        r125.put(r11, r123);
        r125.put("time", (String) r107);
        r124.put(DyPayConstant.KEY_START_TIME, UIHelper.mustacheFormat(UIUtils.getString(r118, R.string.Calendar_StandardTime_RelativeDateTimeCombineFormat), r125));
        HashMap r126 = new HashMap();
        r126.put("relativeDate", r122);
        r126.put("time", (String) r108);
        r124.put("endTime", UIHelper.mustacheFormat(UIUtils.getString(r118, R.string.Calendar_StandardTime_RelativeDateTimeCombineFormat), r126));
        return UIHelper.mustacheFormat(UIUtils.getString(r118, R.string.Calendar_StandardTime_GeneralDateTimeRangeWithoutWrap), r124);
    L19:
        if (e.d(r111, r115) == false) goto L22;
        r116 = false;
        goto L23
    L11:
        if (r100.f22679c == LengthType.SHORT) goto L13;
    L15:
        r123 = e(r112, r211, r100);
        r122 = e(r112, r212, r100);
        r118 = r112;
        goto L24
    L13:
        if (e.d(r110, r111) == true) goto L15;
        r100.c(LengthType.LONG);
        goto L15
    }

    @JvmStatic
    public static final String j(Context r110, Date r111, Date r112, c7c.a r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, com.heytap.mcssdk.constant.b.f276369s);
        Intrinsics.checkNotNullParameter(r112, com.heytap.mcssdk.constant.b.f276370t);
        c7c.a r100 = d.a(r113);
        int r114 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r115 = com.ss.android.lark.time.format.common.a.a(r110, r100.f22688l);
        GregorianCalendar r116 = new GregorianCalendar(d.b(r100.f22677a));
        r116.setTime(r111);
        GregorianCalendar r101 = new GregorianCalendar(d.b(r100.f22677a));
        r101.setTime(r112);
        boolean r102 = true;
        boolean r103 = false;
        if (r100.f22687k == true) goto L5;
    L11:
        boolean r104 = false;
    L13:
        if (e.c(r116, r101) == false) goto L40;
        Intrinsics.checkNotNullParameter(r116, "firstGC");
        Intrinsics.checkNotNullParameter(r101, "secondGC");
        if (r116.get(9) != r101.get(9)) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L40;
        if (r100.f22684h == false) goto L40;
        int r117 = d7c.b.f467370a;
        Intrinsics.checkNotNullParameter(r115, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, com.heytap.mcssdk.constant.b.f276369s);
        Intrinsics.checkNotNullParameter(r112, com.heytap.mcssdk.constant.b.f276370t);
        Intrinsics.checkNotNullParameter(r100, "opt");
        HashMap r118 = new HashMap();
        TimeZone r106 = d.b(r100.f22677a);
        if (r106.getOffset(r111.getTime()) != r106.getOffset(r112.getTime())) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == true) goto L28;
    L30:
        r102 = false;
    L31:
        String r108 = d7c.b.d(r115, r111, r102, r100);
        if (r107 == false) goto L35;
        r103 = TimezoneUtil.a(r115);
    L35:
        String r109 = d7c.b.d(r115, r112, r103, r100);
        Object r119 = r108;
        Object r120 = r109;
        if (r100.f22683g == false) goto L38;
        Pair r121 = d7c.b.a(r108, r109, r115, r100, r111, r112);
        Object r122 = r121.getFirst();
        r119 = r122;
        r120 = r121.getSecond();
    L38:
        r118.put(DyPayConstant.KEY_START_TIME, r119);
        r118.put("endTime", r120);
        return UIHelper.mustacheFormat(UIUtils.getString(r115, R.string.Calendar_StandardTime_GeneralDateTimeRangeWithoutWrap), r118);
    L28:
        if (TimezoneUtil.a(r115) == true) goto L30;
    L24:
        r107 = false;
        goto L25
    L17:
        r105 = false;
    L40:
        if (e.c(r116, r101) == true) goto L47;
        if (r104 == false) goto L45;
        return d7c.b.c(r115, r111, r112, r100);
    L45:
        return d(r115, r111, r112, r100);
    L47:
        return d7c.b.c(r115, r111, r112, r100);
    L5:
        if (e.a(r101, r116) != 1) goto L11;
        if (r101.get(11) != 0) goto L11;
        if (r101.get(12) != 0) goto L11;
        r104 = true;
        goto L13
    }

    public static String k(Context r110, String r111, c7c.a r112, Date r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "dateTimeString");
        Intrinsics.checkNotNullParameter(r112, "opt");
        Intrinsics.checkNotNullParameter(r113, "date");
        int r100 = com.ss.android.lark.time.format.common.a.f441321a;
        Context r114 = com.ss.android.lark.time.format.common.a.a(r110, r112.f22688l);
        HashMap r101 = new HashMap();
        r101.put("timeString", r111);
        Lazy r115 = TimezoneUtil.f441320a;
        int r116 = d.f441324a;
        TimeZone r117 = d.b(r112.f22677a);
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r117, "timezone");
        Intrinsics.checkNotNullParameter(r113, "date");
        SimpleDateFormat r118 = new SimpleDateFormat(UIUtils.getString(r114, R.string.Calendar_StandardTime_GMTFormatForAndroid), Locale.CHINA);
        r118.setTimeZone(r117);
        int r119 = com.ss.android.lark.time.format.common.b.f441322a;
        Intrinsics.checkNotNullParameter(r118, "sdf");
        Intrinsics.checkNotNullParameter(r113, "date");
        String r120 = r118.format(r113);     // Catch: Exception -> L5
    L7:
        if (StringsKt.contains$default(r120, Marker.ANY_NON_NULL_MARKER, false, 2, null) == false) goto L10;
        int r121 = StringsKt.indexOf$default(r120, '+', 0, false, 6, null);
    L13:
        int r102 = StringsKt.indexOf$default(r120, ':', 0, false, 6, null);
        if (r102 == (-1)) goto L20;
        int r103 = r102 + 1;
        if (r103 >= r120.length()) goto L20;
        if (r120.charAt(r103) != '0') goto L20;
        r120 = r120.substring(0, r102);
    L20:
        StringBuilder r122 = new StringBuilder(r120);
        if (r121 == (-1)) goto L27;
        int r123 = r121 + 1;
        if (r123 >= r120.length()) goto L27;
        if (r122.charAt(r123) != '0') goto L27;
        r122.deleteCharAt(r123);
    L27:
        r101.put("GMT", r122.toString());
        return UIHelper.mustacheFormat(UIUtils.getString(r114, R.string.Calendar_StandardTime_TimeStringWithGMT), r101);
    L10:
        if (StringsKt.contains$default(r120, "-", false, 2, null) == false) goto L12;
        r121 = StringsKt.indexOf$default(r120, '-', 0, false, 6, null);
        goto L13
    L12:
        r121 = -1;
    L5:
        Log.e("FormatUtil", "format error!");
        r120 = "";
        goto L7
    }
}
