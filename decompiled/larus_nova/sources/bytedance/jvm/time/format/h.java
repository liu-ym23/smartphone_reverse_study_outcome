package bytedance.jvm.time.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes28.dex */
public final class h {
    public static String a(long r100, String r110, Locale r111) {
        TimeZone r101 = TimeZone.getTimeZone("UTC");
        SimpleDateFormat r102 = new SimpleDateFormat(r110, r111);
        r102.setTimeZone(r101);
        Calendar r112 = Calendar.getInstance();
        r112.setTimeZone(r101);
        r112.set(2016, 1, (int) r100, 0, 0, 0);
        return r102.format(r112.getTime());
    }

    public static String b(long r100, String r110, Locale r111) {
        TimeZone r101 = TimeZone.getTimeZone("UTC");
        SimpleDateFormat r102 = new SimpleDateFormat(r110, r111);
        r102.setTimeZone(r101);
        Calendar r112 = Calendar.getInstance();
        r112.setTimeZone(r101);
        r112.set(0, (int) r100, 0, 0, 0, 0);
        return r102.format(r112.getTime());
    }
}
