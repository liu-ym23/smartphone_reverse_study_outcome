package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class AlarmManagerCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static AlarmManager.AlarmClockInfo createAlarmClockInfo(long r100, PendingIntent r101) {
            return new AlarmManager.AlarmClockInfo(r100, r101);
        }

        public static void setAlarmClock(AlarmManager r100, Object r101, PendingIntent r102) {
            r100.setAlarmClock((AlarmManager.AlarmClockInfo) r101, r102);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void setAndAllowWhileIdle(AlarmManager r100, int r101, long r102, PendingIntent r103) {
            r100.setAndAllowWhileIdle(r101, r102, r103);
        }

        public static void setExactAndAllowWhileIdle(AlarmManager r100, int r101, long r102, PendingIntent r103) {
            r100.setExactAndAllowWhileIdle(r101, r102, r103);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static boolean canScheduleExactAlarms(AlarmManager r100) {
            return r100.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
    }

    public static boolean canScheduleExactAlarms(AlarmManager r100) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return true;
    L5:
        return Api31Impl.canScheduleExactAlarms(r100);
    }

    public static void setAlarmClock(AlarmManager r100, long r101, PendingIntent r102, PendingIntent r103) {
        Api21Impl.setAlarmClock(r100, Api21Impl.createAlarmClockInfo(r101, r102), r103);
    }

    public static void setAndAllowWhileIdle(AlarmManager r100, int r101, long r102, PendingIntent r103) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setAndAllowWhileIdle(r100, r101, r102, r103);
        return;
    L5:
        r100.set(r101, r102, r103);
    }

    @ReplaceWith(expression = "alarmManager.setExact(type, triggerAtMillis, operation)")
    public static void setExact(AlarmManager r100, int r101, long r102, PendingIntent r103) {
        r100.setExact(r101, r102, r103);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager r100, int r101, long r102, PendingIntent r103) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setExactAndAllowWhileIdle(r100, r101, r102, r103);
        return;
    L5:
        setExact(r100, r101, r102, r103);
    }
}
