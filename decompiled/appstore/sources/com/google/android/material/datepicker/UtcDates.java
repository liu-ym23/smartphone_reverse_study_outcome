package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef;

    static {
        timeSourceRef = new AtomicReference();
    }

    private UtcDates() {
    }

    public static long canonicalYearMonthDay(long r10) {
        Calendar r11 = getUtcCalendar();
        r11.setTimeInMillis(r10);
        return getDayCopy(r11).getTimeInMillis();
    }

    private static int findCharactersInDateFormatPattern(@NonNull String r10, @NonNull String r11, int r12, int r13) {
    L2:
        if (r13 < 0) goto L17;
        if (r13 >= r10.length()) goto L17;
        if (r11.indexOf(r10.charAt(r13)) != (-1)) goto L17;
        if (r10.charAt(r13) != '\'') goto L16;
    L9:
        r13 = r13 + r12;
        if (r13 < 0) goto L16;
        if (r13 >= r10.length()) goto L16;
        if (r10.charAt(r13) != '\'') goto L9;
    L16:
        r13 = r13 + r12;
    L17:
        return r13;
    }

    @TargetApi(24)
    public static DateFormat getAbbrMonthDayFormat(Locale r10) {
        return getAndroidFormat("MMMd", r10);
    }

    @TargetApi(24)
    public static DateFormat getAbbrMonthWeekdayDayFormat(Locale r10) {
        return getAndroidFormat("MMMEd", r10);
    }

    @TargetApi(24)
    private static DateFormat getAndroidFormat(String r10, Locale r11) {
        DateFormat r12 = DateFormat.getInstanceForSkeleton(r10, r11);
        r12.setTimeZone(getUtcAndroidTimeZone());
        return r12;
    }

    public static Calendar getDayCopy(Calendar r10) {
        Calendar r11 = getUtcCalendarOf(r10);
        Calendar r12 = getUtcCalendar();
        r12.set(r11.get(1), r11.get(2), r11.get(5));
        return r12;
    }

    private static java.text.DateFormat getFormat(int r10, Locale r11) {
        java.text.DateFormat r12 = java.text.DateFormat.getDateInstance(r10, r11);
        r12.setTimeZone(getTimeZone());
        return r12;
    }

    public static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    public static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    public static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    public static SimpleDateFormat getSimpleFormat(String r10) {
        return getSimpleFormat(r10, Locale.getDefault());
    }

    public static SimpleDateFormat getTextInputFormat() {
        SimpleDateFormat r10 = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        r10.setTimeZone(getTimeZone());
        r10.setLenient(false);
        return r10;
    }

    public static String getTextInputHint(Resources r10, SimpleDateFormat r11) {
        String r12 = r11.toLocalizedPattern();
        String r13 = r10.getString(R.string.mtrl_picker_text_input_year_abbr);
        String r14 = r10.getString(R.string.mtrl_picker_text_input_month_abbr);
        return r12.replaceAll("d", r10.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", r14).replaceAll(FixCard.FixStyle.KEY_Y, r13);
    }

    public static TimeSource getTimeSource() {
        TimeSource r10 = timeSourceRef.get();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return TimeSource.system();
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    public static Calendar getTodayCalendar() {
        Calendar r10 = getTimeSource().now();
        r10.set(11, 0);
        r10.set(12, 0);
        r10.set(13, 0);
        r10.set(14, 0);
        r10.setTimeZone(getTimeZone());
        return r10;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    public static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    public static Calendar getUtcCalendarOf(@Nullable Calendar r10) {
        Calendar r11 = Calendar.getInstance(getTimeZone());
        if (r10 != null) goto L5;
        r11.clear();
    L6:
        return r11;
    L5:
        r11.setTimeInMillis(r10.getTimeInMillis());
        goto L6
    }

    @TargetApi(24)
    public static DateFormat getYearAbbrMonthDayFormat(Locale r10) {
        return getAndroidFormat("yMMMd", r10);
    }

    @TargetApi(24)
    public static DateFormat getYearAbbrMonthWeekdayDayFormat(Locale r10) {
        return getAndroidFormat("yMMMEd", r10);
    }

    @NonNull
    private static String removeYearFromDateFormatPattern(@NonNull String r10) {
        int r11 = findCharactersInDateFormatPattern(r10, "yY", 1, 0);
        if (r11 < r10.length()) goto L5;
        return r10;
    L5:
        String r12 = "EMd";
        int r13 = findCharactersInDateFormatPattern(r10, "EMd", 1, r11);
        if (r13 >= r10.length()) goto L9;
        r12 = "EMd,";
    L9:
        return r10.replace(r10.substring(findCharactersInDateFormatPattern(r10, r12, -1, r11) + 1, r13), " ").trim();
    }

    public static void setTimeSource(@Nullable TimeSource r10) {
        timeSourceRef.set(r10);
    }

    public static java.text.DateFormat getFullFormat(Locale r10) {
        return getFormat(0, r10);
    }

    public static java.text.DateFormat getMediumFormat(Locale r10) {
        return getFormat(2, r10);
    }

    public static java.text.DateFormat getMediumNoYear(Locale r10) {
        SimpleDateFormat r11 = (SimpleDateFormat) getMediumFormat(r10);
        r11.applyPattern(removeYearFromDateFormatPattern(r11.toPattern()));
        return r11;
    }

    private static SimpleDateFormat getSimpleFormat(String r10, Locale r11) {
        SimpleDateFormat r12 = new SimpleDateFormat(r10, r11);
        r12.setTimeZone(getTimeZone());
        return r12;
    }
}
