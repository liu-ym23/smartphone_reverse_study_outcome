package T1;

import android.content.Context;
import java.util.Calendar;

/* loaded from: classes.dex */
public class d {
    public static String a(Context context, long j5) {
        return System.currentTimeMillis() - j5 < 60000 ? context.getString(P1.c.f4546a) : N1.b.a(context, j5, 6).replace("hours", "h").replace("hour", "h").replace("minutes", "min").replace("minute", "min");
    }

    public static int b(long j5, boolean z5) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j5);
        if (z5) {
            int[] iArrE = N1.e.e(calendar.get(1), calendar.get(2) + 1, calendar.get(5), false);
            calendar.set(iArrE[0], iArrE[1] - 1, iArrE[2]);
        }
        Calendar calendar2 = Calendar.getInstance();
        int i5 = calendar2.get(1) - calendar.get(1);
        if (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) {
            i5--;
        }
        return Math.max(0, i5);
    }
}
