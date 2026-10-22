package f2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import com.stepos.digitalwellbeing.server.limit.TimeLimitApproachReceiver;
import com.stepos.digitalwellbeing.server.limit.data.room.RipePeriod;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0696a {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f16779a = Y1.l.f6423E;

    private static Intent a(long j5, long j6, long j7, long j8, long j9, int i5) {
        String strE = e(i5);
        Intent intent = new Intent(strE, null, P1.a.a(), TimeLimitApproachReceiver.class);
        C0702g.b("AlarmUtil", "createApproachIntent action = " + strE + " uri = " + g(j5, j6, j8, j7, j9));
        intent.setData(g(j5, j6, j8, j7, j9));
        intent.putExtra("category_id", j8);
        intent.putExtra("admin_id", j6);
        intent.putExtra("time", j7);
        intent.putExtra("limit_type", 1);
        intent.putExtra("ripe_period_id", j5);
        intent.setPackage("com.stepos.familyguard");
        return intent;
    }

    private static Intent b(long j5, long j6, long j7, String str, long j8, int i5) {
        String strE = e(i5);
        Intent intent = new Intent(strE, null, P1.a.a(), TimeLimitApproachReceiver.class);
        Uri uriH = h(j5, j6, str, j7, j8);
        C0702g.b("AlarmUtil", "createApproachIntent action = " + strE + " uri = " + uriH);
        intent.setData(uriH);
        intent.putExtra("packageName", str);
        intent.putExtra("admin_id", j6);
        intent.putExtra("time", j7);
        intent.putExtra("limit_type", 0);
        intent.putExtra("ripe_period_id", j5);
        intent.setPackage("com.stepos.familyguard");
        return intent;
    }

    private static Intent c(long j5, long j6, long j7, long j8, int i5) {
        String strE = e(i5);
        Intent intent = new Intent(strE, null, P1.a.a(), TimeLimitApproachReceiver.class);
        C0702g.b("AlarmUtil", "createApproachIntent action = " + strE + " uri = " + f(j5, j6, j7, j8));
        intent.setData(f(j5, j6, j7, j8));
        intent.putExtra("admin_id", j6);
        intent.putExtra("time", j7);
        intent.putExtra("limit_type", 2);
        intent.putExtra("ripe_period_id", j5);
        intent.setPackage("com.stepos.familyguard");
        return intent;
    }

    private static PendingIntent d(long j5, Intent intent) {
        return PendingIntent.getBroadcast(P1.a.a(), (int) j5, intent, 167772160);
    }

    private static String e(int i5) {
        return i5 == 2 ? "com.stepos.familyguard.DIGIT_WELLBEING_ALARM_NOTIFY" : i5 == 0 ? "com.stepos.familyguard.DIGIT_WELLBEING_ALARM_LOCK" : i5 == 1 ? "com.stepos.familyguard.DIGIT_WELLBEING_ALARM_UNLOCK" : "com.stepos.familyguard.DIGIT_WELLBEING_ALARM_NOTIFY_ONLY";
    }

    public static Uri f(long j5, long j6, long j7, long j8) {
        return ContentUris.appendId(new Uri.Builder().scheme("content").authority("com.stepos.familyguard").path("alarm").appendPath(String.valueOf(j6)).appendPath(String.valueOf(j8)).appendPath("global").appendPath(String.valueOf(j7)), j5).build();
    }

    public static Uri g(long j5, long j6, long j7, long j8, long j9) {
        return ContentUris.appendId(new Uri.Builder().scheme("content").authority("com.stepos.familyguard").path("alarm").appendPath(String.valueOf(j6)).appendPath(String.valueOf(j9)).appendPath(String.valueOf(j7)).appendPath(String.valueOf(j8)), j5).build();
    }

    public static Uri h(long j5, long j6, String str, long j7, long j8) {
        return ContentUris.appendId(new Uri.Builder().scheme("content").authority("com.stepos.familyguard").path("alarm").appendPath(String.valueOf(j6)).appendPath(String.valueOf(j8)).appendPath(str).appendPath(String.valueOf(j7)), j5).build();
    }

    public static long i(long j5, long j6, long j7, long j8, int i5) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "registerAlarm id = " + j5 + " time = " + C0711p.j(j7) + " adminId = " + j6 + " version = " + j8 + " type = " + i5);
        }
        return m(j5, c(j5, j6, j7, j8, i5));
    }

    public static long j(long j5, long j6, long j7, long j8, long j9, int i5) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "registerAlarm id = " + j5 + " time = " + C0711p.j(j7) + " adminId = " + j6 + " categoryId = " + j8 + " version = " + j9 + " type = " + i5);
        }
        return m(j5, a(j5, j6, j7, j8, j9, i5));
    }

    public static long k(long j5, long j6, long j7, String str, long j8, int i5) {
        R1.a.a("AlarmUtil", "registerAlarm id = " + j5 + " adminId = " + j6 + " time = " + C0711p.j(j7) + " packageName = " + str + " version = " + j8);
        return m(j5, b(j5, j6, j7, str, j8, i5));
    }

    public static long l(RipePeriod ripePeriod) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "registerAlarm periodLimit = " + ripePeriod);
        }
        return ripePeriod.getLimitType() == 1 ? j(ripePeriod.getId(), ripePeriod.getAdminId(), ripePeriod.getTime(), ripePeriod.getLimitCategoryId(), ripePeriod.getVersion(), ripePeriod.getType()) : ripePeriod.getLimitType() == 0 ? k(ripePeriod.getId(), ripePeriod.getAdminId(), ripePeriod.getTime(), ripePeriod.getLimitPackageName(), ripePeriod.getVersion(), ripePeriod.getType()) : i(ripePeriod.getId(), ripePeriod.getAdminId(), ripePeriod.getTime(), ripePeriod.getVersion(), ripePeriod.getType());
    }

    private static long m(long j5, Intent intent) {
        if (intent == null) {
            C0702g.p("AlarmUtil", "intent is null");
            return -1L;
        }
        long longExtra = intent.getLongExtra("time", 0L);
        PendingIntent pendingIntentD = d(j5, intent);
        long jY = longExtra + C0711p.y();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jY > C0711p.x()) {
            jY -= 86400000;
        }
        if (jY < jCurrentTimeMillis) {
            return -1L;
        }
        C0702g.b("AlarmUtil", "alarmTime = " + C0711p.j(jY));
        ((AlarmManager) P1.a.a().getSystemService("alarm")).setExactAndAllowWhileIdle(0, jY, pendingIntentD);
        return j5;
    }

    public static boolean n(long j5, long j6, long j7, long j8, int i5) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "unRegisterAlarm id = " + j5 + " time = " + j6 + " adminId = " + j7 + " version = " + j8 + " type = " + i5);
        }
        PendingIntent pendingIntentD = d(j5, c(j5, j7, j6, j8, i5));
        AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
        if (pendingIntentD == null) {
            return false;
        }
        alarmManager.cancel(pendingIntentD);
        return true;
    }

    public static boolean o(long j5, long j6, long j7, long j8, long j9, int i5) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "unRegisterAlarm id = " + j5 + " time = " + j6 + " adminId = " + j7 + " categoryId = " + j8 + " version = " + j9 + " type = " + i5);
        }
        PendingIntent pendingIntentD = d(j5, a(j5, j7, j6, j8, j9, i5));
        AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
        if (pendingIntentD == null) {
            return false;
        }
        alarmManager.cancel(pendingIntentD);
        return true;
    }

    public static boolean p(long j5, long j6, long j7, String str, long j8, int i5) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "unRegisterAlarm id = " + j5 + " time = " + j6 + " adminId = " + j7 + " packageName = " + str + " version = " + j8 + " type = " + i5);
        }
        PendingIntent pendingIntentD = d(j5, b(j5, j7, j6, str, j8, i5));
        AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
        if (pendingIntentD == null) {
            return true;
        }
        alarmManager.cancel(pendingIntentD);
        return false;
    }

    public static boolean q(RipePeriod ripePeriod) {
        if (f16779a) {
            R1.a.a("AlarmUtil", "unRegisterAlarm ripePeriod = " + ripePeriod);
        }
        return ripePeriod.getLimitType() == 0 ? p(ripePeriod.getId(), ripePeriod.getTime(), ripePeriod.getAdminId(), ripePeriod.getLimitPackageName(), ripePeriod.getVersion(), ripePeriod.getType()) : ripePeriod.getLimitType() == 1 ? o(ripePeriod.getId(), ripePeriod.getTime(), ripePeriod.getAdminId(), ripePeriod.getLimitCategoryId(), ripePeriod.getVersion(), ripePeriod.getType()) : n(ripePeriod.getId(), ripePeriod.getTime(), ripePeriod.getAdminId(), ripePeriod.getVersion(), ripePeriod.getType());
    }
}
