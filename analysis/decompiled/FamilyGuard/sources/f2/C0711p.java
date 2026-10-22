package f2;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.stepos.familyguard.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.function.Supplier;

/* renamed from: f2.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0711p {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f16793a = ThreadLocal.withInitial(new Supplier() { // from class: f2.o
        @Override // java.util.function.Supplier
        public final Object get() {
            return C0711p.a();
        }
    });

    public static int A(Context context, long j5) {
        if (context == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j5));
        calendar.setTimeZone(TimeZone.getDefault());
        return calendar.get(7);
    }

    public static int B(long j5) {
        long jK = k(j5);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        calendar.setTimeInMillis(jK);
        return calendar.get(7) - 1;
    }

    public static String C(Context context, long j5) {
        if (context == null) {
            return null;
        }
        switch (A(context, j5)) {
        }
        return null;
    }

    public static int D(long j5) {
        Date date = new Date(j5);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static boolean E(Context context) {
        if (context == null) {
            return true;
        }
        return DateFormat.is24HourFormat(context);
    }

    public static String F(long j5) {
        Application applicationA = P1.a.a();
        String string = DateFormat.is24HourFormat(applicationA) ? applicationA.getString(R.string.time_format_24) : applicationA.getString(R.string.time_format_12);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        simpleDateFormat.setTimeZone(timeZone);
        String str = simpleDateFormat.format(new Date(j5));
        if (j5 < 86400000) {
            return str;
        }
        return "+" + str;
    }

    public static /* synthetic */ SimpleDateFormat a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static long b(String str) throws ParseException {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            Date date = simpleDateFormat.parse(str);
            Objects.requireNonNull(date);
            return date.getTime();
        } catch (ParseException e6) {
            e6.printStackTrace();
            return -1L;
        }
    }

    public static String c(Context context, int i5) {
        if (context == null) {
            return null;
        }
        String strD = d(context, i5);
        String strD2 = d(context, i5 + 1);
        return strD + context.getString(R.string.us_to) + strD2;
    }

    public static String d(Context context, int i5) {
        return e(context, i5, false);
    }

    public static String e(Context context, int i5, boolean z5) {
        if (context == null) {
            return null;
        }
        Date date = new Date();
        date.setHours(i5);
        return new SimpleDateFormat(z5 ? context.getString(R.string.us_n_clock_24) : E(context) ? context.getString(R.string.us_n_clock_24_H) : context.getString(R.string.us_n_clock_12_H), context.getResources().getConfiguration().locale).format(date);
    }

    public static long f() {
        return g(y());
    }

    public static long g(long j5) {
        int iB = B(j5);
        if (iB < 0 || iB > 6) {
            throw new IllegalStateException("错误的状态 星期信息错误");
        }
        if (iB == 0) {
            iB = 7;
        }
        return k(j5) - ((iB - 1) * 86400000);
    }

    public static String h(long j5, boolean z5) {
        if (!z5) {
            return Long.toString(j5);
        }
        return "\"" + f16793a.get().format(Long.valueOf(j5)) + "\"";
    }

    public static String i(Context context, long j5) {
        if (context == null) {
            return null;
        }
        return DateUtils.formatDateTime(context, j5, 524304);
    }

    public static String j(long j5) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return j5 + ":" + simpleDateFormat.format(Long.valueOf(j5));
    }

    public static long k(long j5) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j5);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long l(long j5) {
        if (j5 > 0 && j5 < 1000) {
            j5 = 1000;
        }
        long j6 = j5 % 1000;
        if (j6 >= 500) {
            j5 += 1000 - j6;
        }
        if (j5 <= 60000) {
            return j5;
        }
        if (j5 % 60000 >= 30000) {
            j5 += 60000;
        }
        return j5 - (j5 % 60000);
    }

    public static String m(Context context, long j5) {
        return o(context, j5, false, true);
    }

    public static String n(Context context, long j5, boolean z5) {
        return o(context, j5, z5, true);
    }

    public static String o(Context context, long j5, boolean z5, boolean z6) {
        if (context == null) {
            return null;
        }
        long jL = l(j5);
        Resources resources = context.getResources();
        int i5 = (int) (jL / 3600000);
        int i6 = (int) ((jL % 3600000) / 60000);
        String strValueOf = String.valueOf(i5);
        String strValueOf2 = String.valueOf(i6);
        String strValueOf3 = String.valueOf((int) ((jL % 60000) / 1000));
        if (z5) {
            strValueOf = " " + strValueOf + " ";
            strValueOf2 = " " + strValueOf2 + " ";
            strValueOf3 = " " + strValueOf3 + " ";
        }
        StringBuilder sb = new StringBuilder();
        if (i5 > 0) {
            if (z6) {
                sb.append(strValueOf);
                sb.append(resources.getString(R.string.us_hour));
            } else {
                sb.append(strValueOf);
                sb.append(resources.getQuantityString(R.plurals.us_widget_hour, i5));
            }
        }
        if (i6 > 0) {
            if (i5 <= 0 || !z6) {
                sb.append(strValueOf2);
                sb.append(resources.getQuantityString(R.plurals.us_widget_minute, i6));
            } else {
                sb.append(strValueOf2);
                sb.append(resources.getString(R.string.us_minute_s));
            }
        } else if (i5 <= 0) {
            sb.append(strValueOf3);
            sb.append(resources.getString(R.string.us_second));
        }
        return sb.toString();
    }

    public static int p(long j5) {
        return (int) Math.ceil((j5 - k(j5)) / 3600000.0f);
    }

    public static int q(long j5) {
        return (int) (j5 / 3600000);
    }

    public static int r(long j5) {
        return (int) ((j5 % 3600000) / 60000);
    }

    public static int s() {
        return p(System.currentTimeMillis());
    }

    public static String t(long j5) {
        return "<" + j5 + " : " + ((int) (j5 / 3600000)) + "h " + ((int) ((j5 % 3600000) / 60000)) + "m " + ((int) ((j5 % 60000) / 1000)) + "s " + ((int) (j5 % 1000)) + "ms>";
    }

    public static String u(Context context, long j5) {
        long jK = k(j5);
        return jK == y() ? context.getString(R.string.us_today) : jK == y() - 86400000 ? context.getString(R.string.mc_pattern_yesterday) : context.getString(R.string.us_week_total, C(context, j5));
    }

    public static String v(Context context, long j5) {
        return j5 >= y() ? context.getString(R.string.us_today) : N1.b.a(context, j5, 6);
    }

    public static int w(long j5) {
        return (int) ((j5 % 60000) / 1000);
    }

    public static long x() {
        return y() + 86399999;
    }

    public static long y() {
        return k(System.currentTimeMillis());
    }

    public static long z(long j5) {
        long jL = l(j5);
        if (jL >= 60000 || jL <= 0) {
            return jL / 60000;
        }
        return 1L;
    }
}
