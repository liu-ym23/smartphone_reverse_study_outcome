package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* JADX INFO: loaded from: classes17.dex */
class Alarms {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("Alarms");
    }

    private Alarms() {
    }

    public static void cancelAlarm(Context r100, WorkManagerImpl r101, String r102) {
        SystemIdInfoDao r103 = r101.getWorkDatabase().systemIdInfoDao();
        SystemIdInfo r104 = r103.getSystemIdInfo(r102);
        if (r104 == null) goto L6;
        cancelExactAlarm(r100, r102, r104.systemId);
        Logger.get().debug(TAG, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{r102}), new Throwable[0]);
        r103.removeSystemIdInfo(r102);
        return;
    }

    private static void cancelExactAlarm(Context r100, String r101, int r102) {
        AlarmManager r103 = (AlarmManager) r100.getSystemService("alarm");
        Intent r104 = CommandHandler.createDelayMetIntent(r100, r101);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r105 = 603979776;
    L6:
        PendingIntent r106 = PendingIntent.getService(r100, r102, r104, r105);
        if (r106 == null) goto L11;
        if (r103 == null) goto L12;
        Logger.get().debug(TAG, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{r101, Integer.valueOf(r102)}), new Throwable[0]);
        r103.cancel(r106);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r105 = 536870912;
        goto L6
    }

    public static void setAlarm(Context r100, WorkManagerImpl r101, String r102, long r103) {
        WorkDatabase r104 = r101.getWorkDatabase();
        SystemIdInfoDao r105 = r104.systemIdInfoDao();
        SystemIdInfo r106 = r105.getSystemIdInfo(r102);
        if (r106 == null) goto L5;
        cancelExactAlarm(r100, r102, r106.systemId);
        setExactAlarm(r100, r102, r106.systemId, r103);
        return;
    L5:
        int r107 = new IdGenerator(r104).nextAlarmManagerId();
        r105.insertSystemIdInfo(new SystemIdInfo(r102, r107));
        setExactAlarm(r100, r102, r107, r103);
    }

    private static void setExactAlarm(Context r100, String r101, int r102, long r103) {
        AlarmManager r104 = (AlarmManager) r100.getSystemService("alarm");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r105 = 201326592;
    L6:
        PendingIntent r106 = PendingIntent.getService(r100, r102, CommandHandler.createDelayMetIntent(r100, r101), r105);
        if (r104 == null) goto L10;
        r104.setExact(0, r103, r106);
        return;
    L10:
        return;
    L5:
        r105 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L6
    }
}
