package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.ReplaceWith;
import androidx.annotation.RequiresApi;

/* loaded from: classes2.dex */
public final class AlarmManagerCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static AlarmManager.AlarmClockInfo createAlarmClockInfo(long j5, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j5, pendingIntent);
        }

        public static void setAlarmClock(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j5, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i, j5, pendingIntent);
        }

        public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j5, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i, j5, pendingIntent);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
    }

    public static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
        return Api31Impl.canScheduleExactAlarms(alarmManager);
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(AlarmManager alarmManager, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(j5, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j5, PendingIntent pendingIntent) {
        Api23Impl.setAndAllowWhileIdle(alarmManager, i, j5, pendingIntent);
    }

    @ReplaceWith(expression = "alarmManager.setExact(type, triggerAtMillis, operation)")
    @Deprecated
    public static void setExact(AlarmManager alarmManager, int i, long j5, PendingIntent pendingIntent) {
        alarmManager.setExact(i, j5, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j5, PendingIntent pendingIntent) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager, i, j5, pendingIntent);
    }
}
