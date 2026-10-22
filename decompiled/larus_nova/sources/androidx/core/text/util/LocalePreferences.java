package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.number.UnlocalizedNumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
public final class LocalePreferences {
    private static final String TAG = null;
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES = null;

    /* JADX INFO: renamed from: androidx.core.text.util.LocalePreferences$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$icu$text$DateFormat$HourCycle = null;

        static {
            int[] r100 = new int[DateFormat.HourCycle.values().length];
            $SwitchMap$android$icu$text$DateFormat$HourCycle = r100;
            r100[DateFormat.HourCycle.HOUR_CYCLE_11.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat.HourCycle.HOUR_CYCLE_12.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat.HourCycle.HOUR_CYCLE_23.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat.HourCycle.HOUR_CYCLE_24.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class Api24Impl {
        public static Locale getDefaultLocale() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }

        private Api24Impl() {
        }

        public static String getCalendarType(Locale r100) {
            return Calendar.getInstance(r100).getType();
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static String getHourCycle(Locale r100) {
            return getHourCycleType(DateTimePatternGenerator.getInstance(r100).getDefaultHourCycle());
        }

        private static String getHourCycleType(DateFormat.HourCycle r100) {
            int r101 = AnonymousClass1.$SwitchMap$android$icu$text$DateFormat$HourCycle[r100.ordinal()];
            if (r101 != 1) goto L5;
            return HourCycle.H11;
        L5:
            if (r101 != 2) goto L7;
            return HourCycle.H12;
        L7:
            if (r101 != 3) goto L9;
            return HourCycle.H23;
        L9:
            if (r101 == 4) goto L12;
            return "";
        L12:
            return HourCycle.H24;
        }

        public static String getResolvedTemperatureUnit(Locale r100) {
            String r101 = ((UnlocalizedNumberFormatter) ((UnlocalizedNumberFormatter) NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale(r100).format(1).getOutputUnit().getIdentifier();
            if (r101.startsWith(TemperatureUnit.FAHRENHEIT) == false) goto L5;
            return TemperatureUnit.FAHRENHEIT;
        L5:
            return r101;
        }
    }

    public static class CalendarType {
        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";
        private static final String U_EXTENSION_TAG = "ca";

        @Retention(RetentionPolicy.SOURCE)
        public @interface CalendarTypes {
        }

        private CalendarType() {
        }
    }

    public static class FirstDayOfWeek {
        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        private static final String U_EXTENSION_TAG = "fw";
        public static final String WEDNESDAY = "wed";

        @Retention(RetentionPolicy.SOURCE)
        public @interface Days {
        }

        private FirstDayOfWeek() {
        }
    }

    public static class HourCycle {
        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";
        private static final String U_EXTENSION_TAG = "hc";

        @Retention(RetentionPolicy.SOURCE)
        public @interface HourCycleTypes {
        }

        private HourCycle() {
        }
    }

    public static class TemperatureUnit {
        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";
        private static final String U_EXTENSION_TAG = "mu";

        @Retention(RetentionPolicy.SOURCE)
        public @interface TemperatureUnits {
        }

        private TemperatureUnit() {
        }
    }

    public static String getCalendarType() {
        return getCalendarType(true);
    }

    public static String getFirstDayOfWeek() {
        return getFirstDayOfWeek(true);
    }

    public static String getHourCycle() {
        return getHourCycle(true);
    }

    public static String getTemperatureUnit() {
        return getTemperatureUnit(true);
    }

    static {
        TAG = "LocalePreferences";
        WEATHER_FAHRENHEIT_COUNTRIES = new String[]{"BS", "BZ", "KY", "PR", "PW", "US"};
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    private LocalePreferences() {
    }

    private static String getBaseFirstDayOfWeek(Locale r100) {
        return getStringOfFirstDayOfWeek(java.util.Calendar.getInstance(r100).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(Locale r100) {
        if (android.text.format.DateFormat.getBestDateTimePattern(r100, "jm").contains(FaceService.neutralLabel) == false) goto L5;
        return HourCycle.H23;
    L5:
        return HourCycle.H12;
    }

    public static String getCalendarType(boolean r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r101 = Api24Impl.getDefaultLocale();
    L7:
        return getCalendarType(r101, r100);
    L5:
        r101 = getDefaultLocale();
        goto L7
    }

    public static String getFirstDayOfWeek(boolean r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r101 = Api24Impl.getDefaultLocale();
    L7:
        return getFirstDayOfWeek(r101, r100);
    L5:
        r101 = getDefaultLocale();
        goto L7
    }

    public static String getHourCycle(boolean r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r101 = Api24Impl.getDefaultLocale();
    L7:
        return getHourCycle(r101, r100);
    L5:
        r101 = getDefaultLocale();
        goto L7
    }

    private static String getStringOfFirstDayOfWeek(int r100) {
        String[] r101 = {FirstDayOfWeek.SUNDAY, "mon", FirstDayOfWeek.TUESDAY, FirstDayOfWeek.WEDNESDAY, FirstDayOfWeek.THURSDAY, FirstDayOfWeek.FRIDAY, FirstDayOfWeek.SATURDAY};
        if (r100 >= 1) goto L5;
    L7:
        return "";
    L5:
        if (r100 > 7) goto L7;
        return r101[r100 - 1];
    }

    private static String getTemperatureHardCoded(Locale r100) {
        if (Arrays.binarySearch(WEATHER_FAHRENHEIT_COUNTRIES, r100.getCountry()) < 0) goto L5;
        return TemperatureUnit.FAHRENHEIT;
    L5:
        return TemperatureUnit.CELSIUS;
    }

    public static String getTemperatureUnit(boolean r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r101 = Api24Impl.getDefaultLocale();
    L7:
        return getTemperatureUnit(r101, r100);
    L5:
        r101 = getDefaultLocale();
        goto L7
    }

    public static String getCalendarType(Locale r100) {
        return getCalendarType(r100, true);
    }

    public static String getFirstDayOfWeek(Locale r100) {
        return getFirstDayOfWeek(r100, true);
    }

    public static String getHourCycle(Locale r100) {
        return getHourCycle(r100, true);
    }

    public static String getTemperatureUnit(Locale r100) {
        return getTemperatureUnit(r100, true);
    }

    public static String getCalendarType(Locale r100, boolean r101) {
        String r102 = getUnicodeLocaleType("ca", "", r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        if (r101 == false) goto L12;
        return CalendarType.GREGORIAN;
    L12:
        return "";
    L8:
        return Api24Impl.getCalendarType(r100);
    }

    public static String getFirstDayOfWeek(Locale r100, boolean r101) {
        String r102 = getUnicodeLocaleType("fw", "", r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return getBaseFirstDayOfWeek(r100);
    }

    public static String getHourCycle(Locale r100, boolean r101) {
        String r102 = getUnicodeLocaleType("hc", "", r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L10;
        return Api33Impl.getHourCycle(r100);
    L10:
        return getBaseHourCycle(r100);
    }

    public static String getTemperatureUnit(Locale r100, boolean r101) {
        String r102 = getUnicodeLocaleType("mu", "", r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L10;
        return Api33Impl.getResolvedTemperatureUnit(r100);
    L10:
        return getTemperatureHardCoded(r100);
    }

    private static String getUnicodeLocaleType(String r100, String r101, Locale r102, boolean r103) {
        String r104 = r102.getUnicodeLocaleType(r100);
        if (r104 == null) goto L5;
        return r104;
    L5:
        if (r103 == true) goto L7;
        return r101;
    L7:
        return null;
    }
}
