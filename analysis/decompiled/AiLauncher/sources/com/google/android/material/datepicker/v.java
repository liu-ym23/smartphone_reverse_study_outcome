package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicReference<u> f20862a = new AtomicReference<>();

    public static long a(long j10) {
        Calendar calendarN = n();
        calendarN.setTimeInMillis(j10);
        return e(calendarN).getTimeInMillis();
    }

    @TargetApi(24)
    public static DateFormat b(Locale locale) {
        return c("MMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(m());
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    public static String d(String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    public static Calendar e(Calendar calendar) {
        Calendar calendarO = o(calendar);
        Calendar calendarN = n();
        calendarN.set(calendarO.get(1), calendarO.get(2), calendarO.get(5));
        return calendarN;
    }

    public static SimpleDateFormat f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(d(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(k());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String g(Resources resources, SimpleDateFormat simpleDateFormat) throws Resources.NotFoundException {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R$string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R$string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R$string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", Const.INTENT_KEY_UMID).replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace(Const.INTENT_KEY_UMID, string3).replace("M", string2).replace("y", string);
    }

    @TargetApi(24)
    public static DateFormat h(Locale locale) {
        return c("MMMMEEEEd", locale);
    }

    public static java.text.DateFormat i(java.text.DateFormat dateFormat) {
        java.text.DateFormat dateFormat2 = (java.text.DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(k());
        return dateFormat2;
    }

    public static u j() {
        u uVar = f20862a.get();
        return uVar == null ? u.c() : uVar;
    }

    public static TimeZone k() {
        return TimeZone.getTimeZone("UTC");
    }

    public static Calendar l() {
        Calendar calendarA = j().a();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        calendarA.setTimeZone(k());
        return calendarA;
    }

    @TargetApi(24)
    public static android.icu.util.TimeZone m() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar n() {
        return o(null);
    }

    public static Calendar o(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(k());
        if (calendar == null) {
            calendar2.clear();
            return calendar2;
        }
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        return calendar2;
    }

    @TargetApi(24)
    public static DateFormat p(Locale locale) {
        return c("yMMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat q(Locale locale) {
        return c("yMMMM", locale);
    }

    @TargetApi(24)
    public static DateFormat r(Locale locale) {
        return c("yMMMMEEEEd", locale);
    }
}
