package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static void setExact(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setExact(r1, r2, r4);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void setAlarmClock(AlarmManager r0, Object r1, PendingIntent r2) {
            r0.setAlarmClock((AlarmManager.AlarmClockInfo) r1, r2);
        }

        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long r1, PendingIntent r3) {
            return new AlarmManager.AlarmClockInfo(r1, r3);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setAndAllowWhileIdle(r1, r2, r4);
        }

        static void setExactAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setExactAndAllowWhileIdle(r1, r2, r4);
        }
    }

    public static void setAlarmClock(AlarmManager r0, long r1, PendingIntent r3, PendingIntent r4) {
        Api21Impl.setAlarmClock(r0, Api21Impl.createAlarmClockInfo(r1, r3), r4);
    }

    public static void setAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
        Api23Impl.setAndAllowWhileIdle(r0, r1, r2, r4);
    }

    public static void setExact(AlarmManager r0, int r1, long r2, PendingIntent r4) {
        Api19Impl.setExact(r0, r1, r2, r4);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
        Api23Impl.setExactAndAllowWhileIdle(r0, r1, r2, r4);
    }

    private AlarmManagerCompat() {
    }
}
